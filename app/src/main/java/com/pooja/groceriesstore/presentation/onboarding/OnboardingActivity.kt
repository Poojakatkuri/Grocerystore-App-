package com.pooja.groceriesstore.presentation.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging
import com.pooja.groceriesstore.MainActivity
import com.pooja.groceriesstore.R
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContent {
            OnboardingScreen(navigateToMainInitialScreen = ::navigateToMainInitialScreen)
        }
        setEvenListener()
    }

    private fun navigateToMainInitialScreen() {
        val intent = Intent(this.applicationContext, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        startActivity(intent)
    }

    private fun setEvenListener() {
        // Firebase is optional: skip push setup when no google-services.json was provided.
        if (FirebaseApp.getApps(this).isEmpty()) {
            Timber.d("Firebase is not configured; skipping FCM token fetch")
            return
        }
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Timber.d("Fetching FCM registration token failed" + task.exception)
                return@OnCompleteListener
            }
            val token = task.result
            Timber.d(token)
        })
    }
}
