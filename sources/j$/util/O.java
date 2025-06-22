package j$.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final /* synthetic */ class O implements Q, C1263y {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PrimitiveIterator.OfLong f5106a;

    public /* synthetic */ O(PrimitiveIterator.OfLong ofLong) {
        this.f5106a = ofLong;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        PrimitiveIterator.OfLong ofLong = this.f5106a;
        if (obj instanceof O) {
            obj = ((O) obj).f5106a;
        }
        return ofLong.equals(obj);
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f5106a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f5106a.forEachRemaining(consumer);
    }

    public final /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        this.f5106a.forEachRemaining(longConsumer);
    }

    public final /* synthetic */ boolean hasNext() {
        return this.f5106a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f5106a.hashCode();
    }

    public final /* synthetic */ long nextLong() {
        return this.f5106a.nextLong();
    }

    public final /* synthetic */ void remove() {
        this.f5106a.remove();
    }
}
