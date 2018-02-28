package com.rongke.myaccountbook.database.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by jh352160 on 2018/2/9.
 */

@Entity(tableName = "date_record_table")
data class DateRecordDataModel(var dateStr : String){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    constructor() : this("")
}