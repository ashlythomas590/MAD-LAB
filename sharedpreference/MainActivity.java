package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sharedperference.R;

public class MainActivity extends AppCompatActivity {

    EditText username, mobilenumber, email, password, confirmpassword;
    Button submit;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        mobilenumber = findViewById(R.id.mobilenumber);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmpassword = findViewById(R.id.confirmpassword_confirm);
        submit = findViewById(R.id.loginbtn);

        sharedPreferences = getSharedPreferences("userdetails", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernames = username.getText().toString().trim();
                String mobileli = mobilenumber.getText().toString().trim();
                String emai1s = email.getText().toString().trim();
                String pass1s = password.getText().toString().trim();
                String pass2s = confirmpassword.getText().toString().trim();

                if (usernames.isEmpty()) {
                    username.setError("username is empty");
                    username.requestFocus();
                    return;
                }

                if (mobileli.isEmpty()) {
                    mobilenumber.setError("mobile number is empty");
                    mobilenumber.requestFocus();
                    return;
                }

                if (emai1s.isEmpty()) {
                    email.setError("input email");
                    email.requestFocus();
                    return;
                }

                if (pass1s.isEmpty()) {
                    password.setError("enter password");
                    password.requestFocus();
                    return;
                }

                if (pass2s.isEmpty()) {
                    confirmpassword.setError("confirm password");
                    confirmpassword.requestFocus();
                    return;
                }

                if (pass1s.length() < 6) {
                    password.setError("length must be minimum 6 characters");
                    password.requestFocus();
                    return;
                }

                if (!pass1s.equals(pass2s)) {
                    confirmpassword.setError("passwords do not match");
                    confirmpassword.requestFocus();
                    return;
                }

                Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                editor.putString("keyusername", usernames);
                editor.putString("keymobile", mobileli);
                editor.putString("keyemail", emai1s);
                editor.putString("keypassword", pass1s);
                editor.apply();
            }
        });
    }
}
