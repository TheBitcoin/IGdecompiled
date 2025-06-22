package androidx.datastore.core;

import V2.d;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.m;

public class FileReadScope<T> implements ReadScope<T> {
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final File file;
    private final Serializer<T> serializer;

    public FileReadScope(File file2, Serializer<T> serializer2) {
        m.e(file2, "file");
        m.e(serializer2, "serializer");
        this.file = file2;
        this.serializer = serializer2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006f, code lost:
        r7 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0078, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        b3.C1642b.a(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007c, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0086, code lost:
        r8 = new java.io.FileInputStream(r7.file);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r7 = r7.serializer;
        r0.L$0 = r8;
        r0.L$1 = null;
        r0.label = 2;
        r7 = r7.readFrom(r8, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0099, code lost:
        if (r7 != r1) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x009c, code lost:
        r6 = r8;
        r8 = r7;
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a3, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00a4, code lost:
        r6 = r8;
        r8 = r7;
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a9, code lost:
        b3.C1642b.a(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ac, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00b3, code lost:
        return r7.serializer.getDefaultValue();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:27:0x006b, B:34:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ <T> java.lang.Object readData$suspendImpl(androidx.datastore.core.FileReadScope<T> r7, V2.d r8) {
        /*
            boolean r0 = r8 instanceof androidx.datastore.core.FileReadScope$readData$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            androidx.datastore.core.FileReadScope$readData$1 r0 = (androidx.datastore.core.FileReadScope$readData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.FileReadScope$readData$1 r0 = new androidx.datastore.core.FileReadScope$readData$1
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x004b
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r7 = r0.L$0
            java.io.Closeable r7 = (java.io.Closeable) r7
            R2.n.b(r8)     // Catch:{ all -> 0x0032 }
            goto L_0x009f
        L_0x0032:
            r8 = move-exception
            goto L_0x00a7
        L_0x0035:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003d:
            java.lang.Object r7 = r0.L$1
            java.io.Closeable r7 = (java.io.Closeable) r7
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.FileReadScope r2 = (androidx.datastore.core.FileReadScope) r2
            R2.n.b(r8)     // Catch:{ all -> 0x0049 }
            goto L_0x006b
        L_0x0049:
            r8 = move-exception
            goto L_0x0077
        L_0x004b:
            R2.n.b(r8)
            r7.checkNotClosed()
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x007d }
            java.io.File r2 = r7.file     // Catch:{ FileNotFoundException -> 0x007d }
            r8.<init>(r2)     // Catch:{ FileNotFoundException -> 0x007d }
            androidx.datastore.core.Serializer<T> r2 = r7.serializer     // Catch:{ all -> 0x0072 }
            r0.L$0 = r7     // Catch:{ all -> 0x0072 }
            r0.L$1 = r8     // Catch:{ all -> 0x0072 }
            r0.label = r4     // Catch:{ all -> 0x0072 }
            java.lang.Object r2 = r2.readFrom(r8, r0)     // Catch:{ all -> 0x0072 }
            if (r2 != r1) goto L_0x0067
            goto L_0x009b
        L_0x0067:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L_0x006b:
            b3.C1642b.a(r7, r5)     // Catch:{ FileNotFoundException -> 0x006f }
            return r8
        L_0x006f:
            r7 = r2
            goto L_0x007e
        L_0x0072:
            r2 = move-exception
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L_0x0077:
            throw r8     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r4 = move-exception
            b3.C1642b.a(r7, r8)     // Catch:{ FileNotFoundException -> 0x006f }
            throw r4     // Catch:{ FileNotFoundException -> 0x006f }
        L_0x007d:
        L_0x007e:
            java.io.File r8 = r7.file
            boolean r8 = r8.exists()
            if (r8 == 0) goto L_0x00ad
            java.io.FileInputStream r8 = new java.io.FileInputStream
            java.io.File r2 = r7.file
            r8.<init>(r2)
            androidx.datastore.core.Serializer<T> r7 = r7.serializer     // Catch:{ all -> 0x00a3 }
            r0.L$0 = r8     // Catch:{ all -> 0x00a3 }
            r0.L$1 = r5     // Catch:{ all -> 0x00a3 }
            r0.label = r3     // Catch:{ all -> 0x00a3 }
            java.lang.Object r7 = r7.readFrom(r8, r0)     // Catch:{ all -> 0x00a3 }
            if (r7 != r1) goto L_0x009c
        L_0x009b:
            return r1
        L_0x009c:
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x009f:
            b3.C1642b.a(r7, r5)
            return r8
        L_0x00a3:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x00a7:
            throw r8     // Catch:{ all -> 0x00a8 }
        L_0x00a8:
            r0 = move-exception
            b3.C1642b.a(r7, r8)
            throw r0
        L_0x00ad:
            androidx.datastore.core.Serializer<T> r7 = r7.serializer
            java.lang.Object r7 = r7.getDefaultValue()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileReadScope.readData$suspendImpl(androidx.datastore.core.FileReadScope, V2.d):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("This scope has already been closed.");
        }
    }

    public void close() {
        this.closed.set(true);
    }

    /* access modifiers changed from: protected */
    public final File getFile() {
        return this.file;
    }

    /* access modifiers changed from: protected */
    public final Serializer<T> getSerializer() {
        return this.serializer;
    }

    public Object readData(d dVar) {
        return readData$suspendImpl(this, dVar);
    }
}
