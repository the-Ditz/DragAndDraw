package com.tutorial.bnr.ditzlern.draganddraw

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import java.util.*
import kotlin.random.Random

private const val TAG = "BoxDrawingView"

class BoxDrawingView(context: Context, attrs: AttributeSet? = null) :
        View(context, attrs) {

    private var currentBox: Box? = null
    private val boxen = mutableListOf<Box>()
    private var boxPaint: Paint
    private val backgroundPaint: Paint

    init {
        boxPaint = Paint()
        boxPaint.color = 0x22ff0000.toInt()

        backgroundPaint = Paint()
        backgroundPaint.color = 0xfff8efe0.toInt()
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawPaint(backgroundPaint)
        boxen.forEach {box ->
            canvas.drawRect(box.left, box.top, box.right, box.bottom, boxPaint)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {


        val current = PointF(event.x, event.y)
        var action = ""
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                action = "ACTION_DOWN"
//                randomizeBoxColor()
                currentBox = Box(current, boxPaint).also {
                    boxen.add(it)
                }
            }
            MotionEvent.ACTION_MOVE -> {
                currentBox?.let {
                    it.current = current
                    invalidate()
                }
            }
            MotionEvent.ACTION_UP -> {
                action = "ACTION_UP"
                currentBox = null
            }
            MotionEvent.ACTION_CANCEL -> {
                action = "ACTION_CANCEL"
                currentBox = null
            }
        }

        Log.i(TAG, "$action at x=${current.x}, y=${current.y}")
        return true
    }


    //Half baked attemot to make a hxcode randomizer...
    fun randomizeBoxColor(){

        val array = charArrayOf('0', '1', '2', '3', '4', '5',
                '6', '7', '7', '9',  'a', 'b', 'c',
                'd', 'e', 'f')

        var stringBuffer = StringBuffer()

        stringBuffer.append("0xff")
        for (i in 1..6) {
            stringBuffer.append(array[Random.nextInt(15)])
        }
        var colorString = stringBuffer.toString()
        Log.i("COLORIZER = ", colorString)

        boxPaint =  Paint(colorString.toInt())
    }


}