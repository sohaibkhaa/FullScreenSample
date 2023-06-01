package com.example.fullscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.fullscreen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var showControls = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // enable full screen mode
        enableFullScreen()
        // update status bar and nav bar color according to your requirements
        setStatusBarColor(R.color.controls)
        setNavBarColor(R.color.controls)
        // applying window insets to controls layout
        // so that when status bar and navigation bar appears
        // they can not appear on top of header and footer
        binding.controllersParent.applyWindowInsets()
        setClickListeners()
    }

    private fun setClickListeners() = with(binding) {
        imageView.setOnClickListener {
            showControls = !showControls
            showUi(showControls)
        }
    }

    private fun showUi(show: Boolean) {
        if (show) {
            binding.controllersParent.visibility = View.VISIBLE
            showSystemBars()
        } else {
            binding.controllersParent.visibility = View.GONE
            hideSystemBars()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // disable full screen mode
        disableFullScreen()
        // optional
        // update status bar and navbar color back to original colors
    }
}