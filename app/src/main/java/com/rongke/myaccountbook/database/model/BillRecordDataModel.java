package com.rongke.myaccountbook.database.model;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by jh352160 on 2018/2/8.
 */

@Entity(tableName = "bill_record_table")
public class BillRecordDataModel{
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int type;
    private boolean isIncome;
    private String price;
    private long createTime;

    public BillRecordDataModel(int type, boolean isIncome, String price) {
        this.type = type;
        this.isIncome = isIncome;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isIncome() {
        return isIncome;
    }

    public void setIncome(boolean income) {
        isIncome = income;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = System.currentTimeMillis();
    }
}
