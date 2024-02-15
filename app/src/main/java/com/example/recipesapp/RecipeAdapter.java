package com.example.recipesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>{
    private final Recipe[] recipes;

    public RecipeAdapter(Recipe[] recipes) {
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public RecipeAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item view layout and create a new ViewHolder
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_show_recipe, parent, false);

        return new RecipeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        // Bind the data to the views in the ViewHolder
        Recipe recipe = null;
        if (position < 0 || position >= this.recipes.length)
            throw new IndexOutOfBoundsException();
        recipe = (Recipe) this.recipes[position];
        holder.textViewRecipeName.setText(recipe.getName());
        holder.textViewTimeToMake.setText(recipe.getTime() + " minutes");

        int recipe_id = recipe.getId();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Hello "+recipe_id);
                Intent intent = new Intent(holder.itemView.getContext(), MoreDetails.class);
                Bundle b= new Bundle();
                b.putInt("recipe_id", recipe_id);
                intent.putExtras(b);

                holder.itemView.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
//      Return the number of items in the data set
        return this.recipes.length;
    }

    // Create the ViewHolder class
    public class RecipeViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewRecipeName;
        public TextView textViewTimeToMake;

        public RecipeViewHolder(View itemView) {
            super(itemView);
            // Initialize the views in the ViewHolder
            textViewRecipeName = itemView.findViewById(R.id.NameTextView);
            textViewTimeToMake = itemView.findViewById(R.id.TimeToMakeTextView);
        }
    }



}
