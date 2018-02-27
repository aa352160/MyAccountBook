package com.rongke.myaccountbook.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

import com.rongke.myaccountbook.database.dao.BillRecordDao
import com.rongke.myaccountbook.database.dao.DateRecordDao
import com.rongke.myaccountbook.database.model.BillRecordDataModel
import com.rongke.myaccountbook.database.model.DateRecordDataModel

/**
 * Created by jh352160 on 2018/2/8.
 */

@Database(entities = [BillRecordDataModel::class, DateRecordDataModel::class], version = 1, exportSchema = false)
abstract class RecordDataBase : RoomDatabase() {
    abstract fun billRecordDao(): BillRecordDao
    abstract fun dateRecordDao(): DateRecordDao

    companion object {
        private var INSTANCE: RecordDataBase? = null

        fun getDatabase(context: Context): RecordDataBase? {
            if (INSTANCE == null) {
                synchronized(RecordDataBase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                RecordDataBase::class.java, "bill_record_database")
                                .allowMainThreadQueries()
                                .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}
