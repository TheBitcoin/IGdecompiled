package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class MBSplashShakeView extends MBLinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private final String f12344a = "浏览第三方应用";

    /* renamed from: b  reason: collision with root package name */
    private final String f12345b = "View";

    /* renamed from: c  reason: collision with root package name */
    private final String f12346c = "打开第三方应用";

    /* renamed from: d  reason: collision with root package name */
    private final String f12347d = "Open";

    /* renamed from: e  reason: collision with root package name */
    private final String f12348e = "下载第三方应用";

    /* renamed from: f  reason: collision with root package name */
    private final String f12349f = "Install";

    /* renamed from: g  reason: collision with root package name */
    private ImageView f12350g;

    /* renamed from: h  reason: collision with root package name */
    private Animation f12351h;

    public MBSplashShakeView(Context context) {
        super(context);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0111, code lost:
        if (r11.equals("Open") == false) goto L_0x00e1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = "浏览第三方应用"
            java.lang.String r1 = "View"
            r2 = 1
            r10.setOrientation(r2)
            r10.setGravity(r2)
            android.widget.ImageView r3 = new android.widget.ImageView
            android.content.Context r4 = r10.getContext()
            r3.<init>(r4)
            android.widget.LinearLayout$LayoutParams r4 = new android.widget.LinearLayout$LayoutParams
            android.content.Context r5 = r10.getContext()
            r6 = 1117782016(0x42a00000, float:80.0)
            int r5 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r5, (float) r6)
            android.content.Context r7 = r10.getContext()
            int r6 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r7, (float) r6)
            r4.<init>(r5, r6)
            r3.setLayoutParams(r4)
            java.lang.String r4 = "#60000000"
            int r4 = android.graphics.Color.parseColor(r4)
            android.graphics.drawable.GradientDrawable r5 = new android.graphics.drawable.GradientDrawable
            r5.<init>()
            r5.setColor(r4)
            r4 = 200(0xc8, float:2.8E-43)
            float r4 = (float) r4
            r5.setCornerRadius(r4)
            r3.setBackground(r5)
            android.widget.ImageView r4 = new android.widget.ImageView
            android.content.Context r5 = r10.getContext()
            r4.<init>(r5)
            r10.f12350g = r4
            android.widget.FrameLayout$LayoutParams r4 = new android.widget.FrameLayout$LayoutParams
            android.content.Context r5 = r10.getContext()
            r6 = 1109393408(0x42200000, float:40.0)
            int r5 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r5, (float) r6)
            android.content.Context r7 = r10.getContext()
            int r6 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r7, (float) r6)
            r4.<init>(r5, r6)
            r5 = 17
            r4.gravity = r5
            android.widget.ImageView r6 = r10.f12350g
            r6.setLayoutParams(r4)
            android.content.res.Resources r4 = r10.getResources()
            com.mbridge.msdk.foundation.controller.c r6 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r6 = r6.g()
            java.lang.String r7 = "mbridge_cm_btn_shake"
            java.lang.String r8 = "drawable"
            int r4 = r4.getIdentifier(r7, r8, r6)
            android.widget.ImageView r6 = r10.f12350g
            r6.setImageResource(r4)
            android.widget.FrameLayout r4 = new android.widget.FrameLayout
            android.content.Context r6 = r10.getContext()
            r4.<init>(r6)
            android.widget.LinearLayout$LayoutParams r6 = new android.widget.LinearLayout$LayoutParams
            r7 = -2
            r6.<init>(r7, r7)
            r4.setLayoutParams(r6)
            r4.addView(r3)
            android.widget.ImageView r3 = r10.f12350g
            r4.addView(r3)
            android.widget.TextView r3 = new android.widget.TextView
            android.content.Context r6 = r10.getContext()
            r3.<init>(r6)
            android.widget.LinearLayout$LayoutParams r6 = new android.widget.LinearLayout$LayoutParams
            r6.<init>(r7, r7)
            android.content.Context r8 = r10.getContext()
            r9 = 1092616192(0x41200000, float:10.0)
            int r8 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r8, (float) r9)
            r6.topMargin = r8
            r3.setLayoutParams(r6)
            r3.setGravity(r5)
            java.lang.String r6 = "Shake your phone"
            r3.setText(r6)
            r6 = 1098907648(0x41800000, float:16.0)
            r3.setTextSize(r6)
            r6 = -1
            r3.setTextColor(r6)
            boolean r8 = android.text.TextUtils.isEmpty(r11)
            if (r8 != 0) goto L_0x0121
            r11.getClass()
            int r8 = r11.hashCode()
            switch(r8) {
                case -672744069: goto L_0x0114;
                case 2464362: goto L_0x010b;
                case 2666181: goto L_0x0102;
                case 855294846: goto L_0x00f7;
                case 1383132195: goto L_0x00ec;
                case 1681333335: goto L_0x00e3;
                default: goto L_0x00e1;
            }
        L_0x00e1:
            r2 = -1
            goto L_0x011e
        L_0x00e3:
            boolean r2 = r11.equals(r0)
            if (r2 != 0) goto L_0x00ea
            goto L_0x00e1
        L_0x00ea:
            r2 = 5
            goto L_0x011e
        L_0x00ec:
            java.lang.String r2 = "打开第三方应用"
            boolean r2 = r11.equals(r2)
            if (r2 != 0) goto L_0x00f5
            goto L_0x00e1
        L_0x00f5:
            r2 = 4
            goto L_0x011e
        L_0x00f7:
            java.lang.String r2 = "下载第三方应用"
            boolean r2 = r11.equals(r2)
            if (r2 != 0) goto L_0x0100
            goto L_0x00e1
        L_0x0100:
            r2 = 3
            goto L_0x011e
        L_0x0102:
            boolean r2 = r11.equals(r1)
            if (r2 != 0) goto L_0x0109
            goto L_0x00e1
        L_0x0109:
            r2 = 2
            goto L_0x011e
        L_0x010b:
            java.lang.String r8 = "Open"
            boolean r8 = r11.equals(r8)
            if (r8 != 0) goto L_0x011e
            goto L_0x00e1
        L_0x0114:
            java.lang.String r2 = "Install"
            boolean r2 = r11.equals(r2)
            if (r2 != 0) goto L_0x011d
            goto L_0x00e1
        L_0x011d:
            r2 = 0
        L_0x011e:
            switch(r2) {
                case 0: goto L_0x013e;
                case 1: goto L_0x013e;
                case 2: goto L_0x013e;
                case 3: goto L_0x013e;
                case 4: goto L_0x013e;
                case 5: goto L_0x013e;
                default: goto L_0x0121;
            }
        L_0x0121:
            android.content.Context r11 = r10.getContext()
            android.content.res.Resources r11 = r11.getResources()
            android.content.res.Configuration r11 = r11.getConfiguration()
            java.util.Locale r11 = r11.locale
            java.lang.String r11 = r11.getLanguage()
            java.lang.String r2 = "zh"
            boolean r11 = r11.contains(r2)
            if (r11 == 0) goto L_0x013d
            r11 = r0
            goto L_0x013e
        L_0x013d:
            r11 = r1
        L_0x013e:
            android.widget.TextView r0 = new android.widget.TextView
            android.content.Context r1 = r10.getContext()
            r0.<init>(r1)
            android.widget.LinearLayout$LayoutParams r1 = new android.widget.LinearLayout$LayoutParams
            r1.<init>(r7, r7)
            android.content.Context r2 = r10.getContext()
            r7 = 1084227584(0x40a00000, float:5.0)
            int r2 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r2, (float) r7)
            r1.topMargin = r2
            r0.setLayoutParams(r1)
            r0.setGravity(r5)
            r0.setText(r11)
            r11 = 1094713344(0x41400000, float:12.0)
            r0.setTextSize(r11)
            r0.setTextColor(r6)
            r10.addView(r4)
            r10.addView(r3)
            r10.addView(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.baseview.MBSplashShakeView.initView(java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f12350g != null) {
            RotateAnimation rotateAnimation = new RotateAnimation(-10.0f, 10.0f, 1, 0.5f, 1, 0.5f);
            this.f12351h = rotateAnimation;
            rotateAnimation.setDuration(100);
            this.f12351h.setRepeatMode(2);
            this.f12351h.setRepeatCount(-1);
            this.f12350g.startAnimation(this.f12351h);
        }
    }

    public MBSplashShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBSplashShakeView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }
}
