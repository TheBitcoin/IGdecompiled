package A3;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Locale;
import kotlin.jvm.internal.m;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f81a = new i();

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f82b = {1, 2, 3, 4};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f83c = {5};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f84d = {6};

    /* renamed from: e  reason: collision with root package name */
    public static boolean f85e;

    public final g a(String str) {
        m.e(str, TtmlNode.TAG_REGION);
        String lowerCase = str.toLowerCase(Locale.ROOT);
        m.d(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        int hashCode = lowerCase.hashCode();
        if (hashCode != 3166) {
            if (hashCode != 3180) {
                if (hashCode != 3185) {
                    if (hashCode != 3743) {
                        if (hashCode == 3755 && lowerCase.equals("va")) {
                            return g.VIRGINIA;
                        }
                    } else if (lowerCase.equals("ut")) {
                        return g.UTAH;
                    }
                } else if (lowerCase.equals("ct")) {
                    return g.CONNECTICUT;
                }
            } else if (lowerCase.equals("co")) {
                return g.COLORADO;
            }
        } else if (lowerCase.equals(DownloadCommon.DOWNLOAD_REPORT_CANCEL)) {
            return g.CALIFORNIA;
        }
        return g.NOT_APPLICABLE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(A3.a r7) {
        /*
            r6 = this;
            java.lang.String r0 = "mspaConfig"
            kotlin.jvm.internal.m.e(r7, r0)
            boolean r0 = f85e
            if (r0 != 0) goto L_0x001c
            r6.c(r7)
            java.util.List r7 = r7.f32d
            if (r7 != 0) goto L_0x0012
            goto L_0x00dc
        L_0x0012:
            A3.d r0 = A3.d.f51a
            boolean r1 = f85e
            A3.h r2 = A3.h.f80a
            r0.b(r7, r1, r2)
            return
        L_0x001c:
            A3.d r7 = A3.d.f51a
            C3.f r0 = A3.d.f52b
            C3.a r0 = r0.f170b
            java.lang.String r0 = r0.f118J
            A3.g r1 = r7.c()
            java.lang.String r2 = r7.a()
            java.lang.String r3 = "region"
            kotlin.jvm.internal.m.e(r2, r3)
            java.util.Locale r3 = java.util.Locale.ROOT
            java.lang.String r2 = r2.toLowerCase(r3)
            java.lang.String r3 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
            kotlin.jvm.internal.m.d(r2, r3)
            int r3 = r2.hashCode()
            r4 = 3166(0xc5e, float:4.437E-42)
            if (r3 == r4) goto L_0x0085
            r4 = 3180(0xc6c, float:4.456E-42)
            if (r3 == r4) goto L_0x0079
            r4 = 3185(0xc71, float:4.463E-42)
            if (r3 == r4) goto L_0x006d
            r4 = 3743(0xe9f, float:5.245E-42)
            if (r3 == r4) goto L_0x0061
            r4 = 3755(0xeab, float:5.262E-42)
            if (r3 == r4) goto L_0x0055
            goto L_0x008d
        L_0x0055:
            java.lang.String r3 = "va"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x005e
            goto L_0x008d
        L_0x005e:
            A3.g r2 = A3.g.VIRGINIA
            goto L_0x0092
        L_0x0061:
            java.lang.String r3 = "ut"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x006a
            goto L_0x008d
        L_0x006a:
            A3.g r2 = A3.g.UTAH
            goto L_0x0092
        L_0x006d:
            java.lang.String r3 = "ct"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0076
            goto L_0x008d
        L_0x0076:
            A3.g r2 = A3.g.CONNECTICUT
            goto L_0x0092
        L_0x0079:
            java.lang.String r3 = "co"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0082
            goto L_0x008d
        L_0x0082:
            A3.g r2 = A3.g.COLORADO
            goto L_0x0092
        L_0x0085:
            java.lang.String r3 = "ca"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0090
        L_0x008d:
            A3.g r2 = A3.g.NOT_APPLICABLE
            goto L_0x0092
        L_0x0090:
            A3.g r2 = A3.g.CALIFORNIA
        L_0x0092:
            boolean r3 = r7.d()
            java.lang.String r4 = "NATIONAL"
            if (r3 == 0) goto L_0x00a1
            boolean r3 = kotlin.jvm.internal.m.a(r0, r4)
            if (r3 == 0) goto L_0x00a1
            goto L_0x00d3
        L_0x00a1:
            boolean r3 = r7.d()
            java.lang.String r5 = "STATE_AND_NATIONAL"
            if (r3 == 0) goto L_0x00b4
            boolean r3 = kotlin.jvm.internal.m.a(r0, r5)
            if (r3 == 0) goto L_0x00b4
            A3.g r3 = A3.g.NOT_APPLICABLE
            if (r1 != r3) goto L_0x00b4
            goto L_0x00d3
        L_0x00b4:
            boolean r3 = r7.e()
            if (r3 == 0) goto L_0x00c5
            boolean r3 = kotlin.jvm.internal.m.a(r0, r4)
            if (r3 == 0) goto L_0x00c5
            A3.g r3 = A3.g.NOT_APPLICABLE
            if (r2 != r3) goto L_0x00c5
            goto L_0x00d3
        L_0x00c5:
            boolean r7 = r7.e()
            if (r7 == 0) goto L_0x00d4
            boolean r7 = kotlin.jvm.internal.m.a(r0, r5)
            if (r7 == 0) goto L_0x00d4
            if (r2 != r1) goto L_0x00d4
        L_0x00d3:
            return
        L_0x00d4:
            com.inmobi.cmp.ChoiceCmp r7 = com.inmobi.cmp.ChoiceCmp.INSTANCE
            com.inmobi.cmp.ChoiceCmpCallback r7 = r7.getCallback()
            if (r7 != 0) goto L_0x00dd
        L_0x00dc:
            return
        L_0x00dd:
            r7.onUserMovedToOtherState()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: A3.i.b(A3.a):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0096, code lost:
        if (r1 != r0.c()) goto L_0x0132;
     */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0168  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(A3.a r6) {
        /*
            r5 = this;
            java.lang.String r0 = "config"
            kotlin.jvm.internal.m.e(r6, r0)
            A3.d r0 = A3.d.f51a
            boolean r1 = A3.d.f57g
            if (r1 != 0) goto L_0x0176
            java.lang.String r1 = "mspaConfig"
            kotlin.jvm.internal.m.e(r6, r1)
            boolean r1 = r0.d()
            if (r1 == 0) goto L_0x001c
            E2.h r1 = A3.d.f58h
            E2.h r2 = E2.h.NATIONAL
            if (r1 == r2) goto L_0x0098
        L_0x001c:
            boolean r1 = r0.e()
            if (r1 == 0) goto L_0x0132
            E2.h r1 = A3.d.f58h
            E2.h r2 = E2.h.STATE_AND_NATIONAL
            if (r1 != r2) goto L_0x0132
            java.lang.String r1 = r0.a()
            java.lang.String r2 = "region"
            kotlin.jvm.internal.m.e(r1, r2)
            java.util.Locale r2 = java.util.Locale.ROOT
            java.lang.String r1 = r1.toLowerCase(r2)
            java.lang.String r2 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
            kotlin.jvm.internal.m.d(r1, r2)
            int r2 = r1.hashCode()
            r3 = 3166(0xc5e, float:4.437E-42)
            if (r2 == r3) goto L_0x0085
            r3 = 3180(0xc6c, float:4.456E-42)
            if (r2 == r3) goto L_0x0079
            r3 = 3185(0xc71, float:4.463E-42)
            if (r2 == r3) goto L_0x006d
            r3 = 3743(0xe9f, float:5.245E-42)
            if (r2 == r3) goto L_0x0061
            r3 = 3755(0xeab, float:5.262E-42)
            if (r2 == r3) goto L_0x0055
            goto L_0x008d
        L_0x0055:
            java.lang.String r2 = "va"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x005e
            goto L_0x008d
        L_0x005e:
            A3.g r1 = A3.g.VIRGINIA
            goto L_0x0092
        L_0x0061:
            java.lang.String r2 = "ut"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x006a
            goto L_0x008d
        L_0x006a:
            A3.g r1 = A3.g.UTAH
            goto L_0x0092
        L_0x006d:
            java.lang.String r2 = "ct"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0076
            goto L_0x008d
        L_0x0076:
            A3.g r1 = A3.g.CONNECTICUT
            goto L_0x0092
        L_0x0079:
            java.lang.String r2 = "co"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0082
            goto L_0x008d
        L_0x0082:
            A3.g r1 = A3.g.COLORADO
            goto L_0x0092
        L_0x0085:
            java.lang.String r2 = "ca"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0090
        L_0x008d:
            A3.g r1 = A3.g.NOT_APPLICABLE
            goto L_0x0092
        L_0x0090:
            A3.g r1 = A3.g.CALIFORNIA
        L_0x0092:
            A3.g r0 = r0.c()
            if (r1 != r0) goto L_0x0132
        L_0x0098:
            com.inmobi.cmp.data.storage.SharedStorage r0 = A3.d.f53c
            a4.a r1 = a4.a.MSPA_PURPOSE_CONSENT
            com.inmobi.cmp.core.model.Vector r0 = r0.k(r1)
            if (r0 != 0) goto L_0x00a3
            goto L_0x00ce
        L_0x00a3:
            java.util.List r1 = r6.f32d
            if (r1 != 0) goto L_0x00a8
            goto L_0x00ce
        L_0x00a8:
            java.util.Iterator r1 = r1.iterator()
        L_0x00ac:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00ce
            java.lang.Object r2 = r1.next()
            A3.e r2 = (A3.e) r2
            java.lang.Integer r3 = r2.f60a
            if (r3 != 0) goto L_0x00bd
            goto L_0x00ac
        L_0x00bd:
            int r3 = r3.intValue()
            boolean r4 = r0.contains(r3)
            if (r4 == 0) goto L_0x00ac
            java.lang.Boolean r3 = r0.get(r3)
            r2.f63d = r3
            goto L_0x00ac
        L_0x00ce:
            com.inmobi.cmp.data.storage.SharedStorage r0 = A3.d.f53c
            a4.a r1 = a4.a.MSPA_SENSITIVE_PURPOSE_CONSENT
            com.inmobi.cmp.core.model.Vector r0 = r0.k(r1)
            if (r0 != 0) goto L_0x00d9
            goto L_0x0132
        L_0x00d9:
            java.util.List r6 = r6.f32d
            if (r6 != 0) goto L_0x00de
            goto L_0x0132
        L_0x00de:
            java.util.Iterator r6 = r6.iterator()
        L_0x00e2:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0101
            java.lang.Object r1 = r6.next()
            r2 = r1
            A3.e r2 = (A3.e) r2
            java.lang.Integer r2 = r2.f60a
            int[] r3 = f83c
            int r3 = S2.C1594h.s(r3)
            if (r2 != 0) goto L_0x00fa
            goto L_0x00e2
        L_0x00fa:
            int r2 = r2.intValue()
            if (r2 != r3) goto L_0x00e2
            goto L_0x0102
        L_0x0101:
            r1 = 0
        L_0x0102:
            A3.e r1 = (A3.e) r1
            if (r1 != 0) goto L_0x0107
            goto L_0x0132
        L_0x0107:
            java.util.List r6 = r1.f66g
            if (r6 != 0) goto L_0x010c
            goto L_0x0132
        L_0x010c:
            java.util.Iterator r6 = r6.iterator()
        L_0x0110:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0132
            java.lang.Object r1 = r6.next()
            A3.f r1 = (A3.f) r1
            java.lang.Integer r2 = r1.f68b
            if (r2 != 0) goto L_0x0121
            goto L_0x0110
        L_0x0121:
            int r2 = r2.intValue()
            boolean r3 = r0.contains(r2)
            if (r3 == 0) goto L_0x0110
            java.lang.Boolean r2 = r0.get(r2)
            r1.f70d = r2
            goto L_0x0110
        L_0x0132:
            A3.d r6 = A3.d.f51a
            A3.g r6 = r6.c()
            int r6 = r6.ordinal()
            r0 = 1
            if (r6 == 0) goto L_0x0168
            if (r6 == r0) goto L_0x0162
            r1 = 2
            if (r6 == r1) goto L_0x015c
            r1 = 3
            if (r6 == r1) goto L_0x0156
            r1 = 4
            if (r6 == r1) goto L_0x0150
            B3.e r6 = new B3.e
            r6.<init>()
            goto L_0x016d
        L_0x0150:
            B3.g r6 = new B3.g
            r6.<init>()
            goto L_0x016d
        L_0x0156:
            B3.f r6 = new B3.f
            r6.<init>()
            goto L_0x016d
        L_0x015c:
            B3.c r6 = new B3.c
            r6.<init>()
            goto L_0x016d
        L_0x0162:
            B3.b r6 = new B3.b
            r6.<init>()
            goto L_0x016d
        L_0x0168:
            B3.a r6 = new B3.a
            r6.<init>()
        L_0x016d:
            java.lang.String r1 = "<set-?>"
            kotlin.jvm.internal.m.e(r6, r1)
            A3.d.f54d = r6
            A3.d.f57g = r0
        L_0x0176:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: A3.i.c(A3.a):void");
    }
}
