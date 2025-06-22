package j$.util.stream;

import j$.util.F;
import j$.util.J;
import j$.util.N;
import j$.util.Objects;

public final class W1 extends C1167e2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5417b = 1;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5418c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f5419d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ C1144a f5420e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public W1(U u4, C1187i2 i2Var) {
        super(i2Var);
        this.f5420e = u4;
        C1187i2 i2Var2 = this.f5498a;
        Objects.requireNonNull(i2Var2);
        this.f5419d = new J(i2Var2, 1);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public W1(C1242w wVar, C1187i2 i2Var) {
        super(i2Var);
        this.f5420e = wVar;
        C1187i2 i2Var2 = this.f5498a;
        Objects.requireNonNull(i2Var2);
        this.f5419d = new F(i2Var2, 1);
    }

    public final void k(long j4) {
        switch (this.f5417b) {
            case 0:
                this.f5498a.k(-1);
                return;
            case 1:
                this.f5498a.k(-1);
                return;
            default:
                this.f5498a.k(-1);
                return;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f A[Catch:{ all -> 0x0025, all -> 0x0042 }, LOOP:0: B:13:0x002f->B:16:0x003b, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0077 A[Catch:{ all -> 0x006d, all -> 0x008a }, LOOP:1: B:35:0x0077->B:38:0x0083, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bf A[Catch:{ all -> 0x00b5, all -> 0x00d2 }, LOOP:2: B:57:0x00bf->B:60:0x00cb, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void accept(java.lang.Object r4) {
        /*
            r3 = this;
            int r0 = r3.f5417b
            switch(r0) {
                case 0: goto L_0x0095;
                case 1: goto L_0x004d;
                default: goto L_0x0005;
            }
        L_0x0005:
            j$.util.stream.a r0 = r3.f5420e
            j$.util.stream.w r0 = (j$.util.stream.C1242w) r0
            java.lang.Object r0 = r0.f5623n
            j$.time.format.r r0 = (j$.time.format.r) r0
            java.lang.Object r4 = r0.apply(r4)
            j$.util.stream.C r4 = (j$.util.stream.C) r4
            if (r4 == 0) goto L_0x0047
            boolean r0 = r3.f5418c     // Catch:{ all -> 0x0025 }
            java.lang.Object r1 = r3.f5419d
            j$.util.F r1 = (j$.util.F) r1
            if (r0 != 0) goto L_0x0027
            j$.util.stream.C r0 = r4.sequential()     // Catch:{ all -> 0x0025 }
            r0.forEach(r1)     // Catch:{ all -> 0x0025 }
            goto L_0x0047
        L_0x0025:
            r0 = move-exception
            goto L_0x003e
        L_0x0027:
            j$.util.stream.C r0 = r4.sequential()     // Catch:{ all -> 0x0025 }
            j$.util.W r0 = r0.spliterator()     // Catch:{ all -> 0x0025 }
        L_0x002f:
            j$.util.stream.i2 r2 = r3.f5498a     // Catch:{ all -> 0x0025 }
            boolean r2 = r2.m()     // Catch:{ all -> 0x0025 }
            if (r2 != 0) goto L_0x0047
            boolean r2 = r0.tryAdvance(r1)     // Catch:{ all -> 0x0025 }
            if (r2 != 0) goto L_0x002f
            goto L_0x0047
        L_0x003e:
            r4.close()     // Catch:{ all -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r4 = move-exception
            r0.addSuppressed(r4)
        L_0x0046:
            throw r0
        L_0x0047:
            if (r4 == 0) goto L_0x004c
            r4.close()
        L_0x004c:
            return
        L_0x004d:
            j$.util.stream.a r0 = r3.f5420e
            j$.util.stream.U r0 = (j$.util.stream.U) r0
            java.lang.Object r0 = r0.f5408n
            j$.time.format.r r0 = (j$.time.format.r) r0
            java.lang.Object r4 = r0.apply(r4)
            j$.util.stream.IntStream r4 = (j$.util.stream.IntStream) r4
            if (r4 == 0) goto L_0x008f
            boolean r0 = r3.f5418c     // Catch:{ all -> 0x006d }
            java.lang.Object r1 = r3.f5419d
            j$.util.J r1 = (j$.util.J) r1
            if (r0 != 0) goto L_0x006f
            j$.util.stream.IntStream r0 = r4.sequential()     // Catch:{ all -> 0x006d }
            r0.forEach(r1)     // Catch:{ all -> 0x006d }
            goto L_0x008f
        L_0x006d:
            r0 = move-exception
            goto L_0x0086
        L_0x006f:
            j$.util.stream.IntStream r0 = r4.sequential()     // Catch:{ all -> 0x006d }
            j$.util.Z r0 = r0.spliterator()     // Catch:{ all -> 0x006d }
        L_0x0077:
            j$.util.stream.i2 r2 = r3.f5498a     // Catch:{ all -> 0x006d }
            boolean r2 = r2.m()     // Catch:{ all -> 0x006d }
            if (r2 != 0) goto L_0x008f
            boolean r2 = r0.tryAdvance(r1)     // Catch:{ all -> 0x006d }
            if (r2 != 0) goto L_0x0077
            goto L_0x008f
        L_0x0086:
            r4.close()     // Catch:{ all -> 0x008a }
            goto L_0x008e
        L_0x008a:
            r4 = move-exception
            r0.addSuppressed(r4)
        L_0x008e:
            throw r0
        L_0x008f:
            if (r4 == 0) goto L_0x0094
            r4.close()
        L_0x0094:
            return
        L_0x0095:
            j$.util.stream.a r0 = r3.f5420e
            j$.util.stream.e0 r0 = (j$.util.stream.C1165e0) r0
            java.lang.Object r0 = r0.f5497n
            j$.time.format.r r0 = (j$.time.format.r) r0
            java.lang.Object r4 = r0.apply(r4)
            j$.util.stream.k0 r4 = (j$.util.stream.C1195k0) r4
            if (r4 == 0) goto L_0x00d7
            boolean r0 = r3.f5418c     // Catch:{ all -> 0x00b5 }
            java.lang.Object r1 = r3.f5419d
            j$.util.N r1 = (j$.util.N) r1
            if (r0 != 0) goto L_0x00b7
            j$.util.stream.k0 r0 = r4.sequential()     // Catch:{ all -> 0x00b5 }
            r0.forEach(r1)     // Catch:{ all -> 0x00b5 }
            goto L_0x00d7
        L_0x00b5:
            r0 = move-exception
            goto L_0x00ce
        L_0x00b7:
            j$.util.stream.k0 r0 = r4.sequential()     // Catch:{ all -> 0x00b5 }
            j$.util.c0 r0 = r0.spliterator()     // Catch:{ all -> 0x00b5 }
        L_0x00bf:
            j$.util.stream.i2 r2 = r3.f5498a     // Catch:{ all -> 0x00b5 }
            boolean r2 = r2.m()     // Catch:{ all -> 0x00b5 }
            if (r2 != 0) goto L_0x00d7
            boolean r2 = r0.tryAdvance(r1)     // Catch:{ all -> 0x00b5 }
            if (r2 != 0) goto L_0x00bf
            goto L_0x00d7
        L_0x00ce:
            r4.close()     // Catch:{ all -> 0x00d2 }
            goto L_0x00d6
        L_0x00d2:
            r4 = move-exception
            r0.addSuppressed(r4)
        L_0x00d6:
            throw r0
        L_0x00d7:
            if (r4 == 0) goto L_0x00dc
            r4.close()
        L_0x00dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.W1.accept(java.lang.Object):void");
    }

    public final boolean m() {
        switch (this.f5417b) {
            case 0:
                this.f5418c = true;
                return this.f5498a.m();
            case 1:
                this.f5418c = true;
                return this.f5498a.m();
            default:
                this.f5418c = true;
                return this.f5498a.m();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public W1(C1165e0 e0Var, C1187i2 i2Var) {
        super(i2Var);
        this.f5420e = e0Var;
        C1187i2 i2Var2 = this.f5498a;
        Objects.requireNonNull(i2Var2);
        this.f5419d = new N(i2Var2, 1);
    }
}
