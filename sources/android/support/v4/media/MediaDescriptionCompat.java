package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.c;
import android.support.v4.media.f;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f698a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f699b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence f700c;

    /* renamed from: d  reason: collision with root package name */
    private final CharSequence f701d;

    /* renamed from: e  reason: collision with root package name */
    private final Bitmap f702e;

    /* renamed from: f  reason: collision with root package name */
    private final Uri f703f;

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f704g;

    /* renamed from: h  reason: collision with root package name */
    private final Uri f705h;

    /* renamed from: i  reason: collision with root package name */
    private Object f706i;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return MediaDescriptionCompat.a(c.a(parcel));
        }

        /* renamed from: b */
        public MediaDescriptionCompat[] newArray(int i4) {
            return new MediaDescriptionCompat[i4];
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private String f707a;

        /* renamed from: b  reason: collision with root package name */
        private CharSequence f708b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f709c;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f710d;

        /* renamed from: e  reason: collision with root package name */
        private Bitmap f711e;

        /* renamed from: f  reason: collision with root package name */
        private Uri f712f;

        /* renamed from: g  reason: collision with root package name */
        private Bundle f713g;

        /* renamed from: h  reason: collision with root package name */
        private Uri f714h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f707a, this.f708b, this.f709c, this.f710d, this.f711e, this.f712f, this.f713g, this.f714h);
        }

        public b b(CharSequence charSequence) {
            this.f710d = charSequence;
            return this;
        }

        public b c(Bundle bundle) {
            this.f713g = bundle;
            return this;
        }

        public b d(Bitmap bitmap) {
            this.f711e = bitmap;
            return this;
        }

        public b e(Uri uri) {
            this.f712f = uri;
            return this;
        }

        public b f(String str) {
            this.f707a = str;
            return this;
        }

        public b g(Uri uri) {
            this.f714h = uri;
            return this;
        }

        public b h(CharSequence charSequence) {
            this.f709c = charSequence;
            return this;
        }

        public b i(CharSequence charSequence) {
            this.f708b = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f698a = str;
        this.f699b = charSequence;
        this.f700c = charSequence2;
        this.f701d = charSequence3;
        this.f702e = bitmap;
        this.f703f = uri;
        this.f704g = bundle;
        this.f705h = uri2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.v4.media.MediaDescriptionCompat a(java.lang.Object r9) {
        /*
            r0 = 0
            if (r9 == 0) goto L_0x007a
            int r1 = android.os.Build.VERSION.SDK_INT
            android.support.v4.media.MediaDescriptionCompat$b r2 = new android.support.v4.media.MediaDescriptionCompat$b
            r2.<init>()
            java.lang.String r3 = android.support.v4.media.c.f(r9)
            r2.f(r3)
            java.lang.CharSequence r3 = android.support.v4.media.c.h(r9)
            r2.i(r3)
            java.lang.CharSequence r3 = android.support.v4.media.c.g(r9)
            r2.h(r3)
            java.lang.CharSequence r3 = android.support.v4.media.c.b(r9)
            r2.b(r3)
            android.graphics.Bitmap r3 = android.support.v4.media.c.d(r9)
            r2.d(r3)
            android.net.Uri r3 = android.support.v4.media.c.e(r9)
            r2.e(r3)
            android.os.Bundle r3 = android.support.v4.media.c.c(r9)
            java.lang.String r4 = "android.support.v4.media.description.MEDIA_URI"
            if (r3 == 0) goto L_0x0046
            android.support.v4.media.session.MediaSessionCompat.a(r3)
            android.os.Parcelable r5 = r3.getParcelable(r4)
            android.net.Uri r5 = (android.net.Uri) r5
            goto L_0x0047
        L_0x0046:
            r5 = r0
        L_0x0047:
            if (r5 == 0) goto L_0x005f
            java.lang.String r6 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r7 = r3.containsKey(r6)
            if (r7 == 0) goto L_0x0059
            int r7 = r3.size()
            r8 = 2
            if (r7 != r8) goto L_0x0059
            goto L_0x0060
        L_0x0059:
            r3.remove(r4)
            r3.remove(r6)
        L_0x005f:
            r0 = r3
        L_0x0060:
            r2.c(r0)
            if (r5 == 0) goto L_0x0069
            r2.g(r5)
            goto L_0x0074
        L_0x0069:
            r0 = 23
            if (r1 < r0) goto L_0x0074
            android.net.Uri r0 = android.support.v4.media.f.a(r9)
            r2.g(r0)
        L_0x0074:
            android.support.v4.media.MediaDescriptionCompat r0 = r2.a()
            r0.f706i = r9
        L_0x007a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.a(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    public Bitmap b() {
        return this.f702e;
    }

    public Object c() {
        Object obj = this.f706i;
        if (obj != null) {
            return obj;
        }
        int i4 = Build.VERSION.SDK_INT;
        Object b5 = c.a.b();
        c.a.g(b5, this.f698a);
        c.a.i(b5, this.f699b);
        c.a.h(b5, this.f700c);
        c.a.c(b5, this.f701d);
        c.a.e(b5, this.f702e);
        c.a.f(b5, this.f703f);
        Bundle bundle = this.f704g;
        if (i4 < 23 && this.f705h != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f705h);
        }
        c.a.d(b5, bundle);
        if (i4 >= 23) {
            f.a.a(b5, this.f705h);
        }
        Object a5 = c.a.a(b5);
        this.f706i = a5;
        return a5;
    }

    public CharSequence d() {
        return this.f700c;
    }

    public int describeContents() {
        return 0;
    }

    public CharSequence e() {
        return this.f699b;
    }

    public String toString() {
        return this.f699b + ", " + this.f700c + ", " + this.f701d;
    }

    public void writeToParcel(Parcel parcel, int i4) {
        c.i(c(), parcel, i4);
    }
}
