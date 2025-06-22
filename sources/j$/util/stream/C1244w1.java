package j$.util.stream;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;

/* renamed from: j$.util.stream.w1  reason: case insensitive filesystem */
public final class C1244w1 extends C1232t1 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f5624h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f5625i;

    public /* synthetic */ C1244w1(X2 x22, Object obj, int i4) {
        this.f5624h = i4;
        this.f5625i = obj;
    }

    public final O1 Z() {
        switch (this.f5624h) {
            case 0:
                return new N1((LongBinaryOperator) this.f5625i);
            case 1:
                return new C1256z1((DoubleBinaryOperator) this.f5625i);
            case 2:
                return new E1((BinaryOperator) this.f5625i);
            default:
                return new K1((IntBinaryOperator) this.f5625i);
        }
    }
}
