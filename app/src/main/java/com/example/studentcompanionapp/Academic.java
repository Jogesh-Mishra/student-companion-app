package com.example.studentcompanionapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Academic extends AppCompatActivity {


    Button btnContact, btnNoticeBoard, btnAcademic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar2);


        btnAcademic = findViewById(R.id.btnAcademic);
        btnContact = findViewById(R.id.btnContact);
        btnNoticeBoard = findViewById(R.id.btnNoticeBoard);


        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Academic.this,ContactUs.class);
                startActivity(intent);
            }
        });

        btnNoticeBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "https://www.facebook.com/n/?groups/cetinformation";
                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse(uri));
                startActivity(web);

            }
        });

        btnAcademic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Academic.this, academicFinal.class);
                startActivity(intent);
            }
        });

    }
}
