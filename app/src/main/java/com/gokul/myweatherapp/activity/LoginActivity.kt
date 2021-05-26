package com.gokul.myweatherapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gokul.myweatherapp.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener{
           if(validateLogin()){
               startActivity(Intent(this, MainActivity::class.java))
           }

        }
    }

    private fun validateLogin(): Boolean {
        val user = etUserName.text.toString().trim()
        val password = etPassword.text.toString().trim()
        if( user.isEmpty() || password.isEmpty()){
            show("Please enter the value in user and email")
            return false
        }
        if(user != "username" && password != "password" ){
            show("please enter right username and password")
            return false
        }
        return true;
    }

    private fun show(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}