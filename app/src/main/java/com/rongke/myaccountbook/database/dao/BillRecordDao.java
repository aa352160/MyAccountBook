package com.rongke.myaccountbook.database.dao;

import android.arch.persistence.room.Insert;

import com.rongke.myaccountbook.database.model.BillRecordDataModel;

/**
 * Created by jh352160 on 2018/2/8.
 */

public interface BillRecordDao {
    @Insert
    void insert(BillRecordDataModel model);
}
