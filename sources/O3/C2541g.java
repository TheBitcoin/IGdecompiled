package O3;

import N3.C2514e;
import N3.C2522m;
import N3.Z;
import java.io.IOException;
import kotlin.jvm.internal.m;

/* renamed from: O3.g  reason: case insensitive filesystem */
public final class C2541g extends C2522m {

    /* renamed from: b  reason: collision with root package name */
    private final long f23756b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f23757c;

    /* renamed from: d  reason: collision with root package name */
    private long f23758d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2541g(Z z4, long j4, boolean z5) {
        super(z4);
        m.e(z4, "delegate");
        this.f23756b = j4;
        this.f23757c = z5;
    }

    private final void d(C2514e eVar, long j4) {
        C2514e eVar2 = new C2514e();
        eVar2.J(eVar);
        eVar.m(eVar2, j4);
        eVar2.a();
    }

    public long e(C2514e eVar, long j4) {
        m.e(eVar, "sink");
        long j5 = this.f23758d;
        long j6 = this.f23756b;
        if (j5 > j6) {
            j4 = 0;
        } else if (this.f23757c) {
            long j7 = j6 - j5;
            if (j7 == 0) {
                return -1;
            }
            j4 = Math.min(j4, j7);
        }
        long e5 = super.e(eVar, j4);
        int i4 = (e5 > -1 ? 1 : (e5 == -1 ? 0 : -1));
        if (i4 != 0) {
            this.f23758d += e5;
        }
        long j8 = this.f23758d;
        long j9 = this.f23756b;
        if ((j8 >= j9 || i4 != 0) && j8 <= j9) {
            return e5;
        }
        if (e5 > 0 && j8 > j9) {
            d(eVar, eVar.A() - (this.f23758d - this.f23756b));
        }
        throw new IOException("expected " + this.f23756b + " bytes but got " + this.f23758d);
    }
}
