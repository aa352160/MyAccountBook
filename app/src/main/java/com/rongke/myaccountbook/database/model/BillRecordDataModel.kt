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
/**
 * @param type : 记录类型（如餐饮等）
 * @param isIncome : true 收入，false 支出
 */
data class BillRecordDataModel(var type: Int, var isIncome: Boolean, var price: String?,
                               var title:String?, var createTimeId: Long, var createTimeDetail: Long) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    constructor() : this(0,false,null,null,0,System.currentTimeMillis())
}
