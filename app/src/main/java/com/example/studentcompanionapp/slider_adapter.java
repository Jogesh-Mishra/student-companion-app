package com.example.studentcompanionapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class slider_adapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public slider_adapter(Context context){
        this.context = context;
    }

    public String[] slider_headings ={"WELCOME !", "WHAT IT CONTAINS :"};

    public String[] slider_descriptions ={"This Application is for the students of this Organization to help them in their day" +
            "to day life as a student as well as keep them notified about the various societies of the institutions.\n\n" +
            " This also provides a platform, in integration with Firebase, to store data and retrive them with a single click, may it be Backpaper" +
            " or Important Documents or even your ID Card !"
            ,"CALCULATOR : To limit the use of human brain in calculations so that we can save time to code !\n\n" +
            "CAMERA : To click pictures of the Notes,Documents and Assignments, and sometimes of your own group of Avengers\n\n" +
            "TIME TABLE : To help you know what you need to do next as a student\n\n" +
            "ACADEMIC : The whole Academic section in a single click !\n\n" +
            "TO DO : To help you to keep a track of what task you need to do next \n\n" +
            "FINE : We know you are very studious and often forget about the consequences of not returning the issued book on time , so here" +
            " we are to help you with the fine you need to pay !\n\n" +
            "ID CARD : The entry pass to the roller-coaster life you have in this institution needs to be kept safe !\n\n" +
            "GITHUB : For those who know, they know what to do with this button !\n\n" +
            "SPORTS : Keep a track of what is the state of Sports in your Institution\n\n" +
            "TECHNICAL : No this button won't Transform you into IronMan, So you better click on this to know about the technical clubs in your " +
            "institution and start making an Iron suit for yourself. The Nation needs you !\n\n" +
            "CULTURAL : For those who want to know what Entertainment in their Institution is !\n\n" +
            "NEWS : It's time to know about what's happening in the world and taking a break from knowing your own and your friend's problems !\n\n" +
            "ORDER FOOD : This is so easy for you to guess. We like to make you realize that you are a human, not a machine !\n\n" +
            "ASSIGNMENT : Keep a record of the date and assignment you need to submit. This is more safe than what you scribble at the back of your notebook ," +
            " atleast we will notify you when you have to complete it !\n\n"};


    @Override
    public int getCount() {
        return slider_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.slide_layout,container,false);

        TextView heading = v.findViewById(R.id.heading);
        TextView desc = v.findViewById(R.id.descriptions);

        desc.setText(slider_descriptions[position]);
        heading.setText(slider_headings[position]);

        container.addView(v);

        return v;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((RelativeLayout)object);
    }
}
