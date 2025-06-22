package com.mbridge.msdk.playercommon.exoplayer2.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class RepeatModeUtil {
    public static final int REPEAT_TOGGLE_MODE_ALL = 2;
    public static final int REPEAT_TOGGLE_MODE_NONE = 0;
    public static final int REPEAT_TOGGLE_MODE_ONE = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatToggleModes {
    }

    private RepeatModeUtil() {
    }

    public static int getNextRepeatMode(int i4, int i5) {
        for (int i6 = 1; i6 <= 2; i6++) {
            int i7 = (i4 + i6) % 3;
            if (isRepeatModeEnabled(i7, i5)) {
                return i7;
            }
        }
        return i4;
    }

    public static boolean isRepeatModeEnabled(int i4, int i5) {
        if (i4 != 0) {
            return i4 != 1 ? i4 == 2 && (i5 & 2) != 0 : (i5 & 1) != 0;
        }
        return true;
    }
}
