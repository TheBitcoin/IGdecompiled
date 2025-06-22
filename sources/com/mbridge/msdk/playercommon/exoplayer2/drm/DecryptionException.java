package com.mbridge.msdk.playercommon.exoplayer2.drm;

public class DecryptionException extends Exception {
    public final int errorCode;

    public DecryptionException(int i4, String str) {
        super(str);
        this.errorCode = i4;
    }
}
