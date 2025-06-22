package g2;

import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.json.JSONObject;
import u2.y;

/* renamed from: g2.t  reason: case insensitive filesystem */
public final class C2061t {

    /* renamed from: d  reason: collision with root package name */
    public static final a f20768d = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private long f20769a;

    /* renamed from: b  reason: collision with root package name */
    private String f20770b;

    /* renamed from: c  reason: collision with root package name */
    private long f20771c;

    /* renamed from: g2.t$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private final String a(String str, String str2) {
            String str3 = "uptodown.native.1." + str;
            if (str2 == null) {
                return str3;
            }
            return str3 + '.' + str2;
        }

        private final boolean b(String str) {
            if (m.a(str, TypedValues.TransitionType.S_DURATION) || m.a(str, "speed")) {
                return true;
            }
            return false;
        }

        private final boolean c(String str) {
            if (m.a(str, "deeplink") || m.a(str, "update")) {
                return true;
            }
            return false;
        }

        private final boolean d(String str) {
            if (m.a(str, "responseCode") || m.a(str, "exception") || m.a(str, CampaignEx.JSON_NATIVE_VIDEO_ERROR) || m.a(str, "extraError") || m.a(str, "filehashCalculated")) {
                return true;
            }
            return false;
        }

        private final boolean e(String str) {
            if (m.a(str, "host") || m.a(str, "connectionType") || m.a(str, "downBandwidthKbps") || m.a(str, "upBandwidthKbps")) {
                return true;
            }
            return false;
        }

        private final void f(String str, JSONObject jSONObject, Bundle bundle) {
            y yVar = y.f21955a;
            if (yVar.d(str)) {
                jSONObject.put(str, bundle.getLong(str));
            } else if (yVar.c(str)) {
                jSONObject.put(str, bundle.getInt(str));
            } else {
                jSONObject.put(str, bundle.getString(str));
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:102:0x0217  */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x0222  */
        /* JADX WARNING: Removed duplicated region for block: B:108:0x022d  */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x0238  */
        /* JADX WARNING: Removed duplicated region for block: B:144:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final g2.C2061t g(java.lang.String r22, android.os.Bundle r23, android.content.Context r24) {
            /*
                r21 = this;
                r0 = r21
                r1 = r22
                r2 = r23
                r3 = r24
                java.lang.String r4 = "name"
                kotlin.jvm.internal.m.e(r1, r4)
                java.lang.String r4 = "params"
                kotlin.jvm.internal.m.e(r2, r4)
                if (r3 == 0) goto L_0x0266
                long r5 = java.lang.System.currentTimeMillis()
                org.json.JSONObject r7 = new org.json.JSONObject
                r7.<init>()
                org.json.JSONObject r8 = new org.json.JSONObject
                r8.<init>()
                org.json.JSONObject r9 = new org.json.JSONObject
                r9.<init>()
                org.json.JSONObject r10 = new org.json.JSONObject
                r10.<init>()
                com.uptodown.activities.preferences.a$a r11 = com.uptodown.activities.preferences.a.f18818a
                boolean r11 = r11.M(r3)
                if (r11 == 0) goto L_0x0045
                g2.r r11 = new g2.r
                r11.<init>()
                r11.j(r3)
                java.lang.String r12 = "identifier"
                java.lang.String r11 = r11.d()
                r8.put(r12, r11)
            L_0x0045:
                java.lang.String r11 = "storeVersionCode"
                r12 = 671(0x29f, float:9.4E-43)
                r8.put(r11, r12)
                java.util.Locale r11 = java.util.Locale.getDefault()
                java.lang.String r11 = r11.getCountry()
                java.lang.String r12 = "phone"
                java.lang.Object r12 = r3.getSystemService(r12)
                java.lang.String r13 = "null cannot be cast to non-null type android.telephony.TelephonyManager"
                kotlin.jvm.internal.m.c(r12, r13)
                android.telephony.TelephonyManager r12 = (android.telephony.TelephonyManager) r12
                if (r11 == 0) goto L_0x0069
                int r13 = r11.length()
                if (r13 != 0) goto L_0x006d
            L_0x0069:
                java.lang.String r11 = r12.getNetworkCountryIso()
            L_0x006d:
                if (r11 == 0) goto L_0x007b
                int r12 = r11.length()
                if (r12 != 0) goto L_0x0076
                goto L_0x007b
            L_0x0076:
                java.lang.String r12 = "country"
                r7.put(r12, r11)
            L_0x007b:
                org.json.JSONObject r11 = new org.json.JSONObject
                r11.<init>()
                r12 = 1000(0x3e8, float:1.401E-42)
                long r12 = (long) r12
                long r12 = r5 / r12
                java.lang.String r14 = "occurred_on"
                r11.put(r14, r12)
                java.lang.String r12 = "download"
                r13 = 0
                boolean r14 = m3.m.p(r1, r12, r13)
                java.lang.String r15 = "network"
                r16 = 0
                java.lang.String r4 = "type"
                java.lang.String r13 = "messageName"
                if (r14 == 0) goto L_0x0114
                org.json.JSONObject r14 = new org.json.JSONObject
                r14.<init>()
                java.util.Set r17 = r2.keySet()
                java.util.Iterator r17 = r17.iterator()
                r3 = r16
            L_0x00aa:
                boolean r18 = r17.hasNext()
                if (r18 == 0) goto L_0x00f6
                java.lang.Object r18 = r17.next()
                r19 = r5
                r5 = r18
                java.lang.String r5 = (java.lang.String) r5
                boolean r6 = kotlin.jvm.internal.m.a(r5, r4)
                if (r6 == 0) goto L_0x00c7
                java.lang.String r3 = r2.getString(r5)
            L_0x00c4:
                r5 = r19
                goto L_0x00aa
            L_0x00c7:
                kotlin.jvm.internal.m.b(r5)
                boolean r6 = r0.d(r5)
                if (r6 == 0) goto L_0x00d4
                r0.f(r5, r9, r2)
                goto L_0x00c4
            L_0x00d4:
                boolean r6 = r0.b(r5)
                if (r6 == 0) goto L_0x00de
                r0.f(r5, r8, r2)
                goto L_0x00c4
            L_0x00de:
                boolean r6 = r0.e(r5)
                if (r6 == 0) goto L_0x00e8
                r0.f(r5, r10, r2)
                goto L_0x00c4
            L_0x00e8:
                boolean r6 = r0.c(r5)
                if (r6 == 0) goto L_0x00f2
                r0.f(r5, r14, r2)
                goto L_0x00c4
            L_0x00f2:
                r0.f(r5, r7, r2)
                goto L_0x00c4
            L_0x00f6:
                r19 = r5
                int r2 = r10.length()
                if (r2 <= 0) goto L_0x0101
                r8.put(r15, r10)
            L_0x0101:
                int r2 = r14.length()
                if (r2 <= 0) goto L_0x010a
                r7.put(r12, r14)
            L_0x010a:
                java.lang.String r1 = r0.a(r1, r3)
                r11.put(r13, r1)
            L_0x0111:
                r5 = 0
                goto L_0x01b8
            L_0x0114:
                r19 = r5
                java.lang.String r3 = "install"
                r5 = 0
                boolean r3 = m3.m.p(r1, r3, r5)
                if (r3 == 0) goto L_0x0159
                java.util.Set r3 = r2.keySet()
                java.util.Iterator r3 = r3.iterator()
                r5 = r16
            L_0x0129:
                boolean r6 = r3.hasNext()
                if (r6 == 0) goto L_0x0151
                java.lang.Object r6 = r3.next()
                java.lang.String r6 = (java.lang.String) r6
                boolean r10 = kotlin.jvm.internal.m.a(r6, r4)
                if (r10 == 0) goto L_0x0140
                java.lang.String r5 = r2.getString(r6)
                goto L_0x0129
            L_0x0140:
                kotlin.jvm.internal.m.b(r6)
                boolean r10 = r0.d(r6)
                if (r10 == 0) goto L_0x014d
                r0.f(r6, r9, r2)
                goto L_0x0129
            L_0x014d:
                r0.f(r6, r7, r2)
                goto L_0x0129
            L_0x0151:
                java.lang.String r1 = r0.a(r1, r5)
                r11.put(r13, r1)
                goto L_0x0111
            L_0x0159:
                java.lang.String r3 = "upload"
                r5 = 0
                boolean r3 = m3.m.p(r1, r3, r5)
                if (r3 == 0) goto L_0x01ba
                java.util.Set r3 = r2.keySet()
                java.util.Iterator r3 = r3.iterator()
                r6 = r16
            L_0x016c:
                boolean r12 = r3.hasNext()
                if (r12 == 0) goto L_0x01a8
                java.lang.Object r12 = r3.next()
                java.lang.String r12 = (java.lang.String) r12
                boolean r14 = kotlin.jvm.internal.m.a(r12, r4)
                if (r14 == 0) goto L_0x0183
                java.lang.String r6 = r2.getString(r12)
                goto L_0x016c
            L_0x0183:
                kotlin.jvm.internal.m.b(r12)
                boolean r14 = r0.d(r12)
                if (r14 == 0) goto L_0x0190
                r0.f(r12, r9, r2)
                goto L_0x016c
            L_0x0190:
                boolean r14 = r0.e(r12)
                if (r14 == 0) goto L_0x019a
                r0.f(r12, r10, r2)
                goto L_0x016c
            L_0x019a:
                boolean r14 = r0.b(r12)
                if (r14 == 0) goto L_0x01a4
                r0.f(r12, r8, r2)
                goto L_0x016c
            L_0x01a4:
                r0.f(r12, r7, r2)
                goto L_0x016c
            L_0x01a8:
                int r2 = r10.length()
                if (r2 <= 0) goto L_0x01b1
                r8.put(r15, r10)
            L_0x01b1:
                java.lang.String r1 = r0.a(r1, r6)
                r11.put(r13, r1)
            L_0x01b8:
                r1 = 0
                goto L_0x0211
            L_0x01ba:
                java.util.Set r3 = r2.keySet()
                java.util.Iterator r3 = r3.iterator()
                r5 = r16
            L_0x01c4:
                boolean r6 = r3.hasNext()
                if (r6 == 0) goto L_0x0200
                java.lang.Object r6 = r3.next()
                java.lang.String r6 = (java.lang.String) r6
                boolean r12 = kotlin.jvm.internal.m.a(r6, r4)
                if (r12 == 0) goto L_0x01db
                java.lang.String r5 = r2.getString(r6)
                goto L_0x01c4
            L_0x01db:
                kotlin.jvm.internal.m.b(r6)
                boolean r12 = r0.d(r6)
                if (r12 == 0) goto L_0x01e8
                r0.f(r6, r9, r2)
                goto L_0x01c4
            L_0x01e8:
                boolean r12 = r0.e(r6)
                if (r12 == 0) goto L_0x01f2
                r0.f(r6, r10, r2)
                goto L_0x01c4
            L_0x01f2:
                boolean r12 = r0.b(r6)
                if (r12 == 0) goto L_0x01fc
                r0.f(r6, r8, r2)
                goto L_0x01c4
            L_0x01fc:
                r0.f(r6, r7, r2)
                goto L_0x01c4
            L_0x0200:
                int r2 = r10.length()
                if (r2 <= 0) goto L_0x0209
                r8.put(r15, r10)
            L_0x0209:
                java.lang.String r1 = r0.a(r1, r5)
                r11.put(r13, r1)
                r1 = 1
            L_0x0211:
                int r2 = r8.length()
                if (r2 <= 0) goto L_0x021c
                java.lang.String r2 = "context"
                r11.put(r2, r8)
            L_0x021c:
                int r2 = r7.length()
                if (r2 <= 0) goto L_0x0227
                java.lang.String r2 = "payload"
                r11.put(r2, r7)
            L_0x0227:
                int r2 = r9.length()
                if (r2 <= 0) goto L_0x0232
                java.lang.String r2 = "error"
                r11.put(r2, r9)
            L_0x0232:
                boolean r2 = r11.isNull(r13)
                if (r2 != 0) goto L_0x0268
                java.lang.String r2 = r11.toString()
                java.lang.String r3 = "toString(...)"
                kotlin.jvm.internal.m.d(r2, r3)
                g2.t r3 = new g2.t
                r3.<init>()
                r3.e(r2)
                r4 = r19
                r3.f(r4)
                u2.t$a r2 = u2.t.f21927u
                r4 = r24
                u2.t r2 = r2.a(r4)
                r2.a()
                if (r1 != 0) goto L_0x025f
                r2.O0(r3)
                goto L_0x0262
            L_0x025f:
                r2.P0(r3)
            L_0x0262:
                r2.i()
                return r3
            L_0x0266:
                r16 = 0
            L_0x0268:
                return r16
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.C2061t.a.g(java.lang.String, android.os.Bundle, android.content.Context):g2.t");
        }

        private a() {
        }
    }

    public final long a() {
        return this.f20769a;
    }

    public final String b() {
        return this.f20770b;
    }

    public final long c() {
        return this.f20771c;
    }

    public final void d(long j4) {
        this.f20769a = j4;
    }

    public final void e(String str) {
        this.f20770b = str;
    }

    public final void f(long j4) {
        this.f20771c = j4;
    }
}
