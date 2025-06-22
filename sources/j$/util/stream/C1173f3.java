package j$.util.stream;

import j$.util.C1127b;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.concurrent.t;
import j$.util.function.Consumer$CC;
import j$.util.i0;
import java.util.Comparator;
import java.util.function.Consumer;

/* renamed from: j$.util.stream.f3  reason: case insensitive filesystem */
public final class C1173f3 implements i0, Consumer {

    /* renamed from: d  reason: collision with root package name */
    public static final Object f5501d = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final i0 f5502a;

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentHashMap f5503b;

    /* renamed from: c  reason: collision with root package name */
    public Object f5504c;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C1127b.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return C1127b.e(this, i4);
    }

    public C1173f3(i0 i0Var, ConcurrentHashMap concurrentHashMap) {
        this.f5502a = i0Var;
        this.f5503b = concurrentHashMap;
    }

    public final void accept(Object obj) {
        this.f5504c = obj;
    }

    public final boolean tryAdvance(Consumer consumer) {
        while (this.f5502a.tryAdvance(this)) {
            Object obj = this.f5504c;
            if (obj == null) {
                obj = f5501d;
            }
            if (this.f5503b.putIfAbsent(obj, Boolean.TRUE) == null) {
                consumer.accept(this.f5504c);
                this.f5504c = null;
                return true;
            }
        }
        return false;
    }

    public final void forEachRemaining(Consumer consumer) {
        this.f5502a.forEachRemaining(new t(8, (Object) this, (Object) consumer));
    }

    public final i0 trySplit() {
        i0 trySplit = this.f5502a.trySplit();
        if (trySplit != null) {
            return new C1173f3(trySplit, this.f5503b);
        }
        return null;
    }

    public final long estimateSize() {
        return this.f5502a.estimateSize();
    }

    public final int characteristics() {
        return (this.f5502a.characteristics() & -16469) | 1;
    }

    public final Comparator getComparator() {
        return this.f5502a.getComparator();
    }
}
