package androidx.datastore.core;

public final class NativeSharedCounter {
    public final native long nativeCreateSharedCounter(int i4);

    public final native int nativeGetCounterValue(long j4);

    public final native int nativeIncrementAndGetCounterValue(long j4);

    public final native int nativeTruncateFile(int i4);
}
