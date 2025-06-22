package androidx.datastore.core.okio;

import N3.C2520k;
import N3.Q;
import V2.d;
import androidx.datastore.core.ReadScope;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.m;

public class OkioReadScope<T> implements ReadScope<T> {
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final C2520k fileSystem;
    private final Q path;
    private final OkioSerializer<T> serializer;

    public OkioReadScope(C2520k kVar, Q q4, OkioSerializer<T> okioSerializer) {
        m.e(kVar, "fileSystem");
        m.e(q4, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        m.e(okioSerializer, "serializer");
        this.fileSystem = kVar;
        this.path = q4;
        this.serializer = okioSerializer;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0063 A[SYNTHETIC, Splitter:B:24:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0082 A[SYNTHETIC, Splitter:B:39:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008a A[Catch:{ FileNotFoundException -> 0x0086 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ <T> java.lang.Object readData$suspendImpl(androidx.datastore.core.okio.OkioReadScope<T> r6, V2.d r7) {
        /*
            boolean r0 = r7 instanceof androidx.datastore.core.okio.OkioReadScope$readData$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            androidx.datastore.core.okio.OkioReadScope$readData$1 r0 = (androidx.datastore.core.okio.OkioReadScope$readData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.okio.OkioReadScope$readData$1 r0 = new androidx.datastore.core.okio.OkioReadScope$readData$1
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r6 = r0.L$1
            java.io.Closeable r6 = (java.io.Closeable) r6
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.okio.OkioReadScope r0 = (androidx.datastore.core.okio.OkioReadScope) r0
            R2.n.b(r7)     // Catch:{ all -> 0x0032 }
            goto L_0x0061
        L_0x0032:
            r7 = move-exception
            goto L_0x006f
        L_0x0034:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003c:
            R2.n.b(r7)
            r6.checkClose()
            N3.k r7 = r6.fileSystem     // Catch:{ FileNotFoundException -> 0x0086 }
            N3.Q r2 = r6.path     // Catch:{ FileNotFoundException -> 0x0086 }
            N3.Z r7 = r7.l(r2)     // Catch:{ FileNotFoundException -> 0x0086 }
            N3.g r7 = N3.L.d(r7)     // Catch:{ FileNotFoundException -> 0x0086 }
            androidx.datastore.core.okio.OkioSerializer<T> r2 = r6.serializer     // Catch:{ all -> 0x006a }
            r0.L$0 = r6     // Catch:{ all -> 0x006a }
            r0.L$1 = r7     // Catch:{ all -> 0x006a }
            r0.label = r3     // Catch:{ all -> 0x006a }
            java.lang.Object r0 = r2.readFrom(r7, r0)     // Catch:{ all -> 0x006a }
            if (r0 != r1) goto L_0x005d
            return r1
        L_0x005d:
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
        L_0x0061:
            if (r6 == 0) goto L_0x0068
            r6.close()     // Catch:{ all -> 0x0067 }
            goto L_0x0068
        L_0x0067:
            r4 = move-exception
        L_0x0068:
            r6 = r0
            goto L_0x0080
        L_0x006a:
            r0 = move-exception
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
        L_0x006f:
            if (r6 == 0) goto L_0x007c
            r6.close()     // Catch:{ all -> 0x0075 }
            goto L_0x007c
        L_0x0075:
            r6 = move-exception
            R2.a.a(r7, r6)     // Catch:{ FileNotFoundException -> 0x007a }
            goto L_0x007c
        L_0x007a:
            r6 = move-exception
            goto L_0x008b
        L_0x007c:
            r6 = r4
            r4 = r7
            r7 = r6
            goto L_0x0068
        L_0x0080:
            if (r4 != 0) goto L_0x008a
            kotlin.jvm.internal.m.b(r7)     // Catch:{ FileNotFoundException -> 0x0086 }
            goto L_0x009b
        L_0x0086:
            r7 = move-exception
            r0 = r6
            r6 = r7
            goto L_0x008b
        L_0x008a:
            throw r4     // Catch:{ FileNotFoundException -> 0x0086 }
        L_0x008b:
            N3.k r7 = r0.fileSystem
            N3.Q r1 = r0.path
            boolean r7 = r7.g(r1)
            if (r7 != 0) goto L_0x009c
            androidx.datastore.core.okio.OkioSerializer<T> r6 = r0.serializer
            java.lang.Object r7 = r6.getDefaultValue()
        L_0x009b:
            return r7
        L_0x009c:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioReadScope.readData$suspendImpl(androidx.datastore.core.okio.OkioReadScope, V2.d):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public final void checkClose() {
        if (this.closed.get()) {
            throw new IllegalStateException("This scope has already been closed.");
        }
    }

    public void close() {
        this.closed.set(true);
    }

    /* access modifiers changed from: protected */
    public final C2520k getFileSystem() {
        return this.fileSystem;
    }

    /* access modifiers changed from: protected */
    public final Q getPath() {
        return this.path;
    }

    /* access modifiers changed from: protected */
    public final OkioSerializer<T> getSerializer() {
        return this.serializer;
    }

    public Object readData(d dVar) {
        return readData$suspendImpl(this, dVar);
    }
}
