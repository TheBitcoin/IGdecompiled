package com.mbridge.msdk.thrid.okhttp.internal.publicsuffix;

import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import com.mbridge.msdk.thrid.okio.GzipSource;
import com.mbridge.msdk.thrid.okio.Okio;
import com.mbridge.msdk.thrid.okio.Source;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public final class PublicSuffixDatabase {
    private static final String[] EMPTY_RULE = new String[0];
    private static final byte EXCEPTION_MARKER = 33;
    private static final String[] PREVAILING_RULE = {"*"};
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private static final byte[] WILDCARD_LABEL = {42};
    private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    private static String binarySearchBytes(byte[] bArr, byte[][] bArr2, int i4) {
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
                            return new String(bArr3, i9, i11, Util.UTF_8);
                        }
                    }
                }
                i7 = i5 + 1;
            }
            length = i8;
        }
        return null;
    }

    private String[] findMatchingRule(String[] strArr) {
        String str;
        String str2;
        String str3;
        String[] strArr2;
        String[] strArr3;
        int i4 = 0;
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            readTheListUninterruptibly();
        }
        synchronized (this) {
            if (this.publicSuffixListBytes == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i5 = 0; i5 < strArr.length; i5++) {
            bArr[i5] = strArr[i5].getBytes(Util.UTF_8);
        }
        int i6 = 0;
        while (true) {
            str = null;
            if (i6 >= length) {
                str2 = null;
                break;
            }
            str2 = binarySearchBytes(this.publicSuffixListBytes, bArr, i6);
            if (str2 != null) {
                break;
            }
            i6++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            int i7 = 0;
            while (true) {
                if (i7 >= bArr2.length - 1) {
                    break;
                }
                bArr2[i7] = WILDCARD_LABEL;
                str3 = binarySearchBytes(this.publicSuffixListBytes, bArr2, i7);
                if (str3 != null) {
                    break;
                }
                i7++;
            }
        }
        str3 = null;
        if (str3 != null) {
            while (true) {
                if (i4 >= length - 1) {
                    break;
                }
                String binarySearchBytes = binarySearchBytes(this.publicSuffixExceptionListBytes, bArr, i4);
                if (binarySearchBytes != null) {
                    str = binarySearchBytes;
                    break;
                }
                i4++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        } else if (str2 == null && str3 == null) {
            return PREVAILING_RULE;
        } else {
            if (str2 != null) {
                strArr2 = str2.split("\\.");
            } else {
                strArr2 = EMPTY_RULE;
            }
            if (str3 != null) {
                strArr3 = str3.split("\\.");
            } else {
                strArr3 = EMPTY_RULE;
            }
            if (strArr2.length > strArr3.length) {
                return strArr2;
            }
            return strArr3;
        }
    }

    public static PublicSuffixDatabase get() {
        return instance;
    }

    private void readTheList() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream != null) {
            BufferedSource buffer = Okio.buffer((Source) new GzipSource(Okio.source(resourceAsStream)));
            try {
                byte[] bArr = new byte[buffer.readInt()];
                buffer.readFully(bArr);
                byte[] bArr2 = new byte[buffer.readInt()];
                buffer.readFully(bArr2);
                synchronized (this) {
                    this.publicSuffixListBytes = bArr;
                    this.publicSuffixExceptionListBytes = bArr2;
                }
                this.readCompleteLatch.countDown();
            } finally {
                Util.closeQuietly((Closeable) buffer);
            }
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readTheListUninterruptibly() {
        /*
            r5 = this;
            r0 = 0
        L_0x0001:
            r5.readTheList()     // Catch:{ InterruptedIOException -> 0x001f, IOException -> 0x0010 }
            if (r0 == 0) goto L_0x001e
        L_0x0006:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            goto L_0x001e
        L_0x000e:
            r1 = move-exception
            goto L_0x0024
        L_0x0010:
            r1 = move-exception
            com.mbridge.msdk.thrid.okhttp.internal.platform.Platform r2 = com.mbridge.msdk.thrid.okhttp.internal.platform.Platform.get()     // Catch:{ all -> 0x000e }
            java.lang.String r3 = "Failed to read public suffix list"
            r4 = 5
            r2.log(r4, r3, r1)     // Catch:{ all -> 0x000e }
            if (r0 == 0) goto L_0x001e
            goto L_0x0006
        L_0x001e:
            return
        L_0x001f:
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x000e }
            r0 = 1
            goto L_0x0001
        L_0x0024:
            if (r0 == 0) goto L_0x002d
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x002d:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.publicsuffix.PublicSuffixDatabase.readTheListUninterruptibly():void");
    }

    public String getEffectiveTldPlusOne(String str) {
        int length;
        int length2;
        if (str != null) {
            String[] split = IDN.toUnicode(str).split("\\.");
            String[] findMatchingRule = findMatchingRule(split);
            if (split.length == findMatchingRule.length && findMatchingRule[0].charAt(0) != '!') {
                return null;
            }
            if (findMatchingRule[0].charAt(0) == '!') {
                length = split.length;
                length2 = findMatchingRule.length;
            } else {
                length = split.length;
                length2 = findMatchingRule.length + 1;
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

    /* access modifiers changed from: package-private */
    public void setListBytes(byte[] bArr, byte[] bArr2) {
        this.publicSuffixListBytes = bArr;
        this.publicSuffixExceptionListBytes = bArr2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
