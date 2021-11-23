package com.example.career_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView register;
    private TextView forgotPassword;

    private FirebaseAuth mAuth;
    private static final String TAG = "MainActivity";
    private EditText editTextEmail, editTextPassword;

    //Whatever Sign in button does, goes inside this method.
    @SuppressLint("NonConstantResourceId")
    @OnClick(R.id.signIn) void signIn(View view){
        Toast.makeText(this, "logged in!", Toast.LENGTH_LONG).show();
//        Intent intent = new Intent(this, Home.class);
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        register = (TextView) findViewById(R.id.register);
        register.setOnClickListener(this);

        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.password);

        forgotPassword = (TextView) findViewById((R.id.forgotPassword));
        forgotPassword.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register:
                startActivity(new Intent(this,RegisterUser.class));
                break;

            case R.id.forgotPassword:
                startActivity(new Intent(this,ForgotPassword.class));
                break;
        }

    }

}