package u2;

import R2.n;
import S2.C1601o;
import W1.C1610f;
import W1.C1611g;
import W1.s;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.uptodown.UptodownApp;
import com.uptodown.activities.preferences.a;
import d3.p;
import g2.C2048f;
import g2.C2063v;
import g2.S;
import java.io.File;
import java.lang.Character;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.F;
import m3.j;
import o3.C0977g;
import o3.J;
import o3.Y;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final a f21904a = new a((C2103g) null);

    public static final class a {

        /* renamed from: u2.m$a$a  reason: collision with other inner class name */
        public static final class C0269a implements Comparator {
            public final int compare(Object obj, Object obj2) {
                boolean z4;
                C2048f.c w4 = ((C2048f) obj).w();
                C2048f.c cVar = C2048f.c.OUTDATED;
                boolean z5 = false;
                if (w4 != cVar) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Boolean valueOf = Boolean.valueOf(z4);
                if (((C2048f) obj2).w() != cVar) {
                    z5 = true;
                }
                return U2.a.a(valueOf, Boolean.valueOf(z5));
            }
        }

        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private final void h(ArrayList arrayList, Context context) {
            t a5 = t.f21927u.a(context);
            a5.a();
            ArrayList F02 = a5.F0();
            a5.i();
            Iterator it = F02.iterator();
            kotlin.jvm.internal.m.d(it, "iterator(...)");
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                kotlin.jvm.internal.m.d(next, "next(...)");
                S s4 = (S) next;
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    long A4 = ((C2048f) arrayList.get(i4)).A();
                    if (m3.m.p(s4.h(), ((C2048f) arrayList.get(i4)).o(), true) && s4.j() > A4) {
                        ((C2048f) arrayList.get(i4)).c0(C2048f.c.OUTDATED);
                    }
                }
            }
            int size2 = arrayList.size();
            int i5 = 0;
            while (i5 < size2) {
                Object obj = arrayList.get(i5);
                i5++;
                C2048f fVar = (C2048f) obj;
                int size3 = F02.size();
                int i6 = 0;
                while (i6 < size3) {
                    Object obj2 = F02.get(i6);
                    i6++;
                    S s5 = (S) obj2;
                    if (fVar.e() == 1 || (kotlin.jvm.internal.m.a(fVar.o(), s5.h()) && s5.m())) {
                        fVar.c0(C2048f.c.UPDATED);
                    }
                }
            }
            C1601o.t(arrayList, new C0269a());
            int i7 = 0;
            while (i7 < arrayList.size() && (!m3.m.p(context.getPackageName(), ((C2048f) arrayList.get(i7)).o(), true) || ((C2048f) arrayList.get(i7)).w() != C2048f.c.OUTDATED)) {
                i7++;
            }
            if (i7 < arrayList.size()) {
                Object remove = arrayList.remove(i7);
                kotlin.jvm.internal.m.d(remove, "removeAt(...)");
                arrayList.add(0, (C2048f) remove);
            }
        }

        /* access modifiers changed from: private */
        public static final int j(C2048f fVar, C2048f fVar2) {
            kotlin.jvm.internal.m.e(fVar, "app1");
            kotlin.jvm.internal.m.e(fVar2, "app2");
            return kotlin.jvm.internal.m.h(fVar2.j(), fVar.j());
        }

        /* access modifiers changed from: private */
        public static final int k(p pVar, Object obj, Object obj2) {
            return ((Number) pVar.invoke(obj, obj2)).intValue();
        }

        /* access modifiers changed from: private */
        public static final int m(C2048f fVar, C2048f fVar2) {
            kotlin.jvm.internal.m.e(fVar, "app1");
            kotlin.jvm.internal.m.e(fVar2, "app2");
            if (fVar.m() == null) {
                return 1;
            }
            if (fVar2.m() == null) {
                return -1;
            }
            String m4 = fVar.m();
            kotlin.jvm.internal.m.b(m4);
            String m5 = fVar2.m();
            kotlin.jvm.internal.m.b(m5);
            return m3.m.j(m4, m5, true);
        }

        /* access modifiers changed from: private */
        public static final int o(C2048f fVar, C2048f fVar2) {
            kotlin.jvm.internal.m.e(fVar, "app1");
            kotlin.jvm.internal.m.e(fVar2, "app2");
            return kotlin.jvm.internal.m.h(fVar2.t(), fVar.t());
        }

        /* access modifiers changed from: private */
        public static final int p(p pVar, Object obj, Object obj2) {
            return ((Number) pVar.invoke(obj, obj2)).intValue();
        }

        /* access modifiers changed from: private */
        public static final int r(C2048f fVar, C2048f fVar2) {
            kotlin.jvm.internal.m.e(fVar, "app1");
            kotlin.jvm.internal.m.e(fVar2, "app2");
            return kotlin.jvm.internal.m.h(fVar2.j(), fVar.j());
        }

        /* access modifiers changed from: private */
        public static final int s(p pVar, Object obj, Object obj2) {
            return ((Number) pVar.invoke(obj, obj2)).intValue();
        }

        public final void i(ArrayList arrayList, Context context) {
            kotlin.jvm.internal.m.e(arrayList, "tmpUserApps");
            kotlin.jvm.internal.m.e(context, "context");
            C1601o.t(arrayList, new C2324j(new C2323i()));
            h(arrayList, context);
        }

        public final void l(ArrayList arrayList, Context context) {
            kotlin.jvm.internal.m.e(arrayList, "tmpUserApps");
            kotlin.jvm.internal.m.e(context, "context");
            C1601o.t(arrayList, new C2322h());
            h(arrayList, context);
        }

        public final void n(ArrayList arrayList, Context context) {
            kotlin.jvm.internal.m.e(arrayList, "tmpUserApps");
            kotlin.jvm.internal.m.e(context, "context");
            C1601o.t(arrayList, new C2326l(new C2325k()));
            h(arrayList, context);
        }

        public final void q(ArrayList arrayList) {
            kotlin.jvm.internal.m.e(arrayList, "tmpUserApps");
            C1601o.t(arrayList, new C2321g(new C2320f()));
        }

        private a() {
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21905a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2048f f21906b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ PackageManager f21907c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ t f21908d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C2048f fVar, PackageManager packageManager, t tVar, V2.d dVar) {
            super(2, dVar);
            this.f21906b = fVar;
            this.f21907c = packageManager;
            this.f21908d = tVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f21906b, this.f21907c, this.f21908d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            ArrayList a02;
            ApplicationInfo applicationInfo;
            W2.b.c();
            if (this.f21905a == 0) {
                n.b(obj);
                if (this.f21906b.f() == 0) {
                    try {
                        PackageManager packageManager = this.f21907c;
                        String o4 = this.f21906b.o();
                        kotlin.jvm.internal.m.b(o4);
                        applicationInfo = s.a(packageManager, o4, 128);
                    } catch (PackageManager.NameNotFoundException unused) {
                        applicationInfo = null;
                    }
                    if (this.f21906b.r() == null && this.f21906b.f() == 0) {
                        if (applicationInfo != null) {
                            this.f21906b.Z(C1610f.f8672a.e(applicationInfo.sourceDir));
                        }
                        if (this.f21906b.r() != null) {
                            this.f21908d.u1(this.f21906b);
                        } else {
                            this.f21906b.O(1);
                            this.f21908d.s1(this.f21906b);
                        }
                    }
                }
                if (this.f21906b.f() == 0 && (a02 = this.f21908d.a0(this.f21906b)) != null) {
                    Iterator it = a02.iterator();
                    kotlin.jvm.internal.m.d(it, "iterator(...)");
                    while (it.hasNext()) {
                        Object next = it.next();
                        kotlin.jvm.internal.m.d(next, "next(...)");
                        C2063v vVar = (C2063v) next;
                        if (vVar.a() != null && vVar.c() == null) {
                            C1610f fVar = C1610f.f8672a;
                            String a5 = vVar.a();
                            kotlin.jvm.internal.m.b(a5);
                            vVar.f(fVar.e(a5));
                            this.f21908d.t1(vVar);
                        }
                    }
                }
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f21909a;

        /* renamed from: b  reason: collision with root package name */
        Object f21910b;

        /* renamed from: c  reason: collision with root package name */
        Object f21911c;

        /* renamed from: d  reason: collision with root package name */
        int f21912d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f21913e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ArrayList f21914f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ m f21915g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context, ArrayList arrayList, m mVar, V2.d dVar) {
            super(2, dVar);
            this.f21913e = context;
            this.f21914f = arrayList;
            this.f21915g = mVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f21913e, this.f21914f, this.f21915g, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            PackageManager packageManager;
            t tVar;
            Iterator it;
            Object c5 = W2.b.c();
            int i4 = this.f21912d;
            if (i4 == 0) {
                n.b(obj);
                PackageManager packageManager2 = this.f21913e.getPackageManager();
                t a5 = t.f21927u.a(this.f21913e);
                a5.a();
                Iterator it2 = this.f21914f.iterator();
                kotlin.jvm.internal.m.d(it2, "iterator(...)");
                Iterator it3 = it2;
                tVar = a5;
                it = it3;
                packageManager = packageManager2;
            } else if (i4 == 1) {
                it = (Iterator) this.f21911c;
                tVar = (t) this.f21910b;
                packageManager = (PackageManager) this.f21909a;
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            while (it.hasNext()) {
                Object next = it.next();
                kotlin.jvm.internal.m.d(next, "next(...)");
                m mVar = this.f21915g;
                kotlin.jvm.internal.m.b(packageManager);
                this.f21909a = packageManager;
                this.f21910b = tVar;
                this.f21911c = it;
                this.f21912d = 1;
                if (mVar.e((C2048f) next, tVar, packageManager, this) == c5) {
                    return c5;
                }
            }
            tVar.i();
            return R2.s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21916a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f21917b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ApplicationInfo f21918c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Context context, ApplicationInfo applicationInfo, V2.d dVar) {
            super(2, dVar);
            this.f21917b = context;
            this.f21918c = applicationInfo;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f21917b, this.f21918c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f21916a;
            if (i4 == 0) {
                n.b(obj);
                F f4 = F.f21886a;
                Context context = this.f21917b;
                String str = this.f21918c.packageName;
                this.f21916a = 1;
                if (f4.l(context, str, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return R2.s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    private final boolean C(String str) {
        if (m3.m.y(str, "com.miui.", false, 2, (Object) null) || m3.m.y(str, "com.xiaomi.", false, 2, (Object) null)) {
            return true;
        }
        return false;
    }

    private final String E(String str) {
        Normalizer.Form form = Normalizer.Form.NFD;
        if (Normalizer.isNormalized(str, form)) {
            return str;
        }
        return new j("[\\p{InCombiningDiacriticalMarks}]").g(Normalizer.normalize(str, form), "");
    }

    /* access modifiers changed from: private */
    public final Object e(C2048f fVar, t tVar, PackageManager packageManager, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new b(fVar, packageManager, tVar, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return R2.s.f8222a;
    }

    private final byte[] k(PackageManager packageManager, String str) {
        boolean z4;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                SigningInfo a5 = s.d(packageManager, str, 134217728).signingInfo;
                if (a5.hasPastSigningCertificates()) {
                    Signature[] a6 = a5.getSigningCertificateHistory();
                    kotlin.jvm.internal.m.d(a6, "getSigningCertificateHistory(...)");
                    if (a6.length == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (!z4) {
                        return a5.getSigningCertificateHistory()[a5.getSigningCertificateHistory().length - 1].toByteArray();
                    }
                }
                Signature[] a7 = a5.getApkContentsSigners();
                if (a7 == null) {
                    return null;
                }
                if (a7.length == 0) {
                    return null;
                }
                return a7[0].toByteArray();
            }
            Signature[] signatureArr = s.d(packageManager, str, 64).signatures;
            if (signatureArr == null) {
                return null;
            }
            if (signatureArr.length == 0) {
                return null;
            }
            return signatureArr[0].toByteArray();
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    private final String l(PackageManager packageManager, String str, String str2) {
        byte[] k4 = k(packageManager, str);
        if (k4 == null) {
            return null;
        }
        if (kotlin.jvm.internal.m.a(str2, SameMD5.TAG)) {
            return C1610f.f8672a.g(k4);
        }
        if (kotlin.jvm.internal.m.a(str2, "SHA256")) {
            return C1610f.f8672a.d(k4);
        }
        return null;
    }

    private final long m(String str) {
        try {
            return new C1611g().h(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + str + '/'));
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    private final long n(String str) {
        try {
            return new C1611g().h(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/obb/" + str + '/'));
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public static final int p(String str, String str2) {
        kotlin.jvm.internal.m.e(str, "app1");
        kotlin.jvm.internal.m.e(str2, "app2");
        return m3.m.j(str, str2, true);
    }

    /* access modifiers changed from: private */
    public static final int q(p pVar, Object obj, Object obj2) {
        return ((Number) pVar.invoke(obj, obj2)).intValue();
    }

    private final boolean t(int i4) {
        if (Build.VERSION.SDK_INT < 24) {
            return Character.isIdeographic(i4);
        }
        if (Character.UnicodeScript.of(i4) == Character.UnicodeScript.HAN) {
            return true;
        }
        return false;
    }

    private final boolean u(ApplicationInfo applicationInfo) {
        if ((applicationInfo.flags & 2) != 0) {
            return true;
        }
        return false;
    }

    private final boolean v(C2048f fVar) {
        if (fVar.o() == null) {
            return false;
        }
        if (!fVar.F() && !fVar.H()) {
            return false;
        }
        String o4 = fVar.o();
        kotlin.jvm.internal.m.b(o4);
        if (C(o4)) {
            return true;
        }
        return false;
    }

    private final boolean w(String str, PackageManager packageManager) {
        if (str == null || packageManager.getLaunchIntentForPackage(str) == null) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0108  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final g2.C2048f z(android.content.pm.ApplicationInfo r26, g2.C2048f r27, android.content.pm.PackageInfo r28, u2.t r29, android.content.Context r30, android.content.pm.PackageManager r31, boolean r32, boolean r33) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = r27
            r3 = r28
            r4 = r29
            r5 = r30
            r6 = r31
            r7 = r32
            r8 = r33
            o3.G r9 = o3.Y.b()
            o3.J r10 = o3.K.a(r9)
            u2.m$d r13 = new u2.m$d
            r9 = 0
            r13.<init>(r5, r1, r9)
            r14 = 3
            r15 = 0
            r11 = 0
            r12 = 0
            o3.C1001s0 unused = o3.C0981i.d(r10, r11, r12, r13, r14, r15)
            W1.h r10 = new W1.h
            r10.<init>()
            long r10 = r10.m(r3)
            if (r2 == 0) goto L_0x003b
            long r12 = r2.A()
            java.lang.Long r12 = java.lang.Long.valueOf(r12)
            goto L_0x003c
        L_0x003b:
            r12 = r9
        L_0x003c:
            r15 = 0
            java.lang.String r9 = "com.android.vending.archive"
            r18 = 0
            r19 = -1
            r13 = -1
            r14 = 1
            if (r12 == 0) goto L_0x01b2
            long r21 = r2.A()
            int r12 = (r21 > r10 ? 1 : (r21 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x0052
            goto L_0x01b2
        L_0x0052:
            java.lang.String r10 = r2.k()
            if (r10 != 0) goto L_0x0080
            java.lang.String r7 = r2.o()
            if (r7 == 0) goto L_0x0071
            int r7 = r7.length()
            if (r7 != 0) goto L_0x0065
            goto L_0x0071
        L_0x0065:
            java.lang.String r7 = r2.o()
            kotlin.jvm.internal.m.b(r7)
            java.lang.String r9 = r0.i(r6, r7)
            goto L_0x0072
        L_0x0071:
            r9 = 0
        L_0x0072:
            if (r9 == 0) goto L_0x0079
            r2.U(r9)
            r6 = 1
            goto L_0x00d2
        L_0x0079:
            r2.O(r14)
            r4.s1(r2)
            goto L_0x00d1
        L_0x0080:
            java.lang.String r6 = r2.o()
            boolean r6 = r0.x(r6)
            if (r6 != 0) goto L_0x0097
            int r6 = r2.f()
            if (r6 != 0) goto L_0x00d1
            r2.O(r14)
            r4.s1(r2)
            goto L_0x00d1
        L_0x0097:
            android.os.Bundle r6 = r1.metaData
            if (r6 == 0) goto L_0x00ae
            boolean r6 = r6.getBoolean(r9)
            if (r6 != r14) goto L_0x00ae
            int r6 = r2.f()
            if (r6 != 0) goto L_0x00d1
            r2.O(r14)
            r4.s1(r2)
            goto L_0x00d1
        L_0x00ae:
            boolean r6 = r25.u(r26)
            if (r6 == 0) goto L_0x00c1
            int r6 = r2.f()
            if (r6 != 0) goto L_0x00d1
            r2.O(r14)
            r4.s1(r2)
            goto L_0x00d1
        L_0x00c1:
            int r6 = r2.f()
            r2.P(r7, r8)
            int r7 = r2.f()
            if (r6 == r7) goto L_0x00d1
            r4.s1(r2)
        L_0x00d1:
            r6 = 0
        L_0x00d2:
            java.lang.String r7 = r2.c()
            if (r7 != 0) goto L_0x00dc
            r0.D(r2, r3, r5)
            r6 = 1
        L_0x00dc:
            long r7 = r2.t()
            int r9 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r9 != 0) goto L_0x00ec
            long r6 = r25.d(r26)
            r2.b0(r6)
            r6 = 1
        L_0x00ec:
            if (r6 == 0) goto L_0x00f1
            r4.r1(r2)
        L_0x00f1:
            java.lang.String r6 = r3.versionName
            r2.i0(r6)
            long r6 = r3.lastUpdateTime
            r2.T(r6)
            long r6 = r3.firstInstallTime
            r2.Q(r6)
            long r6 = r2.i()
            int r3 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r3 <= 0) goto L_0x02a7
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r2.J(r1, r4)
            java.util.ArrayList r1 = r2.v()
            if (r1 == 0) goto L_0x012d
            java.util.ArrayList r1 = r2.v()
            kotlin.jvm.internal.m.b(r1)
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x012d
            java.util.ArrayList r1 = r2.v()
            kotlin.jvm.internal.m.b(r1)
            r3.addAll(r1)
        L_0x012d:
            r2.I(r4)
            java.util.ArrayList r1 = r2.n()
            if (r1 == 0) goto L_0x014d
            java.util.ArrayList r1 = r2.n()
            kotlin.jvm.internal.m.b(r1)
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x014d
            java.util.ArrayList r1 = r2.n()
            kotlin.jvm.internal.m.b(r1)
            r3.addAll(r1)
        L_0x014d:
            boolean r1 = r3.isEmpty()
            if (r1 != 0) goto L_0x02a7
            long r6 = r2.i()
            java.util.ArrayList r1 = r4.Z(r6)
            java.util.Iterator r1 = r1.iterator()
            java.lang.String r6 = "iterator(...)"
            kotlin.jvm.internal.m.d(r1, r6)
        L_0x0164:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x02a7
            java.lang.Object r6 = r1.next()
            java.lang.String r7 = "next(...)"
            kotlin.jvm.internal.m.d(r6, r7)
            g2.v r6 = (g2.C2063v) r6
            java.util.Iterator r7 = r3.iterator()
            r8 = 0
        L_0x017a:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x01a5
            int r9 = r8 + 1
            java.lang.Object r10 = r7.next()
            g2.v r10 = (g2.C2063v) r10
            java.lang.String r11 = r6.a()
            java.lang.String r12 = r10.a()
            boolean r11 = m3.m.p(r11, r12, r14)
            if (r11 == 0) goto L_0x01a3
            long r11 = r6.d()
            long r15 = r10.d()
            int r10 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r10 != 0) goto L_0x01a3
            goto L_0x01a6
        L_0x01a3:
            r8 = r9
            goto L_0x017a
        L_0x01a5:
            r8 = -1
        L_0x01a6:
            if (r8 != r13) goto L_0x01ac
            r4.w(r6)
            goto L_0x0164
        L_0x01ac:
            if (r8 <= r13) goto L_0x0164
            r3.remove(r8)
            goto L_0x0164
        L_0x01b2:
            if (r2 == 0) goto L_0x01cb
            int r12 = r2.e()
            int r17 = r2.f()
            r21 = r15
            java.lang.String r15 = r2.o()
            kotlin.jvm.internal.m.b(r15)
            r4.v(r15)
            r15 = r17
            goto L_0x01cf
        L_0x01cb:
            r21 = r15
            r12 = -1
            r15 = -1
        L_0x01cf:
            g2.f r14 = new g2.f
            r14.<init>()
            if (r2 == 0) goto L_0x01e5
            long r23 = r2.b()
            int r17 = (r23 > r21 ? 1 : (r23 == r21 ? 0 : -1))
            if (r17 <= 0) goto L_0x01e5
            long r7 = r2.b()
            r14.K(r7)
        L_0x01e5:
            if (r12 == r13) goto L_0x01ea
            r14.N(r12)
        L_0x01ea:
            if (r15 == r13) goto L_0x01ef
            r14.O(r15)
        L_0x01ef:
            java.lang.String r2 = r1.packageName
            r14.W(r2)
            int r2 = r14.f()
            if (r2 != 0) goto L_0x0214
            java.lang.String r2 = r14.o()
            boolean r2 = r0.x(r2)
            if (r2 != 0) goto L_0x0209
            r2 = 1
            r14.O(r2)
            goto L_0x020a
        L_0x0209:
            r2 = 1
        L_0x020a:
            boolean r7 = r25.u(r26)
            if (r7 == 0) goto L_0x0215
            r14.O(r2)
            goto L_0x0215
        L_0x0214:
            r2 = 1
        L_0x0215:
            W1.h r7 = new W1.h
            r7.<init>()
            boolean r7 = r7.r(r3)
            if (r7 == 0) goto L_0x0223
            r14.d0(r2)
        L_0x0223:
            java.lang.String r7 = r14.o()
            boolean r7 = r0.w(r7, r6)
            if (r7 == 0) goto L_0x0230
            r14.e0(r2)
        L_0x0230:
            r14.h0(r10)
            java.lang.String r2 = r3.versionName
            r14.i0(r2)
            long r7 = r3.lastUpdateTime
            r14.T(r7)
            long r7 = r3.firstInstallTime
            r14.Q(r7)
            r0.D(r14, r3, r5)
            java.lang.String r2 = r14.o()
            if (r2 == 0) goto L_0x0254
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0252
            goto L_0x0254
        L_0x0252:
            r2 = 0
            goto L_0x0255
        L_0x0254:
            r2 = 1
        L_0x0255:
            if (r2 != 0) goto L_0x0265
            java.lang.String r2 = r14.o()
            kotlin.jvm.internal.m.b(r2)
            java.lang.String r2 = r0.i(r6, r2)
            r14.U(r2)
        L_0x0265:
            java.lang.String r2 = r14.k()
            if (r2 != 0) goto L_0x0270
            r2 = 1
            r14.O(r2)
            goto L_0x0271
        L_0x0270:
            r2 = 1
        L_0x0271:
            int r3 = r14.f()
            if (r3 != 0) goto L_0x0288
            android.os.Bundle r3 = r1.metaData
            if (r3 == 0) goto L_0x0283
            boolean r3 = r3.getBoolean(r9)
            if (r3 != r2) goto L_0x0283
            r18 = 1
        L_0x0283:
            if (r18 == 0) goto L_0x0288
            r14.O(r2)
        L_0x0288:
            int r2 = r14.f()
            if (r2 != 0) goto L_0x0295
            r7 = r32
            r8 = r33
            r14.P(r7, r8)
        L_0x0295:
            g2.f r2 = r4.J0(r14)
            long r6 = r2.i()
            int r3 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r3 <= 0) goto L_0x02a7
            r2.J(r1, r4)
            r2.I(r4)
        L_0x02a7:
            java.lang.String r1 = r2.o()
            if (r1 == 0) goto L_0x02c0
            W1.h r1 = new W1.h
            r1.<init>()
            java.lang.String r3 = r2.o()
            kotlin.jvm.internal.m.b(r3)
            boolean r1 = r1.p(r5, r3)
            r2.M(r1)
        L_0x02c0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.m.z(android.content.pm.ApplicationInfo, g2.f, android.content.pm.PackageInfo, u2.t, android.content.Context, android.content.pm.PackageManager, boolean, boolean):g2.f");
    }

    /* JADX INFO: finally extract failed */
    public final C2048f A(Context context, String str) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        kotlin.jvm.internal.m.e(context, "context");
        synchronized (UptodownApp.f17422D.h()) {
            C2048f fVar = null;
            if (str == null) {
                return null;
            }
            try {
                t a5 = t.f21927u.a(context);
                a5.a();
                PackageManager packageManager = context.getPackageManager();
                try {
                    PackageManager packageManager2 = context.getPackageManager();
                    kotlin.jvm.internal.m.d(packageManager2, "getPackageManager(...)");
                    packageInfo = s.d(packageManager2, str, 0);
                } catch (PackageManager.NameNotFoundException unused) {
                    packageInfo = null;
                }
                if (packageInfo != null) {
                    a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
                    boolean f02 = aVar.f0(context);
                    boolean g02 = aVar.g0(context);
                    try {
                        PackageManager packageManager3 = context.getPackageManager();
                        kotlin.jvm.internal.m.d(packageManager3, "getPackageManager(...)");
                        applicationInfo = s.a(packageManager3, str, 128);
                    } catch (PackageManager.NameNotFoundException unused2) {
                        applicationInfo = null;
                    }
                    if (applicationInfo != null) {
                        String str2 = applicationInfo.packageName;
                        kotlin.jvm.internal.m.d(str2, "packageName");
                        C2048f Y4 = a5.Y(str2);
                        kotlin.jvm.internal.m.b(packageManager);
                        fVar = z(applicationInfo, Y4, packageInfo, a5, context, packageManager, f02, g02);
                    }
                }
                a5.i();
                return fVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final ArrayList B(Context context) {
        ArrayList arrayList;
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        PackageInfo packageInfo2;
        t tVar;
        C2048f fVar;
        Context context2 = context;
        kotlin.jvm.internal.m.e(context2, "context");
        synchronized (UptodownApp.f17422D.h()) {
            arrayList = new ArrayList();
            t a5 = t.f21927u.a(context2);
            a5.a();
            PackageManager packageManager = context2.getPackageManager();
            kotlin.jvm.internal.m.b(packageManager);
            List<ApplicationInfo> b5 = s.b(packageManager, 128);
            ArrayList b02 = a5.b0();
            a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
            boolean f02 = aVar.f0(context2);
            boolean g02 = aVar.g0(context2);
            for (ApplicationInfo applicationInfo2 : b5) {
                try {
                    String str = applicationInfo2.packageName;
                    kotlin.jvm.internal.m.d(str, "packageName");
                    packageInfo = s.d(packageManager, str, 0);
                } catch (PackageManager.NameNotFoundException unused) {
                    packageInfo = null;
                }
                if (packageInfo != null) {
                    Iterator it = b02.iterator();
                    int i4 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            applicationInfo = applicationInfo2;
                            packageInfo2 = packageInfo;
                            tVar = a5;
                            i4 = -1;
                            fVar = null;
                            break;
                        }
                        int i5 = i4 + 1;
                        C2048f fVar2 = (C2048f) it.next();
                        applicationInfo = applicationInfo2;
                        packageInfo2 = packageInfo;
                        tVar = a5;
                        if (m3.m.q(fVar2.o(), applicationInfo2.packageName, false, 2, (Object) null)) {
                            fVar = fVar2;
                            break;
                        }
                        i4 = i5;
                        a5 = tVar;
                        applicationInfo2 = applicationInfo;
                        packageInfo = packageInfo2;
                    }
                    if (i4 >= 0) {
                        b02.remove(i4);
                    }
                    a5 = tVar;
                    arrayList.add(z(applicationInfo, fVar, packageInfo2, a5, context2, packageManager, f02, g02));
                }
                context2 = context;
            }
            Iterator it2 = b02.iterator();
            kotlin.jvm.internal.m.d(it2, "iterator(...)");
            while (it2.hasNext()) {
                Object next = it2.next();
                kotlin.jvm.internal.m.d(next, "next(...)");
                C2048f fVar3 = (C2048f) next;
                a5.u(fVar3);
                if (fVar3.o() != null) {
                    String o4 = fVar3.o();
                    kotlin.jvm.internal.m.b(o4);
                    a5.R(o4);
                }
            }
            a5.i();
        }
        return arrayList;
    }

    public final void D(C2048f fVar, PackageInfo packageInfo, Context context) {
        kotlin.jvm.internal.m.e(fVar, "appTmp");
        kotlin.jvm.internal.m.e(packageInfo, "pInfo");
        kotlin.jvm.internal.m.e(context, "context");
        try {
            fVar.V(packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString());
        } catch (Exception unused) {
            fVar.V(fVar.o());
        }
        try {
            Configuration configuration = new Configuration();
            configuration.setLocale(new Locale("xx"));
            Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(packageInfo.applicationInfo.packageName);
            kotlin.jvm.internal.m.d(resourcesForApplication, "getResourcesForApplication(...)");
            resourcesForApplication.updateConfiguration(configuration, context.getResources().getDisplayMetrics());
            fVar.L(resourcesForApplication.getString(packageInfo.applicationInfo.labelRes));
        } catch (Exception unused2) {
            fVar.L(fVar.m());
        }
        String c5 = fVar.c();
        kotlin.jvm.internal.m.b(c5);
        int length = c5.length();
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                String c6 = fVar.c();
                kotlin.jvm.internal.m.b(c6);
                fVar.L(E(c6));
                break;
            } else if (t(c5.charAt(i4))) {
                fVar.L(fVar.o());
                break;
            } else {
                i4++;
            }
        }
        if (m3.m.p(fVar.c(), "null", true)) {
            fVar.O(1);
        }
    }

    public final long d(ApplicationInfo applicationInfo) {
        kotlin.jvm.internal.m.e(applicationInfo, "aPackage");
        File parentFile = new File(applicationInfo.sourceDir).getParentFile();
        if (parentFile == null || !parentFile.isDirectory()) {
            return 0;
        }
        long h4 = new C1611g().h(parentFile);
        String str = applicationInfo.packageName;
        kotlin.jvm.internal.m.d(str, "packageName");
        String str2 = applicationInfo.packageName;
        kotlin.jvm.internal.m.d(str2, "packageName");
        return h4 + n(str) + m(str2);
    }

    public final Object f(ArrayList arrayList, Context context, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new c(context, arrayList, this, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return R2.s.f8222a;
    }

    public final ArrayList g(ArrayList arrayList) {
        kotlin.jvm.internal.m.e(arrayList, "apps");
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        kotlin.jvm.internal.m.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            kotlin.jvm.internal.m.d(next, "next(...)");
            C2048f fVar = (C2048f) next;
            if (fVar.f() == 0 && fVar.r() != null) {
                arrayList2.add(fVar);
            }
        }
        return arrayList2;
    }

    public final String h(Context context, String str) {
        kotlin.jvm.internal.m.e(context, "context");
        kotlin.jvm.internal.m.e(str, "packageName");
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                return context.getPackageManager().getInstallSourceInfo(str).getInstallingPackageName();
            }
            return context.getPackageManager().getInstallerPackageName(str);
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public final String i(PackageManager packageManager, String str) {
        kotlin.jvm.internal.m.e(packageManager, "pm");
        kotlin.jvm.internal.m.e(str, "packagename");
        return l(packageManager, str, SameMD5.TAG);
    }

    public final String j(PackageManager packageManager, String str) {
        kotlin.jvm.internal.m.e(packageManager, "pm");
        kotlin.jvm.internal.m.e(str, "packagename");
        return l(packageManager, str, "SHA256");
    }

    public final String o(ArrayList arrayList) {
        kotlin.jvm.internal.m.e(arrayList, "apps");
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        kotlin.jvm.internal.m.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            kotlin.jvm.internal.m.d(next, "next(...)");
            C2048f fVar = (C2048f) next;
            if (fVar.r() != null) {
                String r4 = fVar.r();
                kotlin.jvm.internal.m.b(r4);
                arrayList2.add(r4);
                if (fVar.v() != null) {
                    ArrayList v4 = fVar.v();
                    kotlin.jvm.internal.m.b(v4);
                    if (!v4.isEmpty()) {
                        ArrayList v5 = fVar.v();
                        kotlin.jvm.internal.m.b(v5);
                        Iterator it2 = v5.iterator();
                        kotlin.jvm.internal.m.d(it2, "iterator(...)");
                        while (it2.hasNext()) {
                            Object next2 = it2.next();
                            kotlin.jvm.internal.m.d(next2, "next(...)");
                            C2063v vVar = (C2063v) next2;
                            if (vVar.c() != null) {
                                String c5 = vVar.c();
                                kotlin.jvm.internal.m.b(c5);
                                arrayList2.add(c5);
                            }
                        }
                    }
                }
                if (fVar.n() != null) {
                    ArrayList n4 = fVar.n();
                    kotlin.jvm.internal.m.b(n4);
                    if (!n4.isEmpty()) {
                        ArrayList n5 = fVar.n();
                        kotlin.jvm.internal.m.b(n5);
                        Iterator it3 = n5.iterator();
                        kotlin.jvm.internal.m.d(it3, "iterator(...)");
                        while (it3.hasNext()) {
                            Object next3 = it3.next();
                            kotlin.jvm.internal.m.d(next3, "next(...)");
                            C2063v vVar2 = (C2063v) next3;
                            if (vVar2.c() != null) {
                                String c6 = vVar2.c();
                                kotlin.jvm.internal.m.b(c6);
                                arrayList2.add(c6);
                            }
                        }
                    }
                }
            }
        }
        C1601o.t(arrayList2, new C2319e(new C2318d()));
        Iterator it4 = arrayList2.iterator();
        kotlin.jvm.internal.m.d(it4, "iterator(...)");
        String str = null;
        while (it4.hasNext()) {
            Object next4 = it4.next();
            kotlin.jvm.internal.m.d(next4, "next(...)");
            String str2 = (String) next4;
            if (str == null) {
                str = str2;
            } else {
                F f4 = F.f20971a;
                str = String.format("%s%s", Arrays.copyOf(new Object[]{str, str2}, 2));
                kotlin.jvm.internal.m.d(str, "format(...)");
            }
        }
        if (str == null) {
            return str;
        }
        C1610f fVar2 = C1610f.f8672a;
        return fVar2.f(str + Build.VERSION.SDK_INT);
    }

    public final String r(String str) {
        kotlin.jvm.internal.m.e(str, "sha256");
        return "https://www.virustotal.com/gui/file/" + str + "/detection";
    }

    public final boolean s(String str, Context context) {
        PackageInfo packageInfo = null;
        if (!(str == null || context == null)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageInfo = s.d(packageManager, str, 0);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (packageInfo != null) {
            return true;
        }
        return false;
    }

    public final boolean x(String str) {
        if (str != null && !m3.m.x(str, "org.chromium.webapk.", true)) {
            return Pattern.compile("^[a-zA-Z]\\w*(\\.\\w+)+$").matcher(str).matches();
        }
        return false;
    }

    public final boolean y(Context context) {
        kotlin.jvm.internal.m.e(context, "context");
        String str = Build.BRAND;
        String str2 = Build.MANUFACTURER;
        if (m3.m.p(str, "Xiaomi", true) || m3.m.p(str2, "Xiaomi", true) || m3.m.p(str, "Poco", true)) {
            return true;
        }
        t a5 = t.f21927u.a(context);
        a5.a();
        ArrayList b02 = a5.b0();
        a5.i();
        Iterator it = b02.iterator();
        kotlin.jvm.internal.m.d(it, "iterator(...)");
        int i4 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            kotlin.jvm.internal.m.d(next, "next(...)");
            if (v((C2048f) next) && (i4 = i4 + 1) > 5) {
                break;
            }
        }
        if (i4 > 5) {
            return true;
        }
        return false;
    }
}
