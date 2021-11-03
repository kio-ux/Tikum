package com.example.tikum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Vector;


public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText et_username, et_email, et_password;
    private CheckBox cb_agree;
    private String username, email, password, gender;
    private Boolean agree;
    private Button btn_signup;
    private TextView loginHere;
//    private RadioGroup rg_gender;
    private RadioButton radioButton;

    Vector<String> vectorUsername = new Vector<>();
    Vector<String> vectorPassword = new Vector<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initialize();
    }


    private void initialize() {
        et_username = findViewById(R.id.et_username);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
//        rg_gender = findViewById(R.id.rg_gender);
        btn_signup = findViewById(R.id.btn_signup);
        loginHere = findViewById(R.id.tv_login_here);
        cb_agree = findViewById(R.id.cb_agree);

        btn_signup.setOnClickListener(this);
        loginHere.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == btn_signup){
            username = et_username.getText().toString();
            email = et_email.getText().toString();
            password = et_password.getText().toString();
            agree = cb_agree.isChecked();

            if (username.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Username Must be Filled!", Toast.LENGTH_LONG).show();
            } else if (username.length() < 5 || username.length() > 20) {
                Toast.makeText(getApplicationContext(), "Username must contains 5-20 characters", Toast.LENGTH_LONG).show();
            } else if (email.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Email Must be Filled!", Toast.LENGTH_LONG).show();
            } else if (!email.contains("@") || !email.contains(".")) {
                Toast.makeText(getApplicationContext(), "Email must contain @ and .", Toast.LENGTH_LONG).show();
            } else if (password.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Password Must be Filled!", Toast.LENGTH_LONG).show();
            } else if (password.length() < 6) {
                Toast.makeText(getApplicationContext(), "Password must be at least 6 characters", Toast.LENGTH_LONG).show();
            } else if (!agree) {
                Toast.makeText(getApplicationContext(), "Terms and Conditions Agreement Must be Clicked!", Toast.LENGTH_LONG).show();
            } else {
                vectorUsername.add(username);
                vectorPassword.add(password);

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);

            }
        }else if (v == loginHere){
            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
        }


    }
//    public void checkButton(View v){
//        boolean checked = ((RadioButton) v).isChecked();
//        switch (v.getId()){
//            case R.id.rd_male:
//                if (checked)
//                    gender.equals("Male");
//                break;
//            case R.id.rd_female:
//                if (checked)
//                    gender.equals("Female");
//                break;
//        }
//
//
//    }
}