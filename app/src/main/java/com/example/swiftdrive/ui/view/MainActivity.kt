package com.example.swiftdrive.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.swiftdrive.R
import androidx.navigation.findNavController
import com.example.swiftdrive.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.navHostFragment)
        return navController.navigateUp()
    }
}