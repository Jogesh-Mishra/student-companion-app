package com.example.studentcompanionapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Assignment extends AppCompatActivity {

    private static final String TAG = Assignment.class.getSimpleName();

    Button btnAddNotifier;
    EditText etDate, etHour, etMinute, etTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        startService(new Intent(this,YourService.class));

        btnAddNotifier = findViewById(R.id.btnAddNotifier);
        etDate = findViewById(R.id.etDate);
        etHour = findViewById(R.id.etHour);
        etMinute = findViewById(R.id.etMinute);
        etTask = findViewById(R.id.etTask);

        btnAddNotifier.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                setAlarm();
                Toast.makeText(Assignment.this, "Notifier has been Set !", Toast.LENGTH_SHORT).show();
               // Assignment.this.finish();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setAlarm(){
        Log.d(TAG,"Alarm Enabled ! ");

        String task = etTask.getText().toString();

        Intent intent = new Intent(Assignment.this,AlarmReciever.class);

        intent.putExtra("Task",task);

        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,intent,0);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        String date = etDate.getText().toString().trim();
        String[] datelist = date.split("-");

        String year = datelist[0];
        String month = datelist[1];
        String day = datelist[2];

        calendar.set(Calendar.YEAR, Integer.parseInt(year));
        calendar.set(Calendar.MONTH, Integer.parseInt(month)-1);
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));

        String hour = etHour.getText().toString().trim();
        String minute = etMinute.getText().toString().trim();

        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
        calendar.set(Calendar.MINUTE, Integer.parseInt(minute)-1);

        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY,pendingIntent);

        setBootReceiverEnabled(PackageManager.COMPONENT_ENABLED_STATE_ENABLED);
    }

    private  void setBootReceiverEnabled(int componentEnabledState) {
        ComponentName componentName = new ComponentName(this, AlarmReciever.class);
        PackageManager packageManager = getPackageManager();
        packageManager.setComponentEnabledSetting(componentName, componentEnabledState, PackageManager.DONT_KILL_APP);
    }
}
