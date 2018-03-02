package com.rongke.myaccountbook.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.rongke.myaccountbook.activity.AddRecordActivity
import com.rongke.myaccountbook.activity.MainActivity

/**
 * Created by jh352160 on 2018/1/24.
 */

object UIHelper{
    /**
     * 首页
     */
    fun gotoMainActivity(context: Context){
        val intent = Intent(context,MainActivity::class.java)
        context.startActivity(intent)
    }

    /**
     * 添加记录页面
     */
    fun gotoAddRecordActivity(context: Activity){
        val intent = Intent(context,AddRecordActivity::class.java)
        context.startActivityForResult(intent,1)
    }
}