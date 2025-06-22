package com.google.android.gms.internal.measurement;

import android.content.Context;
import l0.k;

final class V2 extends C0683u3 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1647a;

    /* renamed from: b  reason: collision with root package name */
    private final k f1648b;

    V2(Context context, k kVar) {
        if (context != null) {
            this.f1647a = context;
            this.f1648b = kVar;
            return;
        }
        throw new NullPointerException("Null context");
    }

    /* access modifiers changed from: package-private */
    public final Context a() {
        return this.f1647a;
    }

    /* access modifiers changed from: package-private */
    public final k b() {
        return this.f1648b;
    }

    public final boolean equals(Object obj) {
        k kVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0683u3) {
            C0683u3 u3Var = (C0683u3) obj;
            if (!this.f1647a.equals(u3Var.a()) || ((kVar = this.f1648b) != null ? !kVar.equals(u3Var.b()) : u3Var.b() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i4;
        int hashCode = (this.f1647a.hashCode() ^ 1000003) * 1000003;
        k kVar = this.f1648b;
        if (kVar == null) {
            i4 = 0;
        } else {
            i4 = kVar.hashCode();
        }
        return hashCode ^ i4;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f1647a);
        String valueOf2 = String.valueOf(this.f1648b);
        return "FlagsContext{context=" + valueOf + ", hermeticFileOverrides=" + valueOf2 + "}";
    }
}
