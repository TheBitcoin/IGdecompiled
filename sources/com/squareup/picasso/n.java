package com.squareup.picasso;

import N3.L;
import N3.Z;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import com.squareup.picasso.s;
import com.squareup.picasso.x;

class n extends e {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f17277b = {"orientation"};

    enum a {
        MICRO(3, 96, 96),
        MINI(1, 512, 384),
        FULL(2, -1, -1);
        

        /* renamed from: a  reason: collision with root package name */
        final int f17282a;

        /* renamed from: b  reason: collision with root package name */
        final int f17283b;

        /* renamed from: c  reason: collision with root package name */
        final int f17284c;

        private a(int i4, int i5, int i6) {
            this.f17282a = i4;
            this.f17283b = i5;
            this.f17284c = i6;
        }
    }

    n(Context context) {
        super(context);
    }

    static int k(ContentResolver contentResolver, Uri uri) {
        Cursor cursor = null;
        try {
            Cursor query = contentResolver.query(uri, f17277b, (String) null, (String[]) null, (String) null);
            if (query != null) {
                if (query.moveToFirst()) {
                    int i4 = query.getInt(0);
                    query.close();
                    return i4;
                }
            }
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (RuntimeException unused) {
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    static a l(int i4, int i5) {
        a aVar = a.MICRO;
        if (i4 <= aVar.f17283b && i5 <= aVar.f17284c) {
            return aVar;
        }
        a aVar2 = a.MINI;
        if (i4 > aVar2.f17283b || i5 > aVar2.f17284c) {
            return a.FULL;
        }
        return aVar2;
    }

    public boolean c(v vVar) {
        Uri uri = vVar.f17353d;
        if (!"content".equals(uri.getScheme()) || !"media".equals(uri.getAuthority())) {
            return false;
        }
        return true;
    }

    public x.a f(v vVar, int i4) {
        boolean z4;
        v vVar2;
        Bitmap bitmap;
        ContentResolver contentResolver = this.f17239a.getContentResolver();
        int k4 = k(contentResolver, vVar.f17353d);
        String type = contentResolver.getType(vVar.f17353d);
        int i5 = 1;
        if (type == null || !type.startsWith("video/")) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (vVar.c()) {
            a l4 = l(vVar.f17357h, vVar.f17358i);
            if (!z4 && l4 == a.FULL) {
                return new x.a((Bitmap) null, L.l(j(vVar)), s.e.DISK, k4);
            }
            long parseId = ContentUris.parseId(vVar.f17353d);
            BitmapFactory.Options d5 = x.d(vVar);
            d5.inJustDecodeBounds = true;
            vVar2 = vVar;
            x.a(vVar.f17357h, vVar.f17358i, l4.f17283b, l4.f17284c, d5, vVar2);
            if (z4) {
                if (l4 != a.FULL) {
                    i5 = l4.f17282a;
                }
                bitmap = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, parseId, i5, d5);
            } else {
                bitmap = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, parseId, l4.f17282a, d5);
            }
            if (bitmap != null) {
                return new x.a(bitmap, (Z) null, s.e.DISK, k4);
            }
        } else {
            vVar2 = vVar;
        }
        return new x.a((Bitmap) null, L.l(j(vVar2)), s.e.DISK, k4);
    }
}
