package W1;

import S2.C1601o;
import T1.g;
import android.content.Context;
import android.os.Build;
import com.uptodown.core.activities.InstallerActivity;
import d3.p;
import java.io.File;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import m3.j;

public final class C {

    /* renamed from: a  reason: collision with root package name */
    private final Context f8451a;

    /* renamed from: b  reason: collision with root package name */
    private InstallerActivity.a f8452b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList f8453c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList f8454d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private ArrayList f8455e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private ArrayList f8456f = new ArrayList();

    static final class a extends n implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final a f8457a = new a();

        a() {
            super(2);
        }

        /* renamed from: a */
        public final Integer invoke(g gVar, g gVar2) {
            m.e(gVar, "o1");
            m.e(gVar2, "o2");
            return Integer.valueOf(Boolean.compare(!gVar.a(), !gVar2.a()));
        }
    }

    static final class b extends n implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final b f8458a = new b();

        b() {
            super(2);
        }

        /* renamed from: a */
        public final Integer invoke(g gVar, g gVar2) {
            m.e(gVar, "o1");
            m.e(gVar2, "o2");
            return Integer.valueOf(Boolean.compare(!gVar.a(), !gVar2.a()));
        }
    }

    public C(Context context) {
        m.e(context, "context");
        this.f8451a = context;
    }

    private final void h() {
        String[] strArr = Build.SUPPORTED_ABIS;
        m.d(strArr, "SUPPORTED_ABIS");
        int i4 = 0;
        boolean z4 = false;
        for (String str : strArr) {
            ArrayList arrayList = this.f8453c;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                g gVar = (g) obj;
                if (gVar.f() != null) {
                    String f4 = gVar.f();
                    m.b(f4);
                    if (m3.m.p(str, new j("_").g(f4, "-"), true)) {
                        if (!z4) {
                            gVar.g(true);
                            z4 = true;
                        }
                        gVar.h(true);
                    }
                }
            }
        }
        ArrayList arrayList2 = this.f8454d;
        int size2 = arrayList2.size();
        int i6 = 0;
        while (i6 < size2) {
            Object obj2 = arrayList2.get(i6);
            i6++;
            if (((g) obj2).a()) {
                return;
            }
        }
        ArrayList arrayList3 = this.f8454d;
        int size3 = arrayList3.size();
        while (i4 < size3) {
            Object obj3 = arrayList3.get(i4);
            i4++;
            ((g) obj3).g(true);
        }
    }

    private final void i() {
        InstallerActivity.a aVar = this.f8452b;
        if (aVar != null) {
            m.b(aVar);
            if (aVar.a() > -1) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = this.f8453c;
                int size = arrayList2.size();
                int i4 = 0;
                int i5 = 0;
                while (i5 < size) {
                    Object obj = arrayList2.get(i5);
                    i5++;
                    g gVar = (g) obj;
                    m.d(gVar, "item");
                    InstallerActivity.a aVar2 = this.f8452b;
                    m.b(aVar2);
                    if (o(gVar, aVar2.a())) {
                        arrayList.add(gVar);
                    }
                }
                this.f8453c = arrayList;
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = this.f8454d;
                int size2 = arrayList4.size();
                int i6 = 0;
                while (i6 < size2) {
                    Object obj2 = arrayList4.get(i6);
                    i6++;
                    g gVar2 = (g) obj2;
                    m.d(gVar2, "item");
                    InstallerActivity.a aVar3 = this.f8452b;
                    m.b(aVar3);
                    if (o(gVar2, aVar3.a())) {
                        arrayList3.add(gVar2);
                    }
                }
                this.f8454d = arrayList3;
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = this.f8455e;
                int size3 = arrayList6.size();
                int i7 = 0;
                while (i7 < size3) {
                    Object obj3 = arrayList6.get(i7);
                    i7++;
                    g gVar3 = (g) obj3;
                    m.d(gVar3, "item");
                    InstallerActivity.a aVar4 = this.f8452b;
                    m.b(aVar4);
                    if (o(gVar3, aVar4.a())) {
                        arrayList5.add(gVar3);
                    }
                }
                this.f8455e = arrayList5;
                ArrayList arrayList7 = new ArrayList();
                ArrayList arrayList8 = this.f8456f;
                int size4 = arrayList8.size();
                while (i4 < size4) {
                    Object obj4 = arrayList8.get(i4);
                    i4++;
                    g gVar4 = (g) obj4;
                    m.d(gVar4, "item");
                    InstallerActivity.a aVar5 = this.f8452b;
                    m.b(aVar5);
                    if (o(gVar4, aVar5.a())) {
                        arrayList7.add(gVar4);
                    }
                }
                this.f8456f = arrayList7;
            }
        }
    }

    private final boolean o(g gVar, int i4) {
        if (i4 == -1 || gVar.c() == -1 || gVar.c() == i4) {
            return true;
        }
        return false;
    }

    private final void p() {
        C1601o.t(this.f8453c, new v());
        C1601o.t(this.f8453c, new w());
        C1601o.t(this.f8454d, new x());
        C1601o.t(this.f8454d, new y(a.f8457a));
        C1601o.t(this.f8455e, new z());
        C1601o.t(this.f8455e, new A(b.f8458a));
        C1601o.t(this.f8456f, new B());
    }

    /* access modifiers changed from: private */
    public static final int q(g gVar, g gVar2) {
        m.e(gVar, "o1");
        m.e(gVar2, "o2");
        if (gVar.e() == null) {
            return 1;
        }
        if (gVar2.e() == null) {
            return -1;
        }
        File e5 = gVar.e();
        m.b(e5);
        String name = e5.getName();
        m.d(name, "o1.file!!.name");
        File e6 = gVar2.e();
        m.b(e6);
        String name2 = e6.getName();
        m.d(name2, "o2.file!!.name");
        return m3.m.j(name, name2, true);
    }

    /* access modifiers changed from: private */
    public static final int r(g gVar, g gVar2) {
        m.e(gVar, "o1");
        m.e(gVar2, "o2");
        if (gVar.e() == null) {
            return 1;
        }
        if (gVar2.e() == null) {
            return -1;
        }
        return Boolean.compare(!gVar.a(), !gVar2.a());
    }

    /* access modifiers changed from: private */
    public static final int s(g gVar, g gVar2) {
        m.e(gVar, "d1");
        m.e(gVar2, "d2");
        if (gVar.e() == null) {
            return 1;
        }
        if (gVar2.e() == null) {
            return -1;
        }
        File e5 = gVar.e();
        m.b(e5);
        String name = e5.getName();
        m.d(name, "d1.file!!.name");
        File e6 = gVar2.e();
        m.b(e6);
        String name2 = e6.getName();
        m.d(name2, "d2.file!!.name");
        return m3.m.j(name, name2, true);
    }

    /* access modifiers changed from: private */
    public static final int t(p pVar, Object obj, Object obj2) {
        m.e(pVar, "$tmp0");
        return ((Number) pVar.invoke(obj, obj2)).intValue();
    }

    /* access modifiers changed from: private */
    public static final int u(g gVar, g gVar2) {
        m.e(gVar, "d1");
        m.e(gVar2, "d2");
        if (gVar.e() == null) {
            return 1;
        }
        if (gVar2.e() == null) {
            return -1;
        }
        File e5 = gVar.e();
        m.b(e5);
        String name = e5.getName();
        m.d(name, "d1.file!!.name");
        File e6 = gVar2.e();
        m.b(e6);
        String name2 = e6.getName();
        m.d(name2, "d2.file!!.name");
        return m3.m.j(name, name2, true);
    }

    /* access modifiers changed from: private */
    public static final int v(p pVar, Object obj, Object obj2) {
        m.e(pVar, "$tmp0");
        return ((Number) pVar.invoke(obj, obj2)).intValue();
    }

    /* access modifiers changed from: private */
    public static final int w(g gVar, g gVar2) {
        m.e(gVar, "f1");
        m.e(gVar2, "f2");
        if (gVar.e() == null) {
            return 1;
        }
        if (gVar2.e() == null) {
            return -1;
        }
        File e5 = gVar.e();
        m.b(e5);
        String name = e5.getName();
        m.d(name, "f1.file!!.name");
        File e6 = gVar2.e();
        m.b(e6);
        String name2 = e6.getName();
        m.d(name2, "f2.file!!.name");
        return m3.m.j(name, name2, true);
    }

    public final ArrayList j() {
        return this.f8453c;
    }

    public final InstallerActivity.a k() {
        return this.f8452b;
    }

    public final ArrayList l() {
        return this.f8454d;
    }

    public final ArrayList m() {
        return this.f8456f;
    }

    public final ArrayList n() {
        return this.f8455e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x018c, code lost:
        if (r7.equals("arm64_v8a") == false) goto L_0x0220;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0196, code lost:
        if (r7.equals("armeabi_v7a") == false) goto L_0x0220;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x01a0, code lost:
        if (r7.equals("xhdpi") == false) goto L_0x0220;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x01aa, code lost:
        if (r7.equals("tvdpi") == false) goto L_0x0220;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x01b4, code lost:
        if (r7.equals("mips") == false) goto L_0x0220;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x01be, code lost:
        if (r7.equals("mdpi") == false) goto L_0x0220;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01c7, code lost:
        if (r7.equals("ldpi") == false) goto L_0x0220;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01d0, code lost:
        if (r7.equals("hdpi") == false) goto L_0x0220;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01d9, code lost:
        if (r7.equals("x86") != false) goto L_0x0200;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01e2, code lost:
        if (r7.equals("armeabi") == false) goto L_0x0220;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01eb, code lost:
        if (r7.equals("xxhdpi") == false) goto L_0x0220;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01f4, code lost:
        if (r7.equals("x86_64") == false) goto L_0x0220;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01fd, code lost:
        if (r7.equals("mips64") == false) goto L_0x0220;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0200, code lost:
        r9 = new T1.g();
        r9.k(r6);
        r9.l(r7);
        r9.j(r7);
        r9.i(r8);
        r14.f8453c.add(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x021e, code lost:
        if (r7.equals("xxxhdpi") == false) goto L_0x0220;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0220, code lost:
        r9 = new T1.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        r11 = new java.util.Locale.Builder().setLanguage(r7).build();
        r9.j(r11.getDisplayLanguage(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x023a, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x023b, code lost:
        r11.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0258, code lost:
        r9 = new T1.g();
        r9.k(r6);
        r9.l(r7);
        r9.j(r7);
        r9.g(m3.m.p(r7, r0, true));
        r9.h(true);
        r9.i(r8);
        r14.f8454d.add(r9);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void x(java.util.ArrayList r15) {
        /*
            r14 = this;
            java.lang.String r0 = "files"
            kotlin.jvm.internal.m.e(r15, r0)
            android.content.Context r0 = r14.f8451a
            int r1 = N1.i.dpi_device
            java.lang.String r0 = r0.getString(r1)
            java.lang.String r1 = "context.getString(R.string.dpi_device)"
            kotlin.jvm.internal.m.d(r0, r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r14.f8453c = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r14.f8454d = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r14.f8455e = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r14.f8456f = r1
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.String r1 = r1.getLanguage()
            android.content.Context r2 = r14.f8451a
            android.content.pm.PackageManager r2 = r2.getPackageManager()
            int r3 = r15.size()
            r4 = 0
            r5 = 0
        L_0x0042:
            if (r5 >= r3) goto L_0x02a0
            java.lang.Object r6 = r15.get(r5)
            int r5 = r5 + 1
            java.io.File r6 = (java.io.File) r6
            W1.b r7 = new W1.b
            r7.<init>()
            java.lang.String r8 = r6.getAbsolutePath()
            java.lang.String r7 = r7.f(r8)
            W1.a r8 = new W1.a
            r8.<init>()
            int r8 = r8.e(r7)
            java.lang.String r9 = "pm"
            kotlin.jvm.internal.m.d(r2, r9)
            java.lang.String r9 = r6.getAbsolutePath()
            java.lang.String r10 = "file.absolutePath"
            kotlin.jvm.internal.m.d(r9, r10)
            r10 = 128(0x80, float:1.794E-43)
            android.content.pm.PackageInfo r9 = W1.s.c(r2, r9, r10)
            r10 = 1
            if (r9 == 0) goto L_0x010e
            com.uptodown.core.activities.InstallerActivity$a r11 = r14.f8452b
            if (r11 != 0) goto L_0x010e
            android.content.pm.ApplicationInfo r11 = r9.applicationInfo     // Catch:{ Exception -> 0x00c5 }
            if (r11 == 0) goto L_0x0042
            W1.g r11 = new W1.g     // Catch:{ Exception -> 0x00c5 }
            r11.<init>()     // Catch:{ Exception -> 0x00c5 }
            boolean r11 = r11.k(r9)     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r12 = "file"
            if (r11 == 0) goto L_0x00c7
            com.uptodown.core.activities.InstallerActivity$a r7 = new com.uptodown.core.activities.InstallerActivity$a     // Catch:{ Exception -> 0x00c5 }
            kotlin.jvm.internal.m.d(r6, r12)     // Catch:{ Exception -> 0x00c5 }
            r7.<init>(r6)     // Catch:{ Exception -> 0x00c5 }
            r14.f8452b = r7     // Catch:{ Exception -> 0x00c5 }
            kotlin.jvm.internal.m.b(r7)     // Catch:{ Exception -> 0x00c5 }
            r7.f(r8)     // Catch:{ Exception -> 0x00c5 }
            com.uptodown.core.activities.InstallerActivity$a r6 = r14.f8452b     // Catch:{ Exception -> 0x00c5 }
            kotlin.jvm.internal.m.b(r6)     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r7 = r9.packageName     // Catch:{ Exception -> 0x00c5 }
            r6.g(r7)     // Catch:{ Exception -> 0x00c5 }
            com.uptodown.core.activities.InstallerActivity$a r6 = r14.f8452b     // Catch:{ Exception -> 0x00c5 }
            kotlin.jvm.internal.m.b(r6)     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r7 = r9.versionName     // Catch:{ Exception -> 0x00c5 }
            r6.i(r7)     // Catch:{ Exception -> 0x00c5 }
            com.uptodown.core.activities.InstallerActivity$a r6 = r14.f8452b     // Catch:{ Exception -> 0x00c5 }
            kotlin.jvm.internal.m.b(r6)     // Catch:{ Exception -> 0x00c5 }
            W1.h r7 = new W1.h     // Catch:{ Exception -> 0x00c5 }
            r7.<init>()     // Catch:{ Exception -> 0x00c5 }
            long r7 = r7.m(r9)     // Catch:{ Exception -> 0x00c5 }
            r6.h(r7)     // Catch:{ Exception -> 0x00c5 }
            goto L_0x0042
        L_0x00c5:
            r6 = move-exception
            goto L_0x0109
        L_0x00c7:
            java.lang.String r9 = "name=\"com.android.vending.splits\""
            r11 = 2
            r13 = 0
            boolean r7 = m3.m.D(r7, r9, r4, r11, r13)     // Catch:{ Exception -> 0x00c5 }
            if (r7 == 0) goto L_0x00e3
            com.uptodown.core.activities.InstallerActivity$a r7 = new com.uptodown.core.activities.InstallerActivity$a     // Catch:{ Exception -> 0x00c5 }
            kotlin.jvm.internal.m.d(r6, r12)     // Catch:{ Exception -> 0x00c5 }
            r7.<init>(r6)     // Catch:{ Exception -> 0x00c5 }
            r14.f8452b = r7     // Catch:{ Exception -> 0x00c5 }
            kotlin.jvm.internal.m.b(r7)     // Catch:{ Exception -> 0x00c5 }
            r7.f(r8)     // Catch:{ Exception -> 0x00c5 }
            goto L_0x0042
        L_0x00e3:
            T1.g r7 = new T1.g     // Catch:{ Exception -> 0x00c5 }
            r7.<init>()     // Catch:{ Exception -> 0x00c5 }
            r7.k(r6)     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r9 = r6.getName()     // Catch:{ Exception -> 0x00c5 }
            r7.l(r9)     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r6 = r6.getName()     // Catch:{ Exception -> 0x00c5 }
            r7.j(r6)     // Catch:{ Exception -> 0x00c5 }
            r7.g(r10)     // Catch:{ Exception -> 0x00c5 }
            r7.h(r10)     // Catch:{ Exception -> 0x00c5 }
            r7.i(r8)     // Catch:{ Exception -> 0x00c5 }
            java.util.ArrayList r6 = r14.f8456f     // Catch:{ Exception -> 0x00c5 }
            r6.add(r7)     // Catch:{ Exception -> 0x00c5 }
            goto L_0x0042
        L_0x0109:
            r6.printStackTrace()
            goto L_0x0042
        L_0x010e:
            W1.a r9 = new W1.a
            r9.<init>()
            boolean r9 = r9.c(r7)
            if (r9 == 0) goto L_0x0138
            T1.g r7 = new T1.g
            r7.<init>()
            r7.k(r6)
            java.lang.String r6 = r6.getName()
            r7.j(r6)
            r7.g(r10)
            r7.h(r10)
            r7.i(r8)
            java.util.ArrayList r6 = r14.f8456f
            r6.add(r7)
            goto L_0x0042
        L_0x0138:
            W1.a r9 = new W1.a
            r9.<init>()
            boolean r9 = r9.b(r7)
            if (r9 == 0) goto L_0x0169
            T1.g r7 = new T1.g
            r7.<init>()
            r7.k(r6)
            java.lang.String r9 = r6.getName()
            r7.l(r9)
            java.lang.String r6 = r6.getName()
            r7.j(r6)
            r7.g(r10)
            r7.h(r10)
            r7.i(r8)
            java.util.ArrayList r6 = r14.f8456f
            r6.add(r7)
            goto L_0x0042
        L_0x0169:
            W1.a r9 = new W1.a
            r9.<init>()
            boolean r9 = r9.d(r7)
            if (r9 == 0) goto L_0x027a
            W1.a r9 = new W1.a
            r9.<init>()
            java.lang.String r7 = r9.a(r7)
            int r9 = r7.hashCode()
            switch(r9) {
                case -1619189395: goto L_0x0218;
                case -1073971299: goto L_0x01f7;
                case -806050265: goto L_0x01ee;
                case -745448715: goto L_0x01e5;
                case -738963905: goto L_0x01dc;
                case 117110: goto L_0x01d3;
                case 3197941: goto L_0x01ca;
                case 3317105: goto L_0x01c1;
                case 3346896: goto L_0x01b8;
                case 3351711: goto L_0x01ae;
                case 110743451: goto L_0x01a4;
                case 114020461: goto L_0x019a;
                case 146933760: goto L_0x0190;
                case 1433054842: goto L_0x0186;
                default: goto L_0x0184;
            }
        L_0x0184:
            goto L_0x0220
        L_0x0186:
            java.lang.String r9 = "arm64_v8a"
            boolean r9 = r7.equals(r9)
            if (r9 != 0) goto L_0x0200
            goto L_0x0220
        L_0x0190:
            java.lang.String r9 = "armeabi_v7a"
            boolean r9 = r7.equals(r9)
            if (r9 != 0) goto L_0x0200
            goto L_0x0220
        L_0x019a:
            java.lang.String r9 = "xhdpi"
            boolean r9 = r7.equals(r9)
            if (r9 != 0) goto L_0x0258
            goto L_0x0220
        L_0x01a4:
            java.lang.String r9 = "tvdpi"
            boolean r9 = r7.equals(r9)
            if (r9 != 0) goto L_0x0258
            goto L_0x0220
        L_0x01ae:
            java.lang.String r9 = "mips"
            boolean r9 = r7.equals(r9)
            if (r9 != 0) goto L_0x0200
            goto L_0x0220
        L_0x01b8:
            java.lang.String r9 = "mdpi"
            boolean r9 = r7.equals(r9)
            if (r9 != 0) goto L_0x0258
            goto L_0x0220
        L_0x01c1:
            java.lang.String r9 = "ldpi"
            boolean r9 = r7.equals(r9)
            if (r9 != 0) goto L_0x0258
            goto L_0x0220
        L_0x01ca:
            java.lang.String r9 = "hdpi"
            boolean r9 = r7.equals(r9)
            if (r9 != 0) goto L_0x0258
            goto L_0x0220
        L_0x01d3:
            java.lang.String r9 = "x86"
            boolean r9 = r7.equals(r9)
            if (r9 == 0) goto L_0x0220
            goto L_0x0200
        L_0x01dc:
            java.lang.String r9 = "armeabi"
            boolean r9 = r7.equals(r9)
            if (r9 != 0) goto L_0x0200
            goto L_0x0220
        L_0x01e5:
            java.lang.String r9 = "xxhdpi"
            boolean r9 = r7.equals(r9)
            if (r9 != 0) goto L_0x0258
            goto L_0x0220
        L_0x01ee:
            java.lang.String r9 = "x86_64"
            boolean r9 = r7.equals(r9)
            if (r9 != 0) goto L_0x0200
            goto L_0x0220
        L_0x01f7:
            java.lang.String r9 = "mips64"
            boolean r9 = r7.equals(r9)
            if (r9 != 0) goto L_0x0200
            goto L_0x0220
        L_0x0200:
            T1.g r9 = new T1.g
            r9.<init>()
            r9.k(r6)
            r9.l(r7)
            r9.j(r7)
            r9.i(r8)
            java.util.ArrayList r6 = r14.f8453c
            r6.add(r9)
            goto L_0x0042
        L_0x0218:
            java.lang.String r9 = "xxxhdpi"
            boolean r9 = r7.equals(r9)
            if (r9 != 0) goto L_0x0258
        L_0x0220:
            T1.g r9 = new T1.g
            r9.<init>()
            java.util.Locale$Builder r11 = new java.util.Locale$Builder     // Catch:{ Exception -> 0x023a }
            r11.<init>()     // Catch:{ Exception -> 0x023a }
            java.util.Locale$Builder r11 = r11.setLanguage(r7)     // Catch:{ Exception -> 0x023a }
            java.util.Locale r11 = r11.build()     // Catch:{ Exception -> 0x023a }
            java.lang.String r11 = r11.getDisplayLanguage(r11)     // Catch:{ Exception -> 0x023a }
            r9.j(r11)     // Catch:{ Exception -> 0x023a }
            goto L_0x023e
        L_0x023a:
            r11 = move-exception
            r11.printStackTrace()
        L_0x023e:
            r9.k(r6)
            r9.l(r7)
            boolean r6 = m3.m.p(r7, r1, r10)
            r9.g(r6)
            r9.h(r10)
            r9.i(r8)
            java.util.ArrayList r6 = r14.f8455e
            r6.add(r9)
            goto L_0x0042
        L_0x0258:
            T1.g r9 = new T1.g
            r9.<init>()
            r9.k(r6)
            r9.l(r7)
            r9.j(r7)
            boolean r6 = m3.m.p(r7, r0, r10)
            r9.g(r6)
            r9.h(r10)
            r9.i(r8)
            java.util.ArrayList r6 = r14.f8454d
            r6.add(r9)
            goto L_0x0042
        L_0x027a:
            T1.g r7 = new T1.g
            r7.<init>()
            r7.k(r6)
            java.lang.String r9 = r6.getName()
            r7.l(r9)
            java.lang.String r6 = r6.getName()
            r7.j(r6)
            r7.g(r10)
            r7.h(r10)
            r7.i(r8)
            java.util.ArrayList r6 = r14.f8456f
            r6.add(r7)
            goto L_0x0042
        L_0x02a0:
            r14.i()
            r14.h()
            r14.p()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: W1.C.x(java.util.ArrayList):void");
    }

    public final ArrayList y() {
        ArrayList arrayList = new ArrayList();
        InstallerActivity.a aVar = this.f8452b;
        if (aVar != null) {
            m.b(aVar);
            arrayList.add(aVar.b());
        }
        ArrayList arrayList2 = this.f8453c;
        int size = arrayList2.size();
        int i4 = 0;
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList2.get(i5);
            i5++;
            g gVar = (g) obj;
            if (gVar.a()) {
                File e5 = gVar.e();
                m.b(e5);
                arrayList.add(e5);
            }
        }
        ArrayList arrayList3 = this.f8454d;
        int size2 = arrayList3.size();
        int i6 = 0;
        while (i6 < size2) {
            Object obj2 = arrayList3.get(i6);
            i6++;
            g gVar2 = (g) obj2;
            if (gVar2.a()) {
                File e6 = gVar2.e();
                m.b(e6);
                arrayList.add(e6);
            }
        }
        ArrayList arrayList4 = this.f8455e;
        int size3 = arrayList4.size();
        int i7 = 0;
        while (i7 < size3) {
            Object obj3 = arrayList4.get(i7);
            i7++;
            g gVar3 = (g) obj3;
            if (gVar3.a()) {
                File e7 = gVar3.e();
                m.b(e7);
                arrayList.add(e7);
            }
        }
        ArrayList arrayList5 = this.f8456f;
        int size4 = arrayList5.size();
        while (i4 < size4) {
            Object obj4 = arrayList5.get(i4);
            i4++;
            g gVar4 = (g) obj4;
            if (gVar4.a()) {
                File e8 = gVar4.e();
                m.b(e8);
                arrayList.add(e8);
            }
        }
        return arrayList;
    }
}
