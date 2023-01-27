package com.example.appmarte.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appmarte.R
import com.example.appmarte.databinding.ActivityInicioBinding
import com.example.appmarte.databinding.ActivityMainBinding

class InicioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInicioBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInicioBinding.inflate(layoutInflater)
        setContentView(binding.root)


       // setContentView(R.layout.activity_inicio)
        binding.buttonFirst.setOnClickListener {
            val intento = Intent(this, MainActivity::class.java)
            startActivity(intento)


        }
    }
}