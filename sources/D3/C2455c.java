package D3;

import D3.C2469q;
import D3.x;
import D3.z;
import E3.c;
import F3.C2479b;
import F3.C2480c;
import F3.d;
import F3.f;
import H3.e;
import H3.k;
import K3.C2493a;
import L3.C2499f;
import N3.C2514e;
import N3.C2515f;
import N3.C2516g;
import N3.C2517h;
import N3.C2521l;
import N3.C2522m;
import N3.L;
import N3.X;
import N3.Z;
import androidx.browser.trusted.sharing.ShareTarget;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: D3.c  reason: case insensitive filesystem */
public final class C2455c implements Closeable, Flushable, AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    final f f22882a;

    /* renamed from: b  reason: collision with root package name */
    final F3.d f22883b;

    /* renamed from: c  reason: collision with root package name */
    int f22884c;

    /* renamed from: d  reason: collision with root package name */
    int f22885d;

    /* renamed from: e  reason: collision with root package name */
    private int f22886e;

    /* renamed from: f  reason: collision with root package name */
    private int f22887f;

    /* renamed from: g  reason: collision with root package name */
    private int f22888g;

    /* renamed from: D3.c$a */
    class a implements f {
        a() {
        }

        public void a(x xVar) {
            C2455c.this.l(xVar);
        }

        public z b(x xVar) {
            return C2455c.this.d(xVar);
        }

        public C2479b c(z zVar) {
            return C2455c.this.i(zVar);
        }

        public void d(C2480c cVar) {
            C2455c.this.o(cVar);
        }

        public void e(z zVar, z zVar2) {
            C2455c.this.p(zVar, zVar2);
        }

        public void trackConditionalCacheHit() {
            C2455c.this.n();
        }
    }

    /* renamed from: D3.c$b */
    private final class b implements C2479b {

        /* renamed from: a  reason: collision with root package name */
        private final d.c f22890a;

        /* renamed from: b  reason: collision with root package name */
        private X f22891b;

        /* renamed from: c  reason: collision with root package name */
        private X f22892c;

        /* renamed from: d  reason: collision with root package name */
        boolean f22893d;

        /* renamed from: D3.c$b$a */
        class a extends C2521l {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2455c f22895b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ d.c f22896c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(X x4, C2455c cVar, d.c cVar2) {
                super(x4);
                this.f22895b = cVar;
                this.f22896c = cVar2;
            }

            public void close() {
                synchronized (C2455c.this) {
                    try {
                        b bVar = b.this;
                        if (!bVar.f22893d) {
                            bVar.f22893d = true;
                            C2455c.this.f22884c++;
                            super.close();
                            this.f22896c.b();
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            }
        }

        b(d.c cVar) {
            this.f22890a = cVar;
            X d5 = cVar.d(1);
            this.f22891b = d5;
            this.f22892c = new a(d5, C2455c.this, cVar);
        }

        public void abort() {
            synchronized (C2455c.this) {
                try {
                    if (!this.f22893d) {
                        this.f22893d = true;
                        C2455c.this.f22885d++;
                        c.d(this.f22891b);
                        try {
                            this.f22890a.a();
                        } catch (IOException unused) {
                        }
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        public X body() {
            return this.f22892c;
        }
    }

    /* renamed from: D3.c$c  reason: collision with other inner class name */
    private static class C0277c extends C2450A {

        /* renamed from: a  reason: collision with root package name */
        final d.e f22898a;

        /* renamed from: b  reason: collision with root package name */
        private final C2516g f22899b;

        /* renamed from: c  reason: collision with root package name */
        private final String f22900c;

        /* renamed from: d  reason: collision with root package name */
        private final String f22901d;

        /* renamed from: D3.c$c$a */
        class a extends C2522m {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ d.e f22902b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Z z4, d.e eVar) {
                super(z4);
                this.f22902b = eVar;
            }

            public void close() {
                this.f22902b.close();
                super.close();
            }
        }

        C0277c(d.e eVar, String str, String str2) {
            this.f22898a = eVar;
            this.f22900c = str;
            this.f22901d = str2;
            this.f22899b = L.d(new a(eVar.d(1), eVar));
        }

        public long a() {
            try {
                String str = this.f22901d;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        public C2516g i() {
            return this.f22899b;
        }
    }

    public C2455c(File file, long j4) {
        this(file, j4, C2493a.f23604a);
    }

    private void a(d.c cVar) {
        if (cVar != null) {
            try {
                cVar.a();
            } catch (IOException unused) {
            }
        }
    }

    public static String g(C2470r rVar) {
        return C2517h.f(rVar.toString()).v().m();
    }

    static int k(C2516g gVar) {
        try {
            long readDecimalLong = gVar.readDecimalLong();
            String readUtf8LineStrict = gVar.readUtf8LineStrict();
            if (readDecimalLong >= 0 && readDecimalLong <= 2147483647L && readUtf8LineStrict.isEmpty()) {
                return (int) readDecimalLong;
            }
            throw new IOException("expected an int but was \"" + readDecimalLong + readUtf8LineStrict + "\"");
        } catch (NumberFormatException e5) {
            throw new IOException(e5.getMessage());
        }
    }

    public void close() {
        this.f22883b.close();
    }

    /* access modifiers changed from: package-private */
    public z d(x xVar) {
        try {
            d.e n4 = this.f22883b.n(g(xVar.i()));
            if (n4 == null) {
                return null;
            }
            try {
                d dVar = new d(n4.d(0));
                z d5 = dVar.d(n4);
                if (dVar.b(xVar, d5)) {
                    return d5;
                }
                c.d(d5.a());
                return null;
            } catch (IOException unused) {
                c.d(n4);
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    public void flush() {
        this.f22883b.flush();
    }

    /* access modifiers changed from: package-private */
    public C2479b i(z zVar) {
        d.c cVar;
        String g4 = zVar.A().g();
        if (H3.f.a(zVar.A().g())) {
            try {
                l(zVar.A());
            } catch (IOException unused) {
            }
            return null;
        } else if (!g4.equals(ShareTarget.METHOD_GET) || e.e(zVar)) {
            return null;
        } else {
            d dVar = new d(zVar);
            try {
                cVar = this.f22883b.k(g(zVar.A().i()));
                if (cVar == null) {
                    return null;
                }
                try {
                    dVar.f(cVar);
                    return new b(cVar);
                } catch (IOException unused2) {
                    a(cVar);
                    return null;
                }
            } catch (IOException unused3) {
                cVar = null;
                a(cVar);
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void l(x xVar) {
        this.f22883b.z(g(xVar.i()));
    }

    /* access modifiers changed from: package-private */
    public synchronized void n() {
        this.f22887f++;
    }

    /* access modifiers changed from: package-private */
    public synchronized void o(C2480c cVar) {
        try {
            this.f22888g++;
            if (cVar.f23268a != null) {
                this.f22886e++;
            } else if (cVar.f23269b != null) {
                this.f22887f++;
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void p(z zVar, z zVar2) {
        d.c cVar;
        d dVar = new d(zVar2);
        try {
            cVar = ((C0277c) zVar.a()).f22898a.a();
            if (cVar != null) {
                try {
                    dVar.f(cVar);
                    cVar.b();
                } catch (IOException unused) {
                    a(cVar);
                }
            }
        } catch (IOException unused2) {
            cVar = null;
            a(cVar);
        }
    }

    C2455c(File file, long j4, C2493a aVar) {
        this.f22882a = new a();
        this.f22883b = F3.d.g(aVar, file, 201105, 2, j4);
    }

    /* renamed from: D3.c$d */
    private static final class d {

        /* renamed from: k  reason: collision with root package name */
        private static final String f22904k = (C2499f.i().j() + "-Sent-Millis");

        /* renamed from: l  reason: collision with root package name */
        private static final String f22905l = (C2499f.i().j() + "-Received-Millis");

        /* renamed from: a  reason: collision with root package name */
        private final String f22906a;

        /* renamed from: b  reason: collision with root package name */
        private final C2469q f22907b;

        /* renamed from: c  reason: collision with root package name */
        private final String f22908c;

        /* renamed from: d  reason: collision with root package name */
        private final C2474v f22909d;

        /* renamed from: e  reason: collision with root package name */
        private final int f22910e;

        /* renamed from: f  reason: collision with root package name */
        private final String f22911f;

        /* renamed from: g  reason: collision with root package name */
        private final C2469q f22912g;

        /* renamed from: h  reason: collision with root package name */
        private final C2468p f22913h;

        /* renamed from: i  reason: collision with root package name */
        private final long f22914i;

        /* renamed from: j  reason: collision with root package name */
        private final long f22915j;

        d(Z z4) {
            C2452C c5;
            try {
                C2516g d5 = L.d(z4);
                this.f22906a = d5.readUtf8LineStrict();
                this.f22908c = d5.readUtf8LineStrict();
                C2469q.a aVar = new C2469q.a();
                int k4 = C2455c.k(d5);
                for (int i4 = 0; i4 < k4; i4++) {
                    aVar.b(d5.readUtf8LineStrict());
                }
                this.f22907b = aVar.d();
                k a5 = k.a(d5.readUtf8LineStrict());
                this.f22909d = a5.f23398a;
                this.f22910e = a5.f23399b;
                this.f22911f = a5.f23400c;
                C2469q.a aVar2 = new C2469q.a();
                int k5 = C2455c.k(d5);
                for (int i5 = 0; i5 < k5; i5++) {
                    aVar2.b(d5.readUtf8LineStrict());
                }
                String str = f22904k;
                String f4 = aVar2.f(str);
                String str2 = f22905l;
                String f5 = aVar2.f(str2);
                aVar2.g(str);
                aVar2.g(str2);
                long j4 = 0;
                this.f22914i = f4 != null ? Long.parseLong(f4) : 0;
                this.f22915j = f5 != null ? Long.parseLong(f5) : j4;
                this.f22912g = aVar2.d();
                if (a()) {
                    String readUtf8LineStrict = d5.readUtf8LineStrict();
                    if (readUtf8LineStrict.length() <= 0) {
                        C2459g a6 = C2459g.a(d5.readUtf8LineStrict());
                        List c6 = c(d5);
                        List c7 = c(d5);
                        if (!d5.exhausted()) {
                            c5 = C2452C.a(d5.readUtf8LineStrict());
                        } else {
                            c5 = C2452C.SSL_3_0;
                        }
                        this.f22913h = C2468p.b(c5, a6, c6, c7);
                    } else {
                        throw new IOException("expected \"\" but was \"" + readUtf8LineStrict + "\"");
                    }
                } else {
                    this.f22913h = null;
                }
            } finally {
                z4.close();
            }
        }

        private boolean a() {
            return this.f22906a.startsWith("https://");
        }

        private List c(C2516g gVar) {
            int k4 = C2455c.k(gVar);
            if (k4 == -1) {
                return Collections.EMPTY_LIST;
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(k4);
                for (int i4 = 0; i4 < k4; i4++) {
                    String readUtf8LineStrict = gVar.readUtf8LineStrict();
                    C2514e eVar = new C2514e();
                    eVar.G(C2517h.c(readUtf8LineStrict));
                    arrayList.add(instance.generateCertificate(eVar.inputStream()));
                }
                return arrayList;
            } catch (CertificateException e5) {
                throw new IOException(e5.getMessage());
            }
        }

        private void e(C2515f fVar, List list) {
            try {
                fVar.writeDecimalLong((long) list.size()).writeByte(10);
                int size = list.size();
                for (int i4 = 0; i4 < size; i4++) {
                    fVar.writeUtf8(C2517h.w(((Certificate) list.get(i4)).getEncoded()).a()).writeByte(10);
                }
            } catch (CertificateEncodingException e5) {
                throw new IOException(e5.getMessage());
            }
        }

        public boolean b(x xVar, z zVar) {
            if (!this.f22906a.equals(xVar.i().toString()) || !this.f22908c.equals(xVar.g()) || !e.o(zVar, this.f22907b, xVar)) {
                return false;
            }
            return true;
        }

        public z d(d.e eVar) {
            String a5 = this.f22912g.a("Content-Type");
            String a6 = this.f22912g.a("Content-Length");
            return new z.a().o(new x.a().h(this.f22906a).e(this.f22908c, (y) null).d(this.f22907b).a()).m(this.f22909d).g(this.f22910e).j(this.f22911f).i(this.f22912g).b(new C0277c(eVar, a5, a6)).h(this.f22913h).p(this.f22914i).n(this.f22915j).c();
        }

        public void f(d.c cVar) {
            C2515f c5 = L.c(cVar.d(0));
            c5.writeUtf8(this.f22906a).writeByte(10);
            c5.writeUtf8(this.f22908c).writeByte(10);
            c5.writeDecimalLong((long) this.f22907b.e()).writeByte(10);
            int e5 = this.f22907b.e();
            for (int i4 = 0; i4 < e5; i4++) {
                c5.writeUtf8(this.f22907b.c(i4)).writeUtf8(": ").writeUtf8(this.f22907b.f(i4)).writeByte(10);
            }
            c5.writeUtf8(new k(this.f22909d, this.f22910e, this.f22911f).toString()).writeByte(10);
            c5.writeDecimalLong((long) (this.f22912g.e() + 2)).writeByte(10);
            int e6 = this.f22912g.e();
            for (int i5 = 0; i5 < e6; i5++) {
                c5.writeUtf8(this.f22912g.c(i5)).writeUtf8(": ").writeUtf8(this.f22912g.f(i5)).writeByte(10);
            }
            c5.writeUtf8(f22904k).writeUtf8(": ").writeDecimalLong(this.f22914i).writeByte(10);
            c5.writeUtf8(f22905l).writeUtf8(": ").writeDecimalLong(this.f22915j).writeByte(10);
            if (a()) {
                c5.writeByte(10);
                c5.writeUtf8(this.f22913h.a().c()).writeByte(10);
                e(c5, this.f22913h.e());
                e(c5, this.f22913h.d());
                c5.writeUtf8(this.f22913h.f().c()).writeByte(10);
            }
            c5.close();
        }

        d(z zVar) {
            this.f22906a = zVar.A().i().toString();
            this.f22907b = e.n(zVar);
            this.f22908c = zVar.A().g();
            this.f22909d = zVar.x();
            this.f22910e = zVar.i();
            this.f22911f = zVar.r();
            this.f22912g = zVar.o();
            this.f22913h = zVar.k();
            this.f22914i = zVar.D();
            this.f22915j = zVar.z();
        }
    }
}
