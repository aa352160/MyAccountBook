package com.rongke.myaccountbook.database.repository;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.rongke.myaccountbook.database.BillRecordDataBase;
import com.rongke.myaccountbook.database.dao.BillRecordDao;
import com.rongke.myaccountbook.database.model.BillRecordDataModel;

import java.util.List;

/**
 * Created by jh352160 on 2018/2/9.
 */

public class BillRecordRepository {
    private BillRecordDao recordDao;
    private LiveData<List<BillRecordDataModel>> allRecord;

    public BillRecordRepository(Application application){
        BillRecordDataBase database = BillRecordDataBase.getDatabase(application);
        recordDao = database.billRecordDao();
        allRecord = recordDao.getAllRecord();
    }

    public LiveData<List<BillRecordDataModel>> getAllRecord() {
        return allRecord;
    }

    @SuppressLint("StaticFieldLeak")
    public void insert(BillRecordDataModel model){
        new AsyncTask<BillRecordDataModel,Void,Void>(){
            @Override
            protected Void doInBackground(BillRecordDataModel... billRecordDataModels) {
                recordDao.insert(billRecordDataModels[0]);
                return null;
            }
        }.execute(model);
    }
}