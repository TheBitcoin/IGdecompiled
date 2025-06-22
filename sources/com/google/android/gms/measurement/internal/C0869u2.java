package com.google.android.gms.measurement.internal;

import M.C0335p;
import java.net.URL;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.u2  reason: case insensitive filesystem */
final class C0869u2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final URL f3236a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f3237b;

    /* renamed from: c  reason: collision with root package name */
    private final C0862t2 f3238c;

    /* renamed from: d  reason: collision with root package name */
    private final String f3239d;

    /* renamed from: e  reason: collision with root package name */
    private final Map f3240e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ C0842q2 f3241f;

    public C0869u2(C0842q2 q2Var, String str, URL url, byte[] bArr, Map map, C0862t2 t2Var) {
        this.f3241f = q2Var;
        C0335p.f(str);
        C0335p.l(url);
        C0335p.l(t2Var);
        this.f3236a = url;
        this.f3237b = bArr;
        this.f3238c = t2Var;
        this.f3239d = str;
        this.f3240e = map;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: java.util.Map<java.lang.String, java.util.List<java.lang.String>>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: java.util.Map<java.lang.String, java.util.List<java.lang.String>>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: java.util.Map<java.lang.String, java.util.List<java.lang.String>>} */
    /* JADX WARNING: type inference failed for: r0v13, types: [java.net.URLConnection] */
    /* JADX WARNING: type inference failed for: r13v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00fe A[SYNTHETIC, Splitter:B:54:0x00fe] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0133 A[SYNTHETIC, Splitter:B:63:0x0133] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x014d  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r15 = this;
            java.lang.String r1 = "Error closing HTTP compressed POST connection output stream. appId"
            com.google.android.gms.measurement.internal.q2 r0 = r15.f3241f
            r0.i()
            r2 = 0
            r3 = 0
            java.net.URL r0 = r15.f3236a     // Catch:{ IOException -> 0x00ee, all -> 0x00e9 }
            com.google.android.gms.internal.measurement.D0 r4 = com.google.android.gms.internal.measurement.D0.a()     // Catch:{ IOException -> 0x00ee, all -> 0x00e9 }
            java.lang.String r5 = "client-measurement"
            java.net.URLConnection r0 = r4.b(r0, r5)     // Catch:{ IOException -> 0x00ee, all -> 0x00e9 }
            boolean r4 = r0 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x00ee, all -> 0x00e9 }
            if (r4 == 0) goto L_0x00f4
            r4 = r0
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ IOException -> 0x00ee, all -> 0x00e9 }
            r4.setDefaultUseCaches(r3)     // Catch:{ IOException -> 0x00ee, all -> 0x00e9 }
            r0 = 60000(0xea60, float:8.4078E-41)
            r4.setConnectTimeout(r0)     // Catch:{ IOException -> 0x00ee, all -> 0x00e9 }
            r0 = 61000(0xee48, float:8.5479E-41)
            r4.setReadTimeout(r0)     // Catch:{ IOException -> 0x00ee, all -> 0x00e9 }
            r4.setInstanceFollowRedirects(r3)     // Catch:{ IOException -> 0x00ee, all -> 0x00e9 }
            r0 = 1
            r4.setDoInput(r0)     // Catch:{ IOException -> 0x00ee, all -> 0x00e9 }
            java.util.Map r5 = r15.f3240e     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            if (r5 == 0) goto L_0x0067
            java.util.Set r5 = r5.entrySet()     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x0061, all -> 0x005a }
        L_0x003e:
            boolean r6 = r5.hasNext()     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            if (r6 == 0) goto L_0x0067
            java.lang.Object r6 = r5.next()     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            java.lang.Object r7 = r6.getKey()     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            java.lang.Object r6 = r6.getValue()     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            r4.addRequestProperty(r7, r6)     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            goto L_0x003e
        L_0x005a:
            r0 = move-exception
            r6 = r2
        L_0x005c:
            r13 = r6
        L_0x005d:
            r10 = 0
        L_0x005e:
            r2 = r0
            goto L_0x00fc
        L_0x0061:
            r0 = move-exception
            r8 = r0
            r10 = r2
        L_0x0064:
            r7 = 0
            goto L_0x0131
        L_0x0067:
            byte[] r5 = r15.f3237b     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            if (r5 == 0) goto L_0x00af
            com.google.android.gms.measurement.internal.q2 r5 = r15.f3241f     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            com.google.android.gms.measurement.internal.Z5 r5 = r5.l()     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            byte[] r6 = r15.f3237b     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            byte[] r5 = r5.h0(r6)     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            com.google.android.gms.measurement.internal.q2 r6 = r15.f3241f     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            com.google.android.gms.measurement.internal.n2 r6 = r6.a()     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            com.google.android.gms.measurement.internal.p2 r6 = r6.K()     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            java.lang.String r7 = "Uploading data. size"
            int r8 = r5.length     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            r6.b(r7, r8)     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            r4.setDoOutput(r0)     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            java.lang.String r0 = "Content-Encoding"
            java.lang.String r6 = "gzip"
            r4.addRequestProperty(r0, r6)     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            int r0 = r5.length     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            r4.setFixedLengthStreamingMode(r0)     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            r4.connect()     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            java.io.OutputStream r6 = r4.getOutputStream()     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            r6.write(r5)     // Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
            r6.close()     // Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
            goto L_0x00af
        L_0x00a7:
            r0 = move-exception
            r13 = r2
            goto L_0x005d
        L_0x00aa:
            r0 = move-exception
            r8 = r0
            r10 = r2
            r2 = r6
            goto L_0x0064
        L_0x00af:
            int r8 = r4.getResponseCode()     // Catch:{ IOException -> 0x0061, all -> 0x005a }
            java.util.Map r11 = r4.getHeaderFields()     // Catch:{ IOException -> 0x00e5, all -> 0x00df }
            com.google.android.gms.measurement.internal.q2 r0 = r15.f3241f     // Catch:{ IOException -> 0x00da, all -> 0x00d5 }
            byte[] r10 = com.google.android.gms.measurement.internal.C0842q2.y(r4)     // Catch:{ IOException -> 0x00da, all -> 0x00d5 }
            r4.disconnect()
            com.google.android.gms.measurement.internal.q2 r0 = r15.f3241f
            com.google.android.gms.measurement.internal.P2 r0 = r0.f()
            com.google.android.gms.measurement.internal.s2 r5 = new com.google.android.gms.measurement.internal.s2
            java.lang.String r6 = r15.f3239d
            com.google.android.gms.measurement.internal.t2 r7 = r15.f3238c
            r9 = 0
            r12 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r0.D(r5)
            return
        L_0x00d5:
            r0 = move-exception
            r6 = r2
            r10 = r8
            r13 = r11
            goto L_0x005e
        L_0x00da:
            r0 = move-exception
            r7 = r8
            r10 = r11
        L_0x00dd:
            r8 = r0
            goto L_0x0131
        L_0x00df:
            r0 = move-exception
            r6 = r2
            r13 = r6
            r10 = r8
            goto L_0x005e
        L_0x00e5:
            r0 = move-exception
            r10 = r2
            r7 = r8
            goto L_0x00dd
        L_0x00e9:
            r0 = move-exception
            r4 = r2
            r6 = r4
            goto L_0x005c
        L_0x00ee:
            r0 = move-exception
            r8 = r0
            r4 = r2
            r10 = r4
            goto L_0x0064
        L_0x00f4:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x00ee, all -> 0x00e9 }
            java.lang.String r4 = "Failed to obtain HTTP connection"
            r0.<init>(r4)     // Catch:{ IOException -> 0x00ee, all -> 0x00e9 }
            throw r0     // Catch:{ IOException -> 0x00ee, all -> 0x00e9 }
        L_0x00fc:
            if (r6 == 0) goto L_0x0116
            r6.close()     // Catch:{ IOException -> 0x0102 }
            goto L_0x0116
        L_0x0102:
            r0 = move-exception
            com.google.android.gms.measurement.internal.q2 r3 = r15.f3241f
            com.google.android.gms.measurement.internal.n2 r3 = r3.a()
            com.google.android.gms.measurement.internal.p2 r3 = r3.G()
            java.lang.String r5 = r15.f3239d
            java.lang.Object r5 = com.google.android.gms.measurement.internal.C0821n2.s(r5)
            r3.c(r1, r5, r0)
        L_0x0116:
            if (r4 == 0) goto L_0x011b
            r4.disconnect()
        L_0x011b:
            com.google.android.gms.measurement.internal.q2 r0 = r15.f3241f
            com.google.android.gms.measurement.internal.P2 r0 = r0.f()
            com.google.android.gms.measurement.internal.s2 r7 = new com.google.android.gms.measurement.internal.s2
            java.lang.String r8 = r15.f3239d
            com.google.android.gms.measurement.internal.t2 r9 = r15.f3238c
            r12 = 0
            r14 = 0
            r11 = 0
            r7.<init>(r8, r9, r10, r11, r12, r13)
            r0.D(r7)
            throw r2
        L_0x0131:
            if (r2 == 0) goto L_0x014b
            r2.close()     // Catch:{ IOException -> 0x0137 }
            goto L_0x014b
        L_0x0137:
            r0 = move-exception
            com.google.android.gms.measurement.internal.q2 r2 = r15.f3241f
            com.google.android.gms.measurement.internal.n2 r2 = r2.a()
            com.google.android.gms.measurement.internal.p2 r2 = r2.G()
            java.lang.String r3 = r15.f3239d
            java.lang.Object r3 = com.google.android.gms.measurement.internal.C0821n2.s(r3)
            r2.c(r1, r3, r0)
        L_0x014b:
            if (r4 == 0) goto L_0x0150
            r4.disconnect()
        L_0x0150:
            com.google.android.gms.measurement.internal.q2 r0 = r15.f3241f
            com.google.android.gms.measurement.internal.P2 r0 = r0.f()
            com.google.android.gms.measurement.internal.s2 r4 = new com.google.android.gms.measurement.internal.s2
            java.lang.String r5 = r15.f3239d
            com.google.android.gms.measurement.internal.t2 r6 = r15.f3238c
            r9 = 0
            r11 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r0.D(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0869u2.run():void");
    }
}
