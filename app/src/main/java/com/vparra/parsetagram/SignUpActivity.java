package com.vparra.parsetagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.text.ParseException;

public class SignUpActivity extends AppCompatActivity {

    public static final String TAG = "SignUpActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnSignUpUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnSignUpUser = findViewById(R.id.btnSignUpUser);
        btnSignUpUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "signing up the user");
                // Create the ParseUser
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                signUpUser(username, password);
            }
        });
    }

    private void signUpUser(String username, String password) {
        ParseUser user = new ParseUser();
        // Set core properties


        user.setUsername(username);
        user.setPassword(password);
        // Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(com.parse.ParseException e) {
                if(e != null) {
                    // TODO: better error handling
                    Log.e(TAG, "Issue with signup", e);
                    Toast.makeText(SignUpActivity.this, "Issue with sign up!", Toast.LENGTH_SHORT).show();
                    return;
                }
                goMainActivity();
                Toast.makeText(SignUpActivity.this, "Success!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}