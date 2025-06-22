package com.mbridge.msdk.video.dynview.widget;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.mbridge.msdk.video.dynview.moffer.b;
import com.mbridge.msdk.video.dynview.moffer.d;

public class MBridgeRelativeLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private d f16230a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f16231b;

    /* renamed from: c  reason: collision with root package name */
    private AnimatorSet f16232c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f16233d;

    /* renamed from: e  reason: collision with root package name */
    private b f16234e;

    public MBridgeRelativeLayout(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AnimatorSet animatorSet = this.f16232c;
        if (animatorSet != null) {
            try {
                animatorSet.start();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        d dVar;
        super.onDetachedFromWindow();
        if (!this.f16231b && (dVar = this.f16230a) != null) {
            this.f16231b = true;
            dVar.a();
        }
        AnimatorSet animatorSet = this.f16232c;
        if (animatorSet != null) {
            try {
                animatorSet.cancel();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(@NonNull View view, int i4) {
        b bVar;
        super.onVisibilityChanged(view, i4);
        if ((view instanceof MBridgeRelativeLayout) && i4 == 0 && (bVar = this.f16234e) != null && !this.f16233d) {
            this.f16233d = true;
            bVar.a();
        }
    }

    public void setAnimatorSet(AnimatorSet animatorSet) {
        this.f16232c = animatorSet;
    }

    public void setMoreOfferCacheReportCallBack(b bVar) {
        this.f16234e = bVar;
    }

    public void setMoreOfferShowFailedCallBack(d dVar) {
        this.f16230a = dVar;
    }

    public MBridgeRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBridgeRelativeLayout(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }
}
