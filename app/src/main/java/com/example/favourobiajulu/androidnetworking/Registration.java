package com.example.favourobiajulu.androidnetworking;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

/**
 * Created by favourobiajulu on 11/20/18.
 */

public class Registration extends AppCompatActivity {
    private EditText etFirstName, etlastName, etemail, etpassword, etConfirmpassword,etPhoneNumber;
    private Button btnRegister;
    private Spinner spGender;
    private String Email, Password, Firstname, Lastname, Confirmpassword, Gender,phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        etFirstName = (EditText)findViewById(R.id.etFirstName);
        etlastName = (EditText)findViewById(R.id.etLastName);
        etConfirmpassword =(EditText)findViewById(R.id.etConfirmPassword);
        etemail =(EditText)findViewById(R.id.etEmail);
        etPhoneNumber=(EditText)findViewById(R.id.etphoneNumber);
        etpassword=(EditText)findViewById(R.id.etPass);
        btnRegister=(Button)findViewById(R.id.btnlogin);
        spGender = (Spinner)findViewById(R.id.spGender);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }

            private void validation() {
                Firstname= etFirstName.getText().toString().trim();
                Lastname = etlastName.getText().toString().trim();
                Confirmpassword = etConfirmpassword.getText().toString().trim();
                Email= etemail.getText().toString().trim();
                Password=etpassword.getText().toString().trim();
                phoneNumber=etPhoneNumber.getText().toString().trim();
                Gender = spGender.getSelectedItem().toString().trim();


                if (Firstname.isEmpty()){
                    etFirstName.setError(" Firstname");
                    return;
                }
                if (Lastname.isEmpty()){
                    etlastName.setError(" Lastname");
                    return;
                }
                if (!isValidEmaillId(Email)){
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
                if (phoneNumber.length()  <11) {
                    etPhoneNumber.setError("phoneNumber cannot be less than 11");
                    return;
                }
                if (phoneNumber.isEmpty()){
                    etPhoneNumber.setError("phoneNumber cannot be empty");
                }
                else {
                    Toast.makeText(Registration.this, "Successsful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Registration.this, MainActivity.class));

                }



            }
        });

    }

    boolean isValidEmaillId(String email){
        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{2}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))[1]|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }




}
