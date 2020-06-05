package com.example.studentcompanionapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class biodata extends AppCompatActivity {

    ImageView ivImage;
    EditText etImgName;
    Button btnChoose, btnUpload, btnShowUpload;
    ProgressBar progressBar;

    Uri mImageUri;

    StorageReference mStorageRef;
    DatabaseReference mDatabaseRef;


    private static final int PICK_IMAGE_REQUEST =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar2);

        ivImage = findViewById(R.id.ivImage);
        etImgName = findViewById(R.id.etImgName);
        btnChoose = findViewById(R.id.btnChoose);
        btnUpload = findViewById(R.id.btnUpload);
        btnShowUpload = findViewById(R.id.btnShowUpload);
        progressBar = findViewById(R.id.progressBar);

        btnUpload.setVisibility(View.GONE);
        etImgName.setVisibility(View.GONE);

        progressBar.setVisibility(View.GONE);

        mStorageRef = FirebaseStorage.getInstance().getReference("Documents");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Documents");

        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
                btnUpload.setVisibility(View.VISIBLE);
                etImgName.setVisibility(View.VISIBLE);
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                uploadFile();
                btnUpload.setVisibility(View.GONE);
                etImgName.setVisibility(View.GONE);
            }
        });

        btnShowUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(biodata.this,show_idcard.class);
                startActivity(intent);
            }
        });

    }
    public  String getFileExtension(Uri uri){
        ContentResolver cr = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(uri));
    }

    public void uploadFile(){
        if(mImageUri !=null){
            StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()+"."+getFileExtension(mImageUri));
            fileReference.putFile(mImageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress(0);
                                    progressBar.setVisibility(View.GONE);

                                }
                            },5000);
                            Toast.makeText(biodata.this, "Upload Successfull", Toast.LENGTH_SHORT).show();
                            Documents document = new Documents(etImgName.getText().toString().trim(),taskSnapshot.getMetadata().getReference().getDownloadUrl().toString());
                            String doc_id = mDatabaseRef.push().getKey();
                            mDatabaseRef.child(doc_id).setValue(document);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(biodata.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress =(100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                           progressBar.setProgress((int)progress);
                            Toast.makeText(biodata.this, "In Progress ! ", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
        else{
            Toast.makeText(this, "No File Selected", Toast.LENGTH_SHORT).show();
        }
    }

    public  void openFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            mImageUri = data.getData();
            Picasso.get().load(mImageUri).into(ivImage);
        }
    }
}
