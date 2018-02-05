package com.rongke.myaccountbook.util

import android.content.Context
import android.content.Intent
import com.rongke.myaccountbook.activity.MainActivity

/**
 * Created by Administrator on 2018/1/24.
 */

object UIHelper{
    fun gotoMainActivity(context: Context){
        val intent = Intent(context,MainActivity::class.java)
        context.startActivity(intent)
    }
}