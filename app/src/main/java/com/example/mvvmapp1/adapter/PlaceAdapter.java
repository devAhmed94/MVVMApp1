package com.example.mvvmapp1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvmapp1.R;
import com.example.mvvmapp1.model.Places;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {

    List<Places> placesArrayList;
    Context context;

    public PlaceAdapter(Context context, List<Places> placesArrayList) {
        this.context = context;
        this.placesArrayList =placesArrayList;
    }


    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_view, parent, false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {

        holder.textView.setText(placesArrayList.get(position).getTitle());
        Glide.with(context).load(placesArrayList.get(position).getImageUrl()).into(holder.circleImageView);

    }

    @Override
    public int getItemCount() {
        return placesArrayList.size();
    }

    class PlaceViewHolder extends RecyclerView.ViewHolder {

        CircleImageView circleImageView;
        TextView textView;

        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.item_circle_image);
            textView = itemView.findViewById(R.id.item_name);

        }
    }
}
