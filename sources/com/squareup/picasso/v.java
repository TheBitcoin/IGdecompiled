package com.squareup.picasso;

import H1.e;
import android.graphics.Bitmap;
import android.net.Uri;
import com.squareup.picasso.s;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class v {

    /* renamed from: u  reason: collision with root package name */
    private static final long f17349u = TimeUnit.SECONDS.toNanos(5);

    /* renamed from: a  reason: collision with root package name */
    int f17350a;

    /* renamed from: b  reason: collision with root package name */
    long f17351b;

    /* renamed from: c  reason: collision with root package name */
    int f17352c;

    /* renamed from: d  reason: collision with root package name */
    public final Uri f17353d;

    /* renamed from: e  reason: collision with root package name */
    public final int f17354e;

    /* renamed from: f  reason: collision with root package name */
    public final String f17355f;

    /* renamed from: g  reason: collision with root package name */
    public final List f17356g;

    /* renamed from: h  reason: collision with root package name */
    public final int f17357h;

    /* renamed from: i  reason: collision with root package name */
    public final int f17358i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f17359j;

    /* renamed from: k  reason: collision with root package name */
    public final int f17360k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f17361l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f17362m;

    /* renamed from: n  reason: collision with root package name */
    public final float f17363n;

    /* renamed from: o  reason: collision with root package name */
    public final float f17364o;

    /* renamed from: p  reason: collision with root package name */
    public final float f17365p;

    /* renamed from: q  reason: collision with root package name */
    public final boolean f17366q;

    /* renamed from: r  reason: collision with root package name */
    public final boolean f17367r;

    /* renamed from: s  reason: collision with root package name */
    public final Bitmap.Config f17368s;

    /* renamed from: t  reason: collision with root package name */
    public final s.f f17369t;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private Uri f17370a;

        /* renamed from: b  reason: collision with root package name */
        private int f17371b;

        /* renamed from: c  reason: collision with root package name */
        private String f17372c;

        /* renamed from: d  reason: collision with root package name */
        private int f17373d;

        /* renamed from: e  reason: collision with root package name */
        private int f17374e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f17375f;

        /* renamed from: g  reason: collision with root package name */
        private int f17376g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f17377h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f17378i;

        /* renamed from: j  reason: collision with root package name */
        private float f17379j;

        /* renamed from: k  reason: collision with root package name */
        private float f17380k;

        /* renamed from: l  reason: collision with root package name */
        private float f17381l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f17382m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f17383n;

        /* renamed from: o  reason: collision with root package name */
        private List f17384o;

        /* renamed from: p  reason: collision with root package name */
        private Bitmap.Config f17385p;

        /* renamed from: q  reason: collision with root package name */
        private s.f f17386q;

        b(Uri uri, int i4, Bitmap.Config config) {
            this.f17370a = uri;
            this.f17371b = i4;
            this.f17385p = config;
        }

        public v a() {
            boolean z4 = this.f17377h;
            if (z4 && this.f17375f) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            } else if (this.f17375f && this.f17373d == 0 && this.f17374e == 0) {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            } else if (z4 && this.f17373d == 0 && this.f17374e == 0) {
                throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
            } else {
                if (this.f17386q == null) {
                    this.f17386q = s.f.NORMAL;
                }
                return new v(this.f17370a, this.f17371b, this.f17372c, this.f17384o, this.f17373d, this.f17374e, this.f17375f, this.f17377h, this.f17376g, this.f17378i, this.f17379j, this.f17380k, this.f17381l, this.f17382m, this.f17383n, this.f17385p, this.f17386q);
            }
        }

        public b b(int i4) {
            if (!this.f17377h) {
                this.f17375f = true;
                this.f17376g = i4;
                return this;
            }
            throw new IllegalStateException("Center crop can not be used after calling centerInside");
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            if (this.f17370a == null && this.f17371b == 0) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            if (this.f17386q != null) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            if (this.f17373d == 0 && this.f17374e == 0) {
                return false;
            }
            return true;
        }

        public b f(s.f fVar) {
            if (fVar == null) {
                throw new IllegalArgumentException("Priority invalid.");
            } else if (this.f17386q == null) {
                this.f17386q = fVar;
                return this;
            } else {
                throw new IllegalStateException("Priority already set.");
            }
        }

        public b g(int i4, int i5) {
            if (i4 < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            } else if (i5 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            } else if (i5 == 0 && i4 == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            } else {
                this.f17373d = i4;
                this.f17374e = i5;
                return this;
            }
        }

        public b h(e eVar) {
            if (eVar == null) {
                throw new IllegalArgumentException("Transformation must not be null.");
            } else if (eVar.key() != null) {
                if (this.f17384o == null) {
                    this.f17384o = new ArrayList(2);
                }
                this.f17384o.add(eVar);
                return this;
            } else {
                throw new IllegalArgumentException("Transformation key must not be null.");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String a() {
        Uri uri = this.f17353d;
        if (uri != null) {
            return String.valueOf(uri.getPath());
        }
        return Integer.toHexString(this.f17354e);
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        if (this.f17356g != null) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f17357h == 0 && this.f17358i == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public String d() {
        long nanoTime = System.nanoTime() - this.f17351b;
        if (nanoTime > f17349u) {
            return g() + '+' + TimeUnit.NANOSECONDS.toSeconds(nanoTime) + 's';
        }
        return g() + '+' + TimeUnit.NANOSECONDS.toMillis(nanoTime) + "ms";
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        if (c() || this.f17363n != 0.0f) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        if (e() || b()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public String g() {
        return "[R" + this.f17350a + ']';
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{");
        int i4 = this.f17354e;
        if (i4 > 0) {
            sb.append(i4);
        } else {
            sb.append(this.f17353d);
        }
        List list = this.f17356g;
        if (list != null && !list.isEmpty()) {
            for (e key : this.f17356g) {
                sb.append(' ');
                sb.append(key.key());
            }
        }
        if (this.f17355f != null) {
            sb.append(" stableKey(");
            sb.append(this.f17355f);
            sb.append(')');
        }
        if (this.f17357h > 0) {
            sb.append(" resize(");
            sb.append(this.f17357h);
            sb.append(',');
            sb.append(this.f17358i);
            sb.append(')');
        }
        if (this.f17359j) {
            sb.append(" centerCrop");
        }
        if (this.f17361l) {
            sb.append(" centerInside");
        }
        if (this.f17363n != 0.0f) {
            sb.append(" rotation(");
            sb.append(this.f17363n);
            if (this.f17366q) {
                sb.append(" @ ");
                sb.append(this.f17364o);
                sb.append(',');
                sb.append(this.f17365p);
            }
            sb.append(')');
        }
        if (this.f17367r) {
            sb.append(" purgeable");
        }
        if (this.f17368s != null) {
            sb.append(' ');
            sb.append(this.f17368s);
        }
        sb.append('}');
        return sb.toString();
    }

    private v(Uri uri, int i4, String str, List list, int i5, int i6, boolean z4, boolean z5, int i7, boolean z6, float f4, float f5, float f6, boolean z7, boolean z8, Bitmap.Config config, s.f fVar) {
        this.f17353d = uri;
        this.f17354e = i4;
        this.f17355f = str;
        if (list == null) {
            this.f17356g = null;
        } else {
            this.f17356g = DesugarCollections.unmodifiableList(list);
        }
        this.f17357h = i5;
        this.f17358i = i6;
        this.f17359j = z4;
        this.f17361l = z5;
        this.f17360k = i7;
        this.f17362m = z6;
        this.f17363n = f4;
        this.f17364o = f5;
        this.f17365p = f6;
        this.f17366q = z7;
        this.f17367r = z8;
        this.f17368s = config;
        this.f17369t = fVar;
    }
}
