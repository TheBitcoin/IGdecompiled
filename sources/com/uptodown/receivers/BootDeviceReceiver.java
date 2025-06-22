package com.uptodown.receivers;

import N1.k;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.uptodown.UptodownApp;
import m3.m;
import u2.C2313C;

public final class BootDeviceReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                if (intent.getAction() != null && m.p(intent.getAction(), "android.intent.action.BOOT_COMPLETED", true) && context != null) {
                    UptodownApp.f17422D.o0(context);
                    C2313C.f21882a.F(k.f7778g.a(context));
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }
}
