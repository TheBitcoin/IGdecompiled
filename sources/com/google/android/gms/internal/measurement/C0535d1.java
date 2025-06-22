package com.google.android.gms.internal.measurement;

import M.C0335p;
import U.b;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.measurement.C0544e1;
import f0.n;

/* renamed from: com.google.android.gms.internal.measurement.d1  reason: case insensitive filesystem */
final class C0535d1 extends C0544e1.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ String f1799e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ String f1800f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ Context f1801g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ Bundle f1802h;

    /* renamed from: i  reason: collision with root package name */
    private final /* synthetic */ C0544e1 f1803i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0535d1(C0544e1 e1Var, String str, String str2, Context context, Bundle bundle) {
        super(e1Var);
        this.f1799e = str;
        this.f1800f = str2;
        this.f1801g = context;
        this.f1802h = bundle;
        this.f1803i = e1Var;
    }

    public final void a() {
        String str;
        String str2;
        String str3;
        boolean z4;
        try {
            if (this.f1803i.E(this.f1799e, this.f1800f)) {
                str = this.f1800f;
                str2 = this.f1799e;
                str3 = this.f1803i.f1870a;
            } else {
                str3 = null;
                str2 = null;
                str = null;
            }
            C0335p.l(this.f1801g);
            C0544e1 e1Var = this.f1803i;
            e1Var.f1878i = e1Var.c(this.f1801g, true);
            if (this.f1803i.f1878i == null) {
                Log.w(this.f1803i.f1870a, "Failed to connect to measurement client.");
                return;
            }
            int a5 = DynamiteModule.a(this.f1801g, ModuleDescriptor.MODULE_ID);
            int c5 = DynamiteModule.c(this.f1801g, ModuleDescriptor.MODULE_ID);
            int max = Math.max(a5, c5);
            if (c5 < a5) {
                z4 = true;
            } else {
                z4 = false;
            }
            ((P0) C0335p.l(this.f1803i.f1878i)).initialize(b.l0(this.f1801g), new C0526c1(106000, (long) max, z4, str3, str2, str, this.f1802h, n.a(this.f1801g)), this.f1879a);
        } catch (Exception e5) {
            this.f1803i.r(e5, true, false);
        }
    }
}
