package com.google.android.gms.auth.api.signin;

import D.a;
import G.o;
import J.C0308g;
import J.C0313l;
import K.e;
import K.f;
import L.C0317a;
import M.C0334o;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.dynamite.DynamiteModule;
import k0.C0937l;

public class b extends e {

    /* renamed from: k  reason: collision with root package name */
    private static final f f1233k = new f((F.e) null);

    /* renamed from: l  reason: collision with root package name */
    static int f1234l = 1;

    b(Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, a.f183b, googleSignInOptions, new e.a.C0002a().b(new C0317a()).a());
    }

    private final synchronized int t() {
        int i4;
        try {
            i4 = f1234l;
            if (i4 == 1) {
                Context i5 = i();
                C0308g n4 = C0308g.n();
                int h4 = n4.h(i5, C0313l.f342a);
                if (h4 == 0) {
                    i4 = 4;
                    f1234l = 4;
                } else if (n4.b(i5, h4, (String) null) != null || DynamiteModule.a(i5, "com.google.android.gms.auth.api.fallback") == 0) {
                    i4 = 2;
                    f1234l = 2;
                } else {
                    i4 = 3;
                    f1234l = 3;
                }
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return i4;
    }

    public Intent q() {
        Context i4 = i();
        int t4 = t();
        int i5 = t4 - 1;
        if (t4 == 0) {
            throw null;
        } else if (i5 == 2) {
            return o.a(i4, (GoogleSignInOptions) h());
        } else {
            if (i5 != 3) {
                return o.b(i4, (GoogleSignInOptions) h());
            }
            return o.c(i4, (GoogleSignInOptions) h());
        }
    }

    public C0937l r() {
        boolean z4;
        f b5 = b();
        Context i4 = i();
        if (t() == 3) {
            z4 = true;
        } else {
            z4 = false;
        }
        return C0334o.b(o.e(b5, i4, z4));
    }

    public C0937l s() {
        boolean z4;
        f b5 = b();
        Context i4 = i();
        if (t() == 3) {
            z4 = true;
        } else {
            z4 = false;
        }
        return C0334o.b(o.f(b5, i4, z4));
    }
}
