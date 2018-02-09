package com.rongke.myaccountbook.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.rongke.baselibrary.base.BaseActivity
import com.rongke.myaccountbook.R
import com.rongke.myaccountbook.adapter.IndexAdapter
import com.rongke.myaccountbook.util.UIHelper
import com.rongke.myaccountbook.viewmodel.BillRecordViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {
    private val recordViewModel by lazy { ViewModelProviders.of(this).get(BillRecordViewModel::class.java) }

    override fun setLayoutRes(): Int = R.layout.activity_main

    override fun initView() {
        getRecordFromDataBase()
        btn_add.setOnClickListener { UIHelper.gotoAddRecordActivity(this) }
    }

    private fun getRecordFromDataBase() {
        recordViewModel.allDatas.observe(this, Observer { datas ->
                recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                recycler_view.adapter = IndexAdapter(this, datas)
        })

//        recycler_view.adapter = IndexAdapter(this, listOf("","","","","","",""))
    }
}
