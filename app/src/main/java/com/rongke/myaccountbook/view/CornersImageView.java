package com.rongke.myaccountbook.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by jh352160 on 2018/2/5.
 */

public class CornersImageView extends android.support.v7.widget.AppCompatImageView {
    private GradientDrawable drawable;

    public CornersImageView(Context context) {
        super(context);
    }

    public CornersImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (drawable == null){
            drawable = new GradientDrawable();
            drawable.setShape(GradientDrawable.RECTANGLE);
            drawable.setSize(getWidth(),getHeight());
            drawable.setCornerRadii(new float[]{20,20,20,20,20,20,20,20});
        }
    }
}
