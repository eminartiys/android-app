package com.project.warehouse.hacktivapp.recipe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.warehouse.hacktivapp.R;
import com.project.warehouse.hacktivapp.model.Recipe;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by eminartiys on 24/03/22.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeItemViewHolder> {

    private List<Recipe> items = new ArrayList<>();

    public void setItems(List<Recipe> recipes) {
        items = recipes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecipeItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_recipe_item, parent, false);

        return new RecipeItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeItemViewHolder holder, int position) {
        holder.onBindRecipe(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
