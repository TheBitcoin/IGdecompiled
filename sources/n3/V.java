package N3;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.m;

public final class V {

    /* renamed from: a  reason: collision with root package name */
    public static final V f23658a = new V();

    /* renamed from: b  reason: collision with root package name */
    private static final int f23659b = 65536;

    /* renamed from: c  reason: collision with root package name */
    private static final U f23660c = new U(new byte[0], 0, 0, false, false);

    /* renamed from: d  reason: collision with root package name */
    private static final int f23661d;

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReference[] f23662e;

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f23661d = highestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i4 = 0; i4 < highestOneBit; i4++) {
            atomicReferenceArr[i4] = new AtomicReference();
        }
        f23662e = atomicReferenceArr;
    }

    private V() {
    }

    private final AtomicReference a() {
        return f23662e[(int) (Thread.currentThread().getId() & (((long) f23661d) - 1))];
    }

    public static final void b(U u4) {
        int i4;
        m.e(u4, "segment");
        if (u4.f23656f != null || u4.f23657g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        } else if (!u4.f23654d) {
            AtomicReference a5 = f23658a.a();
            U u5 = f23660c;
            U u6 = (U) a5.getAndSet(u5);
            if (u6 != u5) {
                if (u6 != null) {
                    i4 = u6.f23653c;
                } else {
                    i4 = 0;
                }
                if (i4 >= f23659b) {
                    a5.set(u6);
                    return;
                }
                u4.f23656f = u6;
                u4.f23652b = 0;
                u4.f23653c = i4 + 8192;
                a5.set(u4);
            }
        }
    }

    public static final U c() {
        AtomicReference a5 = f23658a.a();
        U u4 = f23660c;
        U u5 = (U) a5.getAndSet(u4);
        if (u5 == u4) {
            return new U();
        }
        if (u5 == null) {
            a5.set((Object) null);
            return new U();
        }
        a5.set(u5.f23656f);
        u5.f23656f = null;
        u5.f23653c = 0;
        return u5;
    }
}
