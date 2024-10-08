package com.example.mysignupapp;

import static java.util.regex.Pattern.matches;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText etEmail,etPassword,etConfirmPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
            connectComponents();
        });
    }

    private void connectComponents() {
        etEmail=findViewById(R.id.etEmailMain);
        etPassword=findViewById(R.id.etPasswordMain);
        etConfirmPassword=findViewById(R.id.etConfirmPassword);

    }

    public void SignUp(View view) {
        String email ,password, confirmPassword;
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();
        confirmPassword = etConfirmPassword.getText().toString();
        if (email.trim().isEmpty() || password.trim().isEmpty()||confirmPassword.trim().isEmpty())
        {
            Toast.makeText(this, "SOME FIELDS ARE MISSING", Toast.LENGTH_SHORT).show();
        }
        if (!isEmailValid(email)){
            Toast.makeText(this, "EMAIL IS INCORRECT", Toast.LENGTH_SHORT).show();
            return;



        }
        if (!isPasswordValid(password)){
            Toast.makeText(this, "EMAIL IS INCORRECT", Toast.LENGTH_SHORT).show();
            return;




        }
        if (!isPasswordValid(password))
        {
            Toast.makeText(this, "password is not identical", Toast.LENGTH_SHORT).show();

            return;

        }
    public boolean isEmailValid(String email){
        String expression;
            expression = "^[|\wl\.-]+@([\\w|\-]+1\-)+[A-Z]{2,4}$";
            Pattern pattern = Pattern. compile(expression, Pattern. CASE_INSENSITIVE);
        Matcher matcher = pattern. matcher (email);
        return matcher-matches();


    }
        // TODO: signup to system


}

    private boolean isPasswordValid(String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=[0-9]) (?=\u2022[A-Z])(?=.[@#$%&+=!])(?=115+$)-{4,35";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher= pattern.matcher(password);
        return matcher.matches();



    }
    }