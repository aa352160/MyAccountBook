package com.rongke.myaccountbook.database.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.rongke.myaccountbook.database.dao.DateRecordDao
import com.rongke.myaccountbook.database.model.DateRecordDataModel

/**
 * Created by jh352160 on 2018/2/26.
 */

@Database(entities = [DateRecordDataModel::class], version = 1, exportSchema = false)
abstract class DateRecordDataBase : RoomDatabase(){
    abstract fun dateRecordDao(): DateRecordDao

    companion object {
        private var INSTANCE: DateRecordDataBase? = null

        fun getDatabase(context: Context): DateRecordDataBase? {
            if (INSTANCE == null) {
                synchronized(DateRecordDataBase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                DateRecordDataBase::class.java, "date_record_database").build()
                    }
                }
            }
            return INSTANCE
        }
    }
}