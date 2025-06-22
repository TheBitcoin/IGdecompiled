package j$.util.stream;

import java.util.concurrent.CountedCompleter;

/* renamed from: j$.util.stream.s1  reason: case insensitive filesystem */
public class C1228s1 extends CountedCompleter {

    /* renamed from: a  reason: collision with root package name */
    public final E0 f5589a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5590b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f5591c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f5592d;

    public C1228s1(E0 e02, Object obj, int i4) {
        this.f5591c = i4;
        this.f5589a = e02;
        this.f5590b = 0;
        this.f5592d = obj;
    }

    public C1228s1(C1228s1 s1Var, E0 e02, int i4, byte b5) {
        super(s1Var);
        this.f5589a = e02;
        this.f5590b = i4;
    }

    public final void compute() {
        C1228s1 s1Var = this;
        while (s1Var.f5589a.p() != 0) {
            s1Var.setPendingCount(s1Var.f5589a.p() - 1);
            int i4 = 0;
            int i5 = 0;
            while (i4 < s1Var.f5589a.p() - 1) {
                C1228s1 a5 = s1Var.a(i4, s1Var.f5590b + i5);
                i5 = (int) (a5.f5589a.count() + ((long) i5));
                a5.fork();
                i4++;
            }
            s1Var = s1Var.a(i4, s1Var.f5590b + i5);
        }
        switch (s1Var.f5591c) {
            case 0:
                ((D0) s1Var.f5589a).q(s1Var.f5590b, s1Var.f5592d);
                break;
            default:
                s1Var.f5589a.h((Object[]) s1Var.f5592d, s1Var.f5590b);
                break;
        }
        s1Var.propagateCompletion();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C1228s1(C1228s1 s1Var, E0 e02, int i4) {
        this(s1Var, e02, i4, (byte) 0);
        this.f5591c = 1;
        this.f5592d = (Object[]) s1Var.f5592d;
    }

    public final C1228s1 a(int i4, int i5) {
        switch (this.f5591c) {
            case 0:
                return new C1228s1(this, ((D0) this.f5589a).b(i4), i5);
            default:
                return new C1228s1(this, this.f5589a.b(i4), i5);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C1228s1(C1228s1 s1Var, D0 d02, int i4) {
        this(s1Var, d02, i4, (byte) 0);
        this.f5591c = 0;
        this.f5592d = s1Var.f5592d;
    }
}
