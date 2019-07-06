package com.example.favourobiajulu.androidnetworking;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by favourobiajulu on 11/20/18.
 */

@SuppressLint("Registered")
public class Login extends AppCompatActivity {
    private EditText etemail, etpassword;
    private Button btnRegister;
    private String Email, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        etemail =(EditText)findViewById(R.id.etEmail);
        etpassword=(EditText)findViewById(R.id.etPass);
        btnRegister=(Button)findViewById(R.id.btnlogin);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }

            private void validation() {

                Email= etemail.getText().toString().trim();
                Password=etpassword.getText().toString().trim();

                if (Email.isEmpty()){
                    etemail.setError("Email Cannot be empty");
                    return;
                }
                if (Password.length() <7 ) {
                    etpassword.setError("Password is less than 6!");
                    return;
                }
                if (Password.isEmpty()){
                    etpassword.setError("PassWord cannot be empty");
                    return;
                }
                else {
                    Toast.makeText(Login.this, "Successsful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, MainActivity.class));
                    
                }



            }
        });

    }



}
