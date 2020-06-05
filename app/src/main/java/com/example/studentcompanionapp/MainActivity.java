package com.example.studentcompanionapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String CALCULATOR_PACKAGE ="com.android.calculator2";
    public static final String CALCULATOR_CLASS ="com.android.calculator2.Calculator";
    //public static final String CALCULATOR_PACKAGE ="com.sec.android.app.popupcalculator";
    //public static final String CALCULATOR_CLASS ="com.sec.android.app.popupcalculator.Calculator";


    Button btnCalculator, btnRecorder, btnTimeTable, btnSyllabus, btnAcademic,btnToDo, btnGithub, btnId, btnFine
            ,btnCultural, btnSports, btnTech,btnNews,btnFood, btnAssignment, btnLogout;

    private static int SPLASH_TIME_OUT = 4000 ;

    public static final int CAMERA_REQUEST=9999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        btnCalculator = findViewById(R.id.btnCalculator);
        btnRecorder = findViewById(R.id.btnRecorder);
        btnTimeTable = findViewById(R.id.btnTimeTable);
        btnSyllabus = findViewById(R.id.btnSyllabus);
        btnAcademic = findViewById(R.id.btnAcademic);
        btnToDo = findViewById(R.id.btnToDo);
        btnGithub = findViewById(R.id.btnGithub);
        btnId = findViewById(R.id.btnId);
        btnFine = findViewById(R.id.btnFine);
        btnCultural = findViewById(R.id.btnCultural);
        btnSports = findViewById(R.id.btnSports);
        btnTech = findViewById(R.id.btnTech);
        btnNews = findViewById(R.id.btnNews);
        btnFood = findViewById(R.id.btnFood);
        btnAssignment = findViewById(R.id.btnAssignment);
        btnLogout = findViewById(R.id.btnLogout);


        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                intent.setComponent(new ComponentName(CALCULATOR_PACKAGE, CALCULATOR_CLASS));
                MainActivity.this.startActivity(intent);

            }
        });
        btnRecorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenCamera(v);
            }
        });

        btnTimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TimeTable.class);
                startActivity(intent);
            }
        });


        btnSyllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Syllabus.class);
                startActivity(intent);
            }
        });

        btnAcademic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Academic.class);
                startActivity(intent);
            }
        });

        btnToDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ToDoList.class);
                startActivity(intent);
            }
        });

        btnFine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fine_Calculator(v);
            }
        });

        btnId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Id.class);
                startActivity(intent);
            }
        });

        btnGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "https://"+"www.github.com";
                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse(uri));
                startActivity(web);
            }
        });

        btnSports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSports(v);
            }
        });
        btnTech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTech(v);
            }
        });
        btnCultural.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCultural(v);
            }
        });

        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "https://inshorts.com/en/read";
                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse(uri));
                startActivity(web);
            }
        });

        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "tel:"+"+91**********";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(uri));
                startActivity(intent);
            }
        });

        btnAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Assignment.class);
                startActivity(intent);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout(v);
            }
        });

    }

    public void OpenCamera(View view){
         Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
         startActivityForResult(intent,CAMERA_REQUEST);
    }

    public void btnSports(View view){
        final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.sports_dialog,null);

        Button btnCricket = mView.findViewById(R.id.btnCricket);
        Button btnFootball = mView.findViewById(R.id.btnFootball);
        Button btnBasketball = mView.findViewById(R.id.btnBasketBall);
        Button btnCancel = mView.findViewById(R.id.btnCancel);

        alert.setView(mView);

        final AlertDialog alertDialog = alert.create();

        alertDialog.setCanceledOnTouchOutside(false);

        btnBasketball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "http://instagram.com/_u/cetbball";
                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse(uri));
                startActivity(web);
            }
        });
        btnCricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri ="http://instagram.com/_u/engineerscup.cetb";
                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse(uri));
                startActivity(web);
            }
        });
        btnFootball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "http://instagram.com/_u/cet_football_club";
                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse(uri));
                startActivity(web);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

    public void btnTech(View view){
        final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.tech_dialog,null);

        Button btnZairza = mView.findViewById(R.id.btnZairza);
        Button btnEC = mView.findViewById(R.id.btnEC);
        Button btnSpectrum = mView.findViewById(R.id.btnSpectrum);
        Button btnCancel = mView.findViewById(R.id.btnCancel);

        alert.setView(mView);

        final AlertDialog alertDialog = alert.create();

        alertDialog.setCanceledOnTouchOutside(false);

        btnZairza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "https://zairza.in/";
                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse(uri));
                startActivity(web);
            }
        });
        btnEC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri ="http://instagram.com/_u/energy_club_cetb";
                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse(uri));
                startActivity(web);
            }
        });
        btnSpectrum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "https://www.spectrumcet.com/";
                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse(uri));
                startActivity(web);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

    public void btnCultural(View view){
        final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.cultural_dialog,null);

        Button btnDance = mView.findViewById(R.id.btnDance);
        Button btnMusic = mView.findViewById(R.id.btnMusic);
        Button btnDrama = mView.findViewById(R.id.btnDrama);
        Button btnCancel = mView.findViewById(R.id.btnCancel);

        alert.setView(mView);

        final AlertDialog alertDialog = alert.create();

        alertDialog.setCanceledOnTouchOutside(false);

        btnDance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "http://instagram.com/_u/soul_raisers_dance_authority";
                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse(uri));
                startActivity(web);
            }
        });
        btnDrama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri ="http://instagram.com/_u/we_amuza";
                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse(uri));
                startActivity(web);
            }
        });
        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "http://instagram.com/_u/arpeggioofficial.cetb";
                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse(uri));
                startActivity(web);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

    public void Fine_Calculator(View view){
        final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.fine,null);

        final EditText etPrice = mView.findViewById(R.id.etPrice);
        final EditText  etDays =  mView.findViewById(R.id.etDays);
        final TextView tvResult =  mView.findViewById(R.id.tvResult);
        final TextView tvShowResult =  mView.findViewById(R.id.tvShowResult);
        final Button  btnCancel =  mView.findViewById(R.id.btnCancel);
        final Button  btnCalculate =  mView.findViewById(R.id.btnCalculate);
        tvResult.setVisibility(View.GONE);
        tvShowResult.setVisibility(View.GONE);

        alert.setView(mView);

        final AlertDialog alertDialog = alert.create();

        alertDialog.setCanceledOnTouchOutside(false);

       btnCalculate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(etDays.getText().toString().isEmpty()||etPrice.getText().toString().isEmpty()){
                   Toast.makeText(MainActivity.this, "Please Enter all Fields ", Toast.LENGTH_SHORT).show();
               }
               else{
                   Double Price = Double.parseDouble(etPrice.getText().toString().trim());
                   Double Days = Double.parseDouble(etDays.getText().toString().trim());

                   tvResult.setVisibility(View.VISIBLE);
                   tvShowResult.setVisibility(View.VISIBLE);

                   if (Days <= 7){
                       tvResult.setText("Re. 1");
                   }
                   else if (Days > 7 && Days <= 30){
                       Double fine = Price + (Price * 0.2);
                       tvResult.setText("Rs. "+fine);
                   }
                   else{
                       Double fine = Price + (Price * 10);
                       tvResult.setText("Rs. "+fine);
                   }
               }
           }
       });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

    public void logout(View view){
        final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.logout,null);

        final Button  btnCancel =  mView.findViewById(R.id.btnCancel);
        final Button  btnYes =  mView.findViewById(R.id.btnYes);

        alert.setView(mView);

        final AlertDialog alertDialog = alert.create();

        alertDialog.setCanceledOnTouchOutside(false);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();

                Intent intent = new Intent(MainActivity.this,Log_in.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "User Successfullly Logged Out", Toast.LENGTH_SHORT).show();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

}
