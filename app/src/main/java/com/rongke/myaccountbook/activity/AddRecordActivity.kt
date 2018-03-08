package com.rongke.myaccountbook.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import com.rongke.baselibrary.base.BaseActivity
import com.rongke.baselibrary.util.CommonUtil
import com.rongke.myaccountbook.R
import com.rongke.myaccountbook.database.model.BillRecordDataModel
import com.rongke.myaccountbook.database.model.DateRecordDataModel
import com.rongke.myaccountbook.listener.MoneyEditTextWatcher
import com.rongke.myaccountbook.util.BILL_RECORD_TYPE_DINING
import com.rongke.myaccountbook.util.castToTimeStr
import com.rongke.myaccountbook.view.TypeChoosePopupWindow
import com.rongke.myaccountbook.viewmodel.BillRecordViewModel
import com.rongke.myaccountbook.viewmodel.DateRecordViewModel
import kotlinx.android.synthetic.main.activity_add_record.*
import java.math.BigDecimal

/**
 * Created by jh352160 on 2018/2/6.
 */

class AddRecordActivity : BaseActivity(){
    private val recordViewModel by lazy { ViewModelProviders.of(this).get(BillRecordViewModel::class.java) }
    private val dateRecordModel by lazy { ViewModelProviders.of(this).get(DateRecordViewModel::class.java) }

    override fun setLayoutRes(): Int = R.layout.activity_add_record

    override fun initView() {
        edt_price.addTextChangedListener(MoneyEditTextWatcher(edt_price))

        iv_record_type.setOnClickListener { v ->
            TypeChoosePopupWindow(this).show(v)
        }

        btn_save.setOnClickListener {
            if (checkInput()) {
                checkDate(System.currentTimeMillis().castToTimeStr())
            }
        }
    }

    private fun checkInput(): Boolean {
        if (edt_price.text.toString().isEmpty()){
            CommonUtil.showToast(this,"请填写金额")
            return false
        }
        return true
    }

    /**
     * 判断当前日期在数据库中是否存在
     */
    private fun checkDate(currentTime: String){
        dateRecordModel.allDatas.observe(this, object : Observer<List<DateRecordDataModel>>{
            override fun onChanged(datas: List<DateRecordDataModel>?) {
                dateRecordModel.allDatas.removeObserver(this)
                datas?.forEach {
                    if (it.dateStr == currentTime) {
                        insertBillRecordToDataBase(it.id)
                        return
                    }
                }
                insertBillRecordToDataBase(-1)
            }
        })
    }

    /**
     * 将记录插入数据库
     * @param _dateId 日期id,如果该日期在数据库中不存在则插入新数据
     */
    private fun insertBillRecordToDataBase(_dateId : Long) {
        var dateId = _dateId
        if (dateId == -1L){
            dateId = dateRecordModel.insert(
                    DateRecordDataModel(System.currentTimeMillis().castToTimeStr()))
        }

        val price = BigDecimal(edt_price.text.toString()).setScale(2).toString()
        val title = edt_title.text.toString()
        val model = BillRecordDataModel(BILL_RECORD_TYPE_DINING,false,price,title,dateId,System.currentTimeMillis())
        recordViewModel.insert(model)

        setResult(ADD_BILL_RECORD)
        finish()
    }
}
