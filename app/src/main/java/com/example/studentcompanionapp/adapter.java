package com.example.studentcompanionapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class adapter extends ArrayAdapter<Add_Back> {

    private Context context;
    private List<Add_Back> val;

    public adapter(@NonNull Context context, List<Add_Back> values) {
        super(context, R.layout.row_layour,values);
        this.context = context;
        this.val = values;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView= inflater.inflate(R.layout.row_layour,parent,false);

        TextView tvSubject = convertView.findViewById(R.id.tvSubject);
        TextView tvSem = convertView.findViewById(R.id.tvSem);
        TextView tvAttempts = convertView.findViewById(R.id.tvAttempts);

        tvSubject.setText(val.get(position).getSubject());
        tvSem.setText(val.get(position).getSemester());
        tvAttempts.setText(val.get(position).getAttempt());

        return convertView;
    }
}
