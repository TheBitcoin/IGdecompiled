package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.s;

final class B extends C1814a {
    B(s sVar, A a5, v vVar, int i4, int i5, Drawable drawable, String str, Object obj, int i6) {
        super(sVar, a5, vVar, i4, i5, i6, drawable, str, obj, false);
    }

    /* access modifiers changed from: package-private */
    public void b(Bitmap bitmap, s.e eVar) {
        if (bitmap != null) {
            A a5 = (A) k();
            if (a5 != null) {
                a5.c(bitmap, eVar);
                if (bitmap.isRecycled()) {
                    throw new IllegalStateException("Target callback must not recycle bitmap!");
                }
                return;
            }
            return;
        }
        throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
    }

    /* access modifiers changed from: package-private */
    public void c(Exception exc) {
        A a5 = (A) k();
        if (a5 == null) {
            return;
        }
        if (this.f17198g != 0) {
            a5.a(exc, this.f17192a.f17306d.getResources().getDrawable(this.f17198g));
        } else {
            a5.a(exc, this.f17199h);
        }
    }
}
