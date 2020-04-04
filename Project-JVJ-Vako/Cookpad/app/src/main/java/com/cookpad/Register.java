package com.cookpad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Register extends AppCompatActivity implements View.OnClickListener {

    private Button btnRegister, btnCancel;
    private EditText e1, p1, p2;

    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initialize();
    }

    public void initialize() {

        e1 = findViewById(R.id.registerEmail);
        p1 = findViewById(R.id.regPasswField);
        p2 = findViewById(R.id.reRegPasswField);

        btnRegister = findViewById(R.id.btnRegister);
        btnCancel = findViewById(R.id.btnCancel);

        btnRegister.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        switch (id) {

            case R.id.btnRegister:

//           CheckIn if User Already Exist

                if (mAuth.getCurrentUser() != null) {

                    Intent nextView = new Intent(Register.this, MainActivity.class);
                    startActivity(nextView);

                    finish();
                } else {

                    toRegister(view);
                }
                break;
            case  R.id.btnCancel:

                Intent backToLogin = new Intent(this, LogIn.class);

                startActivity(backToLogin);
                break;
        }
    }

    private void toRegister(View view) {

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        String userPassw;

        if ((p1.getText().toString().equals(p2.getText().toString())) && ((e1.getText().toString().trim().matches(emailPattern) && e1.length() > 0)) && p1.length() > 0) {


            String checkedPassw = p1.getText().toString().trim();

            userPassw = checkedPassw;

            String email = e1.getText().toString().trim();
            String password = userPassw;

//          Register the User in FireBase

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {

                        Toast.makeText(getApplicationContext(), "Registration Success!!!", Toast.LENGTH_LONG).show();

                        Intent nextView = new Intent(Register.this, MainActivity.class);
                        startActivity(nextView);

                        e1.setText(null); p1.setText(null); p2.setText(null);

                    } else {


                        Toast.makeText(Register.this, "Error!!! " + task.getException().getMessage(), Toast.LENGTH_LONG).show();

                    }
                }
            });

        } else {

            Toast.makeText(getApplicationContext(), "Please enter valid credentials", Toast.LENGTH_LONG).show();
        }
    }

}
