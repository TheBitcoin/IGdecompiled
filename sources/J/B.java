package J;

import java.lang.ref.WeakReference;

abstract class B extends z {

    /* renamed from: k  reason: collision with root package name */
    private static final WeakReference f290k = new WeakReference((Object) null);

    /* renamed from: b  reason: collision with root package name */
    private WeakReference f291b = f290k;

    B(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: package-private */
    public final byte[] l0() {
        byte[] bArr;
        synchronized (this) {
            try {
                bArr = (byte[]) this.f291b.get();
                if (bArr == null) {
                    bArr = m0();
                    this.f291b = new WeakReference(bArr);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public abstract byte[] m0();
}
