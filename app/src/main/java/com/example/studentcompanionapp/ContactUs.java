package com.example.studentcompanionapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContactUs extends AppCompatActivity {

    TextView tvShow;
    Button btnCall, btnMail, btnWeb, btnLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar2);

        tvShow = findViewById(R.id.tvShow);
        btnCall = findViewById(R.id.btnCall);
        btnMail = findViewById(R.id.btnMail);
        btnWeb = findViewById(R.id.btnWeb);
        btnLoc = findViewById(R.id.btnLoc);

        tvShow.setText("College of Engineering & Technology\n" +
                "Ghatikia, Kalinga Nagar"+"\n"+"Bhubaneswar- 751003 Odisha, India"+
                "\n"+"\n"+"Phone: +91 674 2386075"+"\n"+"Fax: + 91 674 2386182"+
                "Email: info@cet.edu.in"+"\n"+"Website: www.cet.edu.in");

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "tel:"+"+916742386075";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(uri));
                startActivity(intent);
            }
        });
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "https://"+"www.cet.edu.in";
                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse(uri));
                startActivity(web);
            }
        });
        btnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to ="info@cet.edu.in";
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,"Choose a Client"));
            }
        });

        btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = "College of Engineering & Technology,Ghatikia, Kalinga Nagar,Bhubaneswar- 751003 Odisha, India";
                Uri mapUri = Uri.parse("geo:0,0?q=" + Uri.encode(address));
                Intent intent = new Intent(Intent.ACTION_VIEW, mapUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
    }
}
