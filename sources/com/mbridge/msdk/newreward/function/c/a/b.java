package com.mbridge.msdk.newreward.function.c.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.function.c.c.d;
import com.mbridge.msdk.newreward.function.c.c.e;
import com.mbridge.msdk.newreward.function.c.c.i;
import com.mbridge.msdk.newreward.function.c.c.n;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.newreward.function.h.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class b {

    /* renamed from: A  reason: collision with root package name */
    private String f14491A;

    /* renamed from: B  reason: collision with root package name */
    private int f14492B;

    /* renamed from: C  reason: collision with root package name */
    private int f14493C;

    /* renamed from: D  reason: collision with root package name */
    private List<CampaignEx> f14494D;

    /* renamed from: E  reason: collision with root package name */
    private int f14495E;

    /* renamed from: F  reason: collision with root package name */
    private int f14496F = 0;

    /* renamed from: G  reason: collision with root package name */
    private long f14497G;

    /* renamed from: H  reason: collision with root package name */
    private Map<String, Object> f14498H;

    /* renamed from: I  reason: collision with root package name */
    private String f14499I;

    /* renamed from: J  reason: collision with root package name */
    private boolean f14500J = false;

    /* renamed from: K  reason: collision with root package name */
    private int f14501K = 0;

    /* renamed from: L  reason: collision with root package name */
    private int f14502L = 0;

    /* renamed from: a  reason: collision with root package name */
    private int f14503a;

    /* renamed from: b  reason: collision with root package name */
    private String f14504b;

    /* renamed from: c  reason: collision with root package name */
    private String f14505c;

    /* renamed from: d  reason: collision with root package name */
    private String f14506d;

    /* renamed from: e  reason: collision with root package name */
    private String f14507e;

    /* renamed from: f  reason: collision with root package name */
    private String f14508f;

    /* renamed from: g  reason: collision with root package name */
    private String f14509g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f14510h;

    /* renamed from: i  reason: collision with root package name */
    private long f14511i = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;

    /* renamed from: j  reason: collision with root package name */
    private int f14512j;

    /* renamed from: k  reason: collision with root package name */
    private String f14513k;

    /* renamed from: l  reason: collision with root package name */
    private String f14514l;

    /* renamed from: m  reason: collision with root package name */
    private String f14515m;

    /* renamed from: n  reason: collision with root package name */
    private String f14516n;

    /* renamed from: o  reason: collision with root package name */
    private int f14517o;

    /* renamed from: p  reason: collision with root package name */
    private long f14518p;

    /* renamed from: q  reason: collision with root package name */
    private long f14519q;

    /* renamed from: r  reason: collision with root package name */
    private long f14520r;

    /* renamed from: s  reason: collision with root package name */
    private double f14521s;

    /* renamed from: t  reason: collision with root package name */
    private int f14522t;

    /* renamed from: u  reason: collision with root package name */
    private List<a> f14523u;

    /* renamed from: v  reason: collision with root package name */
    private JSONObject f14524v;

    /* renamed from: w  reason: collision with root package name */
    private d<?> f14525w;

    /* renamed from: x  reason: collision with root package name */
    private int f14526x = MBridgeCommon.DEFAULT_LOAD_TIMEOUT;

    /* renamed from: y  reason: collision with root package name */
    private int f14527y = MBridgeCommon.DEFAULT_LOAD_TIMEOUT;

    /* renamed from: z  reason: collision with root package name */
    private Context f14528z;

    public b(int i4, String str, String str2, String str3) {
        this.f14503a = i4;
        this.f14504b = str;
        this.f14505c = str2;
        this.f14506d = str3;
    }

    public final boolean A() {
        if (this.f14518p > System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    public final String B() {
        return this.f14491A;
    }

    public final int C() {
        return this.f14493C;
    }

    public final int D() {
        return this.f14492B;
    }

    public final List<CampaignEx> E() {
        return this.f14494D;
    }

    public final int F() {
        int i4 = this.f14495E;
        if (i4 <= 0) {
            return 1;
        }
        return i4;
    }

    public final int G() {
        return this.f14496F;
    }

    public final Map<String, Object> H() {
        if (this.f14498H == null) {
            this.f14498H = new HashMap();
        }
        return this.f14498H;
    }

    public final long I() {
        return this.f14497G;
    }

    public final String J() {
        return this.f14499I;
    }

    public final boolean K() {
        return this.f14500J;
    }

    public final int a() {
        return this.f14501K;
    }

    public final int b() {
        return this.f14502L;
    }

    public final int c() {
        return this.f14503a;
    }

    public final String d() {
        return this.f14505c;
    }

    public final String e() {
        return this.f14506d;
    }

    public final String f() {
        return this.f14507e;
    }

    public final String g() {
        return this.f14508f;
    }

    public final String h() {
        return this.f14509g;
    }

    public final boolean i() {
        return this.f14510h;
    }

    public final int j() {
        return this.f14512j;
    }

    public final String k() {
        return this.f14513k;
    }

    public final String l() {
        return this.f14514l;
    }

    public final String m() {
        return this.f14515m;
    }

    public final String n() {
        return this.f14516n;
    }

    public final int o() {
        return this.f14517o;
    }

    public final long p() {
        return this.f14518p;
    }

    public final long q() {
        return this.f14519q;
    }

    public final long r() {
        return this.f14520r;
    }

    public final double s() {
        return this.f14521s;
    }

    public final int t() {
        return this.f14522t;
    }

    public final List<a> u() {
        return this.f14523u;
    }

    public final JSONObject v() {
        return this.f14524v;
    }

    public final d<?> w() {
        d<?> dVar = this.f14525w;
        if (dVar != null) {
            return dVar;
        }
        String str = this.f14491A;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f14525w == null) {
            if (c.b(str)) {
                this.f14525w = new e(this, (a) null);
            } else {
                this.f14525w = new i(this, (a) null);
            }
        }
        return this.f14525w;
    }

    public final Context x() {
        return this.f14528z;
    }

    public final boolean y() {
        List<a> list;
        boolean z4;
        boolean z5;
        d<?> dVar = this.f14525w;
        if ((dVar == null || dVar.d()) && (list = this.f14523u) != null && !list.isEmpty()) {
            int size = this.f14523u.size();
            Iterator<a> it = this.f14523u.iterator();
            int i4 = 0;
            while (true) {
                boolean z6 = true;
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                n d5 = next.d();
                if (d5 == null || d5.d()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                d<?> f4 = next.f();
                if (f4 == null || f4.d()) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                d<?> c5 = next.c();
                if (c5 != null && !c5.d()) {
                    z6 = false;
                }
                if (z4 && z5 && z6) {
                    i4++;
                }
            }
            if (i4 == size) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00aa A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean z() {
        /*
            r10 = this;
            boolean r0 = r10.A()
            boolean r1 = r10.y()
            com.mbridge.msdk.newreward.function.c.c.d<?> r2 = r10.f14525w
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0014
            boolean r2 = r2.d()
            if (r2 == 0) goto L_0x0075
        L_0x0014:
            java.util.List<com.mbridge.msdk.newreward.function.c.a.a> r2 = r10.f14523u
            if (r2 == 0) goto L_0x0075
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x001f
            goto L_0x0075
        L_0x001f:
            java.util.List<com.mbridge.msdk.newreward.function.c.a.a> r2 = r10.f14523u
            int r2 = r2.size()
            java.util.List<com.mbridge.msdk.newreward.function.c.a.a> r5 = r10.f14523u
            java.util.Iterator r5 = r5.iterator()
            r6 = 0
        L_0x002c:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0071
            java.lang.Object r7 = r5.next()
            com.mbridge.msdk.newreward.function.c.a.a r7 = (com.mbridge.msdk.newreward.function.c.a.a) r7
            com.mbridge.msdk.newreward.function.c.c.n r8 = r7.d()
            if (r8 == 0) goto L_0x0047
            boolean r8 = r8.e()
            if (r8 == 0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r8 = 0
            goto L_0x0048
        L_0x0047:
            r8 = 1
        L_0x0048:
            com.mbridge.msdk.newreward.function.c.c.d r9 = r7.f()
            if (r9 == 0) goto L_0x0057
            boolean r9 = r9.e()
            if (r9 == 0) goto L_0x0055
            goto L_0x0057
        L_0x0055:
            r9 = 0
            goto L_0x0058
        L_0x0057:
            r9 = 1
        L_0x0058:
            com.mbridge.msdk.newreward.function.c.c.d r7 = r7.c()
            if (r7 == 0) goto L_0x0067
            boolean r7 = r7.e()
            if (r7 == 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r7 = 0
            goto L_0x0068
        L_0x0067:
            r7 = 1
        L_0x0068:
            if (r8 == 0) goto L_0x002c
            if (r9 == 0) goto L_0x002c
            if (r7 == 0) goto L_0x002c
            int r6 = r6 + 1
            goto L_0x002c
        L_0x0071:
            if (r6 != r2) goto L_0x0075
            r2 = 1
            goto L_0x0076
        L_0x0075:
            r2 = 0
        L_0x0076:
            java.util.List<com.mbridge.msdk.newreward.function.c.a.a> r5 = r10.f14523u
            if (r5 == 0) goto L_0x00a7
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x0081
            goto L_0x00a7
        L_0x0081:
            java.util.List<com.mbridge.msdk.newreward.function.c.a.a> r5 = r10.f14523u
            int r5 = r5.size()
            java.util.List<com.mbridge.msdk.newreward.function.c.a.a> r6 = r10.f14523u
            java.util.Iterator r6 = r6.iterator()
            r7 = 0
        L_0x008e:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x00a3
            java.lang.Object r8 = r6.next()
            com.mbridge.msdk.newreward.function.c.a.a r8 = (com.mbridge.msdk.newreward.function.c.a.a) r8
            boolean r8 = r8.l()
            if (r8 != 0) goto L_0x008e
            int r7 = r7 + 1
            goto L_0x008e
        L_0x00a3:
            if (r7 != r5) goto L_0x00a7
            r5 = 1
            goto L_0x00a8
        L_0x00a7:
            r5 = 0
        L_0x00a8:
            if (r0 == 0) goto L_0x00b1
            if (r1 == 0) goto L_0x00b1
            if (r2 == 0) goto L_0x00b1
            if (r5 == 0) goto L_0x00b1
            return r3
        L_0x00b1:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.c.a.b.z():boolean");
    }

    public final void a(int i4) {
        this.f14501K = i4;
    }

    public final void b(int i4) {
        this.f14502L = i4;
    }

    public final void c(String str) {
        this.f14509g = str;
    }

    public final void d(String str) {
        this.f14513k = str;
    }

    public final void e(String str) {
        this.f14514l = str;
    }

    public final void f(String str) {
        this.f14515m = str;
    }

    public final void g(String str) {
        this.f14516n = str;
    }

    public final void h(String str) {
        this.f14491A = str;
    }

    public final void i(int i4) {
        this.f14492B = i4;
    }

    public final void j(int i4) {
        this.f14495E = i4;
    }

    public final void k(int i4) {
        this.f14496F = i4;
    }

    public final void a(String str) {
        this.f14507e = str;
    }

    public final void b(String str) {
        this.f14508f = str;
    }

    public final void c(int i4) {
        this.f14512j = i4;
    }

    public final void d(int i4) {
        this.f14517o = i4;
    }

    public final void e(int i4) {
        this.f14522t = i4;
    }

    public final void f(int i4) {
        this.f14526x = i4;
    }

    public final void g(int i4) {
        this.f14527y = i4;
    }

    public final void h(int i4) {
        this.f14493C = i4;
    }

    public final void i(String str) {
        this.f14499I = str;
    }

    public final void a(boolean z4) {
        this.f14510h = z4;
    }

    public final void b(long j4) {
        this.f14518p = j4;
    }

    public final void c(long j4) {
        this.f14519q = j4;
    }

    public final void d(long j4) {
        this.f14520r = j4;
    }

    public final void e(long j4) {
        this.f14497G = j4;
    }

    public final void a(long j4) {
        this.f14511i = j4;
    }

    public final void b(List<CampaignEx> list) {
        this.f14494D = list;
    }

    public final void a(double d5) {
        this.f14521s = d5;
    }

    public final void b(boolean z4) {
        this.f14500J = z4;
    }

    public final void a(List<a> list) {
        this.f14523u = list;
    }

    public final void a(JSONObject jSONObject) {
        this.f14524v = jSONObject;
    }
}
