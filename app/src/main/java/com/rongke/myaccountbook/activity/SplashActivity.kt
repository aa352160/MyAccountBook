package com.rongke.myaccountbook.activity

import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.rongke.baselibrary.base.BaseActivity
import com.rongke.myaccountbook.R
import com.rongke.myaccountbook.util.UIHelper

/**
 * Created by jh352160 on 2018/1/24.
 */

class SplashActivity : BaseActivity() {
    override fun setLayoutRes(): Int = R.layout.activity_splash

    override fun initView() {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        startCountDown()
    }

    private fun startCountDown() {
        Handler().postDelayed({ UIHelper.gotoMainActivity(this@SplashActivity) },3000)
    }
}