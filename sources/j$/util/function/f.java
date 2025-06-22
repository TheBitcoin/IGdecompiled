package j$.util.function;

import java.util.function.Predicate;

public final /* synthetic */ class f implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5212a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Predicate f5213b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Predicate f5214c;

    public /* synthetic */ f(Predicate predicate, Predicate predicate2, int i4) {
        this.f5212a = i4;
        this.f5213b = predicate;
        this.f5214c = predicate2;
    }

    public final /* synthetic */ Predicate and(Predicate predicate) {
        switch (this.f5212a) {
            case 0:
                return Predicate$CC.$default$and(this, predicate);
            default:
                return Predicate$CC.$default$and(this, predicate);
        }
    }

    public final /* synthetic */ Predicate negate() {
        switch (this.f5212a) {
            case 0:
                return Predicate$CC.$default$negate(this);
            default:
                return Predicate$CC.$default$negate(this);
        }
    }

    public final /* synthetic */ Predicate or(Predicate predicate) {
        switch (this.f5212a) {
            case 0:
                return Predicate$CC.$default$or(this, predicate);
            default:
                return Predicate$CC.$default$or(this, predicate);
        }
    }

    public final boolean test(Object obj) {
        switch (this.f5212a) {
            case 0:
                return this.f5213b.test(obj) && this.f5214c.test(obj);
            default:
                return this.f5213b.test(obj) || this.f5214c.test(obj);
        }
    }
}
