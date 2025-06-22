package com.mbridge.msdk.foundation.tools;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.concurrent.atomic.AtomicInteger;

public final class at {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f13615a = new AtomicInteger(1);

    public static void a(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static int a() {
        AtomicInteger atomicInteger;
        int i4;
        int i5;
        do {
            atomicInteger = f13615a;
            i4 = atomicInteger.get();
            i5 = i4 + 1;
            if (i5 > 16777215) {
                i5 = 1;
            }
        } while (!atomicInteger.compareAndSet(i4, i5));
        return i4;
    }
}
