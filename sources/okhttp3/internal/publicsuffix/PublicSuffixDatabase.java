package okhttp3.internal.publicsuffix;

import E3.c;
import L3.C2499f;
import N3.C2516g;
import N3.C2524o;
import N3.L;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public final class PublicSuffixDatabase {

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f24659e = {42};

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f24660f = new String[0];

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f24661g = {"*"};

    /* renamed from: h  reason: collision with root package name */
    private static final PublicSuffixDatabase f24662h = new PublicSuffixDatabase();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f24663a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private final CountDownLatch f24664b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    private byte[] f24665c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f24666d;

    private static String a(byte[] bArr, byte[][] bArr2, int i4) {
        int i5;
        boolean z4;
        byte b5;
        int i6;
        byte[] bArr3 = bArr;
        byte[][] bArr4 = bArr2;
        int length = bArr3.length;
        int i7 = 0;
        while (i7 < length) {
            int i8 = (i7 + length) / 2;
            while (i8 > -1 && bArr3[i8] != 10) {
                i8--;
            }
            int i9 = i8 + 1;
            int i10 = 1;
            while (true) {
                i5 = i9 + i10;
                if (bArr3[i5] == 10) {
                    break;
                }
                i10++;
            }
            int i11 = i5 - i9;
            int i12 = i4;
            boolean z5 = false;
            int i13 = 0;
            int i14 = 0;
            while (true) {
                if (z5) {
                    b5 = 46;
                    z4 = false;
                } else {
                    z4 = z5;
                    b5 = bArr4[i12][i13] & 255;
                }
                i6 = b5 - (bArr3[i9 + i14] & 255);
                if (i6 == 0) {
                    i14++;
                    i13++;
                    if (i14 == i11) {
                        break;
                    } else if (bArr4[i12].length != i13) {
                        z5 = z4;
                    } else if (i12 == bArr4.length - 1) {
                        break;
                    } else {
                        i12++;
                        z5 = true;
                        i13 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i6 >= 0) {
                if (i6 <= 0) {
                    int i15 = i11 - i14;
                    int length2 = bArr4[i12].length - i13;
                    while (true) {
                        i12++;
                        if (i12 >= bArr4.length) {
                            break;
                        }
                        length2 += bArr4[i12].length;
                    }
                    if (length2 >= i15) {
                        if (length2 <= i15) {
                            return new String(bArr3, i9, i11, c.f23251j);
                        }
                    }
                }
                i7 = i5 + 1;
            }
            length = i8;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0066 A[LOOP:3: B:33:0x0066->B:38:0x0074, LOOP_START, PHI: r1 
      PHI: (r1v2 int) = (r1v0 int), (r1v3 int) binds: [B:32:0x0064, B:38:0x0074] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String[] b(java.lang.String[] r9) {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f24663a
            boolean r0 = r0.get()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0016
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f24663a
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L_0x0016
            r8.f()
            goto L_0x001b
        L_0x0016:
            java.util.concurrent.CountDownLatch r0 = r8.f24664b     // Catch:{ InterruptedException -> 0x001b }
            r0.await()     // Catch:{ InterruptedException -> 0x001b }
        L_0x001b:
            monitor-enter(r8)
            byte[] r0 = r8.f24665c     // Catch:{ all -> 0x00b5 }
            if (r0 == 0) goto L_0x00b7
            monitor-exit(r8)     // Catch:{ all -> 0x00b5 }
            int r0 = r9.length
            byte[][] r3 = new byte[r0][]
            r4 = 0
        L_0x0025:
            int r5 = r9.length
            if (r4 >= r5) goto L_0x0035
            r5 = r9[r4]
            java.nio.charset.Charset r6 = E3.c.f23251j
            byte[] r5 = r5.getBytes(r6)
            r3[r4] = r5
            int r4 = r4 + 1
            goto L_0x0025
        L_0x0035:
            r9 = 0
        L_0x0036:
            r4 = 0
            if (r9 >= r0) goto L_0x0045
            byte[] r5 = r8.f24665c
            java.lang.String r5 = a(r5, r3, r9)
            if (r5 == 0) goto L_0x0042
            goto L_0x0046
        L_0x0042:
            int r9 = r9 + 1
            goto L_0x0036
        L_0x0045:
            r5 = r4
        L_0x0046:
            if (r0 <= r2) goto L_0x0063
            java.lang.Object r9 = r3.clone()
            byte[][] r9 = (byte[][]) r9
            r6 = 0
        L_0x004f:
            int r7 = r9.length
            int r7 = r7 - r2
            if (r6 >= r7) goto L_0x0063
            byte[] r7 = f24659e
            r9[r6] = r7
            byte[] r7 = r8.f24665c
            java.lang.String r7 = a(r7, r9, r6)
            if (r7 == 0) goto L_0x0060
            goto L_0x0064
        L_0x0060:
            int r6 = r6 + 1
            goto L_0x004f
        L_0x0063:
            r7 = r4
        L_0x0064:
            if (r7 == 0) goto L_0x0077
        L_0x0066:
            int r9 = r0 + -1
            if (r1 >= r9) goto L_0x0077
            byte[] r9 = r8.f24666d
            java.lang.String r9 = a(r9, r3, r1)
            if (r9 == 0) goto L_0x0074
            r4 = r9
            goto L_0x0077
        L_0x0074:
            int r1 = r1 + 1
            goto L_0x0066
        L_0x0077:
            if (r4 == 0) goto L_0x0091
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "!"
            r9.append(r0)
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            java.lang.String r0 = "\\."
            java.lang.String[] r9 = r9.split(r0)
            return r9
        L_0x0091:
            if (r5 != 0) goto L_0x0098
            if (r7 != 0) goto L_0x0098
            java.lang.String[] r9 = f24661g
            return r9
        L_0x0098:
            if (r5 == 0) goto L_0x00a1
            java.lang.String r9 = "\\."
            java.lang.String[] r9 = r5.split(r9)
            goto L_0x00a3
        L_0x00a1:
            java.lang.String[] r9 = f24660f
        L_0x00a3:
            if (r7 == 0) goto L_0x00ac
            java.lang.String r0 = "\\."
            java.lang.String[] r0 = r7.split(r0)
            goto L_0x00ae
        L_0x00ac:
            java.lang.String[] r0 = f24660f
        L_0x00ae:
            int r1 = r9.length
            int r2 = r0.length
            if (r1 <= r2) goto L_0x00b3
            goto L_0x00b4
        L_0x00b3:
            r9 = r0
        L_0x00b4:
            return r9
        L_0x00b5:
            r9 = move-exception
            goto L_0x00bf
        L_0x00b7:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00b5 }
            java.lang.String r0 = "Unable to load publicsuffixes.gz resource from the classpath."
            r9.<init>(r0)     // Catch:{ all -> 0x00b5 }
            throw r9     // Catch:{ all -> 0x00b5 }
        L_0x00bf:
            monitor-exit(r8)     // Catch:{ all -> 0x00b5 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.b(java.lang.String[]):java.lang.String[]");
    }

    public static PublicSuffixDatabase c() {
        return f24662h;
    }

    private void e() {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(com.mbridge.msdk.thrid.okhttp.internal.publicsuffix.PublicSuffixDatabase.PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream != null) {
            C2516g d5 = L.d(new C2524o(L.l(resourceAsStream)));
            try {
                byte[] bArr = new byte[d5.readInt()];
                d5.readFully(bArr);
                byte[] bArr2 = new byte[d5.readInt()];
                d5.readFully(bArr2);
                synchronized (this) {
                    this.f24665c = bArr;
                    this.f24666d = bArr2;
                }
                this.f24664b.countDown();
            } finally {
                c.d(d5);
            }
        }
    }

    private void f() {
        boolean z4 = false;
        while (true) {
            try {
                e();
                break;
            } catch (InterruptedIOException unused) {
                z4 = true;
            } catch (IOException e5) {
                C2499f.i().p(5, "Failed to read public suffix list", e5);
                if (!z4) {
                    return;
                }
            } catch (Throwable th) {
                if (z4) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (!z4) {
            return;
        }
        Thread.currentThread().interrupt();
    }

    public String d(String str) {
        int length;
        int length2;
        if (str != null) {
            String[] split = IDN.toUnicode(str).split("\\.");
            String[] b5 = b(split);
            if (split.length == b5.length && b5[0].charAt(0) != '!') {
                return null;
            }
            if (b5[0].charAt(0) == '!') {
                length = split.length;
                length2 = b5.length;
            } else {
                length = split.length;
                length2 = b5.length + 1;
            }
            StringBuilder sb = new StringBuilder();
            String[] split2 = str.split("\\.");
            for (int i4 = length - length2; i4 < split2.length; i4++) {
                sb.append(split2[i4]);
                sb.append('.');
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        throw new NullPointerException("domain == null");
    }
}
