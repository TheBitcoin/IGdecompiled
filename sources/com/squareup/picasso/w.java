package com.squareup.picasso;

import H1.b;
import H1.e;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.squareup.picasso.s;
import com.squareup.picasso.v;
import java.util.concurrent.atomic.AtomicInteger;

public class w {

    /* renamed from: m  reason: collision with root package name */
    private static final AtomicInteger f17387m = new AtomicInteger();

    /* renamed from: a  reason: collision with root package name */
    private final s f17388a;

    /* renamed from: b  reason: collision with root package name */
    private final v.b f17389b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17390c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17391d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f17392e = true;

    /* renamed from: f  reason: collision with root package name */
    private int f17393f;

    /* renamed from: g  reason: collision with root package name */
    private int f17394g;

    /* renamed from: h  reason: collision with root package name */
    private int f17395h;

    /* renamed from: i  reason: collision with root package name */
    private int f17396i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f17397j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f17398k;

    /* renamed from: l  reason: collision with root package name */
    private Object f17399l;

    w(s sVar, Uri uri, int i4) {
        if (!sVar.f17316n) {
            this.f17388a = sVar;
            this.f17389b = new v.b(uri, i4, sVar.f17313k);
            return;
        }
        throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
    }

    private v c(long j4) {
        int andIncrement = f17387m.getAndIncrement();
        v a5 = this.f17389b.a();
        a5.f17350a = andIncrement;
        a5.f17351b = j4;
        boolean z4 = this.f17388a.f17315m;
        if (z4) {
            C.u("Main", "created", a5.g(), a5.toString());
        }
        v p4 = this.f17388a.p(a5);
        if (p4 != a5) {
            p4.f17350a = andIncrement;
            p4.f17351b = j4;
            if (z4) {
                String d5 = p4.d();
                C.u("Main", "changed", d5, "into " + p4);
            }
        }
        return p4;
    }

    private Drawable h() {
        int i4 = this.f17393f;
        if (i4 != 0) {
            return this.f17388a.f17306d.getDrawable(i4);
        }
        return this.f17397j;
    }

    public w a() {
        this.f17389b.b(17);
        return this;
    }

    /* access modifiers changed from: package-private */
    public w b() {
        this.f17399l = null;
        return this;
    }

    public void d() {
        e((b) null);
    }

    public void e(b bVar) {
        long nanoTime = System.nanoTime();
        if (this.f17391d) {
            throw new IllegalStateException("Fit cannot be used with fetch.");
        } else if (this.f17389b.c()) {
            if (!this.f17389b.d()) {
                this.f17389b.f(s.f.LOW);
            }
            v c5 = c(nanoTime);
            String h4 = C.h(c5, new StringBuilder());
            if (!o.a(this.f17395h) || this.f17388a.m(h4) == null) {
                this.f17388a.o(new h(this.f17388a, c5, this.f17395h, this.f17396i, this.f17399l, h4, bVar));
                return;
            }
            if (this.f17388a.f17315m) {
                String g4 = c5.g();
                C.u("Main", "completed", g4, "from " + s.e.MEMORY);
            }
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    public w f() {
        this.f17391d = true;
        return this;
    }

    public Bitmap g() {
        long nanoTime = System.nanoTime();
        C.d();
        if (this.f17391d) {
            throw new IllegalStateException("Fit cannot be used with get.");
        } else if (!this.f17389b.c()) {
            return null;
        } else {
            v c5 = c(nanoTime);
            j jVar = new j(this.f17388a, c5, this.f17395h, this.f17396i, this.f17399l, C.h(c5, new StringBuilder()));
            s sVar = this.f17388a;
            return C1816c.g(sVar, sVar.f17307e, sVar.f17308f, sVar.f17309g, jVar).t();
        }
    }

    public void i(ImageView imageView) {
        j(imageView, (b) null);
    }

    public void j(ImageView imageView, b bVar) {
        Bitmap m4;
        b bVar2 = bVar;
        long nanoTime = System.nanoTime();
        C.c();
        if (imageView == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (!this.f17389b.c()) {
            this.f17388a.b(imageView);
            if (this.f17392e) {
                t.d(imageView, h());
            }
        } else {
            if (this.f17391d) {
                if (!this.f17389b.e()) {
                    int width = imageView.getWidth();
                    int height = imageView.getHeight();
                    if (width == 0 || height == 0) {
                        if (this.f17392e) {
                            t.d(imageView, h());
                        }
                        this.f17388a.e(imageView, new f(this, imageView, bVar));
                        return;
                    }
                    this.f17389b.g(width, height);
                } else {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
            }
            v c5 = c(nanoTime);
            String g4 = C.g(c5);
            if (!o.a(this.f17395h) || (m4 = this.f17388a.m(g4)) == null) {
                if (this.f17392e) {
                    t.d(imageView, h());
                }
                ImageView imageView2 = imageView;
                this.f17388a.g(new k(this.f17388a, imageView2, c5, this.f17395h, this.f17396i, this.f17394g, this.f17398k, g4, this.f17399l, bVar2, this.f17390c));
                return;
            }
            this.f17388a.b(imageView);
            s sVar = this.f17388a;
            Context context = sVar.f17306d;
            s.e eVar = s.e.MEMORY;
            Context context2 = context;
            boolean z4 = this.f17390c;
            Context context3 = context2;
            boolean z5 = sVar.f17314l;
            t.c(imageView, context3, m4, eVar, z4, z5);
            if (this.f17388a.f17315m) {
                String g5 = c5.g();
                C.u("Main", "completed", g5, "from " + eVar);
            }
            if (bVar2 != null) {
                bVar.b();
            }
        }
    }

    public void k(A a5) {
        Bitmap m4;
        long nanoTime = System.nanoTime();
        C.c();
        if (a5 == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (!this.f17391d) {
            Drawable drawable = null;
            if (!this.f17389b.c()) {
                this.f17388a.c(a5);
                if (this.f17392e) {
                    drawable = h();
                }
                a5.b(drawable);
                return;
            }
            v c5 = c(nanoTime);
            String g4 = C.g(c5);
            if (!o.a(this.f17395h) || (m4 = this.f17388a.m(g4)) == null) {
                if (this.f17392e) {
                    drawable = h();
                }
                a5.b(drawable);
                this.f17388a.g(new B(this.f17388a, a5, c5, this.f17395h, this.f17396i, this.f17398k, g4, this.f17399l, this.f17394g));
                return;
            }
            this.f17388a.c(a5);
            a5.c(m4, s.e.MEMORY);
        } else {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        }
    }

    public w l(int i4) {
        if (!this.f17392e) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        } else if (i4 == 0) {
            throw new IllegalArgumentException("Placeholder image resource invalid.");
        } else if (this.f17397j == null) {
            this.f17393f = i4;
            return this;
        } else {
            throw new IllegalStateException("Placeholder image already set.");
        }
    }

    public w m(int i4, int i5) {
        this.f17389b.g(i4, i5);
        return this;
    }

    public w n(e eVar) {
        this.f17389b.h(eVar);
        return this;
    }

    /* access modifiers changed from: package-private */
    public w o() {
        this.f17391d = false;
        return this;
    }
}
