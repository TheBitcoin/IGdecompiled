package W3;

import R2.n;
import R2.s;
import android.graphics.BitmapFactory;
import d3.p;
import java.net.URL;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

public final class c implements b {

    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f24234a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f24235b;

        /* renamed from: c  reason: collision with root package name */
        public int f24236c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar, V2.d dVar) {
            super(dVar);
            this.f24235b = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f24234a = obj;
            this.f24236c |= Integer.MIN_VALUE;
            return this.f24235b.a((String) null, this);
        }
    }

    public static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f24237a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str, V2.d dVar) {
            super(2, dVar);
            this.f24237a = str;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f24237a, dVar);
        }

        public Object invoke(Object obj, Object obj2) {
            J j4 = (J) obj;
            return new b(this.f24237a, (V2.d) obj2).invokeSuspend(s.f8222a);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
            b3.C1642b.a(r0, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r3) {
            /*
                r2 = this;
                W2.b.c()
                R2.n.b(r3)
                java.net.URL r3 = new java.net.URL
                java.lang.String r0 = r2.f24237a
                r3.<init>(r0)
                java.net.URLConnection r3 = r3.openConnection()
                if (r3 == 0) goto L_0x0033
                java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3
                java.io.BufferedReader r0 = new java.io.BufferedReader
                java.io.InputStreamReader r1 = new java.io.InputStreamReader
                java.io.InputStream r3 = r3.getInputStream()
                r1.<init>(r3)
                r0.<init>(r1)
                java.lang.String r3 = b3.i.f(r0)     // Catch:{ all -> 0x002c }
                r1 = 0
                b3.C1642b.a(r0, r1)
                return r3
            L_0x002c:
                r3 = move-exception
                throw r3     // Catch:{ all -> 0x002e }
            L_0x002e:
                r1 = move-exception
                b3.C1642b.a(r0, r3)
                throw r1
            L_0x0033:
                java.lang.NullPointerException r3 = new java.lang.NullPointerException
                java.lang.String r0 = "null cannot be cast to non-null type java.net.HttpURLConnection"
                r3.<init>(r0)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: W3.c.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* renamed from: W3.c$c  reason: collision with other inner class name */
    public static final class C0291c extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f24238a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f24239b;

        /* renamed from: c  reason: collision with root package name */
        public int f24240c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0291c(c cVar, V2.d dVar) {
            super(dVar);
            this.f24239b = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f24238a = obj;
            this.f24240c |= Integer.MIN_VALUE;
            return this.f24239b.b((String) null, this);
        }
    }

    public static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f24241a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str, V2.d dVar) {
            super(2, dVar);
            this.f24241a = str;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f24241a, dVar);
        }

        public Object invoke(Object obj, Object obj2) {
            J j4 = (J) obj;
            return new d(this.f24241a, (V2.d) obj2).invokeSuspend(s.f8222a);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            n.b(obj);
            return BitmapFactory.decodeStream(new URL(this.f24241a).openConnection().getInputStream());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(java.lang.String r12, V2.d r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof W3.c.a
            if (r0 == 0) goto L_0x0013
            r0 = r13
            W3.c$a r0 = (W3.c.a) r0
            int r1 = r0.f24236c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f24236c = r1
            goto L_0x0018
        L_0x0013:
            W3.c$a r0 = new W3.c$a
            r0.<init>(r11, r13)
        L_0x0018:
            java.lang.Object r13 = r0.f24234a
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f24236c
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            R2.n.b(r13)     // Catch:{ Exception -> 0x0029 }
            goto L_0x004b
        L_0x0029:
            r0 = move-exception
            r12 = r0
            r9 = r12
            goto L_0x004e
        L_0x002d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0035:
            R2.n.b(r13)
            o3.G r13 = o3.Y.b()     // Catch:{ Exception -> 0x0029 }
            W3.c$b r2 = new W3.c$b     // Catch:{ Exception -> 0x0029 }
            r4 = 0
            r2.<init>(r12, r4)     // Catch:{ Exception -> 0x0029 }
            r0.f24236c = r3     // Catch:{ Exception -> 0x0029 }
            java.lang.Object r13 = o3.C0977g.g(r13, r2, r0)     // Catch:{ Exception -> 0x0029 }
            if (r13 != r1) goto L_0x004b
            return r1
        L_0x004b:
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ Exception -> 0x0029 }
            return r13
        L_0x004e:
            boolean r12 = r9 instanceof java.security.cert.CertificateException
            if (r12 == 0) goto L_0x0054
            r12 = 1
            goto L_0x0056
        L_0x0054:
            boolean r12 = r9 instanceof javax.net.ssl.SSLHandshakeException
        L_0x0056:
            if (r12 == 0) goto L_0x005a
            r12 = 1
            goto L_0x005c
        L_0x005a:
            boolean r12 = r9 instanceof java.net.SocketException
        L_0x005c:
            if (r12 == 0) goto L_0x0060
            r12 = 1
            goto L_0x0062
        L_0x0060:
            boolean r12 = r9 instanceof java.net.MalformedURLException
        L_0x0062:
            if (r12 == 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            boolean r3 = r9 instanceof java.lang.NullPointerException
        L_0x0067:
            if (r3 != 0) goto L_0x0074
            boolean r12 = r9 instanceof java.io.FileNotFoundException
            if (r12 == 0) goto L_0x0071
            com.inmobi.cmp.model.ChoiceError r12 = com.inmobi.cmp.model.ChoiceError.NETWORK_FILE_NOT_FOUND_ERROR
        L_0x006f:
            r5 = r12
            goto L_0x0077
        L_0x0071:
            com.inmobi.cmp.model.ChoiceError r12 = com.inmobi.cmp.model.ChoiceError.NETWORK_UNEXPECTED_ERROR
            goto L_0x006f
        L_0x0074:
            com.inmobi.cmp.model.ChoiceError r12 = com.inmobi.cmp.model.ChoiceError.NETWORK_CALL_FAILED
            goto L_0x006f
        L_0x0077:
            C2.b r4 = C2.b.f6277a
            r8 = 0
            r10 = 14
            r6 = 0
            r7 = 0
            C2.b.a(r4, r5, r6, r7, r8, r9, r10)
            C2.a r12 = new C2.a
            r12.<init>(r5)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: W3.c.a(java.lang.String, V2.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(java.lang.String r12, V2.d r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof W3.c.C0291c
            if (r0 == 0) goto L_0x0013
            r0 = r13
            W3.c$c r0 = (W3.c.C0291c) r0
            int r1 = r0.f24240c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f24240c = r1
            goto L_0x0018
        L_0x0013:
            W3.c$c r0 = new W3.c$c
            r0.<init>(r11, r13)
        L_0x0018:
            java.lang.Object r13 = r0.f24238a
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f24240c
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            R2.n.b(r13)     // Catch:{ Exception -> 0x0029 }
            goto L_0x004b
        L_0x0029:
            r0 = move-exception
            r12 = r0
            r9 = r12
            goto L_0x0053
        L_0x002d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0035:
            R2.n.b(r13)
            o3.G r13 = o3.Y.b()     // Catch:{ Exception -> 0x0029 }
            W3.c$d r2 = new W3.c$d     // Catch:{ Exception -> 0x0029 }
            r4 = 0
            r2.<init>(r12, r4)     // Catch:{ Exception -> 0x0029 }
            r0.f24240c = r3     // Catch:{ Exception -> 0x0029 }
            java.lang.Object r13 = o3.C0977g.g(r13, r2, r0)     // Catch:{ Exception -> 0x0029 }
            if (r13 != r1) goto L_0x004b
            return r1
        L_0x004b:
            java.lang.String r12 = "url: String): Bitmap {\n …}\n            }\n        }"
            kotlin.jvm.internal.m.d(r13, r12)     // Catch:{ Exception -> 0x0029 }
            android.graphics.Bitmap r13 = (android.graphics.Bitmap) r13     // Catch:{ Exception -> 0x0029 }
            return r13
        L_0x0053:
            boolean r12 = r9 instanceof java.security.cert.CertificateException
            if (r12 == 0) goto L_0x0059
            r12 = 1
            goto L_0x005b
        L_0x0059:
            boolean r12 = r9 instanceof javax.net.ssl.SSLHandshakeException
        L_0x005b:
            if (r12 == 0) goto L_0x005f
            r12 = 1
            goto L_0x0061
        L_0x005f:
            boolean r12 = r9 instanceof java.net.SocketException
        L_0x0061:
            if (r12 == 0) goto L_0x0065
            r12 = 1
            goto L_0x0067
        L_0x0065:
            boolean r12 = r9 instanceof java.net.MalformedURLException
        L_0x0067:
            if (r12 == 0) goto L_0x006a
            goto L_0x006c
        L_0x006a:
            boolean r3 = r9 instanceof java.lang.NullPointerException
        L_0x006c:
            if (r3 != 0) goto L_0x0079
            boolean r12 = r9 instanceof java.io.FileNotFoundException
            if (r12 == 0) goto L_0x0076
            com.inmobi.cmp.model.ChoiceError r12 = com.inmobi.cmp.model.ChoiceError.NETWORK_FILE_NOT_FOUND_ERROR
        L_0x0074:
            r5 = r12
            goto L_0x007c
        L_0x0076:
            com.inmobi.cmp.model.ChoiceError r12 = com.inmobi.cmp.model.ChoiceError.NETWORK_UNEXPECTED_ERROR
            goto L_0x0074
        L_0x0079:
            com.inmobi.cmp.model.ChoiceError r12 = com.inmobi.cmp.model.ChoiceError.FAILED_LOGO_DOWNLOAD
            goto L_0x0074
        L_0x007c:
            C2.b r4 = C2.b.f6277a
            r8 = 0
            r10 = 14
            r6 = 0
            r7 = 0
            C2.b.a(r4, r5, r6, r7, r8, r9, r10)
            C2.a r12 = new C2.a
            r12.<init>(r5)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: W3.c.b(java.lang.String, V2.d):java.lang.Object");
    }
}
