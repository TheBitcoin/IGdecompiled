package com.mbridge.msdk.playercommon.exoplayer2.upstream.crypto;

final class CryptoUtil {
    private CryptoUtil() {
    }

    public static long getFNV64Hash(String str) {
        long j4 = 0;
        if (str == null) {
            return 0;
        }
        for (int i4 = 0; i4 < str.length(); i4++) {
            long charAt = j4 ^ ((long) str.charAt(i4));
            j4 = charAt + (charAt << 1) + (charAt << 4) + (charAt << 5) + (charAt << 7) + (charAt << 8) + (charAt << 40);
        }
        return j4;
    }
}
