package W1;

import N1.i;
import R2.n;
import R2.s;
import S1.h;
import V2.d;
import V2.g;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.documentfile.provider.DocumentFile;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import d3.p;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.C1006v;
import o3.J;
import o3.K;
import o3.L;
import o3.Y;

public final class j {

    /* renamed from: d  reason: collision with root package name */
    public static final a f8686d = new a((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static C1006v f8687e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static C1006v f8688f;

    /* renamed from: a  reason: collision with root package name */
    private final Context f8689a;

    /* renamed from: b  reason: collision with root package name */
    private final h f8690b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f8691c;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final C1006v a() {
            return j.f8687e;
        }

        public final C1006v b() {
            return j.f8688f;
        }

        public final void c(C1006v vVar) {
            j.f8687e = vVar;
        }

        public final void d(C1006v vVar) {
            j.f8688f = vVar;
        }

        private a() {
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f8692a;

        /* renamed from: b  reason: collision with root package name */
        Object f8693b;

        /* renamed from: c  reason: collision with root package name */
        Object f8694c;

        /* renamed from: d  reason: collision with root package name */
        Object f8695d;

        /* renamed from: e  reason: collision with root package name */
        Object f8696e;

        /* renamed from: f  reason: collision with root package name */
        int f8697f;

        /* renamed from: g  reason: collision with root package name */
        boolean f8698g;

        /* renamed from: h  reason: collision with root package name */
        int f8699h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ j f8700i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ ArrayList f8701j;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8702a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ j f8703b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(j jVar, d dVar) {
                super(2, dVar);
                this.f8703b = jVar;
            }

            public final d create(Object obj, d dVar) {
                return new a(this.f8703b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8702a == 0) {
                    n.b(obj);
                    h s4 = this.f8703b.s();
                    if (s4 == null) {
                        return null;
                    }
                    s4.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: W1.j$b$b  reason: collision with other inner class name */
        static final class C0121b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8704a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ j f8705b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f8706c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0121b(j jVar, String str, d dVar) {
                super(2, dVar);
                this.f8705b = jVar;
                this.f8706c = str;
            }

            public final d create(Object obj, d dVar) {
                return new C0121b(this.f8705b, this.f8706c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8704a == 0) {
                    n.b(obj);
                    h s4 = this.f8705b.s();
                    if (s4 == null) {
                        return null;
                    }
                    s4.b(this.f8706c);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((C0121b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8707a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ j f8708b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f8709c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(j jVar, String str, d dVar) {
                super(2, dVar);
                this.f8708b = jVar;
                this.f8709c = str;
            }

            public final d create(Object obj, d dVar) {
                return new c(this.f8708b, this.f8709c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8707a == 0) {
                    n.b(obj);
                    h s4 = this.f8708b.s();
                    if (s4 == null) {
                        return null;
                    }
                    s4.b(this.f8709c);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(j jVar, ArrayList arrayList, d dVar) {
            super(2, dVar);
            this.f8700i = jVar;
            this.f8701j = arrayList;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f8700i, this.f8701j, dVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v63, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v54, resolved type: kotlin.jvm.internal.C} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v64, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v29, resolved type: android.content.pm.PackageInstaller} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v65, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v39, resolved type: kotlin.jvm.internal.A} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v67, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v56, resolved type: kotlin.jvm.internal.C} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v68, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v31, resolved type: android.content.pm.PackageInstaller} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v69, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v41, resolved type: kotlin.jvm.internal.A} */
        /* JADX WARNING: Code restructure failed: missing block: B:141:0x0379, code lost:
            if (r2 != null) goto L_0x037b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x03a5, code lost:
            if (r0 == r4) goto L_0x042e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:157:0x03f1, code lost:
            if (r0 == null) goto L_0x043c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:158:0x03f3, code lost:
            r0.close();
            r0 = R2.s.f8222a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x0439, code lost:
            if (r0 == null) goto L_0x043c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:168:0x043e, code lost:
            return R2.s.f8222a;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:131:0x0312 A[Catch:{ Exception -> 0x02ec, all -> 0x02e8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:132:0x0315 A[Catch:{ Exception -> 0x02ec, all -> 0x02e8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:135:0x035e  */
        /* JADX WARNING: Removed duplicated region for block: B:139:0x0369 A[Catch:{ Exception -> 0x0063, all -> 0x0060 }] */
        /* JADX WARNING: Removed duplicated region for block: B:144:0x0381 A[SYNTHETIC, Splitter:B:144:0x0381] */
        /* JADX WARNING: Removed duplicated region for block: B:153:0x03e6 A[Catch:{ all -> 0x002e }] */
        /* JADX WARNING: Removed duplicated region for block: B:154:0x03e7 A[Catch:{ all -> 0x002e }] */
        /* JADX WARNING: Removed duplicated region for block: B:163:0x042f A[Catch:{ all -> 0x002e }] */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x0259 A[Catch:{ Exception -> 0x026d, all -> 0x0268 }] */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x027a A[Catch:{ Exception -> 0x026d, all -> 0x0268 }] */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x0284 A[Catch:{ Exception -> 0x026d, all -> 0x0268 }] */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x028a A[Catch:{ Exception -> 0x026d, all -> 0x0268 }] */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x02a9 A[Catch:{ Exception -> 0x02ec, all -> 0x02e8 }] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:150:0x03b1=Splitter:B:150:0x03b1, B:159:0x03f9=Splitter:B:159:0x03f9} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r32) {
            /*
                r31 = this;
                r1 = r31
                r0 = 1
                java.lang.String r2 = "item.absolutePath"
                java.lang.String r3 = "file.absolutePath"
                java.lang.Object r4 = W2.b.c()
                int r5 = r1.f8699h
                r6 = 5
                r7 = 4
                r8 = 3
                r9 = 2
                r10 = 0
                r11 = 0
                if (r5 == 0) goto L_0x00a9
                if (r5 == r0) goto L_0x007e
                if (r5 == r9) goto L_0x0066
                if (r5 == r8) goto L_0x0048
                if (r5 == r7) goto L_0x0039
                if (r5 != r6) goto L_0x0031
                int r0 = r1.f8697f
                java.lang.Object r2 = r1.f8693b
                kotlin.jvm.internal.C r2 = (kotlin.jvm.internal.C) r2
                java.lang.Object r3 = r1.f8692a
                android.content.pm.PackageInstaller r3 = (android.content.pm.PackageInstaller) r3
                R2.n.b(r32)     // Catch:{ all -> 0x002e }
                goto L_0x03e8
            L_0x002e:
                r0 = move-exception
                goto L_0x043f
            L_0x0031:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x0039:
                int r0 = r1.f8697f
                java.lang.Object r2 = r1.f8693b
                kotlin.jvm.internal.C r2 = (kotlin.jvm.internal.C) r2
                java.lang.Object r3 = r1.f8692a
                android.content.pm.PackageInstaller r3 = (android.content.pm.PackageInstaller) r3
                R2.n.b(r32)     // Catch:{ all -> 0x002e }
                goto L_0x0430
            L_0x0048:
                int r10 = r1.f8697f
                java.lang.Object r0 = r1.f8694c
                r2 = r0
                kotlin.jvm.internal.C r2 = (kotlin.jvm.internal.C) r2
                java.lang.Object r0 = r1.f8693b
                r3 = r0
                android.content.pm.PackageInstaller r3 = (android.content.pm.PackageInstaller) r3
                java.lang.Object r0 = r1.f8692a
                r5 = r0
                kotlin.jvm.internal.A r5 = (kotlin.jvm.internal.A) r5
                R2.n.b(r32)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                r0 = r32
                goto L_0x03a9
            L_0x0060:
                r0 = move-exception
                goto L_0x03b1
            L_0x0063:
                r0 = move-exception
                goto L_0x03f9
            L_0x0066:
                int r10 = r1.f8697f
                java.lang.Object r0 = r1.f8694c
                r2 = r0
                kotlin.jvm.internal.C r2 = (kotlin.jvm.internal.C) r2
                java.lang.Object r0 = r1.f8693b
                r3 = r0
                android.content.pm.PackageInstaller r3 = (android.content.pm.PackageInstaller) r3
                java.lang.Object r0 = r1.f8692a
                r5 = r0
                kotlin.jvm.internal.A r5 = (kotlin.jvm.internal.A) r5
                R2.n.b(r32)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                r0 = r32
                goto L_0x0361
            L_0x007e:
                boolean r2 = r1.f8698g
                int r3 = r1.f8697f
                java.lang.Object r5 = r1.f8696e
                java.lang.String r5 = (java.lang.String) r5
                java.lang.Object r12 = r1.f8695d
                java.lang.Long r12 = (java.lang.Long) r12
                java.lang.Object r13 = r1.f8694c
                kotlin.jvm.internal.C r13 = (kotlin.jvm.internal.C) r13
                java.lang.Object r14 = r1.f8693b
                android.content.pm.PackageInstaller r14 = (android.content.pm.PackageInstaller) r14
                java.lang.Object r15 = r1.f8692a
                kotlin.jvm.internal.A r15 = (kotlin.jvm.internal.A) r15
                R2.n.b(r32)     // Catch:{ Exception -> 0x00a2, all -> 0x009b }
                goto L_0x017c
            L_0x009b:
                r0 = move-exception
                r10 = r3
                r2 = r13
                r3 = r14
            L_0x009f:
                r5 = r15
                goto L_0x03b1
            L_0x00a2:
                r0 = move-exception
                r10 = r3
                r2 = r13
                r3 = r14
            L_0x00a6:
                r5 = r15
                goto L_0x03f9
            L_0x00a9:
                R2.n.b(r32)
                kotlin.jvm.internal.A r5 = new kotlin.jvm.internal.A
                r5.<init>()
                W1.j r12 = r1.f8700i
                android.content.Context r12 = r12.p()
                android.content.pm.PackageManager r12 = r12.getPackageManager()
                android.content.pm.PackageInstaller r14 = r12.getPackageInstaller()
                java.lang.String r12 = "context.packageManager.packageInstaller"
                kotlin.jvm.internal.m.d(r14, r12)
                W1.j r12 = r1.f8700i
                r12.n(r14)
                kotlin.jvm.internal.C r13 = new kotlin.jvm.internal.C
                r13.<init>()
                java.util.ArrayList r12 = r1.f8701j     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                int r12 = r12.size()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                r15 = 128(0x80, float:1.794E-43)
                java.lang.String r6 = "context.packageManager"
                if (r12 != r0) goto L_0x018b
                java.util.ArrayList r2 = r1.f8701j     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                java.lang.Object r2 = r2.get(r10)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                java.lang.String r12 = "apks[0]"
                kotlin.jvm.internal.m.d(r2, r12)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                boolean r12 = r2 instanceof java.io.File     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                if (r12 == 0) goto L_0x0233
                W1.j r12 = r1.f8700i     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                android.content.Context r12 = r12.p()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                android.content.pm.PackageManager r12 = r12.getPackageManager()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                kotlin.jvm.internal.m.d(r12, r6)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                r16 = r2
                java.io.File r16 = (java.io.File) r16     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                java.lang.String r7 = r16.getAbsolutePath()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                kotlin.jvm.internal.m.d(r7, r3)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                android.content.pm.PackageInfo r7 = W1.s.c(r12, r7, r15)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                if (r7 == 0) goto L_0x0233
                W1.j r12 = r1.f8700i     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                android.content.pm.ApplicationInfo r15 = r7.applicationInfo     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                int r15 = r15.targetSdkVersion     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                boolean r12 = r12.A(r15)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                java.lang.String r15 = r7.packageName     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                W1.h r8 = new W1.h     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                r8.<init>()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                r17 = r2
                java.io.File r17 = (java.io.File) r17     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                java.lang.String r9 = r17.getAbsolutePath()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                kotlin.jvm.internal.m.d(r9, r3)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                W1.j r3 = r1.f8700i     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                android.content.Context r3 = r3.p()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                kotlin.jvm.internal.m.d(r3, r6)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                java.lang.String r21 = r8.b(r7, r9, r3)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                W1.h r3 = new W1.h     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                r3.<init>()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                long r6 = r3.m(r7)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                java.lang.Long r3 = kotlin.coroutines.jvm.internal.b.c(r6)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                N1.k$a r17 = N1.k.f7778g     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                long r19 = r3.longValue()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                java.io.File r2 = (java.io.File) r2     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                long r22 = r2.length()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                r18 = r15
                r17.y(r18, r19, r21, r22)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                r2 = r18
                o3.E0 r6 = o3.Y.c()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                W1.j$b$a r7 = new W1.j$b$a     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                W1.j r8 = r1.f8700i     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                r7.<init>(r8, r11)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                r1.f8692a = r5     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                r1.f8693b = r14     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                r1.f8694c = r13     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                r1.f8695d = r3     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                r1.f8696e = r2     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                r1.f8697f = r10     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                r1.f8698g = r12     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                r1.f8699h = r0     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                java.lang.Object r6 = o3.C0977g.g(r6, r7, r1)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                if (r6 != r4) goto L_0x0177
                goto L_0x042e
            L_0x0177:
                r15 = r5
                r5 = r2
                r2 = r12
                r12 = r3
                r3 = 0
            L_0x017c:
                r6 = r5
                r5 = r3
                r3 = r14
                goto L_0x0239
            L_0x0181:
                r0 = move-exception
                r2 = r13
                r3 = r14
                goto L_0x03b1
            L_0x0186:
                r0 = move-exception
                r2 = r13
                r3 = r14
                goto L_0x03f9
            L_0x018b:
                java.util.ArrayList r3 = r1.f8701j     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                int r7 = r3.size()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                r8 = 0
            L_0x0192:
                if (r8 >= r7) goto L_0x0233
                java.lang.Object r9 = r3.get(r8)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                int r8 = r8 + r0
                boolean r12 = r9 instanceof java.io.File     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                if (r12 == 0) goto L_0x0192
                W1.j r12 = r1.f8700i     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                android.content.Context r12 = r12.p()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                android.content.pm.PackageManager r12 = r12.getPackageManager()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                kotlin.jvm.internal.m.d(r12, r6)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                r17 = r9
                java.io.File r17 = (java.io.File) r17     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                java.lang.String r11 = r17.getAbsolutePath()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                kotlin.jvm.internal.m.d(r11, r2)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                android.content.pm.PackageInfo r11 = W1.s.c(r12, r11, r15)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                if (r11 == 0) goto L_0x0230
                W1.g r12 = new W1.g     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                r12.<init>()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                boolean r12 = r12.k(r11)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                if (r12 == 0) goto L_0x0230
                W1.j r3 = r1.f8700i     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                android.content.pm.ApplicationInfo r7 = r11.applicationInfo     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                int r7 = r7.targetSdkVersion     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                boolean r3 = r3.A(r7)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                java.lang.String r7 = r11.packageName     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                W1.h r8 = new W1.h     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                r8.<init>()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                java.io.File r9 = (java.io.File) r9     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                java.lang.String r9 = r9.getAbsolutePath()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                kotlin.jvm.internal.m.d(r9, r2)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                W1.j r2 = r1.f8700i     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                android.content.Context r2 = r2.p()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                kotlin.jvm.internal.m.d(r2, r6)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                java.lang.String r28 = r8.b(r11, r9, r2)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                W1.h r2 = new W1.h     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                r2.<init>()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                long r8 = r2.m(r11)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                java.lang.Long r12 = kotlin.coroutines.jvm.internal.b.c(r8)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                java.util.ArrayList r2 = r1.f8701j     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                int r6 = r2.size()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                r8 = 0
                r29 = r8
                r8 = 0
            L_0x0209:
                if (r8 >= r6) goto L_0x021e
                java.lang.Object r9 = r2.get(r8)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                int r8 = r8 + r0
                java.lang.String r11 = "null cannot be cast to non-null type java.io.File"
                kotlin.jvm.internal.m.c(r9, r11)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                java.io.File r9 = (java.io.File) r9     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                long r19 = r9.length()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                long r29 = r29 + r19
                goto L_0x0209
            L_0x021e:
                N1.k$a r24 = N1.k.f7778g     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                long r26 = r12.longValue()     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                r25 = r7
                r24.y(r25, r26, r28, r29)     // Catch:{ Exception -> 0x0186, all -> 0x0181 }
                r2 = r3
                r15 = r5
                r3 = r14
                r6 = r25
                r5 = 0
                goto L_0x0239
            L_0x0230:
                r11 = 0
                goto L_0x0192
            L_0x0233:
                r15 = r5
                r3 = r14
                r2 = 0
                r5 = 0
                r6 = 0
                r12 = 0
            L_0x0239:
                W1.j r7 = r1.f8700i     // Catch:{ Exception -> 0x026d, all -> 0x0268 }
                java.util.ArrayList r8 = r1.f8701j     // Catch:{ Exception -> 0x026d, all -> 0x0268 }
                int r7 = r7.u(r6, r12, r8)     // Catch:{ Exception -> 0x026d, all -> 0x0268 }
                android.content.pm.PackageInstaller$SessionParams r8 = new android.content.pm.PackageInstaller$SessionParams     // Catch:{ Exception -> 0x026d, all -> 0x0268 }
                r8.<init>(r7)     // Catch:{ Exception -> 0x026d, all -> 0x0268 }
                r8.setInstallLocation(r10)     // Catch:{ Exception -> 0x026d, all -> 0x0268 }
                r7 = 31
                if (r2 == 0) goto L_0x027e
                int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x026d, all -> 0x0268 }
                if (r2 < r7) goto L_0x027e
                W1.j r2 = r1.f8700i     // Catch:{ Exception -> 0x026d, all -> 0x0268 }
                boolean r2 = r2.f8691c     // Catch:{ Exception -> 0x026d, all -> 0x0268 }
                if (r2 != 0) goto L_0x0272
                W1.j r2 = r1.f8700i     // Catch:{ Exception -> 0x026d, all -> 0x0268 }
                W1.h r9 = new W1.h     // Catch:{ Exception -> 0x026d, all -> 0x0268 }
                r9.<init>()     // Catch:{ Exception -> 0x026d, all -> 0x0268 }
                boolean r9 = r9.s()     // Catch:{ Exception -> 0x026d, all -> 0x0268 }
                r2.f8691c = r9     // Catch:{ Exception -> 0x026d, all -> 0x0268 }
                goto L_0x0272
            L_0x0268:
                r0 = move-exception
                r10 = r5
            L_0x026a:
                r2 = r13
                goto L_0x009f
            L_0x026d:
                r0 = move-exception
                r10 = r5
            L_0x026f:
                r2 = r13
                goto L_0x00a6
            L_0x0272:
                W1.j r2 = r1.f8700i     // Catch:{ Exception -> 0x026d, all -> 0x0268 }
                boolean r2 = r2.f8691c     // Catch:{ Exception -> 0x026d, all -> 0x0268 }
                if (r2 != 0) goto L_0x027e
                r2 = 2
                r8.setRequireUserAction(r2)     // Catch:{ Exception -> 0x026d, all -> 0x0268 }
            L_0x027e:
                int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x026d, all -> 0x0268 }
                r9 = 33
                if (r2 < r9) goto L_0x0288
                r2 = 2
                r8.setPackageSource(r2)     // Catch:{ Exception -> 0x026d, all -> 0x0268 }
            L_0x0288:
                if (r6 == 0) goto L_0x028d
                r8.setAppPackageName(r6)     // Catch:{ Exception -> 0x026d, all -> 0x0268 }
            L_0x028d:
                N1.k$a r2 = N1.k.f7778g     // Catch:{ Exception -> 0x026d, all -> 0x0268 }
                int r6 = r3.createSession(r8)     // Catch:{ Exception -> 0x026d, all -> 0x0268 }
                r2.G(r6)     // Catch:{ Exception -> 0x026d, all -> 0x0268 }
                int r2 = r2.n()     // Catch:{ Exception -> 0x026d, all -> 0x0268 }
                android.content.pm.PackageInstaller$Session r5 = r3.openSession(r2)     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                r13.f20968a = r5     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                java.util.ArrayList r5 = r1.f8701j     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                int r6 = r5.size()     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                r8 = 0
            L_0x02a7:
                if (r8 >= r6) goto L_0x02fe
                java.lang.Object r9 = r5.get(r8)     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                int r8 = r8 + r0
                W1.j r11 = r1.f8700i     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                java.lang.String r12 = "item"
                kotlin.jvm.internal.m.d(r9, r12)     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                java.io.InputStream r11 = r11.r(r9)     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                W1.j r12 = r1.f8700i     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                java.lang.Object r14 = r13.f20968a     // Catch:{ all -> 0x02ef }
                android.content.pm.PackageInstaller$Session r14 = (android.content.pm.PackageInstaller.Session) r14     // Catch:{ all -> 0x02ef }
                java.io.OutputStream r9 = r12.t(r14, r9)     // Catch:{ all -> 0x02ef }
                r15.f20966a = r0     // Catch:{ all -> 0x02d1 }
                if (r11 == 0) goto L_0x02d4
                r12 = 2
                r14 = 0
                long r19 = b3.C1641a.b(r11, r9, r10, r12, r14)     // Catch:{ all -> 0x02d1 }
                kotlin.coroutines.jvm.internal.b.c(r19)     // Catch:{ all -> 0x02d1 }
                goto L_0x02d5
            L_0x02d1:
                r0 = move-exception
                r5 = r0
                goto L_0x02f2
            L_0x02d4:
                r12 = 2
            L_0x02d5:
                r15.f20966a = r12     // Catch:{ all -> 0x02d1 }
                java.lang.Object r12 = r13.f20968a     // Catch:{ all -> 0x02d1 }
                android.content.pm.PackageInstaller$Session r12 = (android.content.pm.PackageInstaller.Session) r12     // Catch:{ all -> 0x02d1 }
                r12.fsync(r9)     // Catch:{ all -> 0x02d1 }
                R2.s r12 = R2.s.f8222a     // Catch:{ all -> 0x02d1 }
                r14 = 0
                b3.C1642b.a(r9, r14)     // Catch:{ all -> 0x02ef }
                b3.C1642b.a(r11, r14)     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                goto L_0x02a7
            L_0x02e8:
                r0 = move-exception
                r10 = r2
                goto L_0x026a
            L_0x02ec:
                r0 = move-exception
                r10 = r2
                goto L_0x026f
            L_0x02ef:
                r0 = move-exception
                r5 = r0
                goto L_0x02f8
            L_0x02f2:
                throw r5     // Catch:{ all -> 0x02f3 }
            L_0x02f3:
                r0 = move-exception
                b3.C1642b.a(r9, r5)     // Catch:{ all -> 0x02ef }
                throw r0     // Catch:{ all -> 0x02ef }
            L_0x02f8:
                throw r5     // Catch:{ all -> 0x02f9 }
            L_0x02f9:
                r0 = move-exception
                b3.C1642b.a(r11, r5)     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                throw r0     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
            L_0x02fe:
                android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                W1.j r5 = r1.f8700i     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                android.content.Context r5 = r5.p()     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                java.lang.Class<com.uptodown.core.service.SplitApksEventsService> r6 = com.uptodown.core.service.SplitApksEventsService.class
                r0.<init>(r5, r6)     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                r5 = 3
                r15.f20966a = r5     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                if (r5 < r7) goto L_0x0315
                r5 = 301989888(0x12000000, float:4.0389678E-28)
                goto L_0x0316
            L_0x0315:
                r5 = 0
            L_0x0316:
                W1.j r6 = r1.f8700i     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                android.content.Context r6 = r6.p()     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                android.app.PendingIntent r0 = android.app.PendingIntent.getService(r6, r10, r0, r5)     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                r5 = 4
                r15.f20966a = r5     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                java.lang.Object r5 = r13.f20968a     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                android.content.pm.PackageInstaller$Session r5 = (android.content.pm.PackageInstaller.Session) r5     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                android.content.IntentSender r0 = r0.getIntentSender()     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                r5.commit(r0)     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                r5 = 5
                r15.f20966a = r5     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                V2.g r0 = r1.getContext()     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                o3.s0$b r5 = o3.C1001s0.f3726k0     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                V2.g$b r0 = r0.get(r5)     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                o3.s0 r0 = (o3.C1001s0) r0     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                o3.v r0 = o3.C1010x.a(r0)     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                W1.j$a r5 = W1.j.f8686d     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                r5.d(r0)     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                r1.f8692a = r15     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                r1.f8693b = r3     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                r1.f8694c = r13     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                r14 = 0
                r1.f8695d = r14     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                r1.f8696e = r14     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                r1.f8697f = r2     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                r12 = 2
                r1.f8699h = r12     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                java.lang.Object r0 = r0.p(r1)     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
                if (r0 != r4) goto L_0x035e
                goto L_0x042e
            L_0x035e:
                r10 = r2
                r2 = r13
                r5 = r15
            L_0x0361:
                java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                if (r0 != 0) goto L_0x0381
                W1.j r0 = r1.f8700i     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                r0.o(r10, r3)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                N1.k$a r0 = N1.k.f7778g     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                r0.e()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                java.lang.String r0 = "fail"
                java.lang.Object r2 = r2.f20968a
                android.content.pm.PackageInstaller$Session r2 = (android.content.pm.PackageInstaller.Session) r2
                if (r2 == 0) goto L_0x0380
            L_0x037b:
                r2.close()
                R2.s r2 = R2.s.f8222a
            L_0x0380:
                return r0
            L_0x0381:
                V2.g r0 = r1.getContext()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                o3.s0$b r6 = o3.C1001s0.f3726k0     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                V2.g$b r0 = r0.get(r6)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                o3.s0 r0 = (o3.C1001s0) r0     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                o3.v r0 = o3.C1010x.a(r0)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                W1.j$a r6 = W1.j.f8686d     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                r6.c(r0)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                r1.f8692a = r5     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                r1.f8693b = r3     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                r1.f8694c = r2     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                r1.f8697f = r10     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                r6 = 3
                r1.f8699h = r6     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                java.lang.Object r0 = r0.p(r1)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                if (r0 != r4) goto L_0x03a9
                goto L_0x042e
            L_0x03a9:
                java.lang.Object r2 = r2.f20968a
                android.content.pm.PackageInstaller$Session r2 = (android.content.pm.PackageInstaller.Session) r2
                if (r2 == 0) goto L_0x03b0
                goto L_0x037b
            L_0x03b0:
                return r0
            L_0x03b1:
                r0.printStackTrace()     // Catch:{ all -> 0x002e }
                N1.k$a r0 = N1.k.f7778g     // Catch:{ all -> 0x002e }
                r0.e()     // Catch:{ all -> 0x002e }
                W1.j r0 = r1.f8700i     // Catch:{ all -> 0x002e }
                java.lang.Object r6 = r2.f20968a     // Catch:{ all -> 0x002e }
                android.content.pm.PackageInstaller$Session r6 = (android.content.pm.PackageInstaller.Session) r6     // Catch:{ all -> 0x002e }
                int r5 = r5.f20966a     // Catch:{ all -> 0x002e }
                java.lang.String r0 = r0.q(r10, r6, r5)     // Catch:{ all -> 0x002e }
                o3.E0 r5 = o3.Y.c()     // Catch:{ all -> 0x002e }
                W1.j$b$c r6 = new W1.j$b$c     // Catch:{ all -> 0x002e }
                W1.j r7 = r1.f8700i     // Catch:{ all -> 0x002e }
                r14 = 0
                r6.<init>(r7, r0, r14)     // Catch:{ all -> 0x002e }
                r1.f8692a = r3     // Catch:{ all -> 0x002e }
                r1.f8693b = r2     // Catch:{ all -> 0x002e }
                r1.f8694c = r14     // Catch:{ all -> 0x002e }
                r1.f8695d = r14     // Catch:{ all -> 0x002e }
                r1.f8696e = r14     // Catch:{ all -> 0x002e }
                r1.f8697f = r10     // Catch:{ all -> 0x002e }
                r7 = 5
                r1.f8699h = r7     // Catch:{ all -> 0x002e }
                java.lang.Object r0 = o3.C0977g.g(r5, r6, r1)     // Catch:{ all -> 0x002e }
                if (r0 != r4) goto L_0x03e7
                goto L_0x042e
            L_0x03e7:
                r0 = r10
            L_0x03e8:
                W1.j r4 = r1.f8700i     // Catch:{ all -> 0x002e }
                r4.o(r0, r3)     // Catch:{ all -> 0x002e }
                java.lang.Object r0 = r2.f20968a
                android.content.pm.PackageInstaller$Session r0 = (android.content.pm.PackageInstaller.Session) r0
                if (r0 == 0) goto L_0x043c
            L_0x03f3:
                r0.close()
                R2.s r0 = R2.s.f8222a
                goto L_0x043c
            L_0x03f9:
                r0.printStackTrace()     // Catch:{ all -> 0x002e }
                N1.k$a r0 = N1.k.f7778g     // Catch:{ all -> 0x002e }
                r0.e()     // Catch:{ all -> 0x002e }
                W1.j r0 = r1.f8700i     // Catch:{ all -> 0x002e }
                java.lang.Object r6 = r2.f20968a     // Catch:{ all -> 0x002e }
                android.content.pm.PackageInstaller$Session r6 = (android.content.pm.PackageInstaller.Session) r6     // Catch:{ all -> 0x002e }
                int r5 = r5.f20966a     // Catch:{ all -> 0x002e }
                java.lang.String r0 = r0.q(r10, r6, r5)     // Catch:{ all -> 0x002e }
                o3.E0 r5 = o3.Y.c()     // Catch:{ all -> 0x002e }
                W1.j$b$b r6 = new W1.j$b$b     // Catch:{ all -> 0x002e }
                W1.j r7 = r1.f8700i     // Catch:{ all -> 0x002e }
                r14 = 0
                r6.<init>(r7, r0, r14)     // Catch:{ all -> 0x002e }
                r1.f8692a = r3     // Catch:{ all -> 0x002e }
                r1.f8693b = r2     // Catch:{ all -> 0x002e }
                r1.f8694c = r14     // Catch:{ all -> 0x002e }
                r1.f8695d = r14     // Catch:{ all -> 0x002e }
                r1.f8696e = r14     // Catch:{ all -> 0x002e }
                r1.f8697f = r10     // Catch:{ all -> 0x002e }
                r7 = 4
                r1.f8699h = r7     // Catch:{ all -> 0x002e }
                java.lang.Object r0 = o3.C0977g.g(r5, r6, r1)     // Catch:{ all -> 0x002e }
                if (r0 != r4) goto L_0x042f
            L_0x042e:
                return r4
            L_0x042f:
                r0 = r10
            L_0x0430:
                W1.j r4 = r1.f8700i     // Catch:{ all -> 0x002e }
                r4.o(r0, r3)     // Catch:{ all -> 0x002e }
                java.lang.Object r0 = r2.f20968a
                android.content.pm.PackageInstaller$Session r0 = (android.content.pm.PackageInstaller.Session) r0
                if (r0 == 0) goto L_0x043c
                goto L_0x03f3
            L_0x043c:
                R2.s r0 = R2.s.f8222a
                return r0
            L_0x043f:
                java.lang.Object r2 = r2.f20968a
                android.content.pm.PackageInstaller$Session r2 = (android.content.pm.PackageInstaller.Session) r2
                if (r2 == 0) goto L_0x044a
                r2.close()
                R2.s r2 = R2.s.f8222a
            L_0x044a:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: W1.j.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8710a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j f8711b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f8712c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(j jVar, ArrayList arrayList, d dVar) {
            super(2, dVar);
            this.f8711b = jVar;
            this.f8712c = arrayList;
        }

        public final d create(Object obj, d dVar) {
            return new c(this.f8711b, this.f8712c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f8710a;
            if (i4 == 0) {
                n.b(obj);
                j jVar = this.f8711b;
                ArrayList arrayList = this.f8712c;
                this.f8710a = 1;
                if (jVar.y(arrayList, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public j(Context context, h hVar) {
        m.e(context, "context");
        this.f8689a = context;
        this.f8690b = hVar;
    }

    /* access modifiers changed from: private */
    public final void n(PackageInstaller packageInstaller) {
        for (PackageInstaller.SessionInfo sessionId : packageInstaller.getMySessions()) {
            try {
                packageInstaller.abandonSession(sessionId.getSessionId());
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void o(int i4, PackageInstaller packageInstaller) {
        try {
            packageInstaller.abandonSession(i4);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public final String q(int i4, PackageInstaller.Session session, int i5) {
        if (i4 == 0) {
            String string = this.f8689a.getString(i.error_code_installation_status_failure, new Object[]{MBridgeCommon.DYNAMIC_VIEW_TEMPLATE_VALUE});
            m.d(string, "context.getString(R.stri…RROR_CODE_CREATE_SESSION)");
            return string;
        } else if (session == null) {
            String string2 = this.f8689a.getString(i.error_code_installation_status_failure, new Object[]{"103"});
            m.d(string2, "context.getString(R.stri….ERROR_CODE_OPEN_SESSION)");
            return string2;
        } else if (i5 == 0) {
            String string3 = this.f8689a.getString(i.installation_status_failure_storage);
            m.d(string3, "context.getString(R.stri…n_status_failure_storage)");
            return string3;
        } else if (i5 == 1) {
            String string4 = this.f8689a.getString(i.error_code_installation_status_failure, new Object[]{"105"});
            m.d(string4, "context.getString(R.stri….ERROR_CODE_FSYNC_FAILED)");
            return string4;
        } else if (i5 == 2) {
            String string5 = this.f8689a.getString(i.error_code_installation_status_failure, new Object[]{"106"});
            m.d(string5, "context.getString(R.stri…ROR_CODE_CALLBACK_INTENT)");
            return string5;
        } else if (i5 == 3) {
            String string6 = this.f8689a.getString(i.error_code_installation_status_failure, new Object[]{"107"});
            m.d(string6, "context.getString(R.stri…NDING_INTENT_GET_SERVICE)");
            return string6;
        } else if (i5 == 4) {
            String string7 = this.f8689a.getString(i.error_code_installation_status_failure, new Object[]{"108"});
            m.d(string7, "context.getString(R.stri…RROR_CODE_SESSION_COMMIT)");
            return string7;
        } else {
            String string8 = this.f8689a.getString(i.error_code_installation_status_failure, new Object[]{"101"});
            m.d(string8, "context.getString(R.stri…re, Const.ERROR_CODE_101)");
            return string8;
        }
    }

    /* access modifiers changed from: private */
    public final InputStream r(Object obj) {
        if (obj instanceof File) {
            return new FileInputStream((File) obj);
        }
        if (obj instanceof DocumentFile) {
            ContentResolver contentResolver = this.f8689a.getContentResolver();
            if (contentResolver != null) {
                return contentResolver.openInputStream(((DocumentFile) obj).getUri());
            }
            return null;
        }
        throw new Exception("getInputStream: Illegal parameter type");
    }

    /* access modifiers changed from: private */
    public final OutputStream t(PackageInstaller.Session session, Object obj) {
        String name;
        long length;
        if (obj instanceof File) {
            File file = (File) obj;
            name = file.getName();
            m.d(name, "any.name");
            length = file.length();
        } else if (obj instanceof DocumentFile) {
            DocumentFile documentFile = (DocumentFile) obj;
            if (documentFile.getName() != null) {
                name = documentFile.getName();
                m.b(name);
                length = documentFile.length();
            } else {
                throw new Exception("getOutputStream: DocumentFile name is null");
            }
        } else {
            throw new Exception("getOutputStream: Illegal parameter type");
        }
        OutputStream openWrite = session.openWrite(name, 0, length);
        m.d(openWrite, "session.openWrite(name, 0, length)");
        return openWrite;
    }

    /* access modifiers changed from: private */
    public final int u(String str, Long l4, ArrayList arrayList) {
        PackageInfo packageInfo;
        if (str != null) {
            try {
                PackageManager packageManager = this.f8689a.getPackageManager();
                m.d(packageManager, "context.packageManager");
                packageInfo = s.d(packageManager, str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo != null) {
                long m4 = new C1612h().m(packageInfo);
                if (l4 != null && m4 == l4.longValue() && arrayList.size() > 1) {
                    return 2;
                }
            }
        }
        return 1;
    }

    public static /* synthetic */ void x(j jVar, ArrayList arrayList, boolean z4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z4 = false;
        }
        jVar.w(arrayList, z4);
    }

    /* access modifiers changed from: private */
    public final Object y(ArrayList arrayList, d dVar) {
        return C0977g.g(Y.b(), new b(this, arrayList, (d) null), dVar);
    }

    private final void z(ArrayList arrayList) {
        C1001s0 unused = C0981i.d(K.a(Y.b()), (g) null, (L) null, new c(this, arrayList, (d) null), 3, (Object) null);
    }

    public final boolean A(int i4) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 31) {
            return false;
        }
        if (i5 == 31 && i4 >= 29) {
            return true;
        }
        if (i5 == 32 && i4 >= 29) {
            return true;
        }
        if (i5 == 33 && i4 >= 30) {
            return true;
        }
        if (i5 < 34 || i4 < 31) {
            return false;
        }
        return true;
    }

    public final Context p() {
        return this.f8689a;
    }

    public final h s() {
        return this.f8690b;
    }

    public final void v(File file, boolean z4) {
        m.e(file, "apk");
        this.f8691c = z4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(file);
        z(arrayList);
    }

    public final void w(ArrayList arrayList, boolean z4) {
        m.e(arrayList, "apks");
        this.f8691c = z4;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList);
        z(arrayList2);
    }
}
