package D3;

import E3.C2477b;
import F3.C2478a;
import G3.C2481a;
import G3.c;
import H3.C2482a;
import H3.C2483b;
import H3.C2484c;
import H3.g;
import H3.j;
import L3.C2499f;
import java.io.IOException;
import java.util.ArrayList;

/* renamed from: D3.w  reason: case insensitive filesystem */
final class C2475w implements C2457e {

    /* renamed from: a  reason: collision with root package name */
    final C2473u f23195a;

    /* renamed from: b  reason: collision with root package name */
    final j f23196b;

    /* renamed from: c  reason: collision with root package name */
    private C2467o f23197c;

    /* renamed from: d  reason: collision with root package name */
    final x f23198d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f23199e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f23200f;

    /* renamed from: D3.w$a */
    final class a extends C2477b {
    }

    private C2475w(C2473u uVar, x xVar, boolean z4) {
        this.f23195a = uVar;
        this.f23198d = xVar;
        this.f23199e = z4;
        this.f23196b = new j(uVar, z4);
    }

    private void a() {
        this.f23196b.h(C2499f.i().m("response.body().close()"));
    }

    static C2475w d(C2473u uVar, x xVar, boolean z4) {
        C2475w wVar = new C2475w(uVar, xVar, z4);
        wVar.f23197c = uVar.k().a(wVar);
        return wVar;
    }

    /* renamed from: b */
    public C2475w clone() {
        return d(this.f23195a, this.f23198d, this.f23199e);
    }

    /* access modifiers changed from: package-private */
    public z c() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f23195a.o());
        arrayList.add(this.f23196b);
        arrayList.add(new C2482a(this.f23195a.h()));
        arrayList.add(new C2478a(this.f23195a.p()));
        arrayList.add(new C2481a(this.f23195a));
        if (!this.f23199e) {
            arrayList.addAll(this.f23195a.q());
        }
        arrayList.add(new C2483b(this.f23199e));
        return new g(arrayList, (G3.g) null, (C2484c) null, (c) null, 0, this.f23198d, this, this.f23197c, this.f23195a.e(), this.f23195a.z(), this.f23195a.F()).a(this.f23198d);
    }

    public z execute() {
        synchronized (this) {
            if (!this.f23200f) {
                this.f23200f = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        a();
        this.f23197c.c(this);
        try {
            this.f23195a.i().a(this);
            z c5 = c();
            if (c5 != null) {
                this.f23195a.i().c(this);
                return c5;
            }
            throw new IOException("Canceled");
        } catch (IOException e5) {
            this.f23197c.b(this, e5);
            throw e5;
        } catch (Throwable th) {
            this.f23195a.i().c(this);
            throw th;
        }
    }
}
