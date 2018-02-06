package com.rongke.baselibrary.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by jh352160 on 2018/2/6.
 */

public class BaseImageView extends android.support.v7.widget.AppCompatImageView {
    private Context context;

    public BaseImageView(Context context) {
        this(context, null);
    }

    public BaseImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }


}
