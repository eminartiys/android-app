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

class ItemAndroidVersionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    AppCompatImageView imageAndroidVersion;
    AppCompatTextView titleAndroidVersion;
    VersionClickListener listener;
    AndroidVersion androidVersion;

    public ItemAndroidVersionViewHolder(@NonNull View itemView) {
        super(itemView);

        imageAndroidVersion = itemView.findViewById(R.id.image_android_version);
        titleAndroidVersion = itemView.findViewById(R.id.title_android_version);
    }

    public void onBind(AndroidVersion version, VersionClickListener listener) {
        androidVersion = version;
        this.listener = listener;
        Picasso.get()
                .load(version.getImage())
                .into(imageAndroidVersion);
        titleAndroidVersion.setText(version.getName());
        imageAndroidVersion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        listener.openDetail(androidVersion);
    }
}
