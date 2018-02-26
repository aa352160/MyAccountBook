package com.rongke.myaccountbook.database.repository

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask

import com.rongke.myaccountbook.database.database.BillRecordDataBase
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
        val database = BillRecordDataBase.getDatabase(application)
        recordDao = database!!.billRecordDao()
        allRecord = recordDao.allRecord
    }

    @SuppressLint("StaticFieldLeak")
    fun insert(model: BillRecordDataModel) {
        object : AsyncTask<BillRecordDataModel, Void, Void>() {
            override fun doInBackground(vararg billRecordDataModels: BillRecordDataModel): Void? {
                recordDao.insert(billRecordDataModels[0])
                return null
            }
        }.execute(model)
    }

    @SuppressLint("StaticFieldLeak")
    fun findByTime(model: DateRecordDataModel) {
        object : AsyncTask<DateRecordDataModel, Void, List<BillRecordDataModel>>() {
            override fun doInBackground(vararg dateRecordDataModel: DateRecordDataModel): List<BillRecordDataModel>? {
                return recordDao.getRecordByTime(dateRecordDataModel[0].id)
            }
        }.execute(model)
    }
}