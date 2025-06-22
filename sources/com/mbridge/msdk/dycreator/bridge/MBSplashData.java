package com.mbridge.msdk.dycreator.bridge;

import com.mbridge.msdk.dycreator.f.a.a;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.foundation.entity.CampaignEx;

public class MBSplashData implements a {

    /* renamed from: a  reason: collision with root package name */
    private DyOption f12574a;

    /* renamed from: b  reason: collision with root package name */
    private String f12575b;

    /* renamed from: c  reason: collision with root package name */
    private String f12576c;

    /* renamed from: d  reason: collision with root package name */
    private String f12577d;

    /* renamed from: e  reason: collision with root package name */
    private String f12578e;

    /* renamed from: f  reason: collision with root package name */
    private CampaignEx f12579f;

    /* renamed from: g  reason: collision with root package name */
    private int f12580g;

    /* renamed from: h  reason: collision with root package name */
    private int f12581h;

    /* renamed from: i  reason: collision with root package name */
    private float f12582i;

    /* renamed from: j  reason: collision with root package name */
    private float f12583j;

    /* renamed from: k  reason: collision with root package name */
    private int f12584k = 0;

    public MBSplashData(DyOption dyOption) {
        this.f12574a = dyOption;
        this.f12579f = dyOption.getCampaignEx();
    }

    public String getAdClickText() {
        return this.f12576c;
    }

    public String getAppInfo() {
        return this.f12575b;
    }

    public CampaignEx getBindData() {
        return this.f12579f;
    }

    public int getClickType() {
        return this.f12584k;
    }

    public String getCountDownText() {
        return this.f12577d;
    }

    public DyOption getDyOption() {
        return this.f12574a;
    }

    public DyOption getEffectData() {
        return this.f12574a;
    }

    public int getLogoImage() {
        return this.f12581h;
    }

    public String getLogoText() {
        return this.f12578e;
    }

    public int getNoticeImage() {
        return this.f12580g;
    }

    public float getxInScreen() {
        return this.f12582i;
    }

    public float getyInScreen() {
        return this.f12583j;
    }

    public void setAdClickText(String str) {
        this.f12576c = str;
    }

    public void setAppInfo(String str) {
        this.f12575b = str;
    }

    public void setClickType(int i4) {
        this.f12584k = i4;
    }

    public void setCountDownText(String str) {
        this.f12577d = str;
    }

    public void setLogoImage(int i4) {
        this.f12581h = i4;
    }

    public void setLogoText(String str) {
        this.f12578e = str;
    }

    public void setNoticeImage(int i4) {
        this.f12580g = i4;
    }

    public void setxInScreen(float f4) {
        this.f12582i = f4;
    }

    public void setyInScreen(float f4) {
        this.f12583j = f4;
    }
}
