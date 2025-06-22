package j$.time.chrono;

import j$.time.g;
import j$.time.temporal.a;
import j$.time.temporal.n;
import j$.time.temporal.u;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;

public final class G extends C1116a implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final G f4867c = new G();
    private static final long serialVersionUID = 2775954514031616474L;

    static {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        hashMap.put("en", new String[]{"BB", "BE"});
        hashMap.put("th", new String[]{"BB", "BE"});
        hashMap2.put("en", new String[]{"B.B.", "B.E."});
        hashMap2.put("th", new String[]{"พ.ศ.", "ปีก่อนคริสต์กาลที่"});
        hashMap3.put("en", new String[]{"Before Buddhist", "Budhhist Era"});
        hashMap3.put("th", new String[]{"พุทธศักราช", "ปีก่อนคริสต์กาลที่"});
    }

    public final m A(int i4) {
        if (i4 == 0) {
            return J.BEFORE_BE;
        }
        if (i4 == 1) {
            return J.BE;
        }
        throw new RuntimeException("Invalid era: " + i4);
    }

    public final String i() {
        return "ThaiBuddhist";
    }

    public final String s() {
        return "buddhist";
    }

    public final C1117b l(n nVar) {
        if (nVar instanceof I) {
            return (I) nVar;
        }
        return new I(g.E(nVar));
    }

    private G() {
    }

    public final u k(a aVar) {
        int i4 = F.f4866a[aVar.ordinal()];
        if (i4 == 1) {
            u uVar = a.PROLEPTIC_MONTH.f5014b;
            return u.e(uVar.f5039a + 6516, uVar.f5042d + 6516);
        } else if (i4 == 2) {
            u uVar2 = a.YEAR.f5014b;
            return u.f((-(uVar2.f5039a + 543)) + 1, uVar2.f5042d + 543);
        } else if (i4 != 3) {
            return aVar.f5014b;
        } else {
            u uVar3 = a.YEAR.f5014b;
            return u.e(uVar3.f5039a + 543, uVar3.f5042d + 543);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new E((byte) 1, this);
    }
}
