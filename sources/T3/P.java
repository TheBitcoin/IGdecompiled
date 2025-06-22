package t3;

import V2.g;
import kotlin.jvm.internal.m;
import o3.Q0;

final class P {

    /* renamed from: a  reason: collision with root package name */
    public final g f4482a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f4483b;

    /* renamed from: c  reason: collision with root package name */
    private final Q0[] f4484c;

    /* renamed from: d  reason: collision with root package name */
    private int f4485d;

    public P(g gVar, int i4) {
        this.f4482a = gVar;
        this.f4483b = new Object[i4];
        this.f4484c = new Q0[i4];
    }

    public final void a(Q0 q02, Object obj) {
        Object[] objArr = this.f4483b;
        int i4 = this.f4485d;
        objArr[i4] = obj;
        Q0[] q0Arr = this.f4484c;
        this.f4485d = i4 + 1;
        m.c(q02, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        q0Arr[i4] = q02;
    }

    public final void b(g gVar) {
        int length = this.f4484c.length - 1;
        if (length >= 0) {
            while (true) {
                int i4 = length - 1;
                Q0 q02 = this.f4484c[length];
                m.b(q02);
                q02.x(gVar, this.f4483b[length]);
                if (i4 >= 0) {
                    length = i4;
                } else {
                    return;
                }
            }
        }
    }
}
