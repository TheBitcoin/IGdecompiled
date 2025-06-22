package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.e.a;
import com.mbridge.msdk.dycreator.e.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.tools.af;
import java.util.HashMap;
import java.util.Map;

public class MBImageView extends ImageView implements InterBase {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Boolean> f12279a;

    /* renamed from: b  reason: collision with root package name */
    private String f12280b = "";

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f12281c;

    /* renamed from: com.mbridge.msdk.dycreator.baseview.MBImageView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12282a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.mbridge.msdk.dycreator.a.c[] r0 = com.mbridge.msdk.dycreator.a.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12282a = r0
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_width     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f12282a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_height     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f12282a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.visibility     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.baseview.MBImageView.AnonymousClass1.<clinit>():void");
        }
    }

    public MBImageView(Context context, AttributeSet attributeSet) {
        super(context);
        if (!(context == null || attributeSet == null)) {
            try {
                this.f12281c = c.a(context, attributeSet);
            } catch (Exception e5) {
                af.b("MBImageView", e5.getMessage());
                return;
            }
        }
        a.a(this, attributeSet);
        setLayoutParams(generateLayoutParams(context, attributeSet));
        c.a(this.f12281c, (View) this);
    }

    public ViewGroup.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        HashMap<String, com.mbridge.msdk.dycreator.a.c> c5 = b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i4 = 0; i4 < attributeCount; i4++) {
            com.mbridge.msdk.dycreator.a.c cVar = c5.get(attributeSet.getAttributeName(i4));
            if (cVar != null) {
                int i5 = AnonymousClass1.f12282a[cVar.ordinal()];
                if (i5 == 1) {
                    String attributeValue = attributeSet.getAttributeValue(i4);
                    if (attributeValue.startsWith("f") || attributeValue.startsWith("m")) {
                        layoutParams.width = -1;
                    } else if (attributeValue.startsWith("wrap")) {
                        layoutParams.width = -2;
                    } else {
                        layoutParams.width = b.a().b(attributeValue);
                    }
                } else if (i5 == 2) {
                    String attributeValue2 = attributeSet.getAttributeValue(i4);
                    if (attributeValue2.startsWith("f") || attributeValue2.startsWith("m")) {
                        layoutParams.height = -1;
                    } else if (attributeValue2.startsWith("wrap")) {
                        layoutParams.height = -2;
                    } else {
                        layoutParams.height = b.a().b(attributeValue2);
                    }
                } else if (i5 == 3) {
                    String attributeValue3 = attributeSet.getAttributeValue(i4);
                    if (!TextUtils.isEmpty(attributeValue3)) {
                        if (attributeValue3.equals("invisible")) {
                            setVisibility(4);
                        } else if (attributeValue3.equalsIgnoreCase("gone")) {
                            setVisibility(8);
                        }
                    }
                }
            }
        }
        return layoutParams;
    }

    public String getActionDes() {
        Map<String, String> map = this.f12281c;
        if (map == null || !map.containsKey("mbridgeAction")) {
            return "";
        }
        return this.f12281c.get("mbridgeAction");
    }

    public String getBindDataDes() {
        Map<String, String> map = this.f12281c;
        if (map == null || !map.containsKey("mbridgeData")) {
            return "";
        }
        return this.f12281c.get("mbridgeData");
    }

    public String getEffectDes() {
        Map<String, String> map = this.f12281c;
        if (map == null || !map.containsKey("mbridgeEffect")) {
            return "";
        }
        return this.f12281c.get("mbridgeEffect");
    }

    public String getReportDes() {
        Map<String, String> map = this.f12281c;
        if (map == null || !map.containsKey("mbridgeReport")) {
            return "";
        }
        return this.f12281c.get("mbridgeReport");
    }

    public String getStrategyDes() {
        Map<String, String> map = this.f12281c;
        if (map == null || !map.containsKey("mbridgeStrategy")) {
            return "";
        }
        return this.f12281c.get("mbridgeStrategy");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Map<String, Boolean> map = this.f12279a;
        if (map != null && map.containsKey("mbridgeAttached") && this.f12279a.get("mbridgeAttached").booleanValue()) {
            new k.a("mbridgeAttached").a().a(this.f12280b);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Map<String, Boolean> map = this.f12279a;
        if (map != null && map.containsKey("mbridgeDetached") && this.f12279a.get("mbridgeDetached").booleanValue()) {
            new k.a("mbridgeDetached").a().a(this.f12280b);
        }
    }

    public void setDynamicReport(String str, CampaignEx campaignEx) {
        this.f12279a = c.a(str);
        if (campaignEx != null) {
            this.f12280b = campaignEx.getCampaignUnitId();
        }
    }
}
