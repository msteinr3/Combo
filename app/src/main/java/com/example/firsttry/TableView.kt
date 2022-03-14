package com.example.firsttry

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import org.w3c.dom.Attr
import java.security.AccessControlContext
import java.util.jar.Attributes

class TableView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defyStyleAttr: Int = 0
) : View(context, attrs, defyStyleAttr) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint = Paint()
        val width = width.toFloat()
        val height = height.toFloat()
        var columns = 10
        var rows = 10

        for (i in 0..columns) {
            canvas?.drawLine(i * (width / columns), 0f, i * (width / columns), width, paint)
        }
        for (j in 0..rows) {
            canvas?.drawLine(0f, j * (width / rows), width, j * (width / rows), paint)

        }
    }
}