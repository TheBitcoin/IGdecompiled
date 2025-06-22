package com.google.firebase.messaging;

import R.k;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.adid.h;
import java.util.concurrent.Executor;
import k0.C0937l;
import k0.C0940o;

/* renamed from: com.google.firebase.messaging.n  reason: case insensitive filesystem */
public class C1800n {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f11408c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static n0 f11409d;

    /* renamed from: a  reason: collision with root package name */
    private final Context f11410a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f11411b = new h();

    public C1800n(Context context) {
        this.f11410a = context;
    }

    public static /* synthetic */ C0937l a(Context context, Intent intent, boolean z4, C0937l lVar) {
        if (!k.h() || ((Integer) lVar.j()).intValue() != 402) {
            return lVar;
        }
        return e(context, intent, z4).g(new h(), new C1798l());
    }

    public static /* synthetic */ Integer c(C0937l lVar) {
        return -1;
    }

    public static /* synthetic */ Integer d(C0937l lVar) {
        return 403;
    }

    private static C0937l e(Context context, Intent intent, boolean z4) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Binding to service");
        }
        n0 f4 = f(context, "com.google.firebase.MESSAGING_EVENT");
        if (!z4) {
            return f4.d(intent).g(new h(), new C1799m());
        }
        if (X.b().e(context)) {
            i0.e(context, f4, intent);
        } else {
            f4.d(intent);
        }
        return C0940o.e(-1);
    }

    private static n0 f(Context context, String str) {
        n0 n0Var;
        synchronized (f11408c) {
            try {
                if (f11409d == null) {
                    f11409d = new n0(context, str);
                }
                n0Var = f11409d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return n0Var;
    }

    public C0937l g(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        return h(this.f11410a, intent);
    }

    public C0937l h(Context context, Intent intent) {
        boolean z4;
        boolean z5 = false;
        if (!k.h() || context.getApplicationInfo().targetSdkVersion < 26) {
            z4 = false;
        } else {
            z4 = true;
        }
        if ((intent.getFlags() & 268435456) != 0) {
            z5 = true;
        }
        if (!z4 || z5) {
            return C0940o.c(this.f11411b, new C1796j(context, intent)).h(this.f11411b, new C1797k(context, intent, z5));
        }
        return e(context, intent, z5);
    }
}
