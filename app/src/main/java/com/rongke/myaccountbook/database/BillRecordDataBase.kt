package com.rongke.myaccountbook.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

import com.rongke.myaccountbook.database.dao.BillRecordDao
import com.rongke.myaccountbook.database.model.BillRecordDataModel

/**
 * Created by jh352160 on 2018/2/8.
 */

@Database(entities = [BillRecordDataModel::class], version = 1, exportSchema = false)
abstract class BillRecordDataBase : RoomDatabase() {

    abstract fun billRecordDao(): BillRecordDao

    companion object {
        private var INSTANCE: BillRecordDataBase? = null

        fun getDatabase(context: Context): BillRecordDataBase? {
            if (INSTANCE == null) {
                synchronized(BillRecordDataBase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                BillRecordDataBase::class.java, "bill_record_database").build()
                    }
                }
            }
            return INSTANCE
        }
    }
}
