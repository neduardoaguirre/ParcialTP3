package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.viewModel.PerfilViewModel

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener() {
            val intent = Intent(this, HomeActivity::class.java)
            var inputUsername = findViewById<EditText>(R.id.username)
            intent.putExtra("username", inputUsername.text.toString())
            //intent.putExtra("username", "Martin")
            startActivity(intent)
        }

    }

}