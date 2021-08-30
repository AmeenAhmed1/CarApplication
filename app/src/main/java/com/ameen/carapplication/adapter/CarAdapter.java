package com.ameen.carapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ameen.carapplication.data.CarModule;
import com.ameen.carapplication.databinding.ItemCarBinding;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by (Ameen Essa) on 8/30/2021
 * Copyright (c) 2021 . All rights reserved.
 *
 * @Ameen.MobileDev@gmail.com
 */
public class CarAdapter extends RecyclerView.Adapter<CarAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<CarModule> carsList;

    public CarAdapter(Context context, ArrayList<CarModule> carList) {
        this.context = context;
        this.carsList = carList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(ItemCarBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        CarModule carModule = carsList.get(position);

        holder.carBinding.carBrandTextView.setText(carModule.getBrand());
        holder.carBinding.isUsedTextView.setText(carModule.isUsed() ? "New" : "Used");
        holder.carBinding.constructionYearTextView.setText(carModule.getConstractionYear());

        Glide.with(context)
                .load(carModule.getImageUrl())
                .centerCrop()
                .into(holder.carBinding.carImageView);
    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ItemCarBinding carBinding;

        public MyViewHolder(ItemCarBinding carBinding) {
            super(carBinding.getRoot());
            this.carBinding = carBinding;
        }
    }

    public void updateList(ArrayList<CarModule> carList) {
        carsList.clear();
        carsList.addAll(carList);
        notifyDataSetChanged();
    }
}

