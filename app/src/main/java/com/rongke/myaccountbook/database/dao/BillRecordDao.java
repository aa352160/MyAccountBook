package com.rongke.myaccountbook.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.rongke.myaccountbook.database.model.BillRecordDataModel;

import java.util.List;

/**
 * Created by jh352160 on 2018/2/8.
 */

@Dao
public interface BillRecordDao {
    @Insert
    void insert(BillRecordDataModel model);

    @Query("SELECT * from bill_record_table ORDER BY id ASC")
    LiveData<List<BillRecordDataModel>> getAllRecord();
}
