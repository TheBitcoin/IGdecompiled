package j$.time.chrono;

import j$.time.g;
import j$.time.temporal.a;
import j$.time.temporal.n;
import j$.time.temporal.u;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class A extends C1116a implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final A f4860c = new A();
    private static final long serialVersionUID = 1039765215346859963L;

    public final String i() {
        return "Minguo";
    }

    public final m A(int i4) {
        if (i4 == 0) {
            return D.BEFORE_ROC;
        }
        if (i4 == 1) {
            return D.ROC;
        }
        throw new RuntimeException("Invalid era: " + i4);
    }

    public final String s() {
        return "roc";
    }

    public final C1117b l(n nVar) {
        if (nVar instanceof C) {
            return (C) nVar;
        }
        return new C(g.E(nVar));
    }

    public final u k(a aVar) {
        int i4 = z.f4918a[aVar.ordinal()];
        if (i4 == 1) {
            u uVar = a.PROLEPTIC_MONTH.f5014b;
            return u.e(uVar.f5039a - 22932, uVar.f5042d - 22932);
        } else if (i4 == 2) {
            u uVar2 = a.YEAR.f5014b;
            return u.f(uVar2.f5042d - 1911, (-uVar2.f5039a) + 1912);
        } else if (i4 != 3) {
            return aVar.f5014b;
        } else {
            u uVar3 = a.YEAR.f5014b;
            return u.e(uVar3.f5039a - 1911, uVar3.f5042d - 1911);
        }
    }

    private A() {
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new E((byte) 1, this);
    }
}
