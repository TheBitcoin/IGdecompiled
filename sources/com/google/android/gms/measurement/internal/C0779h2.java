package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.os.Bundle;
import f0.i;
import f0.q;
import f0.r;
import f0.s;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.h2  reason: case insensitive filesystem */
public final class C0779h2 {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReference f3009b = new AtomicReference();

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReference f3010c = new AtomicReference();

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicReference f3011d = new AtomicReference();

    /* renamed from: a  reason: collision with root package name */
    private final i f3012a;

    public C0779h2(i iVar) {
        this.f3012a = iVar;
    }

    private static String d(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        boolean z4;
        String str2;
        C0335p.l(strArr);
        C0335p.l(strArr2);
        C0335p.l(atomicReference);
        if (strArr.length == strArr2.length) {
            z4 = true;
        } else {
            z4 = false;
        }
        C0335p.a(z4);
        for (int i4 = 0; i4 < strArr.length; i4++) {
            if (Objects.equals(str, strArr[i4])) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = (String[]) atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        if (strArr3[i4] == null) {
                            strArr3[i4] = strArr2[i4] + "(" + strArr[i4] + ")";
                        }
                        str2 = strArr3[i4];
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    private final String e(Object[] objArr) {
        String str;
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Bundle bundle : objArr) {
            if (bundle instanceof Bundle) {
                str = a(bundle);
            } else {
                str = String.valueOf(bundle);
            }
            if (str != null) {
                if (sb.length() != 1) {
                    sb.append(", ");
                }
                sb.append(str);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final String a(Bundle bundle) {
        String str;
        if (bundle == null) {
            return null;
        }
        if (!this.f3012a.A()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle[{");
        for (String next : bundle.keySet()) {
            if (sb.length() != 8) {
                sb.append(", ");
            }
            sb.append(f(next));
            sb.append("=");
            Object obj = bundle.get(next);
            if (obj instanceof Bundle) {
                str = e(new Object[]{obj});
            } else if (obj instanceof Object[]) {
                str = e((Object[]) obj);
            } else if (obj instanceof ArrayList) {
                str = e(((ArrayList) obj).toArray());
            } else {
                str = String.valueOf(obj);
            }
            sb.append(str);
        }
        sb.append("}]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final String b(E e5) {
        String str = null;
        if (e5 == null) {
            return null;
        }
        if (!this.f3012a.A()) {
            return e5.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("origin=");
        sb.append(e5.f2368c);
        sb.append(",name=");
        sb.append(c(e5.f2366a));
        sb.append(",params=");
        D d5 = e5.f2367b;
        if (d5 != null) {
            if (!this.f3012a.A()) {
                str = d5.toString();
            } else {
                str = a(d5.j());
            }
        }
        sb.append(str);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final String c(String str) {
        if (str == null) {
            return null;
        }
        if (!this.f3012a.A()) {
            return str;
        }
        return d(str, q.f3381c, q.f3379a, f3009b);
    }

    /* access modifiers changed from: protected */
    public final String f(String str) {
        if (str == null) {
            return null;
        }
        if (!this.f3012a.A()) {
            return str;
        }
        return d(str, s.f3386b, s.f3385a, f3010c);
    }

    /* access modifiers changed from: protected */
    public final String g(String str) {
        if (str == null) {
            return null;
        }
        if (!this.f3012a.A()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return d(str, r.f3384b, r.f3383a, f3011d);
        }
        return "experiment_id" + "(" + str + ")";
    }
}
