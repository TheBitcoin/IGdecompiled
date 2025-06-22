package c;

import R2.l;
import R2.s;
import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;
import d3.p;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class h extends n implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f1156a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(List list) {
        super(2);
        this.f1156a = list;
    }

    public Object invoke(Object obj, Object obj2) {
        GBCConsentValue gBCConsentValue;
        int intValue = ((Number) obj).intValue();
        boolean booleanValue = ((Boolean) obj2).booleanValue();
        List list = this.f1156a;
        Integer valueOf = Integer.valueOf(intValue);
        if (booleanValue) {
            gBCConsentValue = GBCConsentValue.GRANTED;
        } else {
            gBCConsentValue = GBCConsentValue.DENIED;
        }
        String lowerCase = gBCConsentValue.getValue().toLowerCase(Locale.ROOT);
        m.d(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        list.add(new l(valueOf, lowerCase));
        return s.f8222a;
    }
}
