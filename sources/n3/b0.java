package N3;

import N3.Q;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.MBridgeConstans;
import java.io.IOException;
import java.util.Map;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class b0 extends C2520k {

    /* renamed from: i  reason: collision with root package name */
    private static final a f23675i = new a((C2103g) null);

    /* renamed from: j  reason: collision with root package name */
    private static final Q f23676j = Q.a.e(Q.f23639b, "/", false, 1, (Object) null);

    /* renamed from: e  reason: collision with root package name */
    private final Q f23677e;

    /* renamed from: f  reason: collision with root package name */
    private final C2520k f23678f;

    /* renamed from: g  reason: collision with root package name */
    private final Map f23679g;

    /* renamed from: h  reason: collision with root package name */
    private final String f23680h;

    private static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public b0(Q q4, C2520k kVar, Map map, String str) {
        m.e(q4, "zipPath");
        m.e(kVar, "fileSystem");
        m.e(map, "entries");
        this.f23677e = q4;
        this.f23678f = kVar;
        this.f23679g = map;
        this.f23680h = str;
    }

    private final Q m(Q q4) {
        return f23676j.k(q4, true);
    }

    public void a(Q q4, Q q5) {
        m.e(q4, "source");
        m.e(q5, TypedValues.AttributesType.S_TARGET);
        throw new IOException("zip file systems are read-only");
    }

    public void d(Q q4, boolean z4) {
        m.e(q4, "dir");
        throw new IOException("zip file systems are read-only");
    }

    public void f(Q q4, boolean z4) {
        m.e(q4, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        throw new IOException("zip file systems are read-only");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public N3.C2519j h(N3.Q r15) {
        /*
            r14 = this;
            java.lang.String r0 = "path"
            kotlin.jvm.internal.m.e(r15, r0)
            N3.Q r15 = r14.m(r15)
            java.util.Map r0 = r14.f23679g
            java.lang.Object r15 = r0.get(r15)
            O3.i r15 = (O3.C2543i) r15
            r1 = 0
            if (r15 != 0) goto L_0x0015
            return r1
        L_0x0015:
            N3.j r2 = new N3.j
            boolean r0 = r15.h()
            r3 = r0 ^ 1
            boolean r4 = r15.h()
            boolean r0 = r15.h()
            if (r0 == 0) goto L_0x0029
            r6 = r1
            goto L_0x0032
        L_0x0029:
            long r5 = r15.g()
            java.lang.Long r0 = java.lang.Long.valueOf(r5)
            r6 = r0
        L_0x0032:
            java.lang.Long r8 = r15.e()
            r11 = 128(0x80, float:1.794E-43)
            r12 = 0
            r5 = 0
            r7 = 0
            r9 = 0
            r10 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            long r3 = r15.f()
            r5 = -1
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x004b
            return r2
        L_0x004b:
            N3.k r0 = r14.f23678f
            N3.Q r3 = r14.f23677e
            N3.i r3 = r0.i(r3)
            long r4 = r15.f()     // Catch:{ all -> 0x0068 }
            N3.Z r15 = r3.A(r4)     // Catch:{ all -> 0x0068 }
            N3.g r15 = N3.L.d(r15)     // Catch:{ all -> 0x0068 }
            if (r3 == 0) goto L_0x0077
            r3.close()     // Catch:{ all -> 0x0065 }
            goto L_0x0077
        L_0x0065:
            r0 = move-exception
            r1 = r0
            goto L_0x0077
        L_0x0068:
            r0 = move-exception
            r15 = r0
            if (r3 == 0) goto L_0x0074
            r3.close()     // Catch:{ all -> 0x0070 }
            goto L_0x0074
        L_0x0070:
            r0 = move-exception
            R2.a.a(r15, r0)
        L_0x0074:
            r13 = r1
            r1 = r15
            r15 = r13
        L_0x0077:
            if (r1 != 0) goto L_0x0081
            kotlin.jvm.internal.m.b(r15)
            N3.j r15 = O3.C2544j.h(r15, r2)
            return r15
        L_0x0081:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: N3.b0.h(N3.Q):N3.j");
    }

    public C2518i i(Q q4) {
        m.e(q4, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    public C2518i k(Q q4, boolean z4, boolean z5) {
        m.e(q4, "file");
        throw new IOException("zip entries are not writable");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public N3.Z l(N3.Q r8) {
        /*
            r7 = this;
            java.lang.String r0 = "file"
            kotlin.jvm.internal.m.e(r8, r0)
            N3.Q r0 = r7.m(r8)
            java.util.Map r1 = r7.f23679g
            java.lang.Object r0 = r1.get(r0)
            O3.i r0 = (O3.C2543i) r0
            if (r0 == 0) goto L_0x0077
            N3.k r8 = r7.f23678f
            N3.Q r1 = r7.f23677e
            N3.i r8 = r8.i(r1)
            r1 = 0
            long r2 = r0.f()     // Catch:{ all -> 0x0030 }
            N3.Z r2 = r8.A(r2)     // Catch:{ all -> 0x0030 }
            N3.g r2 = N3.L.d(r2)     // Catch:{ all -> 0x0030 }
            if (r8 == 0) goto L_0x003e
            r8.close()     // Catch:{ all -> 0x002e }
            goto L_0x003e
        L_0x002e:
            r1 = move-exception
            goto L_0x003e
        L_0x0030:
            r2 = move-exception
            if (r8 == 0) goto L_0x003b
            r8.close()     // Catch:{ all -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r8 = move-exception
            R2.a.a(r2, r8)
        L_0x003b:
            r6 = r2
            r2 = r1
            r1 = r6
        L_0x003e:
            if (r1 != 0) goto L_0x0076
            kotlin.jvm.internal.m.b(r2)
            O3.C2544j.k(r2)
            int r8 = r0.d()
            r1 = 1
            if (r8 != 0) goto L_0x0057
            O3.g r8 = new O3.g
            long r3 = r0.g()
            r8.<init>(r2, r3, r1)
            goto L_0x0075
        L_0x0057:
            N3.p r8 = new N3.p
            O3.g r3 = new O3.g
            long r4 = r0.c()
            r3.<init>(r2, r4, r1)
            java.util.zip.Inflater r2 = new java.util.zip.Inflater
            r2.<init>(r1)
            r8.<init>((N3.Z) r3, (java.util.zip.Inflater) r2)
            O3.g r1 = new O3.g
            long r2 = r0.g()
            r0 = 0
            r1.<init>(r8, r2, r0)
            r8 = r1
        L_0x0075:
            return r8
        L_0x0076:
            throw r1
        L_0x0077:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "no such file: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: N3.b0.l(N3.Q):N3.Z");
    }
}
