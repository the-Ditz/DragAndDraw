package com.tutorial.bnr.ditzlern.draganddraw

import android.graphics.Paint
import android.graphics.PointF

class Box(val origin: PointF,
          var paint: Paint) {

    var current: PointF = origin

    val left: Float
        get() = Math.min(origin.x, current.x)
    val right: Float
        get() = Math.max(origin.x, current.x)
    val top: Float
        get() = Math.min(origin.y, current.y)
    val bottom: Float
        get() = Math.max(origin.y, current.y)
}