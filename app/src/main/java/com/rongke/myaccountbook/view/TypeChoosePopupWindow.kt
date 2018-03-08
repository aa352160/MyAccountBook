package com.rongke.myaccountbook.view

import android.app.Activity
import android.view.*
import android.widget.*
import com.rongke.baselibrary.util.DisplayUtil
import com.rongke.myaccountbook.R

/**
 * Created by jh352160 on 2018/3/8.
 */

class TypeChoosePopupWindow(val context : Activity) : PopupWindow(context){
    init {
        isFocusable = true
        setBackgroundDrawable(null)
        contentView = LayoutInflater.from(context).inflate(R.layout.popup_window_type_choose,null)

        popOutShadow()
        for(i in 0..5){
            (contentView.rootView as GridLayout).addView(getItemView())
        }
    }

    private fun getItemView() : View{
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
        imageView.setImageDrawable(context.getDrawable(R.drawable.ic_record_food))
        imageView.setBackgroundColor(context.getColor(R.color.primary_font_color))
        view.addView(imageView)

        val textView = TextView(context)
        val tvLayoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        textView.layoutParams = tvLayoutParams
        tvLayoutParams.gravity = Gravity.CENTER_HORIZONTAL.or(Gravity.BOTTOM)
        textView.textSize = 13f
        textView.setTextColor(context.getColor(R.color.primary_font_color))
        textView.text = "餐饮"
        view.addView(textView)

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
