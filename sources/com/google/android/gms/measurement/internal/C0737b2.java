package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.b2  reason: case insensitive filesystem */
public final class C0737b2 {

    /* renamed from: g  reason: collision with root package name */
    private static final Object f2865g = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final String f2866a;

    /* renamed from: b  reason: collision with root package name */
    private final Z1 f2867b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f2868c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f2869d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Object f2870e;

    /* renamed from: f  reason: collision with root package name */
    private volatile Object f2871f;

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x004b */
    public final java.lang.Object a(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f2869d
            monitor-enter(r0)
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            if (r4 == 0) goto L_0x0007
            return r4
        L_0x0007:
            com.google.android.gms.measurement.internal.c r4 = com.google.android.gms.measurement.internal.C0751d2.f2933a
            if (r4 != 0) goto L_0x000e
            java.lang.Object r4 = r3.f2868c
            return r4
        L_0x000e:
            java.lang.Object r4 = f2865g
            monitor-enter(r4)
            boolean r0 = com.google.android.gms.measurement.internal.C0741c.a()     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x0024
            java.lang.Object r0 = r3.f2871f     // Catch:{ all -> 0x001e }
            if (r0 != 0) goto L_0x0020
            java.lang.Object r0 = r3.f2868c     // Catch:{ all -> 0x001e }
            goto L_0x0022
        L_0x001e:
            r0 = move-exception
            goto L_0x006f
        L_0x0020:
            java.lang.Object r0 = r3.f2871f     // Catch:{ all -> 0x001e }
        L_0x0022:
            monitor-exit(r4)     // Catch:{ all -> 0x001e }
            return r0
        L_0x0024:
            monitor-exit(r4)     // Catch:{ all -> 0x001e }
            java.util.List r4 = com.google.android.gms.measurement.internal.G.f2456a     // Catch:{ SecurityException -> 0x0049 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ SecurityException -> 0x0049 }
        L_0x002d:
            boolean r0 = r4.hasNext()     // Catch:{ SecurityException -> 0x0049 }
            if (r0 == 0) goto L_0x005d
            java.lang.Object r0 = r4.next()     // Catch:{ SecurityException -> 0x0049 }
            com.google.android.gms.measurement.internal.b2 r0 = (com.google.android.gms.measurement.internal.C0737b2) r0     // Catch:{ SecurityException -> 0x0049 }
            boolean r1 = com.google.android.gms.measurement.internal.C0741c.a()     // Catch:{ SecurityException -> 0x0049 }
            if (r1 != 0) goto L_0x0055
            r1 = 0
            com.google.android.gms.measurement.internal.Z1 r2 = r0.f2867b     // Catch:{ IllegalStateException -> 0x004b }
            if (r2 == 0) goto L_0x004b
            java.lang.Object r1 = r2.A()     // Catch:{ IllegalStateException -> 0x004b }
            goto L_0x004b
        L_0x0049:
            goto L_0x005d
        L_0x004b:
            java.lang.Object r2 = f2865g     // Catch:{ SecurityException -> 0x0049 }
            monitor-enter(r2)     // Catch:{ SecurityException -> 0x0049 }
            r0.f2871f = r1     // Catch:{ all -> 0x0052 }
            monitor-exit(r2)     // Catch:{ all -> 0x0052 }
            goto L_0x002d
        L_0x0052:
            r4 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0052 }
            throw r4     // Catch:{ SecurityException -> 0x0049 }
        L_0x0055:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ SecurityException -> 0x0049 }
            java.lang.String r0 = "Refreshing flag cache must be done on a worker thread."
            r4.<init>(r0)     // Catch:{ SecurityException -> 0x0049 }
            throw r4     // Catch:{ SecurityException -> 0x0049 }
        L_0x005d:
            com.google.android.gms.measurement.internal.Z1 r4 = r3.f2867b
            if (r4 != 0) goto L_0x0064
            java.lang.Object r4 = r3.f2868c
            return r4
        L_0x0064:
            java.lang.Object r4 = r4.A()     // Catch:{ SecurityException -> 0x006c, IllegalStateException -> 0x0069 }
            return r4
        L_0x0069:
            java.lang.Object r4 = r3.f2868c
            return r4
        L_0x006c:
            java.lang.Object r4 = r3.f2868c
            return r4
        L_0x006f:
            monitor-exit(r4)     // Catch:{ all -> 0x001e }
            throw r0
        L_0x0071:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0737b2.a(java.lang.Object):java.lang.Object");
    }

    public final String b() {
        return this.f2866a;
    }

    private C0737b2(String str, Object obj, Object obj2, Z1 z12) {
        this.f2869d = new Object();
        this.f2870e = null;
        this.f2871f = null;
        this.f2866a = str;
        this.f2868c = obj;
        this.f2867b = z12;
    }
}
