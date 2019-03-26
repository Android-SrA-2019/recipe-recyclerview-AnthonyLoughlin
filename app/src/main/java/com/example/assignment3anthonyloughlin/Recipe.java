/*
 * Author Anthony Loughlin
 * Date 2019-03-25
 */

package com.example.assignment3anthonyloughlin;

public class Recipe {
    public Recipe(String name, String description, String image, String ingredients, String directions) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public String name;
    public String description;
    public String image;
    public String ingredients;
    public String directions;
}