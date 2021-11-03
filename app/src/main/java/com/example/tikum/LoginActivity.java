package com.example.tikum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private TextView registerHere;
    private EditText et_username, et_password;
    private Button loginButton;

    private String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialize();

    }
        private void initialize() {
            registerHere = findViewById(R.id.tv_registerLink);
            et_username = findViewById(R.id.et_loginUsername);
            et_password = findViewById(R.id.et_loginPassword);
            loginButton = findViewById(R.id.loginButton);

            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    username = et_username.getText().toString();
                    password = et_password.getText().toString();

                    if (username.isEmpty() || password.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Email and password must be filled!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    }
                }
            });


            registerHere.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
                }
            });


    }
}