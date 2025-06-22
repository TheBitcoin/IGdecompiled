package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.C0525c0;
import com.google.android.gms.internal.measurement.C0534d0;

public final class G2 implements ServiceConnection {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f2521a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ E2 f2522b;

    G2(E2 e22, String str) {
        this.f2522b = e22;
        this.f2521a = str;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.f2522b.f2370a.a().L().a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            C0534d0 i4 = C0525c0.i(iBinder);
            if (i4 == null) {
                this.f2522b.f2370a.a().L().a("Install Referrer Service implementation was not found");
                return;
            }
            this.f2522b.f2370a.a().K().a("Install Referrer Service connected");
            this.f2522b.f2370a.f().D(new F2(this, i4, this));
        } catch (RuntimeException e5) {
            this.f2522b.f2370a.a().L().b("Exception occurred while calling Install Referrer API", e5);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f2522b.f2370a.a().K().a("Install Referrer Service disconnected");
    }
}
