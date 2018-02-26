package com.rongke.myaccountbook.bean

import com.rongke.myaccountbook.util.castToTimeStr
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by jh352160 on 2018/2/26.
 */
data class MainRecordBean (val createTime : Long,val recordList : List<Any>){
    val createTimeStr : String = createTime.castToTimeStr()
}