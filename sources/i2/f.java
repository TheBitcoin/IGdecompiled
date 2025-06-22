package I2;

import E2.i;
import G2.c;
import I2.d;
import R2.s;
import S2.C1601o;
import d3.p;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class f extends n implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C f6697a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(C c5) {
        super(2);
        this.f6697a = c5;
    }

    public Object invoke(Object obj, Object obj2) {
        int i4;
        int i5;
        String str;
        int i6;
        int i7;
        String str2 = (String) obj;
        Set set = (Set) obj2;
        m.e(str2, "hash");
        m.e(set, "vendorIds");
        i a5 = i.f6358c.a(str2);
        C c5 = this.f6697a;
        String str3 = (String) c5.f20968a;
        d.a aVar = d.f6695a;
        Integer valueOf = Integer.valueOf(a5.f6359a);
        c cVar = c.f6592a;
        Integer a6 = cVar.a(G2.d.PURPOSE_ID);
        int i8 = 0;
        if (a6 == null) {
            i4 = 0;
        } else {
            i4 = a6.intValue();
        }
        c5.f20968a = m.m(str3, aVar.b(valueOf, i4));
        C c6 = this.f6697a;
        String str4 = (String) c6.f20968a;
        Integer valueOf2 = Integer.valueOf(a5.f6360b.f6369a);
        Integer a7 = cVar.a(G2.d.RESTRICTION_TYPE);
        if (a7 == null) {
            i5 = 0;
        } else {
            i5 = a7.intValue();
        }
        c6.f20968a = m.m(str4, aVar.b(valueOf2, i5));
        List V4 = C1601o.V(set);
        int size = V4.size();
        String str5 = "";
        int i9 = 0;
        int i10 = 0;
        loop0:
        while (true) {
            int i11 = 0;
            while (i9 < size) {
                int i12 = i9 + 1;
                int intValue = ((Number) V4.get(i9)).intValue();
                if (i11 == 0) {
                    i10++;
                    i11 = intValue;
                }
                boolean z4 = true;
                if (i9 == V4.size() - 1 || ((Number) V4.get(i12)).intValue() > intValue + 1) {
                    if (intValue == i11) {
                        z4 = false;
                    }
                    if (z4) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    String m4 = m.m(str5, str);
                    d.a aVar2 = d.f6695a;
                    Integer valueOf3 = Integer.valueOf(i11);
                    c cVar2 = c.f6592a;
                    G2.d dVar = G2.d.VENDOR_ID;
                    Integer a8 = cVar2.a(dVar);
                    if (a8 == null) {
                        i6 = 0;
                    } else {
                        i6 = a8.intValue();
                    }
                    str5 = m.m(m4, aVar2.b(valueOf3, i6));
                    if (z4) {
                        Integer valueOf4 = Integer.valueOf(intValue);
                        Integer a9 = cVar2.a(dVar);
                        if (a9 == null) {
                            i7 = 0;
                        } else {
                            i7 = a9.intValue();
                        }
                        str5 = m.m(str5, aVar2.b(valueOf4, i7));
                    }
                    i9 = i12;
                } else {
                    i9 = i12;
                }
            }
            break loop0;
        }
        C c7 = this.f6697a;
        String str6 = (String) c7.f20968a;
        d.a aVar3 = d.f6695a;
        Integer valueOf5 = Integer.valueOf(i10);
        Integer a10 = c.f6592a.a(G2.d.NUM_ENTRIES);
        if (a10 != null) {
            i8 = a10.intValue();
        }
        c7.f20968a = m.m(str6, aVar3.b(valueOf5, i8));
        C c8 = this.f6697a;
        c8.f20968a = m.m((String) c8.f20968a, str5);
        return s.f8222a;
    }
}
