package com.example.nottnewsonthetop;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
{
    private ArrayList<news>NewsList;
    Context context;
    public RecyclerAdapter(Context context,ArrayList<news>arr)
    {
        this.context = context;
        this.NewsList = arr;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.text_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(NewsList.get(position).title);

    }

    @Override
    public int getItemCount() {
        return NewsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    TextView textView;
    ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.titleTxtVw);
            img = itemView.findViewById(R.id.imgVw);
        }
    }
}