package com.example.studentcompanionapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class academicFinal extends AppCompatActivity {

    Button btnBackReg, btnDocuments, btnIntern, btnMaterial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_final);


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar2);

        btnBackReg = findViewById(R.id.btnBackReg);
        btnDocuments = findViewById(R.id.btnDocuments);
        btnIntern = findViewById(R.id.btnIntern);
        btnMaterial = findViewById(R.id.btnMaterial);

        btnBackReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(academicFinal.this,backPaper.class);
                startActivity(intent);
            }
        });

        btnIntern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "https://"+"www.internshala.com";
                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse(uri));
                startActivity(web);
            }
        });
        btnMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "https://"+"www.classroom.google.com";
                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse(uri));
                startActivity(web);
            }
        });
        btnDocuments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(academicFinal.this,biodata.class);
                startActivity(intent);
            }
        });
    }
}
