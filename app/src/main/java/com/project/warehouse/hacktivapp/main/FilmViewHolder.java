package com.project.warehouse.hacktivapp.main;

import android.view.View;

import com.project.warehouse.hacktivapp.R;
import com.project.warehouse.hacktivapp.model.Film;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by eminartiys on 10/03/22.
 */

public class FilmViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    AppCompatTextView titleFilm;
    AppCompatImageView imageFilm;

    public FilmViewHolder(@NonNull View itemView) {
        super(itemView);

        imageFilm = itemView.findViewById(R.id.ui_view_film_image);
        titleFilm = itemView.findViewById(R.id.ui_view_film_title);
    }

    public void onBind(Film film) {
        titleFilm.setText(film.title);
        Picasso.get()
                .load(film.image)
                .into(imageFilm);
    }

    @Override
    public void onClick(View v) {
    }
}
