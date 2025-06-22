package s3;

import R2.m;
import R2.s;
import V2.d;
import java.util.Arrays;
import kotlin.jvm.internal.m;
import r3.I;

public abstract class b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public d[] f4336a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f4337b;

    /* renamed from: c  reason: collision with root package name */
    private int f4338c;

    /* renamed from: d  reason: collision with root package name */
    private y f4339d;

    public final I g() {
        y yVar;
        synchronized (this) {
            yVar = this.f4339d;
            if (yVar == null) {
                yVar = new y(this.f4337b);
                this.f4339d = yVar;
            }
        }
        return yVar;
    }

    /* access modifiers changed from: protected */
    public final d h() {
        d dVar;
        y yVar;
        synchronized (this) {
            try {
                d[] dVarArr = this.f4336a;
                if (dVarArr == null) {
                    dVarArr = j(2);
                    this.f4336a = dVarArr;
                } else if (this.f4337b >= dVarArr.length) {
                    Object[] copyOf = Arrays.copyOf(dVarArr, dVarArr.length * 2);
                    m.d(copyOf, "copyOf(this, newSize)");
                    this.f4336a = (d[]) copyOf;
                    dVarArr = (d[]) copyOf;
                }
                int i4 = this.f4338c;
                do {
                    dVar = dVarArr[i4];
                    if (dVar == null) {
                        dVar = i();
                        dVarArr[i4] = dVar;
                    }
                    i4++;
                    if (i4 >= dVarArr.length) {
                        i4 = 0;
                    }
                    m.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!dVar.a(this));
                this.f4338c = i4;
                this.f4337b++;
                yVar = this.f4339d;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (yVar != null) {
            yVar.Z(1);
        }
        return dVar;
    }

    /* access modifiers changed from: protected */
    public abstract d i();

    /* access modifiers changed from: protected */
    public abstract d[] j(int i4);

    /* access modifiers changed from: protected */
    public final void k(d dVar) {
        y yVar;
        int i4;
        d[] b5;
        synchronized (this) {
            try {
                int i5 = this.f4337b - 1;
                this.f4337b = i5;
                yVar = this.f4339d;
                if (i5 == 0) {
                    this.f4338c = 0;
                }
                m.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                b5 = dVar.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (d dVar2 : b5) {
            if (dVar2 != null) {
                m.a aVar = R2.m.f8216a;
                dVar2.resumeWith(R2.m.a(s.f8222a));
            }
        }
        if (yVar != null) {
            yVar.Z(-1);
        }
    }

    /* access modifiers changed from: protected */
    public final int l() {
        return this.f4337b;
    }

    /* access modifiers changed from: protected */
    public final d[] m() {
        return this.f4336a;
    }
}
