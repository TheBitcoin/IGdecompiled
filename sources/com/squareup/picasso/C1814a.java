package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.s;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.squareup.picasso.a  reason: case insensitive filesystem */
abstract class C1814a {

    /* renamed from: a  reason: collision with root package name */
    final s f17192a;

    /* renamed from: b  reason: collision with root package name */
    final v f17193b;

    /* renamed from: c  reason: collision with root package name */
    final WeakReference f17194c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f17195d;

    /* renamed from: e  reason: collision with root package name */
    final int f17196e;

    /* renamed from: f  reason: collision with root package name */
    final int f17197f;

    /* renamed from: g  reason: collision with root package name */
    final int f17198g;

    /* renamed from: h  reason: collision with root package name */
    final Drawable f17199h;

    /* renamed from: i  reason: collision with root package name */
    final String f17200i;

    /* renamed from: j  reason: collision with root package name */
    final Object f17201j;

    /* renamed from: k  reason: collision with root package name */
    boolean f17202k;

    /* renamed from: l  reason: collision with root package name */
    boolean f17203l;

    /* renamed from: com.squareup.picasso.a$a  reason: collision with other inner class name */
    static class C0209a extends WeakReference {

        /* renamed from: a  reason: collision with root package name */
        final C1814a f17204a;

        C0209a(C1814a aVar, Object obj, ReferenceQueue referenceQueue) {
            super(obj, referenceQueue);
            this.f17204a = aVar;
        }
    }

    C1814a(s sVar, Object obj, v vVar, int i4, int i5, int i6, Drawable drawable, String str, Object obj2, boolean z4) {
        C0209a aVar;
        this.f17192a = sVar;
        this.f17193b = vVar;
        if (obj == null) {
            aVar = null;
        } else {
            aVar = new C0209a(this, obj, sVar.f17312j);
        }
        this.f17194c = aVar;
        this.f17196e = i4;
        this.f17197f = i5;
        this.f17195d = z4;
        this.f17198g = i6;
        this.f17199h = drawable;
        this.f17200i = str;
        this.f17201j = obj2 == null ? this : obj2;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f17203l = true;
    }

    /* access modifiers changed from: package-private */
    public abstract void b(Bitmap bitmap, s.e eVar);

    /* access modifiers changed from: package-private */
    public abstract void c(Exception exc);

    /* access modifiers changed from: package-private */
    public String d() {
        return this.f17200i;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f17196e;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f17197f;
    }

    /* access modifiers changed from: package-private */
    public s g() {
        return this.f17192a;
    }

    /* access modifiers changed from: package-private */
    public s.f h() {
        return this.f17193b.f17369t;
    }

    /* access modifiers changed from: package-private */
    public v i() {
        return this.f17193b;
    }

    /* access modifiers changed from: package-private */
    public Object j() {
        return this.f17201j;
    }

    /* access modifiers changed from: package-private */
    public Object k() {
        WeakReference weakReference = this.f17194c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return this.f17203l;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return this.f17202k;
    }
}
