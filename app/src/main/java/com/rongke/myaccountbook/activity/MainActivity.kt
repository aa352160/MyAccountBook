package com.rongke.myaccountbook.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.animation.AnimationUtils
import com.rongke.baselibrary.base.BaseActivity
import com.rongke.myaccountbook.R
import com.rongke.myaccountbook.adapter.IndexAdapter
import com.rongke.myaccountbook.bean.MainRecordBean
import com.rongke.myaccountbook.database.model.BillRecordDataModel
import com.rongke.myaccountbook.database.model.DateRecordDataModel
import com.rongke.myaccountbook.util.UIHelper
import com.rongke.myaccountbook.viewmodel.BillRecordViewModel
import com.rongke.myaccountbook.viewmodel.DateRecordViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

const val ADD_BILL_RECORD = 1

class MainActivity : BaseActivity() {
    private val recordViewModel by lazy { ViewModelProviders.of(this).get(BillRecordViewModel::class.java) }
    private val dateRecordModel by lazy { ViewModelProviders.of(this).get(DateRecordViewModel::class.java) }

    private val observer = Observer<List<DateRecordDataModel>>{datas -> getRecordByTime(datas)}

    private lateinit var mainData : ArrayList<MainRecordBean>

    override fun setLayoutRes(): Int = R.layout.activity_main

    override fun initView() {
        getDateRecord()
        btn_add.setOnClickListener { UIHelper.gotoAddRecordActivity(this) }
    }

    /**
     * 获取数据库中日期数据
     */
    private fun getDateRecord() {
        val allDatas = dateRecordModel.allDatas

        if (allDatas.hasObservers()){
            allDatas.removeObserver(observer)
        }

        allDatas.observe(this, observer)
    }

    /**
     * 根据日期查找相应条目
     */
    private fun getRecordByTime(datas: List<DateRecordDataModel>?) {
        mainData = ArrayList()

        datas!!.forEach {
            val recordList = ArrayList<BillRecordDataModel>()
            recordViewModel.findByTime(it).forEach {
                recordList.add(it)
            }
            mainData.add(MainRecordBean(it.dateStr,recordList))
        }

        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = IndexAdapter(this, mainData)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == ADD_BILL_RECORD){
            getDateRecord()
        }
    }
}