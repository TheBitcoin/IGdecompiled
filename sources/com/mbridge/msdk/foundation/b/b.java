package com.mbridge.msdk.foundation.b;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.z;
import java.util.concurrent.CopyOnWriteArrayList;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private CopyOnWriteArrayList<CampaignEx> f12725a;

    /* renamed from: b  reason: collision with root package name */
    private double f12726b;

    /* renamed from: c  reason: collision with root package name */
    private String f12727c;

    /* renamed from: d  reason: collision with root package name */
    private String f12728d;

    /* renamed from: e  reason: collision with root package name */
    private int f12729e;

    /* renamed from: f  reason: collision with root package name */
    private long f12730f;

    /* renamed from: g  reason: collision with root package name */
    private int f12731g;

    /* renamed from: h  reason: collision with root package name */
    private long f12732h;

    /* renamed from: i  reason: collision with root package name */
    private String f12733i;

    /* renamed from: j  reason: collision with root package name */
    private long f12734j;

    public final long a() {
        return this.f12734j;
    }

    public final CopyOnWriteArrayList<CampaignEx> b() {
        return this.f12725a;
    }

    public final double c() {
        return this.f12726b;
    }

    public final String d() {
        return this.f12727c;
    }

    public final String e() {
        return this.f12728d;
    }

    public final int f() {
        return this.f12729e;
    }

    public final int g() {
        return this.f12731g;
    }

    public final long h() {
        return this.f12732h;
    }

    public final void a(long j4) {
        this.f12734j = j4;
    }

    public final void b(String str) {
        this.f12727c = str;
    }

    public final void c(String str) {
        this.f12728d = str;
    }

    public final void d(String str) {
        this.f12733i = str;
    }

    public final void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        this.f12725a = copyOnWriteArrayList;
    }

    public final void b(int i4) {
        this.f12731g = i4;
    }

    public final void c(long j4) {
        this.f12730f = j4;
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String a5 = z.a(str);
            if (!TextUtils.isEmpty(a5)) {
                try {
                    double parseDouble = Double.parseDouble(a5);
                    if (parseDouble > 0.0d) {
                        this.f12726b = parseDouble;
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public final void b(long j4) {
        this.f12732h = j4;
    }

    public final void a(int i4) {
        this.f12729e = i4;
    }
}
