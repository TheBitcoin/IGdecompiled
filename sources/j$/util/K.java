package j$.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final /* synthetic */ class K implements M, C1263y {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PrimitiveIterator.OfInt f5102a;

    public /* synthetic */ K(PrimitiveIterator.OfInt ofInt) {
        this.f5102a = ofInt;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        PrimitiveIterator.OfInt ofInt = this.f5102a;
        if (obj instanceof K) {
            obj = ((K) obj).f5102a;
        }
        return ofInt.equals(obj);
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f5102a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f5102a.forEachRemaining(consumer);
    }

    public final /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.f5102a.forEachRemaining(intConsumer);
    }

    public final /* synthetic */ boolean hasNext() {
        return this.f5102a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f5102a.hashCode();
    }

    public final /* synthetic */ int nextInt() {
        return this.f5102a.nextInt();
    }

    public final /* synthetic */ void remove() {
        this.f5102a.remove();
    }
}
