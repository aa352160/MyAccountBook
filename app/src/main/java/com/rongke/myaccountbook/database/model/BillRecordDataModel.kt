package com.rongke.myaccountbook.database.model

import android.arch.persistence.db.SupportSQLiteOpenHelper
import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.DatabaseConfiguration
import android.arch.persistence.room.Entity
import android.arch.persistence.room.InvalidationTracker
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.RoomDatabase

/**
 * Created by jh352160 on 2018/2/8.
 */

@Entity(tableName = "bill_record_table")
data class BillRecordDataModel(var type: Int, var isIncome: Boolean, var price: String?, var createTimeId: Long) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    constructor() : this(0,false,null,System.currentTimeMillis())
}
