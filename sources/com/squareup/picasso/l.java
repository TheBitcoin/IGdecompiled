package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

public final class l implements H1.a {

    /* renamed from: a  reason: collision with root package name */
    final LruCache f17266a;

    class a extends LruCache {
        a(int i4) {
            super(i4);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int sizeOf(String str, b bVar) {
            return bVar.f17269b;
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final Bitmap f17268a;

        /* renamed from: b  reason: collision with root package name */
        final int f17269b;

        b(Bitmap bitmap, int i4) {
            this.f17268a = bitmap;
            this.f17269b = i4;
        }
    }

    public l(Context context) {
        this(C.b(context));
    }

    public int a() {
        return this.f17266a.maxSize();
    }

    public void b(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        int j4 = C.j(bitmap);
        if (j4 > a()) {
            this.f17266a.remove(str);
        } else {
            this.f17266a.put(str, new b(bitmap, j4));
        }
    }

    public Bitmap get(String str) {
        b bVar = (b) this.f17266a.get(str);
        if (bVar != null) {
            return bVar.f17268a;
        }
        return null;
    }

    public int size() {
        return this.f17266a.size();
    }

    public l(int i4) {
        this.f17266a = new a(i4);
    }
}
