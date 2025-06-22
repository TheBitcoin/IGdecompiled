package com.uptodown.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import kotlin.jvm.internal.m;
import u2.s;

public final class AuthenticatorService extends Service {
    public IBinder onBind(Intent intent) {
        m.e(intent, "intent");
        IBinder iBinder = new s(this).getIBinder();
        m.d(iBinder, "getIBinder(...)");
        return iBinder;
    }
}
