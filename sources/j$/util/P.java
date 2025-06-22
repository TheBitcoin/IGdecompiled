package j$.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final /* synthetic */ class P implements PrimitiveIterator.OfLong {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Q f5107a;

    public /* synthetic */ P(Q q4) {
        this.f5107a = q4;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Q q4 = this.f5107a;
        if (obj instanceof P) {
            obj = ((P) obj).f5107a;
        }
        return q4.equals(obj);
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f5107a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f5107a.forEachRemaining(consumer);
    }

    public final /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        this.f5107a.forEachRemaining(longConsumer);
    }

    public final /* synthetic */ boolean hasNext() {
        return this.f5107a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f5107a.hashCode();
    }

    public final /* synthetic */ long nextLong() {
        return this.f5107a.nextLong();
    }

    public final /* synthetic */ void remove() {
        this.f5107a.remove();
    }
}
