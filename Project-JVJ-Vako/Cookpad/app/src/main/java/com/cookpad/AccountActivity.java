package com.cookpad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {

//    Button btnLogOut;

    public void initialize() {

//        btnLogOut = findViewById(R.id.btnLogOut);
//        btnLogOut.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        getSupportActionBar();
        getSupportActionBar().setTitle("Account");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initialize();
    }


    @Override
    public void onClick(View view) {

//        int id = view.getId();
//
//        switch (id) {
//
//            case R.id.btnLogOut:
//
//                logOut(view);
//                break;
//        }
    }


    private void logOut(View view) {

        FirebaseAuth.getInstance().signOut();

        Intent intent = new Intent(this, LogIn.class);
        startActivity(intent);
    }
}
