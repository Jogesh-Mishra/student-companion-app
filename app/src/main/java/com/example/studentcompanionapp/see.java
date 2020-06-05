package com.example.studentcompanionapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class see extends AppCompatActivity {

    ListView lvList;
    FirebaseDatabase database;
    DatabaseReference ref ;

    ArrayList<Add_Back> list ;

    Add_Back see;

    adapter adap ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar2);

        see = new Add_Back();

        lvList = findViewById(R.id.lvList);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference().child("Add_Back");

        list = new ArrayList<>();
        adap = new adapter(this,list);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){

                    see = ds.getValue(Add_Back.class);
                    list.add(see);
                }
                lvList.setAdapter(adap);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(see.this, "Error :"+databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
