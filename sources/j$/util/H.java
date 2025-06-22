package j$.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public final /* synthetic */ class H implements PrimitiveIterator.OfDouble {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I f5099a;

    public /* synthetic */ H(I i4) {
        this.f5099a = i4;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        I i4 = this.f5099a;
        if (obj instanceof H) {
            obj = ((H) obj).f5099a;
        }
        return i4.equals(obj);
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f5099a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f5099a.forEachRemaining(consumer);
    }

    public final /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        this.f5099a.forEachRemaining(doubleConsumer);
    }

    public final /* synthetic */ boolean hasNext() {
        return this.f5099a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f5099a.hashCode();
    }

    public final /* synthetic */ double nextDouble() {
        return this.f5099a.nextDouble();
    }

    public final /* synthetic */ void remove() {
        this.f5099a.remove();
    }
}
