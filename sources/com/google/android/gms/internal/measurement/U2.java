package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Handler;
import android.os.RemoteException;
import android.os.StrictMode;
import android.support.v4.media.a;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import l0.h;

public final class U2 implements C0519b3 {

    /* renamed from: h  reason: collision with root package name */
    private static final Map f1634h = new ArrayMap();

    /* renamed from: i  reason: collision with root package name */
    private static final String[] f1635i = {LeanbackPreferenceDialogFragment.ARG_KEY, "value"};

    /* renamed from: a  reason: collision with root package name */
    private final ContentResolver f1636a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f1637b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f1638c;

    /* renamed from: d  reason: collision with root package name */
    private final ContentObserver f1639d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f1640e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private volatile Map f1641f;

    /* renamed from: g  reason: collision with root package name */
    private final List f1642g = new ArrayList();

    private U2(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        W2 w22 = new W2(this, (Handler) null);
        this.f1639d = w22;
        h.i(contentResolver);
        h.i(uri);
        this.f1636a = contentResolver;
        this.f1637b = uri;
        this.f1638c = runnable;
        contentResolver.registerContentObserver(uri, false, w22);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(5:5|6|7|8|9)|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0019 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.measurement.U2 a(android.content.ContentResolver r4, android.net.Uri r5, java.lang.Runnable r6) {
        /*
            java.lang.Class<com.google.android.gms.internal.measurement.U2> r0 = com.google.android.gms.internal.measurement.U2.class
            monitor-enter(r0)
            java.util.Map r1 = f1634h     // Catch:{ all -> 0x0017 }
            java.lang.Object r2 = r1.get(r5)     // Catch:{ all -> 0x0017 }
            com.google.android.gms.internal.measurement.U2 r2 = (com.google.android.gms.internal.measurement.U2) r2     // Catch:{ all -> 0x0017 }
            if (r2 != 0) goto L_0x0019
            com.google.android.gms.internal.measurement.U2 r3 = new com.google.android.gms.internal.measurement.U2     // Catch:{ SecurityException -> 0x0019 }
            r3.<init>(r4, r5, r6)     // Catch:{ SecurityException -> 0x0019 }
            r1.put(r5, r3)     // Catch:{ SecurityException -> 0x0015 }
        L_0x0015:
            r2 = r3
            goto L_0x0019
        L_0x0017:
            r4 = move-exception
            goto L_0x001b
        L_0x0019:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return r2
        L_0x001b:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.U2.a(android.content.ContentResolver, android.net.Uri, java.lang.Runnable):com.google.android.gms.internal.measurement.U2");
    }

    static synchronized void e() {
        synchronized (U2.class) {
            try {
                for (U2 u22 : f1634h.values()) {
                    u22.f1636a.unregisterContentObserver(u22.f1639d);
                }
                f1634h.clear();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    private final Map g() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return (Map) C0510a3.a(new X2(this));
        } catch (SQLiteException | IllegalStateException | SecurityException e5) {
            Log.w("ConfigurationContentLdr", "Unable to query ContentProvider, using default values", e5);
            return Collections.EMPTY_MAP;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public final Map b() {
        Map map = this.f1641f;
        if (map == null) {
            synchronized (this.f1640e) {
                try {
                    map = this.f1641f;
                    if (map == null) {
                        map = g();
                        this.f1641f = map;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (map != null) {
            return map;
        }
        return Collections.EMPTY_MAP;
    }

    public final /* synthetic */ Object c(String str) {
        return (String) b().get(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Map d() {
        Cursor query;
        Map map;
        Throwable th;
        ContentProviderClient acquireUnstableContentProviderClient = this.f1636a.acquireUnstableContentProviderClient(this.f1637b);
        if (acquireUnstableContentProviderClient == null) {
            Log.w("ConfigurationContentLdr", "Unable to acquire ContentProviderClient, using default values");
            return Collections.EMPTY_MAP;
        }
        try {
            query = acquireUnstableContentProviderClient.query(this.f1637b, f1635i, (String) null, (String[]) null, (String) null);
            if (query == null) {
                Log.w("ConfigurationContentLdr", "ContentProvider query returned null cursor, using default values");
                Map map2 = Collections.EMPTY_MAP;
                if (query != null) {
                    query.close();
                }
                acquireUnstableContentProviderClient.release();
                return map2;
            }
            int count = query.getCount();
            if (count == 0) {
                Map map3 = Collections.EMPTY_MAP;
                query.close();
                acquireUnstableContentProviderClient.release();
                return map3;
            }
            if (count <= 256) {
                map = new ArrayMap(count);
            } else {
                map = new HashMap(count, 1.0f);
            }
            while (query.moveToNext()) {
                map.put(query.getString(0), query.getString(1));
            }
            if (!query.isAfterLast()) {
                Log.w("ConfigurationContentLdr", "Cursor read incomplete (ContentProvider dead?), using default values");
                Map map4 = Collections.EMPTY_MAP;
                query.close();
                acquireUnstableContentProviderClient.release();
                return map4;
            }
            query.close();
            acquireUnstableContentProviderClient.release();
            return map;
        } catch (RemoteException e5) {
            Log.w("ConfigurationContentLdr", "ContentProvider query failed, using default values", e5);
            Map map5 = Collections.EMPTY_MAP;
            acquireUnstableContentProviderClient.release();
            return map5;
        } catch (Throwable th2) {
            acquireUnstableContentProviderClient.release();
            throw th2;
        }
        throw th;
    }

    public final void f() {
        synchronized (this.f1640e) {
            this.f1641f = null;
            this.f1638c.run();
        }
        synchronized (this) {
            try {
                Iterator it = this.f1642g.iterator();
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
