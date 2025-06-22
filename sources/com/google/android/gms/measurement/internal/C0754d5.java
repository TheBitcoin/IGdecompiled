package com.google.android.gms.measurement.internal;

import J.C0303b;
import M.C0322c;
import M.C0335p;
import Q.b;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import f0.C0917f;

/* renamed from: com.google.android.gms.measurement.internal.d5  reason: case insensitive filesystem */
public final class C0754d5 implements ServiceConnection, C0322c.a, C0322c.b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f2942a;

    /* renamed from: b  reason: collision with root package name */
    private volatile C0793j2 f2943b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ F4 f2944c;

    protected C0754d5(F4 f4) {
        this.f2944c = f4;
    }

    public final void a() {
        this.f2944c.k();
        Context A4 = this.f2944c.A();
        synchronized (this) {
            try {
                if (this.f2942a) {
                    this.f2944c.a().K().a("Connection attempt already in progress");
                } else if (this.f2943b == null || (!this.f2943b.f() && !this.f2943b.j())) {
                    this.f2943b = new C0793j2(A4, Looper.getMainLooper(), this, this);
                    this.f2944c.a().K().a("Connecting to remote service");
                    this.f2942a = true;
                    C0335p.l(this.f2943b);
                    this.f2943b.q();
                } else {
                    this.f2944c.a().K().a("Already awaiting connection attempt");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(Intent intent) {
        this.f2944c.k();
        Context A4 = this.f2944c.A();
        b b5 = b.b();
        synchronized (this) {
            try {
                if (this.f2942a) {
                    this.f2944c.a().K().a("Connection attempt already in progress");
                    return;
                }
                this.f2944c.a().K().a("Using local app measurement service");
                this.f2942a = true;
                b5.a(A4, intent, this.f2944c.f2396c, TsExtractor.TS_STREAM_TYPE_AC3);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        if (this.f2943b != null && (this.f2943b.j() || this.f2943b.f())) {
            this.f2943b.b();
        }
        this.f2943b = null;
    }

    public final void h(int i4) {
        C0335p.e("MeasurementServiceConnection.onConnectionSuspended");
        this.f2944c.a().F().a("Service connection suspended");
        this.f2944c.f().D(new C0782h5(this));
    }

    public final void i(C0303b bVar) {
        C0335p.e("MeasurementServiceConnection.onConnectionFailed");
        C0821n2 E4 = this.f2944c.f3273a.E();
        if (E4 != null) {
            E4.L().b("Service connection failed", bVar);
        }
        synchronized (this) {
            this.f2942a = false;
            this.f2943b = null;
        }
        this.f2944c.f().D(new C0775g5(this));
    }

    public final void k(Bundle bundle) {
        C0335p.e("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                C0335p.l(this.f2943b);
                this.f2944c.f().D(new C0761e5(this, (C0917f) this.f2943b.D()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f2943b = null;
                this.f2942a = false;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r3.f2944c.a().G().a("Service connect failed to get IMeasurementService");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0060 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
        /*
            r3 = this;
            java.lang.String r4 = "MeasurementServiceConnection.onServiceConnected"
            M.C0335p.e(r4)
            monitor-enter(r3)
            r4 = 0
            if (r5 != 0) goto L_0x001f
            r3.f2942a = r4     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.F4 r4 = r3.f2944c     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.n2 r4 = r4.a()     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.p2 r4 = r4.G()     // Catch:{ all -> 0x001c }
            java.lang.String r5 = "Service connected with null binder"
            r4.a(r5)     // Catch:{ all -> 0x001c }
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            return
        L_0x001c:
            r4 = move-exception
            goto L_0x0097
        L_0x001f:
            r0 = 0
            java.lang.String r1 = r5.getInterfaceDescriptor()     // Catch:{ RemoteException -> 0x0060 }
            java.lang.String r2 = "com.google.android.gms.measurement.internal.IMeasurementService"
            boolean r2 = r2.equals(r1)     // Catch:{ RemoteException -> 0x0060 }
            if (r2 == 0) goto L_0x0050
            java.lang.String r1 = "com.google.android.gms.measurement.internal.IMeasurementService"
            android.os.IInterface r1 = r5.queryLocalInterface(r1)     // Catch:{ RemoteException -> 0x0060 }
            boolean r2 = r1 instanceof f0.C0917f     // Catch:{ RemoteException -> 0x0060 }
            if (r2 == 0) goto L_0x003a
            f0.f r1 = (f0.C0917f) r1     // Catch:{ RemoteException -> 0x0060 }
        L_0x0038:
            r0 = r1
            goto L_0x0040
        L_0x003a:
            com.google.android.gms.measurement.internal.e2 r1 = new com.google.android.gms.measurement.internal.e2     // Catch:{ RemoteException -> 0x0060 }
            r1.<init>(r5)     // Catch:{ RemoteException -> 0x0060 }
            goto L_0x0038
        L_0x0040:
            com.google.android.gms.measurement.internal.F4 r5 = r3.f2944c     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.measurement.internal.n2 r5 = r5.a()     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.measurement.internal.p2 r5 = r5.K()     // Catch:{ RemoteException -> 0x0060 }
            java.lang.String r1 = "Bound to IMeasurementService interface"
            r5.a(r1)     // Catch:{ RemoteException -> 0x0060 }
            goto L_0x006f
        L_0x0050:
            com.google.android.gms.measurement.internal.F4 r5 = r3.f2944c     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.measurement.internal.n2 r5 = r5.a()     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.measurement.internal.p2 r5 = r5.G()     // Catch:{ RemoteException -> 0x0060 }
            java.lang.String r2 = "Got binder with a wrong descriptor"
            r5.b(r2, r1)     // Catch:{ RemoteException -> 0x0060 }
            goto L_0x006f
        L_0x0060:
            com.google.android.gms.measurement.internal.F4 r5 = r3.f2944c     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.n2 r5 = r5.a()     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.p2 r5 = r5.G()     // Catch:{ all -> 0x001c }
            java.lang.String r1 = "Service connect failed to get IMeasurementService"
            r5.a(r1)     // Catch:{ all -> 0x001c }
        L_0x006f:
            if (r0 != 0) goto L_0x0087
            r3.f2942a = r4     // Catch:{ all -> 0x001c }
            Q.b r4 = Q.b.b()     // Catch:{ IllegalArgumentException -> 0x0095 }
            com.google.android.gms.measurement.internal.F4 r5 = r3.f2944c     // Catch:{ IllegalArgumentException -> 0x0095 }
            android.content.Context r5 = r5.A()     // Catch:{ IllegalArgumentException -> 0x0095 }
            com.google.android.gms.measurement.internal.F4 r0 = r3.f2944c     // Catch:{ IllegalArgumentException -> 0x0095 }
            com.google.android.gms.measurement.internal.d5 r0 = r0.f2396c     // Catch:{ IllegalArgumentException -> 0x0095 }
            r4.c(r5, r0)     // Catch:{ IllegalArgumentException -> 0x0095 }
            goto L_0x0095
        L_0x0087:
            com.google.android.gms.measurement.internal.F4 r4 = r3.f2944c     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.P2 r4 = r4.f()     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.c5 r5 = new com.google.android.gms.measurement.internal.c5     // Catch:{ all -> 0x001c }
            r5.<init>(r3, r0)     // Catch:{ all -> 0x001c }
            r4.D(r5)     // Catch:{ all -> 0x001c }
        L_0x0095:
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            return
        L_0x0097:
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0754d5.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        C0335p.e("MeasurementServiceConnection.onServiceDisconnected");
        this.f2944c.a().F().a("Service disconnected");
        this.f2944c.f().D(new C0768f5(this, componentName));
    }
}
