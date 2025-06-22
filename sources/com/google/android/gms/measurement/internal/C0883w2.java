package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* renamed from: com.google.android.gms.measurement.internal.w2  reason: case insensitive filesystem */
class C0883w2 extends BroadcastReceiver {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final H5 f3270a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3271b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3272c;

    C0883w2(H5 h5) {
        C0335p.l(h5);
        this.f3270a = h5;
    }

    public final void b() {
        this.f3270a.A0();
        this.f3270a.f().k();
        if (!this.f3271b) {
            this.f3270a.A().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f3272c = this.f3270a.p0().z();
            this.f3270a.a().K().b("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f3272c));
            this.f3271b = true;
        }
    }

    public final void c() {
        this.f3270a.A0();
        this.f3270a.f().k();
        this.f3270a.f().k();
        if (this.f3271b) {
            this.f3270a.a().K().a("Unregistering connectivity change receiver");
            this.f3271b = false;
            this.f3272c = false;
            try {
                this.f3270a.A().unregisterReceiver(this);
            } catch (IllegalArgumentException e5) {
                this.f3270a.a().G().b("Failed to unregister the network broadcast receiver", e5);
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        this.f3270a.A0();
        String action = intent.getAction();
        this.f3270a.a().K().b("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean z4 = this.f3270a.p0().z();
            if (this.f3272c != z4) {
                this.f3272c = z4;
                this.f3270a.f().D(new C0876v2(this, z4));
                return;
            }
            return;
        }
        this.f3270a.a().L().b("NetworkBroadcastReceiver received unknown action", action);
    }
}
