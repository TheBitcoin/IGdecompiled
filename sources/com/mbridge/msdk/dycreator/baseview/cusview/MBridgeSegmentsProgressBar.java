package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.x;
import java.util.ArrayList;
import java.util.List;

public class MBridgeSegmentsProgressBar extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private final String f12440a = "MBridgeSegmentsProgressBar";

    /* renamed from: b  reason: collision with root package name */
    private int f12441b;

    /* renamed from: c  reason: collision with root package name */
    private int f12442c = 1;

    /* renamed from: d  reason: collision with root package name */
    private int f12443d = 20;

    /* renamed from: e  reason: collision with root package name */
    private int f12444e = 10;

    /* renamed from: f  reason: collision with root package name */
    private int f12445f = 1;

    /* renamed from: g  reason: collision with root package name */
    private int f12446g = -1711276033;

    /* renamed from: h  reason: collision with root package name */
    private int f12447h = -1;

    /* renamed from: i  reason: collision with root package name */
    private List<ProgressBar> f12448i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    private TextView f12449j;

    /* renamed from: k  reason: collision with root package name */
    private String f12450k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f12451l = false;

    public MBridgeSegmentsProgressBar(Context context) {
        super(context);
    }

    private void a() {
        Drawable drawable;
        try {
            this.f12451l = getContext().getResources().getConfiguration().locale.getLanguage().contains("zh");
        } catch (Throwable th) {
            af.b("MBridgeSegmentsProgressBar", th.getMessage());
        }
        try {
            if (this.f12442c == 1) {
                setOrientation(1);
                if (TextUtils.isEmpty(this.f12450k)) {
                    this.f12450k = this.f12451l ? "正在播放第%s个，共%s个视频" : "The %s is playing, %s videos.";
                }
            }
            if (this.f12442c == 2) {
                setOrientation(0);
                if (TextUtils.isEmpty(this.f12450k)) {
                    this.f12450k = this.f12451l ? "广告 %s/%s" : "ADS %s/%s";
                }
            }
            this.f12448i.clear();
            removeAllViews();
            setBackground(c());
            TextView textView = new TextView(getContext());
            this.f12449j = textView;
            textView.setTextColor(-1);
            this.f12449j.setTextSize(12.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.f12449j.setLayoutParams(layoutParams);
            if (this.f12442c == 1) {
                layoutParams.gravity = 5;
                TextView textView2 = this.f12449j;
                int i4 = this.f12443d;
                textView2.setPadding(i4 / 2, 15, i4 / 2, 5);
            }
            if (this.f12442c == 2) {
                this.f12449j.setGravity(16);
                TextView textView3 = this.f12449j;
                int i5 = this.f12443d;
                textView3.setPadding(i5 / 2, 0, i5 / 2, 0);
            }
            int a5 = x.a(getContext(), "mbridge_reward_video_icon", "drawable");
            if (!(a5 == 0 || (drawable = getContext().getResources().getDrawable(a5)) == null)) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.f12449j.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                this.f12449j.setCompoundDrawablePadding(5);
            }
        } catch (Throwable th2) {
            af.b("MBridgeSegmentsProgressBar", th2.getMessage());
            return;
        }
        this.f12449j.setText(a(this.f12445f));
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 25);
        linearLayout.setLayoutParams(layoutParams2);
        for (int i6 = 0; i6 < this.f12441b; i6++) {
            ProgressBar progressBar = new ProgressBar(getContext(), (AttributeSet) null, 16842872);
            progressBar.setMax(100);
            progressBar.setProgress(0);
            progressBar.setProgressDrawable(b());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, 20, 1.0f);
            int i7 = this.f12443d;
            layoutParams3.leftMargin = i7 / 2;
            layoutParams3.rightMargin = i7 / 2;
            progressBar.setLayoutParams(layoutParams3);
            linearLayout.addView(progressBar);
            this.f12448i.add(progressBar);
        }
        int i8 = this.f12442c;
        if (i8 == 1) {
            setPadding(15, 10, 15, 25);
            addView(this.f12449j);
            addView(linearLayout);
        } else if (i8 == 2) {
            setPadding(15, 0, 15, 25);
            layoutParams2.gravity = 16;
            layoutParams2.weight = 1.0f;
            addView(linearLayout);
            addView(this.f12449j);
        } else {
            addView(linearLayout);
        }
    }

    private LayerDrawable b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius((float) this.f12444e);
        gradientDrawable.setColor(this.f12446g);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius((float) this.f12444e);
        gradientDrawable2.setColor(this.f12447h);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, new ScaleDrawable(gradientDrawable2, 3, 1.0f, -1.0f)});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908301);
        return layerDrawable;
    }

    private GradientDrawable c() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setDither(true);
        gradientDrawable.setColors(new int[]{0, 1291845632});
        return gradientDrawable;
    }

    public void dismiss() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                MBridgeSegmentsProgressBar.this.setVisibility(8);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        startAnimation(alphaAnimation);
    }

    public void init(int i4, int i5) {
        this.f12441b = i4;
        this.f12442c = i5;
        a();
    }

    public void setIndicatorText(String str) {
        this.f12450k = str;
    }

    public void setProgress(int i4, int i5) {
        try {
            if (this.f12448i.size() != 0) {
                if (i5 < this.f12448i.size()) {
                    this.f12448i.get(i5).setProgress(i4);
                }
                int i6 = i5 + 1;
                if (i6 > this.f12445f) {
                    this.f12445f = i6;
                    TextView textView = this.f12449j;
                    if (textView != null) {
                        textView.setText(a(i6));
                    }
                }
            }
        } catch (Throwable th) {
            af.b("MBridgeSegmentsProgressBar", th.getMessage());
        }
    }

    public void init(int i4, int i5, int i6, int i7) {
        this.f12441b = i4;
        this.f12442c = i5;
        this.f12447h = i6;
        this.f12446g = i7;
        a();
    }

    public void init(int i4, int i5, int i6, int i7, int i8, int i9) {
        this.f12441b = i4;
        this.f12442c = i5;
        this.f12447h = i6;
        this.f12446g = i7;
        this.f12443d = i8;
        this.f12444e = i9;
        a();
    }

    public MBridgeSegmentsProgressBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBridgeSegmentsProgressBar(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    @RequiresApi(api = 21)
    public MBridgeSegmentsProgressBar(Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
    }

    private StringBuilder a(int i4) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(String.format(this.f12450k, new Object[]{Integer.valueOf(i4), Integer.valueOf(this.f12441b)}));
            return sb;
        } catch (Throwable th) {
            sb.append(this.f12441b);
            sb.append("videos, the");
            sb.append(i4);
            sb.append(" is playing.");
            af.b("MBridgeSegmentsProgressBar", th.getMessage());
            return sb;
        }
    }
}
