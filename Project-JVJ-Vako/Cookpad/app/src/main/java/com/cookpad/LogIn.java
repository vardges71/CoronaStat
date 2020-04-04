package com.cookpad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogIn extends AppCompatActivity implements View.OnClickListener {

    private EditText userEmail, userPassword;
    private Button btnLogin, btnRegister;
    private TextView btnForgotPass;

    FirebaseAuth mAuth;
    // TODO: 2020-03-16 implement onAuthStateListener

    private void initialize() {

        userEmail = findViewById(R.id.loginEmail);
        userPassword = findViewById(R.id.loginPassw);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

        btnForgotPass = findViewById(R.id.btnForgotPass);
        btnForgotPass.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        initialize();

        /* This will keep the user logged in by taking the user to the Account activity directly
        without stopping at registration activity.
        So the user will be logged in unless the user click on LogOut button which is in
        Account Activity.
         */

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            Intent i = new Intent(LogIn.this, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        } else {

            // User is signed out
            Log.d("TAG", "onAuthStateChanged: Signed_Out");
        }
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        switch (id) {

            case R.id.btnLogin:
                goTologIn(view);
                break;
            case R.id.btnRegister:
                Intent intent = new Intent(LogIn.this, Register.class);

                startActivity(intent);
                break;
            case R.id.btnForgotPass:
                forgotPassw(view);
                break;
        }
    }

    private void goTologIn(View view) {

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String password = userPassword.getText().toString().trim();

        if ((userEmail.getText().toString().trim().matches(emailPattern) && userEmail.length() > 0) && userPassword.length() > 5) {

            final String email = userEmail.getText().toString().trim();

//          Authenticate the User in FireBase

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {

                        Toast.makeText(getApplicationContext(), "LogIn is Success!!!", Toast.LENGTH_LONG).show();

                        Intent nextView = new Intent(LogIn.this, MainActivity.class);
                        startActivity(nextView);

                        userEmail.setText(null);
                        userPassword.setText(null);
                    } else {

                        Toast.makeText(LogIn.this, "Error!!! " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }

            });
        } else {

            Toast.makeText(LogIn.this, "Enter correct e-mail or password.", Toast.LENGTH_LONG).show();
        }
    }

    private void forgotPassw(View view) {

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if ((userEmail.getText().toString().trim().matches(emailPattern) && userEmail.length() > 0)) {
            mAuth.sendPasswordResetEmail(userEmail.getText().toString().trim())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(LogIn.this,
                                        "Password reset email has been sent to you", Toast.LENGTH_LONG).show();
                            } else {

                                Toast.makeText(LogIn.this, "Error!!! " +
                                        task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        } else {

            Toast.makeText(getApplicationContext(), "Please enter valid e-mail", Toast.LENGTH_LONG).show();
        }
    }
}
