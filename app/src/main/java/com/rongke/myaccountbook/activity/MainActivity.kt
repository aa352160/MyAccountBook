package com.rongke.myaccountbook.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.rongke.baselibrary.base.BaseActivity
import com.rongke.myaccountbook.R
import com.rongke.myaccountbook.adapter.IndexAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recycler_view.adapter = IndexAdapter(this, listOf("","","","","","",""))
    }
}
