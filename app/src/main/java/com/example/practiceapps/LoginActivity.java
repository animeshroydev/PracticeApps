package com.example.practiceapps;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText edtFullName,edtEmail, edtPassword, edtConfirmPassword;
    Button btnCreateAccount;

    CheckBox checkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        edtFullName=findViewById(R.id.edtfullname);
        edtEmail=findViewById(R.id.edtemail);
        edtPassword=findViewById(R.id.edtpassword);
        edtConfirmPassword=findViewById(R.id.edtcofmpassword);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);
        checkBox = findViewById(R.id.checkBoxLogin);


        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fullName=edtFullName.getText().toString();
                String email=edtEmail.getText().toString();
                String password=edtPassword.getText().toString();
                String confirmPassword=edtConfirmPassword.getText().toString();

                if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }

                else if (!checkBox.isChecked()) {
                    Toast.makeText(LoginActivity.this, "Please accept the terms and conditions", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(LoginActivity.this, "Account created successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}