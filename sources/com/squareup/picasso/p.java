package com.squareup.picasso;

public enum p {
    NO_CACHE(1),
    NO_STORE(2),
    OFFLINE(4);
    

    /* renamed from: a  reason: collision with root package name */
    final int f17293a;

    private p(int i4) {
        this.f17293a = i4;
    }

    public static boolean a(int i4) {
        if ((i4 & OFFLINE.f17293a) != 0) {
            return true;
        }
        return false;
    }

    public static boolean b(int i4) {
        if ((i4 & NO_CACHE.f17293a) == 0) {
            return true;
        }
        return false;
    }

    public static boolean c(int i4) {
        if ((i4 & NO_STORE.f17293a) == 0) {
            return true;
        }
        return false;
    }
}
