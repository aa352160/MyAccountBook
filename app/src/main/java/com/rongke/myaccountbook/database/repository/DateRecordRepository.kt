package com.rongke.myaccountbook.database.repository

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.rongke.myaccountbook.database.dao.BillRecordDao
import com.rongke.myaccountbook.database.dao.DateRecordDao
import com.rongke.myaccountbook.database.database.BillRecordDataBase
import com.rongke.myaccountbook.database.database.DateRecordDataBase
import com.rongke.myaccountbook.database.model.BillRecordDataModel
import com.rongke.myaccountbook.database.model.DateRecordDataModel

/**
 * Created by jh352160 on 2018/2/26.
 */
class DateRecordRepository(application: Application) {
    private val recordDao: DateRecordDao
    val allRecord: LiveData<List<DateRecordDataModel>>

    init {
        val database = DateRecordDataBase.getDatabase(application)
        recordDao = database!!.dateRecordDao()
        allRecord = recordDao.allDateRecord()
    }

    @SuppressLint("StaticFieldLeak")
    fun insert(model: DateRecordDataModel) {
        object : AsyncTask<DateRecordDataModel, Void, Void>() {
            override fun doInBackground(vararg dateRecordDataModels: DateRecordDataModel): Void? {
                recordDao.insert(dateRecordDataModels[0])
                return null
            }
        }.execute(model)
    }
}