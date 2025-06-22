package M;

import J.C0303b;
import android.os.Bundle;

abstract class Q extends c0 {

    /* renamed from: d  reason: collision with root package name */
    public final int f444d;

    /* renamed from: e  reason: collision with root package name */
    public final Bundle f445e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ C0322c f446f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected Q(C0322c cVar, int i4, Bundle bundle) {
        super(cVar, Boolean.TRUE);
        this.f446f = cVar;
        this.f444d = i4;
        this.f445e = bundle;
    }

    /* JADX WARNING: type inference failed for: r3v5, types: [android.os.Parcelable] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ void a(java.lang.Object r3) {
        /*
            r2 = this;
            int r3 = r2.f444d
            r0 = 1
            r1 = 0
            if (r3 != 0) goto L_0x001c
            boolean r3 = r2.g()
            if (r3 != 0) goto L_0x001b
            M.c r3 = r2.f446f
            r3.i0(r0, (android.os.IInterface) null)
            J.b r3 = new J.b
            r0 = 8
            r3.<init>(r0, r1)
            r2.f(r3)
        L_0x001b:
            return
        L_0x001c:
            M.c r3 = r2.f446f
            r3.i0(r0, (android.os.IInterface) null)
            android.os.Bundle r3 = r2.f445e
            if (r3 == 0) goto L_0x002e
            java.lang.String r0 = "pendingIntent"
            android.os.Parcelable r3 = r3.getParcelable(r0)
            r1 = r3
            android.app.PendingIntent r1 = (android.app.PendingIntent) r1
        L_0x002e:
            int r3 = r2.f444d
            J.b r0 = new J.b
            r0.<init>(r3, r1)
            r2.f(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M.Q.a(java.lang.Object):void");
    }

    /* access modifiers changed from: protected */
    public abstract void f(C0303b bVar);

    /* access modifiers changed from: protected */
    public abstract boolean g();

    /* access modifiers changed from: protected */
    public final void b() {
    }
}
