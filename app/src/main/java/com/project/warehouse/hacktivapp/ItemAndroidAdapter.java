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

class ItemAndroidAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int TYPE_LEFT = 100;
    private static final int TYPE_RIGHT = 200;

    private List<AndroidVersion> items = new ArrayList<>();
    private VersionClickListener listener;

    public void setItems(List<AndroidVersion> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void setListener(VersionClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutId = 0;
        if (viewType == TYPE_LEFT) {
            layoutId = R.layout.item_android_version;
            View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);

            return new ItemAndroidVersionViewHolder(view);
        } else {
            layoutId = R.layout.item_android_version_reversed;
            View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);

            return new ItemAndroidVersionReversedViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemAndroidVersionViewHolder) {
            ((ItemAndroidVersionViewHolder)holder).onBind(items.get(position), listener);
        } else if (holder instanceof ItemAndroidVersionReversedViewHolder) {
            ((ItemAndroidVersionReversedViewHolder)holder).onBind(items.get(position), listener);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position % 2 == 0) {
            return TYPE_LEFT;
        } else {
            return TYPE_RIGHT;
        }
    }
}
