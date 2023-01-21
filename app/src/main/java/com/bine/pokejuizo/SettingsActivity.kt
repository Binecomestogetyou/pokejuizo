package com.bine.pokejuizo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.selectedItemId = R.id.bottom_navigation_item_settings

        bottomNavigationView.setOnNavigationItemSelectedListener {

            when(it.itemId) {
                R.id.bottom_navigation_item_traniner -> {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    overridePendingTransition(0, 0)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.bottom_navigation_item_library -> {
                    startActivity(Intent(applicationContext, LibraryActivity::class.java))
                    overridePendingTransition(0, 0)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.bottom_navigation_item_settings -> true

                else -> false
            }
        }
    }
}