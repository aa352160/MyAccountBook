package com.rongke.myaccountbook.listener

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.rongke.myaccountbook.R.id.edt_price
import kotlinx.android.synthetic.main.activity_add_record.*

/**
 * Created by jh352160 on 2018/3/1.
 */

class MoneyEditTextWatcher(val edtText : EditText) : TextWatcher {
    private var oringinStr = ""

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        oringinStr = s.toString()
    }

    override fun afterTextChanged(s: Editable?) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (s == null) return

        //如果第一个字符就是'.',清空输入框
        if (s[0] == '.'){
            edtText.text.clear()
            return
        }

        //最后一个字符为点，在最后补上0
        if (s.toString()[s.length -1] == '.'){
            edtText.text.append('0')
            return
        }

        val split = s.split('.')
        if (split.size>1 && split[1].length > 2){
            edtText.setText(oringinStr)
        }
    }
}
