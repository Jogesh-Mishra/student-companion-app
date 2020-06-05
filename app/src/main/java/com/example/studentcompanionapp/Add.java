package com.example.studentcompanionapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add extends AppCompatActivity {

    EditText etSem, etSub, etAttempt;
    Button btnSubmit;

    DatabaseReference database_add;
    Add_Back add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar2);

        btnSubmit = findViewById(R.id.btnSubmit);
        etSem = findViewById(R.id.etSem);
        etSub = findViewById(R.id.etSub);
        etAttempt = findViewById(R.id.etAttempt);
        add =new Add_Back();
        database_add = FirebaseDatabase.getInstance().getReference("Add_Back");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etSem.getText().toString().isEmpty()|| etAttempt.getText().toString().isEmpty()||etSub.getText().toString().isEmpty()){
                    Toast.makeText(Add.this, "Please Enter All The Fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    String Sem = etSem.getText().toString().trim();
                    String Subject = etSub.getText().toString().trim();
                    String Attempt = etAttempt.getText().toString().trim();

                    add.setSemester(Sem);
                    add.setSubject(Subject);
                    add.setAttempt(Attempt);


                    database_add.push().setValue(add);

                    Add.this.finish();

                    Toast.makeText(Add.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
