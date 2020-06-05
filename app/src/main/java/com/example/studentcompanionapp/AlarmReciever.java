package com.example.studentcompanionapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class AlarmReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Time Has Come !", Toast.LENGTH_LONG).show();
        String task = intent.getStringExtra("Task");
        Toast.makeText(context, "Task :"+task, Toast.LENGTH_SHORT).show();
        Intent mintent = new Intent(context,MainActivity.class);
        context.startActivity(mintent);
    }
}
