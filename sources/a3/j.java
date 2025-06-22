package A3;

import R2.s;
import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode;
import d3.p;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final j f86a = new j();

    public static final class a extends n implements p {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Map f87a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Map map) {
            super(2);
            this.f87a = map;
        }

        public Object invoke(Object obj, Object obj2) {
            int intValue = ((Number) obj).intValue();
            Boolean bool = (Boolean) obj2;
            bool.booleanValue();
            this.f87a.put(String.valueOf(intValue), bool);
            return s.f8222a;
        }
    }

    public final PrivacyEncodingMode a(String str) {
        PrivacyEncodingMode privacyEncodingMode;
        if (str == null) {
            privacyEncodingMode = null;
        } else {
            String upperCase = str.toUpperCase(Locale.ROOT);
            m.d(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            if (m.a(upperCase, "TCF")) {
                privacyEncodingMode = PrivacyEncodingMode.TCF;
            } else if (m.a(upperCase, "GPP")) {
                privacyEncodingMode = PrivacyEncodingMode.GPP;
            } else {
                privacyEncodingMode = PrivacyEncodingMode.TCF_AND_GPP;
            }
        }
        if (privacyEncodingMode == null) {
            return PrivacyEncodingMode.TCF_AND_GPP;
        }
        return privacyEncodingMode;
    }

    public final Map b(Vector vector) {
        m.e(vector, "vector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        vector.forEach(new a(linkedHashMap));
        return linkedHashMap;
    }

    public final Map c(Vector vector, Set set) {
        LinkedHashMap linkedHashMap;
        m.e(vector, "vector");
        if (set == null) {
            linkedHashMap = null;
        } else {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                int intValue = ((Number) it.next()).intValue();
                linkedHashMap2.put(String.valueOf(intValue), Boolean.valueOf(vector.contains(intValue)));
            }
            linkedHashMap = linkedHashMap2;
        }
        if (linkedHashMap == null) {
            return b(vector);
        }
        return linkedHashMap;
    }
}
