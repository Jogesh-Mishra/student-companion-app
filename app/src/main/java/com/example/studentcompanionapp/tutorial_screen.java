package com.example.studentcompanionapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class tutorial_screen extends AppCompatActivity {

    ViewPager slideViewPager;
    LinearLayout dots;
    Button prevBtn, nextBtn;

    slider_adapter adapter;

    private int nCurrentPage=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_screen);

        getSupportActionBar().hide();

        slideViewPager = findViewById(R.id.slideViewPager);
        dots = findViewById(R.id.dots);
        prevBtn = findViewById(R.id.prevBtn);
        nextBtn = findViewById(R.id.nextBtn);

        prevBtn.setVisibility(View.GONE);

        adapter = new slider_adapter(this);

        slideViewPager.setAdapter(adapter);


        slideViewPager.addOnPageChangeListener(viewListener);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nCurrentPage==0){
                slideViewPager.setCurrentItem(nCurrentPage+1);}
                else{
                    Intent intent = new Intent(tutorial_screen.this,MainActivity.class);
                    startActivity(intent);
                    tutorial_screen.this.finish();
                }
            }
        });
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideViewPager.setCurrentItem(nCurrentPage-1);
            }
        });
    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            nCurrentPage = position;

            if(position==0){
                nextBtn.setEnabled(true);
                prevBtn.setEnabled(false);
                prevBtn.setVisibility(View.INVISIBLE);

                nextBtn.setText("Next");
                prevBtn.setText(" ");

            }
            else{
                nextBtn.setEnabled(true);
                prevBtn.setEnabled(true);
                prevBtn.setVisibility(View.VISIBLE);

                nextBtn.setText("Finish");
                prevBtn.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
