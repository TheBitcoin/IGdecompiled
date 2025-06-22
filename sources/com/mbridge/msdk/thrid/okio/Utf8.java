package com.mbridge.msdk.thrid.okio;

public final class Utf8 {
    private Utf8() {
    }

    public static long size(String str) {
        return size(str, 0, str.length());
    }

    public static long size(String str, int i4, int i5) {
        long j4;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i4 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i4);
        } else if (i5 < i4) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i5 + " < " + i4);
        } else if (i5 <= str.length()) {
            long j5 = 0;
            while (i4 < i5) {
                char charAt = str.charAt(i4);
                if (charAt < 128) {
                    j5++;
                } else {
                    if (charAt < 2048) {
                        j4 = 2;
                    } else if (charAt < 55296 || charAt > 57343) {
                        j4 = 3;
                    } else {
                        int i6 = i4 + 1;
                        char charAt2 = i6 < i5 ? str.charAt(i6) : 0;
                        if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                            j5++;
                            i4 = i6;
                        } else {
                            j5 += 4;
                            i4 += 2;
                        }
                    }
                    j5 += j4;
                }
                i4++;
            }
            return j5;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i5 + " > " + str.length());
        }
    }
}
