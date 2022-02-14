package com.project.warehouse.hacktivapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by eminartiys on 14/02/22.
 */

class ItemAndroidAdapter extends RecyclerView.Adapter<ItemAndroidVersionViewHolder>{

    private List<AndroidVersion> items = new ArrayList<>();

    public void setItems(List<AndroidVersion> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemAndroidVersionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_android_version, parent, false);
        return new ItemAndroidVersionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAndroidVersionViewHolder holder, int position) {
        holder.onBind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
