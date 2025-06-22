package R1;

import R2.n;
import R2.s;
import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import d3.p;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import kotlin.jvm.internal.C;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.L;
import o3.Y;

public final class b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f8080a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f8081b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final S1.d f8082c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final boolean f8083d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Context f8084e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f8085f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public long f8086g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f8087h;

    static final class a extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8088a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f8089b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(b bVar, V2.d dVar) {
            super(2, dVar);
            this.f8089b = bVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new a(this.f8089b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f8088a;
            if (i4 == 0) {
                n.b(obj);
                b bVar = this.f8089b;
                this.f8088a = 1;
                if (bVar.q(this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: R1.b$b  reason: collision with other inner class name */
    static final class C0100b extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f8090a;

        /* renamed from: b  reason: collision with root package name */
        Object f8091b;

        /* renamed from: c  reason: collision with root package name */
        Object f8092c;

        /* renamed from: d  reason: collision with root package name */
        Object f8093d;

        /* renamed from: e  reason: collision with root package name */
        int f8094e;

        /* renamed from: f  reason: collision with root package name */
        int f8095f;

        /* renamed from: g  reason: collision with root package name */
        /* synthetic */ Object f8096g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ b f8097h;

        /* renamed from: i  reason: collision with root package name */
        int f8098i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0100b(b bVar, V2.d dVar) {
            super(dVar);
            this.f8097h = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f8096g = obj;
            this.f8098i |= Integer.MIN_VALUE;
            return this.f8097h.p((DocumentFile) null, (DocumentFile) null, this);
        }
    }

    static final class c extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f8099a;

        /* renamed from: b  reason: collision with root package name */
        Object f8100b;

        /* renamed from: c  reason: collision with root package name */
        Object f8101c;

        /* renamed from: d  reason: collision with root package name */
        int f8102d;

        /* renamed from: e  reason: collision with root package name */
        int f8103e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ b f8104f;

        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8105a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f8106b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ b f8107c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ Object f8108d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(int i4, b bVar, Object obj, V2.d dVar) {
                super(2, dVar);
                this.f8106b = i4;
                this.f8107c = bVar;
                this.f8108d = obj;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f8106b, this.f8107c, this.f8108d, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8105a == 0) {
                    n.b(obj);
                    int i4 = this.f8106b + 1;
                    S1.d i5 = this.f8107c.f8082c;
                    if (i5 == null) {
                        return null;
                    }
                    i5.b(this.f8108d, i4, this.f8107c.f8080a.size(), this.f8107c.f8086g);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: R1.b$c$b  reason: collision with other inner class name */
        static final class C0101b extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8109a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ File f8110b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ b f8111c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0101b(File file, b bVar, V2.d dVar) {
                super(2, dVar);
                this.f8110b = file;
                this.f8111c = bVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0101b(this.f8110b, this.f8111c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                S1.d i4;
                W2.b.c();
                if (this.f8109a == 0) {
                    n.b(obj);
                    if (!(this.f8110b == null || (i4 = this.f8111c.f8082c) == null)) {
                        i4.h(this.f8110b);
                    }
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((C0101b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: R1.b$c$c  reason: collision with other inner class name */
        static final class C0102c extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8112a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ DocumentFile f8113b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ b f8114c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0102c(DocumentFile documentFile, b bVar, V2.d dVar) {
                super(2, dVar);
                this.f8113b = documentFile;
                this.f8114c = bVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0102c(this.f8113b, this.f8114c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                S1.d i4;
                W2.b.c();
                if (this.f8112a == 0) {
                    n.b(obj);
                    if (!(this.f8113b == null || (i4 = this.f8114c.f8082c) == null)) {
                        i4.h(this.f8113b);
                    }
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((C0102c) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class d extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8115a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ DocumentFile f8116b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ b f8117c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(DocumentFile documentFile, b bVar, V2.d dVar) {
                super(2, dVar);
                this.f8116b = documentFile;
                this.f8117c = bVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new d(this.f8116b, this.f8117c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                S1.d i4;
                W2.b.c();
                if (this.f8115a == 0) {
                    n.b(obj);
                    if (!(this.f8116b == null || (i4 = this.f8117c.f8082c) == null)) {
                        i4.h(this.f8116b);
                    }
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
            int f8118a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ b f8119b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(b bVar, V2.d dVar) {
                super(2, dVar);
                this.f8119b = bVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new e(this.f8119b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8118a == 0) {
                    n.b(obj);
                    S1.d i4 = this.f8119b.f8082c;
                    if (i4 == null) {
                        return null;
                    }
                    i4.i();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar, V2.d dVar) {
            super(2, dVar);
            this.f8104f = bVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f8104f, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0052, code lost:
            r5 = r4;
            r4 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0072, code lost:
            r5 = r4;
            r4 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0095, code lost:
            if (r4.hasNext() == false) goto L_0x020f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0097, code lost:
            r11 = r1 + 1;
            r3 = r4.next();
            r5 = o3.Y.c();
            r6 = new R1.b.c.a(r1, r10.f8104f, r3, (V2.d) null);
            r10.f8099a = r4;
            r10.f8100b = r3;
            r10.f8101c = null;
            r10.f8102d = r11;
            r10.f8103e = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00b7, code lost:
            if (o3.C0977g.g(r5, r6, r10) != r0) goto L_0x00bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00bb, code lost:
            r1 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00be, code lost:
            if ((r3 instanceof java.io.File) == false) goto L_0x0188;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c8, code lost:
            if ((R1.b.j(r10.f8104f) instanceof java.io.File) == false) goto L_0x0125;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ca, code lost:
            r11 = r10.f8104f;
            r10.f8099a = r4;
            r10.f8100b = r3;
            r10.f8102d = r1;
            r10.f8103e = 2;
            r11 = R1.b.e(r11, (java.io.File) r3, (java.io.File) R1.b.j(r11), r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00e2, code lost:
            if (r11 != r0) goto L_0x0072;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00e6, code lost:
            r3 = (java.io.File) r11;
            r11 = o3.Y.c();
            r6 = new R1.b.c.C0101b(r3, r10.f8104f, (V2.d) null);
            r10.f8099a = r5;
            r10.f8100b = r4;
            r10.f8101c = r3;
            r10.f8102d = r1;
            r10.f8103e = 3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0103, code lost:
            if (o3.C0977g.g(r11, r6, r10) != r0) goto L_0x0107;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x010d, code lost:
            if (R1.b.g(r10.f8104f) == false) goto L_0x0122;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x010f, code lost:
            if (r3 == null) goto L_0x0122;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0111, code lost:
            r4 = (java.io.File) r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x011d, code lost:
            if (r3.length() != r4.length()) goto L_0x0122;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x011f, code lost:
            r4.delete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0122, code lost:
            r4 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x012d, code lost:
            if ((R1.b.j(r10.f8104f) instanceof androidx.documentfile.provider.DocumentFile) == false) goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x012f, code lost:
            r11 = r10.f8104f;
            r10.f8099a = r4;
            r10.f8100b = r3;
            r10.f8102d = r1;
            r10.f8103e = 4;
            r11 = R1.b.d(r11, (java.io.File) r3, (androidx.documentfile.provider.DocumentFile) R1.b.j(r11), r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0147, code lost:
            if (r11 != r0) goto L_0x0052;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x014b, code lost:
            r3 = (androidx.documentfile.provider.DocumentFile) r11;
            r11 = o3.Y.c();
            r6 = new R1.b.c.C0102c(r3, r10.f8104f, (V2.d) null);
            r10.f8099a = r5;
            r10.f8100b = r4;
            r10.f8101c = r3;
            r10.f8102d = r1;
            r10.f8103e = 5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0168, code lost:
            if (o3.C0977g.g(r11, r6, r10) != r0) goto L_0x016c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0172, code lost:
            if (R1.b.g(r10.f8104f) == false) goto L_0x0122;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0174, code lost:
            if (r3 == null) goto L_0x0122;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0176, code lost:
            r4 = (java.io.File) r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0182, code lost:
            if (r3.length() != r4.length()) goto L_0x0122;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0184, code lost:
            r4.delete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x018a, code lost:
            if ((r3 instanceof androidx.documentfile.provider.DocumentFile) == false) goto L_0x0207;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0194, code lost:
            if ((R1.b.j(r10.f8104f) instanceof java.io.File) == false) goto L_0x01a8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0196, code lost:
            r11 = androidx.documentfile.provider.DocumentFile.fromFile((java.io.File) R1.b.j(r10.f8104f));
            kotlin.jvm.internal.m.d(r11, "fromFile(targetDir)");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x01a8, code lost:
            r11 = R1.b.j(r10.f8104f);
            kotlin.jvm.internal.m.c(r11, "null cannot be cast to non-null type androidx.documentfile.provider.DocumentFile");
            r11 = (androidx.documentfile.provider.DocumentFile) r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x01b5, code lost:
            r10.f8099a = r4;
            r10.f8100b = r3;
            r10.f8102d = r1;
            r10.f8103e = 6;
            r11 = R1.b.a(r10.f8104f, (androidx.documentfile.provider.DocumentFile) r3, r11, r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x01c7, code lost:
            if (r11 != r0) goto L_0x0032;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x01ca, code lost:
            r3 = (androidx.documentfile.provider.DocumentFile) r11;
            r11 = o3.Y.c();
            r6 = new R1.b.c.d(r3, r10.f8104f, (V2.d) null);
            r10.f8099a = r5;
            r10.f8100b = r4;
            r10.f8101c = r3;
            r10.f8102d = r1;
            r10.f8103e = 7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x01e7, code lost:
            if (o3.C0977g.g(r11, r6, r10) != r0) goto L_0x01ea;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x01f0, code lost:
            if (R1.b.g(r10.f8104f) == false) goto L_0x0122;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x01f2, code lost:
            if (r3 == null) goto L_0x0122;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x01f4, code lost:
            r4 = (androidx.documentfile.provider.DocumentFile) r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x0200, code lost:
            if (r3.length() != r4.length()) goto L_0x0122;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0202, code lost:
            r4.delete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x020e, code lost:
            throw new java.lang.Exception("Unsupported data type");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x020f, code lost:
            r11 = o3.Y.c();
            r1 = new R1.b.c.e(r10.f8104f, (V2.d) null);
            r10.f8099a = null;
            r10.f8100b = null;
            r10.f8101c = null;
            r10.f8103e = 8;
            r11 = o3.C0977g.g(r11, r1, r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x0228, code lost:
            if (r11 != r0) goto L_0x022b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x022a, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x022b, code lost:
            return r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0032, code lost:
            r5 = r4;
            r4 = r3;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r10.f8103e
                r2 = 0
                switch(r1) {
                    case 0: goto L_0x0082;
                    case 1: goto L_0x0076;
                    case 2: goto L_0x0067;
                    case 3: goto L_0x0056;
                    case 4: goto L_0x0047;
                    case 5: goto L_0x0036;
                    case 6: goto L_0x0027;
                    case 7: goto L_0x0016;
                    case 8: goto L_0x0012;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L_0x0012:
                R2.n.b(r11)
                return r11
            L_0x0016:
                int r1 = r10.f8102d
                java.lang.Object r3 = r10.f8101c
                androidx.documentfile.provider.DocumentFile r3 = (androidx.documentfile.provider.DocumentFile) r3
                java.lang.Object r4 = r10.f8100b
                java.lang.Object r5 = r10.f8099a
                java.util.Iterator r5 = (java.util.Iterator) r5
                R2.n.b(r11)
                goto L_0x01ea
            L_0x0027:
                int r1 = r10.f8102d
                java.lang.Object r3 = r10.f8100b
                java.lang.Object r4 = r10.f8099a
                java.util.Iterator r4 = (java.util.Iterator) r4
                R2.n.b(r11)
            L_0x0032:
                r5 = r4
                r4 = r3
                goto L_0x01ca
            L_0x0036:
                int r1 = r10.f8102d
                java.lang.Object r3 = r10.f8101c
                androidx.documentfile.provider.DocumentFile r3 = (androidx.documentfile.provider.DocumentFile) r3
                java.lang.Object r4 = r10.f8100b
                java.lang.Object r5 = r10.f8099a
                java.util.Iterator r5 = (java.util.Iterator) r5
                R2.n.b(r11)
                goto L_0x016c
            L_0x0047:
                int r1 = r10.f8102d
                java.lang.Object r3 = r10.f8100b
                java.lang.Object r4 = r10.f8099a
                java.util.Iterator r4 = (java.util.Iterator) r4
                R2.n.b(r11)
            L_0x0052:
                r5 = r4
                r4 = r3
                goto L_0x014b
            L_0x0056:
                int r1 = r10.f8102d
                java.lang.Object r3 = r10.f8101c
                java.io.File r3 = (java.io.File) r3
                java.lang.Object r4 = r10.f8100b
                java.lang.Object r5 = r10.f8099a
                java.util.Iterator r5 = (java.util.Iterator) r5
                R2.n.b(r11)
                goto L_0x0107
            L_0x0067:
                int r1 = r10.f8102d
                java.lang.Object r3 = r10.f8100b
                java.lang.Object r4 = r10.f8099a
                java.util.Iterator r4 = (java.util.Iterator) r4
                R2.n.b(r11)
            L_0x0072:
                r5 = r4
                r4 = r3
                goto L_0x00e6
            L_0x0076:
                int r1 = r10.f8102d
                java.lang.Object r3 = r10.f8100b
                java.lang.Object r4 = r10.f8099a
                java.util.Iterator r4 = (java.util.Iterator) r4
                R2.n.b(r11)
                goto L_0x00bc
            L_0x0082:
                R2.n.b(r11)
                R1.b r11 = r10.f8104f
                java.util.ArrayList r11 = r11.f8080a
                java.util.Iterator r11 = r11.iterator()
                r1 = 0
                r4 = r11
            L_0x0091:
                boolean r11 = r4.hasNext()
                if (r11 == 0) goto L_0x020f
                int r11 = r1 + 1
                java.lang.Object r3 = r4.next()
                o3.E0 r5 = o3.Y.c()
                R1.b$c$a r6 = new R1.b$c$a
                R1.b r7 = r10.f8104f
                r6.<init>(r1, r7, r3, r2)
                r10.f8099a = r4
                r10.f8100b = r3
                r10.f8101c = r2
                r10.f8102d = r11
                r1 = 1
                r10.f8103e = r1
                java.lang.Object r1 = o3.C0977g.g(r5, r6, r10)
                if (r1 != r0) goto L_0x00bb
                goto L_0x022a
            L_0x00bb:
                r1 = r11
            L_0x00bc:
                boolean r11 = r3 instanceof java.io.File
                if (r11 == 0) goto L_0x0188
                R1.b r11 = r10.f8104f
                java.lang.Object r11 = r11.f8081b
                boolean r11 = r11 instanceof java.io.File
                if (r11 == 0) goto L_0x0125
                R1.b r11 = r10.f8104f
                r5 = r3
                java.io.File r5 = (java.io.File) r5
                java.lang.Object r6 = r11.f8081b
                java.io.File r6 = (java.io.File) r6
                r10.f8099a = r4
                r10.f8100b = r3
                r10.f8102d = r1
                r7 = 2
                r10.f8103e = r7
                java.lang.Object r11 = r11.t(r5, r6, r10)
                if (r11 != r0) goto L_0x0072
                goto L_0x022a
            L_0x00e6:
                r3 = r11
                java.io.File r3 = (java.io.File) r3
                o3.E0 r11 = o3.Y.c()
                R1.b$c$b r6 = new R1.b$c$b
                R1.b r7 = r10.f8104f
                r6.<init>(r3, r7, r2)
                r10.f8099a = r5
                r10.f8100b = r4
                r10.f8101c = r3
                r10.f8102d = r1
                r7 = 3
                r10.f8103e = r7
                java.lang.Object r11 = o3.C0977g.g(r11, r6, r10)
                if (r11 != r0) goto L_0x0107
                goto L_0x022a
            L_0x0107:
                R1.b r11 = r10.f8104f
                boolean r11 = r11.f8083d
                if (r11 == 0) goto L_0x0122
                if (r3 == 0) goto L_0x0122
                long r6 = r3.length()
                java.io.File r4 = (java.io.File) r4
                long r8 = r4.length()
                int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r11 != 0) goto L_0x0122
                r4.delete()
            L_0x0122:
                r4 = r5
                goto L_0x0091
            L_0x0125:
                R1.b r11 = r10.f8104f
                java.lang.Object r11 = r11.f8081b
                boolean r11 = r11 instanceof androidx.documentfile.provider.DocumentFile
                if (r11 == 0) goto L_0x0091
                R1.b r11 = r10.f8104f
                r5 = r3
                java.io.File r5 = (java.io.File) r5
                java.lang.Object r6 = r11.f8081b
                androidx.documentfile.provider.DocumentFile r6 = (androidx.documentfile.provider.DocumentFile) r6
                r10.f8099a = r4
                r10.f8100b = r3
                r10.f8102d = r1
                r7 = 4
                r10.f8103e = r7
                java.lang.Object r11 = r11.s(r5, r6, r10)
                if (r11 != r0) goto L_0x0052
                goto L_0x022a
            L_0x014b:
                r3 = r11
                androidx.documentfile.provider.DocumentFile r3 = (androidx.documentfile.provider.DocumentFile) r3
                o3.E0 r11 = o3.Y.c()
                R1.b$c$c r6 = new R1.b$c$c
                R1.b r7 = r10.f8104f
                r6.<init>(r3, r7, r2)
                r10.f8099a = r5
                r10.f8100b = r4
                r10.f8101c = r3
                r10.f8102d = r1
                r7 = 5
                r10.f8103e = r7
                java.lang.Object r11 = o3.C0977g.g(r11, r6, r10)
                if (r11 != r0) goto L_0x016c
                goto L_0x022a
            L_0x016c:
                R1.b r11 = r10.f8104f
                boolean r11 = r11.f8083d
                if (r11 == 0) goto L_0x0122
                if (r3 == 0) goto L_0x0122
                long r6 = r3.length()
                java.io.File r4 = (java.io.File) r4
                long r8 = r4.length()
                int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r11 != 0) goto L_0x0122
                r4.delete()
                goto L_0x0122
            L_0x0188:
                boolean r11 = r3 instanceof androidx.documentfile.provider.DocumentFile
                if (r11 == 0) goto L_0x0207
                R1.b r11 = r10.f8104f
                java.lang.Object r11 = r11.f8081b
                boolean r11 = r11 instanceof java.io.File
                if (r11 == 0) goto L_0x01a8
                R1.b r11 = r10.f8104f
                java.lang.Object r11 = r11.f8081b
                java.io.File r11 = (java.io.File) r11
                androidx.documentfile.provider.DocumentFile r11 = androidx.documentfile.provider.DocumentFile.fromFile(r11)
                java.lang.String r5 = "fromFile(targetDir)"
                kotlin.jvm.internal.m.d(r11, r5)
                goto L_0x01b5
            L_0x01a8:
                R1.b r11 = r10.f8104f
                java.lang.Object r11 = r11.f8081b
                java.lang.String r5 = "null cannot be cast to non-null type androidx.documentfile.provider.DocumentFile"
                kotlin.jvm.internal.m.c(r11, r5)
                androidx.documentfile.provider.DocumentFile r11 = (androidx.documentfile.provider.DocumentFile) r11
            L_0x01b5:
                R1.b r5 = r10.f8104f
                r6 = r3
                androidx.documentfile.provider.DocumentFile r6 = (androidx.documentfile.provider.DocumentFile) r6
                r10.f8099a = r4
                r10.f8100b = r3
                r10.f8102d = r1
                r7 = 6
                r10.f8103e = r7
                java.lang.Object r11 = r5.p(r6, r11, r10)
                if (r11 != r0) goto L_0x0032
                goto L_0x022a
            L_0x01ca:
                r3 = r11
                androidx.documentfile.provider.DocumentFile r3 = (androidx.documentfile.provider.DocumentFile) r3
                o3.E0 r11 = o3.Y.c()
                R1.b$c$d r6 = new R1.b$c$d
                R1.b r7 = r10.f8104f
                r6.<init>(r3, r7, r2)
                r10.f8099a = r5
                r10.f8100b = r4
                r10.f8101c = r3
                r10.f8102d = r1
                r7 = 7
                r10.f8103e = r7
                java.lang.Object r11 = o3.C0977g.g(r11, r6, r10)
                if (r11 != r0) goto L_0x01ea
                goto L_0x022a
            L_0x01ea:
                R1.b r11 = r10.f8104f
                boolean r11 = r11.f8083d
                if (r11 == 0) goto L_0x0122
                if (r3 == 0) goto L_0x0122
                long r6 = r3.length()
                androidx.documentfile.provider.DocumentFile r4 = (androidx.documentfile.provider.DocumentFile) r4
                long r8 = r4.length()
                int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r11 != 0) goto L_0x0122
                r4.delete()
                goto L_0x0122
            L_0x0207:
                java.lang.Exception r11 = new java.lang.Exception
                java.lang.String r0 = "Unsupported data type"
                r11.<init>(r0)
                throw r11
            L_0x020f:
                o3.E0 r11 = o3.Y.c()
                R1.b$c$e r1 = new R1.b$c$e
                R1.b r3 = r10.f8104f
                r1.<init>(r3, r2)
                r10.f8099a = r2
                r10.f8100b = r2
                r10.f8101c = r2
                r2 = 8
                r10.f8103e = r2
                java.lang.Object r11 = o3.C0977g.g(r11, r1, r10)
                if (r11 != r0) goto L_0x022b
            L_0x022a:
                return r0
            L_0x022b:
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: R1.b.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class d extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f8120a;

        /* renamed from: b  reason: collision with root package name */
        Object f8121b;

        /* renamed from: c  reason: collision with root package name */
        int f8122c;

        /* renamed from: d  reason: collision with root package name */
        long f8123d;

        /* renamed from: e  reason: collision with root package name */
        int f8124e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ b f8125f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ InputStream f8126g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f8127h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ OutputStream f8128i;

        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8129a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ b f8130b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f8131c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar, String str, V2.d dVar) {
                super(2, dVar);
                this.f8130b = bVar;
                this.f8131c = str;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f8130b, this.f8131c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8129a == 0) {
                    n.b(obj);
                    S1.d i4 = this.f8130b.f8082c;
                    if (i4 == null) {
                        return null;
                    }
                    i4.e(this.f8130b.f8087h, this.f8131c, this.f8130b.f8085f, this.f8130b.f8086g);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(b bVar, InputStream inputStream, String str, OutputStream outputStream, V2.d dVar) {
            super(2, dVar);
            this.f8125f = bVar;
            this.f8126g = inputStream;
            this.f8127h = str;
            this.f8128i = outputStream;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f8125f, this.f8126g, this.f8127h, this.f8128i, dVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x00d4  */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0048  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                r18 = this;
                r0 = r18
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.f8124e
                r3 = 4636737291354636288(0x4059000000000000, double:100.0)
                r5 = 1
                if (r2 == 0) goto L_0x0028
                if (r2 != r5) goto L_0x0020
                long r6 = r0.f8123d
                int r2 = r0.f8122c
                java.lang.Object r8 = r0.f8121b
                kotlin.jvm.internal.A r8 = (kotlin.jvm.internal.A) r8
                java.lang.Object r9 = r0.f8120a
                byte[] r9 = (byte[]) r9
                R2.n.b(r19)
                goto L_0x00a0
            L_0x0020:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0028:
                R2.n.b(r19)
                r2 = 1024(0x400, float:1.435E-42)
                byte[] r2 = new byte[r2]
                kotlin.jvm.internal.A r6 = new kotlin.jvm.internal.A
                r6.<init>()
                R1.b r7 = r0.f8125f
                int r7 = r7.f8087h
                r8 = 0
                r9 = r8
                r8 = r6
            L_0x003e:
                java.io.InputStream r6 = r0.f8126g
                int r6 = r6.read(r2)
                r8.f20966a = r6
                if (r6 <= 0) goto L_0x00d4
                R1.b r6 = r0.f8125f
                long r11 = r6.f8085f
                double r11 = (double) r11
                double r11 = r11 * r3
                R1.b r6 = r0.f8125f
                long r13 = r6.f8086g
                double r13 = (double) r13
                double r11 = r11 / r13
                int r6 = (int) r11
                int r11 = r7 + 10
                if (r6 > r11) goto L_0x006c
                long r11 = java.lang.System.currentTimeMillis()
                r13 = 1000(0x3e8, float:1.401E-42)
                long r13 = (long) r13
                long r13 = r13 + r9
                int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r15 <= 0) goto L_0x00a8
                if (r6 <= r7) goto L_0x00a8
            L_0x006c:
                long r9 = java.lang.System.currentTimeMillis()
                java.lang.String r7 = r0.f8127h
                if (r7 == 0) goto L_0x00a7
                int r7 = r7.length()
                if (r7 != 0) goto L_0x007b
                goto L_0x00a7
            L_0x007b:
                o3.E0 r7 = o3.Y.c()
                R1.b$d$a r11 = new R1.b$d$a
                R1.b r12 = r0.f8125f
                java.lang.String r13 = r0.f8127h
                r14 = 0
                r11.<init>(r12, r13, r14)
                r0.f8120a = r2
                r0.f8121b = r8
                r0.f8122c = r6
                r0.f8123d = r9
                r0.f8124e = r5
                java.lang.Object r7 = o3.C0977g.g(r7, r11, r0)
                if (r7 != r1) goto L_0x009a
                return r1
            L_0x009a:
                r16 = r9
                r9 = r2
                r2 = r6
                r6 = r16
            L_0x00a0:
                r16 = r6
                r7 = r2
                r2 = r9
                r9 = r16
                goto L_0x00a8
            L_0x00a7:
                r7 = r6
            L_0x00a8:
                java.io.OutputStream r6 = r0.f8128i
                int r11 = r8.f20966a
                r12 = 0
                r6.write(r2, r12, r11)
                R1.b r6 = r0.f8125f
                long r11 = r6.f8085f
                int r13 = r8.f20966a
                long r13 = (long) r13
                long r11 = r11 + r13
                r6.f8085f = r11
                R1.b r6 = r0.f8125f
                long r11 = r6.f8085f
                double r11 = (double) r11
                double r11 = r11 * r3
                R1.b r13 = r0.f8125f
                long r13 = r13.f8086g
                double r13 = (double) r13
                double r11 = r11 / r13
                int r11 = (int) r11
                r6.f8087h = r11
                goto L_0x003e
            L_0x00d4:
                java.io.InputStream r1 = r0.f8126g
                r1.close()
                java.io.OutputStream r1 = r0.f8128i
                r1.close()
                R2.s r1 = R2.s.f8222a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: R1.b.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class e extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f8132a;

        /* renamed from: b  reason: collision with root package name */
        Object f8133b;

        /* renamed from: c  reason: collision with root package name */
        Object f8134c;

        /* renamed from: d  reason: collision with root package name */
        int f8135d;

        /* renamed from: e  reason: collision with root package name */
        int f8136e;

        /* renamed from: f  reason: collision with root package name */
        /* synthetic */ Object f8137f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ b f8138g;

        /* renamed from: h  reason: collision with root package name */
        int f8139h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(b bVar, V2.d dVar) {
            super(dVar);
            this.f8138g = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f8137f = obj;
            this.f8139h |= Integer.MIN_VALUE;
            return this.f8138g.t((File) null, (File) null, this);
        }
    }

    static final class f extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8140a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f8141b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(b bVar, V2.d dVar) {
            super(2, dVar);
            this.f8141b = bVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new f(this.f8141b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f8140a == 0) {
                n.b(obj);
                S1.d i4 = this.f8141b.f8082c;
                if (i4 == null) {
                    return null;
                }
                i4.g();
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((f) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class g extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8142a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f8143b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ File f8144c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(b bVar, File file, V2.d dVar) {
            super(2, dVar);
            this.f8143b = bVar;
            this.f8144c = file;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new g(this.f8143b, this.f8144c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f8142a == 0) {
                n.b(obj);
                S1.d i4 = this.f8143b.f8082c;
                if (i4 == null) {
                    return null;
                }
                i4.f(this.f8144c);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((g) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class h extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8145a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f8146b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ File f8147c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(b bVar, File file, V2.d dVar) {
            super(2, dVar);
            this.f8146b = bVar;
            this.f8147c = file;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new h(this.f8146b, this.f8147c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f8145a == 0) {
                n.b(obj);
                S1.d i4 = this.f8146b.f8082c;
                if (i4 == null) {
                    return null;
                }
                i4.c(this.f8147c);
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
        int f8148a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f8149b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C f8150c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(b bVar, C c5, V2.d dVar) {
            super(2, dVar);
            this.f8149b = bVar;
            this.f8150c = c5;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new i(this.f8149b, this.f8150c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f8148a == 0) {
                n.b(obj);
                S1.d i4 = this.f8149b.f8082c;
                if (i4 == null) {
                    return null;
                }
                i4.f((File) this.f8150c.f20968a);
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
        int f8151a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f8152b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C f8153c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(b bVar, C c5, V2.d dVar) {
            super(2, dVar);
            this.f8152b = bVar;
            this.f8153c = c5;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new j(this.f8152b, this.f8153c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f8151a == 0) {
                n.b(obj);
                S1.d i4 = this.f8152b.f8082c;
                if (i4 == null) {
                    return null;
                }
                i4.c((File) this.f8153c.f20968a);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((j) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class k extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f8154a;

        /* renamed from: b  reason: collision with root package name */
        Object f8155b;

        /* renamed from: c  reason: collision with root package name */
        Object f8156c;

        /* renamed from: d  reason: collision with root package name */
        int f8157d;

        /* renamed from: e  reason: collision with root package name */
        int f8158e;

        /* renamed from: f  reason: collision with root package name */
        /* synthetic */ Object f8159f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ b f8160g;

        /* renamed from: h  reason: collision with root package name */
        int f8161h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(b bVar, V2.d dVar) {
            super(dVar);
            this.f8160g = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f8159f = obj;
            this.f8161h |= Integer.MIN_VALUE;
            return this.f8160g.s((File) null, (DocumentFile) null, this);
        }
    }

    static final class l extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8162a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f8163b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(b bVar, V2.d dVar) {
            super(2, dVar);
            this.f8163b = bVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new l(this.f8163b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f8162a == 0) {
                n.b(obj);
                S1.d i4 = this.f8163b.f8082c;
                if (i4 == null) {
                    return null;
                }
                i4.g();
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((l) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class m extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8164a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f8165b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f8166c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ DocumentFile f8167d;

        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8168a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ b f8169b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ File f8170c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar, File file, V2.d dVar) {
                super(2, dVar);
                this.f8169b = bVar;
                this.f8170c = file;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f8169b, this.f8170c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8168a == 0) {
                    n.b(obj);
                    S1.d i4 = this.f8169b.f8082c;
                    if (i4 == null) {
                        return null;
                    }
                    i4.f(this.f8170c);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: R1.b$m$b  reason: collision with other inner class name */
        static final class C0103b extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8171a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ b f8172b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ File f8173c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0103b(b bVar, File file, V2.d dVar) {
                super(2, dVar);
                this.f8172b = bVar;
                this.f8173c = file;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0103b(this.f8172b, this.f8173c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8171a == 0) {
                    n.b(obj);
                    S1.d i4 = this.f8172b.f8082c;
                    if (i4 == null) {
                        return null;
                    }
                    i4.c(this.f8173c);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((C0103b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class c extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8174a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ b f8175b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ DocumentFile f8176c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(b bVar, DocumentFile documentFile, V2.d dVar) {
                super(2, dVar);
                this.f8175b = bVar;
                this.f8176c = documentFile;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new c(this.f8175b, this.f8176c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8174a == 0) {
                    n.b(obj);
                    S1.d i4 = this.f8175b.f8082c;
                    if (i4 == null) {
                        return null;
                    }
                    DocumentFile documentFile = this.f8176c;
                    kotlin.jvm.internal.m.b(documentFile);
                    i4.d(documentFile);
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
            int f8177a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ b f8178b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ DocumentFile f8179c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(b bVar, DocumentFile documentFile, V2.d dVar) {
                super(2, dVar);
                this.f8178b = bVar;
                this.f8179c = documentFile;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new d(this.f8178b, this.f8179c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8177a == 0) {
                    n.b(obj);
                    S1.d i4 = this.f8178b.f8082c;
                    if (i4 == null) {
                        return null;
                    }
                    DocumentFile documentFile = this.f8179c;
                    kotlin.jvm.internal.m.b(documentFile);
                    i4.a(documentFile);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(File file, b bVar, DocumentFile documentFile, V2.d dVar) {
            super(2, dVar);
            this.f8165b = file;
            this.f8166c = bVar;
            this.f8167d = documentFile;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new m(this.f8165b, this.f8166c, this.f8167d, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0097, code lost:
            if (R1.b.c(r7, r8, r9, r10, r11, r14) == r0) goto L_0x00ec;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b2, code lost:
            if (o3.C0977g.g(r1, r2, r14) == r0) goto L_0x00ec;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d1, code lost:
            if (o3.C0977g.g(r1, r2, r14) != r0) goto L_0x00d4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ea, code lost:
            if (o3.C0977g.g(r1, r2, r14) != r0) goto L_0x00ed;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r14.f8164a
                r2 = 5
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                if (r1 == 0) goto L_0x003b
                if (r1 == r6) goto L_0x0035
                if (r1 == r5) goto L_0x002f
                if (r1 == r4) goto L_0x0029
                if (r1 == r3) goto L_0x0025
                if (r1 != r2) goto L_0x001d
                R2.n.b(r15)
                r13 = r14
                goto L_0x009a
            L_0x001d:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L_0x0025:
                R2.n.b(r15)
                goto L_0x007f
            L_0x0029:
                R2.n.b(r15)
                r13 = r14
                goto L_0x00b5
            L_0x002f:
                R2.n.b(r15)
                r13 = r14
                goto L_0x00d4
            L_0x0035:
                R2.n.b(r15)
                r13 = r14
                goto L_0x00ed
            L_0x003b:
                R2.n.b(r15)
                r15 = 0
                java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00bb, SecurityException -> 0x00b8 }
                java.io.File r1 = r14.f8165b     // Catch:{ FileNotFoundException -> 0x00bb, SecurityException -> 0x00b8 }
                r8.<init>(r1)     // Catch:{ FileNotFoundException -> 0x00bb, SecurityException -> 0x00b8 }
                R1.b r1 = r14.f8166c     // Catch:{ FileNotFoundException -> 0x009d }
                android.content.Context r1 = r1.f8084e     // Catch:{ FileNotFoundException -> 0x009d }
                android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ FileNotFoundException -> 0x009d }
                if (r1 == 0) goto L_0x0064
                androidx.documentfile.provider.DocumentFile r5 = r14.f8167d     // Catch:{ FileNotFoundException -> 0x0061 }
                kotlin.jvm.internal.m.b(r5)     // Catch:{ FileNotFoundException -> 0x0061 }
                android.net.Uri r5 = r5.getUri()     // Catch:{ FileNotFoundException -> 0x0061 }
                java.io.OutputStream r1 = r1.openOutputStream(r5)     // Catch:{ FileNotFoundException -> 0x0061 }
                r9 = r1
                goto L_0x0065
            L_0x0061:
                r13 = r14
                goto L_0x009f
            L_0x0064:
                r9 = r15
            L_0x0065:
                if (r9 != 0) goto L_0x0082
                o3.E0 r1 = o3.Y.c()
                R1.b$m$d r2 = new R1.b$m$d
                R1.b r4 = r14.f8166c
                androidx.documentfile.provider.DocumentFile r5 = r14.f8167d
                r2.<init>(r4, r5, r15)
                r14.f8164a = r3
                java.lang.Object r15 = o3.C0977g.g(r1, r2, r14)
                if (r15 != r0) goto L_0x007f
                r13 = r14
                goto L_0x00ec
            L_0x007f:
                R2.s r15 = R2.s.f8222a
                return r15
            L_0x0082:
                R1.b r7 = r14.f8166c
                java.io.File r15 = r14.f8165b
                java.lang.String r10 = r15.getName()
                java.io.File r15 = r14.f8165b
                long r11 = r15.length()
                r14.f8164a = r2
                r13 = r14
                java.lang.Object r15 = r7.r(r8, r9, r10, r11, r13)
                if (r15 != r0) goto L_0x009a
                goto L_0x00ec
            L_0x009a:
                R2.s r15 = R2.s.f8222a
                return r15
            L_0x009d:
                r13 = r14
            L_0x009f:
                o3.E0 r1 = o3.Y.c()
                R1.b$m$c r2 = new R1.b$m$c
                R1.b r3 = r13.f8166c
                androidx.documentfile.provider.DocumentFile r5 = r13.f8167d
                r2.<init>(r3, r5, r15)
                r13.f8164a = r4
                java.lang.Object r15 = o3.C0977g.g(r1, r2, r14)
                if (r15 != r0) goto L_0x00b5
                goto L_0x00ec
            L_0x00b5:
                R2.s r15 = R2.s.f8222a
                return r15
            L_0x00b8:
                r13 = r14
                goto L_0x00be
            L_0x00bb:
                r13 = r14
                goto L_0x00d7
            L_0x00be:
                o3.E0 r1 = o3.Y.c()
                R1.b$m$b r2 = new R1.b$m$b
                R1.b r3 = r13.f8166c
                java.io.File r4 = r13.f8165b
                r2.<init>(r3, r4, r15)
                r13.f8164a = r5
                java.lang.Object r15 = o3.C0977g.g(r1, r2, r14)
                if (r15 != r0) goto L_0x00d4
                goto L_0x00ec
            L_0x00d4:
                R2.s r15 = R2.s.f8222a
                return r15
            L_0x00d7:
                o3.E0 r1 = o3.Y.c()
                R1.b$m$a r2 = new R1.b$m$a
                R1.b r3 = r13.f8166c
                java.io.File r4 = r13.f8165b
                r2.<init>(r3, r4, r15)
                r13.f8164a = r6
                java.lang.Object r15 = o3.C0977g.g(r1, r2, r14)
                if (r15 != r0) goto L_0x00ed
            L_0x00ec:
                return r0
            L_0x00ed:
                R2.s r15 = R2.s.f8222a
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: R1.b.m.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((m) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public b(ArrayList arrayList, Object obj, S1.d dVar, boolean z4, Context context) {
        long j4;
        kotlin.jvm.internal.m.e(arrayList, "itemsToCopy");
        kotlin.jvm.internal.m.e(obj, "targetDir");
        kotlin.jvm.internal.m.e(context, "context");
        this.f8080a = arrayList;
        this.f8081b = obj;
        this.f8082c = dVar;
        this.f8083d = z4;
        this.f8084e = context;
        C1001s0 unused = C0981i.d(K.a(Y.b()), (V2.g) null, (L) null, new a(this, (V2.d) null), 3, (Object) null);
        int size = arrayList.size();
        int i4 = 0;
        long j5 = 0;
        while (i4 < size) {
            Object obj2 = arrayList.get(i4);
            i4++;
            if (obj2 instanceof File) {
                j4 = ((File) obj2).length();
            } else if (obj2 instanceof DocumentFile) {
                j4 = ((DocumentFile) obj2).length();
            } else {
                j4 = 0;
            }
            j5 += j4;
        }
        this.f8086g = j5;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x012d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object p(androidx.documentfile.provider.DocumentFile r12, androidx.documentfile.provider.DocumentFile r13, V2.d r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof R1.b.C0100b
            if (r0 == 0) goto L_0x0013
            r0 = r14
            R1.b$b r0 = (R1.b.C0100b) r0
            int r1 = r0.f8098i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f8098i = r1
            goto L_0x0018
        L_0x0013:
            R1.b$b r0 = new R1.b$b
            r0.<init>(r11, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f8096g
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f8098i
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0052
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r12 = r0.f8090a
            androidx.documentfile.provider.DocumentFile r12 = (androidx.documentfile.provider.DocumentFile) r12
            R2.n.b(r14)
            return r12
        L_0x0030:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0038:
            int r12 = r0.f8095f
            int r13 = r0.f8094e
            java.lang.Object r2 = r0.f8093d
            androidx.documentfile.provider.DocumentFile[] r2 = (androidx.documentfile.provider.DocumentFile[]) r2
            java.lang.Object r5 = r0.f8092c
            androidx.documentfile.provider.DocumentFile r5 = (androidx.documentfile.provider.DocumentFile) r5
            java.lang.Object r6 = r0.f8091b
            androidx.documentfile.provider.DocumentFile r6 = (androidx.documentfile.provider.DocumentFile) r6
            java.lang.Object r7 = r0.f8090a
            R1.b r7 = (R1.b) r7
            R2.n.b(r14)
            r14 = r5
            goto L_0x00b4
        L_0x0052:
            R2.n.b(r14)
            boolean r14 = r13.isFile()
            if (r14 == 0) goto L_0x0063
            androidx.documentfile.provider.DocumentFile r13 = r11.u(r12, r13)
        L_0x005f:
            r4 = r11
            r10 = r0
            goto L_0x00d0
        L_0x0063:
            boolean r14 = r13.isDirectory()
            if (r14 == 0) goto L_0x005f
            boolean r14 = r12.isDirectory()
            if (r14 == 0) goto L_0x00c5
            java.lang.String r14 = r12.getName()
            if (r14 == 0) goto L_0x00bd
            java.lang.String r14 = r12.getName()
            kotlin.jvm.internal.m.b(r14)
            androidx.documentfile.provider.DocumentFile r13 = r13.createDirectory(r14)
            if (r13 == 0) goto L_0x005f
            androidx.documentfile.provider.DocumentFile[] r14 = r12.listFiles()
            java.lang.String r2 = "original.listFiles()"
            kotlin.jvm.internal.m.d(r14, r2)
            int r2 = r14.length
            r5 = 0
            r7 = r13
            r13 = r12
            r12 = r2
            r2 = r14
            r14 = r7
            r7 = r11
        L_0x0093:
            if (r5 >= r12) goto L_0x00b8
            r6 = r2[r5]
            java.lang.String r8 = "subFile"
            kotlin.jvm.internal.m.d(r6, r8)
            r0.f8090a = r7
            r0.f8091b = r13
            r0.f8092c = r14
            r0.f8093d = r2
            r0.f8094e = r5
            r0.f8095f = r12
            r0.f8098i = r4
            java.lang.Object r6 = r7.p(r6, r14, r0)
            if (r6 != r1) goto L_0x00b2
            goto L_0x011b
        L_0x00b2:
            r6 = r13
            r13 = r5
        L_0x00b4:
            int r5 = r13 + 1
            r13 = r6
            goto L_0x0093
        L_0x00b8:
            r12 = r13
            r13 = r14
            r10 = r0
            r4 = r7
            goto L_0x00d0
        L_0x00bd:
            java.lang.Exception r12 = new java.lang.Exception
            java.lang.String r13 = "Source name unknown"
            r12.<init>(r13)
            throw r12
        L_0x00c5:
            boolean r14 = r12.isFile()
            if (r14 == 0) goto L_0x005f
            androidx.documentfile.provider.DocumentFile r13 = r11.u(r12, r13)
            goto L_0x005f
        L_0x00d0:
            if (r13 == 0) goto L_0x012d
            boolean r14 = r13.isFile()
            if (r14 == 0) goto L_0x012d
            android.content.Context r14 = r4.f8084e
            android.content.ContentResolver r14 = r14.getContentResolver()
            r0 = 0
            if (r14 == 0) goto L_0x00eb
            android.net.Uri r2 = r12.getUri()
            java.io.InputStream r14 = r14.openInputStream(r2)
            r5 = r14
            goto L_0x00ec
        L_0x00eb:
            r5 = r0
        L_0x00ec:
            if (r5 == 0) goto L_0x0125
            android.content.Context r14 = r4.f8084e
            android.content.ContentResolver r14 = r14.getContentResolver()
            if (r14 == 0) goto L_0x0100
            android.net.Uri r2 = r13.getUri()
            java.io.OutputStream r14 = r14.openOutputStream(r2)
            r6 = r14
            goto L_0x0101
        L_0x0100:
            r6 = r0
        L_0x0101:
            if (r6 == 0) goto L_0x011d
            java.lang.String r7 = r12.getName()
            long r8 = r12.length()
            r10.f8090a = r13
            r10.f8091b = r0
            r10.f8092c = r0
            r10.f8093d = r0
            r10.f8098i = r3
            java.lang.Object r12 = r4.r(r5, r6, r7, r8, r10)
            if (r12 != r1) goto L_0x011c
        L_0x011b:
            return r1
        L_0x011c:
            return r13
        L_0x011d:
            java.lang.Exception r12 = new java.lang.Exception
            java.lang.String r13 = "Cannot open output stream"
            r12.<init>(r13)
            throw r12
        L_0x0125:
            java.lang.Exception r12 = new java.lang.Exception
            java.lang.String r13 = "Cannot open input stream"
            r12.<init>(r13)
            throw r12
        L_0x012d:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: R1.b.p(androidx.documentfile.provider.DocumentFile, androidx.documentfile.provider.DocumentFile, V2.d):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object q(V2.d dVar) {
        return C0977g.g(Y.b(), new c(this, (V2.d) null), dVar);
    }

    /* access modifiers changed from: private */
    public final Object r(InputStream inputStream, OutputStream outputStream, String str, long j4, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new d(this, inputStream, str, outputStream, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x012d, code lost:
        if (r9.s(r3, r7, r4) == r5) goto L_0x012f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x012f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object s(java.io.File r19, androidx.documentfile.provider.DocumentFile r20, V2.d r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            boolean r4 = r3 instanceof R1.b.k
            if (r4 == 0) goto L_0x001b
            r4 = r3
            R1.b$k r4 = (R1.b.k) r4
            int r5 = r4.f8161h
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L_0x001b
            int r5 = r5 - r6
            r4.f8161h = r5
            goto L_0x0020
        L_0x001b:
            R1.b$k r4 = new R1.b$k
            r4.<init>(r0, r3)
        L_0x0020:
            java.lang.Object r3 = r4.f8159f
            java.lang.Object r5 = W2.b.c()
            int r6 = r4.f8161h
            r7 = 0
            r8 = 4
            r9 = 3
            r10 = 2
            r11 = 1
            if (r6 == 0) goto L_0x0060
            if (r6 == r11) goto L_0x005c
            if (r6 == r10) goto L_0x0054
            if (r6 == r9) goto L_0x0054
            if (r6 != r8) goto L_0x004c
            int r1 = r4.f8158e
            int r2 = r4.f8157d
            java.lang.Object r6 = r4.f8156c
            java.io.File[] r6 = (java.io.File[]) r6
            java.lang.Object r7 = r4.f8155b
            androidx.documentfile.provider.DocumentFile r7 = (androidx.documentfile.provider.DocumentFile) r7
            java.lang.Object r9 = r4.f8154a
            R1.b r9 = (R1.b) r9
            R2.n.b(r3)
            goto L_0x0130
        L_0x004c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0054:
            java.lang.Object r1 = r4.f8154a
            androidx.documentfile.provider.DocumentFile r1 = (androidx.documentfile.provider.DocumentFile) r1
            R2.n.b(r3)
            return r1
        L_0x005c:
            R2.n.b(r3)
            goto L_0x0089
        L_0x0060:
            R2.n.b(r3)
            W1.h r3 = new W1.h
            r3.<init>()
            android.content.Context r6 = r0.f8084e
            long r12 = r3.l(r6, r2)
            long r14 = r1.length()
            int r3 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r3 >= 0) goto L_0x008a
            o3.E0 r1 = o3.Y.c()
            R1.b$l r2 = new R1.b$l
            r2.<init>(r0, r7)
            r4.f8161h = r11
            java.lang.Object r1 = o3.C0977g.g(r1, r2, r4)
            if (r1 != r5) goto L_0x0089
            goto L_0x012f
        L_0x0089:
            return r7
        L_0x008a:
            boolean r3 = r1.isFile()
            if (r3 == 0) goto L_0x00f1
            boolean r3 = r2.isDirectory()
            if (r3 == 0) goto L_0x00c4
            java.lang.String r3 = r1.getName()
            java.lang.String r6 = "src.name"
            kotlin.jvm.internal.m.d(r3, r6)
            java.lang.String r12 = r1.getName()
            kotlin.jvm.internal.m.d(r12, r6)
            r16 = 6
            r17 = 0
            java.lang.String r13 = "."
            r14 = 0
            r15 = 0
            int r6 = m3.m.R(r12, r13, r14, r15, r16, r17)
            int r6 = r6 + r11
            java.lang.String r3 = r3.substring(r6)
            java.lang.String r6 = "this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.m.d(r3, r6)
            java.lang.String r6 = r1.getName()
            androidx.documentfile.provider.DocumentFile r2 = r2.createFile(r3, r6)
        L_0x00c4:
            if (r2 == 0) goto L_0x00e9
            boolean r3 = r2.isFile()
            if (r3 == 0) goto L_0x00dd
            boolean r3 = r2.exists()
            if (r3 == 0) goto L_0x00dd
            r4.f8154a = r2
            r4.f8161h = r10
            java.lang.Object r1 = r0.v(r1, r2, r4)
            if (r1 != r5) goto L_0x00e8
            goto L_0x012f
        L_0x00dd:
            r4.f8154a = r2
            r4.f8161h = r9
            java.lang.Object r1 = r0.v(r1, r2, r4)
            if (r1 != r5) goto L_0x00e8
            goto L_0x012f
        L_0x00e8:
            return r2
        L_0x00e9:
            java.lang.Exception r1 = new java.lang.Exception
            java.lang.String r2 = "Target is null"
            r1.<init>(r2)
            throw r1
        L_0x00f1:
            boolean r3 = r1.isDirectory()
            if (r3 == 0) goto L_0x0157
            boolean r3 = r2.isDirectory()
            if (r3 == 0) goto L_0x014f
            java.lang.String r3 = r1.getName()
            androidx.documentfile.provider.DocumentFile r2 = r2.createDirectory(r3)
            if (r2 == 0) goto L_0x0134
            java.io.File[] r1 = r1.listFiles()
            if (r1 == 0) goto L_0x0133
            int r3 = r1.length
            r6 = 0
            r9 = r0
            r6 = r1
            r7 = r2
            r1 = r3
            r2 = 0
        L_0x0114:
            if (r2 >= r1) goto L_0x0132
            r3 = r6[r2]
            java.lang.String r10 = "file"
            kotlin.jvm.internal.m.d(r3, r10)
            r4.f8154a = r9
            r4.f8155b = r7
            r4.f8156c = r6
            r4.f8157d = r2
            r4.f8158e = r1
            r4.f8161h = r8
            java.lang.Object r3 = r9.s(r3, r7, r4)
            if (r3 != r5) goto L_0x0130
        L_0x012f:
            return r5
        L_0x0130:
            int r2 = r2 + r11
            goto L_0x0114
        L_0x0132:
            return r7
        L_0x0133:
            return r2
        L_0x0134:
            java.lang.Exception r2 = new java.lang.Exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Cannot create Directory "
            r3.append(r4)
            java.lang.String r1 = r1.getName()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x014f:
            java.lang.Exception r1 = new java.lang.Exception
            java.lang.String r2 = "Cannot copy a directory into a file"
            r1.<init>(r2)
            throw r1
        L_0x0157:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: R1.b.s(java.io.File, androidx.documentfile.provider.DocumentFile, V2.d):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0108, code lost:
        r13 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01aa, code lost:
        if (r12 >= r11) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01ac, code lost:
        r5 = r13[r12];
        kotlin.jvm.internal.m.d(r5, "file");
        r7.f8132a = r4;
        r7.f8133b = r3;
        r7.f8134c = r13;
        r7.f8135d = r12;
        r7.f8136e = r11;
        r7.f8139h = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01c8, code lost:
        if (r4.t(r5, (java.io.File) r3.f20968a, r7) != r0) goto L_0x01cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01cb, code lost:
        r12 = r12 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01cd, code lost:
        r13 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01d9, code lost:
        return r13.f20968a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01ca A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object t(java.io.File r11, java.io.File r12, V2.d r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof R1.b.e
            if (r0 == 0) goto L_0x0014
            r0 = r13
            R1.b$e r0 = (R1.b.e) r0
            int r1 = r0.f8139h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0014
            int r1 = r1 - r2
            r0.f8139h = r1
        L_0x0012:
            r7 = r0
            goto L_0x001a
        L_0x0014:
            R1.b$e r0 = new R1.b$e
            r0.<init>(r10, r13)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r13 = r7.f8137f
            java.lang.Object r0 = W2.b.c()
            int r1 = r7.f8139h
            r2 = 1
            r3 = 0
            switch(r1) {
                case 0: goto L_0x0070;
                case 1: goto L_0x006c;
                case 2: goto L_0x0065;
                case 3: goto L_0x005e;
                case 4: goto L_0x0057;
                case 5: goto L_0x0050;
                case 6: goto L_0x0046;
                case 7: goto L_0x002f;
                default: goto L_0x0027;
            }
        L_0x0027:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x002f:
            int r11 = r7.f8136e
            int r12 = r7.f8135d
            java.lang.Object r1 = r7.f8134c
            java.io.File[] r1 = (java.io.File[]) r1
            java.lang.Object r3 = r7.f8133b
            kotlin.jvm.internal.C r3 = (kotlin.jvm.internal.C) r3
            java.lang.Object r4 = r7.f8132a
            R1.b r4 = (R1.b) r4
            R2.n.b(r13)
            r13 = r1
            r1 = r10
            goto L_0x01cb
        L_0x0046:
            java.lang.Object r11 = r7.f8132a
            kotlin.jvm.internal.C r11 = (kotlin.jvm.internal.C) r11
            R2.n.b(r13)
            r1 = r10
            goto L_0x0108
        L_0x0050:
            R2.n.b(r13)
            r1 = r10
            r12 = r3
            goto L_0x0125
        L_0x0057:
            R2.n.b(r13)
            r1 = r10
            r12 = r3
            goto L_0x013a
        L_0x005e:
            R2.n.b(r13)
            r1 = r10
            r12 = r3
            goto L_0x0157
        L_0x0065:
            R2.n.b(r13)
            r1 = r10
            r12 = r3
            goto L_0x016b
        L_0x006c:
            R2.n.b(r13)
            goto L_0x009a
        L_0x0070:
            R2.n.b(r13)
            kotlin.jvm.internal.C r13 = new kotlin.jvm.internal.C
            r13.<init>()
            r13.f20968a = r12
            long r4 = r12.getUsableSpace()
            long r8 = r11.length()
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 >= 0) goto L_0x009b
            o3.E0 r11 = o3.Y.c()
            R1.b$f r12 = new R1.b$f
            r12.<init>(r10, r3)
            r7.f8139h = r2
            java.lang.Object r11 = o3.C0977g.g(r11, r12, r7)
            if (r11 != r0) goto L_0x009a
            r1 = r10
            goto L_0x01ca
        L_0x009a:
            return r3
        L_0x009b:
            boolean r1 = r11.isFile()
            r4 = 47
            if (r1 == 0) goto L_0x016c
            boolean r1 = r12.isDirectory()
            if (r1 == 0) goto L_0x00ca
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r12 = r12.getAbsolutePath()
            r2.append(r12)
            r2.append(r4)
            java.lang.String r12 = r11.getName()
            r2.append(r12)
            java.lang.String r12 = r2.toString()
            r1.<init>(r12)
            r13.f20968a = r1
        L_0x00ca:
            java.lang.Object r12 = r13.f20968a
            java.io.File r12 = (java.io.File) r12
            boolean r12 = r12.isFile()
            if (r12 == 0) goto L_0x00e2
            java.lang.Object r12 = r13.f20968a
            java.io.File r12 = (java.io.File) r12
            boolean r12 = r12.exists()
            if (r12 != 0) goto L_0x00df
            goto L_0x00e2
        L_0x00df:
            r1 = r10
            goto L_0x01d7
        L_0x00e2:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x013f, SecurityException -> 0x013b }
            r2.<init>(r11)     // Catch:{ FileNotFoundException -> 0x013f, SecurityException -> 0x013b }
            r12 = r3
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x010e, SecurityException -> 0x010b }
            java.lang.Object r1 = r13.f20968a     // Catch:{ FileNotFoundException -> 0x010e, SecurityException -> 0x010b }
            java.io.File r1 = (java.io.File) r1     // Catch:{ FileNotFoundException -> 0x010e, SecurityException -> 0x010b }
            r3.<init>(r1)     // Catch:{ FileNotFoundException -> 0x010e, SecurityException -> 0x010b }
            java.lang.String r4 = r11.getName()
            long r5 = r11.length()
            r7.f8132a = r13
            r11 = 6
            r7.f8139h = r11
            r1 = r10
            java.lang.Object r11 = r1.r(r2, r3, r4, r5, r7)
            if (r11 != r0) goto L_0x0107
            goto L_0x01ca
        L_0x0107:
            r11 = r13
        L_0x0108:
            r13 = r11
            goto L_0x01d7
        L_0x010b:
            r1 = r10
            goto L_0x0111
        L_0x010e:
            r1 = r10
            goto L_0x0126
        L_0x0111:
            o3.E0 r11 = o3.Y.c()
            R1.b$j r2 = new R1.b$j
            r2.<init>(r10, r13, r12)
            r13 = 5
            r7.f8139h = r13
            java.lang.Object r11 = o3.C0977g.g(r11, r2, r7)
            if (r11 != r0) goto L_0x0125
            goto L_0x01ca
        L_0x0125:
            return r12
        L_0x0126:
            o3.E0 r11 = o3.Y.c()
            R1.b$i r2 = new R1.b$i
            r2.<init>(r10, r13, r12)
            r13 = 4
            r7.f8139h = r13
            java.lang.Object r11 = o3.C0977g.g(r11, r2, r7)
            if (r11 != r0) goto L_0x013a
            goto L_0x01ca
        L_0x013a:
            return r12
        L_0x013b:
            r1 = r10
            r12 = r3
            goto L_0x0143
        L_0x013f:
            r1 = r10
            r12 = r3
            goto L_0x0158
        L_0x0143:
            o3.E0 r13 = o3.Y.c()
            R1.b$h r2 = new R1.b$h
            r2.<init>(r10, r11, r12)
            r11 = 3
            r7.f8139h = r11
            java.lang.Object r11 = o3.C0977g.g(r13, r2, r7)
            if (r11 != r0) goto L_0x0157
            goto L_0x01ca
        L_0x0157:
            return r12
        L_0x0158:
            o3.E0 r13 = o3.Y.c()
            R1.b$g r2 = new R1.b$g
            r2.<init>(r10, r11, r12)
            r11 = 2
            r7.f8139h = r11
            java.lang.Object r11 = o3.C0977g.g(r13, r2, r7)
            if (r11 != r0) goto L_0x016b
            goto L_0x01ca
        L_0x016b:
            return r12
        L_0x016c:
            r1 = r10
            boolean r3 = r11.isDirectory()
            if (r3 == 0) goto L_0x01d7
            boolean r3 = r12.isDirectory()
            if (r3 == 0) goto L_0x01cf
            java.io.File r3 = new java.io.File
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r12 = r12.getAbsolutePath()
            r5.append(r12)
            r5.append(r4)
            java.lang.String r12 = r11.getName()
            r5.append(r12)
            java.lang.String r12 = r5.toString()
            r3.<init>(r12)
            r13.f20968a = r3
            r3.mkdir()
            java.io.File[] r11 = r11.listFiles()
            if (r11 == 0) goto L_0x01d7
            int r12 = r11.length
            r3 = 0
            r3 = r13
            r4 = r1
            r13 = r11
            r11 = r12
            r12 = 0
        L_0x01aa:
            if (r12 >= r11) goto L_0x01cd
            r5 = r13[r12]
            java.lang.String r6 = "file"
            kotlin.jvm.internal.m.d(r5, r6)
            java.lang.Object r6 = r3.f20968a
            java.io.File r6 = (java.io.File) r6
            r7.f8132a = r4
            r7.f8133b = r3
            r7.f8134c = r13
            r7.f8135d = r12
            r7.f8136e = r11
            r8 = 7
            r7.f8139h = r8
            java.lang.Object r5 = r4.t(r5, r6, r7)
            if (r5 != r0) goto L_0x01cb
        L_0x01ca:
            return r0
        L_0x01cb:
            int r12 = r12 + r2
            goto L_0x01aa
        L_0x01cd:
            r13 = r3
            goto L_0x01d7
        L_0x01cf:
            java.lang.Exception r11 = new java.lang.Exception
            java.lang.String r12 = "Cannot copy a directory into a file"
            r11.<init>(r12)
            throw r11
        L_0x01d7:
            java.lang.Object r11 = r13.f20968a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: R1.b.t(java.io.File, java.io.File, V2.d):java.lang.Object");
    }

    private final DocumentFile u(DocumentFile documentFile, DocumentFile documentFile2) {
        if (documentFile.isDirectory()) {
            throw new Exception("Trying copying a directory into a file");
        } else if (documentFile.getName() == null) {
            throw new Exception("Source name unknown");
        } else if (documentFile.getType() != null) {
            String type = documentFile.getType();
            kotlin.jvm.internal.m.b(type);
            String name = documentFile.getName();
            kotlin.jvm.internal.m.b(name);
            String name2 = documentFile.getName();
            kotlin.jvm.internal.m.b(name2);
            String substring = name.substring(0, m3.m.R(name2, ".", 0, false, 6, (Object) null));
            kotlin.jvm.internal.m.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String name3 = documentFile.getName();
            kotlin.jvm.internal.m.b(name3);
            if (m3.m.o(name3, ".xapk", false, 2, (Object) null)) {
                substring = documentFile.getName();
                kotlin.jvm.internal.m.b(substring);
                type = "xapk";
            }
            return documentFile2.createFile(type, substring);
        } else {
            throw new Exception("Source mimetype unknown");
        }
    }

    private final Object v(File file, DocumentFile documentFile, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new m(file, this, documentFile, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }
}
