package com.rongke.myaccountbook.activity

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.content.DialogInterface
import android.view.View

import com.rongke.myaccountbook.database.model.DateRecordDataModel

/**
 * Created by jh352160 on 2018/2/28.
 */

class TempClass {
    private val liveData: LiveData<List<DateRecordDataModel>>? = null

    fun test() {
        object : Observer<List<DateRecordDataModel>> {
            override fun onChanged(dateRecordDataModels: List<DateRecordDataModel>?) {
                liveData!!.removeObserver(this)
            }
        }
    }
}
