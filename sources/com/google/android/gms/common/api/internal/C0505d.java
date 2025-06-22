package com.google.android.gms.common.api.internal;

import J.C0305d;
import K.a;
import L.i;
import L.y;
import M.C0335p;
import k0.C0938m;

/* renamed from: com.google.android.gms.common.api.internal.d  reason: case insensitive filesystem */
public abstract class C0505d {

    /* renamed from: a  reason: collision with root package name */
    private final C0305d[] f1308a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f1309b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1310c;

    /* renamed from: com.google.android.gms.common.api.internal.d$a */
    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public i f1311a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f1312b = true;

        /* renamed from: c  reason: collision with root package name */
        private C0305d[] f1313c;

        /* renamed from: d  reason: collision with root package name */
        private int f1314d = 0;

        /* synthetic */ a(y yVar) {
        }

        public C0505d a() {
            boolean z4;
            if (this.f1311a != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            C0335p.b(z4, "execute parameter required");
            return new t(this, this.f1313c, this.f1312b, this.f1314d);
        }

        public a b(i iVar) {
            this.f1311a = iVar;
            return this;
        }

        public a c(boolean z4) {
            this.f1312b = z4;
            return this;
        }

        public a d(C0305d... dVarArr) {
            this.f1313c = dVarArr;
            return this;
        }
    }

    protected C0505d(C0305d[] dVarArr, boolean z4, int i4) {
        this.f1308a = dVarArr;
        boolean z5 = false;
        if (dVarArr != null && z4) {
            z5 = true;
        }
        this.f1309b = z5;
        this.f1310c = i4;
    }

    public static a a() {
        return new a((y) null);
    }

    /* access modifiers changed from: protected */
    public abstract void b(a.b bVar, C0938m mVar);

    public boolean c() {
        return this.f1309b;
    }

    public final int d() {
        return this.f1310c;
    }

    public final C0305d[] e() {
        return this.f1308a;
    }
}
