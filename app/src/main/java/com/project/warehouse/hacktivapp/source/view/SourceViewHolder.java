package com.project.warehouse.hacktivapp.source.view;

import android.view.View;

import com.project.warehouse.hacktivapp.R;
import com.project.warehouse.hacktivapp.model.Source;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by eminartiys on 02/03/22.
 */

public class SourceViewHolder extends RecyclerView.ViewHolder {

    AppCompatTextView uiViewSourceName;
    AppCompatTextView uiViewSourceDescription;

    public SourceViewHolder(@NonNull View itemView) {
        super(itemView);

        uiViewSourceName = itemView.findViewById(R.id.ui_view_source_name);
        uiViewSourceDescription = itemView.findViewById(R.id.ui_view_source_description);
    }

    public void onBind(Source source) {
        uiViewSourceName.setText(source.getName());
        uiViewSourceDescription.setText(source.getDescription());
    }
}