package com.yjdev.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.yjdev.sharedpreferences.SharedPreferencesApplication.Companion.prefs
import com.yjdev.sharedpreferences.databinding.ActivityResultBinding
import kotlin.contracts.Returns

class ResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    fun initUI() {
        binding.buttonReturn.setOnClickListener {
            prefs.borrar()
            onBackPressed()
        }
        val username = prefs.getName()
        binding.tvName.text = "Bienvenido $username"

        if (prefs.getVip() == true) {
            setVipColorBg()
        }
    }

    fun setVipColorBg() {
        binding.container.setBackgroundColor(ContextCompat.getColor(this, R.color.vip))
    }
}