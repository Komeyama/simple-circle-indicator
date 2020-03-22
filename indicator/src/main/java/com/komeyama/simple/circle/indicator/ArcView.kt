package com.komeyama.simple.circle.indicator

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class ArcView: View {

    private var paint: Paint = Paint()
    private var rectF = RectF()
    private var mCanvas: Canvas? = null
    private var startAngle: Float = 0f
    var completeArcAngle: Float = 0f
    var rotateArcAngle: Float = 0f
    var strokeWidth: Float = 0f
    var strokeColor = Color.parseColor("#FFFFFF")
    var isInversion = false
    private val sign : Int by lazy {
        if (isInversion) { 1 } else { -1 }
    }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.ArcView)
        startAngle = attributes.getFloat(R.styleable.ArcView_start_angle,0f)
        completeArcAngle = attributes.getFloat(R.styleable.ArcView_last_angle,0f)
        strokeWidth = attributes.getFloat(R.styleable.ArcView_stroke_width, 0f)
        strokeColor = attributes.getColor(R.styleable.ArcView_stroke_color, Color.parseColor("#FFFFFF"))
        isInversion = attributes.getBoolean(R.styleable.ArcView_isInversion, false)
        rotateArcAngle = completeArcAngle
        attributes.recycle()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mCanvas = canvas
        rectF.set(strokeWidth / 2, strokeWidth / 2, this.width.toFloat() - strokeWidth / 2, this.height.toFloat() - strokeWidth / 2)
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = strokeWidth
        paint.color = strokeColor
        canvas?.drawArc(rectF, startAngle, sign *  rotateArcAngle, false, paint)
    }

    fun setRotateAngle(angle: Float) {
        rotateArcAngle = angle
    }

}