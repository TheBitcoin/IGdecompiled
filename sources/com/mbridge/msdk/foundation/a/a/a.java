package com.mbridge.msdk.foundation.a.a;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.af;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f12713a = "a";

    /* renamed from: c  reason: collision with root package name */
    private static a f12714c;

    /* renamed from: b  reason: collision with root package name */
    FastKV f12715b;

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f12714c == null) {
                    f12714c = new a();
                }
                aVar = f12714c;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return aVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:13|14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        return 0L;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Long b(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0018 }
            android.content.Context r2 = r2.c()     // Catch:{ Exception -> 0x0018 }
            if (r2 != 0) goto L_0x001a
            java.lang.String r6 = f12713a     // Catch:{ Exception -> 0x0018 }
            java.lang.String r2 = "context is null in get"
            com.mbridge.msdk.foundation.tools.af.b(r6, r2)     // Catch:{ Exception -> 0x0018 }
            java.lang.Long r6 = java.lang.Long.valueOf(r0)     // Catch:{ Exception -> 0x0018 }
            return r6
        L_0x0018:
            r6 = move-exception
            goto L_0x002f
        L_0x001a:
            r5.b()     // Catch:{ Exception -> 0x0018 }
            com.mbridge.msdk.foundation.tools.FastKV r2 = r5.f12715b     // Catch:{ Exception -> 0x0018 }
            if (r2 == 0) goto L_0x004d
            long r2 = r2.getLong(r6, r0)     // Catch:{ Exception -> 0x002a }
            java.lang.Long r6 = java.lang.Long.valueOf(r2)     // Catch:{ Exception -> 0x002a }
            return r6
        L_0x002a:
            java.lang.Long r6 = java.lang.Long.valueOf(r0)     // Catch:{ Exception -> 0x0018 }
            return r6
        L_0x002f:
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r2 == 0) goto L_0x004d
            java.lang.String r2 = f12713a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getLong error: "
            r3.append(r4)
            java.lang.String r6 = r6.getMessage()
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r2, (java.lang.String) r6)
        L_0x004d:
            java.lang.Long r6 = java.lang.Long.valueOf(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.a.a.a.b(java.lang.String):java.lang.Long");
    }

    public final void c(String str) {
        if (c.m().c() != null) {
            b();
            FastKV fastKV = this.f12715b;
            if (fastKV != null) {
                try {
                    fastKV.remove(str);
                } catch (Exception unused) {
                }
            }
        }
    }

    public final String a(String str) {
        try {
            if (c.m().c() == null) {
                return null;
            }
            b();
            FastKV fastKV = this.f12715b;
            if (fastKV != null) {
                try {
                    return fastKV.getString(str, "");
                } catch (Exception unused) {
                    return "";
                }
            }
            return null;
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                String str2 = f12713a;
                af.a(str2, "get error: " + e5.getMessage());
            }
        }
    }

    public final int a(String str, int i4) {
        try {
            if (c.m().c() != null) {
                b();
                FastKV fastKV = this.f12715b;
                if (fastKV != null) {
                    try {
                        return fastKV.getInt(str, i4);
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                String str2 = f12713a;
                af.a(str2, "getInt error: " + e5.getMessage());
            }
        }
        return i4;
    }

    public final void b(String str, int i4) {
        try {
            if (c.m().c() != null) {
                b();
                FastKV fastKV = this.f12715b;
                if (fastKV != null) {
                    try {
                        fastKV.putInt(str, i4);
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private void b() {
        if (this.f12715b == null) {
            try {
                this.f12715b = new FastKV.Builder(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
            } catch (Exception unused) {
                this.f12715b = null;
            }
        }
    }

    public final void a(String str, String str2) {
        try {
            if (c.m().c() != null) {
                b();
                FastKV fastKV = this.f12715b;
                if (fastKV != null) {
                    try {
                        fastKV.putString(str, str2);
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                String str3 = f12713a;
                af.a(str3, "put error: " + e5.getMessage());
            }
        }
    }

    public final void a(String str, long j4) {
        try {
            if (c.m().c() == null) {
                af.b(f12713a, "context is null in put");
                return;
            }
            b();
            FastKV fastKV = this.f12715b;
            if (fastKV != null) {
                try {
                    fastKV.putLong(str, j4);
                } catch (Exception unused) {
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                String str2 = f12713a;
                af.a(str2, "putLong error: " + e5.getMessage());
            }
        }
    }
}
