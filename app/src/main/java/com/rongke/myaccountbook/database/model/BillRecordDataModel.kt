package com.rongke.myaccountbook.database.model

import android.arch.persistence.db.SupportSQLiteOpenHelper
import android.arch.persistence.room.*

/**
 * Created by jh352160 on 2018/2/8.
 */

@Entity(tableName = "bill_record_table",
        foreignKeys = [(ForeignKey(entity = DateRecordDataModel::class,
                                   parentColumns = ["id"],
                                   childColumns = ["createTimeId"]))])
data class BillRecordDataModel(var type: Int, var isIncome: Boolean, var price: String?, var createTimeId: Long) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    constructor() : this(0,false,null,System.currentTimeMillis())
}
