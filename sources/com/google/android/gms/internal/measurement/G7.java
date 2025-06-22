package com.google.android.gms.internal.measurement;

public enum G7 {
    DEBUG(3),
    ERROR(6),
    INFO(4),
    VERBOSE(2),
    WARN(5);

    private G7(int i4) {
    }

    public static G7 a(int i4) {
        if (i4 == 2) {
            return VERBOSE;
        }
        if (i4 == 3) {
            return DEBUG;
        }
        if (i4 == 5) {
            return WARN;
        }
        if (i4 != 6) {
            return INFO;
        }
        return ERROR;
    }
}
