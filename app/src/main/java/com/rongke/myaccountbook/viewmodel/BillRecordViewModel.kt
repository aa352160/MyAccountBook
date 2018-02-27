package com.rongke.myaccountbook.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData

import com.rongke.myaccountbook.database.model.BillRecordDataModel
import com.rongke.myaccountbook.database.model.DateRecordDataModel
import com.rongke.myaccountbook.database.repository.BillRecordRepository

/**
 * Created by jh352160 on 2018/2/9.
 */

class BillRecordViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: BillRecordRepository
    val allDatas: LiveData<List<BillRecordDataModel>>

    init {
        repository = BillRecordRepository(application)
        allDatas = repository.allRecord
    }

    fun insert(model: BillRecordDataModel) = repository.insert(model)

    fun findByTime(model: DateRecordDataModel) = repository.findByTime(model)
}
