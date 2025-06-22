package j$.util.stream;

/* renamed from: j$.util.stream.l  reason: case insensitive filesystem */
public final class C1199l extends C1167e2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5534b = 2;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5535c;

    /* renamed from: d  reason: collision with root package name */
    public Object f5536d;

    public /* synthetic */ C1199l(C1187i2 i2Var) {
        super(i2Var);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1199l(F3 f32, C1187i2 i2Var) {
        super(i2Var);
        this.f5536d = f32;
        this.f5535c = true;
    }

    public final void k(long j4) {
        switch (this.f5534b) {
            case 0:
                this.f5535c = false;
                this.f5536d = null;
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

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0049 A[Catch:{ all -> 0x003d, all -> 0x005a }, LOOP:0: B:18:0x0049->B:21:0x0053, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void accept(java.lang.Object r4) {
        /*
            r3 = this;
            int r0 = r3.f5534b
            switch(r0) {
                case 0: goto L_0x0065;
                case 1: goto L_0x001d;
                default: goto L_0x0005;
            }
        L_0x0005:
            boolean r0 = r3.f5535c
            if (r0 == 0) goto L_0x001c
            java.lang.Object r0 = r3.f5536d
            j$.util.stream.F3 r0 = (j$.util.stream.F3) r0
            java.util.function.Predicate r0 = r0.f5291n
            boolean r0 = r0.test(r4)
            r3.f5535c = r0
            if (r0 == 0) goto L_0x001c
            j$.util.stream.i2 r0 = r3.f5498a
            r0.accept(r4)
        L_0x001c:
            return
        L_0x001d:
            java.lang.Object r0 = r3.f5536d
            j$.util.stream.r r0 = (j$.util.stream.r) r0
            java.lang.Object r0 = r0.f5577n
            j$.time.format.r r0 = (j$.time.format.r) r0
            java.lang.Object r4 = r0.apply(r4)
            j$.util.stream.Stream r4 = (j$.util.stream.Stream) r4
            if (r4 == 0) goto L_0x005f
            boolean r0 = r3.f5535c     // Catch:{ all -> 0x003d }
            j$.util.stream.i2 r1 = r3.f5498a
            if (r0 != 0) goto L_0x003f
            j$.util.stream.g r0 = r4.sequential()     // Catch:{ all -> 0x003d }
            j$.util.stream.Stream r0 = (j$.util.stream.Stream) r0     // Catch:{ all -> 0x003d }
            r0.forEach(r1)     // Catch:{ all -> 0x003d }
            goto L_0x005f
        L_0x003d:
            r0 = move-exception
            goto L_0x0056
        L_0x003f:
            j$.util.stream.g r0 = r4.sequential()     // Catch:{ all -> 0x003d }
            j$.util.stream.Stream r0 = (j$.util.stream.Stream) r0     // Catch:{ all -> 0x003d }
            j$.util.i0 r0 = r0.spliterator()     // Catch:{ all -> 0x003d }
        L_0x0049:
            boolean r2 = r1.m()     // Catch:{ all -> 0x003d }
            if (r2 != 0) goto L_0x005f
            boolean r2 = r0.tryAdvance(r1)     // Catch:{ all -> 0x003d }
            if (r2 != 0) goto L_0x0049
            goto L_0x005f
        L_0x0056:
            r4.close()     // Catch:{ all -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r4 = move-exception
            r0.addSuppressed(r4)
        L_0x005e:
            throw r0
        L_0x005f:
            if (r4 == 0) goto L_0x0064
            r4.close()
        L_0x0064:
            return
        L_0x0065:
            j$.util.stream.i2 r0 = r3.f5498a
            if (r4 != 0) goto L_0x0077
            boolean r4 = r3.f5535c
            if (r4 != 0) goto L_0x0086
            r4 = 1
            r3.f5535c = r4
            r4 = 0
            r3.f5536d = r4
            r0.accept(r4)
            goto L_0x0086
        L_0x0077:
            java.lang.Object r1 = r3.f5536d
            if (r1 == 0) goto L_0x0081
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L_0x0086
        L_0x0081:
            r3.f5536d = r4
            r0.accept(r4)
        L_0x0086:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C1199l.accept(java.lang.Object):void");
    }

    public boolean m() {
        switch (this.f5534b) {
            case 1:
                this.f5535c = true;
                return this.f5498a.m();
            case 2:
                return !this.f5535c || this.f5498a.m();
            default:
                return super.m();
        }
    }

    public void j() {
        switch (this.f5534b) {
            case 0:
                this.f5535c = false;
                this.f5536d = null;
                this.f5498a.j();
                return;
            default:
                super.j();
                return;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1199l(r rVar, C1187i2 i2Var) {
        super(i2Var);
        this.f5536d = rVar;
    }
}
