package com.rongke.myaccountbook.util

import android.content.Context
import android.widget.Toast
import com.rongke.baselibrary.base.BaseActivity
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by jh352160 on 2018/2/9.
 */

fun Long.castToTimeStr() : String = SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(Date(this))
