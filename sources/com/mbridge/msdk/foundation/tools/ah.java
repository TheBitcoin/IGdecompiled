package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import j$.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class ah {

    /* renamed from: a  reason: collision with root package name */
    public volatile JSONObject f13566a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f13567b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f13568c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f13569d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f13570e;

    /* renamed from: f  reason: collision with root package name */
    private String f13571f;

    /* renamed from: g  reason: collision with root package name */
    private volatile ConcurrentHashMap<String, Boolean> f13572g;

    /* renamed from: h  reason: collision with root package name */
    private volatile ConcurrentHashMap<String, Integer> f13573h;

    /* renamed from: i  reason: collision with root package name */
    private volatile g f13574i;

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final ah f13575a = new ah();
    }

    public static ah a() {
        return a.f13575a;
    }

    private int b(String str, String str2, int i4) {
        if (!a(true)) {
            try {
                String optString = this.f13566a.optString(str, "");
                if (!TextUtils.isEmpty(optString)) {
                    String a5 = z.a(optString);
                    if (!TextUtils.isEmpty(a5)) {
                        return new JSONObject(a5).optInt(str2, i4);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return i4;
    }

    private ConcurrentHashMap<String, Boolean> c() {
        synchronized (this.f13569d) {
            try {
                if (this.f13572g == null) {
                    this.f13572g = new ConcurrentHashMap<>();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return this.f13572g;
    }

    private ah() {
        this.f13567b = new Object();
        this.f13568c = new Object();
        this.f13569d = new Object();
        this.f13570e = new Object();
    }

    private static Integer a(String str, ConcurrentHashMap<String, Integer> concurrentHashMap) {
        try {
            return concurrentHashMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r1 = java.lang.Integer.valueOf(r4);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.lang.String r3, int r4) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x002b }
            if (r0 == 0) goto L_0x0007
            goto L_0x002b
        L_0x0007:
            j$.util.concurrent.ConcurrentHashMap r0 = r2.b()     // Catch:{ Exception -> 0x002b }
            java.lang.Integer r1 = a((java.lang.String) r3, (j$.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer>) r0)     // Catch:{ Exception -> 0x002b }
            if (r1 == 0) goto L_0x0016
            int r3 = r1.intValue()     // Catch:{ Exception -> 0x002b }
            return r3
        L_0x0016:
            int r1 = r2.b((java.lang.String) r3, (int) r4)     // Catch:{ Exception -> 0x001f }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x001f }
            goto L_0x0023
        L_0x001f:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x002b }
        L_0x0023:
            r0.put(r3, r1)     // Catch:{ Exception -> 0x002b }
            int r3 = r1.intValue()     // Catch:{ Exception -> 0x002b }
            return r3
        L_0x002b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ah.a(java.lang.String, int):int");
    }

    private int b(String str, int i4) {
        if (!a(true)) {
            try {
                return this.f13566a.optInt(str, i4);
            } catch (Exception unused) {
            }
        }
        return i4;
    }

    private ConcurrentHashMap<String, Integer> b() {
        synchronized (this.f13567b) {
            try {
                if (this.f13573h == null) {
                    this.f13573h = new ConcurrentHashMap<>();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return this.f13573h;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r4 = java.lang.Integer.valueOf(r6);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0039 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.lang.String r4, java.lang.String r5, int r6) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x004a }
            if (r0 != 0) goto L_0x0045
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x004a }
            if (r0 == 0) goto L_0x000d
            goto L_0x0045
        L_0x000d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004a }
            r0.<init>()     // Catch:{ Exception -> 0x004a }
            r0.append(r4)     // Catch:{ Exception -> 0x004a }
            java.lang.String r1 = "_"
            r0.append(r1)     // Catch:{ Exception -> 0x004a }
            r0.append(r5)     // Catch:{ Exception -> 0x004a }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x004a }
            j$.util.concurrent.ConcurrentHashMap r1 = r3.b()     // Catch:{ Exception -> 0x004a }
            java.lang.Integer r2 = a((java.lang.String) r0, (j$.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer>) r1)     // Catch:{ Exception -> 0x004a }
            if (r2 == 0) goto L_0x0030
            int r4 = r2.intValue()     // Catch:{ Exception -> 0x004a }
            return r4
        L_0x0030:
            int r4 = r3.b((java.lang.String) r4, (java.lang.String) r5, (int) r6)     // Catch:{ Exception -> 0x0039 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x004a }
        L_0x003d:
            r1.put(r0, r4)     // Catch:{ Exception -> 0x004a }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x004a }
            return r4
        L_0x0045:
            int r4 = r3.a((java.lang.String) r5, (int) r6)     // Catch:{ Exception -> 0x004a }
            return r4
        L_0x004a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ah.a(java.lang.String, java.lang.String, int):int");
    }

    private static Boolean b(String str, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        try {
            return concurrentHashMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean b(String str, boolean z4, boolean z5) {
        if (!a(z5)) {
            try {
                return this.f13566a.optInt(str, z4 ? 1 : 0) != 0;
            } catch (Exception unused) {
            }
        }
        return z4;
    }

    public final boolean a(String str, boolean z4) {
        try {
            return a(str, z4, true);
        } catch (Exception unused) {
            return z4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r5 = java.lang.Boolean.valueOf(r4);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0021 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.String r3, boolean r4, boolean r5) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x002d }
            if (r0 == 0) goto L_0x0007
            goto L_0x002d
        L_0x0007:
            j$.util.concurrent.ConcurrentHashMap r0 = r2.c()     // Catch:{ Exception -> 0x002d }
            if (r5 == 0) goto L_0x0018
            java.lang.Boolean r1 = b((java.lang.String) r3, (j$.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean>) r0)     // Catch:{ Exception -> 0x002d }
            if (r1 == 0) goto L_0x0018
            boolean r3 = r1.booleanValue()     // Catch:{ Exception -> 0x002d }
            return r3
        L_0x0018:
            boolean r5 = r2.b((java.lang.String) r3, (boolean) r4, (boolean) r5)     // Catch:{ Exception -> 0x0021 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x0021 }
            goto L_0x0025
        L_0x0021:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x002d }
        L_0x0025:
            r0.put(r3, r5)     // Catch:{ Exception -> 0x002d }
            boolean r3 = r5.booleanValue()     // Catch:{ Exception -> 0x002d }
            return r3
        L_0x002d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ah.a(java.lang.String, boolean, boolean):boolean");
    }

    private boolean a(boolean z4) {
        synchronized (this.f13570e) {
            if (this.f13574i == null || this.f13574i.K() == 1 || !z4) {
                try {
                    if (TextUtils.isEmpty(this.f13571f)) {
                        this.f13571f = com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.SDK_APP_ID);
                    }
                    this.f13574i = h.a().a(this.f13571f);
                } catch (Exception unused) {
                    this.f13574i = null;
                }
            }
            if (this.f13574i != null) {
                this.f13566a = this.f13574i.am();
            }
        }
        if (this.f13574i == null || this.f13566a == null) {
            return true;
        }
        return false;
    }
}
