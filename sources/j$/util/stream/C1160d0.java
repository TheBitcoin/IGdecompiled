package j$.util.stream;

import j$.util.N;
import j$.util.Objects;

/* renamed from: j$.util.stream.d0  reason: case insensitive filesystem */
public final class C1160d0 extends C1162d2 {

    /* renamed from: b  reason: collision with root package name */
    public boolean f5490b;

    /* renamed from: c  reason: collision with root package name */
    public final N f5491c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ C1165e0 f5492d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1160d0(C1165e0 e0Var, C1187i2 i2Var) {
        super(i2Var);
        this.f5492d = e0Var;
        C1187i2 i2Var2 = this.f5493a;
        Objects.requireNonNull(i2Var2);
        this.f5491c = new N(i2Var2, 1);
    }

    public final void k(long j4) {
        this.f5493a.k(-1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0026 A[Catch:{ all -> 0x001c, all -> 0x0039 }, LOOP:0: B:11:0x0026->B:14:0x0032, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void accept(long r3) {
        /*
            r2 = this;
            j$.util.stream.e0 r0 = r2.f5492d
            java.lang.Object r0 = r0.f5497n
            j$.time.format.r r0 = (j$.time.format.r) r0
            java.lang.Object r3 = r0.apply(r3)
            j$.util.stream.k0 r3 = (j$.util.stream.C1195k0) r3
            if (r3 == 0) goto L_0x003e
            boolean r4 = r2.f5490b     // Catch:{ all -> 0x001c }
            j$.util.N r0 = r2.f5491c
            if (r4 != 0) goto L_0x001e
            j$.util.stream.k0 r4 = r3.sequential()     // Catch:{ all -> 0x001c }
            r4.forEach(r0)     // Catch:{ all -> 0x001c }
            goto L_0x003e
        L_0x001c:
            r4 = move-exception
            goto L_0x0035
        L_0x001e:
            j$.util.stream.k0 r4 = r3.sequential()     // Catch:{ all -> 0x001c }
            j$.util.c0 r4 = r4.spliterator()     // Catch:{ all -> 0x001c }
        L_0x0026:
            j$.util.stream.i2 r1 = r2.f5493a     // Catch:{ all -> 0x001c }
            boolean r1 = r1.m()     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x003e
            boolean r1 = r4.tryAdvance(r0)     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0026
            goto L_0x003e
        L_0x0035:
            r3.close()     // Catch:{ all -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r3 = move-exception
            r4.addSuppressed(r3)
        L_0x003d:
            throw r4
        L_0x003e:
            if (r3 == 0) goto L_0x0043
            r3.close()
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C1160d0.accept(long):void");
    }

    public final boolean m() {
        this.f5490b = true;
        return this.f5493a.m();
    }
}
