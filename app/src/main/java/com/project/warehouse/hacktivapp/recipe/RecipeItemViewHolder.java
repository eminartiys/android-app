package com.project.warehouse.hacktivapp.recipe;

import android.view.View;

import com.project.warehouse.hacktivapp.R;
import com.project.warehouse.hacktivapp.model.Recipe;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by eminartiys on 24/03/22.
 */

public class RecipeItemViewHolder extends RecyclerView.ViewHolder {

    AppCompatImageView recipeImage;
    AppCompatTextView recipeTitle;
    AppCompatTextView recipeDescription;

    public RecipeItemViewHolder(@NonNull View itemView) {
        super(itemView);

        recipeImage = itemView.findViewById(R.id.ui_view_recipe_image);
        recipeTitle = itemView.findViewById(R.id.ui_view_recipe_title);
        recipeDescription = itemView.findViewById(R.id.ui_view_recipe_description);
    }

    public void onBindRecipe(Recipe recipe) {
        Picasso.get()
                .load(recipe.getImage())
                .into(recipeImage);

        recipeTitle.setText(recipe.getTitle());
        recipeDescription.setText(recipe.getDescription());

    }

}
