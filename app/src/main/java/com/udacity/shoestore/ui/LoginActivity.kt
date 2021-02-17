package com.udacity.shoestore.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this,R.layout.activity_login)

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        binding.btnCreateLogin.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }

}