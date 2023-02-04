package com.bine.pokejuizo.item

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import com.bine.pokejuizo.R

class ShowItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_item)

        val item = Item(intent.getStringExtra("Item")!!)

        val textViewName = findViewById<TextView>(R.id.SI_TV_NAME)
        textViewName.text = item.name

        val textViewDescription = findViewById<TextView>(R.id.SI_TV_DESCRIPTION)
        textViewDescription.text = item.description
    }
}