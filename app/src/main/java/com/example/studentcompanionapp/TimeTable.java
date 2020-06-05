package com.example.studentcompanionapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class TimeTable extends AppCompatActivity {

    ImageView ivTable, ivnewTimeTable ;
    Button btnNew, btnAddTimeTable;

    Uri mImageUri;

    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar2);

        ivnewTimeTable = findViewById(R.id.ivnewTimeTable);
        ivTable = findViewById(R.id.IvTable);
        btnNew = findViewById(R.id.btnNew);
        btnAddTimeTable = findViewById(R.id.btnAddTimeTable);

        ivnewTimeTable.setVisibility(View.GONE);
        btnAddTimeTable.setVisibility(View.GONE);

        ivTable.setImageResource(R.drawable.timetable);

        mStorageRef = FirebaseStorage.getInstance().getReference("Time_Table");

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Time_Table");

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivnewTimeTable.setVisibility(View.VISIBLE);
                btnAddTimeTable.setVisibility(View.VISIBLE);
                openFileChooser();
            }
        });

        btnAddTimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadFile();
            }
        });

    }
    public  void openFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            mImageUri = data.getData();
            Picasso.get().load(mImageUri).into(ivnewTimeTable);
        }
    }
    public void uploadFile(){
        if(mImageUri !=null){
            final StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()+"."+getFileExtension(mImageUri));
            fileReference.putFile(mImageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(TimeTable.this, "Upload Successfull", Toast.LENGTH_SHORT).show();
                            ivnewTimeTable.setVisibility(View.GONE);
                            btnAddTimeTable.setVisibility(View.GONE);

                            Time_Table tt = new Time_Table(taskSnapshot.getMetadata().getReference().getDownloadUrl().toString());
                            tt.setImageurl(taskSnapshot.getMetadata().getReference().getDownloadUrl().toString());
                            String doc_id = mDatabaseRef.push().getKey();
                            Glide.with(getApplicationContext()).load(fileReference.getDownloadUrl()).into(ivTable);
                            mDatabaseRef.child(doc_id).setValue(tt);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(TimeTable.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(TimeTable.this, "In Progress ! ", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
        else{
            Toast.makeText(this, "No File Selected", Toast.LENGTH_SHORT).show();
        }
    }
    public  String getFileExtension(Uri uri){
        ContentResolver cr = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(uri));
    }
}
