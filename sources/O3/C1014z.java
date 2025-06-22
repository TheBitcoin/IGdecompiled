package o3;

import d3.l;
import kotlin.jvm.internal.m;

/* renamed from: o3.z  reason: case insensitive filesystem */
final class C1014z {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3731a;

    /* renamed from: b  reason: collision with root package name */
    public final C0985k f3732b;

    /* renamed from: c  reason: collision with root package name */
    public final l f3733c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f3734d;

    /* renamed from: e  reason: collision with root package name */
    public final Throwable f3735e;

    public C1014z(Object obj, C0985k kVar, l lVar, Object obj2, Throwable th) {
        this.f3731a = obj;
        this.f3732b = kVar;
        this.f3733c = lVar;
        this.f3734d = obj2;
        this.f3735e = th;
    }

    public static /* synthetic */ C1014z b(C1014z zVar, Object obj, C0985k kVar, l lVar, Object obj2, Throwable th, int i4, Object obj3) {
        if ((i4 & 1) != 0) {
            obj = zVar.f3731a;
        }
        if ((i4 & 2) != 0) {
            kVar = zVar.f3732b;
        }
        if ((i4 & 4) != 0) {
            lVar = zVar.f3733c;
        }
        if ((i4 & 8) != 0) {
            obj2 = zVar.f3734d;
        }
        if ((i4 & 16) != 0) {
            th = zVar.f3735e;
        }
        Object obj4 = obj2;
        Throwable th2 = th;
        return zVar.a(obj, kVar, lVar, obj4, th2);
    }

    public final C1014z a(Object obj, C0985k kVar, l lVar, Object obj2, Throwable th) {
        return new C1014z(obj, kVar, lVar, obj2, th);
    }

    public final boolean c() {
        if (this.f3735e != null) {
            return true;
        }
        return false;
    }

    public final void d(C0991n nVar, Throwable th) {
        C0985k kVar = this.f3732b;
        if (kVar != null) {
            nVar.l(kVar, th);
        }
        l lVar = this.f3733c;
        if (lVar != null) {
            nVar.m(lVar, th);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1014z)) {
            return false;
        }
        C1014z zVar = (C1014z) obj;
        if (m.a(this.f3731a, zVar.f3731a) && m.a(this.f3732b, zVar.f3732b) && m.a(this.f3733c, zVar.f3733c) && m.a(this.f3734d, zVar.f3734d) && m.a(this.f3735e, zVar.f3735e)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        int i5;
        int i6;
        int i7;
        Object obj = this.f3731a;
        int i8 = 0;
        if (obj == null) {
            i4 = 0;
        } else {
            i4 = obj.hashCode();
        }
        int i9 = i4 * 31;
        C0985k kVar = this.f3732b;
        if (kVar == null) {
            i5 = 0;
        } else {
            i5 = kVar.hashCode();
        }
        int i10 = (i9 + i5) * 31;
        l lVar = this.f3733c;
        if (lVar == null) {
            i6 = 0;
        } else {
            i6 = lVar.hashCode();
        }
        int i11 = (i10 + i6) * 31;
        Object obj2 = this.f3734d;
        if (obj2 == null) {
            i7 = 0;
        } else {
            i7 = obj2.hashCode();
        }
        int i12 = (i11 + i7) * 31;
        Throwable th = this.f3735e;
        if (th != null) {
            i8 = th.hashCode();
        }
        return i12 + i8;
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f3731a + ", cancelHandler=" + this.f3732b + ", onCancellation=" + this.f3733c + ", idempotentResume=" + this.f3734d + ", cancelCause=" + this.f3735e + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ C1014z(java.lang.Object r2, o3.C0985k r3, d3.l r4, java.lang.Object r5, java.lang.Throwable r6, int r7, kotlin.jvm.internal.C2103g r8) {
        /*
            r1 = this;
            r8 = r7 & 2
            r0 = 0
            if (r8 == 0) goto L_0x0006
            r3 = r0
        L_0x0006:
            r8 = r7 & 4
            if (r8 == 0) goto L_0x000b
            r4 = r0
        L_0x000b:
            r8 = r7 & 8
            if (r8 == 0) goto L_0x0010
            r5 = r0
        L_0x0010:
            r7 = r7 & 16
            if (r7 == 0) goto L_0x001b
            r7 = r0
        L_0x0015:
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            goto L_0x001d
        L_0x001b:
            r7 = r6
            goto L_0x0015
        L_0x001d:
            r2.<init>(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.C1014z.<init>(java.lang.Object, o3.k, d3.l, java.lang.Object, java.lang.Throwable, int, kotlin.jvm.internal.g):void");
    }
}
