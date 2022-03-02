package com.project.warehouse.hacktivapp.source.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.warehouse.hacktivapp.R;
import com.project.warehouse.hacktivapp.model.Source;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by eminartiys on 02/03/22.
 */

public class SourceAdapter extends RecyclerView.Adapter<SourceViewHolder>{

    private List<Source> items = new ArrayList<>();

    public void setItems(List<Source> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SourceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutId = R.layout.item_source;
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);

        return new SourceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SourceViewHolder holder, int position) {
        holder.onBind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
