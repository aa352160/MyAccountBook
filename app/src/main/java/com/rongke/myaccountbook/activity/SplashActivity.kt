package com.rongke.myaccountbook.activity

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.rongke.myaccountbook.R
import com.rongke.myaccountbook.util.UIHelper

/**
 * Created by Administrator on 2018/1/24.
 */

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        startCountDown()
    }

    private fun startCountDown() {
//        object : CountDownTimer(3000,3000) {
//            override fun onTick(millisUntilFinished: Long) {}
//            override fun onFinish() {
//            }
//        }.start()

        Handler().postDelayed({ UIHelper.gotoMainActivity(this@SplashActivity) },3000)
    }
}