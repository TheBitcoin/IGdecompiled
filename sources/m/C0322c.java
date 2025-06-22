package M;

import J.C0303b;
import J.C0305d;
import J.C0309h;
import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: M.c  reason: case insensitive filesystem */
public abstract class C0322c {

    /* renamed from: D  reason: collision with root package name */
    public static final String[] f453D = {"service_esmobile", "service_googleme"};

    /* renamed from: E  reason: collision with root package name */
    private static final C0305d[] f454E = new C0305d[0];
    /* access modifiers changed from: private */

    /* renamed from: A  reason: collision with root package name */
    public boolean f455A;

    /* renamed from: B  reason: collision with root package name */
    private volatile h0 f456B;

    /* renamed from: C  reason: collision with root package name */
    protected AtomicInteger f457C;

    /* renamed from: a  reason: collision with root package name */
    private int f458a;

    /* renamed from: b  reason: collision with root package name */
    private long f459b;

    /* renamed from: c  reason: collision with root package name */
    private long f460c;

    /* renamed from: d  reason: collision with root package name */
    private int f461d;

    /* renamed from: e  reason: collision with root package name */
    private long f462e;

    /* renamed from: f  reason: collision with root package name */
    private volatile String f463f;

    /* renamed from: g  reason: collision with root package name */
    s0 f464g;

    /* renamed from: h  reason: collision with root package name */
    private final Context f465h;

    /* renamed from: i  reason: collision with root package name */
    private final Looper f466i;

    /* renamed from: j  reason: collision with root package name */
    private final C0327h f467j;

    /* renamed from: k  reason: collision with root package name */
    private final C0309h f468k;

    /* renamed from: l  reason: collision with root package name */
    final Handler f469l;

    /* renamed from: m  reason: collision with root package name */
    private final Object f470m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final Object f471n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public C0331l f472o;

    /* renamed from: p  reason: collision with root package name */
    protected C0003c f473p;

    /* renamed from: q  reason: collision with root package name */
    private IInterface f474q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public final ArrayList f475r;

    /* renamed from: s  reason: collision with root package name */
    private e0 f476s;

    /* renamed from: t  reason: collision with root package name */
    private int f477t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public final a f478u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public final b f479v;

    /* renamed from: w  reason: collision with root package name */
    private final int f480w;

    /* renamed from: x  reason: collision with root package name */
    private final String f481x;

    /* renamed from: y  reason: collision with root package name */
    private volatile String f482y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public C0303b f483z;

    /* renamed from: M.c$a */
    public interface a {
        void h(int i4);

        void k(Bundle bundle);
    }

    /* renamed from: M.c$b */
    public interface b {
        void i(C0303b bVar);
    }

    /* renamed from: M.c$c  reason: collision with other inner class name */
    public interface C0003c {
        void a(C0303b bVar);
    }

    /* renamed from: M.c$d */
    protected class d implements C0003c {
        public d() {
        }

        public final void a(C0303b bVar) {
            if (bVar.k()) {
                C0322c cVar = C0322c.this;
                cVar.e((C0329j) null, cVar.C());
            } else if (C0322c.this.f479v != null) {
                C0322c.this.f479v.i(bVar);
            }
        }
    }

    /* renamed from: M.c$e */
    public interface e {
        void a();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected C0322c(android.content.Context r10, android.os.Looper r11, int r12, M.C0322c.a r13, M.C0322c.b r14, java.lang.String r15) {
        /*
            r9 = this;
            M.h r3 = M.C0327h.a(r10)
            J.h r4 = J.C0309h.f()
            M.C0335p.l(r13)
            M.C0335p.l(r14)
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M.C0322c.<init>(android.content.Context, android.os.Looper, int, M.c$a, M.c$b, java.lang.String):void");
    }

    static /* bridge */ /* synthetic */ void c0(C0322c cVar, h0 h0Var) {
        r rVar;
        cVar.f456B = h0Var;
        if (cVar.S()) {
            C0324e eVar = h0Var.f543d;
            C0336q b5 = C0336q.b();
            if (eVar == null) {
                rVar = null;
            } else {
                rVar = eVar.l();
            }
            b5.c(rVar);
        }
    }

    static /* bridge */ /* synthetic */ void d0(C0322c cVar, int i4) {
        int i5;
        int i6;
        synchronized (cVar.f470m) {
            i5 = cVar.f477t;
        }
        if (i5 == 3) {
            cVar.f455A = true;
            i6 = 5;
        } else {
            i6 = 4;
        }
        Handler handler = cVar.f469l;
        handler.sendMessage(handler.obtainMessage(i6, cVar.f457C.get(), 16));
    }

    static /* bridge */ /* synthetic */ boolean g0(C0322c cVar, int i4, int i5, IInterface iInterface) {
        synchronized (cVar.f470m) {
            try {
                if (cVar.f477t != i4) {
                    return false;
                }
                cVar.i0(i5, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static /* bridge */ /* synthetic */ boolean h0(C0322c cVar) {
        if (cVar.f455A || TextUtils.isEmpty(cVar.E()) || TextUtils.isEmpty(cVar.B())) {
            return false;
        }
        try {
            Class.forName(cVar.E());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final void i0(int i4, IInterface iInterface) {
        boolean z4;
        boolean z5;
        s0 s0Var;
        s0 s0Var2;
        boolean z6 = false;
        if (i4 != 4) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (iInterface == null) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (z4 == z5) {
            z6 = true;
        }
        C0335p.a(z6);
        synchronized (this.f470m) {
            try {
                this.f477t = i4;
                this.f474q = iInterface;
                if (i4 == 1) {
                    e0 e0Var = this.f476s;
                    if (e0Var != null) {
                        C0327h hVar = this.f467j;
                        String b5 = this.f464g.b();
                        C0335p.l(b5);
                        hVar.d(b5, this.f464g.a(), 4225, e0Var, X(), this.f464g.c());
                        this.f476s = null;
                    }
                } else if (i4 == 2 || i4 == 3) {
                    e0 e0Var2 = this.f476s;
                    if (!(e0Var2 == null || (s0Var2 = this.f464g) == null)) {
                        String b6 = s0Var2.b();
                        String a5 = s0Var2.a();
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + b6 + " on " + a5);
                        C0327h hVar2 = this.f467j;
                        String b7 = this.f464g.b();
                        C0335p.l(b7);
                        hVar2.d(b7, this.f464g.a(), 4225, e0Var2, X(), this.f464g.c());
                        this.f457C.incrementAndGet();
                    }
                    e0 e0Var3 = new e0(this, this.f457C.get());
                    this.f476s = e0Var3;
                    if (this.f477t != 3 || B() == null) {
                        s0Var = new s0(G(), F(), false, 4225, I());
                    } else {
                        s0Var = new s0(y().getPackageName(), B(), true, 4225, false);
                    }
                    this.f464g = s0Var;
                    if (s0Var.c()) {
                        if (l() < 17895000) {
                            throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.f464g.b())));
                        }
                    }
                    C0327h hVar3 = this.f467j;
                    String b8 = this.f464g.b();
                    C0335p.l(b8);
                    String a6 = this.f464g.a();
                    String X4 = X();
                    boolean c5 = this.f464g.c();
                    if (!hVar3.e(new l0(b8, a6, 4225, c5), e0Var3, X4, w())) {
                        String b9 = this.f464g.b();
                        String a7 = this.f464g.a();
                        Log.w("GmsClient", "unable to connect to service: " + b9 + " on " + a7);
                        e0(16, (Bundle) null, this.f457C.get());
                    }
                } else if (i4 == 4) {
                    C0335p.l(iInterface);
                    K(iInterface);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public Bundle A() {
        return new Bundle();
    }

    /* access modifiers changed from: protected */
    public String B() {
        return null;
    }

    /* access modifiers changed from: protected */
    public Set C() {
        return Collections.EMPTY_SET;
    }

    public final IInterface D() {
        IInterface iInterface;
        synchronized (this.f470m) {
            try {
                if (this.f477t != 5) {
                    r();
                    iInterface = this.f474q;
                    C0335p.m(iInterface, "Client is connected but service is null");
                } else {
                    throw new DeadObjectException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    /* access modifiers changed from: protected */
    public abstract String E();

    /* access modifiers changed from: protected */
    public abstract String F();

    /* access modifiers changed from: protected */
    public String G() {
        return "com.google.android.gms";
    }

    public C0324e H() {
        h0 h0Var = this.f456B;
        if (h0Var == null) {
            return null;
        }
        return h0Var.f543d;
    }

    /* access modifiers changed from: protected */
    public boolean I() {
        if (l() >= 211700000) {
            return true;
        }
        return false;
    }

    public boolean J() {
        if (this.f456B != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void K(IInterface iInterface) {
        this.f460c = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void L(C0303b bVar) {
        this.f461d = bVar.c();
        this.f462e = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void M(int i4) {
        this.f458a = i4;
        this.f459b = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void N(int i4, IBinder iBinder, Bundle bundle, int i5) {
        this.f469l.sendMessage(this.f469l.obtainMessage(1, i5, -1, new f0(this, i4, iBinder, bundle)));
    }

    public boolean O() {
        return false;
    }

    public void P(String str) {
        this.f482y = str;
    }

    public void Q(int i4) {
        this.f469l.sendMessage(this.f469l.obtainMessage(6, this.f457C.get(), i4));
    }

    /* access modifiers changed from: protected */
    public void R(C0003c cVar, int i4, PendingIntent pendingIntent) {
        C0335p.m(cVar, "Connection progress callbacks cannot be null.");
        this.f473p = cVar;
        this.f469l.sendMessage(this.f469l.obtainMessage(3, this.f457C.get(), i4, pendingIntent));
    }

    public boolean S() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final String X() {
        String str = this.f481x;
        if (str == null) {
            return this.f465h.getClass().getName();
        }
        return str;
    }

    public void b() {
        this.f457C.incrementAndGet();
        synchronized (this.f475r) {
            try {
                int size = this.f475r.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ((c0) this.f475r.get(i4)).d();
                }
                this.f475r.clear();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        synchronized (this.f471n) {
            this.f472o = null;
        }
        i0(1, (IInterface) null);
    }

    public void d(String str) {
        this.f463f = str;
        b();
    }

    public void e(C0329j jVar, Set set) {
        Set set2 = set;
        Bundle A4 = A();
        String str = this.f482y;
        int i4 = C0309h.f337a;
        Scope[] scopeArr = C0325f.f513o;
        Bundle bundle = new Bundle();
        int i5 = this.f480w;
        C0305d[] dVarArr = C0325f.f514p;
        C0325f fVar = new C0325f(6, i5, i4, (String) null, (IBinder) null, scopeArr, bundle, (Account) null, dVarArr, dVarArr, true, 0, false, str);
        fVar.f518d = this.f465h.getPackageName();
        fVar.f521g = A4;
        if (set2 != null) {
            fVar.f520f = (Scope[]) set2.toArray(new Scope[0]);
        }
        if (o()) {
            Account u4 = u();
            if (u4 == null) {
                u4 = new Account("<<default account>>", "com.google");
            }
            fVar.f522h = u4;
            if (jVar != null) {
                fVar.f519e = jVar.asBinder();
            }
        } else if (O()) {
            fVar.f522h = u();
        }
        fVar.f523i = f454E;
        fVar.f524j = v();
        if (S()) {
            fVar.f527m = true;
        }
        try {
            synchronized (this.f471n) {
                C0331l lVar = this.f472o;
                if (lVar != null) {
                    lVar.f0(new d0(this, this.f457C.get()), fVar);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e5) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e5);
            Q(3);
        } catch (SecurityException e6) {
            throw e6;
        } catch (RemoteException | RuntimeException e7) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e7);
            N(8, (IBinder) null, (Bundle) null, this.f457C.get());
        } catch (Throwable th) {
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final void e0(int i4, Bundle bundle, int i5) {
        this.f469l.sendMessage(this.f469l.obtainMessage(7, i5, -1, new g0(this, i4, (Bundle) null)));
    }

    public boolean f() {
        boolean z4;
        synchronized (this.f470m) {
            int i4 = this.f477t;
            z4 = true;
            if (i4 != 2) {
                if (i4 != 3) {
                    z4 = false;
                }
            }
        }
        return z4;
    }

    public String g() {
        s0 s0Var;
        if (j() && (s0Var = this.f464g) != null) {
            return s0Var.a();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    public void h(e eVar) {
        eVar.a();
    }

    public void i(C0003c cVar) {
        C0335p.m(cVar, "Connection progress callbacks cannot be null.");
        this.f473p = cVar;
        i0(2, (IInterface) null);
    }

    public boolean j() {
        boolean z4;
        synchronized (this.f470m) {
            if (this.f477t == 4) {
                z4 = true;
            } else {
                z4 = false;
            }
        }
        return z4;
    }

    public boolean k() {
        return true;
    }

    public abstract int l();

    public final C0305d[] m() {
        h0 h0Var = this.f456B;
        if (h0Var == null) {
            return null;
        }
        return h0Var.f541b;
    }

    public String n() {
        return this.f463f;
    }

    public boolean o() {
        return false;
    }

    public void q() {
        int h4 = this.f468k.h(this.f465h, l());
        if (h4 != 0) {
            i0(1, (IInterface) null);
            R(new d(), h4, (PendingIntent) null);
            return;
        }
        i(new d());
    }

    /* access modifiers changed from: protected */
    public final void r() {
        if (!j()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    /* access modifiers changed from: protected */
    public abstract IInterface s(IBinder iBinder);

    /* access modifiers changed from: protected */
    public boolean t() {
        return false;
    }

    public Account u() {
        return null;
    }

    public C0305d[] v() {
        return f454E;
    }

    /* access modifiers changed from: protected */
    public Executor w() {
        return null;
    }

    public Bundle x() {
        return null;
    }

    public final Context y() {
        return this.f465h;
    }

    public int z() {
        return this.f480w;
    }

    protected C0322c(Context context, Looper looper, C0327h hVar, C0309h hVar2, int i4, a aVar, b bVar, String str) {
        this.f463f = null;
        this.f470m = new Object();
        this.f471n = new Object();
        this.f475r = new ArrayList();
        this.f477t = 1;
        this.f483z = null;
        this.f455A = false;
        this.f456B = null;
        this.f457C = new AtomicInteger(0);
        C0335p.m(context, "Context must not be null");
        this.f465h = context;
        C0335p.m(looper, "Looper must not be null");
        this.f466i = looper;
        C0335p.m(hVar, "Supervisor must not be null");
        this.f467j = hVar;
        C0335p.m(hVar2, "API availability must not be null");
        this.f468k = hVar2;
        this.f469l = new b0(this, looper);
        this.f480w = i4;
        this.f478u = aVar;
        this.f479v = bVar;
        this.f481x = str;
    }
}
