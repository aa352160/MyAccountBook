package com.rongke.myaccountbook.database;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.rongke.myaccountbook.database.dao.BillRecordDao;
import com.rongke.myaccountbook.database.model.BillRecordDataModel;

/**
 * Created by jh352160 on 2018/2/8.
 */

public abstract class BillRecordDataBase extends RoomDatabase{
    private static BillRecordDataBase INSTANCE;

    static BillRecordDataBase getDatabase(final Context context){
        if (INSTANCE == null) {
            synchronized (BillRecordDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BillRecordDataBase.class,"bill_record_database").build();
                }
            }
        }
    }

    public abstract BillRecordDao billRecordDao();
}
