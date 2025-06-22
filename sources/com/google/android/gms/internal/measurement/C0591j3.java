package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import l0.c;

/* renamed from: com.google.android.gms.internal.measurement.j3  reason: case insensitive filesystem */
public abstract class C0591j3 {

    /* renamed from: h  reason: collision with root package name */
    private static final Object f1949h = new Object();

    /* renamed from: i  reason: collision with root package name */
    private static volatile C0683u3 f1950i;

    /* renamed from: j  reason: collision with root package name */
    private static C0715y3 f1951j = new C0715y3(new C0636o3());

    /* renamed from: k  reason: collision with root package name */
    private static final AtomicInteger f1952k = new AtomicInteger();

    /* renamed from: a  reason: collision with root package name */
    private final C0659r3 f1953a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1954b;

    /* renamed from: c  reason: collision with root package name */
    private Object f1955c;

    /* renamed from: d  reason: collision with root package name */
    private volatile int f1956d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Object f1957e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f1958f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f1959g;

    static {
        new AtomicReference();
    }

    static /* synthetic */ C0591j3 a(C0659r3 r3Var, String str, Boolean bool, boolean z4) {
        return new C0652q3(r3Var, str, bool, true);
    }

    static /* synthetic */ C0591j3 b(C0659r3 r3Var, String str, Double d5, boolean z4) {
        return new C0644p3(r3Var, str, d5, true);
    }

    static /* synthetic */ C0591j3 c(C0659r3 r3Var, String str, Long l4, boolean z4) {
        return new C0627n3(r3Var, str, l4, true);
    }

    static /* synthetic */ C0591j3 d(C0659r3 r3Var, String str, String str2, boolean z4) {
        return new C0667s3(r3Var, str, str2, true);
    }

    private final Object f(C0683u3 u3Var) {
        c cVar;
        String str;
        C0659r3 r3Var = this.f1953a;
        if (!r3Var.f2128e && ((cVar = r3Var.f2132i) == null || ((Boolean) cVar.apply(u3Var.a())).booleanValue())) {
            C0528c3 a5 = C0528c3.a(u3Var.a());
            C0659r3 r3Var2 = this.f1953a;
            if (r3Var2.f2128e) {
                str = null;
            } else {
                str = h(r3Var2.f2126c);
            }
            Object c5 = a5.c(str);
            if (c5 != null) {
                return g(c5);
            }
        }
        return null;
    }

    private final String h(String str) {
        if (str != null && str.isEmpty()) {
            return this.f1954b;
        }
        String str2 = this.f1954b;
        return str + str2;
    }

    private final Object j(C0683u3 u3Var) {
        C0519b3 b3Var;
        Object c5;
        if (this.f1953a.f2125b == null) {
            b3Var = C0699w3.b(u3Var.a(), this.f1953a.f2124a, new C0618m3());
        } else if (!C0582i3.b(u3Var.a(), this.f1953a.f2125b)) {
            b3Var = null;
        } else if (this.f1953a.f2131h) {
            b3Var = U2.a(u3Var.a().getContentResolver(), C0600k3.a(C0600k3.b(u3Var.a(), this.f1953a.f2125b.getLastPathSegment())), new C0618m3());
        } else {
            b3Var = U2.a(u3Var.a().getContentResolver(), this.f1953a.f2125b, new C0618m3());
        }
        if (b3Var == null || (c5 = b3Var.c(k())) == null) {
            return null;
        }
        return g(c5);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static void l(android.content.Context r3) {
        /*
            com.google.android.gms.internal.measurement.u3 r0 = f1950i
            if (r0 != 0) goto L_0x004e
            if (r3 != 0) goto L_0x0007
            goto L_0x004e
        L_0x0007:
            java.lang.Object r0 = f1949h
            monitor-enter(r0)
            com.google.android.gms.internal.measurement.u3 r1 = f1950i     // Catch:{ all -> 0x0048 }
            if (r1 != 0) goto L_0x004a
            monitor-enter(r0)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.measurement.u3 r1 = f1950i     // Catch:{ all -> 0x0022 }
            android.content.Context r2 = r3.getApplicationContext()     // Catch:{ all -> 0x0022 }
            if (r2 != 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r3 = r2
        L_0x0019:
            if (r1 == 0) goto L_0x0024
            android.content.Context r2 = r1.a()     // Catch:{ all -> 0x0022 }
            if (r2 == r3) goto L_0x0044
            goto L_0x0024
        L_0x0022:
            r3 = move-exception
            goto L_0x0046
        L_0x0024:
            if (r1 == 0) goto L_0x002f
            com.google.android.gms.internal.measurement.U2.e()     // Catch:{ all -> 0x0022 }
            com.google.android.gms.internal.measurement.C0699w3.d()     // Catch:{ all -> 0x0022 }
            com.google.android.gms.internal.measurement.C0528c3.b()     // Catch:{ all -> 0x0022 }
        L_0x002f:
            com.google.android.gms.internal.measurement.l3 r1 = new com.google.android.gms.internal.measurement.l3     // Catch:{ all -> 0x0022 }
            r1.<init>(r3)     // Catch:{ all -> 0x0022 }
            l0.k r1 = l0.l.a(r1)     // Catch:{ all -> 0x0022 }
            com.google.android.gms.internal.measurement.V2 r2 = new com.google.android.gms.internal.measurement.V2     // Catch:{ all -> 0x0022 }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x0022 }
            f1950i = r2     // Catch:{ all -> 0x0022 }
            java.util.concurrent.atomic.AtomicInteger r3 = f1952k     // Catch:{ all -> 0x0022 }
            r3.incrementAndGet()     // Catch:{ all -> 0x0022 }
        L_0x0044:
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            goto L_0x004a
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            throw r3     // Catch:{ all -> 0x0048 }
        L_0x0048:
            r3 = move-exception
            goto L_0x004c
        L_0x004a:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x004c:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r3
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C0591j3.l(android.content.Context):void");
    }

    public static void m() {
        f1952k.incrementAndGet();
    }

    static /* synthetic */ boolean n() {
        return true;
    }

    private final Object o() {
        return this.f1955c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0086 A[Catch:{ all -> 0x004e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e() {
        /*
            r8 = this;
            boolean r0 = r8.f1958f
            if (r0 != 0) goto L_0x0011
            com.google.android.gms.internal.measurement.y3 r0 = f1951j
            java.lang.String r1 = r8.f1954b
            boolean r0 = r0.a(r1)
            java.lang.String r1 = "Attempt to access PhenotypeFlag not via codegen. All new PhenotypeFlags must be accessed through codegen APIs. If you believe you are seeing this error by mistake, you can add your flag to the exemption list located at //java/com/google/android/libraries/phenotype/client/lockdown/flags.textproto. Send the addition CL to ph-reviews@. See go/phenotype-android-codegen for information about generated code. See go/ph-lockdown for more information about this error."
            l0.h.o(r0, r1)
        L_0x0011:
            java.util.concurrent.atomic.AtomicInteger r0 = f1952k
            int r0 = r0.get()
            int r1 = r8.f1956d
            if (r1 >= r0) goto L_0x0099
            monitor-enter(r8)
            int r1 = r8.f1956d     // Catch:{ all -> 0x004e }
            if (r1 >= r0) goto L_0x0095
            com.google.android.gms.internal.measurement.u3 r1 = f1950i     // Catch:{ all -> 0x004e }
            l0.g r2 = l0.g.a()     // Catch:{ all -> 0x004e }
            r3 = 0
            if (r1 == 0) goto L_0x0050
            l0.k r2 = r1.b()     // Catch:{ all -> 0x004e }
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x004e }
            l0.g r2 = (l0.g) r2     // Catch:{ all -> 0x004e }
            boolean r4 = r2.c()     // Catch:{ all -> 0x004e }
            if (r4 == 0) goto L_0x0050
            java.lang.Object r3 = r2.b()     // Catch:{ all -> 0x004e }
            com.google.android.gms.internal.measurement.h3 r3 = (com.google.android.gms.internal.measurement.C0573h3) r3     // Catch:{ all -> 0x004e }
            com.google.android.gms.internal.measurement.r3 r4 = r8.f1953a     // Catch:{ all -> 0x004e }
            android.net.Uri r5 = r4.f2125b     // Catch:{ all -> 0x004e }
            java.lang.String r6 = r4.f2124a     // Catch:{ all -> 0x004e }
            java.lang.String r4 = r4.f2127d     // Catch:{ all -> 0x004e }
            java.lang.String r7 = r8.f1954b     // Catch:{ all -> 0x004e }
            java.lang.String r3 = r3.a(r5, r6, r4, r7)     // Catch:{ all -> 0x004e }
            goto L_0x0050
        L_0x004e:
            r0 = move-exception
            goto L_0x0097
        L_0x0050:
            if (r1 == 0) goto L_0x0054
            r4 = 1
            goto L_0x0055
        L_0x0054:
            r4 = 0
        L_0x0055:
            java.lang.String r5 = "Must call PhenotypeFlagInitializer.maybeInit() first"
            l0.h.o(r4, r5)     // Catch:{ all -> 0x004e }
            com.google.android.gms.internal.measurement.r3 r4 = r8.f1953a     // Catch:{ all -> 0x004e }
            boolean r4 = r4.f2129f     // Catch:{ all -> 0x004e }
            if (r4 == 0) goto L_0x006e
            java.lang.Object r4 = r8.f(r1)     // Catch:{ all -> 0x004e }
            if (r4 == 0) goto L_0x0067
            goto L_0x0080
        L_0x0067:
            java.lang.Object r4 = r8.j(r1)     // Catch:{ all -> 0x004e }
            if (r4 == 0) goto L_0x007c
            goto L_0x0080
        L_0x006e:
            java.lang.Object r4 = r8.j(r1)     // Catch:{ all -> 0x004e }
            if (r4 == 0) goto L_0x0075
            goto L_0x0080
        L_0x0075:
            java.lang.Object r4 = r8.f(r1)     // Catch:{ all -> 0x004e }
            if (r4 == 0) goto L_0x007c
            goto L_0x0080
        L_0x007c:
            java.lang.Object r4 = r8.o()     // Catch:{ all -> 0x004e }
        L_0x0080:
            boolean r1 = r2.c()     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x0091
            if (r3 != 0) goto L_0x008d
            java.lang.Object r4 = r8.o()     // Catch:{ all -> 0x004e }
            goto L_0x0091
        L_0x008d:
            java.lang.Object r4 = r8.g(r3)     // Catch:{ all -> 0x004e }
        L_0x0091:
            r8.f1957e = r4     // Catch:{ all -> 0x004e }
            r8.f1956d = r0     // Catch:{ all -> 0x004e }
        L_0x0095:
            monitor-exit(r8)     // Catch:{ all -> 0x004e }
            goto L_0x0099
        L_0x0097:
            monitor-exit(r8)     // Catch:{ all -> 0x004e }
            throw r0
        L_0x0099:
            java.lang.Object r0 = r8.f1957e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C0591j3.e():java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    public abstract Object g(Object obj);

    public final String k() {
        return h(this.f1953a.f2127d);
    }

    private C0591j3(C0659r3 r3Var, String str, Object obj, boolean z4) {
        this.f1956d = -1;
        String str2 = r3Var.f2124a;
        if (str2 == null && r3Var.f2125b == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        } else if (str2 == null || r3Var.f2125b == null) {
            this.f1953a = r3Var;
            this.f1954b = str;
            this.f1955c = obj;
            this.f1958f = z4;
            this.f1959g = false;
        } else {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
    }
}
