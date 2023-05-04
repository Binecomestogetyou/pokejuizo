package com.bine.pokejuizo

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.*
import androidx.core.content.ContextCompat
import com.bine.pokejuizo.trainer.toPx
import java.util.*

class Score @JvmOverloads constructor (ctx : Context, attributeSet: AttributeSet? = null, defStyle : Int = 0) : LinearLayout(ctx, attributeSet, defStyle){

    var textView : TextView

    private var buttons : LinkedList<CheckBox> = LinkedList()
    private var min : Int = 0

    var text : String
    get() { return textView.text.toString() }
    set(value) { textView.text = value }

    init {

        (ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(R.layout.score_view, this)

        this.orientation = VERTICAL

        textView = findViewById(R.id.SV_TV)

        if(attributeSet != null) {

            val attr = ctx.obtainStyledAttributes(attributeSet, R.styleable.Score)

            textView.setTextColor(attr.getColor(R.styleable.Score_text_color, 0xFF000000.toInt()))

            text = attr.getString(R.styleable.Score_text).toString()

            val linearLayout = findViewById<LinearLayout>(R.id.SV_LL)

            var maxButtons = attr.getInt(R.styleable.Score_max, 5)

            min = attr.getInt(R.styleable.Score_min, 0)

            val backgroundDrawablePath = attr.getString(R.styleable.Score_score_background)

            if(backgroundDrawablePath != null) {

                val drawableName =
                    backgroundDrawablePath.split("/")[backgroundDrawablePath.split("/").size - 1]

                val drawableResource = resources.getIdentifier(drawableName.substring(0, drawableName.indexOf('.')),
                        "drawable",
                        ctx.packageName
                    )

                println("drawableResource is $drawableResource")

                this.background = ContextCompat.getDrawable(ctx, drawableResource)
            }

            this.setPadding(15.toPx.toInt(), 5.toPx.toInt(), 10.toPx.toInt(), 10.toPx.toInt())

            do {
                val switch = CheckBox(ctx)

                switch.buttonDrawable = ContextCompat.getDrawable(ctx, R.drawable.selector_checkbox)

                switch.setOnClickListener {

                    if (!switch.isSelected) {
                        switch.isChecked = true
                        switch.isSelected = true

                        for(b in buttons){

                            if(buttons.indexOf(b) < buttons.indexOf(switch)) b.isChecked = true

                            if(buttons.indexOf(b) > buttons.indexOf(switch)) b.isChecked = false
                        }
                    } else {
                        switch.isChecked = false
                        switch.isSelected = false

                        for(b in buttons){
                            if(buttons.indexOf(b) > buttons.indexOf(switch)) b.isChecked = false
                        }
                    }

                    for(i in 0 until min) buttons[i].isChecked = true
                }

                buttons.add(switch)

                linearLayout.addView(switch)

                maxButtons--
            }while (maxButtons > 0)

            for(i in 0 until min) buttons[i].isChecked = true

            attr.recycle()
        }
    }

    fun getLevel() : Int{

        var level = 0

        for(b in buttons) if(b.isChecked) level++

        return level
    }
}