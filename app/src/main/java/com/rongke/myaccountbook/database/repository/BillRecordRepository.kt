package com.rongke.myaccountbook.database.repository

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.LiveData

import com.rongke.myaccountbook.database.RecordDataBase
import com.rongke.myaccountbook.database.dao.BillRecordDao
import com.rongke.myaccountbook.database.model.BillRecordDataModel
import com.rongke.myaccountbook.database.model.DateRecordDataModel

/**
 * Created by jh352160 on 2018/2/9.
 */

class BillRecordRepository(application: Application) {
    private val recordDao: BillRecordDao
    val allRecord: LiveData<List<BillRecordDataModel>>

    init {
        val database = RecordDataBase.getDatabase(application)
        recordDao = database!!.billRecordDao()
        allRecord = recordDao.allRecord
    }

    @SuppressLint("StaticFieldLeak")
    fun insert(model: BillRecordDataModel) = recordDao.insert(model)

    @SuppressLint("StaticFieldLeak")
    fun findByTime(model: DateRecordDataModel) = recordDao.getRecordByTime(model.id)
}