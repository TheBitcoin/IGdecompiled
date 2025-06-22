package androidx.datastore.core;

import android.os.ParcelFileDescriptor;
import java.io.IOException;
import kotlin.jvm.internal.C2103g;

public final class SharedCounter {
    public static final Factory Factory = new Factory((C2103g) null);
    /* access modifiers changed from: private */
    public static final NativeSharedCounter nativeSharedCounter = new NativeSharedCounter();
    private final long mappedAddress;

    public static final class Factory {
        public /* synthetic */ Factory(C2103g gVar) {
            this();
        }

        private final SharedCounter createCounterFromFd(ParcelFileDescriptor parcelFileDescriptor) {
            int fd = parcelFileDescriptor.getFd();
            if (getNativeSharedCounter$datastore_core_release().nativeTruncateFile(fd) == 0) {
                long nativeCreateSharedCounter = getNativeSharedCounter$datastore_core_release().nativeCreateSharedCounter(fd);
                if (nativeCreateSharedCounter >= 0) {
                    return new SharedCounter(nativeCreateSharedCounter, (C2103g) null);
                }
                throw new IOException("Failed to mmap counter file");
            }
            throw new IOException("Failed to truncate counter file");
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.datastore.core.SharedCounter create$datastore_core_release(d3.a r2) {
            /*
                r1 = this;
                java.lang.String r0 = "produceFile"
                kotlin.jvm.internal.m.e(r2, r0)
                java.lang.Object r2 = r2.invoke()
                java.io.File r2 = (java.io.File) r2
                r0 = 939524096(0x38000000, float:3.0517578E-5)
                android.os.ParcelFileDescriptor r2 = android.os.ParcelFileDescriptor.open(r2, r0)     // Catch:{ all -> 0x001d }
                androidx.datastore.core.SharedCounter r0 = r1.createCounterFromFd(r2)     // Catch:{ all -> 0x001b }
                if (r2 == 0) goto L_0x001a
                r2.close()
            L_0x001a:
                return r0
            L_0x001b:
                r0 = move-exception
                goto L_0x001f
            L_0x001d:
                r0 = move-exception
                r2 = 0
            L_0x001f:
                if (r2 == 0) goto L_0x0024
                r2.close()
            L_0x0024:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SharedCounter.Factory.create$datastore_core_release(d3.a):androidx.datastore.core.SharedCounter");
        }

        public final NativeSharedCounter getNativeSharedCounter$datastore_core_release() {
            return SharedCounter.nativeSharedCounter;
        }

        public final void loadLib() {
            System.loadLibrary("datastore_shared_counter");
        }

        private Factory() {
        }
    }

    public /* synthetic */ SharedCounter(long j4, C2103g gVar) {
        this(j4);
    }

    public final int getValue() {
        return nativeSharedCounter.nativeGetCounterValue(this.mappedAddress);
    }

    public final int incrementAndGetValue() {
        return nativeSharedCounter.nativeIncrementAndGetCounterValue(this.mappedAddress);
    }

    private SharedCounter(long j4) {
        this.mappedAddress = j4;
    }
}
