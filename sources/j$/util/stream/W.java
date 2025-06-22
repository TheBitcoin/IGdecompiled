package j$.util.stream;

import j$.util.J;
import j$.util.Objects;

public final class W extends C1157c2 {

    /* renamed from: b  reason: collision with root package name */
    public boolean f5414b;

    /* renamed from: c  reason: collision with root package name */
    public final J f5415c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ U f5416d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public W(U u4, C1187i2 i2Var) {
        super(i2Var);
        this.f5416d = u4;
        C1187i2 i2Var2 = this.f5481a;
        Objects.requireNonNull(i2Var2);
        this.f5415c = new J(i2Var2, 1);
    }

    public final void k(long j4) {
        this.f5481a.k(-1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0026 A[Catch:{ all -> 0x001c, all -> 0x0039 }, LOOP:0: B:11:0x0026->B:14:0x0032, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void accept(int r4) {
        /*
            r3 = this;
            j$.util.stream.U r0 = r3.f5416d
            java.lang.Object r0 = r0.f5408n
            j$.util.stream.K r0 = (j$.util.stream.K) r0
            java.lang.Object r4 = r0.apply(r4)
            j$.util.stream.IntStream r4 = (j$.util.stream.IntStream) r4
            if (r4 == 0) goto L_0x003e
            boolean r0 = r3.f5414b     // Catch:{ all -> 0x001c }
            j$.util.J r1 = r3.f5415c
            if (r0 != 0) goto L_0x001e
            j$.util.stream.IntStream r0 = r4.sequential()     // Catch:{ all -> 0x001c }
            r0.forEach(r1)     // Catch:{ all -> 0x001c }
            goto L_0x003e
        L_0x001c:
            r0 = move-exception
            goto L_0x0035
        L_0x001e:
            j$.util.stream.IntStream r0 = r4.sequential()     // Catch:{ all -> 0x001c }
            j$.util.Z r0 = r0.spliterator()     // Catch:{ all -> 0x001c }
        L_0x0026:
            j$.util.stream.i2 r2 = r3.f5481a     // Catch:{ all -> 0x001c }
            boolean r2 = r2.m()     // Catch:{ all -> 0x001c }
            if (r2 != 0) goto L_0x003e
            boolean r2 = r0.tryAdvance(r1)     // Catch:{ all -> 0x001c }
            if (r2 != 0) goto L_0x0026
            goto L_0x003e
        L_0x0035:
            r4.close()     // Catch:{ all -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r4 = move-exception
            r0.addSuppressed(r4)
        L_0x003d:
            throw r0
        L_0x003e:
            if (r4 == 0) goto L_0x0043
            r4.close()
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.W.accept(int):void");
    }

    public final boolean m() {
        this.f5414b = true;
        return this.f5481a.m();
    }
}
