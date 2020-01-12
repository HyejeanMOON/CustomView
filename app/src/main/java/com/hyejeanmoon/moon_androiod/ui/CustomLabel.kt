package com.hyejeanmoon.moon_androiod.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.hyejeanmoon.moon_androiod.R

class CustomLabel : ConstraintLayout {
    private lateinit var customLabel: CustomLabel

    val textView: TextView
        get() {
            return customLabel.findViewById(R.id.textField)
        }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)
    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attributeSet,
        if (defStyleAttr != 0) defStyleAttr else R.attr.customLabel
    ) {
        init(attributeSet, defStyleAttr)
    }

    private fun init(attributeSet: AttributeSet?, defStyleAttr: Int) {
        val inflater = LayoutInflater.from(context)

        customLabel = inflater.inflate(R.layout.custom_layout, this, true) as CustomLabel

        val typedArray = context.theme.obtainStyledAttributes(
            attributeSet,
            R.styleable.CustomLabel,
            defStyleAttr,
            R.style.CustomLabel
        )

        try {
            val src = typedArray.getString(R.styleable.CustomLabel_text)
            if (src.isNullOrEmpty()) {
                textView.text = "hello world"
            } else {
                textView.text = src
            }
        } finally {
            typedArray.recycle()
        }

    }

}
