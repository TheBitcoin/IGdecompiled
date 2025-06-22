package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;

public final class B {

    /* renamed from: a  reason: collision with root package name */
    final String f2316a;

    /* renamed from: b  reason: collision with root package name */
    final String f2317b;

    /* renamed from: c  reason: collision with root package name */
    final String f2318c;

    /* renamed from: d  reason: collision with root package name */
    final long f2319d;

    /* renamed from: e  reason: collision with root package name */
    final long f2320e;

    /* renamed from: f  reason: collision with root package name */
    final D f2321f;

    B(S2 s22, String str, String str2, String str3, long j4, long j5, Bundle bundle) {
        D d5;
        C0335p.f(str2);
        C0335p.f(str3);
        this.f2316a = str2;
        this.f2317b = str3;
        this.f2318c = TextUtils.isEmpty(str) ? null : str;
        this.f2319d = j4;
        this.f2320e = j5;
        if (j5 != 0 && j5 > j4) {
            s22.a().L().b("Event created with reverse previous/current timestamps. appId", C0821n2.s(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            d5 = new D(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    s22.a().G().a("Param name can't be null");
                    it.remove();
                } else {
                    Object s02 = s22.L().s0(next, bundle2.get(next));
                    if (s02 == null) {
                        s22.a().L().b("Param value can't be null", s22.D().f(next));
                        it.remove();
                    } else {
                        s22.L().O(bundle2, next, s02);
                    }
                }
            }
            d5 = new D(bundle2);
        }
        this.f2321f = d5;
    }

    /* access modifiers changed from: package-private */
    public final B a(S2 s22, long j4) {
        return new B(s22, this.f2318c, this.f2316a, this.f2317b, this.f2319d, j4, this.f2321f);
    }

    public final String toString() {
        String str = this.f2316a;
        String str2 = this.f2317b;
        String valueOf = String.valueOf(this.f2321f);
        return "Event{appId='" + str + "', name='" + str2 + "', params=" + valueOf + "}";
    }

    private B(S2 s22, String str, String str2, String str3, long j4, long j5, D d5) {
        C0335p.f(str2);
        C0335p.f(str3);
        C0335p.l(d5);
        this.f2316a = str2;
        this.f2317b = str3;
        this.f2318c = TextUtils.isEmpty(str) ? null : str;
        this.f2319d = j4;
        this.f2320e = j5;
        if (j5 != 0 && j5 > j4) {
            s22.a().L().c("Event created with reverse previous/current timestamps. appId, name", C0821n2.s(str2), C0821n2.s(str3));
        }
        this.f2321f = d5;
    }
}
