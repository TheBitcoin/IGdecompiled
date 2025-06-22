package a0;

import android.os.Build;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f662a;

    static {
        int i4;
        if (Build.VERSION.SDK_INT >= 31) {
            i4 = 33554432;
        } else {
            i4 = 0;
        }
        f662a = i4;
    }
}
