package com.mbridge.msdk.newreward.function.c.c;

import android.text.TextUtils;
import com.mbridge.msdk.newreward.function.c.a.b;

public abstract class a<Resource> implements o {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f14563a = false;

    /* renamed from: b  reason: collision with root package name */
    private final b f14564b;

    /* renamed from: c  reason: collision with root package name */
    private final com.mbridge.msdk.newreward.function.c.a.a f14565c;

    /* renamed from: d  reason: collision with root package name */
    private int f14566d = 0;

    /* renamed from: e  reason: collision with root package name */
    private boolean f14567e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14568f = false;

    public a(b bVar, com.mbridge.msdk.newreward.function.c.a.a aVar) {
        this.f14564b = bVar;
        this.f14565c = aVar;
    }

    public abstract Resource a();

    public final void a(boolean z4) {
        this.f14563a = z4;
    }

    public final b b() {
        return this.f14564b;
    }

    public final com.mbridge.msdk.newreward.function.c.a.a c() {
        return this.f14565c;
    }

    public boolean d() {
        if (TextUtils.isEmpty(j()) || h() || this.f14567e) {
            return true;
        }
        return false;
    }

    public boolean e() {
        if (TextUtils.isEmpty(j()) || k() || this.f14568f) {
            return true;
        }
        return false;
    }

    public final int f() {
        return this.f14566d;
    }

    public final void a(int i4) {
        this.f14566d = i4;
    }

    public final void b(boolean z4) {
        this.f14567e = z4;
    }
}
