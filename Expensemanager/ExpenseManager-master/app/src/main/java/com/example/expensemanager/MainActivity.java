package com.example.expensemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mEmail;
    private EditText mPass;
    private Button btnLogin;
    private TextView mForgetPassword;
    private TextView mSignupHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginDetails();
    }

    private void loginDetails(){

        mEmail=findViewById(R.id.login_email);
        mPass=findViewById(R.id.login_password);
        btnLogin=findViewById(R.id.login_loginbtn);
        mForgetPassword=findViewById(R.id.login_forgotpassword);
        mSignupHere=findViewById(R.id.login_signuphere);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=mEmail.getText().toString().trim();
                String pass=mPass.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    mEmail.setError("Email required..");
                    return;
                }

                if (TextUtils.isEmpty(pass)){
                    mPass.setError("password required..");
                    return;
                }

            }
        });

        //registration acticity

        mSignupHere.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegistrationActivity.class));


            }
        });

        //Reset password activity..

        mForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ResetActivity.class));
            }
        });

    }

}