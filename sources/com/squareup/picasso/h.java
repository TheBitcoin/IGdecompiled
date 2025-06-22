package com.squareup.picasso;

import H1.b;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.s;

class h extends C1814a {

    /* renamed from: m  reason: collision with root package name */
    private final Object f17263m = new Object();

    /* renamed from: n  reason: collision with root package name */
    private b f17264n;

    h(s sVar, v vVar, int i4, int i5, Object obj, String str, b bVar) {
        super(sVar, (Object) null, vVar, i4, i5, 0, (Drawable) null, str, obj, false);
        this.f17264n = bVar;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        super.a();
        this.f17264n = null;
    }

    /* access modifiers changed from: package-private */
    public void b(Bitmap bitmap, s.e eVar) {
        b bVar = this.f17264n;
        if (bVar != null) {
            bVar.b();
        }
    }

    /* access modifiers changed from: package-private */
    public void c(Exception exc) {
        b bVar = this.f17264n;
        if (bVar != null) {
            bVar.a(exc);
        }
    }

    /* access modifiers changed from: package-private */
    public Object k() {
        return this.f17263m;
    }
}
