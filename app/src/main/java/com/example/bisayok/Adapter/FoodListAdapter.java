package com.example.bisayok.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.bisayok.Activity.DetailActivity;
import com.example.bisayok.Domain.FoodDomain;
import com.example.bisayok.R;

import java.util.ArrayList;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.ViewHolder> {
ArrayList<FoodDomain> items;
Context context;

    public FoodListAdapter(ArrayList<FoodDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_food_list, parent, false);
        context=parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.titleTxt.setText(items.get(position).getTittle());
holder.timeTxt.setText(items.get(position).getTime() + "min");
holder.scoreTxt.setText(""+items.get(position).getScore());
int drawableResourceid=holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl(),"draweble",holder.itemView.getContext().getPackageName());


Glide.with(holder.itemView.getContext())
        .load(drawableResourceid)
        .transform(new GranularRoundedCorners(30, 30,0,0))
        .into(holder.pic);

holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(holder.itemView.getContext(), DetailActivity.class);
        intent.putExtra("object", items.get(position));
        holder.itemView.getContext().startActivity(intent);
    }
});
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
TextView titleTxt, timeTxt, scoreTxt;
ImageView pic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        titleTxt=itemView.findViewById(R.id.titleTxt);
        timeTxt=itemView.findViewById(R.id.timeTxt);
        scoreTxt=itemView.findViewById(R.id.scoreTxt);
        pic=itemView.findViewById(R.id.pic);


        }

    }
}
