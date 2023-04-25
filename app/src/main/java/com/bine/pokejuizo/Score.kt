package com.bine.pokejuizo

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.*
import java.util.*

class Score @JvmOverloads constructor (ctx : Context, attributeSet: AttributeSet? = null, defStyle : Int = 0) : LinearLayout(ctx, attributeSet, defStyle){

    var textView : TextView

    var buttons : LinkedList<ToggleButton> = LinkedList()

    var text : String
    get() { return textView.text.toString() }
    set(value) { textView.text = value }

    init {

        (ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(R.layout.score_view, this)

        this.orientation = VERTICAL

        textView = findViewById(R.id.SV_TV)

        if(attributeSet != null) {

            val attr = ctx.obtainStyledAttributes(attributeSet, R.styleable.Score)

            text = attr.getString(R.styleable.Score_text).toString()

            val linearLayout = findViewById<LinearLayout>(R.id.SV_LL)

            var maxButtons = attr.getInt(R.styleable.Score_max, 1)

            val minButtons = attr

            do {
                val switch = ToggleButton(ctx)

                switch.setOnClickListener { switch -> onClick(switch as ToggleButton) }

                buttons.add(switch)

                linearLayout.addView(switch)

                maxButtons--
            }while (maxButtons > 0)

            attr.recycle()
        }
    }

    fun onClick(toggleButton: ToggleButton){

        if(toggleButton.isChecked){
            for(b in buttons){

                if(buttons.indexOf(b) < buttons.indexOf(toggleButton)) b.isChecked = true

                if(buttons.indexOf(b) > buttons.indexOf(toggleButton)) b.isChecked = false
            }
        }
        else{
            for(b in buttons){
                if(buttons.indexOf(b) > buttons.indexOf(toggleButton)) b.isChecked = false
            }
        }
    }
}