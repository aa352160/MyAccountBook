package com.rongke.myaccountbook.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.rongke.myaccountbook.database.model.DateRecordDataModel
import com.rongke.myaccountbook.database.repository.DateRecordRepository

/**
 * Created by jh352160 on 2018/2/26.
 */
class DateRecordViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: DateRecordRepository
    val allDatas: LiveData<List<DateRecordDataModel>>

    init {
        repository = DateRecordRepository(application)
        allDatas = repository.allRecord
    }

    fun insert(model: DateRecordDataModel) = repository.insert(model)
}