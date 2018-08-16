package com.weixin.wuyezhiguhun.ydandroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.weixin.wuyezhiguhun.ydandroid.ydjoke.activity.YDJokeActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun buttonTouch(view: View) {
        when (view.id) {

            R.id.button_yd_joke -> {
                println("wuyezhiguhun" + " *---* " + "计算器")
                val intent = Intent(this, YDJokeActivity::class.java)
                startActivity(intent)
            }

            else -> {
                println("wuyezhiguhun" + " *---* ")
            }
        }
    }
}
