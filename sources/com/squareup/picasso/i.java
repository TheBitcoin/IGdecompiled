package com.squareup.picasso;

import N3.L;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.squareup.picasso.s;
import com.squareup.picasso.x;

class i extends e {
    i(Context context) {
        super(context);
    }

    static int k(Uri uri) {
        return new ExifInterface(uri.getPath()).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
    }

    public boolean c(v vVar) {
        return "file".equals(vVar.f17353d.getScheme());
    }

    public x.a f(v vVar, int i4) {
        return new x.a((Bitmap) null, L.l(j(vVar)), s.e.DISK, k(vVar.f17353d));
    }
}
