package j$.util.stream;

import j$.util.Collection$EL;
import j$.util.i0;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public final class I0 implements E0 {

    /* renamed from: a  reason: collision with root package name */
    public final Collection f5322a;

    public final /* synthetic */ E0 g(long j4, long j5, IntFunction intFunction) {
        return C1232t1.w(this, j4, j5, intFunction);
    }

    public final /* synthetic */ int p() {
        return 0;
    }

    public final E0 b(int i4) {
        throw new IndexOutOfBoundsException();
    }

    public I0(Collection collection) {
        this.f5322a = collection;
    }

    public final i0 spliterator() {
        return Collection$EL.stream(this.f5322a).spliterator();
    }

    public final void h(Object[] objArr, int i4) {
        for (Object obj : this.f5322a) {
            objArr[i4] = obj;
            i4++;
        }
    }

    public final Object[] n(IntFunction intFunction) {
        Collection collection = this.f5322a;
        return collection.toArray((Object[]) intFunction.apply(collection.size()));
    }

    public final long count() {
        return (long) this.f5322a.size();
    }

    public final void forEach(Consumer consumer) {
        Collection$EL.a(this.f5322a, consumer);
    }

    public final String toString() {
        Collection collection = this.f5322a;
        return String.format("CollectionNode[%d][%s]", new Object[]{Integer.valueOf(collection.size()), collection});
    }
}
