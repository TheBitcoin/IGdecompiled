package W1;

import N1.k;
import R2.n;
import R2.s;
import T1.i;
import V2.d;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import d3.p;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.z;
import o3.C0977g;
import o3.J;
import o3.Y;

public final class G {

    /* renamed from: b  reason: collision with root package name */
    public static final a f8470b = new a((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f8471a;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final boolean a(String str) {
            m.e(str, "filename");
            if (m3.m.o(str, ".xapk", false, 2, (Object) null) || m3.m.o(str, ".apks", false, 2, (Object) null) || m3.m.o(str, ".apkm", false, 2, (Object) null)) {
                return true;
            }
            return false;
        }

        private a() {
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f8472a;

        /* renamed from: b  reason: collision with root package name */
        Object f8473b;

        /* renamed from: c  reason: collision with root package name */
        Object f8474c;

        /* renamed from: d  reason: collision with root package name */
        Object f8475d;

        /* renamed from: e  reason: collision with root package name */
        Object f8476e;

        /* renamed from: f  reason: collision with root package name */
        Object f8477f;

        /* renamed from: g  reason: collision with root package name */
        Object f8478g;

        /* renamed from: h  reason: collision with root package name */
        Object f8479h;

        /* renamed from: i  reason: collision with root package name */
        Object f8480i;

        /* renamed from: j  reason: collision with root package name */
        Object f8481j;

        /* renamed from: k  reason: collision with root package name */
        Object f8482k;

        /* renamed from: l  reason: collision with root package name */
        int f8483l;

        /* renamed from: m  reason: collision with root package name */
        int f8484m;

        /* renamed from: n  reason: collision with root package name */
        int f8485n;

        /* renamed from: o  reason: collision with root package name */
        long f8486o;

        /* renamed from: p  reason: collision with root package name */
        long f8487p;

        /* renamed from: q  reason: collision with root package name */
        int f8488q;

        /* renamed from: r  reason: collision with root package name */
        final /* synthetic */ File f8489r;

        /* renamed from: s  reason: collision with root package name */
        final /* synthetic */ G f8490s;

        /* renamed from: t  reason: collision with root package name */
        final /* synthetic */ File f8491t;

        /* renamed from: u  reason: collision with root package name */
        final /* synthetic */ S1.m f8492u;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8493a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.m f8494b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(S1.m mVar, V2.d dVar) {
                super(2, dVar);
                this.f8494b = mVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f8494b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8493a == 0) {
                    n.b(obj);
                    S1.m mVar = this.f8494b;
                    if (mVar == null) {
                        return null;
                    }
                    mVar.g();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: W1.G$b$b  reason: collision with other inner class name */
        static final class C0117b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8495a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.m f8496b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C f8497c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0117b(S1.m mVar, C c5, V2.d dVar) {
                super(2, dVar);
                this.f8496b = mVar;
                this.f8497c = c5;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0117b(this.f8496b, this.f8497c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8495a == 0) {
                    n.b(obj);
                    S1.m mVar = this.f8496b;
                    if (mVar == null) {
                        return null;
                    }
                    mVar.d((File) this.f8497c.f20968a);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((C0117b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8498a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.m f8499b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f8500c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(S1.m mVar, int i4, V2.d dVar) {
                super(2, dVar);
                this.f8499b = mVar;
                this.f8500c = i4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new c(this.f8499b, this.f8500c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8498a == 0) {
                    n.b(obj);
                    S1.m mVar = this.f8499b;
                    if (mVar == null) {
                        return null;
                    }
                    mVar.b(this.f8500c);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class d extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8501a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.m f8502b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C f8503c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(S1.m mVar, C c5, V2.d dVar) {
                super(2, dVar);
                this.f8502b = mVar;
                this.f8503c = c5;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new d(this.f8502b, this.f8503c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8501a == 0) {
                    n.b(obj);
                    S1.m mVar = this.f8502b;
                    if (mVar == null) {
                        return null;
                    }
                    mVar.c((File) this.f8503c.f20968a);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class e extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8504a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.m f8505b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(S1.m mVar, V2.d dVar) {
                super(2, dVar);
                this.f8505b = mVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new e(this.f8505b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8504a == 0) {
                    n.b(obj);
                    S1.m mVar = this.f8505b;
                    if (mVar == null) {
                        return null;
                    }
                    mVar.b(100);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class f extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8506a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.m f8507b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ File f8508c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ ArrayList f8509d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(S1.m mVar, File file, ArrayList arrayList, V2.d dVar) {
                super(2, dVar);
                this.f8507b = mVar;
                this.f8508c = file;
                this.f8509d = arrayList;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new f(this.f8507b, this.f8508c, this.f8509d, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8506a == 0) {
                    n.b(obj);
                    k.f7778g.f();
                    S1.m mVar = this.f8507b;
                    if (mVar == null) {
                        return null;
                    }
                    mVar.a(this.f8508c, this.f8509d);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((f) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class g extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8510a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.m f8511b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            g(S1.m mVar, V2.d dVar) {
                super(2, dVar);
                this.f8511b = mVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new g(this.f8511b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8510a == 0) {
                    n.b(obj);
                    S1.m mVar = this.f8511b;
                    if (mVar == null) {
                        return null;
                    }
                    mVar.h();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((g) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class h extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8512a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ z f8513b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ z f8514c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ S1.m f8515d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            h(z zVar, z zVar2, S1.m mVar, V2.d dVar) {
                super(2, dVar);
                this.f8513b = zVar;
                this.f8514c = zVar2;
                this.f8515d = mVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new h(this.f8513b, this.f8514c, this.f8515d, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8512a == 0) {
                    n.b(obj);
                    if (!this.f8513b.f20985a) {
                        if (!this.f8514c.f20985a) {
                            S1.m mVar = this.f8515d;
                            if (mVar != null) {
                                mVar.e();
                            }
                        } else {
                            S1.m mVar2 = this.f8515d;
                            if (mVar2 != null) {
                                mVar2.h();
                            }
                        }
                    }
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((h) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(File file, G g4, File file2, S1.m mVar, V2.d dVar) {
            super(2, dVar);
            this.f8489r = file;
            this.f8490s = g4;
            this.f8491t = file2;
            this.f8492u = mVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f8489r, this.f8490s, this.f8491t, this.f8492u, dVar);
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x0383, code lost:
            r11 = r35;
            r18 = r5;
            r5 = r22;
            r12 = r23;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:103:0x038b, code lost:
            r9 = r30;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:0x038e, code lost:
            r2 = r4;
            r3 = r6;
            r4 = r7;
            r8 = r21;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x0395, code lost:
            r35 = r8;
            r30 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:0x0399, code lost:
            r8 = java.lang.System.currentTimeMillis();
            N1.k.f7778g.Q(r11);
            r18 = o3.Y.c();
            r10 = new W1.G.b.c(r0.f8492u, r11, (V2.d) null);
            r0.f8472a = r7;
            r0.f8473b = r6;
            r0.f8474c = r4;
            r0.f8475d = r15;
            r0.f8476e = r2;
            r0.f8477f = r14;
            r0.f8478g = r3;
            r12 = r22;
            r0.f8479h = r12;
            r0.f8480i = r13;
            r1 = r23;
            r0.f8481j = r1;
            r23 = r1;
            r1 = r35;
            r0.f8482k = r1;
            r0.f8483l = r5;
            r35 = r1;
            r1 = r20;
            r0.f8484m = r1;
            r22 = r1;
            r20 = r2;
            r1 = r30;
            r0.f8486o = r1;
            r0.f8485n = r11;
            r0.f8487p = r8;
            r30 = r1;
            r0.f8488q = 3;
            r1 = o3.C0977g.g(r18, r10, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x03ed, code lost:
            r10 = r21;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x03ef, code lost:
            if (r1 != r10) goto L_0x03f4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x03f4, code lost:
            r18 = r5;
            r25 = r8;
            r1 = r11;
            r5 = r12;
            r2 = r20;
            r20 = r22;
            r12 = r23;
            r11 = r35;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:0x0408, code lost:
            if (W1.G.a(r0.f8490s) != false) goto L_0x040a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:0x040a, code lost:
            r35 = r2;
            r2 = r18;
            r18 = r13;
            r13 = r14;
            r14 = r20;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x0413, code lost:
            r8 = r25;
            r11 = r30;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x0418, code lost:
            r21 = r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:118:0x041c, code lost:
            r2 = r4;
            r3 = r6;
            r4 = r7;
            r8 = r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:0x0422, code lost:
            r30 = r9;
            r10 = r21;
            r12 = r22;
            r22 = r20;
            r20 = r2;
            r5 = r12;
            r2 = r18;
            r35 = r20;
            r18 = r13;
            r13 = r14;
            r14 = r22;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:?, code lost:
            r35.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:?, code lost:
            r18.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:0x043d, code lost:
            r18 = r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:129:0x0445, code lost:
            if (W1.G.a(r0.f8490s) == false) goto L_0x0447;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:0x0447, code lost:
            kotlin.jvm.internal.m.d(r3, r19);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:0x044c, code lost:
            r16 = r1;
            r20 = r8;
            r10 = r29;
            r9 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:134:0x0459, code lost:
            if (m3.m.o(r3, r10, false, 2, (java.lang.Object) null) != false) goto L_0x045b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:136:?, code lost:
            r3 = o3.Y.c();
            r9 = new W1.G.b.d(r0.f8492u, r5, (V2.d) null);
            r0.f8472a = r7;
            r0.f8473b = r6;
            r0.f8474c = r4;
            r0.f8475d = r15;
            r0.f8476e = r13;
            r0.f8477f = null;
            r0.f8478g = null;
            r0.f8479h = null;
            r0.f8480i = null;
            r0.f8481j = null;
            r0.f8482k = null;
            r0.f8483l = r2;
            r0.f8484m = r14;
            r0.f8486o = r11;
            r1 = r16;
            r0.f8485n = r1;
            r16 = r1;
            r5 = r2;
            r1 = r20;
            r0.f8487p = r1;
            r0.f8488q = 4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:137:0x0495, code lost:
            r8 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:138:0x0497, code lost:
            if (o3.C0977g.g(r3, r9, r0) == r8) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:139:0x049b, code lost:
            r3 = r7;
            r7 = r6;
            r6 = r3;
            r3 = r14;
            r32 = r1;
            r1 = r4;
            r4 = r15;
            r2 = r16;
            r15 = r13;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:140:0x04a8, code lost:
            r17 = r4;
            r4 = r1;
            r1 = r17;
            r17 = r7;
            r7 = r6;
            r6 = r17;
            r25 = r32;
            r11 = r11;
            r14 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:141:0x04b8, code lost:
            r13 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:0x04bb, code lost:
            r8 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:144:0x04bd, code lost:
            r2 = r4;
            r3 = r6;
            r4 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x04c2, code lost:
            r5 = r2;
            r1 = r20;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x04c5, code lost:
            r8 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:147:0x04c8, code lost:
            r8 = r18;
            r2 = r4;
            r3 = r6;
            r4 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x04cf, code lost:
            r16 = r1;
            r5 = r2;
            r1 = r8;
            r10 = r29;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:150:0x04d6, code lost:
            r25 = r1;
            r1 = r15;
            r2 = r16;
            r15 = r13;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:151:0x04df, code lost:
            r8 = r21;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:153:0x04e2, code lost:
            r8 = r3;
            r2 = r4;
            r4 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:155:0x04e7, code lost:
            r1 = r35;
            r10 = r3;
            r19 = r5;
            r20 = r8;
            r8 = r18;
            r9 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:157:?, code lost:
            r6.f20985a = false;
            N1.k.f7778g.f();
            r7.f20985a = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:158:0x04fa, code lost:
            r2 = r1;
            r1 = r15;
            r11 = r27;
            r15 = r14;
            r14 = r20;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x0503, code lost:
            r3 = r14 + 1;
            r18 = r8;
            r14 = r15;
            r5 = r19;
            r15 = r1;
            r8 = r3;
            r3 = r10;
            r9 = r11;
            r11 = r25;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x0512, code lost:
            r17 = true;
            r2 = r4;
            r3 = r6;
            r4 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:162:0x0519, code lost:
            r8 = r18;
            r17 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:0x051d, code lost:
            r2 = r4;
            r3 = r6;
            r4 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x0520, code lost:
            r9 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:167:0x0522, code lost:
            r1 = r2;
            r8 = r18;
            r17 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:170:0x0529, code lost:
            if (r7.f20985a == false) goto L_0x0571;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:175:0x0537, code lost:
            N1.k.f7778g.Q(100);
            r1 = o3.Y.c();
            r2 = new W1.G.b.e(r0.f8492u, (V2.d) null);
            r0.f8472a = r7;
            r0.f8473b = r6;
            r0.f8474c = r4;
            r0.f8475d = null;
            r0.f8476e = null;
            r0.f8477f = null;
            r0.f8478g = null;
            r0.f8479h = null;
            r0.f8480i = null;
            r0.f8481j = null;
            r0.f8482k = null;
            r0.f8488q = 5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:176:0x0565, code lost:
            if (o3.C0977g.g(r1, r2, r0) == r8) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:177:0x0569, code lost:
            r2 = r4;
            r3 = r6;
            r4 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:178:0x056c, code lost:
            r6 = r3;
            r7 = r4;
            r9 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:180:0x0571, code lost:
            r9 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:181:0x0573, code lost:
            r8 = r1;
            r17 = true;
            r3 = r4;
            r4 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:188:0x058a, code lost:
            r1 = r0.f8491t.listFiles();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:189:0x0590, code lost:
            if (r1 != null) goto L_0x0592;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:190:0x0592, code lost:
            r2 = new java.util.ArrayList();
            S2.C1601o.v(r2, r1);
            r1 = o3.Y.c();
            r3 = new W1.G.b.f(r0.f8492u, r0.f8489r, r2, (V2.d) null);
            r0.f8472a = null;
            r0.f8473b = null;
            r0.f8474c = null;
            r0.f8475d = null;
            r0.f8476e = null;
            r0.f8477f = null;
            r0.f8478g = null;
            r0.f8479h = null;
            r0.f8480i = null;
            r0.f8481j = null;
            r0.f8482k = null;
            r0.f8488q = 6;
            r1 = o3.C0977g.g(r1, r3, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:191:0x05c5, code lost:
            if (r1 == r8) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:194:0x05d1, code lost:
            if (r4.isEmpty() == false) goto L_0x05d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:195:0x05d3, code lost:
            r1 = r4.size();
            r7 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:196:0x05d8, code lost:
            if (r7 < r1) goto L_0x05da;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:197:0x05da, code lost:
            r2 = r4.get(r7);
            r7 = r7 + 1;
            ((java.io.File) r2).delete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:198:0x05e6, code lost:
            N1.k.f7778g.f();
            r1 = o3.Y.c();
            r2 = new W1.G.b.g(r0.f8492u, (V2.d) null);
            r0.f8472a = null;
            r0.f8473b = null;
            r0.f8474c = null;
            r0.f8475d = null;
            r0.f8476e = null;
            r0.f8477f = null;
            r0.f8478g = null;
            r0.f8479h = null;
            r0.f8480i = null;
            r0.f8481j = null;
            r0.f8482k = null;
            r0.f8488q = 7;
            r1 = o3.C0977g.g(r1, r2, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:199:0x0614, code lost:
            if (r1 == r8) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:201:0x061a, code lost:
            r1 = r0.f8491t.listFiles();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:202:0x0620, code lost:
            if (r1 != null) goto L_0x0622;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:204:0x0623, code lost:
            if (r1.length != 0) goto L_0x0626;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:205:0x0626, code lost:
            r17 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:206:0x0628, code lost:
            if (r17 == false) goto L_0x062a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:207:0x062a, code lost:
            r2 = r1.length;
            r3 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:208:0x062c, code lost:
            if (r3 < r2) goto L_0x062e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:209:0x062e, code lost:
            r1[r3].delete();
            r3 = r3 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:211:0x063a, code lost:
            if (r4.isEmpty() == false) goto L_0x063c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:212:0x063c, code lost:
            r1 = r4.size();
            r9 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:213:0x0640, code lost:
            if (r9 < r1) goto L_0x0642;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:214:0x0642, code lost:
            ((java.io.File) r4.get(r9)).delete();
            r9 = r9 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:215:0x064e, code lost:
            N1.k.f7778g.f();
            r1 = o3.Y.c();
            r2 = new W1.G.b.h(r7, r6, r0.f8492u, (V2.d) null);
            r0.f8472a = null;
            r0.f8473b = null;
            r0.f8474c = null;
            r0.f8475d = null;
            r0.f8476e = null;
            r0.f8477f = null;
            r0.f8478g = null;
            r0.f8479h = null;
            r0.f8480i = null;
            r0.f8481j = null;
            r0.f8482k = null;
            r0.f8488q = 8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:216:0x067d, code lost:
            if (o3.C0977g.g(r1, r2, r0) == r8) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:222:?, code lost:
            return r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:223:?, code lost:
            return r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:224:?, code lost:
            return r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:225:?, code lost:
            return r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:226:?, code lost:
            return r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:227:?, code lost:
            return r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:228:?, code lost:
            return r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:229:?, code lost:
            return R2.s.f8222a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:230:?, code lost:
            return (R2.s) r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:231:?, code lost:
            return (R2.s) r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            r7 = new java.util.zip.ZipFile(r0.f8489r);
            r8 = r7.entries();
            r9 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x01a2, code lost:
            if (r8.hasMoreElements() == false) goto L_0x01b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x01ae, code lost:
            r9 = r9 + ((java.util.zip.ZipEntry) r8.nextElement()).getSize();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x01b0, code lost:
            r8 = r1;
            r3 = r4;
            r4 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
            r11 = java.lang.System.currentTimeMillis();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x01bd, code lost:
            r18 = r1;
            r15 = r7;
            r14 = r7.entries();
            r8 = 0;
            r13 = 0;
            r7 = r6;
            r6 = r4;
            r4 = r2;
            r2 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x01c9, code lost:
            if (r7.f20985a == false) goto L_0x0522;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x01d9, code lost:
            r1 = (java.util.zip.ZipEntry) r14.nextElement();
            r25 = r11;
            r11 = r1.getName();
            kotlin.jvm.internal.m.d(r11, r5);
            r35 = r2;
            r27 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x01f5, code lost:
            if (m3.m.o(r11, r3, false, 2, (java.lang.Object) null) == false) goto L_0x01f7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
            kotlin.jvm.internal.m.d(r11, r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x01ff, code lost:
            if (m3.m.o(r11, ".obb", false, 2, (java.lang.Object) null) == false) goto L_0x0202;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0202, code lost:
            r1 = r35;
            r10 = r3;
            r19 = r5;
            r20 = r8;
            r8 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x020d, code lost:
            r2 = r4;
            r3 = r6;
            r4 = r7;
            r8 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x0220, code lost:
            if (r1.getSize() < r0.f8491t.getUsableSpace()) goto L_0x0222;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
            r9 = new kotlin.jvm.internal.C();
            r9.f20968a = new java.io.File(r0.f8491t, r11);
            kotlin.jvm.internal.m.d(r11, r5);
            r29 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x023c, code lost:
            if (m3.m.o(r11, ".obb", false, 2, (java.lang.Object) null) != false) goto L_0x023e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
            kotlin.jvm.internal.m.d(r11, r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0247, code lost:
            if (m3.m.D(r11, "/", false, 2, (java.lang.Object) null) != false) goto L_0x0249;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0249, code lost:
            kotlin.jvm.internal.m.d(r11, r5);
            r2 = m3.m.R(r11, "/", 0, false, 6, (java.lang.Object) null);
            kotlin.jvm.internal.m.d(r11, r5);
            r3 = r11.substring(0, r2);
            kotlin.jvm.internal.m.d(r3, "this as java.lang.String…ing(startIndex, endIndex)");
            r10 = new java.io.File(android.os.Environment.getExternalStorageDirectory().toString() + '/' + r3);
            r10.mkdirs();
            kotlin.jvm.internal.m.d(r11, r5);
            r2 = r11.substring(r2 + 1);
            kotlin.jvm.internal.m.d(r2, "this as java.lang.String).substring(startIndex)");
            r12 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x029f, code lost:
            r12 = r11;
            r10 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x02a1, code lost:
            r2 = new java.io.File(r10, r12);
            r9.f20968a = r2;
            r4.add(r2);
            r2 = o3.Y.c();
            r3 = new W1.G.b.C0117b(r0.f8492u, r9, (V2.d) null);
            r0.f8472a = r7;
            r0.f8473b = r6;
            r0.f8474c = r4;
            r0.f8475d = r15;
            r0.f8476e = r14;
            r0.f8477f = r1;
            r0.f8478g = r12;
            r0.f8479h = r9;
            r0.f8480i = null;
            r0.f8481j = null;
            r0.f8482k = null;
            r0.f8483l = r13;
            r0.f8484m = r8;
            r10 = r27;
            r0.f8486o = r10;
            r19 = r1;
            r1 = r35;
            r0.f8485n = r1;
            r20 = r8;
            r35 = r9;
            r8 = r25;
            r0.f8487p = r8;
            r25 = r8;
            r0.f8488q = 2;
            r2 = o3.C0977g.g(r2, r3, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x02ed, code lost:
            r3 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x02ef, code lost:
            if (r2 == r3) goto L_0x02f1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x02f4, code lost:
            r2 = r20;
            r20 = r6;
            r6 = r2;
            r2 = r7;
            r8 = r10;
            r10 = r13;
            r13 = r19;
            r11 = r35;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x0300, code lost:
            r7 = r2;
            r27 = r8;
            r9 = r11;
            r11 = r12;
            r2 = r1;
            r8 = r6;
            r1 = r13;
            r13 = r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x030a, code lost:
            r19 = r1;
            r20 = r8;
            r3 = r18;
            r1 = r35;
            r35 = r9;
            r2 = r1;
            r1 = r19;
            r20 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
            r1 = r15.getInputStream(r1);
            kotlin.jvm.internal.m.d(r1, "zipFile.getInputStream(element)");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x0334, code lost:
            r18 = r2;
            r2 = r1;
            r1 = r18;
            r21 = r3;
            r19 = r5;
            r5 = r9;
            r3 = r11;
            r11 = new byte[8192];
            r18 = r13;
            r13 = new java.io.FileOutputStream((java.io.File) r9.f20968a);
            r12 = new kotlin.jvm.internal.A();
            r6 = r20;
            r9 = r27;
            r20 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
            r8 = r2.read(r11);
            r12.f20966a = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x0350, code lost:
            r22 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x0353, code lost:
            if (r8 == -1) goto L_0x0422;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
            r13.write(r11, 0, r8);
            r5 = r18 + r12.f20966a;
            r8 = r11;
            r23 = r12;
            r11 = (int) ((((double) r5) * 100.0d) / ((double) r9));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x036d, code lost:
            if (r11 <= (r1 + 5)) goto L_0x036f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x036f, code lost:
            r35 = r8;
            r30 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x037e, code lost:
            if (java.lang.System.currentTimeMillis() <= (r25 + ((long) 1000))) goto L_0x0383;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:123:0x043a */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x0395 A[Catch:{ Exception -> 0x038e }] */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x03f4  */
        /* JADX WARNING: Removed duplicated region for block: B:120:0x0422  */
        /* JADX WARNING: Removed duplicated region for block: B:130:0x0447 A[Catch:{ Exception -> 0x04bb }] */
        /* JADX WARNING: Removed duplicated region for block: B:149:0x04cf  */
        /* JADX WARNING: Removed duplicated region for block: B:167:0x0522  */
        /* JADX WARNING: Removed duplicated region for block: B:188:0x058a  */
        /* JADX WARNING: Removed duplicated region for block: B:201:0x061a  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x01d9 A[Catch:{ Exception -> 0x0519 }] */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x0355  */
        /* JADX WARNING: Removed duplicated region for block: B:98:0x036f A[Catch:{ Exception -> 0x038e }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r35) {
            /*
                r34 = this;
                r0 = r34
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.f8488q
                java.lang.String r3 = ".apk"
                java.lang.String r5 = "entryName"
                switch(r2) {
                    case 0: goto L_0x0145;
                    case 1: goto L_0x0135;
                    case 2: goto L_0x00ee;
                    case 3: goto L_0x007f;
                    case 4: goto L_0x0044;
                    case 5: goto L_0x002a;
                    case 6: goto L_0x0023;
                    case 7: goto L_0x001c;
                    case 8: goto L_0x0017;
                    default: goto L_0x000f;
                }
            L_0x000f:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0017:
                R2.n.b(r35)
                goto L_0x0680
            L_0x001c:
                R2.n.b(r35)
                r1 = r35
                goto L_0x0617
            L_0x0023:
                R2.n.b(r35)
                r1 = r35
                goto L_0x05c9
            L_0x002a:
                java.lang.Object r2 = r0.f8474c
                java.util.ArrayList r2 = (java.util.ArrayList) r2
                java.lang.Object r3 = r0.f8473b
                kotlin.jvm.internal.z r3 = (kotlin.jvm.internal.z) r3
                java.lang.Object r4 = r0.f8472a
                kotlin.jvm.internal.z r4 = (kotlin.jvm.internal.z) r4
                R2.n.b(r35)     // Catch:{ Exception -> 0x003e }
                r8 = r1
                r17 = 1
                goto L_0x056c
            L_0x003e:
                r8 = r1
            L_0x003f:
                r9 = 0
            L_0x0040:
                r17 = 1
                goto L_0x0579
            L_0x0044:
                long r9 = r0.f8487p
                int r2 = r0.f8485n
                long r11 = r0.f8486o
                int r13 = r0.f8484m
                int r14 = r0.f8483l
                java.lang.Object r15 = r0.f8476e
                java.util.Enumeration r15 = (java.util.Enumeration) r15
                java.lang.Object r4 = r0.f8475d
                java.util.zip.ZipFile r4 = (java.util.zip.ZipFile) r4
                java.lang.Object r8 = r0.f8474c
                java.util.ArrayList r8 = (java.util.ArrayList) r8
                java.lang.Object r7 = r0.f8473b
                kotlin.jvm.internal.z r7 = (kotlin.jvm.internal.z) r7
                java.lang.Object r6 = r0.f8472a
                kotlin.jvm.internal.z r6 = (kotlin.jvm.internal.z) r6
                R2.n.b(r35)     // Catch:{ Exception -> 0x0076 }
                r19 = r8
                r8 = r1
                r1 = r19
                r19 = r5
                r5 = r14
                r32 = r9
                r10 = r3
                r3 = r13
            L_0x0071:
                r13 = r11
                r11 = r32
                goto L_0x04a8
            L_0x0076:
                r4 = r6
                r3 = r7
                r2 = r8
                r9 = 0
                r17 = 1
                r8 = r1
                goto L_0x0579
            L_0x007f:
                long r6 = r0.f8487p
                int r2 = r0.f8485n
                long r8 = r0.f8486o
                int r4 = r0.f8484m
                int r10 = r0.f8483l
                java.lang.Object r11 = r0.f8482k
                byte[] r11 = (byte[]) r11
                java.lang.Object r12 = r0.f8481j
                kotlin.jvm.internal.A r12 = (kotlin.jvm.internal.A) r12
                java.lang.Object r13 = r0.f8480i
                java.io.FileOutputStream r13 = (java.io.FileOutputStream) r13
                java.lang.Object r14 = r0.f8479h
                kotlin.jvm.internal.C r14 = (kotlin.jvm.internal.C) r14
                java.lang.Object r15 = r0.f8478g
                java.lang.String r15 = (java.lang.String) r15
                r18 = r2
                java.lang.Object r2 = r0.f8477f
                java.util.Enumeration r2 = (java.util.Enumeration) r2
                r19 = r2
                java.lang.Object r2 = r0.f8476e
                java.io.InputStream r2 = (java.io.InputStream) r2
                r20 = r2
                java.lang.Object r2 = r0.f8475d
                java.util.zip.ZipFile r2 = (java.util.zip.ZipFile) r2
                r21 = r2
                java.lang.Object r2 = r0.f8474c
                java.util.ArrayList r2 = (java.util.ArrayList) r2
                r22 = r2
                java.lang.Object r2 = r0.f8473b
                kotlin.jvm.internal.z r2 = (kotlin.jvm.internal.z) r2
                r23 = r2
                java.lang.Object r2 = r0.f8472a
                kotlin.jvm.internal.z r2 = (kotlin.jvm.internal.z) r2
                R2.n.b(r35)     // Catch:{ Exception -> 0x00e6 }
                r25 = r10
                r10 = r1
                r1 = r18
                r18 = r25
                r25 = r19
                r19 = r5
                r5 = r14
                r14 = r25
                r29 = r3
                r25 = r6
                r30 = r8
                r3 = r15
                r15 = r21
                r6 = r23
                r7 = r2
                r2 = r20
                r20 = r4
                r4 = r22
                goto L_0x0402
            L_0x00e6:
                r8 = r1
                r4 = r2
                r2 = r22
                r3 = r23
                goto L_0x003f
            L_0x00ee:
                long r6 = r0.f8487p
                int r2 = r0.f8485n
                long r8 = r0.f8486o
                int r4 = r0.f8484m
                int r10 = r0.f8483l
                java.lang.Object r11 = r0.f8479h
                kotlin.jvm.internal.C r11 = (kotlin.jvm.internal.C) r11
                java.lang.Object r12 = r0.f8478g
                java.lang.String r12 = (java.lang.String) r12
                java.lang.Object r13 = r0.f8477f
                java.util.zip.ZipEntry r13 = (java.util.zip.ZipEntry) r13
                java.lang.Object r14 = r0.f8476e
                java.util.Enumeration r14 = (java.util.Enumeration) r14
                java.lang.Object r15 = r0.f8475d
                java.util.zip.ZipFile r15 = (java.util.zip.ZipFile) r15
                r18 = r2
                java.lang.Object r2 = r0.f8474c
                java.util.ArrayList r2 = (java.util.ArrayList) r2
                r19 = r2
                java.lang.Object r2 = r0.f8473b
                kotlin.jvm.internal.z r2 = (kotlin.jvm.internal.z) r2
                r20 = r2
                java.lang.Object r2 = r0.f8472a
                kotlin.jvm.internal.z r2 = (kotlin.jvm.internal.z) r2
                R2.n.b(r35)     // Catch:{ Exception -> 0x012d }
                r29 = r3
                r25 = r6
                r3 = r1
                r6 = r4
                r1 = r18
                r4 = r19
                goto L_0x0300
            L_0x012d:
                r8 = r1
                r4 = r2
                r2 = r19
            L_0x0131:
                r3 = r20
                goto L_0x003f
            L_0x0135:
                java.lang.Object r2 = r0.f8474c
                java.util.ArrayList r2 = (java.util.ArrayList) r2
                java.lang.Object r4 = r0.f8473b
                kotlin.jvm.internal.z r4 = (kotlin.jvm.internal.z) r4
                java.lang.Object r6 = r0.f8472a
                kotlin.jvm.internal.z r6 = (kotlin.jvm.internal.z) r6
                R2.n.b(r35)
                goto L_0x0191
            L_0x0145:
                R2.n.b(r35)
                kotlin.jvm.internal.z r2 = new kotlin.jvm.internal.z
                r2.<init>()
                r4 = 1
                r2.f20985a = r4
                kotlin.jvm.internal.z r6 = new kotlin.jvm.internal.z
                r6.<init>()
                r6.f20985a = r4
                java.util.ArrayList r4 = new java.util.ArrayList
                r4.<init>()
                N1.k$a r7 = N1.k.f7778g
                java.io.File r8 = r0.f8489r
                java.lang.String r8 = r8.getAbsolutePath()
                java.lang.String r9 = "fileZipped.absolutePath"
                kotlin.jvm.internal.m.d(r8, r9)
                r9 = 0
                r7.z(r8, r9)
                o3.E0 r7 = o3.Y.c()
                W1.G$b$a r8 = new W1.G$b$a
                S1.m r9 = r0.f8492u
                r10 = 0
                r8.<init>(r9, r10)
                r0.f8472a = r2
                r0.f8473b = r6
                r0.f8474c = r4
                r9 = 1
                r0.f8488q = r9
                java.lang.Object r7 = o3.C0977g.g(r7, r8, r0)
                if (r7 != r1) goto L_0x018b
                r8 = r1
                goto L_0x067f
            L_0x018b:
                r32 = r6
                r6 = r2
                r2 = r4
                r4 = r32
            L_0x0191:
                java.util.zip.ZipFile r7 = new java.util.zip.ZipFile     // Catch:{ Exception -> 0x0573 }
                java.io.File r8 = r0.f8489r     // Catch:{ Exception -> 0x0573 }
                r7.<init>(r8)     // Catch:{ Exception -> 0x0573 }
                java.util.Enumeration r8 = r7.entries()     // Catch:{ Exception -> 0x0573 }
                r9 = 0
            L_0x019e:
                boolean r11 = r8.hasMoreElements()     // Catch:{ Exception -> 0x0573 }
                if (r11 == 0) goto L_0x01b5
                java.lang.Object r11 = r8.nextElement()     // Catch:{ Exception -> 0x01b0 }
                java.util.zip.ZipEntry r11 = (java.util.zip.ZipEntry) r11     // Catch:{ Exception -> 0x01b0 }
                long r11 = r11.getSize()     // Catch:{ Exception -> 0x01b0 }
                long r9 = r9 + r11
                goto L_0x019e
            L_0x01b0:
                r8 = r1
                r3 = r4
                r4 = r6
                goto L_0x003f
            L_0x01b5:
                long r11 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0573 }
                java.util.Enumeration r8 = r7.entries()     // Catch:{ Exception -> 0x0573 }
                r18 = r1
                r15 = r7
                r14 = r8
                r8 = 0
                r13 = 0
                r7 = r6
                r6 = r4
                r4 = r2
                r2 = 0
            L_0x01c7:
                boolean r1 = r7.f20985a     // Catch:{ Exception -> 0x0519 }
                if (r1 == 0) goto L_0x0522
                W1.G r1 = r0.f8490s     // Catch:{ Exception -> 0x0519 }
                boolean r1 = r1.f8471a     // Catch:{ Exception -> 0x0519 }
                if (r1 != 0) goto L_0x0522
                boolean r1 = r14.hasMoreElements()     // Catch:{ Exception -> 0x0519 }
                if (r1 == 0) goto L_0x0522
                java.lang.Object r1 = r14.nextElement()     // Catch:{ Exception -> 0x0519 }
                java.util.zip.ZipEntry r1 = (java.util.zip.ZipEntry) r1     // Catch:{ Exception -> 0x0519 }
                r25 = r11
                java.lang.String r11 = r1.getName()     // Catch:{ Exception -> 0x0519 }
                kotlin.jvm.internal.m.d(r11, r5)     // Catch:{ Exception -> 0x0519 }
                r35 = r2
                r27 = r9
                r2 = 0
                r9 = 0
                r12 = 2
                boolean r10 = m3.m.o(r11, r3, r2, r12, r9)     // Catch:{ Exception -> 0x0519 }
                java.lang.String r2 = ".obb"
                if (r10 != 0) goto L_0x0214
                kotlin.jvm.internal.m.d(r11, r5)     // Catch:{ Exception -> 0x020d }
                r10 = 0
                boolean r19 = m3.m.o(r11, r2, r10, r12, r9)     // Catch:{ Exception -> 0x020d }
                if (r19 == 0) goto L_0x0202
                goto L_0x0214
            L_0x0202:
                r1 = r35
                r10 = r3
                r19 = r5
                r20 = r8
                r8 = r18
                goto L_0x04fa
            L_0x020d:
                r2 = r4
                r3 = r6
                r4 = r7
                r8 = r18
                goto L_0x003f
            L_0x0214:
                long r9 = r1.getSize()     // Catch:{ Exception -> 0x0519 }
                java.io.File r12 = r0.f8491t     // Catch:{ Exception -> 0x0519 }
                long r19 = r12.getUsableSpace()     // Catch:{ Exception -> 0x0519 }
                int r12 = (r9 > r19 ? 1 : (r9 == r19 ? 0 : -1))
                if (r12 >= 0) goto L_0x04e7
                kotlin.jvm.internal.C r9 = new kotlin.jvm.internal.C     // Catch:{ Exception -> 0x04bb }
                r9.<init>()     // Catch:{ Exception -> 0x04bb }
                java.io.File r10 = new java.io.File     // Catch:{ Exception -> 0x04bb }
                java.io.File r12 = r0.f8491t     // Catch:{ Exception -> 0x04bb }
                r10.<init>(r12, r11)     // Catch:{ Exception -> 0x04bb }
                r9.f20968a = r10     // Catch:{ Exception -> 0x04bb }
                kotlin.jvm.internal.m.d(r11, r5)     // Catch:{ Exception -> 0x04bb }
                r29 = r3
                r3 = 0
                r10 = 0
                r12 = 2
                boolean r2 = m3.m.o(r11, r2, r10, r12, r3)     // Catch:{ Exception -> 0x04bb }
                if (r2 == 0) goto L_0x030a
                kotlin.jvm.internal.m.d(r11, r5)     // Catch:{ Exception -> 0x020d }
                java.lang.String r2 = "/"
                boolean r2 = m3.m.D(r11, r2, r10, r12, r3)     // Catch:{ Exception -> 0x020d }
                if (r2 == 0) goto L_0x029f
                kotlin.jvm.internal.m.d(r11, r5)     // Catch:{ Exception -> 0x020d }
                java.lang.String r20 = "/"
                r23 = 6
                r24 = 0
                r21 = 0
                r22 = 0
                r19 = r11
                int r2 = m3.m.R(r19, r20, r21, r22, r23, r24)     // Catch:{ Exception -> 0x020d }
                kotlin.jvm.internal.m.d(r11, r5)     // Catch:{ Exception -> 0x020d }
                r10 = 0
                java.lang.String r3 = r11.substring(r10, r2)     // Catch:{ Exception -> 0x020d }
                java.lang.String r10 = "this as java.lang.String…ing(startIndex, endIndex)"
                kotlin.jvm.internal.m.d(r3, r10)     // Catch:{ Exception -> 0x020d }
                java.io.File r10 = new java.io.File     // Catch:{ Exception -> 0x020d }
                java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x020d }
                r12.<init>()     // Catch:{ Exception -> 0x020d }
                java.io.File r19 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x020d }
                r20 = r2
                java.lang.String r2 = r19.toString()     // Catch:{ Exception -> 0x020d }
                r12.append(r2)     // Catch:{ Exception -> 0x020d }
                r2 = 47
                r12.append(r2)     // Catch:{ Exception -> 0x020d }
                r12.append(r3)     // Catch:{ Exception -> 0x020d }
                java.lang.String r2 = r12.toString()     // Catch:{ Exception -> 0x020d }
                r10.<init>(r2)     // Catch:{ Exception -> 0x020d }
                r10.mkdirs()     // Catch:{ Exception -> 0x020d }
                kotlin.jvm.internal.m.d(r11, r5)     // Catch:{ Exception -> 0x020d }
                int r2 = r20 + 1
                java.lang.String r2 = r11.substring(r2)     // Catch:{ Exception -> 0x020d }
                java.lang.String r3 = "this as java.lang.String).substring(startIndex)"
                kotlin.jvm.internal.m.d(r2, r3)     // Catch:{ Exception -> 0x020d }
                r12 = r2
                goto L_0x02a1
            L_0x029f:
                r12 = r11
                r10 = 0
            L_0x02a1:
                java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x020d }
                r2.<init>(r10, r12)     // Catch:{ Exception -> 0x020d }
                r9.f20968a = r2     // Catch:{ Exception -> 0x020d }
                r4.add(r2)     // Catch:{ Exception -> 0x020d }
                o3.E0 r2 = o3.Y.c()     // Catch:{ Exception -> 0x020d }
                W1.G$b$b r3 = new W1.G$b$b     // Catch:{ Exception -> 0x020d }
                S1.m r10 = r0.f8492u     // Catch:{ Exception -> 0x020d }
                r11 = 0
                r3.<init>(r10, r9, r11)     // Catch:{ Exception -> 0x020d }
                r0.f8472a = r7     // Catch:{ Exception -> 0x020d }
                r0.f8473b = r6     // Catch:{ Exception -> 0x020d }
                r0.f8474c = r4     // Catch:{ Exception -> 0x020d }
                r0.f8475d = r15     // Catch:{ Exception -> 0x020d }
                r0.f8476e = r14     // Catch:{ Exception -> 0x020d }
                r0.f8477f = r1     // Catch:{ Exception -> 0x020d }
                r0.f8478g = r12     // Catch:{ Exception -> 0x020d }
                r0.f8479h = r9     // Catch:{ Exception -> 0x020d }
                r10 = 0
                r0.f8480i = r10     // Catch:{ Exception -> 0x020d }
                r0.f8481j = r10     // Catch:{ Exception -> 0x020d }
                r0.f8482k = r10     // Catch:{ Exception -> 0x020d }
                r0.f8483l = r13     // Catch:{ Exception -> 0x020d }
                r0.f8484m = r8     // Catch:{ Exception -> 0x020d }
                r10 = r27
                r0.f8486o = r10     // Catch:{ Exception -> 0x020d }
                r19 = r1
                r1 = r35
                r0.f8485n = r1     // Catch:{ Exception -> 0x020d }
                r20 = r8
                r35 = r9
                r8 = r25
                r0.f8487p = r8     // Catch:{ Exception -> 0x020d }
                r25 = r8
                r8 = 2
                r0.f8488q = r8     // Catch:{ Exception -> 0x020d }
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)     // Catch:{ Exception -> 0x020d }
                r3 = r18
                if (r2 != r3) goto L_0x02f4
                r8 = r3
                goto L_0x067f
            L_0x02f4:
                r2 = r20
                r20 = r6
                r6 = r2
                r2 = r7
                r8 = r10
                r10 = r13
                r13 = r19
                r11 = r35
            L_0x0300:
                r7 = r2
                r27 = r8
                r9 = r11
                r11 = r12
                r2 = r1
                r8 = r6
                r1 = r13
                r13 = r10
                goto L_0x0319
            L_0x030a:
                r19 = r1
                r20 = r8
                r3 = r18
                r1 = r35
                r35 = r9
                r2 = r1
                r1 = r19
                r20 = r6
            L_0x0319:
                java.io.InputStream r1 = r15.getInputStream(r1)     // Catch:{ Exception -> 0x04e2 }
                java.lang.String r6 = "zipFile.getInputStream(element)"
                kotlin.jvm.internal.m.d(r1, r6)     // Catch:{ Exception -> 0x04e2 }
                java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x04e2 }
                java.lang.Object r10 = r9.f20968a     // Catch:{ Exception -> 0x04e2 }
                java.io.File r10 = (java.io.File) r10     // Catch:{ Exception -> 0x04e2 }
                r6.<init>(r10)     // Catch:{ Exception -> 0x04e2 }
                kotlin.jvm.internal.A r10 = new kotlin.jvm.internal.A     // Catch:{ Exception -> 0x04e2 }
                r10.<init>()     // Catch:{ Exception -> 0x04e2 }
                r12 = 8192(0x2000, float:1.14794E-41)
                byte[] r12 = new byte[r12]     // Catch:{ Exception -> 0x04e2 }
                r18 = r2
                r2 = r1
                r1 = r18
                r21 = r3
                r19 = r5
                r5 = r9
                r3 = r11
                r11 = r12
                r18 = r13
                r13 = r6
                r12 = r10
                r6 = r20
                r9 = r27
                r20 = r8
            L_0x034a:
                int r8 = r2.read(r11)     // Catch:{ Exception -> 0x04df }
                r12.f20966a = r8     // Catch:{ Exception -> 0x04df }
                r22 = r5
                r5 = -1
                if (r8 == r5) goto L_0x0422
                r5 = 0
                r13.write(r11, r5, r8)     // Catch:{ Exception -> 0x038e }
                int r5 = r12.f20966a     // Catch:{ Exception -> 0x038e }
                int r5 = r18 + r5
                r8 = r11
                r23 = r12
                double r11 = (double) r5     // Catch:{ Exception -> 0x038e }
                r27 = 4636737291354636288(0x4059000000000000, double:100.0)
                double r11 = r11 * r27
                r27 = r11
                double r11 = (double) r9     // Catch:{ Exception -> 0x038e }
                double r11 = r27 / r11
                int r11 = (int) r11     // Catch:{ Exception -> 0x038e }
                int r12 = r1 + 5
                if (r11 > r12) goto L_0x0395
                long r27 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x038e }
                r12 = 1000(0x3e8, float:1.401E-42)
                r35 = r8
                r30 = r9
                long r8 = (long) r12     // Catch:{ Exception -> 0x038e }
                long r8 = r25 + r8
                int r10 = (r27 > r8 ? 1 : (r27 == r8 ? 0 : -1))
                if (r10 <= 0) goto L_0x0383
                if (r11 == r1) goto L_0x0383
                goto L_0x0399
            L_0x0383:
                r11 = r35
                r18 = r5
                r5 = r22
                r12 = r23
            L_0x038b:
                r9 = r30
                goto L_0x034a
            L_0x038e:
                r2 = r4
                r3 = r6
                r4 = r7
                r8 = r21
                goto L_0x003f
            L_0x0395:
                r35 = r8
                r30 = r9
            L_0x0399:
                long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x038e }
                N1.k$a r1 = N1.k.f7778g     // Catch:{ Exception -> 0x038e }
                r1.Q(r11)     // Catch:{ Exception -> 0x038e }
                o3.E0 r1 = o3.Y.c()     // Catch:{ Exception -> 0x038e }
                W1.G$b$c r10 = new W1.G$b$c     // Catch:{ Exception -> 0x038e }
                S1.m r12 = r0.f8492u     // Catch:{ Exception -> 0x038e }
                r18 = r1
                r1 = 0
                r10.<init>(r12, r11, r1)     // Catch:{ Exception -> 0x038e }
                r0.f8472a = r7     // Catch:{ Exception -> 0x038e }
                r0.f8473b = r6     // Catch:{ Exception -> 0x038e }
                r0.f8474c = r4     // Catch:{ Exception -> 0x038e }
                r0.f8475d = r15     // Catch:{ Exception -> 0x038e }
                r0.f8476e = r2     // Catch:{ Exception -> 0x038e }
                r0.f8477f = r14     // Catch:{ Exception -> 0x038e }
                r0.f8478g = r3     // Catch:{ Exception -> 0x038e }
                r12 = r22
                r0.f8479h = r12     // Catch:{ Exception -> 0x038e }
                r0.f8480i = r13     // Catch:{ Exception -> 0x038e }
                r1 = r23
                r0.f8481j = r1     // Catch:{ Exception -> 0x038e }
                r23 = r1
                r1 = r35
                r0.f8482k = r1     // Catch:{ Exception -> 0x038e }
                r0.f8483l = r5     // Catch:{ Exception -> 0x038e }
                r35 = r1
                r1 = r20
                r0.f8484m = r1     // Catch:{ Exception -> 0x038e }
                r22 = r1
                r20 = r2
                r1 = r30
                r0.f8486o = r1     // Catch:{ Exception -> 0x038e }
                r0.f8485n = r11     // Catch:{ Exception -> 0x038e }
                r0.f8487p = r8     // Catch:{ Exception -> 0x038e }
                r30 = r1
                r1 = 3
                r0.f8488q = r1     // Catch:{ Exception -> 0x038e }
                r1 = r18
                java.lang.Object r1 = o3.C0977g.g(r1, r10, r0)     // Catch:{ Exception -> 0x038e }
                r10 = r21
                if (r1 != r10) goto L_0x03f4
                r8 = r10
                goto L_0x067f
            L_0x03f4:
                r18 = r5
                r25 = r8
                r1 = r11
                r5 = r12
                r2 = r20
                r20 = r22
                r12 = r23
                r11 = r35
            L_0x0402:
                W1.G r8 = r0.f8490s     // Catch:{ Exception -> 0x041c }
                boolean r8 = r8.f8471a     // Catch:{ Exception -> 0x041c }
                if (r8 == 0) goto L_0x0418
                r35 = r2
                r2 = r18
                r18 = r13
                r13 = r14
                r14 = r20
            L_0x0413:
                r8 = r25
                r11 = r30
                goto L_0x0437
            L_0x0418:
                r21 = r10
                goto L_0x038b
            L_0x041c:
                r2 = r4
                r3 = r6
                r4 = r7
                r8 = r10
                goto L_0x003f
            L_0x0422:
                r30 = r9
                r10 = r21
                r12 = r22
                r22 = r20
                r20 = r2
                r5 = r12
                r2 = r18
                r35 = r20
                r18 = r13
                r13 = r14
                r14 = r22
                goto L_0x0413
            L_0x0437:
                r35.close()     // Catch:{ IOException -> 0x043a }
            L_0x043a:
                r18.close()     // Catch:{ IOException -> 0x043d }
            L_0x043d:
                r18 = r10
                W1.G r10 = r0.f8490s     // Catch:{ Exception -> 0x04bb }
                boolean r10 = r10.f8471a     // Catch:{ Exception -> 0x04bb }
                if (r10 != 0) goto L_0x04cf
                r10 = r19
                kotlin.jvm.internal.m.d(r3, r10)     // Catch:{ Exception -> 0x04bb }
                r16 = r1
                r20 = r8
                r10 = r29
                r1 = 0
                r8 = 2
                r9 = 0
                boolean r3 = m3.m.o(r3, r10, r9, r8, r1)     // Catch:{ Exception -> 0x04c8 }
                if (r3 == 0) goto L_0x04c2
                o3.E0 r3 = o3.Y.c()     // Catch:{ Exception -> 0x04bb }
                W1.G$b$d r9 = new W1.G$b$d     // Catch:{ Exception -> 0x04bb }
                S1.m r8 = r0.f8492u     // Catch:{ Exception -> 0x04bb }
                r9.<init>(r8, r5, r1)     // Catch:{ Exception -> 0x04bb }
                r0.f8472a = r7     // Catch:{ Exception -> 0x04bb }
                r0.f8473b = r6     // Catch:{ Exception -> 0x04bb }
                r0.f8474c = r4     // Catch:{ Exception -> 0x04bb }
                r0.f8475d = r15     // Catch:{ Exception -> 0x04bb }
                r0.f8476e = r13     // Catch:{ Exception -> 0x04bb }
                r1 = 0
                r0.f8477f = r1     // Catch:{ Exception -> 0x04bb }
                r0.f8478g = r1     // Catch:{ Exception -> 0x04bb }
                r0.f8479h = r1     // Catch:{ Exception -> 0x04bb }
                r0.f8480i = r1     // Catch:{ Exception -> 0x04bb }
                r0.f8481j = r1     // Catch:{ Exception -> 0x04bb }
                r0.f8482k = r1     // Catch:{ Exception -> 0x04bb }
                r0.f8483l = r2     // Catch:{ Exception -> 0x04bb }
                r0.f8484m = r14     // Catch:{ Exception -> 0x04bb }
                r0.f8486o = r11     // Catch:{ Exception -> 0x04bb }
                r1 = r16
                r0.f8485n = r1     // Catch:{ Exception -> 0x04bb }
                r16 = r1
                r5 = r2
                r1 = r20
                r0.f8487p = r1     // Catch:{ Exception -> 0x04bb }
                r8 = 4
                r0.f8488q = r8     // Catch:{ Exception -> 0x04bb }
                java.lang.Object r3 = o3.C0977g.g(r3, r9, r0)     // Catch:{ Exception -> 0x04bb }
                r8 = r18
                if (r3 != r8) goto L_0x049b
                goto L_0x067f
            L_0x049b:
                r3 = r7
                r7 = r6
                r6 = r3
                r3 = r14
                r32 = r1
                r1 = r4
                r4 = r15
                r2 = r16
                r15 = r13
                goto L_0x0071
            L_0x04a8:
                r17 = r4
                r4 = r1
                r1 = r17
                r17 = r7
                r7 = r6
                r6 = r17
                r25 = r11
                r11 = r13
                r17 = 1
                r14 = r3
            L_0x04b8:
                r13 = r5
                goto L_0x0503
            L_0x04bb:
                r8 = r18
            L_0x04bd:
                r2 = r4
                r3 = r6
                r4 = r7
                goto L_0x003f
            L_0x04c2:
                r5 = r2
                r1 = r20
            L_0x04c5:
                r8 = r18
                goto L_0x04d6
            L_0x04c8:
                r8 = r18
                r2 = r4
                r3 = r6
                r4 = r7
                goto L_0x0040
            L_0x04cf:
                r16 = r1
                r5 = r2
                r1 = r8
                r10 = r29
                goto L_0x04c5
            L_0x04d6:
                r25 = r1
                r1 = r15
                r2 = r16
                r17 = 1
                r15 = r13
                goto L_0x04b8
            L_0x04df:
                r8 = r21
                goto L_0x04bd
            L_0x04e2:
                r8 = r3
                r2 = r4
                r4 = r7
                goto L_0x0131
            L_0x04e7:
                r1 = r35
                r10 = r3
                r19 = r5
                r20 = r8
                r8 = r18
                r9 = 0
                r6.f20985a = r9     // Catch:{ Exception -> 0x0512 }
                N1.k$a r2 = N1.k.f7778g     // Catch:{ Exception -> 0x0512 }
                r2.f()     // Catch:{ Exception -> 0x0512 }
                r7.f20985a = r9     // Catch:{ Exception -> 0x0512 }
            L_0x04fa:
                r2 = r1
                r1 = r15
                r11 = r27
                r17 = 1
                r15 = r14
                r14 = r20
            L_0x0503:
                int r3 = r14 + 1
                r18 = r8
                r14 = r15
                r5 = r19
                r15 = r1
                r8 = r3
                r3 = r10
                r9 = r11
                r11 = r25
                goto L_0x01c7
            L_0x0512:
                r17 = 1
                r2 = r4
                r3 = r6
                r4 = r7
                goto L_0x0579
            L_0x0519:
                r8 = r18
                r17 = 1
            L_0x051d:
                r2 = r4
                r3 = r6
                r4 = r7
            L_0x0520:
                r9 = 0
                goto L_0x0579
            L_0x0522:
                r1 = r2
                r8 = r18
                r17 = 1
                boolean r2 = r7.f20985a     // Catch:{ Exception -> 0x051d }
                if (r2 == 0) goto L_0x0571
                W1.G r2 = r0.f8490s     // Catch:{ Exception -> 0x051d }
                boolean r2 = r2.f8471a     // Catch:{ Exception -> 0x051d }
                if (r2 != 0) goto L_0x0571
                r2 = 100
                if (r1 >= r2) goto L_0x0571
                N1.k$a r1 = N1.k.f7778g     // Catch:{ Exception -> 0x051d }
                r1.Q(r2)     // Catch:{ Exception -> 0x051d }
                o3.E0 r1 = o3.Y.c()     // Catch:{ Exception -> 0x051d }
                W1.G$b$e r2 = new W1.G$b$e     // Catch:{ Exception -> 0x051d }
                S1.m r3 = r0.f8492u     // Catch:{ Exception -> 0x051d }
                r10 = 0
                r2.<init>(r3, r10)     // Catch:{ Exception -> 0x051d }
                r0.f8472a = r7     // Catch:{ Exception -> 0x051d }
                r0.f8473b = r6     // Catch:{ Exception -> 0x051d }
                r0.f8474c = r4     // Catch:{ Exception -> 0x051d }
                r0.f8475d = r10     // Catch:{ Exception -> 0x051d }
                r0.f8476e = r10     // Catch:{ Exception -> 0x051d }
                r0.f8477f = r10     // Catch:{ Exception -> 0x051d }
                r0.f8478g = r10     // Catch:{ Exception -> 0x051d }
                r0.f8479h = r10     // Catch:{ Exception -> 0x051d }
                r0.f8480i = r10     // Catch:{ Exception -> 0x051d }
                r0.f8481j = r10     // Catch:{ Exception -> 0x051d }
                r0.f8482k = r10     // Catch:{ Exception -> 0x051d }
                r3 = 5
                r0.f8488q = r3     // Catch:{ Exception -> 0x051d }
                java.lang.Object r1 = o3.C0977g.g(r1, r2, r0)     // Catch:{ Exception -> 0x051d }
                if (r1 != r8) goto L_0x0569
                goto L_0x067f
            L_0x0569:
                r2 = r4
                r3 = r6
                r4 = r7
            L_0x056c:
                r6 = r3
                r7 = r4
                r9 = 0
            L_0x056f:
                r4 = r2
                goto L_0x057e
            L_0x0571:
                r9 = 0
                goto L_0x057e
            L_0x0573:
                r8 = r1
                r17 = 1
                r3 = r4
                r4 = r6
                goto L_0x0520
            L_0x0579:
                r4.f20985a = r9
                r6 = r3
                r7 = r4
                goto L_0x056f
            L_0x057e:
                boolean r1 = r7.f20985a
                if (r1 == 0) goto L_0x061a
                W1.G r1 = r0.f8490s
                boolean r1 = r1.f8471a
                if (r1 != 0) goto L_0x061a
                java.io.File r1 = r0.f8491t
                java.io.File[] r1 = r1.listFiles()
                if (r1 == 0) goto L_0x05cd
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                S2.C1601o.v(r2, r1)
                o3.E0 r1 = o3.Y.c()
                W1.G$b$f r3 = new W1.G$b$f
                S1.m r4 = r0.f8492u
                java.io.File r5 = r0.f8489r
                r10 = 0
                r3.<init>(r4, r5, r2, r10)
                r0.f8472a = r10
                r0.f8473b = r10
                r0.f8474c = r10
                r0.f8475d = r10
                r0.f8476e = r10
                r0.f8477f = r10
                r0.f8478g = r10
                r0.f8479h = r10
                r0.f8480i = r10
                r0.f8481j = r10
                r0.f8482k = r10
                r2 = 6
                r0.f8488q = r2
                java.lang.Object r1 = o3.C0977g.g(r1, r3, r0)
                if (r1 != r8) goto L_0x05c9
                goto L_0x067f
            L_0x05c9:
                R2.s r1 = (R2.s) r1
                goto L_0x0682
            L_0x05cd:
                boolean r1 = r4.isEmpty()
                if (r1 != 0) goto L_0x05e6
                int r1 = r4.size()
                r7 = 0
            L_0x05d8:
                if (r7 >= r1) goto L_0x05e6
                java.lang.Object r2 = r4.get(r7)
                int r7 = r7 + 1
                java.io.File r2 = (java.io.File) r2
                r2.delete()
                goto L_0x05d8
            L_0x05e6:
                N1.k$a r1 = N1.k.f7778g
                r1.f()
                o3.E0 r1 = o3.Y.c()
                W1.G$b$g r2 = new W1.G$b$g
                S1.m r3 = r0.f8492u
                r10 = 0
                r2.<init>(r3, r10)
                r0.f8472a = r10
                r0.f8473b = r10
                r0.f8474c = r10
                r0.f8475d = r10
                r0.f8476e = r10
                r0.f8477f = r10
                r0.f8478g = r10
                r0.f8479h = r10
                r0.f8480i = r10
                r0.f8481j = r10
                r0.f8482k = r10
                r3 = 7
                r0.f8488q = r3
                java.lang.Object r1 = o3.C0977g.g(r1, r2, r0)
                if (r1 != r8) goto L_0x0617
                goto L_0x067f
            L_0x0617:
                R2.s r1 = (R2.s) r1
                goto L_0x0682
            L_0x061a:
                java.io.File r1 = r0.f8491t
                java.io.File[] r1 = r1.listFiles()
                if (r1 == 0) goto L_0x0636
                int r2 = r1.length
                if (r2 != 0) goto L_0x0626
                goto L_0x0628
            L_0x0626:
                r17 = 0
            L_0x0628:
                if (r17 != 0) goto L_0x0636
                int r2 = r1.length
                r3 = 0
            L_0x062c:
                if (r3 >= r2) goto L_0x0636
                r5 = r1[r3]
                r5.delete()
                int r3 = r3 + 1
                goto L_0x062c
            L_0x0636:
                boolean r1 = r4.isEmpty()
                if (r1 != 0) goto L_0x064e
                int r1 = r4.size()
            L_0x0640:
                if (r9 >= r1) goto L_0x064e
                java.lang.Object r2 = r4.get(r9)
                int r9 = r9 + 1
                java.io.File r2 = (java.io.File) r2
                r2.delete()
                goto L_0x0640
            L_0x064e:
                N1.k$a r1 = N1.k.f7778g
                r1.f()
                o3.E0 r1 = o3.Y.c()
                W1.G$b$h r2 = new W1.G$b$h
                S1.m r3 = r0.f8492u
                r10 = 0
                r2.<init>(r7, r6, r3, r10)
                r0.f8472a = r10
                r0.f8473b = r10
                r0.f8474c = r10
                r0.f8475d = r10
                r0.f8476e = r10
                r0.f8477f = r10
                r0.f8478g = r10
                r0.f8479h = r10
                r0.f8480i = r10
                r0.f8481j = r10
                r0.f8482k = r10
                r3 = 8
                r0.f8488q = r3
                java.lang.Object r1 = o3.C0977g.g(r1, r2, r0)
                if (r1 != r8) goto L_0x0680
            L_0x067f:
                return r8
            L_0x0680:
                R2.s r1 = R2.s.f8222a
            L_0x0682:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: W1.G.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    private final boolean h(File file, File file2) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        try {
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                String name = zipEntry.getName();
                m.d(name, "entryName");
                if (m3.m.o(name, ".apk", false, 2, (Object) null)) {
                    if (zipEntry.getSize() >= file2.getUsableSpace()) {
                        return false;
                    }
                    File file3 = new File(file2, name);
                    inputStream = zipFile.getInputStream(zipEntry);
                    m.d(inputStream, "zipFile.getInputStream(element)");
                    fileOutputStream = new FileOutputStream(file3);
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        inputStream.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        inputStream.close();
                    }
                    fileOutputStream.close();
                }
            }
            return true;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        } catch (Throwable th) {
            inputStream.close();
            fileOutputStream.close();
            throw th;
        }
    }

    public final void b() {
        this.f8471a = true;
    }

    public final boolean c(File file) {
        try {
            Enumeration<? extends ZipEntry> entries = new ZipFile(file).entries();
            while (entries.hasMoreElements()) {
                String name = ((ZipEntry) entries.nextElement()).getName();
                m.d(name, "entryName");
                if (m3.m.o(name, ".obb", false, 2, (Object) null)) {
                    return true;
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        return false;
    }

    public final Drawable d(File file, Context context) {
        boolean z4;
        m.e(file, "xapkFile");
        m.e(context, "context");
        Drawable drawable = (Drawable) D.f8459a.a().get(file.getName());
        if (drawable == null) {
            File g4 = new C1612h().g(context);
            String name = file.getName();
            m.d(name, "xapkFile.name");
            String name2 = file.getName();
            m.d(name2, "xapkFile.name");
            int i4 = 0;
            String substring = name.substring(0, m3.m.R(name2, ".", 0, false, 6, (Object) null));
            m.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            File file2 = new File(g4, substring);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (h(file, file2)) {
                File[] listFiles = file2.listFiles();
                if (listFiles != null) {
                    if (listFiles.length == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (!z4) {
                        int length = listFiles.length;
                        while (i4 < length) {
                            File file3 = listFiles[i4];
                            C1612h hVar = new C1612h();
                            String absolutePath = file3.getAbsolutePath();
                            m.d(absolutePath, "item.absolutePath");
                            Drawable h4 = hVar.h(context, absolutePath);
                            HashMap a5 = D.f8459a.a();
                            String name3 = file.getName();
                            m.d(name3, "xapkFile.name");
                            a5.put(name3, h4);
                            try {
                                file3.delete();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                            i4++;
                            drawable = h4;
                        }
                    }
                }
                if (file2.exists()) {
                    new i().a(file2);
                }
            }
        }
        return drawable;
    }

    public final i e(File file, Context context) {
        boolean z4;
        File file2 = file;
        Context context2 = context;
        m.e(file2, "xapkFile");
        m.e(context2, "context");
        File g4 = new C1612h().g(context2);
        String name = file2.getName();
        m.d(name, "xapkFile.name");
        String name2 = file2.getName();
        m.d(name2, "xapkFile.name");
        int i4 = 0;
        String substring = name.substring(0, m3.m.R(name2, ".", 0, false, 6, (Object) null));
        m.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        File file3 = new File(g4, substring);
        if (!file3.exists()) {
            file3.mkdirs();
        }
        i iVar = null;
        if (h(file2, file3)) {
            File[] listFiles = file3.listFiles();
            if (listFiles != null) {
                if (listFiles.length == 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (!z4) {
                    PackageManager packageManager = context2.getPackageManager();
                    int length = listFiles.length;
                    while (i4 < length) {
                        File file4 = listFiles[i4];
                        m.d(packageManager, "pm");
                        String absolutePath = file4.getAbsolutePath();
                        m.d(absolutePath, "item.absolutePath");
                        PackageInfo c5 = s.c(packageManager, absolutePath, 128);
                        if (c5 != null) {
                            try {
                                long m4 = new C1612h().m(c5);
                                String str = c5.packageName;
                                m.d(str, "pi.packageName");
                                i iVar2 = new i(str, m4);
                                try {
                                    D d5 = D.f8459a;
                                    if (((Drawable) d5.a().get(file.getName())) == null) {
                                        C1612h hVar = new C1612h();
                                        String absolutePath2 = file4.getAbsolutePath();
                                        m.d(absolutePath2, "item.absolutePath");
                                        Drawable h4 = hVar.h(context2, absolutePath2);
                                        HashMap a5 = d5.a();
                                        String name3 = file.getName();
                                        m.d(name3, "xapkFile.name");
                                        a5.put(name3, h4);
                                    }
                                    iVar = iVar2;
                                } catch (Exception e5) {
                                    e = e5;
                                    iVar = iVar2;
                                    e.printStackTrace();
                                    file4.delete();
                                    i4++;
                                    File file5 = file;
                                }
                            } catch (Exception e6) {
                                e = e6;
                                e.printStackTrace();
                                file4.delete();
                                i4++;
                                File file52 = file;
                            }
                        }
                        try {
                            file4.delete();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                        i4++;
                        File file522 = file;
                    }
                }
            }
            if (file3.exists()) {
                new i().a(file3);
            }
        }
        return iVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean f(java.io.File r7) {
        /*
            r6 = this;
            r0 = 0
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile     // Catch:{ Exception -> 0x002f }
            r1.<init>(r7)     // Catch:{ Exception -> 0x002f }
            java.util.Enumeration r7 = r1.entries()     // Catch:{ Exception -> 0x002f }
            r1 = 0
        L_0x000b:
            boolean r2 = r7.hasMoreElements()     // Catch:{ Exception -> 0x002d }
            if (r2 == 0) goto L_0x0034
            java.lang.Object r2 = r7.nextElement()     // Catch:{ Exception -> 0x002d }
            java.util.zip.ZipEntry r2 = (java.util.zip.ZipEntry) r2     // Catch:{ Exception -> 0x002d }
            java.lang.String r2 = r2.getName()     // Catch:{ Exception -> 0x002d }
            java.lang.String r3 = "entryName"
            kotlin.jvm.internal.m.d(r2, r3)     // Catch:{ Exception -> 0x002d }
            java.lang.String r3 = ".apk"
            r4 = 2
            r5 = 0
            boolean r2 = m3.m.o(r2, r3, r0, r4, r5)     // Catch:{ Exception -> 0x002d }
            if (r2 == 0) goto L_0x000b
            int r1 = r1 + 1
            goto L_0x000b
        L_0x002d:
            r7 = move-exception
            goto L_0x0031
        L_0x002f:
            r7 = move-exception
            r1 = 0
        L_0x0031:
            r7.printStackTrace()
        L_0x0034:
            if (r1 <= 0) goto L_0x0037
            r0 = 1
        L_0x0037:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: W1.G.f(java.io.File):boolean");
    }

    public final Object g(File file, File file2, S1.m mVar, d dVar) {
        return C0977g.g(Y.b(), new b(file, this, file2, mVar, (d) null), dVar);
    }
}
