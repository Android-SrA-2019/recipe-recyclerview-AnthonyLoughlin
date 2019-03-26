/*
 * Author Anthony Loughlin
 * Date 2019-03-25
 */

package com.example.assignment3anthonyloughlin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private LinkedList<Recipe> mRecipeList = new LinkedList<>();

    private RecyclerView mRecyclerView;
    private RecipeRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecipeList = DataProvider.getRecipes();

        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new RecipeRecyclerViewAdapter(this, mRecipeList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
