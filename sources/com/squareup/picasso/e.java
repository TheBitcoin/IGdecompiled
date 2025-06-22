package com.squareup.picasso;

import N3.L;
import android.content.Context;
import com.squareup.picasso.s;
import com.squareup.picasso.x;
import java.io.InputStream;

class e extends x {

    /* renamed from: a  reason: collision with root package name */
    final Context f17239a;

    e(Context context) {
        this.f17239a = context;
    }

    public boolean c(v vVar) {
        return "content".equals(vVar.f17353d.getScheme());
    }

    public x.a f(v vVar, int i4) {
        return new x.a(L.l(j(vVar)), s.e.DISK);
    }

    /* access modifiers changed from: package-private */
    public InputStream j(v vVar) {
        return this.f17239a.getContentResolver().openInputStream(vVar.f17353d);
    }
}
