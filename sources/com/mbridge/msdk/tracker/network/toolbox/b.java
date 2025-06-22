package com.mbridge.msdk.tracker.network.toolbox;

import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.tracker.network.n;
import com.mbridge.msdk.tracker.network.q;
import com.mbridge.msdk.tracker.network.u;

public final class b implements n {

    /* renamed from: a  reason: collision with root package name */
    protected final c f15606a;

    /* renamed from: b  reason: collision with root package name */
    private final a f15607b;

    public b(a aVar) {
        this(aVar, new c(4096));
    }

    private static q b(u<?> uVar) {
        String str;
        if (uVar == null) {
            return null;
        }
        try {
            if (!uVar.d() || TextUtils.isEmpty(uVar.k())) {
                return null;
            }
            if (uVar.i() == 0) {
                str = ShareTarget.METHOD_GET;
            } else {
                str = ShareTarget.METHOD_POST;
            }
            q qVar = new q(uVar.f(), str);
            qVar.d("queue");
            qVar.c(uVar.d("local_id"));
            qVar.b(uVar.d("ad_type"));
            qVar.a(uVar.v());
            uVar.a(qVar);
            return qVar;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:1|2|3|(2:5|6)(8:11|12|(3:14|15|16)|17|18|19|(3:21|22|23)|24)|25|26|27|28|(2:30|31)|32|33|34|(3:36|37|(2:39|143)(3:42|43|142))(8:44|45|46|(2:48|49)(2:51|52)|50|53|54|(7:56|57|(2:59|60)(1:63)|64|65|66|67)(2:137|72))|121) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0051 */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01e4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0059 A[SYNTHETIC, Splitter:B:36:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0147  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.tracker.network.r a(com.mbridge.msdk.tracker.network.u<?> r27) throws com.mbridge.msdk.tracker.network.ad {
        /*
            r26 = this;
            r1 = r26
            r2 = r27
            r4 = 2
            r5 = 1
            r6 = 0
            long r7 = android.os.SystemClock.elapsedRealtime()
            com.mbridge.msdk.tracker.network.q r9 = b(r2)
        L_0x000f:
            r10 = 0
            com.mbridge.msdk.tracker.network.b$a r0 = r2.m()     // Catch:{ IOException -> 0x011c }
            if (r0 != 0) goto L_0x0022
            java.util.Map r0 = java.util.Collections.EMPTY_MAP     // Catch:{ IOException -> 0x0019 }
            goto L_0x0042
        L_0x0019:
            r0 = move-exception
            r11 = r10
            r14 = r11
        L_0x001c:
            r19 = 3
        L_0x001e:
            r20 = 0
            goto L_0x0123
        L_0x0022:
            java.util.HashMap r11 = new java.util.HashMap     // Catch:{ IOException -> 0x011c }
            r11.<init>()     // Catch:{ IOException -> 0x011c }
            java.lang.String r12 = r0.f15519b     // Catch:{ IOException -> 0x011c }
            if (r12 == 0) goto L_0x0030
            java.lang.String r13 = "If-None-Match"
            r11.put(r13, r12)     // Catch:{ IOException -> 0x0019 }
        L_0x0030:
            long r12 = r0.f15521d     // Catch:{ IOException -> 0x011c }
            r14 = 0
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 <= 0) goto L_0x0041
            java.lang.String r0 = "If-Modified-Since"
            java.lang.String r12 = com.mbridge.msdk.tracker.network.toolbox.f.a((long) r12)     // Catch:{ IOException -> 0x0019 }
            r11.put(r0, r12)     // Catch:{ IOException -> 0x0019 }
        L_0x0041:
            r0 = r11
        L_0x0042:
            com.mbridge.msdk.tracker.network.toolbox.a r11 = r1.f15607b     // Catch:{ IOException -> 0x011c }
            com.mbridge.msdk.tracker.network.toolbox.g r11 = r11.a(r2, r0)     // Catch:{ IOException -> 0x011c }
            int r13 = r11.a()     // Catch:{ IOException -> 0x0115 }
            if (r9 == 0) goto L_0x0051
            r9.a((int) r13)     // Catch:{ Exception -> 0x0051 }
        L_0x0051:
            java.util.List r18 = r11.b()     // Catch:{ IOException -> 0x0115 }
            r0 = 304(0x130, float:4.26E-43)
            if (r13 != r0) goto L_0x0090
            long r12 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0075 }
            long r23 = r12 - r7
            com.mbridge.msdk.tracker.network.b$a r0 = r2.m()     // Catch:{ IOException -> 0x0075 }
            if (r0 != 0) goto L_0x0078
            com.mbridge.msdk.tracker.network.r r14 = new com.mbridge.msdk.tracker.network.r     // Catch:{ IOException -> 0x0075 }
            r16 = 0
            r17 = 1
            r15 = 304(0x130, float:4.26E-43)
            r20 = r18
            r18 = r23
            r14.<init>(r15, r16, r17, r18, r20)     // Catch:{ IOException -> 0x0075 }
            goto L_0x008f
        L_0x0075:
            r0 = move-exception
            r14 = r10
            goto L_0x001c
        L_0x0078:
            r12 = r18
            r18 = r23
            java.util.List r25 = com.mbridge.msdk.tracker.network.toolbox.f.a(r12, r0)     // Catch:{ IOException -> 0x0075 }
            com.mbridge.msdk.tracker.network.r r19 = new com.mbridge.msdk.tracker.network.r     // Catch:{ IOException -> 0x0075 }
            byte[] r0 = r0.f15518a     // Catch:{ IOException -> 0x0075 }
            r22 = 1
            r20 = 304(0x130, float:4.26E-43)
            r21 = r0
            r19.<init>(r20, r21, r22, r23, r25)     // Catch:{ IOException -> 0x0075 }
            r14 = r19
        L_0x008f:
            return r14
        L_0x0090:
            r12 = r18
            java.io.InputStream r0 = r11.d()     // Catch:{ IOException -> 0x0115 }
            if (r0 == 0) goto L_0x00a4
            int r14 = r11.c()     // Catch:{ IOException -> 0x0075 }
            com.mbridge.msdk.tracker.network.toolbox.c r15 = r1.f15606a     // Catch:{ IOException -> 0x0075 }
            byte[] r0 = com.mbridge.msdk.tracker.network.toolbox.i.a(r0, r14, r15, r9)     // Catch:{ IOException -> 0x0075 }
        L_0x00a2:
            r14 = r0
            goto L_0x00a7
        L_0x00a4:
            byte[] r0 = new byte[r6]     // Catch:{ IOException -> 0x0115 }
            goto L_0x00a2
        L_0x00a7:
            long r15 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x00ed }
            long r15 = r15 - r7
            r17 = 3000(0xbb8, double:1.482E-320)
            int r0 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r0 <= 0) goto L_0x00f0
            java.lang.String r0 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]"
            java.lang.Long r15 = java.lang.Long.valueOf(r15)     // Catch:{ IOException -> 0x00ed }
            r19 = 3
            if (r14 == 0) goto L_0x00c5
            int r3 = r14.length     // Catch:{ IOException -> 0x00c2 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x00c2 }
            goto L_0x00c7
        L_0x00c2:
            r0 = move-exception
            goto L_0x001e
        L_0x00c5:
            java.lang.String r3 = "null"
        L_0x00c7:
            java.lang.Integer r16 = java.lang.Integer.valueOf(r13)     // Catch:{ IOException -> 0x00c2 }
            com.mbridge.msdk.tracker.network.z r17 = r2.b()     // Catch:{ IOException -> 0x00c2 }
            int r17 = r17.c()     // Catch:{ IOException -> 0x00c2 }
            java.lang.Integer r17 = java.lang.Integer.valueOf(r17)     // Catch:{ IOException -> 0x00c2 }
            r20 = 0
            r6 = 5
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ IOException -> 0x00eb }
            r6[r20] = r2     // Catch:{ IOException -> 0x00eb }
            r6[r5] = r15     // Catch:{ IOException -> 0x00eb }
            r6[r4] = r3     // Catch:{ IOException -> 0x00eb }
            r6[r19] = r16     // Catch:{ IOException -> 0x00eb }
            r3 = 4
            r6[r3] = r17     // Catch:{ IOException -> 0x00eb }
            com.mbridge.msdk.tracker.network.ae.b(r0, r6)     // Catch:{ IOException -> 0x00eb }
            goto L_0x00f4
        L_0x00eb:
            r0 = move-exception
            goto L_0x0123
        L_0x00ed:
            r0 = move-exception
            goto L_0x001c
        L_0x00f0:
            r19 = 3
            r20 = 0
        L_0x00f4:
            r0 = 200(0xc8, float:2.8E-43)
            if (r13 < r0) goto L_0x010f
            r0 = 299(0x12b, float:4.19E-43)
            if (r13 > r0) goto L_0x010f
            a(r9, r5, r10)     // Catch:{ IOException -> 0x00eb }
            r18 = r12
            com.mbridge.msdk.tracker.network.r r12 = new com.mbridge.msdk.tracker.network.r     // Catch:{ IOException -> 0x00eb }
            long r15 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x00eb }
            long r15 = r15 - r7
            r16 = r15
            r15 = 0
            r12.<init>(r13, r14, r15, r16, r18)     // Catch:{ IOException -> 0x00eb }
            return r12
        L_0x010f:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x00eb }
            r0.<init>()     // Catch:{ IOException -> 0x00eb }
            throw r0     // Catch:{ IOException -> 0x00eb }
        L_0x0115:
            r0 = move-exception
            r19 = 3
            r20 = 0
            r14 = r10
            goto L_0x0123
        L_0x011c:
            r0 = move-exception
            r19 = 3
            r20 = 0
            r11 = r10
            r14 = r11
        L_0x0123:
            java.lang.String r3 = r0.getMessage()
            java.lang.String r6 = "timeout"
            boolean r3 = android.text.TextUtils.equals(r3, r6)
            if (r3 == 0) goto L_0x0131
            r3 = 3
            goto L_0x0132
        L_0x0131:
            r3 = 2
        L_0x0132:
            a(r9, r3, r0)
            boolean r3 = r0 instanceof java.net.SocketTimeoutException
            if (r3 == 0) goto L_0x0147
            com.mbridge.msdk.tracker.network.toolbox.i$a r0 = new com.mbridge.msdk.tracker.network.toolbox.i$a
            com.mbridge.msdk.tracker.network.ab r3 = new com.mbridge.msdk.tracker.network.ab
            r3.<init>()
            java.lang.String r6 = "socket"
            r0.<init>(r6, r3)
            goto L_0x01cb
        L_0x0147:
            boolean r3 = r0 instanceof java.net.MalformedURLException
            if (r3 != 0) goto L_0x01f2
            if (r11 == 0) goto L_0x01b9
            int r13 = r11.a()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r13)
            java.lang.String r3 = r2.k()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r6[r20] = r0
            r6[r5] = r3
            java.lang.String r0 = "Unexpected response code %d for %s"
            com.mbridge.msdk.tracker.network.ae.c(r0, r6)
            if (r14 == 0) goto L_0x01a9
            java.util.List r18 = r11.b()
            com.mbridge.msdk.tracker.network.r r12 = new com.mbridge.msdk.tracker.network.r
            long r15 = android.os.SystemClock.elapsedRealtime()
            long r15 = r15 - r7
            r16 = r15
            r15 = 0
            r12.<init>(r13, r14, r15, r16, r18)
            r0 = 400(0x190, float:5.6E-43)
            if (r13 < r0) goto L_0x0189
            r0 = 499(0x1f3, float:6.99E-43)
            if (r13 <= r0) goto L_0x0180
            goto L_0x0189
        L_0x0180:
            com.mbridge.msdk.tracker.network.d r0 = new com.mbridge.msdk.tracker.network.d
            r0.<init>(r12)
            r0.a((int) r13)
            throw r0
        L_0x0189:
            com.mbridge.msdk.tracker.network.aa r0 = new com.mbridge.msdk.tracker.network.aa
            r0.<init>(r12)
            r0.a((int) r13)
            r3 = 500(0x1f4, float:7.0E-43)
            if (r13 < r3) goto L_0x01a8
            r3 = 599(0x257, float:8.4E-43)
            if (r13 > r3) goto L_0x01a8
            boolean r3 = r2.s()
            if (r3 == 0) goto L_0x01a8
            com.mbridge.msdk.tracker.network.toolbox.i$a r3 = new com.mbridge.msdk.tracker.network.toolbox.i$a
            java.lang.String r6 = "server"
            r3.<init>(r6, r0)
        L_0x01a6:
            r0 = r3
            goto L_0x01cb
        L_0x01a8:
            throw r0
        L_0x01a9:
            com.mbridge.msdk.tracker.network.p r0 = new com.mbridge.msdk.tracker.network.p
            r0.<init>()
            r0.a((int) r13)
            com.mbridge.msdk.tracker.network.toolbox.i$a r3 = new com.mbridge.msdk.tracker.network.toolbox.i$a
            java.lang.String r6 = "network"
            r3.<init>(r6, r0)
            goto L_0x01a6
        L_0x01b9:
            boolean r3 = r2.t()
            if (r3 == 0) goto L_0x01ec
            com.mbridge.msdk.tracker.network.toolbox.i$a r0 = new com.mbridge.msdk.tracker.network.toolbox.i$a
            com.mbridge.msdk.tracker.network.s r3 = new com.mbridge.msdk.tracker.network.s
            r3.<init>()
            java.lang.String r6 = "connection"
            r0.<init>(r6, r3)
        L_0x01cb:
            if (r2 == 0) goto L_0x01e4
            com.mbridge.msdk.tracker.network.z r3 = r2.b()
            if (r3 == 0) goto L_0x01e1
            com.mbridge.msdk.tracker.network.ad r6 = r0.f15622b
            boolean r3 = r3.a(r6)
            if (r3 == 0) goto L_0x01de
            r6 = 0
            goto L_0x000f
        L_0x01de:
            com.mbridge.msdk.tracker.network.ad r0 = r0.f15622b
            throw r0
        L_0x01e1:
            com.mbridge.msdk.tracker.network.ad r0 = r0.f15622b
            throw r0
        L_0x01e4:
            com.mbridge.msdk.tracker.network.ac r0 = new com.mbridge.msdk.tracker.network.ac
            java.lang.String r2 = "request is null when retrying"
            r0.<init>((java.lang.String) r2)
            throw r0
        L_0x01ec:
            com.mbridge.msdk.tracker.network.s r2 = new com.mbridge.msdk.tracker.network.s
            r2.<init>(r0)
            throw r2
        L_0x01f2:
            com.mbridge.msdk.tracker.network.a r0 = new com.mbridge.msdk.tracker.network.a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Bad URL "
            r3.append(r4)
            java.lang.String r2 = r2.k()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.tracker.network.toolbox.b.a(com.mbridge.msdk.tracker.network.u):com.mbridge.msdk.tracker.network.r");
    }

    private b(a aVar, c cVar) {
        this.f15607b = aVar;
        this.f15606a = cVar;
    }

    private static void a(q qVar, int i4, Exception exc) {
        if (qVar != null) {
            try {
                qVar.a(exc);
                qVar.b(i4);
            } catch (Exception unused) {
            }
        }
    }
}
