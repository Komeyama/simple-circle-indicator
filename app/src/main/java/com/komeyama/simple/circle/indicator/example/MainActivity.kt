package com.komeyama.simple.circle.indicator.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.komeyama.simple.circle.indicator.ArcAnimation
import com.komeyama.simple.circle.indicator.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //indicatorCircle.circleAngle = 360f * 0.1f

        val animation = ArcAnimation(indicatorCircle)
        animation.isClockwise = true
        animation.duration = 2000
        indicatorCircle.startAnimation(animation)
    }
}
