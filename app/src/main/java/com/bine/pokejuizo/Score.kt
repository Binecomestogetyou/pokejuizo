package com.bine.pokejuizo

import android.content.Context
import android.text.Editable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import com.bine.pokejuizo.R.styleable.Score_stepSize

class Score @JvmOverloads constructor (ctx : Context, attributeSet: AttributeSet? = null) : LinearLayout(ctx, attributeSet){

    var textView : TextView
    private var score : EditText

    var text : String
    get() { return textView.text.toString() }
    set(value) { textView.text = value }

    init {

        (ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(R.layout.score_view, this)

        textView = findViewById(R.id.SV_TV)

        score = findViewById(R.id.SV_ET)

        if(attributeSet != null) {

            val attr = ctx.obtainStyledAttributes(attributeSet, R.styleable.Score)

            text = attr.getString(R.styleable.Score_text)!!

            attr.recycle()
        }
    }
}