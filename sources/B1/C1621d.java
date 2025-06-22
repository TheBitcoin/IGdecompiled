package b1;

import M0.f;

/* renamed from: b1.d  reason: case insensitive filesystem */
public enum C1621d implements f {
    COLLECTION_UNKNOWN(0),
    COLLECTION_SDK_NOT_INSTALLED(1),
    COLLECTION_ENABLED(2),
    COLLECTION_DISABLED(3),
    COLLECTION_DISABLED_REMOTE(4),
    COLLECTION_SAMPLED(5);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f9024a;

    private C1621d(int i4) {
        this.f9024a = i4;
    }

    public int getNumber() {
        return this.f9024a;
    }
}
