package j$.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public final /* synthetic */ class G implements I, C1263y {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PrimitiveIterator.OfDouble f5098a;

    public /* synthetic */ G(PrimitiveIterator.OfDouble ofDouble) {
        this.f5098a = ofDouble;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        PrimitiveIterator.OfDouble ofDouble = this.f5098a;
        if (obj instanceof G) {
            obj = ((G) obj).f5098a;
        }
        return ofDouble.equals(obj);
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f5098a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f5098a.forEachRemaining(consumer);
    }

    public final /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        this.f5098a.forEachRemaining(doubleConsumer);
    }

    public final /* synthetic */ boolean hasNext() {
        return this.f5098a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f5098a.hashCode();
    }

    public final /* synthetic */ double nextDouble() {
        return this.f5098a.nextDouble();
    }

    public final /* synthetic */ void remove() {
        this.f5098a.remove();
    }
}
