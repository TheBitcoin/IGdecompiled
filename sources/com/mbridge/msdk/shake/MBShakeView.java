package com.mbridge.msdk.shake;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.ak;

public class MBShakeView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Animation f15424a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f15425b;

    public MBShakeView(Context context) {
        super(context);
    }

    public void initView(String str) {
        initView(str, false);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        RotateAnimation rotateAnimation = new RotateAnimation(-10.0f, 10.0f, 1, 0.5f, 1, 0.5f);
        this.f15424a = rotateAnimation;
        rotateAnimation.setDuration(100);
        this.f15424a.setRepeatMode(2);
        this.f15424a.setRepeatCount(-1);
        this.f15425b.startAnimation(this.f15424a);
    }

    public MBShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void initView(String str, boolean z4) {
        setOrientation(1);
        setGravity(1);
        ImageView imageView = new ImageView(getContext());
        float f4 = 80.0f;
        int a5 = ak.a(getContext(), z4 ? 60.0f : 80.0f);
        Context context = getContext();
        if (z4) {
            f4 = 60.0f;
        }
        imageView.setLayoutParams(new LinearLayout.LayoutParams(a5, ak.a(context, f4)));
        int parseColor = Color.parseColor("#80000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(parseColor);
        gradientDrawable.setCornerRadius((float) 200);
        imageView.setBackground(gradientDrawable);
        this.f15425b = new ImageView(getContext());
        float f5 = 40.0f;
        float f6 = 20.0f;
        int a6 = ak.a(getContext(), z4 ? 20.0f : 40.0f);
        Context context2 = getContext();
        if (z4) {
            f5 = 20.0f;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a6, ak.a(context2, f5));
        layoutParams.gravity = 17;
        this.f15425b.setLayoutParams(layoutParams);
        this.f15425b.setImageResource(getResources().getIdentifier("mbridge_cm_btn_shake", "drawable", c.m().g()));
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        frameLayout.addView(imageView);
        frameLayout.addView(this.f15425b);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = ak.a(getContext(), 10.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(17);
        if (getContext().getResources().getConfiguration().locale.getLanguage().contains("zh")) {
            textView.setText("摇动手机 或 点击图标");
        } else {
            textView.setText("Shake your phone");
        }
        float f7 = 16.0f;
        if (z4) {
            f6 = 16.0f;
        }
        textView.setTextSize(f6);
        textView.setTextColor(-1);
        textView.setShadowLayer(8.0f, 3.0f, 3.0f, ViewCompat.MEASURED_STATE_MASK);
        if (TextUtils.isEmpty(str)) {
            str = getContext().getResources().getConfiguration().locale.getLanguage().contains("zh") ? "浏览第三方应用" : "Redirect to third party application";
        }
        TextView textView2 = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = ak.a(getContext(), 5.0f);
        textView2.setLayoutParams(layoutParams3);
        textView2.setGravity(17);
        textView2.setText(str);
        if (z4) {
            f7 = 12.0f;
        }
        textView2.setTextSize(f7);
        textView2.setTextColor(-1);
        textView2.setShadowLayer(8.0f, 3.0f, 3.0f, ViewCompat.MEASURED_STATE_MASK);
        addView(frameLayout);
        addView(textView);
        addView(textView2);
    }

    public MBShakeView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    @RequiresApi(api = 21)
    public MBShakeView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
    }
}
