package com.example.count

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val TAG="hello"

        var count=0

        layout.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                clock(++count)
                Log.e(TAG, "onTouch: count $count" )
                return false
            }

        })

        button.setOnClickListener {
            clock(--count)
            Log.e(TAG, "onTouch: count $count" )
        }



    }

    fun clock(count:Int){
        var n=
        when(count.toString().length){
            3-> "$count"
            2-> "0$count"
            1-> "00$count"
            else ->"error"
        }

        ones.text = n[2].toString()
        tens.text = n[1].toString()
        hundred.text= n[0].toString()
    }
}