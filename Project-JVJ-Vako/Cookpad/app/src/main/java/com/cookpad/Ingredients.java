package com.cookpad;

import androidx.annotation.NonNull;

public class Ingredients {

    String ingredients;

    public Ingredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @NonNull
    @Override
    public String toString() {

        return ingredients;
    }
}