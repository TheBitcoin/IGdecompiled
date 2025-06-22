package com.google.android.gms.measurement.internal;

import M.C0335p;
import com.google.android.gms.internal.measurement.M0;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class Q2 extends FutureTask implements Comparable {

    /* renamed from: a  reason: collision with root package name */
    private final long f2692a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f2693b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2694c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ P2 f2695d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Q2(P2 p22, Runnable runnable, boolean z4, String str) {
        super(M0.a().b(runnable), (Object) null);
        this.f2695d = p22;
        C0335p.l(str);
        long andIncrement = P2.f2674l.getAndIncrement();
        this.f2692a = andIncrement;
        this.f2694c = str;
        this.f2693b = z4;
        if (andIncrement == Long.MAX_VALUE) {
            p22.a().G().a("Tasks index overflow");
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        Q2 q22 = (Q2) obj;
        boolean z4 = this.f2693b;
        if (z4 == q22.f2693b) {
            long j4 = this.f2692a;
            long j5 = q22.f2692a;
            if (j4 < j5) {
                return -1;
            }
            if (j4 > j5) {
                return 1;
            }
            this.f2695d.a().I().b("Two tasks share the same index. index", Long.valueOf(this.f2692a));
            return 0;
        } else if (z4) {
            return -1;
        } else {
            return 1;
        }
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th) {
        this.f2695d.a().G().b(this.f2694c, th);
        super.setException(th);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Q2(P2 p22, Callable callable, boolean z4, String str) {
        super(M0.a().a(callable));
        this.f2695d = p22;
        C0335p.l(str);
        long andIncrement = P2.f2674l.getAndIncrement();
        this.f2692a = andIncrement;
        this.f2694c = str;
        this.f2693b = z4;
        if (andIncrement == Long.MAX_VALUE) {
            p22.a().G().a("Tasks index overflow");
        }
    }
}
