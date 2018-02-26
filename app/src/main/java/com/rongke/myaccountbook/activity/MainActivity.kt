package com.rongke.myaccountbook.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.LinearLayoutManager
import com.rongke.baselibrary.base.BaseActivity
import com.rongke.myaccountbook.R
import com.rongke.myaccountbook.adapter.IndexAdapter
import com.rongke.myaccountbook.database.model.DateRecordDataModel
import com.rongke.myaccountbook.util.UIHelper
import com.rongke.myaccountbook.viewmodel.BillRecordViewModel
import com.rongke.myaccountbook.viewmodel.DateRecordViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {
    private val recordViewModel by lazy { ViewModelProviders.of(this).get(BillRecordViewModel::class.java) }
    private val dateRecordModel by lazy { ViewModelProviders.of(this).get(DateRecordViewModel::class.java) }

    override fun setLayoutRes(): Int = R.layout.activity_main

    override fun initView() {
        getDateRecord()
        getRecordFromDataBase()
        btn_add.setOnClickListener { UIHelper.gotoAddRecordActivity(this) }
    }

    /**
     * 获取数据库中日期数据
     */
    private fun getDateRecord() {
        dateRecordModel.allDatas.observe(this, Observer { datas -> getRecordByTime(datas) })
    }

    /**
     * 根据日期查找相应条目
     */
    private fun getRecordByTime(datas: List<DateRecordDataModel>?) {
        datas!!.forEach { recordViewModel.findByTime(it) }
    }

    private fun getRecordFromDataBase() {
        recordViewModel.allDatas.observe(this, Observer { datas ->
                recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                recycler_view.adapter = IndexAdapter(this, datas)
        })
    }
}
