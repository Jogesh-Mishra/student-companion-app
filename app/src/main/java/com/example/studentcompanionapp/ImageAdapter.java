package com.example.studentcompanionapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.Viewholder> {
    Context context;
    List<Documents> image_list;

    public ImageAdapter(Context context, List<Documents> image) {
        this.context = context;
        this.image_list = image;
    }

    @NonNull
    @Override
    public ImageAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item,parent,false);
        Viewholder viewholder = new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.Viewholder holder, int position) {
        Documents doc = image_list.get(position);
        //holder.tvName.setText(doc.getName());
        //Glide.with(context.getApplicationContext()).load(doc.getmImageUrl()).into(holder.ivUpload);
    }

    @Override
    public int getItemCount() {
        return image_list.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public ImageView ivUpload;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            tvName =itemView.findViewById(R.id.tvName);
            ivUpload=itemView.findViewById(R.id.ivUpload);
            ivUpload.setImageResource(R.drawable.receipt);
            tvName.setText("Receipt");
        }
    }
}
