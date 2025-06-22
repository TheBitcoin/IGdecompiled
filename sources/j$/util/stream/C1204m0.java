package j$.util.stream;

import java.util.function.Predicate;

/* renamed from: j$.util.stream.m0  reason: case insensitive filesystem */
public final class C1204m0 extends C1220q0 {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C1223r0 f5545c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Predicate f5546d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1204m0(C1223r0 r0Var, Predicate predicate) {
        super(r0Var);
        this.f5545c = r0Var;
        this.f5546d = predicate;
    }

    public final void accept(Object obj) {
        if (!this.f5572a) {
            boolean test = this.f5546d.test(obj);
            C1223r0 r0Var = this.f5545c;
            if (test == r0Var.f5579a) {
                this.f5572a = true;
                this.f5573b = r0Var.f5580b;
            }
        }
    }
}
