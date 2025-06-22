package com.squareup.picasso;

import H1.b;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.squareup.picasso.s;

class k extends C1814a {

    /* renamed from: m  reason: collision with root package name */
    b f17265m;

    k(s sVar, ImageView imageView, v vVar, int i4, int i5, int i6, Drawable drawable, String str, Object obj, b bVar, boolean z4) {
        super(sVar, imageView, vVar, i4, i5, i6, drawable, str, obj, z4);
        this.f17265m = bVar;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        super.a();
        if (this.f17265m != null) {
            this.f17265m = null;
        }
    }

    public void b(Bitmap bitmap, s.e eVar) {
        if (bitmap != null) {
            ImageView imageView = (ImageView) this.f17194c.get();
            if (imageView != null) {
                s sVar = this.f17192a;
                Bitmap bitmap2 = bitmap;
                s.e eVar2 = eVar;
                t.c(imageView, sVar.f17306d, bitmap2, eVar2, this.f17195d, sVar.f17314l);
                b bVar = this.f17265m;
                if (bVar != null) {
                    bVar.b();
                    return;
                }
                return;
            }
            return;
        }
        throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
    }

    public void c(Exception exc) {
        ImageView imageView = (ImageView) this.f17194c.get();
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).stop();
            }
            int i4 = this.f17198g;
            if (i4 != 0) {
                imageView.setImageResource(i4);
            } else {
                Drawable drawable2 = this.f17199h;
                if (drawable2 != null) {
                    imageView.setImageDrawable(drawable2);
                }
            }
            b bVar = this.f17265m;
            if (bVar != null) {
                bVar.a(exc);
            }
        }
    }
}
