package com.cookpad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class AccountActivity extends AppCompatActivity implements View.OnClickListener {

    TextView displayEmail;
    Button btnLogOut;

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    public void initialize() {

        displayEmail = findViewById(R.id.displayEmail);

        btnLogOut = findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        initialize();

//************** Tool Bar **********************************

        getSupportActionBar();
        getSupportActionBar().setTitle("Account");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//***********************************************************

//******************* Get User Email ************************

        if (user != null) {

            String userEmail = user.getEmail();

            displayEmail.setText(userEmail);

        } else {

            // No user is signed in
        }
    }


    @Override
    public void onClick(View view) {

        int id = view.getId();

        switch (id) {

            case R.id.btnLogOut:

                logOut(view);
                break;
            case R.id.btnEditProfile:

                Intent goToEditProfile = new Intent(this, EditProfile.class);
                startActivity(goToEditProfile);
        }
    }

    private void logOut(View view) {

        FirebaseAuth.getInstance().signOut();

        Intent intent = new Intent(this, LogIn.class);
        startActivity(intent);
    }
}
