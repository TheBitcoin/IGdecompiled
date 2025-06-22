package com.mbridge.msdk.foundation.download.utils;

public final class Utils {
    private Utils() {
    }

    public static int getDownloadRate(long j4, long j5) {
        if (j4 == 0 || j5 == 0) {
            return 0;
        }
        if (j4 == j5) {
            return 100;
        }
        return (int) (((((double) j5) * 1.0d) / (((double) j4) * 1.0d)) * 100.0d);
    }
}
