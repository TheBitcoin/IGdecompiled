package com.squareup.picasso;

import N3.L;
import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.squareup.picasso.s;
import com.squareup.picasso.x;

/* renamed from: com.squareup.picasso.b  reason: case insensitive filesystem */
class C1815b extends x {

    /* renamed from: d  reason: collision with root package name */
    private static final int f17205d = 22;

    /* renamed from: a  reason: collision with root package name */
    private final Context f17206a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f17207b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private AssetManager f17208c;

    C1815b(Context context) {
        this.f17206a = context;
    }

    static String j(v vVar) {
        return vVar.f17353d.toString().substring(f17205d);
    }

    public boolean c(v vVar) {
        Uri uri = vVar.f17353d;
        if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }

    public x.a f(v vVar, int i4) {
        if (this.f17208c == null) {
            synchronized (this.f17207b) {
                try {
                    if (this.f17208c == null) {
                        this.f17208c = this.f17206a.getAssets();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return new x.a(L.l(this.f17208c.open(j(vVar))), s.e.DISK);
    }
}
