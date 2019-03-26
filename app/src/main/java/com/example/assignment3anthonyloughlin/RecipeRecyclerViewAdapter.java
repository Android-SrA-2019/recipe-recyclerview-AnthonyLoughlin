/*
 * Author Anthony Loughlin
 * Date 2019-03-25
 */

package com.example.assignment3anthonyloughlin;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class RecipeRecyclerViewAdapter extends RecyclerView.Adapter<RecipeRecyclerViewAdapter.RecipeListViewHolder> {
    private final LinkedList<Recipe> mRecipeList;
    private LayoutInflater mInflater;
    private Context mContext;


    public RecipeRecyclerViewAdapter(Context context, LinkedList<Recipe> recipeList){
        mInflater = LayoutInflater.from(context);
        this.mRecipeList = recipeList;
        this.mContext = context;
    }

    class RecipeListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView recipeNameView;
        public final TextView recipeDescView;
        final RecipeRecyclerViewAdapter mAdapter;

        public RecipeListViewHolder(@NonNull View itemView, RecipeRecyclerViewAdapter adapter) {
            super(itemView);
            recipeNameView = itemView.findViewById(R.id.recipe_name);
            recipeDescView = itemView.findViewById(R.id.recipe_description);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            mAdapter.notifyItemChanged(position, position);
            Intent intent = new Intent(mContext, CompleteRecipe.class);
            intent.putExtra("name", mRecipeList.get(position).name);
            intent.putExtra("directions", mRecipeList.get(position).directions);
            intent.putExtra("ingredients", mRecipeList.get(position).ingredients);
            intent.putExtra("image", mRecipeList.get(position).image);
            mContext.startActivity(intent);
        }
    }

    @NonNull
    @Override
    public RecipeRecyclerViewAdapter.RecipeListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recipelist_item, parent, false);

        return new RecipeListViewHolder(mItemView, this);
    }


    @Override
    public void onBindViewHolder(@NonNull RecipeRecyclerViewAdapter.RecipeListViewHolder recipeListViewHolder, int position) {
        Recipe mCurrent = mRecipeList.get(position);
        recipeListViewHolder.recipeNameView.setText(mCurrent.name);
        recipeListViewHolder.recipeDescView.setText(mCurrent.description);
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }
}
