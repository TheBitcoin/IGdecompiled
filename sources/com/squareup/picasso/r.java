package com.squareup.picasso;

import D3.C2455c;
import D3.C2457e;
import D3.C2473u;
import D3.x;
import D3.z;
import H1.c;
import android.content.Context;
import java.io.File;

public final class r implements c {

    /* renamed from: a  reason: collision with root package name */
    final C2457e.a f17298a;

    /* renamed from: b  reason: collision with root package name */
    private final C2455c f17299b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17300c;

    public r(Context context) {
        this(C.f(context));
    }

    public z a(x xVar) {
        return this.f17298a.a(xVar).execute();
    }

    public r(File file) {
        this(file, C.a(file));
    }

    public r(File file, long j4) {
        this(new C2473u.b().b(new C2455c(file, j4)).a());
        this.f17300c = false;
    }

    public r(C2473u uVar) {
        this.f17300c = true;
        this.f17298a = uVar;
        this.f17299b = uVar.c();
    }
}
