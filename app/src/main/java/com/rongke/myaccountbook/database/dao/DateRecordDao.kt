package com.rongke.myaccountbook.database.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.rongke.myaccountbook.database.model.BillRecordDataModel
import com.rongke.myaccountbook.database.model.DateRecordDataModel

/**
 * Created by jh352160 on 2018/2/26.
 */

@Dao
interface DateRecordDao {
    @Query("SELECT * from date_record_table ORDER BY id DESC")
    fun allDateRecord(): LiveData<List<DateRecordDataModel>>

    @Insert
    fun insert(model: DateRecordDataModel) : Long
}