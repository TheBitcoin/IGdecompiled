package j$.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final /* synthetic */ class L implements PrimitiveIterator.OfInt {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ M f5103a;

    public /* synthetic */ L(M m4) {
        this.f5103a = m4;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        M m4 = this.f5103a;
        if (obj instanceof L) {
            obj = ((L) obj).f5103a;
        }
        return m4.equals(obj);
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f5103a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f5103a.forEachRemaining(consumer);
    }

    public final /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.f5103a.forEachRemaining(intConsumer);
    }

    public final /* synthetic */ boolean hasNext() {
        return this.f5103a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f5103a.hashCode();
    }

    public final /* synthetic */ int nextInt() {
        return this.f5103a.nextInt();
    }

    public final /* synthetic */ void remove() {
        this.f5103a.remove();
    }
}
