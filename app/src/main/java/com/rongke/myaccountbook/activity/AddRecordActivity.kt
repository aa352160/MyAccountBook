package com.rongke.myaccountbook.activity

import android.arch.lifecycle.ViewModelProviders
import android.widget.Toast
import com.rongke.baselibrary.base.BaseActivity
import com.rongke.baselibrary.util.CommonUtil
import com.rongke.myaccountbook.R
import com.rongke.myaccountbook.database.model.BillRecordDataModel
import com.rongke.myaccountbook.util.BILL_RECORD_TYPE_DINING
import com.rongke.myaccountbook.viewmodel.BillRecordViewModel
import kotlinx.android.synthetic.main.activity_add_record.*

/**
 * Created by jh352160 on 2018/2/6.
 */

class AddRecordActivity : BaseActivity(){
    private val recordViewModel by lazy { ViewModelProviders.of(this).get(BillRecordViewModel::class.java) }

    override fun setLayoutRes(): Int = R.layout.activity_add_record

    override fun initView() {
        btn_save.setOnClickListener {
            if (checkInput()) insertBillRecordToDataBase()
        }
    }

    private fun checkInput(): Boolean {
        if (edt_price.text.toString().isEmpty()){
            CommonUtil.showToast(this,"请填写金额")
            return false
        }
        return true
    }

    private fun insertBillRecordToDataBase() {
        val model = BillRecordDataModel(
                BILL_RECORD_TYPE_DINING,false,edt_price.text.toString(),System.currentTimeMillis())
        recordViewModel.insert(model)
    }
}
