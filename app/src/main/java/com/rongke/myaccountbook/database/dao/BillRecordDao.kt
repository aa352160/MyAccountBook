package com.rongke.myaccountbook.database.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

import com.rongke.myaccountbook.database.model.BillRecordDataModel

/**
 * Created by jh352160 on 2018/2/8.
 */

@Dao
interface BillRecordDao {
    @get:Query("SELECT * from bill_record_table ORDER BY id ASC")
    val allRecord: LiveData<List<BillRecordDataModel>>

    @Insert
    fun insert(model: BillRecordDataModel) : Long

    @Query("SELECT * from bill_record_table WHERE createTimeId = :arg0 ")
    fun getRecordByTime(createTimeId : Long): List<BillRecordDataModel>
}
