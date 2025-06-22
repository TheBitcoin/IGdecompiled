package j$.util.stream;

import j$.util.C1132g;
import j$.util.stream.IntStream;
import java.util.function.IntFunction;
import java.util.function.LongFunction;

public final class K implements IntFunction, LongFunction {

    /* renamed from: a  reason: collision with root package name */
    public IntFunction f5354a;

    public Object apply(int i4) {
        Object apply = this.f5354a.apply(i4);
        if (apply == null) {
            return null;
        }
        if (apply instanceof IntStream) {
            return IntStream.Wrapper.convert((IntStream) apply);
        }
        if (apply instanceof java.util.stream.IntStream) {
            return IntStream.VivifiedWrapper.convert((java.util.stream.IntStream) apply);
        }
        C1132g.a("java.util.stream.IntStream", apply.getClass());
        throw null;
    }

    public Object apply(long j4) {
        return C1232t1.z(j4, this.f5354a);
    }
}
