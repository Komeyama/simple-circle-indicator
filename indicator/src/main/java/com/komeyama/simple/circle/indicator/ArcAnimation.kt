package com.komeyama.simple.circle.indicator

import android.view.animation.Animation
import android.view.animation.Transformation

class ArcAnimation(private val arc: ArcView): Animation() {

    private var beforeAngle = 0f
    var isClockwise = true

    init {
        beforeAngle = arc.rotateArcAngle
        beforeAngle = 0f
    }

    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        val rotateAngle = beforeAngle + (arc.completeArcAngle - beforeAngle) * interpolatedTime
        if (isClockwise) {
            arc.setRotateAngle(rotateAngle)
        } else {
            arc.setRotateAngle((-1) * rotateAngle)
        }
        arc.requestLayout()
    }
}