package com.squareup.picasso;

public enum o {
    NO_CACHE(1),
    NO_STORE(2);
    

    /* renamed from: a  reason: collision with root package name */
    final int f17288a;

    private o(int i4) {
        this.f17288a = i4;
    }

    static boolean a(int i4) {
        if ((i4 & NO_CACHE.f17288a) == 0) {
            return true;
        }
        return false;
    }

    static boolean b(int i4) {
        if ((i4 & NO_STORE.f17288a) == 0) {
            return true;
        }
        return false;
    }
}
