package com.mbridge.msdk.dycreator.baseview.rewardpopview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class MBGradientAndShadowTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private int f12524a = AcquireRewardPopViewConst.DEFAULT_COLOR_FFFBED;

    /* renamed from: b  reason: collision with root package name */
    private int f12525b = AcquireRewardPopViewConst.DEFAULT_COLOR_FFBD6F;

    /* renamed from: c  reason: collision with root package name */
    private int f12526c = AcquireRewardPopViewConst.DEFAULT_COLOR_EC7501;

    /* renamed from: d  reason: collision with root package name */
    private int f12527d = 40;

    /* renamed from: e  reason: collision with root package name */
    private LinearGradient f12528e;
    public float mShadowDx = 1.5f;
    public float mShadowDy = 1.8f;
    public float mShadowRadius = 3.0f;

    public static class GradientAndShadowParameters {
        public int gradientEndColor;
        public int gradientStartColor;
        public int shadowColor;
        public float shadowDx = 1.5f;
        public float shadowDy = 1.8f;
        public float shadowRadius = 3.0f;
        public int textSize = 40;
    }

    public MBGradientAndShadowTextView(Context context) {
        super(context);
        a();
    }

    private void a() {
        setTextSize((float) this.f12527d);
        setTypeface(Typeface.defaultFromStyle(3));
        this.f12528e = new LinearGradient(0.0f, 0.0f, 0.0f, getTextSize(), this.f12524a, this.f12525b, Shader.TileMode.CLAMP);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        getPaint().setShader((Shader) null);
        getPaint().setShadowLayer(3.0f, 1.5f, 1.8f, this.f12526c);
        super.onDraw(canvas);
        getPaint().clearShadowLayer();
        getPaint().setShader(this.f12528e);
        super.onDraw(canvas);
    }

    public MBGradientAndShadowTextView(Context context, GradientAndShadowParameters gradientAndShadowParameters) {
        super(context);
        if (gradientAndShadowParameters != null) {
            this.f12524a = gradientAndShadowParameters.gradientStartColor;
            this.f12525b = gradientAndShadowParameters.gradientEndColor;
            this.f12526c = gradientAndShadowParameters.shadowColor;
            this.f12527d = gradientAndShadowParameters.textSize;
            this.mShadowRadius = gradientAndShadowParameters.shadowRadius;
            this.mShadowDx = gradientAndShadowParameters.shadowDx;
            this.mShadowDy = gradientAndShadowParameters.shadowDy;
        }
        a();
    }

    public MBGradientAndShadowTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBGradientAndShadowTextView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    @RequiresApi(api = 21)
    public MBGradientAndShadowTextView(Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
    }
}
