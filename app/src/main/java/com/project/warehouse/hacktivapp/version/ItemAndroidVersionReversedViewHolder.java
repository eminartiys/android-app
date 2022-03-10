package com.project.warehouse.hacktivapp.version;

import android.view.View;

import com.project.warehouse.hacktivapp.R;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by eminartiys on 14/02/22.
 */

class ItemAndroidVersionReversedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    AppCompatImageView imageAndroidVersion;
    VersionClickListener listener;
    AndroidVersion androidVersion;

    public ItemAndroidVersionReversedViewHolder(@NonNull View itemView) {
        super(itemView);

        imageAndroidVersion = itemView.findViewById(R.id.image_android_version_reversed);
    }

    public void onBind(AndroidVersion version, VersionClickListener listener) {
        this.androidVersion = version;
        this.listener = listener;
        Picasso.get()
                .load(version.getImage())
                .into(imageAndroidVersion);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        listener.openDetail(androidVersion);
    }
}
