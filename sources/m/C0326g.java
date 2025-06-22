package M;

import J.C0308g;
import K.a;
import K.f;
import L.C0319c;
import L.h;
import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* renamed from: M.g  reason: case insensitive filesystem */
public abstract class C0326g extends C0322c implements a.f {

    /* renamed from: F  reason: collision with root package name */
    private final C0323d f531F;

    /* renamed from: G  reason: collision with root package name */
    private final Set f532G;

    /* renamed from: H  reason: collision with root package name */
    private final Account f533H;

    protected C0326g(Context context, Looper looper, int i4, C0323d dVar, f.a aVar, f.b bVar) {
        this(context, looper, i4, dVar, (C0319c) aVar, (h) bVar);
    }

    private final Set l0(Set set) {
        Set<Scope> k02 = k0(set);
        for (Scope contains : k02) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return k02;
    }

    /* access modifiers changed from: protected */
    public final Set C() {
        return this.f532G;
    }

    public Set c() {
        if (o()) {
            return this.f532G;
        }
        return Collections.EMPTY_SET;
    }

    /* access modifiers changed from: protected */
    public final C0323d j0() {
        return this.f531F;
    }

    public final Account u() {
        return this.f533H;
    }

    /* access modifiers changed from: protected */
    public Executor w() {
        return null;
    }

    protected C0326g(Context context, Looper looper, int i4, C0323d dVar, C0319c cVar, h hVar) {
        this(context, looper, C0327h.a(context), C0308g.n(), i4, dVar, (C0319c) C0335p.l(cVar), (h) C0335p.l(hVar));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected C0326g(android.content.Context r10, android.os.Looper r11, M.C0327h r12, J.C0308g r13, int r14, M.C0323d r15, L.C0319c r16, L.h r17) {
        /*
            r9 = this;
            r0 = r16
            r1 = r17
            r2 = 0
            if (r0 != 0) goto L_0x0009
            r6 = r2
            goto L_0x000f
        L_0x0009:
            M.E r3 = new M.E
            r3.<init>(r0)
            r6 = r3
        L_0x000f:
            if (r1 != 0) goto L_0x0013
        L_0x0011:
            r7 = r2
            goto L_0x0019
        L_0x0013:
            M.F r2 = new M.F
            r2.<init>(r1)
            goto L_0x0011
        L_0x0019:
            java.lang.String r8 = r15.j()
            r0 = r9
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r9.f531F = r15
            android.accounts.Account r2 = r15.a()
            r9.f533H = r2
            java.util.Set r1 = r15.d()
            java.util.Set r1 = r9.l0(r1)
            r9.f532G = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M.C0326g.<init>(android.content.Context, android.os.Looper, M.h, J.g, int, M.d, L.c, L.h):void");
    }

    /* access modifiers changed from: protected */
    public Set k0(Set set) {
        return set;
    }
}
