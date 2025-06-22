package com.google.android.gms.measurement.internal;

import M.C0332m;
import M.C0338t;
import M.C0339u;
import M.C0340v;
import M.C0341w;
import android.content.Context;
import j$.time.Duration;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.google.android.gms.measurement.internal.l2  reason: case insensitive filesystem */
public final class C0807l2 {

    /* renamed from: d  reason: collision with root package name */
    private static C0807l2 f3094d;

    /* renamed from: e  reason: collision with root package name */
    private static final Duration f3095e = Duration.ofMinutes(30);

    /* renamed from: a  reason: collision with root package name */
    private final S2 f3096a;

    /* renamed from: b  reason: collision with root package name */
    private final C0340v f3097b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicLong f3098c = new AtomicLong(-1);

    private C0807l2(Context context, S2 s22) {
        this.f3097b = C0339u.b(context, C0341w.a().b("measurement:api").a());
        this.f3096a = s22;
    }

    static C0807l2 a(S2 s22) {
        if (f3094d == null) {
            f3094d = new C0807l2(s22.A(), s22);
        }
        return f3094d;
    }

    public final synchronized void b(int i4, int i5, long j4, long j5, int i6) {
        synchronized (this) {
            long elapsedRealtime = this.f3096a.B().elapsedRealtime();
            if (this.f3098c.get() != -1) {
                if (elapsedRealtime - this.f3098c.get() <= f3095e.toMillis()) {
                    return;
                }
            }
            this.f3097b.a(new C0338t(0, Arrays.asList(new C0332m[]{new C0332m(36301, i5, 0, j4, j5, (String) null, (String) null, 0, i6)}))).e(new C0800k2(this, elapsedRealtime));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void c(long j4, Exception exc) {
        this.f3098c.set(j4);
    }
}
