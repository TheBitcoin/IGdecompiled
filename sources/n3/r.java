package N3;

import java.io.RandomAccessFile;
import kotlin.jvm.internal.m;

public final class r extends C2518i {

    /* renamed from: e  reason: collision with root package name */
    private final RandomAccessFile f23745e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(boolean z4, RandomAccessFile randomAccessFile) {
        super(z4);
        m.e(randomAccessFile, "randomAccessFile");
        this.f23745e = randomAccessFile;
    }

    /* access modifiers changed from: protected */
    public synchronized void n() {
        this.f23745e.close();
    }

    /* access modifiers changed from: protected */
    public synchronized void o() {
        this.f23745e.getFD().sync();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int p(long r2, byte[] r4, int r5, int r6) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.lang.String r0 = "array"
            kotlin.jvm.internal.m.e(r4, r0)     // Catch:{ all -> 0x001f }
            java.io.RandomAccessFile r0 = r1.f23745e     // Catch:{ all -> 0x001f }
            r0.seek(r2)     // Catch:{ all -> 0x001f }
            r2 = 0
        L_0x000c:
            if (r2 >= r6) goto L_0x0021
            java.io.RandomAccessFile r3 = r1.f23745e     // Catch:{ all -> 0x001f }
            int r0 = r6 - r2
            int r3 = r3.read(r4, r5, r0)     // Catch:{ all -> 0x001f }
            r0 = -1
            if (r3 != r0) goto L_0x001d
            if (r2 != 0) goto L_0x0021
            monitor-exit(r1)
            return r0
        L_0x001d:
            int r2 = r2 + r3
            goto L_0x000c
        L_0x001f:
            r2 = move-exception
            goto L_0x0023
        L_0x0021:
            monitor-exit(r1)
            return r2
        L_0x0023:
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: N3.r.p(long, byte[], int, int):int");
    }

    /* access modifiers changed from: protected */
    public synchronized long r() {
        return this.f23745e.length();
    }

    /* access modifiers changed from: protected */
    public synchronized void u(long j4, byte[] bArr, int i4, int i5) {
        m.e(bArr, "array");
        this.f23745e.seek(j4);
        this.f23745e.write(bArr, i4, i5);
    }
}
