package com.example.studentcompanionapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ToDoList extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    EditText etTask;
    Button btnAddTask;
    ListView lvTaskList;

    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar2);

        etTask = findViewById(R.id.etTask);
        btnAddTask = findViewById(R.id.btnAddTask);
        lvTaskList = findViewById(R.id.lvTaskList);

        items = Filehelper.readData(this);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        lvTaskList.setAdapter(adapter);

        btnAddTask.setOnClickListener(this);
        lvTaskList.setOnItemClickListener(this);

    }
    @Override
    public void onClick(View v) {
     switch(v.getId()){
         case R.id.btnAddTask:
             String task = etTask.getText().toString();
             adapter.add(task);
             etTask.setText(" ");
             Filehelper.writeData(items,this);
             Toast.makeText(this, "Task Added Successfully", Toast.LENGTH_SHORT).show();
             break;

     }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        items.remove(position);
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Deleted !", Toast.LENGTH_SHORT).show();

    }
}
