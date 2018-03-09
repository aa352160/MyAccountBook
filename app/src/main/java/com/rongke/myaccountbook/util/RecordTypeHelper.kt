package com.rongke.myaccountbook.util

import com.rongke.myaccountbook.R
import com.rongke.myaccountbook.bean.RecordTypeBean

/**
 * Created by jh352160 on 2018/3/9.
 */

object RecordTypeHelper{
    private val allRecordType by lazy {
        arrayOf(
                RecordTypeBean(1, R.drawable.ic_record_food,"餐饮"),
                RecordTypeBean(2, R.drawable.ic_record_transportation,"交通")
        )
    }

    fun getDefaultType() = allRecordType[0]

    fun getAllType() = allRecordType

    fun getRecordTypeById(recordId : Int) = allRecordType.filter { it.typeId == recordId }[0]
}
