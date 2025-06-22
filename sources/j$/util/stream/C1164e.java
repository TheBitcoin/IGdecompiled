package j$.util.stream;

import j$.util.g0;
import j$.util.i0;
import j$.util.stream.IntStream;
import java.util.Iterator;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/* renamed from: j$.util.stream.e  reason: case insensitive filesystem */
public final /* synthetic */ class C1164e implements C1174g, AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseStream f5495a;

    public /* synthetic */ C1164e(BaseStream baseStream) {
        this.f5495a = baseStream;
    }

    public static /* synthetic */ C1174g w(BaseStream baseStream) {
        if (baseStream == null) {
            return null;
        }
        return baseStream instanceof C1169f ? ((C1169f) baseStream).f5500a : baseStream instanceof DoubleStream ? A.w((DoubleStream) baseStream) : baseStream instanceof IntStream ? IntStream.VivifiedWrapper.convert((java.util.stream.IntStream) baseStream) : baseStream instanceof LongStream ? C1185i0.w((LongStream) baseStream) : baseStream instanceof Stream ? T2.w((Stream) baseStream) : new C1164e(baseStream);
    }

    public final /* synthetic */ void close() {
        this.f5495a.close();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        BaseStream baseStream = this.f5495a;
        if (obj instanceof C1164e) {
            obj = ((C1164e) obj).f5495a;
        }
        return baseStream.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f5495a.hashCode();
    }

    public final /* synthetic */ boolean isParallel() {
        return this.f5495a.isParallel();
    }

    public final /* synthetic */ Iterator iterator() {
        return this.f5495a.iterator();
    }

    public final /* synthetic */ C1174g onClose(Runnable runnable) {
        return w(this.f5495a.onClose(runnable));
    }

    public final /* synthetic */ C1174g parallel() {
        return w(this.f5495a.parallel());
    }

    public final /* synthetic */ C1174g sequential() {
        return w(this.f5495a.sequential());
    }

    public final /* synthetic */ i0 spliterator() {
        return g0.a(this.f5495a.spliterator());
    }

    public final /* synthetic */ C1174g unordered() {
        return w(this.f5495a.unordered());
    }
}
