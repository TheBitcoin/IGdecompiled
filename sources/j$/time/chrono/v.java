package j$.time.chrono;

import j$.time.g;
import j$.time.temporal.a;
import j$.time.temporal.n;
import j$.time.temporal.u;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class v extends C1116a implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final v f4907c = new v();
    private static final long serialVersionUID = 459996390165777884L;

    public final String i() {
        return "Japanese";
    }

    public final String s() {
        return "japanese";
    }

    public final C1117b l(n nVar) {
        if (nVar instanceof x) {
            return (x) nVar;
        }
        return new x(g.E(nVar));
    }

    private v() {
    }

    public final m A(int i4) {
        return y.o(i4);
    }

    public final u k(a aVar) {
        switch (u.f4906a[aVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                throw new RuntimeException("Unsupported field: " + aVar);
            case 5:
                y[] yVarArr = y.f4914e;
                g gVar = yVarArr[yVarArr.length - 1].f4916b;
                int i4 = 1000000000 - yVarArr[yVarArr.length - 1].f4916b.f4977a;
                int i5 = yVarArr[0].f4916b.f4977a;
                int i6 = 1;
                while (i6 < yVarArr.length) {
                    y yVar = yVarArr[i6];
                    i4 = Math.min(i4, (yVar.f4916b.f4977a - i5) + 1);
                    i6++;
                    i5 = yVar.f4916b.f4977a;
                }
                return u.f((long) i4, (long) (999999999 - gVar.f4977a));
            case 6:
                y yVar2 = y.f4913d;
                u uVar = a.DAY_OF_YEAR.f5014b;
                long j4 = uVar.f5041c;
                for (y yVar3 : y.f4914e) {
                    j4 = Math.min(j4, (long) (((yVar3.f4916b.I() ? 366 : 365) - yVar3.f4916b.H()) + 1));
                    if (yVar3.l() != null) {
                        j4 = Math.min(j4, (long) (yVar3.l().f4916b.H() - 1));
                    }
                }
                return u.f(j4, a.DAY_OF_YEAR.f5014b.f5042d);
            case 7:
                return u.e((long) x.f4909d.f4977a, 999999999);
            case 8:
                long j5 = (long) y.f4913d.f4915a;
                y[] yVarArr2 = y.f4914e;
                return u.e(j5, (long) yVarArr2[yVarArr2.length - 1].f4915a);
            default:
                return aVar.f5014b;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new E((byte) 1, this);
    }
}
