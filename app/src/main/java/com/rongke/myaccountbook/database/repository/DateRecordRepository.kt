package com.rongke.myaccountbook.database.repository

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.LiveData
import com.rongke.myaccountbook.database.dao.DateRecordDao
import com.rongke.myaccountbook.database.RecordDataBase
import com.rongke.myaccountbook.database.model.DateRecordDataModel

/**
 * Created by jh352160 on 2018/2/26.
 */
class DateRecordRepository(application: Application) {
    private val recordDao: DateRecordDao
    val allRecord: LiveData<List<DateRecordDataModel>>

    init {
        val database = RecordDataBase.getDatabase(application)
        recordDao = database!!.dateRecordDao()
        allRecord = recordDao.allDateRecord()
    }

    @SuppressLint("StaticFieldLeak")
    fun insert(model: DateRecordDataModel) = recordDao.insert(model)
}