package com.google.android.gms.internal.measurement;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public abstract class B0 {

    /* renamed from: a  reason: collision with root package name */
    public static final int f1405a;

    static {
        int i4;
        if (Build.VERSION.SDK_INT >= 31) {
            i4 = 33554432;
        } else {
            i4 = 0;
        }
        f1405a = i4;
    }

    public static PendingIntent a(Context context, int i4, Intent intent, int i5) {
        return PendingIntent.getBroadcast(context, 0, intent, i5);
    }
}
