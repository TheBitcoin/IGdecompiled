package i2;

import V2.d;
import V2.g;
import android.content.Context;
import j2.C2092a;
import kotlin.jvm.internal.m;
import l2.C2125e;
import l2.k;
import o3.C1001s0;
import o3.K;
import o3.L;
import o3.Y;

/* renamed from: i2.a  reason: case insensitive filesystem */
public final class C2083a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f20901a;

    public C2083a(Context context) {
        m.e(context, "context");
        this.f20901a = context;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(i2.C2083a r7, l2.C2124d r8, j2.C2092a r9, V2.d r10) {
        /*
            java.lang.String r0 = "errorMsg"
            java.lang.String r1 = "success"
            r7.getClass()
            boolean r2 = r10 instanceof i2.C2085c
            if (r2 == 0) goto L_0x001a
            r2 = r10
            i2.c r2 = (i2.C2085c) r2
            int r3 = r2.f20909d
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x001a
            int r3 = r3 - r4
            r2.f20909d = r3
            goto L_0x001f
        L_0x001a:
            i2.c r2 = new i2.c
            r2.<init>(r7, r10)
        L_0x001f:
            java.lang.Object r10 = r2.f20907b
            java.lang.Object r3 = W2.b.c()
            int r4 = r2.f20909d
            r5 = 0
            switch(r4) {
                case 0: goto L_0x0043;
                case 1: goto L_0x0038;
                case 2: goto L_0x0038;
                case 3: goto L_0x0038;
                case 4: goto L_0x0038;
                case 5: goto L_0x0038;
                case 6: goto L_0x0033;
                default: goto L_0x002b;
            }
        L_0x002b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0033:
            R2.n.b(r10)
            goto L_0x011c
        L_0x0038:
            j2.a r7 = r2.f20906a
            r9 = r7
            R2.n.b(r10)     // Catch:{ JSONException -> 0x0040 }
            goto L_0x011c
        L_0x0040:
            r7 = move-exception
            goto L_0x0104
        L_0x0043:
            R2.n.b(r10)
            int r10 = r8.b()     // Catch:{ JSONException -> 0x0040 }
            r4 = 409(0x199, float:5.73E-43)
            r6 = 1
            if (r10 != r4) goto L_0x0076
            l2.e r8 = new l2.e     // Catch:{ JSONException -> 0x0040 }
            android.content.Context r10 = r7.f20901a     // Catch:{ JSONException -> 0x0040 }
            r8.<init>(r10)     // Catch:{ JSONException -> 0x0040 }
            l2.k r10 = l2.k.f21023a     // Catch:{ JSONException -> 0x0040 }
            android.content.Context r7 = r7.f20901a     // Catch:{ JSONException -> 0x0040 }
            long r0 = r10.d(r7)     // Catch:{ JSONException -> 0x0040 }
            r8.b(r0)     // Catch:{ JSONException -> 0x0040 }
            o3.E0 r7 = o3.Y.c()     // Catch:{ JSONException -> 0x0040 }
            i2.d r8 = new i2.d     // Catch:{ JSONException -> 0x0040 }
            r8.<init>(r9, r5)     // Catch:{ JSONException -> 0x0040 }
            r2.f20906a = r9     // Catch:{ JSONException -> 0x0040 }
            r2.f20909d = r6     // Catch:{ JSONException -> 0x0040 }
            java.lang.Object r7 = o3.C0977g.g(r7, r8, r2)     // Catch:{ JSONException -> 0x0040 }
            if (r7 != r3) goto L_0x011c
            goto L_0x011e
        L_0x0076:
            java.lang.String r10 = r8.a()     // Catch:{ JSONException -> 0x0040 }
            if (r10 == 0) goto L_0x00ef
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0040 }
            java.lang.String r8 = r8.a()     // Catch:{ JSONException -> 0x0040 }
            kotlin.jvm.internal.m.b(r8)     // Catch:{ JSONException -> 0x0040 }
            r10.<init>(r8)     // Catch:{ JSONException -> 0x0040 }
            boolean r8 = r10.has(r1)     // Catch:{ JSONException -> 0x0040 }
            if (r8 == 0) goto L_0x00bb
            int r8 = r10.getInt(r1)     // Catch:{ JSONException -> 0x0040 }
            if (r8 != r6) goto L_0x00bb
            l2.e r8 = new l2.e     // Catch:{ JSONException -> 0x0040 }
            android.content.Context r10 = r7.f20901a     // Catch:{ JSONException -> 0x0040 }
            r8.<init>(r10)     // Catch:{ JSONException -> 0x0040 }
            l2.k r10 = l2.k.f21023a     // Catch:{ JSONException -> 0x0040 }
            android.content.Context r7 = r7.f20901a     // Catch:{ JSONException -> 0x0040 }
            long r0 = r10.d(r7)     // Catch:{ JSONException -> 0x0040 }
            r8.b(r0)     // Catch:{ JSONException -> 0x0040 }
            o3.E0 r7 = o3.Y.c()     // Catch:{ JSONException -> 0x0040 }
            i2.e r8 = new i2.e     // Catch:{ JSONException -> 0x0040 }
            r8.<init>(r9, r5)     // Catch:{ JSONException -> 0x0040 }
            r2.f20906a = r9     // Catch:{ JSONException -> 0x0040 }
            r10 = 2
            r2.f20909d = r10     // Catch:{ JSONException -> 0x0040 }
            java.lang.Object r7 = o3.C0977g.g(r7, r8, r2)     // Catch:{ JSONException -> 0x0040 }
            if (r7 != r3) goto L_0x011c
            goto L_0x011e
        L_0x00bb:
            boolean r7 = r10.has(r0)     // Catch:{ JSONException -> 0x0040 }
            if (r7 == 0) goto L_0x00da
            java.lang.String r7 = r10.getString(r0)     // Catch:{ JSONException -> 0x0040 }
            o3.E0 r8 = o3.Y.c()     // Catch:{ JSONException -> 0x0040 }
            i2.f r10 = new i2.f     // Catch:{ JSONException -> 0x0040 }
            r10.<init>(r9, r7, r5)     // Catch:{ JSONException -> 0x0040 }
            r2.f20906a = r9     // Catch:{ JSONException -> 0x0040 }
            r7 = 3
            r2.f20909d = r7     // Catch:{ JSONException -> 0x0040 }
            java.lang.Object r7 = o3.C0977g.g(r8, r10, r2)     // Catch:{ JSONException -> 0x0040 }
            if (r7 != r3) goto L_0x011c
            goto L_0x011e
        L_0x00da:
            o3.E0 r7 = o3.Y.c()     // Catch:{ JSONException -> 0x0040 }
            i2.g r8 = new i2.g     // Catch:{ JSONException -> 0x0040 }
            r8.<init>(r9, r5)     // Catch:{ JSONException -> 0x0040 }
            r2.f20906a = r9     // Catch:{ JSONException -> 0x0040 }
            r10 = 4
            r2.f20909d = r10     // Catch:{ JSONException -> 0x0040 }
            java.lang.Object r7 = o3.C0977g.g(r7, r8, r2)     // Catch:{ JSONException -> 0x0040 }
            if (r7 != r3) goto L_0x011c
            goto L_0x011e
        L_0x00ef:
            o3.E0 r7 = o3.Y.c()     // Catch:{ JSONException -> 0x0040 }
            i2.h r8 = new i2.h     // Catch:{ JSONException -> 0x0040 }
            r8.<init>(r9, r5)     // Catch:{ JSONException -> 0x0040 }
            r2.f20906a = r9     // Catch:{ JSONException -> 0x0040 }
            r10 = 5
            r2.f20909d = r10     // Catch:{ JSONException -> 0x0040 }
            java.lang.Object r7 = o3.C0977g.g(r7, r8, r2)     // Catch:{ JSONException -> 0x0040 }
            if (r7 != r3) goto L_0x011c
            goto L_0x011e
        L_0x0104:
            r7.printStackTrace()
            o3.E0 r8 = o3.Y.c()
            i2.i r10 = new i2.i
            r10.<init>(r9, r7, r5)
            r2.f20906a = r5
            r7 = 6
            r2.f20909d = r7
            java.lang.Object r7 = o3.C0977g.g(r8, r10, r2)
            if (r7 != r3) goto L_0x011c
            goto L_0x011e
        L_0x011c:
            R2.s r3 = R2.s.f8222a
        L_0x011e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.C2083a.b(i2.a, l2.d, j2.a, V2.d):java.lang.Object");
    }

    public final void c(String str, C2092a aVar) {
        m.e(str, "token");
        m.e(aVar, "initListener");
        if (new C2125e(this.f20901a).a() == k.f21023a.d(this.f20901a)) {
            aVar.c();
        } else {
            C1001s0 unused = C0981i.d(K.a(Y.b()), (g) null, (L) null, new C2084b(this, str, aVar, (d) null), 3, (Object) null);
        }
    }
}
