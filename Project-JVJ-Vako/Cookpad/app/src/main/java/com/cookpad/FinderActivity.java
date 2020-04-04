package com.cookpad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FinderActivity extends AppCompatActivity implements View.OnClickListener {

    ListView listViewIngredients;
    EditText ingredientField;
    Button btnAddIngredients, btnSearch;

    ArrayList<Ingredients> listOfIngredients;
    ArrayAdapter<Ingredients> ingredientsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finder);

        initialize();
        initializeToolbar();
    }

    public void initialize() {

        listViewIngredients = findViewById(R.id.listViewIngredient);
        ingredientField = findViewById(R.id.ingredientField);

        btnAddIngredients = findViewById(R.id.btnAdd);
        btnSearch = findViewById(R.id.btnSearch);

        btnAddIngredients.setOnClickListener(this);
        btnSearch.setOnClickListener(this);

        listOfIngredients = new ArrayList<Ingredients>();

        ingredientsAdapter = new ArrayAdapter<Ingredients>(this, R.layout.listview_row, R.id.lvRow, listOfIngredients);

        listViewIngredients.setAdapter(ingredientsAdapter);

    }


    @Override
    public void onClick(View v) {

        int btnId = v.getId();

        switch (btnId) {

            case R.id.btnAdd:
                add();
                break;
            case R.id.btnSearch:
                searchFinder();
            break;
        }
    }

    public void add() {

        String ingredient = ingredientField.getText().toString();

        Ingredients ing = new Ingredients(ingredient);
        listOfIngredients.add(ing);

        ingredientsAdapter.notifyDataSetChanged();

        ingredientField.setText(null);

        Toast.makeText(this, "Ingredient is added", Toast.LENGTH_LONG).show();

    }

    public void searchFinder() {

        Intent intent = new Intent(FinderActivity.this, MainActivity.class);
        startActivity(intent);
    }


//    ********************************* Menu Part ***********************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.btnGoToFavorites :

                Intent intentFavorites = new Intent(this, FavoriteActivity.class);
                startActivity(intentFavorites);
                break;

            case R.id.btnGoToAccount :

                Intent intentAccount = new Intent(this,AccountActivity.class);
                startActivity(intentAccount);
                break;

            default:

                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void initializeToolbar () {

        getSupportActionBar().setTitle("Finder");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

//    **************************************************************************

}
