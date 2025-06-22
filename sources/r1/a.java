package R1;

import R2.s;
import W1.C1611g;
import W1.C1612h;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.documentfile.provider.DocumentFile;
import d3.p;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import kotlin.jvm.internal.C2103g;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.L;
import o3.Y;

public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static final C0098a f8004e = new C0098a((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f8005a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final S1.b f8006b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f8007c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f8008d;

    /* renamed from: R1.a$a  reason: collision with other inner class name */
    public static final class C0098a {
        public /* synthetic */ C0098a(C2103g gVar) {
            this();
        }

        private C0098a() {
        }
    }

    static final class b extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f8009a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f8010b;

        /* renamed from: c  reason: collision with root package name */
        int f8011c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar, V2.d dVar) {
            super(dVar);
            this.f8010b = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f8009a = obj;
            this.f8011c |= Integer.MIN_VALUE;
            return this.f8010b.l((T1.b) null, this);
        }
    }

    static final class c extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8012a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f8013b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ T1.b f8014c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar, T1.b bVar, V2.d dVar) {
            super(2, dVar);
            this.f8013b = aVar;
            this.f8014c = bVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f8013b, this.f8014c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f8012a == 0) {
                R2.n.b(obj);
                S1.b i4 = this.f8013b.f8006b;
                if (i4 == null) {
                    return null;
                }
                i4.f(this.f8014c);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class d extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8015a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f8016b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ T1.b f8017c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(a aVar, T1.b bVar, V2.d dVar) {
            super(2, dVar);
            this.f8016b = aVar;
            this.f8017c = bVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f8016b, this.f8017c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f8015a == 0) {
                R2.n.b(obj);
                S1.b i4 = this.f8016b.f8006b;
                if (i4 == null) {
                    return null;
                }
                i4.f(this.f8017c);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class e extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8018a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f8019b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ T1.b f8020c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(a aVar, T1.b bVar, V2.d dVar) {
            super(2, dVar);
            this.f8019b = aVar;
            this.f8020c = bVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f8019b, this.f8020c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f8018a == 0) {
                R2.n.b(obj);
                S1.b i4 = this.f8019b.f8006b;
                if (i4 == null) {
                    return null;
                }
                i4.a(this.f8020c);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class f extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f8021a;

        /* renamed from: b  reason: collision with root package name */
        Object f8022b;

        /* renamed from: c  reason: collision with root package name */
        int f8023c;

        /* renamed from: d  reason: collision with root package name */
        int f8024d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f8025e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ a f8026f;

        /* renamed from: R1.a$f$a  reason: collision with other inner class name */
        static final class C0099a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8027a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a f8028b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ T1.b f8029c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f8030d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0099a(a aVar, T1.b bVar, int i4, V2.d dVar) {
                super(2, dVar);
                this.f8028b = aVar;
                this.f8029c = bVar;
                this.f8030d = i4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0099a(this.f8028b, this.f8029c, this.f8030d, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8027a == 0) {
                    R2.n.b(obj);
                    S1.b i4 = this.f8028b.f8006b;
                    if (i4 == null) {
                        return null;
                    }
                    i4.b(this.f8029c, this.f8030d);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((C0099a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class b extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8031a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a f8032b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f8033c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(a aVar, ArrayList arrayList, V2.d dVar) {
                super(2, dVar);
                this.f8032b = aVar;
                this.f8033c = arrayList;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f8032b, this.f8033c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8031a == 0) {
                    R2.n.b(obj);
                    S1.b i4 = this.f8032b.f8006b;
                    if (i4 == null) {
                        return null;
                    }
                    i4.c(this.f8033c);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(ArrayList arrayList, a aVar, V2.d dVar) {
            super(2, dVar);
            this.f8025e = arrayList;
            this.f8026f = aVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new f(this.f8025e, this.f8026f, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x008c, code lost:
            if (R1.a.d(r7, r6, r11) != r0) goto L_0x004b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a4, code lost:
            if (o3.C0977g.g(r12, r1, r11) == r0) goto L_0x00a6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r11.f8024d
                r2 = 3
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L_0x0039
                if (r1 == r4) goto L_0x002a
                if (r1 == r3) goto L_0x001f
                if (r1 != r2) goto L_0x0017
                R2.n.b(r12)
                goto L_0x00a7
            L_0x0017:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x001f:
                int r1 = r11.f8023c
                java.lang.Object r6 = r11.f8021a
                java.util.Iterator r6 = (java.util.Iterator) r6
                R2.n.b(r12)
                r12 = r6
                goto L_0x004b
            L_0x002a:
                int r1 = r11.f8023c
                java.lang.Object r6 = r11.f8022b
                T1.b r6 = (T1.b) r6
                java.lang.Object r7 = r11.f8021a
                java.util.Iterator r7 = (java.util.Iterator) r7
                R2.n.b(r12)
                r12 = r7
                goto L_0x0075
            L_0x0039:
                R2.n.b(r12)
                java.util.ArrayList r12 = r11.f8025e
                int r12 = r12.size()
                if (r12 <= 0) goto L_0x00a7
                java.util.ArrayList r12 = r11.f8025e
                java.util.Iterator r12 = r12.iterator()
                r1 = 0
            L_0x004b:
                boolean r6 = r12.hasNext()
                if (r6 == 0) goto L_0x008f
                int r6 = r1 + 1
                java.lang.Object r7 = r12.next()
                T1.b r7 = (T1.b) r7
                o3.E0 r8 = o3.Y.c()
                R1.a$f$a r9 = new R1.a$f$a
                R1.a r10 = r11.f8026f
                r9.<init>(r10, r7, r1, r5)
                r11.f8021a = r12
                r11.f8022b = r7
                r11.f8023c = r6
                r11.f8024d = r4
                java.lang.Object r1 = o3.C0977g.g(r8, r9, r11)
                if (r1 != r0) goto L_0x0073
                goto L_0x00a6
            L_0x0073:
                r1 = r6
                r6 = r7
            L_0x0075:
                R1.a r7 = r11.f8026f
                java.lang.String r7 = r7.p(r6)
                r6.d(r7)
                R1.a r7 = r11.f8026f
                r11.f8021a = r12
                r11.f8022b = r5
                r11.f8023c = r1
                r11.f8024d = r3
                java.lang.Object r6 = r7.o(r6, r11)
                if (r6 != r0) goto L_0x004b
                goto L_0x00a6
            L_0x008f:
                o3.E0 r12 = o3.Y.c()
                R1.a$f$b r1 = new R1.a$f$b
                R1.a r3 = r11.f8026f
                java.util.ArrayList r4 = r11.f8025e
                r1.<init>(r3, r4, r5)
                r11.f8021a = r5
                r11.f8024d = r2
                java.lang.Object r12 = o3.C0977g.g(r12, r1, r11)
                if (r12 != r0) goto L_0x00a7
            L_0x00a6:
                return r0
            L_0x00a7:
                R2.s r12 = R2.s.f8222a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: R1.a.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((f) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class g extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f8034a;

        /* renamed from: b  reason: collision with root package name */
        Object f8035b;

        /* renamed from: c  reason: collision with root package name */
        Object f8036c;

        /* renamed from: d  reason: collision with root package name */
        Object f8037d;

        /* renamed from: e  reason: collision with root package name */
        Object f8038e;

        /* renamed from: f  reason: collision with root package name */
        int f8039f;

        /* renamed from: g  reason: collision with root package name */
        int f8040g;

        /* renamed from: h  reason: collision with root package name */
        long f8041h;

        /* renamed from: i  reason: collision with root package name */
        long f8042i;

        /* renamed from: j  reason: collision with root package name */
        /* synthetic */ Object f8043j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ a f8044k;

        /* renamed from: l  reason: collision with root package name */
        int f8045l;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(a aVar, V2.d dVar) {
            super(dVar);
            this.f8044k = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f8043j = obj;
            this.f8045l |= Integer.MIN_VALUE;
            return this.f8044k.n((Object) null, (Object) null, this);
        }
    }

    static final class h extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8046a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f8047b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f8048c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(a aVar, int i4, V2.d dVar) {
            super(2, dVar);
            this.f8047b = aVar;
            this.f8048c = i4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new h(this.f8047b, this.f8048c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f8046a == 0) {
                R2.n.b(obj);
                S1.b i4 = this.f8047b.f8006b;
                if (i4 == null) {
                    return null;
                }
                i4.g(this.f8048c);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((h) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class i extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8049a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f8050b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ T1.b f8051c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(a aVar, T1.b bVar, V2.d dVar) {
            super(2, dVar);
            this.f8050b = aVar;
            this.f8051c = bVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new i(this.f8050b, this.f8051c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f8049a == 0) {
                R2.n.b(obj);
                S1.b i4 = this.f8050b.f8006b;
                if (i4 == null) {
                    return null;
                }
                i4.f(this.f8051c);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((i) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class j extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8052a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f8053b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ T1.b f8054c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(a aVar, T1.b bVar, V2.d dVar) {
            super(2, dVar);
            this.f8053b = aVar;
            this.f8054c = bVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new j(this.f8053b, this.f8054c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f8052a == 0) {
                R2.n.b(obj);
                S1.b i4 = this.f8053b.f8006b;
                if (i4 == null) {
                    return null;
                }
                i4.d(this.f8054c);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((j) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class k extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8055a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f8056b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f8057c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(a aVar, ArrayList arrayList, V2.d dVar) {
            super(2, dVar);
            this.f8056b = aVar;
            this.f8057c = arrayList;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new k(this.f8056b, this.f8057c, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0066, code lost:
            if (r0.exists() != false) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0068, code lost:
            r0.delete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0086, code lost:
            if (r4.exists() != false) goto L_0x0088;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0088, code lost:
            r4.delete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00cd, code lost:
            if (r0.exists() != false) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e9, code lost:
            if (r4.exists() != false) goto L_0x0088;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r3.f8055a
                r2 = 1
                if (r1 == 0) goto L_0x001d
                if (r1 != r2) goto L_0x0015
                R2.n.b(r4)     // Catch:{ CancellationException -> 0x0012 }
                goto L_0x002d
            L_0x000f:
                r4 = move-exception
                goto L_0x00ef
            L_0x0012:
                r4 = move-exception
                goto L_0x008c
            L_0x0015:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
            L_0x001d:
                R2.n.b(r4)
                R1.a r4 = r3.f8056b     // Catch:{ CancellationException -> 0x0012 }
                java.util.ArrayList r1 = r3.f8057c     // Catch:{ CancellationException -> 0x0012 }
                r3.f8055a = r2     // Catch:{ CancellationException -> 0x0012 }
                java.lang.Object r4 = r4.m(r1, r3)     // Catch:{ CancellationException -> 0x0012 }
                if (r4 != r0) goto L_0x002d
                return r0
            L_0x002d:
                R1.a r4 = r3.f8056b
                boolean r4 = r4.f8008d
                if (r4 == 0) goto L_0x00ec
                R1.a r4 = r3.f8056b
                java.lang.String r4 = r4.f8007c
                if (r4 == 0) goto L_0x00ec
                P1.a r4 = new P1.a
                R1.a r0 = r3.f8056b
                android.content.Context r0 = r0.f8005a
                r4.<init>(r0)
                java.lang.Object r4 = r4.c()
                if (r4 == 0) goto L_0x00ec
                boolean r0 = r4 instanceof java.io.File
                if (r0 == 0) goto L_0x006d
                java.io.File r0 = new java.io.File
                java.io.File r4 = (java.io.File) r4
                R1.a r1 = r3.f8056b
                java.lang.String r1 = r1.f8007c
                kotlin.jvm.internal.m.b(r1)
                r0.<init>(r4, r1)
                boolean r4 = r0.exists()
                if (r4 == 0) goto L_0x00ec
            L_0x0068:
                r0.delete()
                goto L_0x00ec
            L_0x006d:
                boolean r0 = r4 instanceof androidx.documentfile.provider.DocumentFile
                if (r0 == 0) goto L_0x00ec
                androidx.documentfile.provider.DocumentFile r4 = (androidx.documentfile.provider.DocumentFile) r4
                R1.a r0 = r3.f8056b
                java.lang.String r0 = r0.f8007c
                kotlin.jvm.internal.m.b(r0)
                androidx.documentfile.provider.DocumentFile r4 = r4.findFile(r0)
                if (r4 == 0) goto L_0x00ec
                boolean r0 = r4.exists()
                if (r0 == 0) goto L_0x00ec
            L_0x0088:
                r4.delete()
                goto L_0x00ec
            L_0x008c:
                R1.a r0 = r3.f8056b     // Catch:{ all -> 0x000f }
                r0.f8008d = r2     // Catch:{ all -> 0x000f }
                r4.printStackTrace()     // Catch:{ all -> 0x000f }
                R1.a r4 = r3.f8056b
                boolean r4 = r4.f8008d
                if (r4 == 0) goto L_0x00ec
                R1.a r4 = r3.f8056b
                java.lang.String r4 = r4.f8007c
                if (r4 == 0) goto L_0x00ec
                P1.a r4 = new P1.a
                R1.a r0 = r3.f8056b
                android.content.Context r0 = r0.f8005a
                r4.<init>(r0)
                java.lang.Object r4 = r4.c()
                if (r4 == 0) goto L_0x00ec
                boolean r0 = r4 instanceof java.io.File
                if (r0 == 0) goto L_0x00d0
                java.io.File r0 = new java.io.File
                java.io.File r4 = (java.io.File) r4
                R1.a r1 = r3.f8056b
                java.lang.String r1 = r1.f8007c
                kotlin.jvm.internal.m.b(r1)
                r0.<init>(r4, r1)
                boolean r4 = r0.exists()
                if (r4 == 0) goto L_0x00ec
                goto L_0x0068
            L_0x00d0:
                boolean r0 = r4 instanceof androidx.documentfile.provider.DocumentFile
                if (r0 == 0) goto L_0x00ec
                androidx.documentfile.provider.DocumentFile r4 = (androidx.documentfile.provider.DocumentFile) r4
                R1.a r0 = r3.f8056b
                java.lang.String r0 = r0.f8007c
                kotlin.jvm.internal.m.b(r0)
                androidx.documentfile.provider.DocumentFile r4 = r4.findFile(r0)
                if (r4 == 0) goto L_0x00ec
                boolean r0 = r4.exists()
                if (r0 == 0) goto L_0x00ec
                goto L_0x0088
            L_0x00ec:
                R2.s r4 = R2.s.f8222a
                return r4
            L_0x00ef:
                R1.a r0 = r3.f8056b
                boolean r0 = r0.f8008d
                if (r0 == 0) goto L_0x014c
                R1.a r0 = r3.f8056b
                java.lang.String r0 = r0.f8007c
                if (r0 == 0) goto L_0x014c
                P1.a r0 = new P1.a
                R1.a r1 = r3.f8056b
                android.content.Context r1 = r1.f8005a
                r0.<init>(r1)
                java.lang.Object r0 = r0.c()
                if (r0 == 0) goto L_0x014c
                boolean r1 = r0 instanceof java.io.File
                if (r1 == 0) goto L_0x012e
                java.io.File r1 = new java.io.File
                java.io.File r0 = (java.io.File) r0
                R1.a r2 = r3.f8056b
                java.lang.String r2 = r2.f8007c
                kotlin.jvm.internal.m.b(r2)
                r1.<init>(r0, r2)
                boolean r0 = r1.exists()
                if (r0 == 0) goto L_0x014c
                r1.delete()
                goto L_0x014c
            L_0x012e:
                boolean r1 = r0 instanceof androidx.documentfile.provider.DocumentFile
                if (r1 == 0) goto L_0x014c
                androidx.documentfile.provider.DocumentFile r0 = (androidx.documentfile.provider.DocumentFile) r0
                R1.a r1 = r3.f8056b
                java.lang.String r1 = r1.f8007c
                kotlin.jvm.internal.m.b(r1)
                androidx.documentfile.provider.DocumentFile r0 = r0.findFile(r1)
                if (r0 == 0) goto L_0x014c
                boolean r1 = r0.exists()
                if (r1 == 0) goto L_0x014c
                r0.delete()
            L_0x014c:
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: R1.a.k.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((k) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class l extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f8058a;

        /* renamed from: b  reason: collision with root package name */
        Object f8059b;

        /* renamed from: c  reason: collision with root package name */
        Object f8060c;

        /* renamed from: d  reason: collision with root package name */
        Object f8061d;

        /* renamed from: e  reason: collision with root package name */
        Object f8062e;

        /* renamed from: f  reason: collision with root package name */
        Object f8063f;

        /* renamed from: g  reason: collision with root package name */
        long f8064g;

        /* renamed from: h  reason: collision with root package name */
        long f8065h;

        /* renamed from: i  reason: collision with root package name */
        int f8066i;

        /* renamed from: j  reason: collision with root package name */
        int f8067j;

        /* renamed from: k  reason: collision with root package name */
        int f8068k;

        /* renamed from: l  reason: collision with root package name */
        int f8069l;

        /* renamed from: m  reason: collision with root package name */
        int f8070m;

        /* renamed from: n  reason: collision with root package name */
        /* synthetic */ Object f8071n;

        /* renamed from: o  reason: collision with root package name */
        final /* synthetic */ a f8072o;

        /* renamed from: p  reason: collision with root package name */
        int f8073p;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(a aVar, V2.d dVar) {
            super(dVar);
            this.f8072o = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f8071n = obj;
            this.f8073p |= Integer.MIN_VALUE;
            return this.f8072o.u((ArrayList) null, (ArrayList) null, (String) null, 0, this);
        }
    }

    static final class m extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8074a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f8075b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f8076c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(a aVar, String str, V2.d dVar) {
            super(2, dVar);
            this.f8075b = aVar;
            this.f8076c = str;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new m(this.f8075b, this.f8076c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f8074a == 0) {
                R2.n.b(obj);
                S1.b i4 = this.f8075b.f8006b;
                if (i4 == null) {
                    return null;
                }
                i4.e(this.f8076c);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((m) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class n extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8077a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f8078b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f8079c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(a aVar, int i4, V2.d dVar) {
            super(2, dVar);
            this.f8078b = aVar;
            this.f8079c = i4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new n(this.f8078b, this.f8079c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f8077a == 0) {
                R2.n.b(obj);
                S1.b i4 = this.f8078b.f8006b;
                if (i4 == null) {
                    return null;
                }
                i4.g(this.f8079c);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((n) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public a(Context context, S1.b bVar) {
        kotlin.jvm.internal.m.e(context, "context");
        this.f8005a = context;
        this.f8006b = bVar;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x016a, code lost:
        if (o3.C0977g.g(r2, r5, r3) == r4) goto L_0x016c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object l(T1.b r19, V2.d r20) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            r2 = r20
            boolean r3 = r2 instanceof R1.a.b
            if (r3 == 0) goto L_0x0019
            r3 = r2
            R1.a$b r3 = (R1.a.b) r3
            int r4 = r3.f8011c
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f8011c = r4
            goto L_0x001e
        L_0x0019:
            R1.a$b r3 = new R1.a$b
            r3.<init>(r1, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f8009a
            java.lang.Object r4 = W2.b.c()
            int r5 = r3.f8011c
            r6 = 5
            r7 = 4
            r8 = 3
            r9 = 2
            r10 = 1
            if (r5 == 0) goto L_0x0047
            if (r5 == r10) goto L_0x0037
            if (r5 == r9) goto L_0x0037
            if (r5 == r8) goto L_0x0037
            if (r5 == r7) goto L_0x0037
            if (r5 != r6) goto L_0x003f
        L_0x0037:
            R2.n.b(r2)     // Catch:{ Exception -> 0x003c }
            goto L_0x0170
        L_0x003c:
            r0 = move-exception
            goto L_0x016d
        L_0x003f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0047:
            R2.n.b(r2)
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x003c }
            android.content.Context r5 = r1.f8005a     // Catch:{ Exception -> 0x003c }
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch:{ Exception -> 0x003c }
            java.lang.String r11 = "context.packageManager"
            kotlin.jvm.internal.m.d(r5, r11)     // Catch:{ Exception -> 0x003c }
            java.lang.String r11 = r0.c()     // Catch:{ Exception -> 0x003c }
            r12 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r5 = W1.s.a(r5, r11, r12)     // Catch:{ Exception -> 0x003c }
            java.lang.String r5 = r5.sourceDir     // Catch:{ Exception -> 0x003c }
            r2.<init>(r5)     // Catch:{ Exception -> 0x003c }
            long r11 = r2.length()     // Catch:{ Exception -> 0x003c }
            double r11 = (double) r11     // Catch:{ Exception -> 0x003c }
            r13 = 4608083138725491507(0x3ff3333333333333, double:1.2)
            double r11 = r11 * r13
            long r11 = (long) r11     // Catch:{ Exception -> 0x003c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003c }
            r5.<init>()     // Catch:{ Exception -> 0x003c }
            java.lang.String r15 = r0.a()     // Catch:{ Exception -> 0x003c }
            r5.append(r15)     // Catch:{ Exception -> 0x003c }
            java.lang.String r15 = ".apk"
            r5.append(r15)     // Catch:{ Exception -> 0x003c }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x003c }
            r0.d(r5)     // Catch:{ Exception -> 0x003c }
            java.lang.String r5 = r0.a()     // Catch:{ Exception -> 0x003c }
            r1.f8007c = r5     // Catch:{ Exception -> 0x003c }
            P1.a r5 = new P1.a     // Catch:{ Exception -> 0x003c }
            android.content.Context r15 = r1.f8005a     // Catch:{ Exception -> 0x003c }
            r5.<init>(r15)     // Catch:{ Exception -> 0x003c }
            java.lang.Object r5 = r5.c()     // Catch:{ Exception -> 0x003c }
            if (r5 == 0) goto L_0x0170
            boolean r15 = r5 instanceof java.io.File     // Catch:{ Exception -> 0x003c }
            r16 = r13
            r13 = 0
            if (r15 == 0) goto L_0x00e8
            r6 = r5
            java.io.File r6 = (java.io.File) r6     // Catch:{ Exception -> 0x003c }
            long r6 = r6.getUsableSpace()     // Catch:{ Exception -> 0x003c }
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x003c }
            java.io.File r5 = (java.io.File) r5     // Catch:{ Exception -> 0x003c }
            java.lang.String r14 = r1.f8007c     // Catch:{ Exception -> 0x003c }
            kotlin.jvm.internal.m.b(r14)     // Catch:{ Exception -> 0x003c }
            r8.<init>(r5, r14)     // Catch:{ Exception -> 0x003c }
            int r5 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r5 <= 0) goto L_0x00d5
            boolean r0 = r8.exists()     // Catch:{ Exception -> 0x003c }
            if (r0 == 0) goto L_0x00c5
            r8.delete()     // Catch:{ Exception -> 0x003c }
        L_0x00c5:
            boolean r0 = r8.createNewFile()     // Catch:{ Exception -> 0x003c }
            if (r0 == 0) goto L_0x0170
            r3.f8011c = r10     // Catch:{ Exception -> 0x003c }
            java.lang.Object r0 = r1.n(r2, r8, r3)     // Catch:{ Exception -> 0x003c }
            if (r0 != r4) goto L_0x0170
            goto L_0x016c
        L_0x00d5:
            o3.E0 r2 = o3.Y.c()     // Catch:{ Exception -> 0x003c }
            R1.a$c r5 = new R1.a$c     // Catch:{ Exception -> 0x003c }
            r5.<init>(r1, r0, r13)     // Catch:{ Exception -> 0x003c }
            r3.f8011c = r9     // Catch:{ Exception -> 0x003c }
            java.lang.Object r0 = o3.C0977g.g(r2, r5, r3)     // Catch:{ Exception -> 0x003c }
            if (r0 != r4) goto L_0x0170
            goto L_0x016c
        L_0x00e8:
            boolean r9 = r5 instanceof androidx.documentfile.provider.DocumentFile     // Catch:{ Exception -> 0x003c }
            if (r9 == 0) goto L_0x0170
            r9 = r5
            androidx.documentfile.provider.DocumentFile r9 = (androidx.documentfile.provider.DocumentFile) r9     // Catch:{ Exception -> 0x003c }
            java.lang.String r10 = r1.f8007c     // Catch:{ Exception -> 0x003c }
            kotlin.jvm.internal.m.b(r10)     // Catch:{ Exception -> 0x003c }
            androidx.documentfile.provider.DocumentFile r9 = r9.findFile(r10)     // Catch:{ Exception -> 0x003c }
            java.lang.String r10 = ""
            if (r9 != 0) goto L_0x010b
            androidx.documentfile.provider.DocumentFile r5 = (androidx.documentfile.provider.DocumentFile) r5     // Catch:{ Exception -> 0x003c }
            java.lang.String r9 = r1.f8007c     // Catch:{ Exception -> 0x003c }
            kotlin.jvm.internal.m.b(r9)     // Catch:{ Exception -> 0x003c }
            androidx.documentfile.provider.DocumentFile r9 = r5.createFile(r10, r9)     // Catch:{ Exception -> 0x003c }
            kotlin.jvm.internal.m.b(r9)     // Catch:{ Exception -> 0x003c }
            goto L_0x0122
        L_0x010b:
            boolean r14 = r9.exists()     // Catch:{ Exception -> 0x003c }
            if (r14 == 0) goto L_0x0122
            boolean r14 = r9.delete()     // Catch:{ Exception -> 0x003c }
            if (r14 == 0) goto L_0x0122
            androidx.documentfile.provider.DocumentFile r5 = (androidx.documentfile.provider.DocumentFile) r5     // Catch:{ Exception -> 0x003c }
            java.lang.String r9 = r1.f8007c     // Catch:{ Exception -> 0x003c }
            kotlin.jvm.internal.m.b(r9)     // Catch:{ Exception -> 0x003c }
            androidx.documentfile.provider.DocumentFile r9 = r5.createFile(r10, r9)     // Catch:{ Exception -> 0x003c }
        L_0x0122:
            if (r9 == 0) goto L_0x015b
            W1.h r5 = new W1.h     // Catch:{ Exception -> 0x003c }
            r5.<init>()     // Catch:{ Exception -> 0x003c }
            android.content.Context r6 = r1.f8005a     // Catch:{ Exception -> 0x003c }
            long r5 = r5.l(r6, r9)     // Catch:{ Exception -> 0x003c }
            r14 = 0
            int r10 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r10 != 0) goto L_0x013c
            r5 = 1
            long r5 = r5 + r11
            double r5 = (double) r5     // Catch:{ Exception -> 0x003c }
            double r5 = r5 * r16
            long r5 = (long) r5     // Catch:{ Exception -> 0x003c }
        L_0x013c:
            int r10 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r10 <= 0) goto L_0x0149
            r3.f8011c = r8     // Catch:{ Exception -> 0x003c }
            java.lang.Object r0 = r1.n(r2, r9, r3)     // Catch:{ Exception -> 0x003c }
            if (r0 != r4) goto L_0x0170
            goto L_0x016c
        L_0x0149:
            o3.E0 r2 = o3.Y.c()     // Catch:{ Exception -> 0x003c }
            R1.a$d r5 = new R1.a$d     // Catch:{ Exception -> 0x003c }
            r5.<init>(r1, r0, r13)     // Catch:{ Exception -> 0x003c }
            r3.f8011c = r7     // Catch:{ Exception -> 0x003c }
            java.lang.Object r0 = o3.C0977g.g(r2, r5, r3)     // Catch:{ Exception -> 0x003c }
            if (r0 != r4) goto L_0x0170
            goto L_0x016c
        L_0x015b:
            o3.E0 r2 = o3.Y.c()     // Catch:{ Exception -> 0x003c }
            R1.a$e r5 = new R1.a$e     // Catch:{ Exception -> 0x003c }
            r5.<init>(r1, r0, r13)     // Catch:{ Exception -> 0x003c }
            r3.f8011c = r6     // Catch:{ Exception -> 0x003c }
            java.lang.Object r0 = o3.C0977g.g(r2, r5, r3)     // Catch:{ Exception -> 0x003c }
            if (r0 != r4) goto L_0x0170
        L_0x016c:
            return r4
        L_0x016d:
            r0.printStackTrace()
        L_0x0170:
            R2.s r0 = R2.s.f8222a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: R1.a.l(T1.b, V2.d):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object m(ArrayList arrayList, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new f(arrayList, this, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r20, java.lang.Object r21, V2.d r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r22
            boolean r3 = r2 instanceof R1.a.g
            if (r3 == 0) goto L_0x0019
            r3 = r2
            R1.a$g r3 = (R1.a.g) r3
            int r4 = r3.f8045l
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f8045l = r4
            goto L_0x001e
        L_0x0019:
            R1.a$g r3 = new R1.a$g
            r3.<init>(r0, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f8043j
            java.lang.Object r4 = W2.b.c()
            int r5 = r3.f8045l
            r6 = 1
            if (r5 == 0) goto L_0x0054
            if (r5 != r6) goto L_0x004c
            long r8 = r3.f8042i
            long r10 = r3.f8041h
            int r1 = r3.f8040g
            int r5 = r3.f8039f
            java.lang.Object r12 = r3.f8038e
            kotlin.jvm.internal.A r12 = (kotlin.jvm.internal.A) r12
            java.lang.Object r13 = r3.f8037d
            byte[] r13 = (byte[]) r13
            java.lang.Object r14 = r3.f8036c
            java.io.OutputStream r14 = (java.io.OutputStream) r14
            java.lang.Object r15 = r3.f8035b
            java.io.InputStream r15 = (java.io.InputStream) r15
            java.lang.Object r7 = r3.f8034a
            R1.a r7 = (R1.a) r7
            R2.n.b(r2)
            goto L_0x00be
        L_0x004c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0054:
            R2.n.b(r2)
            java.io.InputStream r2 = r19.q(r20)
            r5 = r21
            java.io.OutputStream r5 = r0.r(r5)
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]
            kotlin.jvm.internal.A r8 = new kotlin.jvm.internal.A
            r8.<init>()
            boolean r9 = r1 instanceof java.io.File
            r10 = 0
            if (r9 == 0) goto L_0x0080
            java.io.File r1 = (java.io.File) r1
            long r12 = r1.length()
        L_0x0076:
            r14 = r12
            r12 = r8
            r8 = r14
            r15 = r2
            r14 = r5
            r13 = r7
        L_0x007c:
            r1 = 0
            r5 = 0
            r7 = r0
            goto L_0x0091
        L_0x0080:
            boolean r9 = r1 instanceof androidx.documentfile.provider.DocumentFile
            if (r9 == 0) goto L_0x008b
            androidx.documentfile.provider.DocumentFile r1 = (androidx.documentfile.provider.DocumentFile) r1
            long r12 = r1.length()
            goto L_0x0076
        L_0x008b:
            r15 = r2
            r14 = r5
            r13 = r7
            r12 = r8
            r8 = r10
            goto L_0x007c
        L_0x0091:
            int r2 = r15.read(r13)
            r12.f20966a = r2
            if (r2 <= 0) goto L_0x00fd
            r20 = r7
            double r6 = (double) r5
            r16 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r6 = r6 * r16
            r16 = r3
            double r2 = (double) r8
            double r6 = r6 / r2
            int r2 = (int) r6
            int r3 = r1 + 10
            if (r2 > r3) goto L_0x00c0
            long r6 = java.lang.System.currentTimeMillis()
            r3 = 1000(0x3e8, float:1.401E-42)
            r17 = r6
            long r6 = (long) r3
            long r6 = r6 + r10
            int r3 = (r17 > r6 ? 1 : (r17 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x00ba
            if (r2 <= r1) goto L_0x00ba
            goto L_0x00c0
        L_0x00ba:
            r7 = r20
            r3 = r16
        L_0x00be:
            r0 = 1
            goto L_0x00f0
        L_0x00c0:
            long r10 = java.lang.System.currentTimeMillis()
            o3.E0 r1 = o3.Y.c()
            R1.a$h r3 = new R1.a$h
            r6 = 0
            r7 = r20
            r3.<init>(r7, r2, r6)
            r6 = r16
            r6.f8034a = r7
            r6.f8035b = r15
            r6.f8036c = r14
            r6.f8037d = r13
            r6.f8038e = r12
            r6.f8039f = r5
            r6.f8040g = r2
            r6.f8041h = r10
            r6.f8042i = r8
            r0 = 1
            r6.f8045l = r0
            java.lang.Object r1 = o3.C0977g.g(r1, r3, r6)
            if (r1 != r4) goto L_0x00ee
            return r4
        L_0x00ee:
            r1 = r2
            r3 = r6
        L_0x00f0:
            int r2 = r12.f20966a
            r6 = 0
            r14.write(r13, r6, r2)
            int r2 = r12.f20966a
            int r5 = r5 + r2
            r0 = r19
            r6 = 1
            goto L_0x0091
        L_0x00fd:
            r15.close()
            r14.close()
            R2.s r0 = R2.s.f8222a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: R1.a.n(java.lang.Object, java.lang.Object, V2.d):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object o(T1.b r24, V2.d r25) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            android.content.Context r0 = r1.f8005a
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            if (r0 == 0) goto L_0x01f7
            r3 = 0
            java.lang.String r4 = r2.c()     // Catch:{ NameNotFoundException -> 0x001e }
            r5 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r0 = W1.s.a(r0, r4, r5)     // Catch:{ NameNotFoundException -> 0x001e }
            java.lang.String r4 = r0.sourceDir     // Catch:{ NameNotFoundException -> 0x001e }
            java.lang.String[] r0 = r0.splitSourceDirs     // Catch:{ NameNotFoundException -> 0x001c }
            goto L_0x0024
        L_0x001c:
            r0 = move-exception
            goto L_0x0020
        L_0x001e:
            r0 = move-exception
            r4 = r3
        L_0x0020:
            r0.printStackTrace()
            r0 = r3
        L_0x0024:
            if (r4 == 0) goto L_0x01f7
            java.io.File r5 = new java.io.File
            r5.<init>(r4)
            long r10 = r5.length()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            r13 = r3
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r12.add(r4)
            r8 = 6
            r9 = 0
            java.lang.String r5 = "/"
            r6 = 0
            r7 = 0
            int r5 = m3.m.R(r4, r5, r6, r7, r8, r9)
            r6 = 1
            int r5 = r5 + r6
            java.lang.String r4 = r4.substring(r5)
            java.lang.String r5 = "this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.m.d(r4, r5)
            r3.add(r4)
            if (r0 == 0) goto L_0x008f
            java.util.Iterator r0 = kotlin.jvm.internal.C2098b.a(r0)
        L_0x005b:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x008f
            java.lang.Object r4 = r0.next()
            r14 = r4
            java.lang.String r14 = (java.lang.String) r14
            java.io.File r4 = new java.io.File
            r4.<init>(r14)
            long r7 = r4.length()
            long r10 = r10 + r7
            r12.add(r14)
            r18 = 6
            r19 = 0
            java.lang.String r15 = "/"
            r16 = 0
            r17 = 0
            int r4 = m3.m.R(r14, r15, r16, r17, r18, r19)
            int r4 = r4 + r6
            java.lang.String r4 = r14.substring(r4)
            kotlin.jvm.internal.m.d(r4, r5)
            r3.add(r4)
            goto L_0x005b
        L_0x008f:
            W1.E r0 = new W1.E
            r0.<init>()
            java.lang.String r4 = r2.c()
            java.util.ArrayList r0 = r0.a(r4)
            int r4 = r0.size()
            r7 = 0
            r8 = 0
        L_0x00a2:
            if (r8 >= r4) goto L_0x0102
            java.lang.Object r9 = r0.get(r8)
            int r8 = r8 + 1
            java.io.File r9 = (java.io.File) r9
            long r14 = r9.length()
            long r10 = r10 + r14
            java.lang.String r14 = r9.getAbsolutePath()
            r12.add(r14)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "Android/Obb/"
            r14.append(r15)
            java.lang.String r15 = r2.c()
            r14.append(r15)
            r15 = 47
            r14.append(r15)
            java.lang.String r15 = r9.getAbsolutePath()
            java.lang.String r13 = "obb.absolutePath"
            kotlin.jvm.internal.m.d(r15, r13)
            java.lang.String r9 = r9.getAbsolutePath()
            kotlin.jvm.internal.m.d(r9, r13)
            r21 = 6
            r22 = 0
            java.lang.String r18 = "/"
            r19 = 0
            r20 = 0
            r17 = r9
            int r9 = m3.m.R(r17, r18, r19, r20, r21, r22)
            int r9 = r9 + r6
            java.lang.String r9 = r15.substring(r9)
            kotlin.jvm.internal.m.d(r9, r5)
            r14.append(r9)
            java.lang.String r9 = r14.toString()
            r3.add(r9)
            r13 = 0
            goto L_0x00a2
        L_0x0102:
            P1.a r0 = new P1.a
            android.content.Context r4 = r1.f8005a
            r0.<init>(r4)
            java.lang.Object r0 = r0.c()
            r4 = 4608083138725491507(0x3ff3333333333333, double:1.2)
            r8 = 0
            if (r0 == 0) goto L_0x0127
            boolean r13 = r0 instanceof java.io.File
            if (r13 == 0) goto L_0x0129
            r13 = r0
            java.io.File r13 = (java.io.File) r13
            boolean r14 = r13.exists()
            if (r14 == 0) goto L_0x0129
            long r8 = r13.getUsableSpace()
        L_0x0127:
            r0 = 1
            goto L_0x014f
        L_0x0129:
            boolean r13 = r0 instanceof androidx.documentfile.provider.DocumentFile
            if (r13 == 0) goto L_0x014e
            androidx.documentfile.provider.DocumentFile r0 = (androidx.documentfile.provider.DocumentFile) r0
            boolean r13 = r0.exists()
            if (r13 == 0) goto L_0x014e
            W1.h r13 = new W1.h
            r13.<init>()
            android.content.Context r14 = r1.f8005a
            long r13 = r13.l(r14, r0)
            int r0 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r0 != 0) goto L_0x014c
            r8 = 1
            long r8 = r8 + r10
            double r8 = (double) r8
            double r8 = r8 * r4
            long r8 = (long) r8
            goto L_0x0127
        L_0x014c:
            r8 = r13
            goto L_0x0127
        L_0x014e:
            r0 = 0
        L_0x014f:
            double r10 = (double) r10
            double r10 = r10 * r4
            long r4 = (long) r10
            if (r0 == 0) goto L_0x01e6
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x01d5
            java.lang.String r0 = r23.p(r24)
            int r8 = r12.size()
            if (r8 <= r6) goto L_0x01a9
            P1.a r6 = new P1.a
            android.content.Context r7 = r1.f8005a
            r6.<init>(r7)
            java.lang.String r6 = r6.b()
            if (r6 == 0) goto L_0x0180
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r0)
            r7.append(r6)
            java.lang.String r0 = r7.toString()
            goto L_0x0191
        L_0x0180:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            java.lang.String r0 = ".xapk"
            r6.append(r0)
            java.lang.String r0 = r6.toString()
        L_0x0191:
            r2.d(r0)
            r1.f8007c = r0
            r7 = r25
            r5 = r4
            r2 = r12
            r4 = r0
            java.lang.Object r0 = r1.u(r2, r3, r4, r5, r7)
            java.lang.Object r2 = W2.b.c()
            if (r0 != r2) goto L_0x01a6
            return r0
        L_0x01a6:
            R2.s r0 = R2.s.f8222a
            return r0
        L_0x01a9:
            r3 = r25
            r0 = r12
            int r4 = r0.size()
            if (r4 != r6) goto L_0x01f7
            java.lang.Object r0 = r0.get(r7)
            java.lang.String r4 = "filesToZip[0]"
            kotlin.jvm.internal.m.d(r0, r4)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r4 = ".apk"
            r5 = 2
            r13 = 0
            boolean r0 = m3.m.o(r0, r4, r7, r5, r13)
            if (r0 == 0) goto L_0x01f7
            java.lang.Object r0 = r23.l(r24, r25)
            java.lang.Object r2 = W2.b.c()
            if (r0 != r2) goto L_0x01d2
            return r0
        L_0x01d2:
            R2.s r0 = R2.s.f8222a
            return r0
        L_0x01d5:
            r3 = r25
            o3.E0 r0 = o3.Y.c()
            R1.a$i r4 = new R1.a$i
            r13 = 0
            r4.<init>(r1, r2, r13)
            java.lang.Object r0 = o3.C0977g.g(r0, r4, r3)
            return r0
        L_0x01e6:
            r3 = r25
            r13 = 0
            o3.E0 r0 = o3.Y.c()
            R1.a$j r4 = new R1.a$j
            r4.<init>(r1, r2, r13)
            java.lang.Object r0 = o3.C0977g.g(r0, r4, r3)
            return r0
        L_0x01f7:
            R2.s r0 = R2.s.f8222a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: R1.a.o(T1.b, V2.d):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final String p(T1.b bVar) {
        String str;
        P1.a aVar = new P1.a(this.f8005a);
        if (aVar.i()) {
            str = new C1611g().m(bVar.b());
        } else {
            str = new C1611g().m(bVar.c());
        }
        if (!aVar.k()) {
            return str;
        }
        long s4 = s(bVar);
        return str + '_' + s4;
    }

    private final InputStream q(Object obj) {
        InputStream inputStream;
        if (obj instanceof File) {
            return new FileInputStream((File) obj);
        }
        if (obj instanceof DocumentFile) {
            ContentResolver contentResolver = this.f8005a.getContentResolver();
            if (contentResolver != null) {
                inputStream = contentResolver.openInputStream(((DocumentFile) obj).getUri());
            } else {
                inputStream = null;
            }
            kotlin.jvm.internal.m.b(inputStream);
            return inputStream;
        }
        throw new Exception("getInputStream: Illegal parameter type");
    }

    private final OutputStream r(Object obj) {
        OutputStream outputStream;
        if (obj instanceof File) {
            return new FileOutputStream((File) obj);
        }
        if (obj instanceof DocumentFile) {
            DocumentFile documentFile = (DocumentFile) obj;
            if (documentFile.getName() != null) {
                ContentResolver contentResolver = this.f8005a.getContentResolver();
                if (contentResolver != null) {
                    outputStream = contentResolver.openOutputStream(documentFile.getUri());
                } else {
                    outputStream = null;
                }
                kotlin.jvm.internal.m.b(outputStream);
                return outputStream;
            }
            throw new Exception("getOutputStream: DocumentFile name is null");
        }
        throw new Exception("getOutputStream: Illegal parameter type");
    }

    private final long s(T1.b bVar) {
        PackageInfo packageInfo;
        try {
            PackageManager packageManager = this.f8005a.getPackageManager();
            kotlin.jvm.internal.m.d(packageManager, "context.packageManager");
            packageInfo = W1.s.d(packageManager, bVar.c(), 0);
        } catch (Exception e5) {
            e5.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            return new C1612h().m(packageInfo);
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0156 A[Catch:{ Exception -> 0x006f }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0193 A[Catch:{ Exception -> 0x006f }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01a6 A[Catch:{ Exception -> 0x006f }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0207 A[Catch:{ Exception -> 0x006f }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0228 A[Catch:{ Exception -> 0x006f }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object u(java.util.ArrayList r23, java.util.ArrayList r24, java.lang.String r25, long r26, V2.d r28) {
        /*
            r22 = this;
            r1 = r22
            r0 = r23
            r2 = r24
            r3 = r25
            r4 = r28
            boolean r5 = r4 instanceof R1.a.l
            if (r5 == 0) goto L_0x001d
            r5 = r4
            R1.a$l r5 = (R1.a.l) r5
            int r6 = r5.f8073p
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r8 = r6 & r7
            if (r8 == 0) goto L_0x001d
            int r6 = r6 - r7
            r5.f8073p = r6
            goto L_0x0022
        L_0x001d:
            R1.a$l r5 = new R1.a$l
            r5.<init>(r1, r4)
        L_0x0022:
            java.lang.Object r4 = r5.f8071n
            java.lang.Object r6 = W2.b.c()
            int r7 = r5.f8073p
            r8 = 2
            r10 = 1
            if (r7 == 0) goto L_0x009d
            if (r7 == r10) goto L_0x007a
            if (r7 != r8) goto L_0x0072
            int r0 = r5.f8070m
            int r2 = r5.f8069l
            long r12 = r5.f8065h
            int r3 = r5.f8068k
            int r7 = r5.f8067j
            int r10 = r5.f8066i
            long r14 = r5.f8064g
            java.lang.Object r8 = r5.f8063f
            java.io.BufferedInputStream r8 = (java.io.BufferedInputStream) r8
            java.lang.Object r11 = r5.f8062e
            byte[] r11 = (byte[]) r11
            java.lang.Object r9 = r5.f8061d
            java.util.zip.ZipOutputStream r9 = (java.util.zip.ZipOutputStream) r9
            r23 = r0
            java.lang.Object r0 = r5.f8060c
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            r24 = r0
            java.lang.Object r0 = r5.f8059b
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            r25 = r0
            java.lang.Object r0 = r5.f8058a
            R1.a r0 = (R1.a) r0
            R2.n.b(r4)     // Catch:{ Exception -> 0x006f }
            r17 = r24
            r18 = r14
            r15 = r9
            r14 = r11
            r11 = r6
            r9 = r7
            r7 = r23
            r6 = r25
            goto L_0x020f
        L_0x006f:
            r0 = move-exception
            goto L_0x0257
        L_0x0072:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x007a:
            long r2 = r5.f8065h
            int r0 = r5.f8068k
            int r7 = r5.f8067j
            int r8 = r5.f8066i
            long r9 = r5.f8064g
            java.lang.Object r11 = r5.f8062e
            byte[] r11 = (byte[]) r11
            java.lang.Object r12 = r5.f8061d
            java.util.zip.ZipOutputStream r12 = (java.util.zip.ZipOutputStream) r12
            java.lang.Object r13 = r5.f8060c
            java.util.ArrayList r13 = (java.util.ArrayList) r13
            java.lang.Object r14 = r5.f8059b
            java.util.ArrayList r14 = (java.util.ArrayList) r14
            java.lang.Object r15 = r5.f8058a
            R1.a r15 = (R1.a) r15
            R2.n.b(r4)     // Catch:{ Exception -> 0x006f }
            goto L_0x014d
        L_0x009d:
            R2.n.b(r4)
            if (r0 == 0) goto L_0x025a
            if (r2 == 0) goto L_0x025a
            int r4 = r0.size()     // Catch:{ Exception -> 0x006f }
            int r7 = r2.size()     // Catch:{ Exception -> 0x006f }
            if (r4 != r7) goto L_0x025a
            P1.a r4 = new P1.a     // Catch:{ Exception -> 0x006f }
            android.content.Context r7 = r1.f8005a     // Catch:{ Exception -> 0x006f }
            r4.<init>(r7)     // Catch:{ Exception -> 0x006f }
            java.lang.Object r4 = r4.c()     // Catch:{ Exception -> 0x006f }
            boolean r7 = r4 instanceof java.io.File     // Catch:{ Exception -> 0x006f }
            if (r7 == 0) goto L_0x00e8
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x006f }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006f }
            r8.<init>()     // Catch:{ Exception -> 0x006f }
            java.io.File r4 = (java.io.File) r4     // Catch:{ Exception -> 0x006f }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ Exception -> 0x006f }
            r8.append(r4)     // Catch:{ Exception -> 0x006f }
            r4 = 47
            r8.append(r4)     // Catch:{ Exception -> 0x006f }
            r8.append(r3)     // Catch:{ Exception -> 0x006f }
            java.lang.String r4 = r8.toString()     // Catch:{ Exception -> 0x006f }
            r7.<init>(r4)     // Catch:{ Exception -> 0x006f }
            java.util.zip.ZipOutputStream r4 = new java.util.zip.ZipOutputStream     // Catch:{ Exception -> 0x006f }
            java.io.BufferedOutputStream r8 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x006f }
            r8.<init>(r7)     // Catch:{ Exception -> 0x006f }
            r4.<init>(r8)     // Catch:{ Exception -> 0x006f }
            r12 = r4
            goto L_0x010f
        L_0x00e8:
            boolean r7 = r4 instanceof androidx.documentfile.provider.DocumentFile     // Catch:{ Exception -> 0x006f }
            if (r7 == 0) goto L_0x010e
            androidx.documentfile.provider.DocumentFile r4 = (androidx.documentfile.provider.DocumentFile) r4     // Catch:{ Exception -> 0x006f }
            java.lang.String r7 = ""
            androidx.documentfile.provider.DocumentFile r4 = r4.createFile(r7, r3)     // Catch:{ Exception -> 0x006f }
            if (r4 == 0) goto L_0x0106
            java.io.OutputStream r4 = r1.r(r4)     // Catch:{ Exception -> 0x006f }
            java.util.zip.ZipOutputStream r7 = new java.util.zip.ZipOutputStream     // Catch:{ Exception -> 0x006f }
            java.io.BufferedOutputStream r8 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x006f }
            r8.<init>(r4)     // Catch:{ Exception -> 0x006f }
            r7.<init>(r8)     // Catch:{ Exception -> 0x006f }
            r12 = r7
            goto L_0x010f
        L_0x0106:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x006f }
            java.lang.String r2 = "zipSuspend createFile return null"
            r0.<init>(r2)     // Catch:{ Exception -> 0x006f }
            throw r0     // Catch:{ Exception -> 0x006f }
        L_0x010e:
            r12 = 0
        L_0x010f:
            if (r12 == 0) goto L_0x024f
            r7 = 8192(0x2000, float:1.14794E-41)
            byte[] r11 = new byte[r7]     // Catch:{ Exception -> 0x006f }
            o3.E0 r4 = o3.Y.c()     // Catch:{ Exception -> 0x006f }
            R1.a$m r8 = new R1.a$m     // Catch:{ Exception -> 0x006f }
            r9 = 0
            r8.<init>(r1, r3, r9)     // Catch:{ Exception -> 0x006f }
            r5.f8058a = r1     // Catch:{ Exception -> 0x006f }
            r5.f8059b = r0     // Catch:{ Exception -> 0x006f }
            r5.f8060c = r2     // Catch:{ Exception -> 0x006f }
            r5.f8061d = r12     // Catch:{ Exception -> 0x006f }
            r5.f8062e = r11     // Catch:{ Exception -> 0x006f }
            r13 = r26
            r5.f8064g = r13     // Catch:{ Exception -> 0x006f }
            r3 = 0
            r5.f8066i = r3     // Catch:{ Exception -> 0x006f }
            r5.f8067j = r7     // Catch:{ Exception -> 0x006f }
            r5.f8068k = r3     // Catch:{ Exception -> 0x006f }
            r9 = r8
            r7 = 0
            r5.f8065h = r7     // Catch:{ Exception -> 0x006f }
            r5.f8073p = r10     // Catch:{ Exception -> 0x006f }
            java.lang.Object r4 = o3.C0977g.g(r4, r9, r5)     // Catch:{ Exception -> 0x006f }
            if (r4 != r6) goto L_0x0144
            r11 = r6
            goto L_0x0206
        L_0x0144:
            r15 = r1
            r9 = r13
            r14 = r0
            r13 = r2
            r2 = r7
            r0 = 0
            r7 = 8192(0x2000, float:1.14794E-41)
            r8 = 0
        L_0x014d:
            int r4 = r14.size()     // Catch:{ Exception -> 0x006f }
            r23 = r0
            r0 = 0
        L_0x0154:
            if (r0 >= r4) goto L_0x024b
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x006f }
            java.lang.Object r16 = r14.get(r0)     // Catch:{ Exception -> 0x006f }
            r24 = r2
            r2 = r16
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x006f }
            r1.<init>(r2)     // Catch:{ Exception -> 0x006f }
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x006f }
            r2.<init>(r1, r7)     // Catch:{ Exception -> 0x006f }
            java.util.zip.ZipEntry r1 = new java.util.zip.ZipEntry     // Catch:{ Exception -> 0x006f }
            java.lang.Object r3 = r13.get(r0)     // Catch:{ Exception -> 0x006f }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x006f }
            r1.<init>(r3)     // Catch:{ Exception -> 0x006f }
            r12.putNextEntry(r1)     // Catch:{ Exception -> 0x006f }
            r3 = 0
            int r1 = r2.read(r11, r3, r7)     // Catch:{ Exception -> 0x006f }
            r17 = r13
            r18 = r14
            r19 = r15
            r14 = r11
            r15 = r12
            r11 = r8
            r12 = r9
            r10 = r2
            r8 = r5
            r9 = r7
            r2 = r0
            r7 = r4
            r0 = r23
            r23 = r24
        L_0x0190:
            r4 = -1
            if (r1 == r4) goto L_0x0228
            r15.write(r14, r3, r1)     // Catch:{ Exception -> 0x006f }
            int r1 = r1 + r11
            double r3 = (double) r1     // Catch:{ Exception -> 0x006f }
            r20 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r3 = r3 * r20
            r25 = r3
            double r3 = (double) r12     // Catch:{ Exception -> 0x006f }
            double r3 = r25 / r3
            int r3 = (int) r3     // Catch:{ Exception -> 0x006f }
            int r4 = r0 + 10
            if (r3 > r4) goto L_0x01c3
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x006f }
            r11 = 1000(0x3e8, float:1.401E-42)
            r25 = r4
            long r4 = (long) r11     // Catch:{ Exception -> 0x006f }
            long r4 = r23 + r4
            int r11 = (r25 > r4 ? 1 : (r25 == r4 ? 0 : -1))
            if (r11 <= 0) goto L_0x01b8
            if (r3 <= r0) goto L_0x01b8
            goto L_0x01c3
        L_0x01b8:
            r11 = r6
            r6 = r18
            r3 = r19
            r18 = r12
            r12 = r23
        L_0x01c1:
            r4 = 0
            goto L_0x0216
        L_0x01c3:
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x006f }
            o3.E0 r0 = o3.Y.c()     // Catch:{ Exception -> 0x006f }
            R1.a$n r11 = new R1.a$n     // Catch:{ Exception -> 0x006f }
            r23 = r0
            r16 = r6
            r0 = r19
            r6 = 0
            r11.<init>(r0, r3, r6)     // Catch:{ Exception -> 0x006f }
            r8.f8058a = r0     // Catch:{ Exception -> 0x006f }
            r6 = r18
            r8.f8059b = r6     // Catch:{ Exception -> 0x006f }
            r18 = r0
            r0 = r17
            r8.f8060c = r0     // Catch:{ Exception -> 0x006f }
            r8.f8061d = r15     // Catch:{ Exception -> 0x006f }
            r8.f8062e = r14     // Catch:{ Exception -> 0x006f }
            r8.f8063f = r10     // Catch:{ Exception -> 0x006f }
            r8.f8064g = r12     // Catch:{ Exception -> 0x006f }
            r8.f8066i = r1     // Catch:{ Exception -> 0x006f }
            r8.f8067j = r9     // Catch:{ Exception -> 0x006f }
            r8.f8068k = r3     // Catch:{ Exception -> 0x006f }
            r8.f8065h = r4     // Catch:{ Exception -> 0x006f }
            r8.f8069l = r2     // Catch:{ Exception -> 0x006f }
            r8.f8070m = r7     // Catch:{ Exception -> 0x006f }
            r17 = r0
            r0 = 2
            r8.f8073p = r0     // Catch:{ Exception -> 0x006f }
            r0 = r23
            java.lang.Object r0 = o3.C0977g.g(r0, r11, r8)     // Catch:{ Exception -> 0x006f }
            r11 = r16
            if (r0 != r11) goto L_0x0207
        L_0x0206:
            return r11
        L_0x0207:
            r0 = r18
            r18 = r12
            r12 = r4
            r5 = r8
            r8 = r10
            r10 = r1
        L_0x020f:
            r1 = r3
            r3 = r0
            r0 = r1
            r1 = r10
            r10 = r8
            r8 = r5
            goto L_0x01c1
        L_0x0216:
            int r5 = r10.read(r14, r4, r9)     // Catch:{ Exception -> 0x006f }
            r23 = r12
            r12 = r18
            r19 = r3
            r18 = r6
            r6 = r11
            r3 = 0
            r11 = r1
            r1 = r5
            goto L_0x0190
        L_0x0228:
            r16 = r6
            r6 = r18
            r18 = r19
            r4 = 0
            r10.close()     // Catch:{ Exception -> 0x006f }
            int r1 = r2 + 1
            r2 = r23
            r23 = r0
            r0 = r1
            r4 = r7
            r5 = r8
            r7 = r9
            r8 = r11
            r9 = r12
            r11 = r14
            r12 = r15
            r13 = r17
            r15 = r18
            r1 = r22
            r14 = r6
            r6 = r16
            goto L_0x0154
        L_0x024b:
            r12.close()     // Catch:{ Exception -> 0x006f }
            goto L_0x025a
        L_0x024f:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x006f }
            java.lang.String r1 = "zipSuspend ZipOutputStream is null"
            r0.<init>(r1)     // Catch:{ Exception -> 0x006f }
            throw r0     // Catch:{ Exception -> 0x006f }
        L_0x0257:
            r0.printStackTrace()
        L_0x025a:
            R2.s r0 = R2.s.f8222a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: R1.a.u(java.util.ArrayList, java.util.ArrayList, java.lang.String, long, V2.d):java.lang.Object");
    }

    public final C1001s0 t(ArrayList arrayList) {
        kotlin.jvm.internal.m.e(arrayList, "appsToBackup");
        return C0981i.d(K.a(Y.b()), (V2.g) null, (L) null, new k(this, arrayList, (V2.d) null), 3, (Object) null);
    }
}
