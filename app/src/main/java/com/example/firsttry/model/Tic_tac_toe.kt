package com.example.firsttry.model

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Tic_tac_toe @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defyStyleAttr: Int = 0,
) : View(context, attrs, defyStyleAttr) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint = Paint()
        val width = width.toFloat()
        val height = height.toFloat()
        var columns = 3
        var rows = 3

        for (i in 1..columns-1) {
            canvas?.drawLine(i * (width / columns), 0f, i * (width / columns), width, paint)
        }
        for (j in 1..rows-1) {
            canvas?.drawLine(0f, j * (width / rows), width, j * (width / rows), paint)

        }
    }
}