package com.squareup.picasso;

import N3.Z;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import com.squareup.picasso.s;

public abstract class x {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final s.e f17400a;

        /* renamed from: b  reason: collision with root package name */
        private final Bitmap f17401b;

        /* renamed from: c  reason: collision with root package name */
        private final Z f17402c;

        /* renamed from: d  reason: collision with root package name */
        private final int f17403d;

        public a(Bitmap bitmap, s.e eVar) {
            this((Bitmap) C.e(bitmap, "bitmap == null"), (Z) null, eVar, 0);
        }

        public Bitmap a() {
            return this.f17401b;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.f17403d;
        }

        public s.e c() {
            return this.f17400a;
        }

        public Z d() {
            return this.f17402c;
        }

        public a(Z z4, s.e eVar) {
            this((Bitmap) null, (Z) C.e(z4, "source == null"), eVar, 0);
        }

        a(Bitmap bitmap, Z z4, s.e eVar, int i4) {
            if ((bitmap != null) != (z4 != null)) {
                this.f17401b = bitmap;
                this.f17402c = z4;
                this.f17400a = (s.e) C.e(eVar, "loadedFrom == null");
                this.f17403d = i4;
                return;
            }
            throw new AssertionError();
        }
    }

    static void a(int i4, int i5, int i6, int i7, BitmapFactory.Options options, v vVar) {
        int i8;
        double floor;
        if (i7 > i5 || i6 > i4) {
            if (i5 == 0) {
                floor = Math.floor((double) (((float) i6) / ((float) i4)));
            } else if (i4 == 0) {
                floor = Math.floor((double) (((float) i7) / ((float) i5)));
            } else {
                int floor2 = (int) Math.floor((double) (((float) i7) / ((float) i5)));
                int floor3 = (int) Math.floor((double) (((float) i6) / ((float) i4)));
                if (vVar.f17361l) {
                    i8 = Math.max(floor2, floor3);
                } else {
                    i8 = Math.min(floor2, floor3);
                }
            }
            i8 = (int) floor;
        } else {
            i8 = 1;
        }
        options.inSampleSize = i8;
        options.inJustDecodeBounds = false;
    }

    static void b(int i4, int i5, BitmapFactory.Options options, v vVar) {
        a(i4, i5, options.outWidth, options.outHeight, options, vVar);
    }

    static BitmapFactory.Options d(v vVar) {
        boolean z4;
        boolean c5 = vVar.c();
        if (vVar.f17368s != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!c5 && !z4 && !vVar.f17367r) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = c5;
        boolean z5 = vVar.f17367r;
        options.inInputShareable = z5;
        options.inPurgeable = z5;
        if (z4) {
            options.inPreferredConfig = vVar.f17368s;
        }
        return options;
    }

    static boolean g(BitmapFactory.Options options) {
        if (options == null || !options.inJustDecodeBounds) {
            return false;
        }
        return true;
    }

    public abstract boolean c(v vVar);

    /* access modifiers changed from: package-private */
    public int e() {
        return 0;
    }

    public abstract a f(v vVar, int i4);

    /* access modifiers changed from: package-private */
    public boolean h(boolean z4, NetworkInfo networkInfo) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return false;
    }
}
