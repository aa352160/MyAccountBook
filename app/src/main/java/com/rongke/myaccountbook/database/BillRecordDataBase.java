package com.rongke.myaccountbook.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.rongke.myaccountbook.database.dao.BillRecordDao;
import com.rongke.myaccountbook.database.model.BillRecordDataModel;

/**
 * Created by jh352160 on 2018/2/8.
 */

@Database(entities = {BillRecordDataModel.class}, version = 1, exportSchema = false)
public abstract class BillRecordDataBase extends RoomDatabase{
    private static BillRecordDataBase INSTANCE;

    public static BillRecordDataBase getDatabase(final Context context){
        if (INSTANCE == null) {
            synchronized (BillRecordDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BillRecordDataBase.class,"bill_record_database").build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract BillRecordDao billRecordDao();
}
