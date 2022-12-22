package com.bine.pokejuizo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.selectedItemId = R.id.bottom_navigation_item_traniner

        bottomNavigationView.setOnItemSelectedListener {

                when(it.itemId) {
                    R.id.bottom_navigation_item_traniner -> true

                    R.id.bottom_navigation_item_library -> {
                        startActivity(Intent(applicationContext, LibraryActivity::class.java))
                        overridePendingTransition(0, 0)
                        return@setOnItemSelectedListener true
                    }

                    R.id.bottom_navigation_item_settings -> {
                        startActivity(Intent(applicationContext, SettingsActivity::class.java))
                        overridePendingTransition(0, 0)
                        return@setOnItemSelectedListener true
                    }

                    else -> false
                }
        }
    }
}