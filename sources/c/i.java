package c;

import R2.s;
import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.core.model.gbc.GoogleBasicConsents;
import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;
import d3.p;
import java.util.Map;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f1157a = new i();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f1158b;

    /* renamed from: c  reason: collision with root package name */
    public static Vector f1159c = new Vector((Map) null, 1, (C2103g) null);

    public static final class a extends n implements p {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Vector f1160a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Vector vector) {
            super(2);
            this.f1160a = vector;
        }

        public Object invoke(Object obj, Object obj2) {
            int intValue = ((Number) obj).intValue();
            boolean booleanValue = ((Boolean) obj2).booleanValue();
            if (!this.f1160a.contains(intValue)) {
                if (booleanValue) {
                    this.f1160a.set(intValue);
                } else {
                    this.f1160a.unset(intValue);
                }
            }
            return s.f8222a;
        }
    }

    public final Vector a(Vector vector, Vector vector2) {
        m.e(vector2, "newVector");
        if (vector == null) {
            return vector2;
        }
        vector.forEach(new a(vector2));
        return vector2;
    }

    public final GoogleBasicConsents b() {
        return new GoogleBasicConsents(c("adStorage"), c("adUserData"), c("adPersonalization"), c("analyticsStorage"));
    }

    public final GBCConsentValue c(String str) {
        boolean z4;
        Vector vector = f1159c;
        int e5 = e(str);
        if (vector.contains(e5)) {
            z4 = m.a(vector.get(e5), Boolean.TRUE);
        } else {
            z4 = false;
        }
        if (z4) {
            return GBCConsentValue.GRANTED;
        }
        return GBCConsentValue.DENIED;
    }

    public final void d(int i4, GBCConsentValue gBCConsentValue) {
        m.e(gBCConsentValue, "value");
        if (gBCConsentValue == GBCConsentValue.GRANTED) {
            f1159c.set(i4);
        } else {
            f1159c.unset(i4);
        }
    }

    public final int e(String str) {
        m.e(str, "value");
        if (m.a(str, "adStorage")) {
            return 1;
        }
        if (m.a(str, "adUserData")) {
            return 2;
        }
        if (m.a(str, "adPersonalization")) {
            return 3;
        }
        if (m.a(str, "analyticsStorage")) {
            return 4;
        }
        return 0;
    }
}
