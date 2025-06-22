package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.squareup.picasso.s;
import com.squareup.picasso.x;

class y extends x {

    /* renamed from: a  reason: collision with root package name */
    private final Context f17404a;

    y(Context context) {
        this.f17404a = context;
    }

    private static Bitmap j(Resources resources, int i4, v vVar) {
        BitmapFactory.Options d5 = x.d(vVar);
        if (x.g(d5)) {
            BitmapFactory.decodeResource(resources, i4, d5);
            x.b(vVar.f17357h, vVar.f17358i, d5, vVar);
        }
        return BitmapFactory.decodeResource(resources, i4, d5);
    }

    public boolean c(v vVar) {
        if (vVar.f17354e != 0) {
            return true;
        }
        return "android.resource".equals(vVar.f17353d.getScheme());
    }

    public x.a f(v vVar, int i4) {
        Resources n4 = C.n(this.f17404a, vVar);
        return new x.a(j(n4, C.m(n4, vVar), vVar), s.e.DISK);
    }
}
