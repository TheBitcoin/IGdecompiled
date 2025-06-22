package com.mbridge.msdk.playercommon.exoplayer2.drm;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class UnsupportedDrmException extends Exception {
    public static final int REASON_INSTANTIATION_ERROR = 2;
    public static final int REASON_UNSUPPORTED_SCHEME = 1;
    public final int reason;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Reason {
    }

    public UnsupportedDrmException(int i4) {
        this.reason = i4;
    }

    public UnsupportedDrmException(int i4, Exception exc) {
        super(exc);
        this.reason = i4;
    }
}
