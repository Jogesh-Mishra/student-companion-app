package com.example.studentcompanionapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class Id extends AppCompatActivity {

    ImageView ivId,ivnewId;
    Button btnAddImg, btnChange,btnChoose;
    EditText etNewName;

    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;

    Uri mImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar2);

        ivId = findViewById(R.id.ivId);
        ivnewId = findViewById(R.id.ivnewId);
        btnAddImg = findViewById(R.id.btnAddImg);
        btnChange = findViewById(R.id.btnChange);
        etNewName = findViewById(R.id.etNewName);
        btnChoose = findViewById(R.id.btnChoose);

        ivId.setImageResource(R.drawable.id_layout);

        ivnewId.setVisibility(View.GONE);
        etNewName.setVisibility(View.GONE);
        btnAddImg.setVisibility(View.GONE);
        btnChoose.setVisibility(View.GONE);

        mStorageRef = FirebaseStorage.getInstance().getReference("ID");

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("ID");

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivnewId.setVisibility(View.VISIBLE);
                etNewName.setVisibility(View.VISIBLE);
                btnAddImg.setVisibility(View.VISIBLE);
                btnChoose.setVisibility(View.VISIBLE);
            }
        });
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });
        btnAddImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadFile();
                StorageReference strRef = FirebaseStorage.getInstance().getReference();

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
            Picasso.get().load(mImageUri).into(ivnewId);
        }
    }
    public void uploadFile(){
        if(mImageUri !=null){
            StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()+"."+getFileExtension(mImageUri));
            fileReference.putFile(mImageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(Id.this, "Upload Successfull", Toast.LENGTH_SHORT).show();
                            ivnewId.setVisibility(View.GONE);
                            etNewName.setVisibility(View.GONE);
                            btnAddImg.setVisibility(View.GONE);
                            btnChoose.setVisibility(View.GONE);
                            Documents document = new Documents(etNewName.getText().toString().trim(),taskSnapshot.getMetadata().getReference().getDownloadUrl().toString());
                            String doc_id = mDatabaseRef.push().getKey();
                            mStorageRef = FirebaseStorage.getInstance().getReference().child(mImageUri.getPath());
                            Glide.with(getApplicationContext()).load(mStorageRef).into(ivId);
                            mDatabaseRef.child(doc_id).setValue(document);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Id.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(Id.this, "In Progress ! ", Toast.LENGTH_SHORT).show();
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
