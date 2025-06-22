package com.mbridge.msdk.dycreator.baseview;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.baseview.inter.InterEffect;
import com.mbridge.msdk.dycreator.e.a;
import com.mbridge.msdk.dycreator.e.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.tools.af;
import java.util.HashMap;
import java.util.Map;

public class MBFrameLayout extends FrameLayout implements InterBase, InterEffect {

    /* renamed from: a  reason: collision with root package name */
    private Animator f12266a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, String> f12267b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Boolean> f12268c;

    /* renamed from: d  reason: collision with root package name */
    private String f12269d = "";

    /* renamed from: com.mbridge.msdk.dycreator.baseview.MBFrameLayout$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12270a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.mbridge.msdk.dycreator.a.c[] r0 = com.mbridge.msdk.dycreator.a.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12270a = r0
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_width     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f12270a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_height     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f12270a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_gravity     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f12270a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_marginLeft     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f12270a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_margin     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.baseview.MBFrameLayout.AnonymousClass1.<clinit>():void");
        }
    }

    public MBFrameLayout(Context context, AttributeSet attributeSet) {
        super(context);
        try {
            this.f12267b = c.a(context, attributeSet);
            a.a(this, attributeSet);
            setLayoutParams(generateLayoutParams(attributeSet));
            c.a(this.f12267b, (View) this);
        } catch (Exception e5) {
            af.b("MBFrameLayout", e5.getMessage());
        }
    }

    public String getActionDes() {
        Map<String, String> map = this.f12267b;
        if (map == null || !map.containsKey("mbridgeAction")) {
            return "";
        }
        return this.f12267b.get("mbridgeAction");
    }

    public String getBindDataDes() {
        Map<String, String> map = this.f12267b;
        if (map == null || !map.containsKey("mbridgeData")) {
            return "";
        }
        return this.f12267b.get("mbridgeData");
    }

    public String getEffectDes() {
        Map<String, String> map = this.f12267b;
        if (map == null || !map.containsKey("mbridgeEffect")) {
            return "";
        }
        return this.f12267b.get("mbridgeEffect");
    }

    public String getReportDes() {
        Map<String, String> map = this.f12267b;
        if (map == null || !map.containsKey("mbridgeReport")) {
            return "";
        }
        return this.f12267b.get("mbridgeReport");
    }

    public String getStrategyDes() {
        Map<String, String> map = this.f12267b;
        if (map == null || !map.containsKey("mbridgeStrategy")) {
            return "";
        }
        return this.f12267b.get("mbridgeStrategy");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            Animator animator = this.f12266a;
            if (animator != null) {
                animator.start();
            }
        } catch (Exception e5) {
            af.b("MBFrameLayout", e5.getMessage());
        }
        Map<String, Boolean> map = this.f12268c;
        if (map != null && map.containsKey("mbridgeAttached") && this.f12268c.get("mbridgeAttached").booleanValue()) {
            new k.a("mbridgeAttached").a().a(this.f12269d);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            Animator animator = this.f12266a;
            if (animator != null) {
                animator.cancel();
            }
        } catch (Exception e5) {
            af.b("MBFrameLayout", e5.getMessage());
        }
        Map<String, Boolean> map = this.f12268c;
        if (map != null && map.containsKey("mbridgeDetached") && this.f12268c.get("mbridgeDetached").booleanValue()) {
            new k.a("mbridgeDetached").a().a(this.f12269d);
        }
    }

    public void setAnimator(Animator animator) {
        this.f12266a = animator;
    }

    public void setDynamicReport(String str, CampaignEx campaignEx) {
        this.f12268c = c.a(str);
        if (campaignEx != null) {
            this.f12269d = campaignEx.getCampaignUnitId();
        }
    }

    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, 0);
        HashMap b5 = b.a().b();
        layoutParams.width = -2;
        layoutParams.height = -2;
        int attributeCount = attributeSet.getAttributeCount();
        for (int i4 = 0; i4 < attributeCount; i4++) {
            com.mbridge.msdk.dycreator.a.c cVar = (com.mbridge.msdk.dycreator.a.c) b5.get(attributeSet.getAttributeName(i4));
            if (cVar != null) {
                int i5 = AnonymousClass1.f12270a[cVar.ordinal()];
                if (i5 == 1) {
                    String attributeValue = attributeSet.getAttributeValue(i4);
                    if (attributeValue.startsWith("f") || attributeValue.startsWith("m")) {
                        layoutParams.width = -1;
                    } else if (attributeValue.startsWith("w")) {
                        layoutParams.width = -2;
                    } else {
                        layoutParams.width = b.a().b(attributeValue);
                    }
                } else if (i5 == 2) {
                    String attributeValue2 = attributeSet.getAttributeValue(i4);
                    if (attributeValue2.startsWith("f") || attributeValue2.startsWith("m")) {
                        layoutParams.width = -1;
                    } else if (attributeValue2.startsWith("w")) {
                        layoutParams.width = -2;
                    } else {
                        layoutParams.height = b.a().b(attributeValue2);
                    }
                } else if (i5 == 3) {
                    layoutParams.gravity = b.a().c(attributeSet.getAttributeValue(i4));
                } else if (i5 == 4) {
                    layoutParams.leftMargin = b.a().b(attributeSet.getAttributeValue(i4));
                } else if (i5 == 5) {
                    int b6 = b.a().b(attributeSet.getAttributeValue(i4));
                    layoutParams.setMargins(b6, b6, b6, b6);
                }
            }
        }
        return layoutParams;
    }
}
