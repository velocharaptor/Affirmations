package com.example.affirmations.uikit.strikethroughtextview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet

class StrikethroughTextItemView(
    context: Context,
    attrs: AttributeSet? = null
) : androidx.appcompat.widget.AppCompatTextView(context, attrs) {
    private val paint = Paint().apply {
        isAntiAlias = true
        strokeWidth = resources.displayMetrics.density * 2
        color = currentTextColor
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawLine(0f, (height / 2).toFloat(), width.toFloat(), (height / 2).toFloat(), paint)
    }
}