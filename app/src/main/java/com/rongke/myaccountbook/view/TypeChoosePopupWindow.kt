package com.rongke.myaccountbook.view

import android.app.Activity
import android.support.v4.widget.PopupWindowCompat.showAsDropDown
import android.view.*
import android.widget.*
import com.rongke.baselibrary.util.DisplayUtil
import com.rongke.myaccountbook.R
import com.rongke.myaccountbook.bean.RecordTypeBean
import com.rongke.myaccountbook.util.RecordTypeHelper

/**
 * Created by jh352160 on 2018/3/8.
 */

class TypeChoosePopupWindow(private val context : Activity,
                            private val onTypeChoose : (RecordTypeBean) -> Unit) : PopupWindow(context){
    init {
        isFocusable = true
        setBackgroundDrawable(null)
        contentView = LayoutInflater.from(context).inflate(R.layout.popup_window_type_choose,null)

        popOutShadow()

        RecordTypeHelper.getAllType().forEach {
            (contentView.rootView as GridLayout).addView(getItemView(it)) }
    }

    private fun getItemView(bean: RecordTypeBean): View{
        val view = FrameLayout(context)
        view.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)

        val imageView = ImageView(context)
        val ivLayoutParams = FrameLayout.LayoutParams(
                DisplayUtil.dip2px(context,45f),DisplayUtil.dip2px(context,45f))
        ivLayoutParams.setMargins(DisplayUtil.dip2px(context,5f),
                                  DisplayUtil.dip2px(context,5f),
                                  DisplayUtil.dip2px(context,5f),
                                  DisplayUtil.dip2px(context,20f))
        ivLayoutParams.gravity = Gravity.NO_GRAVITY
        imageView.layoutParams = ivLayoutParams
        imageView.setImageDrawable(context.getDrawable(bean.typeImgResId))
        view.addView(imageView)

        val textView = TextView(context)
        val tvLayoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        textView.layoutParams = tvLayoutParams
        tvLayoutParams.gravity = Gravity.CENTER_HORIZONTAL.or(Gravity.BOTTOM)
        textView.textSize = 13f
        textView.setTextColor(context.getColor(R.color.primary_font_color))
        textView.text = bean.typeName
        view.addView(textView)

        view.setOnClickListener {
            onTypeChoose(bean)
            dismiss()
        }

        return view
    }

    /**
     * 除去popupWindow外的区域以阴影显示
     */
    private fun popOutShadow() {
        val layoutParam = context.window.attributes
        layoutParam.alpha = 0.7f
        context.window.attributes = layoutParam
        setOnDismissListener {
            layoutParam.alpha = 1f
            context.window.attributes = layoutParam
        }
    }

    fun show(anchorView : View){
        showAsDropDown(anchorView)
    }
}
