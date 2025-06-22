package O3;

import N3.C2514e;
import N3.C2517h;
import N3.Q;
import S2.C1601o;
import java.util.ArrayList;
import kotlin.jvm.internal.m;

/* renamed from: O3.d  reason: case insensitive filesystem */
public abstract class C2538d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final C2517h f23748a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final C2517h f23749b;

    /* renamed from: c  reason: collision with root package name */
    private static final C2517h f23750c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final C2517h f23751d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final C2517h f23752e;

    static {
        C2517h.a aVar = C2517h.f23704d;
        f23748a = aVar.c("/");
        f23749b = aVar.c("\\");
        f23750c = aVar.c("/\\");
        f23751d = aVar.c(".");
        f23752e = aVar.c("..");
    }

    public static final Q j(Q q4, Q q5, boolean z4) {
        m.e(q4, "<this>");
        m.e(q5, "child");
        if (q5.e() || q5.o() != null) {
            return q5;
        }
        C2517h m4 = m(q4);
        if (m4 == null && (m4 = m(q5)) == null) {
            m4 = s(Q.f23640c);
        }
        C2514e eVar = new C2514e();
        eVar.G(q4.b());
        if (eVar.A() > 0) {
            eVar.G(m4);
        }
        eVar.G(q5.b());
        return q(eVar, z4);
    }

    public static final Q k(String str, boolean z4) {
        m.e(str, "<this>");
        return q(new C2514e().writeUtf8(str), z4);
    }

    /* access modifiers changed from: private */
    public static final int l(Q q4) {
        int u4 = C2517h.u(q4.b(), f23748a, 0, 2, (Object) null);
        if (u4 != -1) {
            return u4;
        }
        return C2517h.u(q4.b(), f23749b, 0, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final C2517h m(Q q4) {
        C2517h b5 = q4.b();
        C2517h hVar = f23748a;
        if (C2517h.p(b5, hVar, 0, 2, (Object) null) != -1) {
            return hVar;
        }
        C2517h b6 = q4.b();
        C2517h hVar2 = f23749b;
        if (C2517h.p(b6, hVar2, 0, 2, (Object) null) != -1) {
            return hVar2;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final boolean n(Q q4) {
        if (!q4.b().g(f23752e) || (q4.b().G() != 2 && !q4.b().x(q4.b().G() - 3, f23748a, 0, 1) && !q4.b().x(q4.b().G() - 3, f23749b, 0, 1))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final int o(Q q4) {
        if (q4.b().G() == 0) {
            return -1;
        }
        if (q4.b().h(0) == 47) {
            return 1;
        }
        if (q4.b().h(0) != 92) {
            if (q4.b().G() > 2 && q4.b().h(1) == 58 && q4.b().h(2) == 92) {
                char h4 = (char) q4.b().h(0);
                if ('a' <= h4 && h4 < '{') {
                    return 3;
                }
                if ('A' > h4 || h4 >= '[') {
                    return -1;
                }
                return 3;
            }
            return -1;
        } else if (q4.b().G() <= 2 || q4.b().h(1) != 92) {
            return 1;
        } else {
            int n4 = q4.b().n(f23749b, 2);
            if (n4 == -1) {
                return q4.b().G();
            }
            return n4;
        }
    }

    private static final boolean p(C2514e eVar, C2517h hVar) {
        if (!m.a(hVar, f23749b) || eVar.A() < 2 || eVar.n(1) != 58) {
            return false;
        }
        char n4 = (char) eVar.n(0);
        if ('a' <= n4 && n4 < '{') {
            return true;
        }
        if ('A' > n4 || n4 >= '[') {
            return false;
        }
        return true;
    }

    public static final Q q(C2514e eVar, boolean z4) {
        C2517h hVar;
        boolean z5;
        boolean z6;
        C2517h hVar2;
        C2514e eVar2 = eVar;
        m.e(eVar2, "<this>");
        C2514e eVar3 = new C2514e();
        C2517h hVar3 = null;
        int i4 = 0;
        while (true) {
            if (!eVar2.s(0, f23748a)) {
                hVar = f23749b;
                if (!eVar2.s(0, hVar)) {
                    break;
                }
            }
            byte readByte = eVar2.readByte();
            if (hVar3 == null) {
                hVar3 = r(readByte);
            }
            i4++;
        }
        if (i4 < 2 || !m.a(hVar3, hVar)) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (z5) {
            m.b(hVar3);
            eVar3.G(hVar3);
            eVar3.G(hVar3);
        } else if (i4 > 0) {
            m.b(hVar3);
            eVar3.G(hVar3);
        } else {
            long o4 = eVar2.o(f23750c);
            if (hVar3 == null) {
                if (o4 == -1) {
                    hVar3 = s(Q.f23640c);
                } else {
                    hVar3 = r(eVar2.n(o4));
                }
            }
            if (p(eVar2, hVar3)) {
                if (o4 == 2) {
                    eVar3.m(eVar2, 3);
                } else {
                    eVar3.m(eVar2, 2);
                }
            }
        }
        if (eVar3.A() > 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        ArrayList arrayList = new ArrayList();
        while (!eVar2.exhausted()) {
            long o5 = eVar2.o(f23750c);
            if (o5 == -1) {
                hVar2 = eVar2.x();
            } else {
                hVar2 = eVar2.readByteString(o5);
                eVar2.readByte();
            }
            C2517h hVar4 = f23752e;
            if (m.a(hVar2, hVar4)) {
                if (!z6 || !arrayList.isEmpty()) {
                    if (!z4 || (!z6 && (arrayList.isEmpty() || m.a(C1601o.P(arrayList), hVar4)))) {
                        arrayList.add(hVar2);
                    } else if (!z5 || arrayList.size() != 1) {
                        C1601o.y(arrayList);
                    }
                }
            } else if (!m.a(hVar2, f23751d) && !m.a(hVar2, C2517h.f23705e)) {
                arrayList.add(hVar2);
            }
        }
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (i5 > 0) {
                eVar3.G(hVar3);
            }
            eVar3.G((C2517h) arrayList.get(i5));
        }
        if (eVar3.A() == 0) {
            eVar3.G(f23751d);
        }
        return new Q(eVar3.x());
    }

    private static final C2517h r(byte b5) {
        if (b5 == 47) {
            return f23748a;
        }
        if (b5 == 92) {
            return f23749b;
        }
        throw new IllegalArgumentException("not a directory separator: " + b5);
    }

    /* access modifiers changed from: private */
    public static final C2517h s(String str) {
        if (m.a(str, "/")) {
            return f23748a;
        }
        if (m.a(str, "\\")) {
            return f23749b;
        }
        throw new IllegalArgumentException("not a directory separator: " + str);
    }
}
