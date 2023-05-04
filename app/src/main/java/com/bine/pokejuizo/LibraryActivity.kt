package com.bine.pokejuizo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.view.children
import com.google.android.material.bottomnavigation.BottomNavigationView

class LibraryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        val buttons = findViewById<LinearLayout>(R.id.LA_LL).children

        for(b in buttons) b.setOnClickListener { onClick(b) }


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.selectedItemId = R.id.bottom_navigation_item_library

        bottomNavigationView.setOnNavigationItemSelectedListener {

            when(it.itemId) {
                R.id.bottom_navigation_item_trainer -> {
                    startActivity(Intent(applicationContext, TrainerActivity::class.java))
                    overridePendingTransition(0, 0)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.bottom_navigation_item_library -> true

                R.id.bottom_navigation_item_settings -> {
                    startActivity(Intent(applicationContext, SettingsActivity::class.java))
                    overridePendingTransition(0, 0)
                    return@setOnNavigationItemSelectedListener true
                }

                else -> false
            }
        }
    }

    private fun onClick(view : View){

        val intent = Intent(view.context, BookCaseActivity::class.java)

        val str = (view as Button).text.toString()

        println("LibraryActivity intent got $str")

        intent.putExtra("BOOKCASE", str)

        startActivity(intent)
    }
}