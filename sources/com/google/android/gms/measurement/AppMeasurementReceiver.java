package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import f0.l;

public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements l.a {

    /* renamed from: a  reason: collision with root package name */
    private l f2278a;

    public final void a(Context context, Intent intent) {
        WakefulBroadcastReceiver.startWakefulService(context, intent);
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.f2278a == null) {
            this.f2278a = new l(this);
        }
        this.f2278a.a(context, intent);
    }
}
