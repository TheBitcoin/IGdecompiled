package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.support.v4.media.a;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.w3  reason: case insensitive filesystem */
public final class C0699w3 implements C0519b3 {

    /* renamed from: g  reason: collision with root package name */
    private static final Map f2229g = new ArrayMap();

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f2230a;

    /* renamed from: b  reason: collision with root package name */
    private final Runnable f2231b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedPreferences.OnSharedPreferenceChangeListener f2232c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f2233d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private volatile Map f2234e;

    /* renamed from: f  reason: collision with root package name */
    private final List f2235f = new ArrayList();

    private C0699w3(SharedPreferences sharedPreferences, Runnable runnable) {
        C0691v3 v3Var = new C0691v3(this);
        this.f2232c = v3Var;
        this.f2230a = sharedPreferences;
        this.f2231b = runnable;
        sharedPreferences.registerOnSharedPreferenceChangeListener(v3Var);
    }

    private static SharedPreferences a(Context context, String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (str.startsWith("direct_boot:")) {
                if (S2.a()) {
                    context = context.createDeviceProtectedStorageContext();
                }
                SharedPreferences a5 = C0720z0.a(context, str.substring(12), 0, C0688v0.f2203a);
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return a5;
            }
            SharedPreferences a6 = C0720z0.a(context, str, 0, C0688v0.f2203a);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return a6;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
    }

    static C0699w3 b(Context context, String str, Runnable runnable) {
        boolean z4;
        C0699w3 w3Var;
        if (!S2.a() || str.startsWith("direct_boot:")) {
            z4 = true;
        } else {
            z4 = S2.c(context);
        }
        if (!z4) {
            return null;
        }
        synchronized (C0699w3.class) {
            try {
                Map map = f2229g;
                w3Var = (C0699w3) map.get(str);
                if (w3Var == null) {
                    w3Var = new C0699w3(a(context, str), runnable);
                    map.put(str, w3Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return w3Var;
    }

    static synchronized void d() {
        synchronized (C0699w3.class) {
            try {
                for (C0699w3 w3Var : f2229g.values()) {
                    w3Var.f2230a.unregisterOnSharedPreferenceChangeListener(w3Var.f2232c);
                }
                f2229g.clear();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final Object c(String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads;
        Map<String, ?> map = this.f2234e;
        if (map == null) {
            synchronized (this.f2233d) {
                try {
                    map = this.f2234e;
                    if (map == null) {
                        allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        Map<String, ?> all = this.f2230a.getAll();
                        this.f2234e = all;
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        map = all;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void e(SharedPreferences sharedPreferences, String str) {
        synchronized (this.f2233d) {
            this.f2234e = null;
            this.f2231b.run();
        }
        synchronized (this) {
            try {
                Iterator it = this.f2235f.iterator();
                if (it.hasNext()) {
                    a.a(it.next());
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
