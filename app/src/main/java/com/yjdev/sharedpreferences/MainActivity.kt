package com.yjdev.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yjdev.sharedpreferences.SharedPreferencesApplication.Companion.prefs
import com.yjdev.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        checkUserValues()
    }

    private fun checkUserValues(){
        if(prefs.getName()!!.isNotEmpty()){
            goToDetail()
        }
    }
    private fun initUI(){
        binding.buttonContinue.setOnClickListener{accessToDetail()}
    }

    private fun accessToDetail(){
        if(binding.etName.text.toString().isNotEmpty()){
            prefs.saveName(binding.etName.text.toString())
            prefs.saveVip(binding.cbVip.isChecked)
            goToDetail()
        }else{

        }
    }
    private fun goToDetail(){
        startActivity(Intent(this, ResultActivity::class.java))
    }
}