package com.example.practiceapps

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class LoginActivity2 : AppCompatActivity() {

    lateinit var edtEmailAds: EditText
    lateinit var edtPassword: EditText
    lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        edtEmailAds = findViewById<EditText>(R.id.emailEditTxt)
        edtPassword = findViewById<EditText>(R.id.passwordEditTxt)
        btnLogin = findViewById<Button>(R.id.loginBtn)

        val sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val isLoggedIn = sharedPreferences.getBoolean("isLogin", false)

        if (isLoggedIn) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnLogin.setOnClickListener {

            val emailAddress = edtEmailAds.text.toString()
            val password = edtPassword.text.toString()

            if (emailAddress == "john@gmail.com" && password == "123456") {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                editor.putBoolean("isLogin", true)
                editor.apply()

                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish() // it's important for proper backstack handling
            }
            else if (emailAddress.isEmpty()){
                Toast.makeText(this, "Enter Mobile No.", Toast.LENGTH_SHORT).show();
            }
            else if (password.isEmpty()) {
                Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }

        }
    }
}