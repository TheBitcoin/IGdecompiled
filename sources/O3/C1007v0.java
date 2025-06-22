package o3;

/* renamed from: o3.v0  reason: case insensitive filesystem */
public class C1007v0 extends A0 implements C1012y {

    /* renamed from: c  reason: collision with root package name */
    private final boolean f3730c = L0();

    public C1007v0(C1001s0 s0Var) {
        super(true);
        i0(s0Var);
    }

    private final boolean L0() {
        C1002t tVar;
        A0 s4;
        C1002t tVar2;
        C1000s e02 = e0();
        if (e02 instanceof C1002t) {
            tVar = (C1002t) e02;
        } else {
            tVar = null;
        }
        if (!(tVar == null || (s4 = tVar.s()) == null)) {
            while (!s4.b0()) {
                C1000s e03 = s4.e0();
                if (e03 instanceof C1002t) {
                    tVar2 = (C1002t) e03;
                } else {
                    tVar2 = null;
                }
                if (tVar2 != null) {
                    s4 = tVar2.s();
                    if (s4 == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean b0() {
        return this.f3730c;
    }

    public boolean c0() {
        return true;
    }
}
