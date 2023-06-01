package com.example.fullscreen

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.core.view.updatePadding

fun Activity.setStatusBarColor(color: Int) {
    window.statusBarColor = ContextCompat.getColor(this, color)
}

fun Activity.setNavBarColor(color: Int) {
    window.navigationBarColor = ContextCompat.getColor(this, color)
}

fun Activity.enableFullScreen() {
    WindowCompat.setDecorFitsSystemWindows(window, false)
}

fun Activity.disableFullScreen() {
    WindowCompat.setDecorFitsSystemWindows(window, true)
}

fun View.applyWindowInsets() {
    ViewCompat.setOnApplyWindowInsetsListener(this) { view, windowInsets ->
        val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
        // Apply the insets as a margin to the view. Here the system is setting
        // only the bottom, left, and right dimensions, but apply whichever insets are
        // appropriate to your layout. You can also update the view padding
        // if that's more appropriate.
        (layoutParams as MarginLayoutParams).setMargins(
            insets.left, insets.top, insets.right, insets.bottom
        )
        // Return CONSUMED if you don't want want the window insets to keep being
        // passed down to descendant views.
        WindowInsetsCompat.CONSUMED
    }
}

fun Activity.hideSystemBars() {
    val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
    windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
}

fun Activity.showSystemBars() {
    val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
    windowInsetsController.show(WindowInsetsCompat.Type.systemBars())
}