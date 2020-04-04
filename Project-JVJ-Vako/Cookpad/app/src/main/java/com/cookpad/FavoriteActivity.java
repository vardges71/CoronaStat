package com.cookpad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity {

    ArrayList<Recipe> listOfFavoriteRecipe = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_recipes);

        initializeToolbar();
        initializeList ();

        ListView favorite_listview = findViewById(R.id.favorite_listview);
        RecipeListAdapter recipeListAdapter = new RecipeListAdapter(this,listOfFavoriteRecipe);
        favorite_listview.setAdapter(recipeListAdapter);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        getMenuInflater().inflate(R.menu.main, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()) {
//
//            case R.id.btnGoToFinder :
//
//                Intent intentFinder = new Intent(this, FinderActivity.class);
//                startActivity(intentFinder);
//                break;
//
//            case R.id.btnGoToAccount :
//
//                Intent intentAccount = new Intent(this,AccountActivity.class);
//                startActivity(intentAccount);
//                break;
//
//            default:
//
//                break;
//
//        }
//        return super.onOptionsItemSelected(item);
//    }

    public void initializeToolbar () {
        getSupportActionBar().setTitle("Favorites");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void initializeList () {

        /*
        The usage of initializeList is only for exhibition.
        listOfFavoriteRecipe will be requested from database related with user preferences.
         */

//        Recipe recipeA = new Recipe ("MeatBalls1001","Italian");

//        listOfFavoriteRecipe.add(recipeA);

    }
}
