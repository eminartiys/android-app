package com.project.warehouse.hacktivapp.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.warehouse.hacktivapp.R;
import com.project.warehouse.hacktivapp.model.Film;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by eminartiys on 10/03/22.
 */

class FilmAdapter extends RecyclerView.Adapter<FilmViewHolder>{

    private List<Film> items = new ArrayList<>();

    public void setItems(List<Film> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutId = R.layout.view_film_list_item;
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);

        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        holder.onBind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
