package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.e.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.k;
import java.util.HashMap;
import java.util.Map;

public class MBScrollView extends ScrollView implements InterBase {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f12310a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Boolean> f12311b;

    /* renamed from: c  reason: collision with root package name */
    private String f12312c = "";

    /* renamed from: com.mbridge.msdk.dycreator.baseview.MBScrollView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12313a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.mbridge.msdk.dycreator.a.c[] r0 = com.mbridge.msdk.dycreator.a.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12313a = r0
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.id     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f12313a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.background     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f12313a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.contentDescription     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f12313a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.fadingEdge     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f12313a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.visibility     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f12313a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_marginBottom     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.baseview.MBScrollView.AnonymousClass1.<clinit>():void");
        }
    }

    public MBScrollView(Context context, AttributeSet attributeSet) {
        super(context);
        this.f12310a = c.a(context, attributeSet);
        setAttributeSet(attributeSet);
        setLayoutParams(generateLayoutParams(attributeSet));
        c.a(this.f12310a, (View) this);
    }

    public String getActionDes() {
        Map<String, String> map = this.f12310a;
        if (map == null || !map.containsKey("mbridgeAction")) {
            return "";
        }
        return this.f12310a.get("mbridgeAction");
    }

    public String getBindDataDes() {
        Map<String, String> map = this.f12310a;
        if (map == null || !map.containsKey("mbridgeData")) {
            return "";
        }
        return this.f12310a.get("mbridgeData");
    }

    public String getEffectDes() {
        Map<String, String> map = this.f12310a;
        if (map == null || !map.containsKey("mbridgeEffect")) {
            return "";
        }
        return this.f12310a.get("mbridgeEffect");
    }

    public String getReportDes() {
        Map<String, String> map = this.f12310a;
        if (map == null || !map.containsKey("mbridgeReport")) {
            return "";
        }
        return this.f12310a.get("mbridgeReport");
    }

    public String getStrategyDes() {
        Map<String, String> map = this.f12310a;
        if (map == null || !map.containsKey("mbridgeStrategy")) {
            return "";
        }
        return this.f12310a.get("mbridgeStrategy");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Map<String, Boolean> map = this.f12311b;
        if (map != null && map.containsKey("mbridgeAttached") && this.f12311b.get("mbridgeAttached").booleanValue()) {
            new k.a("mbridgeAttached").a().a(this.f12312c);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Map<String, Boolean> map = this.f12311b;
        if (map != null && map.containsKey("mbridgeDetached") && this.f12311b.get("mbridgeDetached").booleanValue()) {
            new k.a("mbridgeDetached").a().a(this.f12312c);
        }
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        HashMap<String, com.mbridge.msdk.dycreator.a.c> c5 = b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i4 = 0; i4 < attributeCount; i4++) {
            com.mbridge.msdk.dycreator.a.c cVar = c5.get(attributeSet.getAttributeName(i4));
            if (cVar != null) {
                int i5 = AnonymousClass1.f12313a[cVar.ordinal()];
                if (i5 == 1) {
                    String attributeValue = attributeSet.getAttributeValue(i4);
                    if (attributeValue.startsWith("@+id/")) {
                        setId(attributeValue.substring(5).hashCode());
                    }
                } else if (i5 == 2) {
                    String attributeValue2 = attributeSet.getAttributeValue(i4);
                    if (attributeValue2.startsWith("#")) {
                        setBackgroundColor(b.a().a(attributeSet.getAttributeValue(i4)));
                    } else {
                        if (attributeValue2.startsWith("@drawable/")) {
                            attributeValue2 = attributeValue2.substring(10);
                        }
                        String file = getContext().getFilesDir().toString();
                        setBackgroundDrawable(new BitmapDrawable(BitmapFactory.decodeFile(file + "/" + attributeValue2 + ".png")));
                    }
                } else if (i5 == 3) {
                    setContentDescription(attributeSet.getAttributeValue(i4));
                }
            }
        }
    }

    public void setDynamicReport(String str, CampaignEx campaignEx) {
        this.f12311b = c.a(str);
        if (campaignEx != null) {
            this.f12312c = campaignEx.getCampaignUnitId();
        }
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        FrameLayout.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        HashMap<String, com.mbridge.msdk.dycreator.a.c> c5 = b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i4 = 0; i4 < attributeCount; i4++) {
            com.mbridge.msdk.dycreator.a.c cVar = c5.get(attributeSet.getAttributeName(i4));
            if (cVar != null) {
                Log.e("MBscrollviewparam", cVar.toString());
            }
            if (cVar != null) {
                int i5 = AnonymousClass1.f12313a[cVar.ordinal()];
                if (i5 == 4) {
                    setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i4, false));
                } else if (i5 == 5) {
                    String attributeValue = attributeSet.getAttributeValue(i4);
                    if (!TextUtils.isEmpty(attributeValue)) {
                        if (attributeValue.equals("invisible")) {
                            setVisibility(4);
                        } else if (attributeValue.equalsIgnoreCase("gone")) {
                            setVisibility(8);
                        }
                    }
                } else if (i5 == 6) {
                    generateDefaultLayoutParams.bottomMargin = b.a().b(attributeSet.getAttributeValue(i4));
                }
            }
        }
        return generateDefaultLayoutParams;
    }
}
