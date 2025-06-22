package Q3;

import P3.C2546b;

/* renamed from: Q3.c  reason: case insensitive filesystem */
public class C2552c implements C2561l {

    /* renamed from: c  reason: collision with root package name */
    private static final String f23883c = C2546b.i(C2552c.class);

    /* renamed from: a  reason: collision with root package name */
    private long f23884a = 5000;

    /* renamed from: b  reason: collision with root package name */
    private boolean f23885b = false;

    private static boolean d(int i4) {
        if (i4 == 204 || i4 == 200) {
            return true;
        }
        return false;
    }

    public void a(long j4) {
        this.f23884a = j4;
    }

    public void b(boolean z4) {
        this.f23885b = z4;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.io.BufferedWriter} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v2, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r4v5, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v14 */
    /* JADX WARNING: type inference failed for: r4v15, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r4v17 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b1 A[SYNTHETIC, Splitter:B:30:0x00b1] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f6 A[SYNTHETIC, Splitter:B:56:0x00f6] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0191 A[SYNTHETIC, Splitter:B:93:0x0191] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c(Q3.C2559j r12) {
        /*
            r11 = this;
            r0 = 1
            r1 = 0
            java.lang.String r2 = "Failed to close output stream after writing POST data."
            java.lang.String r3 = "Failed to close output stream after writing gzipped POST data."
            r4 = 0
            java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x01a4 }
            java.lang.String r6 = r12.c()     // Catch:{ Exception -> 0x01a4 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x01a4 }
            java.net.URLConnection r5 = r5.openConnection()     // Catch:{ Exception -> 0x01a4 }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x01a4 }
            java.lang.String r6 = f23883c     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            Y3.a$b r7 = Y3.C2611a.b(r6)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.String r8 = "Connection is open to %s"
            java.net.URL r9 = r5.getURL()     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.String r9 = r9.toExternalForm()     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.Object[] r10 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r10[r1] = r9     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r7.g(r8, r10)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            Y3.a$b r6 = Y3.C2611a.b(r6)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.String r7 = "Sending: %s"
            java.lang.Object[] r8 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r8[r1] = r12     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r6.g(r7, r8)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            long r6 = r11.f23884a     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            int r7 = (int) r6     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r5.setConnectTimeout(r7)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            long r6 = r11.f23884a     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            int r7 = (int) r6     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r5.setReadTimeout(r7)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            org.json.JSONObject r6 = r12.b()     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            if (r6 == 0) goto L_0x0107
            r5.setDoOutput(r0)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.String r6 = "Content-Type"
            java.lang.String r7 = "application/json"
            r5.setRequestProperty(r6, r7)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.String r6 = "charset"
            java.lang.String r7 = "utf-8"
            r5.setRequestProperty(r6, r7)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            org.json.JSONObject r12 = r12.b()     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            boolean r6 = r11.f23885b     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            if (r6 == 0) goto L_0x00cc
            java.lang.String r2 = "Content-Encoding"
            java.lang.String r6 = "gzip"
            r5.addRequestProperty(r2, r6)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r2.<init>()     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.util.zip.GZIPOutputStream r6 = new java.util.zip.GZIPOutputStream     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r6.<init>(r2)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.nio.charset.Charset r7 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x00c2 }
            byte[] r12 = r12.getBytes(r7)     // Catch:{ all -> 0x00c2 }
            r6.write(r12)     // Catch:{ all -> 0x00c2 }
            r6.close()     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.io.OutputStream r12 = r5.getOutputStream()     // Catch:{ all -> 0x00ae }
            byte[] r2 = r2.toByteArray()     // Catch:{ all -> 0x00ab }
            r12.write(r2)     // Catch:{ all -> 0x00ab }
            r12.close()     // Catch:{ IOException -> 0x009e }
            goto L_0x010a
        L_0x0096:
            r12 = move-exception
            r4 = r5
            goto L_0x01b8
        L_0x009a:
            r12 = move-exception
            r4 = r5
            goto L_0x01a5
        L_0x009e:
            r12 = move-exception
            java.lang.String r2 = f23883c     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            Y3.a$b r2 = Y3.C2611a.b(r2)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r2.b(r12, r3, r6)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            goto L_0x010a
        L_0x00ab:
            r0 = move-exception
            r4 = r12
            goto L_0x00af
        L_0x00ae:
            r0 = move-exception
        L_0x00af:
            if (r4 == 0) goto L_0x00c1
            r4.close()     // Catch:{ IOException -> 0x00b5 }
            goto L_0x00c1
        L_0x00b5:
            r12 = move-exception
            java.lang.String r2 = f23883c     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            Y3.a$b r2 = Y3.C2611a.b(r2)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r2.b(r12, r3, r4)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
        L_0x00c1:
            throw r0     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
        L_0x00c2:
            r12 = move-exception
            r6.close()     // Catch:{ all -> 0x00c7 }
            goto L_0x00cb
        L_0x00c7:
            r0 = move-exception
            r12.addSuppressed(r0)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
        L_0x00cb:
            throw r12     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
        L_0x00cc:
            java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch:{ all -> 0x00f3 }
            java.io.OutputStreamWriter r6 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x00f3 }
            java.io.OutputStream r7 = r5.getOutputStream()     // Catch:{ all -> 0x00f3 }
            java.nio.charset.Charset r8 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x00f3 }
            r6.<init>(r7, r8)     // Catch:{ all -> 0x00f3 }
            r3.<init>(r6)     // Catch:{ all -> 0x00f3 }
            r3.write(r12)     // Catch:{ all -> 0x00f0 }
            r3.close()     // Catch:{ IOException -> 0x00e3 }
            goto L_0x010a
        L_0x00e3:
            r12 = move-exception
            java.lang.String r3 = f23883c     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            Y3.a$b r3 = Y3.C2611a.b(r3)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r3.b(r12, r2, r6)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            goto L_0x010a
        L_0x00f0:
            r12 = move-exception
            r4 = r3
            goto L_0x00f4
        L_0x00f3:
            r12 = move-exception
        L_0x00f4:
            if (r4 == 0) goto L_0x0106
            r4.close()     // Catch:{ IOException -> 0x00fa }
            goto L_0x0106
        L_0x00fa:
            r0 = move-exception
            java.lang.String r3 = f23883c     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            Y3.a$b r3 = Y3.C2611a.b(r3)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r3.b(r0, r2, r4)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
        L_0x0106:
            throw r12     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
        L_0x0107:
            r5.setDoOutput(r1)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
        L_0x010a:
            int r12 = r5.getResponseCode()     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.String r2 = f23883c     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            Y3.a$b r2 = Y3.C2611a.b(r2)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.String r3 = "Transmission finished (code=%d)."
            java.lang.Integer r6 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.Object[] r7 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r7[r1] = r6     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r2.g(r3, r7)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            boolean r2 = d(r12)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.String r3 = "Failed to close the error stream."
            if (r2 == 0) goto L_0x0140
            java.io.InputStream r12 = r5.getInputStream()     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            if (r12 == 0) goto L_0x018a
            r12.close()     // Catch:{ IOException -> 0x0133 }
            goto L_0x018a
        L_0x0133:
            r12 = move-exception
            java.lang.String r0 = f23883c     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            Y3.a$b r0 = Y3.C2611a.b(r0)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r0.b(r12, r3, r4)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            goto L_0x018a
        L_0x0140:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r6.<init>()     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ all -> 0x018e }
            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch:{ all -> 0x018e }
            java.io.InputStream r9 = r5.getErrorStream()     // Catch:{ all -> 0x018e }
            r8.<init>(r9)     // Catch:{ all -> 0x018e }
            r7.<init>(r8)     // Catch:{ all -> 0x018e }
        L_0x0153:
            java.lang.String r4 = r7.readLine()     // Catch:{ all -> 0x015d }
            if (r4 == 0) goto L_0x0160
            r6.append(r4)     // Catch:{ all -> 0x015d }
            goto L_0x0153
        L_0x015d:
            r12 = move-exception
            r4 = r7
            goto L_0x018f
        L_0x0160:
            r7.close()     // Catch:{ IOException -> 0x0164 }
            goto L_0x0170
        L_0x0164:
            r4 = move-exception
            java.lang.String r7 = f23883c     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            Y3.a$b r7 = Y3.C2611a.b(r7)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r7.b(r4, r3, r8)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
        L_0x0170:
            java.lang.String r3 = f23883c     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            Y3.a$b r3 = Y3.C2611a.b(r3)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.String r4 = "Transmission failed (code=%d, reason=%s)"
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r7[r1] = r12     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r7[r0] = r6     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r3.h(r4, r7)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
        L_0x018a:
            r5.disconnect()
            return r2
        L_0x018e:
            r12 = move-exception
        L_0x018f:
            if (r4 == 0) goto L_0x01a1
            r4.close()     // Catch:{ IOException -> 0x0195 }
            goto L_0x01a1
        L_0x0195:
            r0 = move-exception
            java.lang.String r2 = f23883c     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            Y3.a$b r2 = Y3.C2611a.b(r2)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r2.b(r0, r3, r4)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
        L_0x01a1:
            throw r12     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
        L_0x01a2:
            r12 = move-exception
            goto L_0x01b8
        L_0x01a4:
            r12 = move-exception
        L_0x01a5:
            java.lang.String r0 = f23883c     // Catch:{ all -> 0x01a2 }
            Y3.a$b r0 = Y3.C2611a.b(r0)     // Catch:{ all -> 0x01a2 }
            java.lang.String r2 = "Transmission failed unexpectedly."
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x01a2 }
            r0.e(r12, r2, r3)     // Catch:{ all -> 0x01a2 }
            if (r4 == 0) goto L_0x01b7
            r4.disconnect()
        L_0x01b7:
            return r1
        L_0x01b8:
            if (r4 == 0) goto L_0x01bd
            r4.disconnect()
        L_0x01bd:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: Q3.C2552c.c(Q3.j):boolean");
    }
}
