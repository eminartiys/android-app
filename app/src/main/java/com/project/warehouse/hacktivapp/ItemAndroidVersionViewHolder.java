package com.project.warehouse.hacktivapp;

import android.view.View;

import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by eminartiys on 14/02/22.
 */

class ItemAndroidVersionViewHolder extends RecyclerView.ViewHolder {

    AppCompatImageView imageAndroidVersion;
    AppCompatTextView titleAndroidVersion;

    public ItemAndroidVersionViewHolder(@NonNull View itemView) {
        super(itemView);

        imageAndroidVersion = itemView.findViewById(R.id.image_android_version);
        titleAndroidVersion = itemView.findViewById(R.id.title_android_version);
    }

    public void onBind(AndroidVersion version) {
        Picasso.get()
                .load(version.getImage())
                .into(imageAndroidVersion);
        titleAndroidVersion.setText(version.getName());
    }
}
