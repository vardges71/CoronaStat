package com.cookpad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {

    TextView textViewRecipeName, textViewOrigine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        initialize ();
        initializeToolbar();
    }

    public void initialize (){
        textViewRecipeName = findViewById(R.id.textViewRecipeName);
        textViewOrigine = findViewById(R.id.textViewOrigine);
        //ArrayList<String> ingredientArray = new ArrayList<>();
        //ArrayList<String> instructionArray = new ArrayList<>();

        textViewRecipeName.setText(getIntent().getStringExtra("recipeName"));
        textViewOrigine.setText(getIntent().getStringExtra("recipeOrigine"));
    }

    public void initializeToolbar () {
        getSupportActionBar().setTitle(textViewRecipeName.getText());
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
