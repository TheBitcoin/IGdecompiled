package com.google.android.gms.common.api.internal;

import J.C0303b;
import L.C0318b;
import M.C0322c;
import M.C0324e;
import M.C0332m;
import M.C0336q;
import R.b;
import android.os.SystemClock;
import com.google.android.gms.common.api.Status;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import k0.C0931f;
import k0.C0937l;

final class r implements C0931f {

    /* renamed from: a  reason: collision with root package name */
    private final C0504c f1352a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1353b;

    /* renamed from: c  reason: collision with root package name */
    private final C0318b f1354c;

    /* renamed from: d  reason: collision with root package name */
    private final long f1355d;

    /* renamed from: e  reason: collision with root package name */
    private final long f1356e;

    r(C0504c cVar, int i4, C0318b bVar, long j4, long j5, String str, String str2) {
        this.f1352a = cVar;
        this.f1353b = i4;
        this.f1354c = bVar;
        this.f1355d = j4;
        this.f1356e = j5;
    }

    static r b(C0504c cVar, int i4, C0318b bVar) {
        boolean z4;
        long j4;
        if (!cVar.e()) {
            return null;
        }
        M.r a5 = C0336q.b().a();
        if (a5 == null) {
            z4 = true;
        } else if (!a5.h()) {
            return null;
        } else {
            z4 = a5.j();
            n t4 = cVar.t(bVar);
            if (t4 != null) {
                if (!(t4.v() instanceof C0322c)) {
                    return null;
                }
                C0322c cVar2 = (C0322c) t4.v();
                if (cVar2.J() && !cVar2.f()) {
                    C0324e c5 = c(t4, cVar2, i4);
                    if (c5 == null) {
                        return null;
                    }
                    t4.G();
                    z4 = c5.k();
                }
            }
        }
        long j5 = 0;
        if (z4) {
            j4 = System.currentTimeMillis();
        } else {
            j4 = 0;
        }
        if (z4) {
            j5 = SystemClock.elapsedRealtime();
        }
        return new r(cVar, i4, bVar, j4, j5, (String) null, (String) null);
    }

    private static C0324e c(n nVar, C0322c cVar, int i4) {
        int[] g4;
        int[] h4;
        C0324e H4 = cVar.H();
        if (H4 == null || !H4.j() || ((g4 = H4.g()) != null ? !b.a(g4, i4) : !((h4 = H4.h()) == null || !b.a(h4, i4))) || nVar.t() >= H4.c()) {
            return null;
        }
        return H4;
    }

    public final void a(C0937l lVar) {
        n t4;
        boolean z4;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        long j4;
        long j5;
        if (this.f1352a.e()) {
            M.r a5 = C0336q.b().a();
            if ((a5 == null || a5.h()) && (t4 = this.f1352a.t(this.f1354c)) != null && (t4.v() instanceof C0322c)) {
                C0322c cVar = (C0322c) t4.v();
                boolean z5 = true;
                if (this.f1355d > 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                int z6 = cVar.z();
                if (a5 != null) {
                    boolean j6 = z4 & a5.j();
                    int c5 = a5.c();
                    int g4 = a5.g();
                    i6 = a5.k();
                    if (cVar.J() && !cVar.f()) {
                        C0324e c6 = c(t4, cVar, this.f1353b);
                        if (c6 != null) {
                            if (!c6.k() || this.f1355d <= 0) {
                                z5 = false;
                            }
                            g4 = c6.c();
                            j6 = z5;
                        } else {
                            return;
                        }
                    }
                    i5 = c5;
                    i4 = g4;
                } else {
                    i6 = 0;
                    i5 = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS;
                    i4 = 100;
                }
                C0504c cVar2 = this.f1352a;
                if (lVar.n()) {
                    i8 = 0;
                    i7 = 0;
                } else {
                    if (lVar.l()) {
                        i8 = 100;
                    } else {
                        Exception i10 = lVar.i();
                        if (i10 instanceof K.b) {
                            Status a6 = ((K.b) i10).a();
                            int g5 = a6.g();
                            C0303b c7 = a6.c();
                            if (c7 == null) {
                                i8 = g5;
                            } else {
                                i7 = c7.c();
                                i8 = g5;
                            }
                        } else {
                            i8 = 101;
                        }
                    }
                    i7 = -1;
                }
                if (z4) {
                    long j7 = this.f1355d;
                    long j8 = this.f1356e;
                    j5 = j7;
                    j4 = System.currentTimeMillis();
                    i9 = (int) (SystemClock.elapsedRealtime() - j8);
                } else {
                    j5 = 0;
                    j4 = 0;
                    i9 = -1;
                }
                cVar2.C(new C0332m(this.f1353b, i8, i7, j5, j4, (String) null, (String) null, z6, i9), i6, (long) i5, i4);
            }
        }
    }
}
