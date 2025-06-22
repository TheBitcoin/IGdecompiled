package j$.time.chrono;

import j$.com.android.tools.r8.a;
import j$.time.c;
import j$.time.g;
import j$.time.temporal.m;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.u;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class y implements m, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final y f4913d;

    /* renamed from: e  reason: collision with root package name */
    public static final y[] f4914e;
    private static final long serialVersionUID = 1466499369062886794L;

    /* renamed from: a  reason: collision with root package name */
    public final transient int f4915a;

    /* renamed from: b  reason: collision with root package name */
    public final transient g f4916b;

    /* renamed from: c  reason: collision with root package name */
    public final transient String f4917c;

    public final /* synthetic */ boolean f(q qVar) {
        return a.o(this, qVar);
    }

    public final /* synthetic */ int k(q qVar) {
        return a.l(this, (j$.time.temporal.a) qVar);
    }

    public final /* synthetic */ Object p(j$.time.format.a aVar) {
        return a.s(this, aVar);
    }

    public final /* synthetic */ long t(q qVar) {
        return a.m(this, qVar);
    }

    static {
        y yVar = new y(-1, g.K(1868, 1, 1), "Meiji");
        f4913d = yVar;
        y yVar2 = new y(0, g.K(1912, 7, 30), "Taisho");
        y yVar3 = new y(1, g.K(1926, 12, 25), "Showa");
        y yVar4 = new y(2, g.K(1989, 1, 8), "Heisei");
        y yVar5 = new y(3, g.K(2019, 5, 1), "Reiwa");
        y[] yVarArr = new y[5];
        f4914e = yVarArr;
        yVarArr[0] = yVar;
        yVarArr[1] = yVar2;
        yVarArr[2] = yVar3;
        yVarArr[3] = yVar4;
        yVarArr[4] = yVar5;
    }

    public final y l() {
        y[] yVarArr = f4914e;
        if (this == yVarArr[yVarArr.length - 1]) {
            return null;
        }
        return o(this.f4915a + 1);
    }

    public y(int i4, g gVar, String str) {
        this.f4915a = i4;
        this.f4916b = gVar;
        this.f4917c = str;
    }

    public static y o(int i4) {
        int i5 = i4 + 1;
        if (i5 >= 0) {
            y[] yVarArr = f4914e;
            if (i5 < yVarArr.length) {
                return yVarArr[i5];
            }
        }
        throw new RuntimeException("Invalid era: " + i4);
    }

    public final m w(m mVar) {
        return mVar.d((long) getValue(), j$.time.temporal.a.ERA);
    }

    public static y i(g gVar) {
        g gVar2 = x.f4909d;
        if (!(!c.b(gVar2) ? gVar.u() < gVar2.u() : gVar.C(gVar2) < 0)) {
            y[] yVarArr = f4914e;
            for (int length = yVarArr.length - 1; length >= 0; length--) {
                y yVar = yVarArr[length];
                if (gVar.compareTo(yVar.f4916b) >= 0) {
                    return yVar;
                }
            }
            return null;
        }
        throw new RuntimeException("JapaneseDate before Meiji 6 are not supported");
    }

    public final int getValue() {
        return this.f4915a;
    }

    public final u n(q qVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
        return qVar == aVar ? v.f4907c.k(aVar) : r.d(this, qVar);
    }

    public final String toString() {
        return this.f4917c;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new E((byte) 5, this);
    }
}
