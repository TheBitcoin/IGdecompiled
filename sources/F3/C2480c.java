package F3;

import D3.C2456d;
import D3.C2469q;
import D3.x;
import D3.z;
import E3.C2476a;
import H3.d;
import H3.e;
import com.mbridge.msdk.foundation.download.Command;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* renamed from: F3.c  reason: case insensitive filesystem */
public final class C2480c {

    /* renamed from: a  reason: collision with root package name */
    public final x f23268a;

    /* renamed from: b  reason: collision with root package name */
    public final z f23269b;

    /* renamed from: F3.c$a */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final long f23270a;

        /* renamed from: b  reason: collision with root package name */
        final x f23271b;

        /* renamed from: c  reason: collision with root package name */
        final z f23272c;

        /* renamed from: d  reason: collision with root package name */
        private Date f23273d;

        /* renamed from: e  reason: collision with root package name */
        private String f23274e;

        /* renamed from: f  reason: collision with root package name */
        private Date f23275f;

        /* renamed from: g  reason: collision with root package name */
        private String f23276g;

        /* renamed from: h  reason: collision with root package name */
        private Date f23277h;

        /* renamed from: i  reason: collision with root package name */
        private long f23278i;

        /* renamed from: j  reason: collision with root package name */
        private long f23279j;

        /* renamed from: k  reason: collision with root package name */
        private String f23280k;

        /* renamed from: l  reason: collision with root package name */
        private int f23281l = -1;

        public a(long j4, x xVar, z zVar) {
            this.f23270a = j4;
            this.f23271b = xVar;
            this.f23272c = zVar;
            if (zVar != null) {
                this.f23278i = zVar.D();
                this.f23279j = zVar.z();
                C2469q o4 = zVar.o();
                int e5 = o4.e();
                for (int i4 = 0; i4 < e5; i4++) {
                    String c5 = o4.c(i4);
                    String f4 = o4.f(i4);
                    if ("Date".equalsIgnoreCase(c5)) {
                        this.f23273d = d.b(f4);
                        this.f23274e = f4;
                    } else if ("Expires".equalsIgnoreCase(c5)) {
                        this.f23277h = d.b(f4);
                    } else if ("Last-Modified".equalsIgnoreCase(c5)) {
                        this.f23275f = d.b(f4);
                        this.f23276g = f4;
                    } else if (Command.HTTP_HEADER_ETAG.equalsIgnoreCase(c5)) {
                        this.f23280k = f4;
                    } else if ("Age".equalsIgnoreCase(c5)) {
                        this.f23281l = e.f(f4, -1);
                    }
                }
            }
        }

        private long a() {
            Date date = this.f23273d;
            long j4 = 0;
            if (date != null) {
                j4 = Math.max(0, this.f23279j - date.getTime());
            }
            int i4 = this.f23281l;
            if (i4 != -1) {
                j4 = Math.max(j4, TimeUnit.SECONDS.toMillis((long) i4));
            }
            long j5 = this.f23279j;
            return j4 + (j5 - this.f23278i) + (this.f23270a - j5);
        }

        private long b() {
            long j4;
            long j5;
            C2456d d5 = this.f23272c.d();
            if (d5.e() != -1) {
                return TimeUnit.SECONDS.toMillis((long) d5.e());
            }
            if (this.f23277h != null) {
                Date date = this.f23273d;
                if (date != null) {
                    j5 = date.getTime();
                } else {
                    j5 = this.f23279j;
                }
                long time = this.f23277h.getTime() - j5;
                if (time > 0) {
                    return time;
                }
                return 0;
            }
            if (this.f23275f != null && this.f23272c.A().i().x() == null) {
                Date date2 = this.f23273d;
                if (date2 != null) {
                    j4 = date2.getTime();
                } else {
                    j4 = this.f23278i;
                }
                long time2 = j4 - this.f23275f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
            }
            return 0;
        }

        private C2480c d() {
            long j4;
            String str;
            if (this.f23272c == null) {
                return new C2480c(this.f23271b, (z) null);
            }
            if (this.f23271b.f() && this.f23272c.k() == null) {
                return new C2480c(this.f23271b, (z) null);
            }
            if (!C2480c.a(this.f23272c, this.f23271b)) {
                return new C2480c(this.f23271b, (z) null);
            }
            C2456d b5 = this.f23271b.b();
            if (b5.i() || e(this.f23271b)) {
                return new C2480c(this.f23271b, (z) null);
            }
            C2456d d5 = this.f23272c.d();
            if (d5.b()) {
                return new C2480c((x) null, this.f23272c);
            }
            long a5 = a();
            long b6 = b();
            if (b5.e() != -1) {
                b6 = Math.min(b6, TimeUnit.SECONDS.toMillis((long) b5.e()));
            }
            long j5 = 0;
            if (b5.g() != -1) {
                j4 = TimeUnit.SECONDS.toMillis((long) b5.g());
            } else {
                j4 = 0;
            }
            if (!d5.h() && b5.f() != -1) {
                j5 = TimeUnit.SECONDS.toMillis((long) b5.f());
            }
            if (!d5.i()) {
                long j6 = j4 + a5;
                if (j6 < j5 + b6) {
                    z.a v4 = this.f23272c.v();
                    if (j6 >= b6) {
                        v4.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (a5 > 86400000 && f()) {
                        v4.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new C2480c((x) null, v4.c());
                }
            }
            String str2 = this.f23280k;
            if (str2 != null) {
                str = "If-None-Match";
            } else {
                if (this.f23275f != null) {
                    str2 = this.f23276g;
                } else if (this.f23273d == null) {
                    return new C2480c(this.f23271b, (z) null);
                } else {
                    str2 = this.f23274e;
                }
                str = "If-Modified-Since";
            }
            C2469q.a d6 = this.f23271b.d().d();
            C2476a.f23240a.b(d6, str, str2);
            return new C2480c(this.f23271b.h().d(d6.d()).a(), this.f23272c);
        }

        private static boolean e(x xVar) {
            if (xVar.c("If-Modified-Since") == null && xVar.c("If-None-Match") == null) {
                return false;
            }
            return true;
        }

        private boolean f() {
            if (this.f23272c.d().e() == -1 && this.f23277h == null) {
                return true;
            }
            return false;
        }

        public C2480c c() {
            C2480c d5 = d();
            if (d5.f23268a == null || !this.f23271b.b().k()) {
                return d5;
            }
            return new C2480c((x) null, (z) null);
        }
    }

    C2480c(x xVar, z zVar) {
        this.f23268a = xVar;
        this.f23269b = zVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
        if (r3.d().c() == false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(D3.z r3, D3.x r4) {
        /*
            int r0 = r3.i()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L_0x005a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L_0x0031
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L_0x005a
            switch(r0) {
                case 300: goto L_0x005a;
                case 301: goto L_0x005a;
                case 302: goto L_0x0031;
                default: goto L_0x0030;
            }
        L_0x0030:
            goto L_0x0059
        L_0x0031:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.l(r0)
            if (r0 != 0) goto L_0x005a
            D3.d r0 = r3.d()
            int r0 = r0.e()
            r1 = -1
            if (r0 != r1) goto L_0x005a
            D3.d r0 = r3.d()
            boolean r0 = r0.d()
            if (r0 != 0) goto L_0x005a
            D3.d r0 = r3.d()
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            return r2
        L_0x005a:
            D3.d r3 = r3.d()
            boolean r3 = r3.j()
            if (r3 != 0) goto L_0x0070
            D3.d r3 = r4.b()
            boolean r3 = r3.j()
            if (r3 != 0) goto L_0x0070
            r3 = 1
            return r3
        L_0x0070:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: F3.C2480c.a(D3.z, D3.x):boolean");
    }
}
