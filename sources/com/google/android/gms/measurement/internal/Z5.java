package com.google.android.gms.measurement.internal;

import M.C0335p;
import R.d;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.C0542e;
import com.google.android.gms.internal.measurement.C0554f2;
import com.google.android.gms.internal.measurement.C0556f4;
import com.google.android.gms.internal.measurement.C0572h2;
import com.google.android.gms.internal.measurement.C0581i2;
import com.google.android.gms.internal.measurement.C0590j2;
import com.google.android.gms.internal.measurement.C0599k2;
import com.google.android.gms.internal.measurement.C0604k7;
import com.google.android.gms.internal.measurement.C0613l7;
import com.google.android.gms.internal.measurement.C0617m2;
import com.google.android.gms.internal.measurement.C0635o2;
import com.google.android.gms.internal.measurement.C0643p2;
import com.google.android.gms.internal.measurement.C0658r2;
import com.google.android.gms.internal.measurement.C0666s2;
import com.google.android.gms.internal.measurement.C0668s4;
import com.google.android.gms.internal.measurement.C0674t2;
import com.google.android.gms.internal.measurement.J1;
import com.google.android.gms.internal.measurement.K1;
import com.google.android.gms.internal.measurement.L1;
import com.google.android.gms.internal.measurement.M1;
import com.google.android.gms.internal.measurement.N1;
import com.google.android.gms.internal.measurement.R6;
import com.google.android.gms.internal.measurement.Y4;
import com.google.android.gms.internal.measurement.r7;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import f0.q;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class Z5 extends E5 {
    Z5(H5 h5) {
        super(h5);
    }

    static C0617m2 F(C0599k2 k2Var, String str) {
        for (C0617m2 m2Var : k2Var.V()) {
            if (m2Var.W().equals(str)) {
                return m2Var;
            }
        }
        return null;
    }

    static Y4 G(Y4 y4, byte[] bArr) {
        C0556f4 a5 = C0556f4.a();
        if (a5 != null) {
            return y4.w(bArr, a5);
        }
        return y4.v(bArr);
    }

    static Object J(C0599k2 k2Var, String str, Object obj) {
        Object f02 = f0(k2Var, str);
        if (f02 == null) {
            return obj;
        }
        return f02;
    }

    private static String N(boolean z4, boolean z5, boolean z6) {
        StringBuilder sb = new StringBuilder();
        if (z4) {
            sb.append("Dynamic ");
        }
        if (z5) {
            sb.append("Sequence ");
        }
        if (z6) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    static List O(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i4 = 0; i4 < length; i4++) {
            long j4 = 0;
            for (int i5 = 0; i5 < 64; i5++) {
                int i6 = (i4 << 6) + i5;
                if (i6 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i6)) {
                    j4 |= 1 << i5;
                }
            }
            arrayList.add(Long.valueOf(j4));
        }
        return arrayList;
    }

    private static void R(Uri.Builder builder, String str, String str2, Set set) {
        if (!set.contains(str) && !TextUtils.isEmpty(str2)) {
            builder.appendQueryParameter(str, str2);
        }
    }

    private static void S(Uri.Builder builder, String[] strArr, Bundle bundle, Set set) {
        for (String split : strArr) {
            String[] split2 = split.split(",");
            String str = split2[0];
            String str2 = split2[split2.length - 1];
            String string = bundle.getString(str);
            if (string != null) {
                R(builder, str2, string, set);
            }
        }
    }

    static void T(C0599k2.a aVar, String str, Object obj) {
        List I4 = aVar.I();
        int i4 = 0;
        while (true) {
            if (i4 >= I4.size()) {
                i4 = -1;
                break;
            } else if (str.equals(((C0617m2) I4.get(i4)).W())) {
                break;
            } else {
                i4++;
            }
        }
        C0617m2.a y4 = C0617m2.U().y(str);
        if (obj instanceof Long) {
            y4.s(((Long) obj).longValue());
        } else if (obj instanceof String) {
            y4.A((String) obj);
        } else if (obj instanceof Double) {
            y4.r(((Double) obj).doubleValue());
        }
        if (i4 >= 0) {
            aVar.s(i4, y4);
        } else {
            aVar.y(y4);
        }
    }

    private static void W(StringBuilder sb, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            sb.append("  ");
        }
    }

    private final void X(StringBuilder sb, int i4, K1 k12) {
        if (k12 != null) {
            W(sb, i4);
            sb.append("filter {\n");
            if (k12.N()) {
                a0(sb, i4, "complement", Boolean.valueOf(k12.M()));
            }
            if (k12.P()) {
                a0(sb, i4, "param_name", d().f(k12.L()));
            }
            if (k12.Q()) {
                int i5 = i4 + 1;
                N1 K4 = k12.K();
                if (K4 != null) {
                    W(sb, i5);
                    sb.append("string_filter");
                    sb.append(" {\n");
                    if (K4.O()) {
                        a0(sb, i5, "match_type", K4.G().name());
                    }
                    if (K4.N()) {
                        a0(sb, i5, "expression", K4.J());
                    }
                    if (K4.M()) {
                        a0(sb, i5, "case_sensitive", Boolean.valueOf(K4.L()));
                    }
                    if (K4.j() > 0) {
                        W(sb, i4 + 2);
                        sb.append("expression_list {\n");
                        for (String append : K4.K()) {
                            W(sb, i4 + 3);
                            sb.append(append);
                            sb.append("\n");
                        }
                        sb.append("}\n");
                    }
                    W(sb, i5);
                    sb.append("}\n");
                }
            }
            if (k12.O()) {
                Y(sb, i4 + 1, "number_filter", k12.J());
            }
            W(sb, i4);
            sb.append("}\n");
        }
    }

    private static void Y(StringBuilder sb, int i4, String str, L1 l12) {
        if (l12 != null) {
            W(sb, i4);
            sb.append(str);
            sb.append(" {\n");
            if (l12.N()) {
                a0(sb, i4, "comparison_type", l12.G().name());
            }
            if (l12.P()) {
                a0(sb, i4, "match_as_float", Boolean.valueOf(l12.M()));
            }
            if (l12.O()) {
                a0(sb, i4, "comparison_value", l12.J());
            }
            if (l12.R()) {
                a0(sb, i4, "min_comparison_value", l12.L());
            }
            if (l12.Q()) {
                a0(sb, i4, "max_comparison_value", l12.K());
            }
            W(sb, i4);
            sb.append("}\n");
        }
    }

    private static void Z(StringBuilder sb, int i4, String str, C0658r2 r2Var) {
        Integer num;
        Integer num2;
        Long l4;
        if (r2Var != null) {
            W(sb, 3);
            sb.append(str);
            sb.append(" {\n");
            if (r2Var.I() != 0) {
                W(sb, 4);
                sb.append("results: ");
                int i5 = 0;
                for (Long l5 : r2Var.V()) {
                    int i6 = i5 + 1;
                    if (i5 != 0) {
                        sb.append(", ");
                    }
                    sb.append(l5);
                    i5 = i6;
                }
                sb.append(10);
            }
            if (r2Var.O() != 0) {
                W(sb, 4);
                sb.append("status: ");
                int i7 = 0;
                for (Long l6 : r2Var.X()) {
                    int i8 = i7 + 1;
                    if (i7 != 0) {
                        sb.append(", ");
                    }
                    sb.append(l6);
                    i7 = i8;
                }
                sb.append(10);
            }
            if (r2Var.j() != 0) {
                W(sb, 4);
                sb.append("dynamic_filter_timestamps: {");
                int i9 = 0;
                for (C0590j2 j2Var : r2Var.U()) {
                    int i10 = i9 + 1;
                    if (i9 != 0) {
                        sb.append(", ");
                    }
                    if (j2Var.M()) {
                        num2 = Integer.valueOf(j2Var.j());
                    } else {
                        num2 = null;
                    }
                    sb.append(num2);
                    sb.append(":");
                    if (j2Var.L()) {
                        l4 = Long.valueOf(j2Var.I());
                    } else {
                        l4 = null;
                    }
                    sb.append(l4);
                    i9 = i10;
                }
                sb.append("}\n");
            }
            if (r2Var.L() != 0) {
                W(sb, 4);
                sb.append("sequence_filter_timestamps: {");
                int i11 = 0;
                for (C0666s2 s2Var : r2Var.W()) {
                    int i12 = i11 + 1;
                    if (i11 != 0) {
                        sb.append(", ");
                    }
                    if (s2Var.N()) {
                        num = Integer.valueOf(s2Var.J());
                    } else {
                        num = null;
                    }
                    sb.append(num);
                    sb.append(": [");
                    int i13 = 0;
                    for (Long longValue : s2Var.M()) {
                        long longValue2 = longValue.longValue();
                        int i14 = i13 + 1;
                        if (i13 != 0) {
                            sb.append(", ");
                        }
                        sb.append(longValue2);
                        i13 = i14;
                    }
                    sb.append("]");
                    i11 = i12;
                }
                sb.append("}\n");
            }
            W(sb, 3);
            sb.append("}\n");
        }
    }

    private static void a0(StringBuilder sb, int i4, String str, Object obj) {
        if (obj != null) {
            W(sb, i4 + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(10);
        }
    }

    private final void b0(StringBuilder sb, int i4, List list) {
        String str;
        String str2;
        Long l4;
        if (list != null) {
            int i5 = i4 + 1;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C0617m2 m2Var = (C0617m2) it.next();
                if (m2Var != null) {
                    W(sb, i5);
                    sb.append("param {\n");
                    Double d5 = null;
                    if (m2Var.c0()) {
                        str = d().f(m2Var.W());
                    } else {
                        str = null;
                    }
                    a0(sb, i5, RewardPlus.NAME, str);
                    if (m2Var.d0()) {
                        str2 = m2Var.X();
                    } else {
                        str2 = null;
                    }
                    a0(sb, i5, "string_value", str2);
                    if (m2Var.b0()) {
                        l4 = Long.valueOf(m2Var.S());
                    } else {
                        l4 = null;
                    }
                    a0(sb, i5, "int_value", l4);
                    if (m2Var.Z()) {
                        d5 = Double.valueOf(m2Var.G());
                    }
                    a0(sb, i5, "double_value", d5);
                    if (m2Var.Q() > 0) {
                        b0(sb, i5, m2Var.Y());
                    }
                    W(sb, i5);
                    sb.append("}\n");
                }
            }
        }
    }

    static boolean d0(E e5, M5 m5) {
        C0335p.l(e5);
        C0335p.l(m5);
        if (!TextUtils.isEmpty(m5.f2632b) || !TextUtils.isEmpty(m5.f2647q)) {
            return true;
        }
        return false;
    }

    static boolean e0(List list, int i4) {
        if (i4 >= (list.size() << 6)) {
            return false;
        }
        if (((1 << (i4 % 64)) & ((Long) list.get(i4 / 64)).longValue()) != 0) {
            return true;
        }
        return false;
    }

    static Object f0(C0599k2 k2Var, String str) {
        C0617m2 F4 = F(k2Var, str);
        if (F4 == null) {
            return null;
        }
        if (F4.d0()) {
            return F4.X();
        }
        if (F4.b0()) {
            return Long.valueOf(F4.S());
        }
        if (F4.Z()) {
            return Double.valueOf(F4.G());
        }
        if (F4.Q() > 0) {
            return i0(F4.Y());
        }
        return null;
    }

    static boolean g0(String str) {
        if (str == null || !str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") || str.length() > 310) {
            return false;
        }
        return true;
    }

    static Bundle[] i0(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0617m2 m2Var = (C0617m2) it.next();
            if (m2Var != null) {
                Bundle bundle = new Bundle();
                for (C0617m2 m2Var2 : m2Var.Y()) {
                    if (m2Var2.d0()) {
                        bundle.putString(m2Var2.W(), m2Var2.X());
                    } else if (m2Var2.b0()) {
                        bundle.putLong(m2Var2.W(), m2Var2.S());
                    } else if (m2Var2.Z()) {
                        bundle.putDouble(m2Var2.W(), m2Var2.G());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    static int v(C0643p2.a aVar, String str) {
        if (aVar == null) {
            return -1;
        }
        for (int i4 = 0; i4 < aVar.Z(); i4++) {
            if (str.equals(aVar.H0(i4).U())) {
                return i4;
            }
        }
        return -1;
    }

    static Bundle y(List list) {
        Bundle bundle = new Bundle();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0617m2 m2Var = (C0617m2) it.next();
            String W4 = m2Var.W();
            if (m2Var.Z()) {
                bundle.putDouble(W4, m2Var.G());
            } else if (m2Var.a0()) {
                bundle.putFloat(W4, m2Var.N());
            } else if (m2Var.d0()) {
                bundle.putString(W4, m2Var.X());
            } else if (m2Var.b0()) {
                bundle.putLong(W4, m2Var.S());
            }
        }
        return bundle;
    }

    private final Bundle z(Map map, boolean z4) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, (String) null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z4) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj2 = arrayList.get(i4);
                    i4++;
                    arrayList2.add(z((Map) obj2, false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    public final /* bridge */ /* synthetic */ Context A() {
        return super.A();
    }

    public final /* bridge */ /* synthetic */ d B() {
        return super.B();
    }

    public final /* bridge */ /* synthetic */ C0741c C() {
        return super.C();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        a().G().a("Failed to load parcelable from buffer");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Parcelable D(byte[] r5, android.os.Parcelable.Creator r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.os.Parcel r1 = android.os.Parcel.obtain()
            int r2 = r5.length     // Catch:{ a -> 0x001c }
            r3 = 0
            r1.unmarshall(r5, r3, r2)     // Catch:{ a -> 0x001c }
            r1.setDataPosition(r3)     // Catch:{ a -> 0x001c }
            java.lang.Object r5 = r6.createFromParcel(r1)     // Catch:{ a -> 0x001c }
            android.os.Parcelable r5 = (android.os.Parcelable) r5     // Catch:{ a -> 0x001c }
            r1.recycle()
            return r5
        L_0x001a:
            r5 = move-exception
            goto L_0x002d
        L_0x001c:
            com.google.android.gms.measurement.internal.n2 r5 = r4.a()     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.p2 r5 = r5.G()     // Catch:{ all -> 0x001a }
            java.lang.String r6 = "Failed to load parcelable from buffer"
            r5.a(r6)     // Catch:{ all -> 0x001a }
            r1.recycle()
            return r0
        L_0x002d:
            r1.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.Z5.D(byte[], android.os.Parcelable$Creator):android.os.Parcelable");
    }

    /* access modifiers changed from: package-private */
    public final C0599k2 E(B b5) {
        C0599k2.a x4 = C0599k2.S().x(b5.f2320e);
        Iterator it = b5.f2321f.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            C0617m2.a y4 = C0617m2.U().y(str);
            Object l4 = b5.f2321f.l(str);
            C0335p.l(l4);
            U(y4, l4);
            x4.y(y4);
        }
        if (b().q(G.f2485j1) && !TextUtils.isEmpty(b5.f2318c) && b5.f2321f.l("_o") == null) {
            x4.z((C0617m2) ((C0668s4) C0617m2.U().y("_o").A(b5.f2318c).m()));
        }
        return (C0599k2) ((C0668s4) x4.m());
    }

    /* access modifiers changed from: package-private */
    public final E H(C0542e eVar) {
        String str;
        Object obj;
        Bundle z4 = z(eVar.g(), true);
        if (!z4.containsKey("_o") || (obj = z4.get("_o")) == null) {
            str = MBridgeConstans.DYNAMIC_VIEW_WX_APP;
        } else {
            str = obj.toString();
        }
        String str2 = str;
        String b5 = q.b(eVar.e());
        if (b5 == null) {
            b5 = eVar.e();
        }
        return new E(b5, new D(z4), str2, eVar.a());
    }

    /* access modifiers changed from: package-private */
    public final B5 I(String str, C0643p2.a aVar, C0599k2.a aVar2, String str2) {
        int indexOf;
        if (!C0604k7.a() || !b().F(str, G.f2421I0)) {
            return null;
        }
        long currentTimeMillis = B().currentTimeMillis();
        String[] split = b().D(str, G.f2478h0).split(",");
        HashSet hashSet = new HashSet(split.length);
        int length = split.length;
        int i4 = 0;
        while (i4 < length) {
            String str3 = split[i4];
            Objects.requireNonNull(str3);
            if (hashSet.add(str3)) {
                i4++;
            } else {
                throw new IllegalArgumentException("duplicate element: " + str3);
            }
        }
        Set unmodifiableSet = DesugarCollections.unmodifiableSet(hashSet);
        G5 q4 = q();
        String R4 = q4.o().R(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(q4.b().D(str, G.f2457a0));
        if (!TextUtils.isEmpty(R4)) {
            String D4 = q4.b().D(str, G.f2460b0);
            builder.authority(R4 + "." + D4);
        } else {
            builder.authority(q4.b().D(str, G.f2460b0));
        }
        builder.path(q4.b().D(str, G.f2463c0));
        R(builder, "gmp_app_id", aVar.d1(), unmodifiableSet);
        R(builder, "gmp_version", "106000", unmodifiableSet);
        String a12 = aVar.a1();
        C0769g b5 = b();
        C0737b2 b2Var = G.f2427L0;
        if (b5.F(str, b2Var) && o().a0(str)) {
            a12 = "";
        }
        R(builder, "app_instance_id", a12, unmodifiableSet);
        R(builder, "rdid", aVar.f1(), unmodifiableSet);
        R(builder, "bundle_id", aVar.Z0(), unmodifiableSet);
        String H4 = aVar2.H();
        String a5 = q.a(H4);
        if (!TextUtils.isEmpty(a5)) {
            H4 = a5;
        }
        R(builder, "app_event_name", H4, unmodifiableSet);
        R(builder, "app_version", String.valueOf(aVar.N()), unmodifiableSet);
        String e12 = aVar.e1();
        if (b().F(str, b2Var) && o().e0(str) && !TextUtils.isEmpty(e12) && (indexOf = e12.indexOf(".")) != -1) {
            e12 = e12.substring(0, indexOf);
        }
        R(builder, "os_version", e12, unmodifiableSet);
        R(builder, CampaignEx.JSON_KEY_TIMESTAMP, String.valueOf(aVar2.F()), unmodifiableSet);
        String str4 = "1";
        if (aVar.L()) {
            R(builder, "lat", str4, unmodifiableSet);
        }
        R(builder, "privacy_sandbox_version", String.valueOf(aVar.q()), unmodifiableSet);
        R(builder, "trigger_uri_source", str4, unmodifiableSet);
        R(builder, "trigger_uri_timestamp", String.valueOf(currentTimeMillis), unmodifiableSet);
        R(builder, "request_uuid", str2, unmodifiableSet);
        List<C0617m2> I4 = aVar2.I();
        Bundle bundle = new Bundle();
        for (C0617m2 m2Var : I4) {
            String W4 = m2Var.W();
            if (m2Var.Z()) {
                bundle.putString(W4, String.valueOf(m2Var.G()));
            } else if (m2Var.a0()) {
                bundle.putString(W4, String.valueOf(m2Var.N()));
            } else if (m2Var.d0()) {
                bundle.putString(W4, m2Var.X());
            } else if (m2Var.b0()) {
                bundle.putString(W4, String.valueOf(m2Var.S()));
            }
        }
        S(builder, b().D(str, G.f2475g0).split("\\|"), bundle, unmodifiableSet);
        List<C0674t2> J4 = aVar.J();
        Bundle bundle2 = new Bundle();
        for (C0674t2 t2Var : J4) {
            String U4 = t2Var.U();
            if (t2Var.W()) {
                bundle2.putString(U4, String.valueOf(t2Var.G()));
            } else if (t2Var.X()) {
                bundle2.putString(U4, String.valueOf(t2Var.L()));
            } else if (t2Var.a0()) {
                bundle2.putString(U4, t2Var.V());
            } else if (t2Var.Y()) {
                bundle2.putString(U4, String.valueOf(t2Var.P()));
            }
        }
        S(builder, b().D(str, G.f2472f0).split("\\|"), bundle2, unmodifiableSet);
        if (!aVar.K()) {
            str4 = "0";
        }
        R(builder, "dma", str4, unmodifiableSet);
        if (!aVar.c1().isEmpty()) {
            R(builder, "dma_cps", aVar.c1(), unmodifiableSet);
        }
        if (b().q(G.f2431N0) && aVar.M()) {
            C0554f2 o02 = aVar.o0();
            if (!o02.b0().isEmpty()) {
                R(builder, "dl_gclid", o02.b0(), unmodifiableSet);
            }
            if (!o02.a0().isEmpty()) {
                R(builder, "dl_gbraid", o02.a0(), unmodifiableSet);
            }
            if (!o02.X().isEmpty()) {
                R(builder, "dl_gs", o02.X(), unmodifiableSet);
            }
            if (o02.G() > 0) {
                R(builder, "dl_ss_ts", String.valueOf(o02.G()), unmodifiableSet);
            }
            if (!o02.e0().isEmpty()) {
                R(builder, "mr_gclid", o02.e0(), unmodifiableSet);
            }
            if (!o02.d0().isEmpty()) {
                R(builder, "mr_gbraid", o02.d0(), unmodifiableSet);
            }
            if (!o02.c0().isEmpty()) {
                R(builder, "mr_gs", o02.c0(), unmodifiableSet);
            }
            if (o02.K() > 0) {
                R(builder, "mr_click_ts", String.valueOf(o02.K()), unmodifiableSet);
            }
        }
        return new B5(builder.build().toString(), currentTimeMillis, 1);
    }

    /* access modifiers changed from: package-private */
    public final String K(J1 j12) {
        if (j12 == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (j12.T()) {
            a0(sb, 0, "filter_id", Integer.valueOf(j12.J()));
        }
        a0(sb, 0, "event_name", d().c(j12.N()));
        String N4 = N(j12.P(), j12.Q(), j12.R());
        if (!N4.isEmpty()) {
            a0(sb, 0, "filter_type", N4);
        }
        if (j12.S()) {
            Y(sb, 1, "event_count_filter", j12.M());
        }
        if (j12.j() > 0) {
            sb.append("  filters {\n");
            for (K1 X4 : j12.O()) {
                X(sb, 2, X4);
            }
        }
        W(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String L(M1 m12) {
        if (m12 == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (m12.O()) {
            a0(sb, 0, "filter_id", Integer.valueOf(m12.j()));
        }
        a0(sb, 0, "property_name", d().g(m12.K()));
        String N4 = N(m12.L(), m12.M(), m12.N());
        if (!N4.isEmpty()) {
            a0(sb, 0, "filter_type", N4);
        }
        X(sb, 1, m12.H());
        sb.append("}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String M(C0635o2 o2Var) {
        Long l4;
        Long l5;
        C0572h2 t22;
        if (o2Var == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (r7.a() && b().q(G.f2518y0) && o2Var.j() > 0) {
            g();
            if (d6.H0(o2Var.H(0).x2())) {
                if (o2Var.T()) {
                    a0(sb, 0, "upload_subdomain", o2Var.Q());
                }
                if (o2Var.S()) {
                    a0(sb, 0, "sgtm_join_id", o2Var.P());
                }
            }
        }
        for (C0643p2 p2Var : o2Var.R()) {
            if (p2Var != null) {
                W(sb, 1);
                sb.append("bundle {\n");
                if (p2Var.R0()) {
                    a0(sb, 1, "protocol_version", Integer.valueOf(p2Var.w1()));
                }
                if (C0613l7.a() && b().F(p2Var.x2(), G.f2516x0) && p2Var.U0()) {
                    a0(sb, 1, "session_stitching_token", p2Var.i0());
                }
                a0(sb, 1, "platform", p2Var.g0());
                if (p2Var.M0()) {
                    a0(sb, 1, "gmp_version", Long.valueOf(p2Var.f2()));
                }
                if (p2Var.Z0()) {
                    a0(sb, 1, "uploading_gmp_version", Long.valueOf(p2Var.r2()));
                }
                if (p2Var.K0()) {
                    a0(sb, 1, "dynamite_version", Long.valueOf(p2Var.Y1()));
                }
                if (p2Var.D0()) {
                    a0(sb, 1, "config_version", Long.valueOf(p2Var.Q1()));
                }
                a0(sb, 1, "gmp_app_id", p2Var.d0());
                a0(sb, 1, "admob_app_id", p2Var.w2());
                a0(sb, 1, MBridgeConstans.APP_ID, p2Var.x2());
                a0(sb, 1, "app_version", p2Var.W());
                if (p2Var.s0()) {
                    a0(sb, 1, "app_version_major", Integer.valueOf(p2Var.u0()));
                }
                a0(sb, 1, "firebase_instance_id", p2Var.c0());
                if (p2Var.I0()) {
                    a0(sb, 1, "dev_cert_hash", Long.valueOf(p2Var.U1()));
                }
                a0(sb, 1, "app_store", p2Var.V());
                if (p2Var.Y0()) {
                    a0(sb, 1, "upload_timestamp_millis", Long.valueOf(p2Var.p2()));
                }
                if (p2Var.V0()) {
                    a0(sb, 1, "start_timestamp_millis", Long.valueOf(p2Var.l2()));
                }
                if (p2Var.L0()) {
                    a0(sb, 1, "end_timestamp_millis", Long.valueOf(p2Var.c2()));
                }
                if (p2Var.Q0()) {
                    a0(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(p2Var.j2()));
                }
                if (p2Var.P0()) {
                    a0(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(p2Var.h2()));
                }
                a0(sb, 1, "app_instance_id", p2Var.U());
                a0(sb, 1, "resettable_device_id", p2Var.h0());
                a0(sb, 1, "ds_id", p2Var.b0());
                if (p2Var.O0()) {
                    a0(sb, 1, "limited_ad_tracking", Boolean.valueOf(p2Var.p0()));
                }
                a0(sb, 1, "os_version", p2Var.f0());
                a0(sb, 1, "device_model", p2Var.a0());
                a0(sb, 1, "user_default_language", p2Var.j0());
                if (p2Var.X0()) {
                    a0(sb, 1, "time_zone_offset_minutes", Integer.valueOf(p2Var.G1()));
                }
                if (p2Var.C0()) {
                    a0(sb, 1, "bundle_sequential_index", Integer.valueOf(p2Var.a1()));
                }
                if (r7.a()) {
                    g();
                    if (d6.H0(p2Var.x2()) && b().q(G.f2518y0) && p2Var.H0()) {
                        a0(sb, 1, "delivery_index", Integer.valueOf(p2Var.j1()));
                    }
                }
                if (p2Var.T0()) {
                    a0(sb, 1, "service_upload", Boolean.valueOf(p2Var.q0()));
                }
                a0(sb, 1, "health_monitor", p2Var.e0());
                if (p2Var.S0()) {
                    a0(sb, 1, "retry_counter", Integer.valueOf(p2Var.B1()));
                }
                if (p2Var.F0()) {
                    a0(sb, 1, "consent_signals", p2Var.Y());
                }
                if (p2Var.N0()) {
                    a0(sb, 1, "is_dma_region", Boolean.valueOf(p2Var.o0()));
                }
                if (p2Var.G0()) {
                    a0(sb, 1, "core_platform_services", p2Var.Z());
                }
                if (p2Var.E0()) {
                    a0(sb, 1, "consent_diagnostics", p2Var.X());
                }
                if (p2Var.W0()) {
                    a0(sb, 1, "target_os_version", Long.valueOf(p2Var.n2()));
                }
                if (C0604k7.a() && b().F(p2Var.x2(), G.f2421I0)) {
                    a0(sb, 1, "ad_services_version", Integer.valueOf(p2Var.j()));
                    if (p2Var.t0() && (t22 = p2Var.t2()) != null) {
                        W(sb, 2);
                        sb.append("attribution_eligibility_status {\n");
                        a0(sb, 2, "eligible", Boolean.valueOf(t22.R()));
                        a0(sb, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(t22.U()));
                        a0(sb, 2, "pre_r", Boolean.valueOf(t22.V()));
                        a0(sb, 2, "r_extensions_too_old", Boolean.valueOf(t22.W()));
                        a0(sb, 2, "adservices_extension_too_old", Boolean.valueOf(t22.P()));
                        a0(sb, 2, "ad_storage_not_allowed", Boolean.valueOf(t22.N()));
                        a0(sb, 2, "measurement_manager_disabled", Boolean.valueOf(t22.T()));
                        W(sb, 2);
                        sb.append("}\n");
                    }
                }
                if (R6.a() && b().q(G.f2447V0) && p2Var.r0()) {
                    C0554f2 s22 = p2Var.s2();
                    W(sb, 2);
                    sb.append("ad_campaign_info {\n");
                    if (s22.h0()) {
                        a0(sb, 2, "deep_link_gclid", s22.b0());
                    }
                    if (s22.g0()) {
                        a0(sb, 2, "deep_link_gbraid", s22.a0());
                    }
                    if (s22.f0()) {
                        a0(sb, 2, "deep_link_gad_source", s22.X());
                    }
                    if (s22.i0()) {
                        a0(sb, 2, "deep_link_session_millis", Long.valueOf(s22.G()));
                    }
                    if (s22.m0()) {
                        a0(sb, 2, "market_referrer_gclid", s22.e0());
                    }
                    if (s22.l0()) {
                        a0(sb, 2, "market_referrer_gbraid", s22.d0());
                    }
                    if (s22.k0()) {
                        a0(sb, 2, "market_referrer_gad_source", s22.c0());
                    }
                    if (s22.j0()) {
                        a0(sb, 2, "market_referrer_click_millis", Long.valueOf(s22.K()));
                    }
                    W(sb, 2);
                    sb.append("}\n");
                }
                List<C0674t2> m02 = p2Var.m0();
                if (m02 != null) {
                    for (C0674t2 t2Var : m02) {
                        if (t2Var != null) {
                            W(sb, 2);
                            sb.append("user_property {\n");
                            Double d5 = null;
                            if (t2Var.Z()) {
                                l4 = Long.valueOf(t2Var.R());
                            } else {
                                l4 = null;
                            }
                            a0(sb, 2, "set_timestamp_millis", l4);
                            a0(sb, 2, RewardPlus.NAME, d().g(t2Var.U()));
                            a0(sb, 2, "string_value", t2Var.V());
                            if (t2Var.Y()) {
                                l5 = Long.valueOf(t2Var.P());
                            } else {
                                l5 = null;
                            }
                            a0(sb, 2, "int_value", l5);
                            if (t2Var.W()) {
                                d5 = Double.valueOf(t2Var.G());
                            }
                            a0(sb, 2, "double_value", d5);
                            W(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<C0581i2> k02 = p2Var.k0();
                p2Var.x2();
                if (k02 != null) {
                    for (C0581i2 i2Var : k02) {
                        if (i2Var != null) {
                            W(sb, 2);
                            sb.append("audience_membership {\n");
                            if (i2Var.P()) {
                                a0(sb, 2, "audience_id", Integer.valueOf(i2Var.j()));
                            }
                            if (i2Var.Q()) {
                                a0(sb, 2, "new_audience", Boolean.valueOf(i2Var.O()));
                            }
                            Z(sb, 2, "current_data", i2Var.M());
                            if (i2Var.R()) {
                                Z(sb, 2, "previous_data", i2Var.N());
                            }
                            W(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<C0599k2> l02 = p2Var.l0();
                if (l02 != null) {
                    for (C0599k2 k2Var : l02) {
                        if (k2Var != null) {
                            W(sb, 2);
                            sb.append("event {\n");
                            a0(sb, 2, RewardPlus.NAME, d().c(k2Var.U()));
                            if (k2Var.Y()) {
                                a0(sb, 2, "timestamp_millis", Long.valueOf(k2Var.R()));
                            }
                            if (k2Var.X()) {
                                a0(sb, 2, "previous_timestamp_millis", Long.valueOf(k2Var.Q()));
                            }
                            if (k2Var.W()) {
                                a0(sb, 2, "count", Integer.valueOf(k2Var.j()));
                            }
                            if (k2Var.O() != 0) {
                                b0(sb, 2, k2Var.V());
                            }
                            W(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                W(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("} // End-of-batch\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final List P(List list, List list2) {
        int i4;
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < 0) {
                a().L().b("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    a().L().c("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i5 = size2;
            i4 = size;
            size = i5;
            if (size >= 0 && ((Long) arrayList.get(size)).longValue() == 0) {
                size2 = size - 1;
            }
        }
        return arrayList.subList(0, i4);
    }

    /* access modifiers changed from: package-private */
    public final Map Q(Bundle bundle, boolean z4) {
        HashMap hashMap = new HashMap();
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            boolean z5 = obj instanceof Parcelable[];
            if (z5 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z4) {
                    ArrayList arrayList = new ArrayList();
                    if (z5) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(Q((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        int i4 = 0;
                        while (i4 < size) {
                            Object obj2 = arrayList2.get(i4);
                            i4++;
                            if (obj2 instanceof Bundle) {
                                arrayList.add(Q((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(Q((Bundle) obj, false));
                    }
                    hashMap.put(next, arrayList);
                }
            } else if (obj != null) {
                hashMap.put(next, obj);
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public final void U(C0617m2.a aVar, Object obj) {
        C0335p.l(obj);
        aVar.D().B().z().C();
        if (obj instanceof String) {
            aVar.A((String) obj);
        } else if (obj instanceof Long) {
            aVar.s(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            aVar.r(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            ArrayList arrayList = new ArrayList();
            for (Bundle bundle : (Bundle[]) obj) {
                if (bundle != null) {
                    C0617m2.a U4 = C0617m2.U();
                    for (String next : bundle.keySet()) {
                        C0617m2.a y4 = C0617m2.U().y(next);
                        Object obj2 = bundle.get(next);
                        if (obj2 instanceof Long) {
                            y4.s(((Long) obj2).longValue());
                        } else if (obj2 instanceof String) {
                            y4.A((String) obj2);
                        } else if (obj2 instanceof Double) {
                            y4.r(((Double) obj2).doubleValue());
                        }
                        U4.t(y4);
                    }
                    if (U4.q() > 0) {
                        arrayList.add((C0617m2) ((C0668s4) U4.m()));
                    }
                }
            }
            aVar.x(arrayList);
        } else {
            a().G().b("Ignoring invalid (type) event param value", obj);
        }
    }

    /* access modifiers changed from: package-private */
    public final void V(C0674t2.a aVar, Object obj) {
        C0335p.l(obj);
        aVar.A().x().q();
        if (obj instanceof String) {
            aVar.z((String) obj);
        } else if (obj instanceof Long) {
            aVar.s(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            aVar.r(((Double) obj).doubleValue());
        } else {
            a().G().b("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final /* bridge */ /* synthetic */ C0821n2 a() {
        return super.a();
    }

    public final /* bridge */ /* synthetic */ C0769g b() {
        return super.b();
    }

    public final /* bridge */ /* synthetic */ C0887x c() {
        return super.c();
    }

    /* access modifiers changed from: package-private */
    public final boolean c0(long j4, long j5) {
        if (j4 == 0 || j5 <= 0 || Math.abs(B().currentTimeMillis() - j4) > j5) {
            return true;
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ C0779h2 d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ C0904z2 e() {
        return super.e();
    }

    public final /* bridge */ /* synthetic */ P2 f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ d6 g() {
        return super.g();
    }

    /* access modifiers changed from: package-private */
    public final byte[] h0(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e5) {
            a().G().b("Failed to gzip content", e5);
            throw e5;
        }
    }

    public final /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    /* access modifiers changed from: package-private */
    public final byte[] j0(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e5) {
            a().G().b("Failed to ungzip content", e5);
            throw e5;
        }
    }

    public final /* bridge */ /* synthetic */ void k() {
        super.k();
    }

    /* access modifiers changed from: package-private */
    public final List k0() {
        Map e5 = G.e(this.f2403b.A());
        if (e5 == null || e5.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int intValue = ((Integer) G.f2440S.a((Object) null)).intValue();
        Iterator it = e5.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            if (((String) entry.getKey()).startsWith("measurement.id.")) {
                try {
                    int parseInt = Integer.parseInt((String) entry.getValue());
                    if (parseInt != 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                        if (arrayList.size() >= intValue) {
                            a().L().b("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e6) {
                    a().L().b("Experiment ID NumberFormatException", e6);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public final /* bridge */ /* synthetic */ Z5 l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ h6 m() {
        return super.m();
    }

    public final /* bridge */ /* synthetic */ C0797k n() {
        return super.n();
    }

    public final /* bridge */ /* synthetic */ I2 o() {
        return super.o();
    }

    public final /* bridge */ /* synthetic */ C0796j5 p() {
        return super.p();
    }

    public final /* bridge */ /* synthetic */ G5 q() {
        return super.q();
    }

    /* access modifiers changed from: protected */
    public final boolean u() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final long w(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return x(str.getBytes(Charset.forName(C.UTF8_NAME)));
    }

    /* access modifiers changed from: package-private */
    public final long x(byte[] bArr) {
        C0335p.l(bArr);
        g().k();
        MessageDigest V02 = d6.V0();
        if (V02 != null) {
            return d6.y(V02.digest(bArr));
        }
        a().G().a("Failed to get MD5");
        return 0;
    }
}
