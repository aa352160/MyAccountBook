package com.rongke.myaccountbook.activity

import com.rongke.baselibrary.base.BaseActivity
import com.rongke.myaccountbook.R
import kotlinx.android.synthetic.main.activity_add_record.*

/**
 * Created by jh352160 on 2018/2/6.
 */

class AddRecordActivity : BaseActivity(){
    override fun setLayoutRes(): Int = R.layout.activity_add_record

    override fun initView() {
        btn_back.setOnClickListener { finish() }
        btn_save.setOnClickListener {

        }
    }
}
