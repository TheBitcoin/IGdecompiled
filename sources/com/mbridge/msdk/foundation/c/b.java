package com.mbridge.msdk.foundation.c;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.out.MBridgeIds;
import java.io.Serializable;
import java.util.HashMap;

public final class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private int f12749a;

    /* renamed from: b  reason: collision with root package name */
    private int f12750b;

    /* renamed from: c  reason: collision with root package name */
    private String f12751c;

    /* renamed from: d  reason: collision with root package name */
    private Throwable f12752d;

    /* renamed from: e  reason: collision with root package name */
    private CampaignEx f12753e;

    /* renamed from: f  reason: collision with root package name */
    private MBridgeIds f12754f;

    /* renamed from: g  reason: collision with root package name */
    private String f12755g;

    /* renamed from: h  reason: collision with root package name */
    private String f12756h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f12757i;

    /* renamed from: j  reason: collision with root package name */
    private int f12758j = -1;

    /* renamed from: k  reason: collision with root package name */
    private String f12759k;

    /* renamed from: l  reason: collision with root package name */
    private HashMap<Object, Object> f12760l;

    /* renamed from: m  reason: collision with root package name */
    private int f12761m;

    /* renamed from: n  reason: collision with root package name */
    private String f12762n;

    /* renamed from: o  reason: collision with root package name */
    private String f12763o;

    /* renamed from: p  reason: collision with root package name */
    private String f12764p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f12765q;

    public b(int i4) {
        this.f12749a = i4;
        this.f12750b = a.b(i4);
    }

    public final int a() {
        return this.f12749a;
    }

    public final String b() {
        String str;
        int i4;
        if (!TextUtils.isEmpty(this.f12751c)) {
            str = this.f12751c;
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str) && (i4 = this.f12749a) != -1) {
            str = a.a(i4);
        }
        Throwable th = this.f12752d;
        if (th == null) {
            return str;
        }
        String message = th.getMessage();
        if (TextUtils.isEmpty(message)) {
            return str;
        }
        return str + " # " + message;
    }

    public final CampaignEx c() {
        return this.f12753e;
    }

    public final MBridgeIds d() {
        if (this.f12754f == null) {
            this.f12754f = new MBridgeIds();
        }
        return this.f12754f;
    }

    public final int e() {
        return this.f12750b;
    }

    public final String f() {
        return this.f12756h;
    }

    public final int g() {
        return this.f12758j;
    }

    public final String h() {
        return this.f12759k;
    }

    public final int i() {
        return this.f12761m;
    }

    public final String j() {
        return this.f12762n;
    }

    public final String k() {
        return this.f12763o;
    }

    public final String l() {
        return this.f12764p;
    }

    public final boolean m() {
        return this.f12765q;
    }

    public final String toString() {
        return "MBFailureReason{errorCode=" + this.f12749a + ", errorSubType=" + this.f12750b + ", message='" + this.f12751c + '\'' + ", cause=" + this.f12752d + ", campaign=" + this.f12753e + ", ids=" + this.f12754f + ", requestId='" + this.f12755g + '\'' + ", localRequestId='" + this.f12756h + '\'' + ", isHeaderBidding=" + this.f12757i + ", typeD=" + this.f12758j + ", reasonD='" + this.f12759k + '\'' + ", extraMap=" + this.f12760l + ", serverErrorCode=" + this.f12761m + ", errorUrl='" + this.f12762n + '\'' + ", serverErrorResponse='" + this.f12763o + '\'' + '}';
    }

    public final void a(String str) {
        this.f12751c = str;
    }

    public final void c(String str) {
        this.f12759k = str;
    }

    public final void e(String str) {
        this.f12763o = str;
    }

    public final void f(String str) {
        this.f12764p = str;
    }

    public final void a(Throwable th) {
        this.f12752d = th;
    }

    public final void a(CampaignEx campaignEx) {
        this.f12753e = campaignEx;
    }

    public final void d(String str) {
        this.f12762n = str;
    }

    public b(int i4, String str) {
        this.f12749a = i4;
        if (!TextUtils.isEmpty(str)) {
            a("his_reason", str);
        }
        this.f12751c = str;
        this.f12750b = a.b(i4);
    }

    public final void a(MBridgeIds mBridgeIds) {
        this.f12754f = mBridgeIds;
    }

    public final void a(boolean z4) {
        this.f12757i = z4;
    }

    public final void a(Object obj, Object obj2) {
        if (this.f12760l == null) {
            this.f12760l = new HashMap<>();
        }
        this.f12760l.put(obj, obj2);
    }

    public final Object a(Object obj) {
        HashMap<Object, Object> hashMap = this.f12760l;
        if (hashMap != null && hashMap.containsKey(obj)) {
            return this.f12760l.get(obj);
        }
        return null;
    }

    public final void b(String str) {
        this.f12756h = str;
    }

    public b(int i4, int i5, String str) {
        if (!TextUtils.isEmpty(str)) {
            a("his_reason", str);
            this.f12751c = str;
        } else {
            this.f12751c = a.a(i5);
        }
        this.f12761m = i4;
        this.f12750b = a.b(i5);
    }

    public final void b(boolean z4) {
        this.f12765q = z4;
    }

    public final void a(int i4) {
        this.f12758j = i4;
    }
}
