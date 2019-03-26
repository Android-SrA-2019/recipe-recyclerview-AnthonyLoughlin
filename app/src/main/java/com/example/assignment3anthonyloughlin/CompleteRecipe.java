/*
 * Author Anthony Loughlin
 * Date 2019-03-25
 */

package com.example.assignment3anthonyloughlin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class CompleteRecipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_recipe);
        TextView name = findViewById(R.id.recipe_name);
        name.setText(getIntent().getStringExtra("name"));
        TextView ingredients = findViewById(R.id.ingredients);
        ingredients.setText(getIntent().getStringExtra("ingredients") + "\n");
        TextView directions = findViewById(R.id.directions);
        directions.setText(getIntent().getStringExtra("directions"));
        ImageView img = findViewById(R.id.recipe_image);
        Picasso.get()
                .load(getIntent().getStringExtra("image"))
                .fit()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(img);
    }
}
