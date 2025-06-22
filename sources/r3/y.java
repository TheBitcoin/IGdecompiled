package r3;

import R2.m;
import R2.s;
import V2.d;
import V2.g;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.m;
import o3.C0991n;
import o3.Z;
import s3.p;
import t3.F;

public class y extends s3.b implements s, C1035e, p {

    /* renamed from: e  reason: collision with root package name */
    private final int f4309e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final int f4310f;

    /* renamed from: g  reason: collision with root package name */
    private final q3.a f4311g;

    /* renamed from: h  reason: collision with root package name */
    private Object[] f4312h;

    /* renamed from: i  reason: collision with root package name */
    private long f4313i;

    /* renamed from: j  reason: collision with root package name */
    private long f4314j;

    /* renamed from: k  reason: collision with root package name */
    private int f4315k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public int f4316l;

    private static final class a implements Z {

        /* renamed from: a  reason: collision with root package name */
        public final y f4317a;

        /* renamed from: b  reason: collision with root package name */
        public long f4318b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f4319c;

        /* renamed from: d  reason: collision with root package name */
        public final d f4320d;

        public a(y yVar, long j4, Object obj, d dVar) {
            this.f4317a = yVar;
            this.f4318b = j4;
            this.f4319c = obj;
            this.f4320d = dVar;
        }

        public void dispose() {
            this.f4317a.y(this);
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f4321a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                q3.a[] r0 = q3.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                q3.a r1 = q3.a.SUSPEND     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                q3.a r1 = q3.a.DROP_LATEST     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                q3.a r1 = q3.a.DROP_OLDEST     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f4321a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: r3.y.b.<clinit>():void");
        }
    }

    static final class c extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f4322a;

        /* renamed from: b  reason: collision with root package name */
        Object f4323b;

        /* renamed from: c  reason: collision with root package name */
        Object f4324c;

        /* renamed from: d  reason: collision with root package name */
        Object f4325d;

        /* renamed from: e  reason: collision with root package name */
        /* synthetic */ Object f4326e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ y f4327f;

        /* renamed from: g  reason: collision with root package name */
        int f4328g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(y yVar, d dVar) {
            super(dVar);
            this.f4327f = yVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f4326e = obj;
            this.f4328g |= Integer.MIN_VALUE;
            return y.A(this.f4327f, (C1036f) null, this);
        }
    }

    public y(int i4, int i5, q3.a aVar) {
        this.f4309e = i4;
        this.f4310f = i5;
        this.f4311g = aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: r3.A} */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ab, code lost:
        if (r8 == null) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ad, code lost:
        o3.C1009w0.g(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b0, code lost:
        r0.f4322a = r5;
        r0.f4323b = r2;
        r0.f4324c = r9;
        r0.f4325d = r8;
        r0.f4328g = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00be, code lost:
        if (r2.emit(r10, r0) != r1) goto L_0x003e;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009a A[Catch:{ all -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ab A[EDGE_INSN: B:48:0x00ab->B:38:0x00ab ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object A(r3.y r8, r3.C1036f r9, V2.d r10) {
        /*
            boolean r0 = r10 instanceof r3.y.c
            if (r0 == 0) goto L_0x0013
            r0 = r10
            r3.y$c r0 = (r3.y.c) r0
            int r1 = r0.f4328g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f4328g = r1
            goto L_0x0018
        L_0x0013:
            r3.y$c r0 = new r3.y$c
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f4326e
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f4328g
            r3 = 3
            r4 = 2
            if (r2 == 0) goto L_0x0077
            r8 = 1
            if (r2 == r8) goto L_0x0061
            if (r2 == r4) goto L_0x004d
            if (r2 != r3) goto L_0x0045
            java.lang.Object r8 = r0.f4325d
            o3.s0 r8 = (o3.C1001s0) r8
            java.lang.Object r9 = r0.f4324c
            r3.A r9 = (r3.A) r9
            java.lang.Object r2 = r0.f4323b
            r3.f r2 = (r3.C1036f) r2
            java.lang.Object r5 = r0.f4322a
            r3.y r5 = (r3.y) r5
            R2.n.b(r10)     // Catch:{ all -> 0x0042 }
        L_0x003e:
            r10 = r2
            r2 = r8
            r8 = r5
            goto L_0x008f
        L_0x0042:
            r8 = move-exception
            goto L_0x00c4
        L_0x0045:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x004d:
            java.lang.Object r8 = r0.f4325d
            o3.s0 r8 = (o3.C1001s0) r8
            java.lang.Object r9 = r0.f4324c
            r3.A r9 = (r3.A) r9
            java.lang.Object r2 = r0.f4323b
            r3.f r2 = (r3.C1036f) r2
            java.lang.Object r5 = r0.f4322a
            r3.y r5 = (r3.y) r5
            R2.n.b(r10)     // Catch:{ all -> 0x0042 }
            goto L_0x0092
        L_0x0061:
            java.lang.Object r8 = r0.f4324c
            r9 = r8
            r3.A r9 = (r3.A) r9
            java.lang.Object r8 = r0.f4323b
            r3.f r8 = (r3.C1036f) r8
            java.lang.Object r2 = r0.f4322a
            r3.y r2 = (r3.y) r2
            R2.n.b(r10)     // Catch:{ all -> 0x0074 }
            r10 = r8
            r8 = r2
            goto L_0x0083
        L_0x0074:
            r8 = move-exception
            r5 = r2
            goto L_0x00c4
        L_0x0077:
            R2.n.b(r10)
            s3.d r10 = r8.h()
            r3.A r10 = (r3.A) r10
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0083:
            V2.g r2 = r0.getContext()     // Catch:{ all -> 0x00c1 }
            o3.s0$b r5 = o3.C1001s0.f3726k0     // Catch:{ all -> 0x00c1 }
            V2.g$b r2 = r2.get(r5)     // Catch:{ all -> 0x00c1 }
            o3.s0 r2 = (o3.C1001s0) r2     // Catch:{ all -> 0x00c1 }
        L_0x008f:
            r5 = r8
            r8 = r2
            r2 = r10
        L_0x0092:
            java.lang.Object r10 = r5.U(r9)     // Catch:{ all -> 0x0042 }
            t3.F r6 = r3.z.f4329a     // Catch:{ all -> 0x0042 }
            if (r10 != r6) goto L_0x00ab
            r0.f4322a = r5     // Catch:{ all -> 0x0042 }
            r0.f4323b = r2     // Catch:{ all -> 0x0042 }
            r0.f4324c = r9     // Catch:{ all -> 0x0042 }
            r0.f4325d = r8     // Catch:{ all -> 0x0042 }
            r0.f4328g = r4     // Catch:{ all -> 0x0042 }
            java.lang.Object r10 = r5.x(r9, r0)     // Catch:{ all -> 0x0042 }
            if (r10 != r1) goto L_0x0092
            goto L_0x00c0
        L_0x00ab:
            if (r8 == 0) goto L_0x00b0
            o3.C1009w0.g(r8)     // Catch:{ all -> 0x0042 }
        L_0x00b0:
            r0.f4322a = r5     // Catch:{ all -> 0x0042 }
            r0.f4323b = r2     // Catch:{ all -> 0x0042 }
            r0.f4324c = r9     // Catch:{ all -> 0x0042 }
            r0.f4325d = r8     // Catch:{ all -> 0x0042 }
            r0.f4328g = r3     // Catch:{ all -> 0x0042 }
            java.lang.Object r10 = r2.emit(r10, r0)     // Catch:{ all -> 0x0042 }
            if (r10 != r1) goto L_0x003e
        L_0x00c0:
            return r1
        L_0x00c1:
            r10 = move-exception
            r5 = r8
            r8 = r10
        L_0x00c4:
            r5.k(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.y.A(r3.y, r3.f, V2.d):java.lang.Object");
    }

    private final void B(long j4) {
        s3.d[] e5;
        if (!(this.f4337b == 0 || (e5 = this.f4336a) == null)) {
            for (s3.d dVar : e5) {
                if (dVar != null) {
                    A a5 = (A) dVar;
                    long j5 = a5.f4138a;
                    if (j5 >= 0 && j5 < j4) {
                        a5.f4138a = j4;
                    }
                }
            }
        }
        this.f4314j = j4;
    }

    private final void E() {
        Object[] objArr = this.f4312h;
        m.b(objArr);
        z.f(objArr, K(), (Object) null);
        this.f4315k--;
        long K4 = K() + 1;
        if (this.f4313i < K4) {
            this.f4313i = K4;
        }
        if (this.f4314j < K4) {
            B(K4);
        }
    }

    static /* synthetic */ Object F(y yVar, Object obj, d dVar) {
        if (yVar.f(obj)) {
            return s.f8222a;
        }
        Object G4 = yVar.G(obj, dVar);
        if (G4 == W2.b.c()) {
            return G4;
        }
        return s.f8222a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        if (r0 == null) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005b, code lost:
        o3.C0995p.a(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005e, code lost:
        r0 = r9.length;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        if (r2 >= r0) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0062, code lost:
        r3 = r9[r2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0064, code lost:
        if (r3 == null) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0066, code lost:
        r4 = R2.m.f8216a;
        r3.resumeWith(R2.m.a(R2.s.f8222a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0071, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0073, code lost:
        r9 = r5.v();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007b, code lost:
        if (r9 != W2.b.c()) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007d, code lost:
        kotlin.coroutines.jvm.internal.h.c(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r9 != W2.b.c()) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0086, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0089, code lost:
        return R2.s.f8222a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object G(java.lang.Object r9, V2.d r10) {
        /*
            r8 = this;
            o3.n r5 = new o3.n
            V2.d r0 = W2.b.b(r10)
            r6 = 1
            r5.<init>(r0, r6)
            r5.z()
            V2.d[] r7 = s3.c.f4340a
            monitor-enter(r8)
            boolean r0 = r8.R(r9)     // Catch:{ all -> 0x008a }
            if (r0 == 0) goto L_0x002c
            R2.m$a r9 = R2.m.f8216a     // Catch:{ all -> 0x0028 }
            R2.s r9 = R2.s.f8222a     // Catch:{ all -> 0x0028 }
            java.lang.Object r9 = R2.m.a(r9)     // Catch:{ all -> 0x0028 }
            r5.resumeWith(r9)     // Catch:{ all -> 0x0028 }
            V2.d[] r9 = r8.I(r7)     // Catch:{ all -> 0x0028 }
            r0 = 0
            r1 = r8
            goto L_0x0058
        L_0x0028:
            r0 = move-exception
            r9 = r0
            r1 = r8
            goto L_0x008d
        L_0x002c:
            r3.y$a r0 = new r3.y$a     // Catch:{ all -> 0x008a }
            long r1 = r8.K()     // Catch:{ all -> 0x008a }
            int r3 = r8.P()     // Catch:{ all -> 0x008a }
            long r3 = (long) r3
            long r1 = r1 + r3
            r4 = r9
            r2 = r1
            r1 = r8
            r0.<init>(r1, r2, r4, r5)     // Catch:{ all -> 0x0054 }
            r8.H(r0)     // Catch:{ all -> 0x0054 }
            int r9 = r8.f4316l     // Catch:{ all -> 0x0054 }
            int r9 = r9 + r6
            r8.f4316l = r9     // Catch:{ all -> 0x0054 }
            int r9 = r8.f4310f     // Catch:{ all -> 0x0054 }
            if (r9 != 0) goto L_0x0057
            V2.d[] r7 = r8.I(r7)     // Catch:{ all -> 0x0054 }
            goto L_0x0057
        L_0x0054:
            r0 = move-exception
        L_0x0055:
            r9 = r0
            goto L_0x008d
        L_0x0057:
            r9 = r7
        L_0x0058:
            monitor-exit(r8)
            if (r0 == 0) goto L_0x005e
            o3.C0995p.a(r5, r0)
        L_0x005e:
            int r0 = r9.length
            r2 = 0
        L_0x0060:
            if (r2 >= r0) goto L_0x0073
            r3 = r9[r2]
            if (r3 == 0) goto L_0x0071
            R2.m$a r4 = R2.m.f8216a
            R2.s r4 = R2.s.f8222a
            java.lang.Object r4 = R2.m.a(r4)
            r3.resumeWith(r4)
        L_0x0071:
            int r2 = r2 + r6
            goto L_0x0060
        L_0x0073:
            java.lang.Object r9 = r5.v()
            java.lang.Object r0 = W2.b.c()
            if (r9 != r0) goto L_0x0080
            kotlin.coroutines.jvm.internal.h.c(r10)
        L_0x0080:
            java.lang.Object r10 = W2.b.c()
            if (r9 != r10) goto L_0x0087
            return r9
        L_0x0087:
            R2.s r9 = R2.s.f8222a
            return r9
        L_0x008a:
            r0 = move-exception
            r1 = r8
            goto L_0x0055
        L_0x008d:
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.y.G(java.lang.Object, V2.d):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void H(Object obj) {
        int P4 = P();
        Object[] objArr = this.f4312h;
        if (objArr == null) {
            objArr = Q((Object[]) null, 0, 2);
        } else if (P4 >= objArr.length) {
            objArr = Q(objArr, P4, objArr.length * 2);
        }
        z.f(objArr, K() + ((long) P4), obj);
    }

    /* JADX WARNING: type inference failed for: r12v6, types: [java.lang.Object[], java.lang.Object] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0045, code lost:
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
        r4 = (r3.A) r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V2.d[] I(V2.d[] r12) {
        /*
            r11 = this;
            int r0 = r12.length
            int r1 = r11.f4337b
            if (r1 == 0) goto L_0x0048
            s3.d[] r1 = r11.f4336a
            if (r1 == 0) goto L_0x0048
            int r2 = r1.length
            r3 = 0
        L_0x000f:
            if (r3 >= r2) goto L_0x0048
            r4 = r1[r3]
            if (r4 == 0) goto L_0x0045
            r3.A r4 = (r3.A) r4
            V2.d r5 = r4.f4139b
            if (r5 != 0) goto L_0x001c
            goto L_0x0045
        L_0x001c:
            long r6 = r11.T(r4)
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 < 0) goto L_0x0045
            int r6 = r12.length
            if (r0 < r6) goto L_0x003a
            int r6 = r12.length
            r7 = 2
            int r6 = r6 * 2
            int r6 = java.lang.Math.max(r7, r6)
            java.lang.Object[] r12 = java.util.Arrays.copyOf(r12, r6)
            java.lang.String r6 = "copyOf(this, newSize)"
            kotlin.jvm.internal.m.d(r12, r6)
        L_0x003a:
            r6 = r12
            V2.d[] r6 = (V2.d[]) r6
            int r7 = r0 + 1
            r6[r0] = r5
            r0 = 0
            r4.f4139b = r0
            r0 = r7
        L_0x0045:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x0048:
            V2.d[] r12 = (V2.d[]) r12
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.y.I(V2.d[]):V2.d[]");
    }

    private final long J() {
        return K() + ((long) this.f4315k);
    }

    /* access modifiers changed from: private */
    public final long K() {
        return Math.min(this.f4314j, this.f4313i);
    }

    private final Object M(long j4) {
        Object[] objArr = this.f4312h;
        m.b(objArr);
        Object b5 = z.e(objArr, j4);
        if (b5 instanceof a) {
            return ((a) b5).f4319c;
        }
        return b5;
    }

    private final long N() {
        return K() + ((long) this.f4315k) + ((long) this.f4316l);
    }

    private final int O() {
        return (int) ((K() + ((long) this.f4315k)) - this.f4313i);
    }

    /* access modifiers changed from: private */
    public final int P() {
        return this.f4315k + this.f4316l;
    }

    private final Object[] Q(Object[] objArr, int i4, int i5) {
        if (i5 > 0) {
            Object[] objArr2 = new Object[i5];
            this.f4312h = objArr2;
            if (objArr != null) {
                long K4 = K();
                for (int i6 = 0; i6 < i4; i6++) {
                    long j4 = ((long) i6) + K4;
                    z.f(objArr2, j4, z.e(objArr, j4));
                }
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow");
    }

    /* access modifiers changed from: private */
    public final boolean R(Object obj) {
        if (l() == 0) {
            return S(obj);
        }
        if (this.f4315k >= this.f4310f && this.f4314j <= this.f4313i) {
            int i4 = b.f4321a[this.f4311g.ordinal()];
            if (i4 == 1) {
                return false;
            }
            if (i4 == 2) {
                return true;
            }
        }
        H(obj);
        int i5 = this.f4315k + 1;
        this.f4315k = i5;
        if (i5 > this.f4310f) {
            E();
        }
        if (O() > this.f4309e) {
            V(this.f4313i + 1, this.f4314j, J(), N());
        }
        return true;
    }

    private final boolean S(Object obj) {
        if (this.f4309e == 0) {
            return true;
        }
        H(obj);
        int i4 = this.f4315k + 1;
        this.f4315k = i4;
        if (i4 > this.f4309e) {
            E();
        }
        this.f4314j = K() + ((long) this.f4315k);
        return true;
    }

    /* access modifiers changed from: private */
    public final long T(A a5) {
        long j4 = a5.f4138a;
        if (j4 >= J() && (this.f4310f > 0 || j4 > K() || this.f4316l == 0)) {
            return -1;
        }
        return j4;
    }

    private final Object U(A a5) {
        Object obj;
        d[] dVarArr = s3.c.f4340a;
        synchronized (this) {
            try {
                long T4 = T(a5);
                if (T4 < 0) {
                    obj = z.f4329a;
                } else {
                    long j4 = a5.f4138a;
                    Object M4 = M(T4);
                    a5.f4138a = T4 + 1;
                    Object obj2 = M4;
                    dVarArr = W(j4);
                    obj = obj2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (d dVar : dVarArr) {
            if (dVar != null) {
                m.a aVar = R2.m.f8216a;
                dVar.resumeWith(R2.m.a(s.f8222a));
            }
        }
        return obj;
    }

    private final void V(long j4, long j5, long j6, long j7) {
        long min = Math.min(j5, j4);
        for (long K4 = K(); K4 < min; K4++) {
            Object[] objArr = this.f4312h;
            kotlin.jvm.internal.m.b(objArr);
            z.f(objArr, K4, (Object) null);
        }
        this.f4313i = j4;
        this.f4314j = j5;
        this.f4315k = (int) (j6 - min);
        this.f4316l = (int) (j7 - j6);
    }

    private final Object x(A a5, d dVar) {
        C0991n nVar = new C0991n(W2.b.b(dVar), 1);
        nVar.z();
        synchronized (this) {
            try {
                if (T(a5) < 0) {
                    a5.f4139b = nVar;
                } else {
                    m.a aVar = R2.m.f8216a;
                    nVar.resumeWith(R2.m.a(s.f8222a));
                }
                s sVar = s.f8222a;
            } catch (Throwable th) {
                throw th;
            }
        }
        Object v4 = nVar.v();
        if (v4 == W2.b.c()) {
            h.c(dVar);
        }
        if (v4 == W2.b.c()) {
            return v4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final void y(a aVar) {
        synchronized (this) {
            if (aVar.f4318b >= K()) {
                Object[] objArr = this.f4312h;
                kotlin.jvm.internal.m.b(objArr);
                if (z.e(objArr, aVar.f4318b) == aVar) {
                    z.f(objArr, aVar.f4318b, z.f4329a);
                    z();
                    s sVar = s.f8222a;
                }
            }
        }
    }

    private final void z() {
        if (this.f4310f != 0 || this.f4316l > 1) {
            Object[] objArr = this.f4312h;
            kotlin.jvm.internal.m.b(objArr);
            while (this.f4316l > 0 && z.e(objArr, (K() + ((long) P())) - 1) == z.f4329a) {
                this.f4316l--;
                z.f(objArr, K() + ((long) P()), (Object) null);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public A i() {
        return new A();
    }

    /* access modifiers changed from: protected */
    /* renamed from: D */
    public A[] j(int i4) {
        return new A[i4];
    }

    /* access modifiers changed from: protected */
    public final Object L() {
        Object[] objArr = this.f4312h;
        kotlin.jvm.internal.m.b(objArr);
        return z.e(objArr, (this.f4313i + ((long) O())) - 1);
    }

    public final d[] W(long j4) {
        int i4;
        long j5;
        long j6;
        long j7;
        long j8;
        boolean z4;
        s3.d[] e5;
        if (j4 > this.f4314j) {
            return s3.c.f4340a;
        }
        long K4 = K();
        long j9 = ((long) this.f4315k) + K4;
        if (this.f4310f == 0 && this.f4316l > 0) {
            j9++;
        }
        if (!(this.f4337b == 0 || (e5 = this.f4336a) == null)) {
            for (s3.d dVar : e5) {
                if (dVar != null) {
                    long j10 = ((A) dVar).f4138a;
                    if (j10 >= 0 && j10 < j9) {
                        j9 = j10;
                    }
                }
            }
        }
        if (j9 <= this.f4314j) {
            return s3.c.f4340a;
        }
        long J4 = J();
        if (l() > 0) {
            i4 = Math.min(this.f4316l, this.f4310f - ((int) (J4 - j9)));
        } else {
            i4 = this.f4316l;
        }
        d[] dVarArr = s3.c.f4340a;
        long j11 = ((long) this.f4316l) + J4;
        if (i4 > 0) {
            dVarArr = new d[i4];
            Object[] objArr = this.f4312h;
            kotlin.jvm.internal.m.b(objArr);
            j7 = 1;
            long j12 = J4;
            int i5 = 0;
            while (true) {
                if (J4 >= j11) {
                    j5 = K4;
                    j6 = j9;
                    J4 = j12;
                    break;
                }
                Object b5 = z.e(objArr, J4);
                j5 = K4;
                F f4 = z.f4329a;
                if (b5 != f4) {
                    kotlin.jvm.internal.m.c(b5, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    a aVar = (a) b5;
                    int i6 = i5 + 1;
                    j6 = j9;
                    dVarArr[i5] = aVar.f4320d;
                    z.f(objArr, J4, f4);
                    z.f(objArr, j12, aVar.f4319c);
                    long j13 = j12 + 1;
                    if (i6 >= i4) {
                        J4 = j13;
                        break;
                    }
                    i5 = i6;
                    j12 = j13;
                } else {
                    j6 = j9;
                }
                J4++;
                K4 = j5;
                j9 = j6;
            }
        } else {
            j5 = K4;
            j6 = j9;
            j7 = 1;
        }
        d[] dVarArr2 = dVarArr;
        int i7 = (int) (J4 - j5);
        if (l() == 0) {
            j8 = J4;
        } else {
            j8 = j6;
        }
        long max = Math.max(this.f4313i, J4 - ((long) Math.min(this.f4309e, i7)));
        if (this.f4310f == 0 && max < j11) {
            Object[] objArr2 = this.f4312h;
            kotlin.jvm.internal.m.b(objArr2);
            if (kotlin.jvm.internal.m.a(z.e(objArr2, max), z.f4329a)) {
                J4 += j7;
                max += j7;
            }
        }
        V(max, j8, J4, j11);
        z();
        if (dVarArr2.length == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            return I(dVarArr2);
        }
        return dVarArr2;
    }

    public final long X() {
        long j4 = this.f4313i;
        if (j4 < this.f4314j) {
            this.f4314j = j4;
        }
        return j4;
    }

    public C1035e b(g gVar, int i4, q3.a aVar) {
        return z.d(this, gVar, i4, aVar);
    }

    public Object collect(C1036f fVar, d dVar) {
        return A(this, fVar, dVar);
    }

    public void d() {
        synchronized (this) {
            try {
                try {
                    V(J(), this.f4314j, J(), N());
                    s sVar = s.f8222a;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public Object emit(Object obj, d dVar) {
        return F(this, obj, dVar);
    }

    public boolean f(Object obj) {
        int i4;
        boolean z4;
        d[] dVarArr = s3.c.f4340a;
        synchronized (this) {
            if (R(obj)) {
                dVarArr = I(dVarArr);
                z4 = true;
            } else {
                z4 = false;
            }
        }
        for (d dVar : dVarArr) {
            if (dVar != null) {
                m.a aVar = R2.m.f8216a;
                dVar.resumeWith(R2.m.a(s.f8222a));
            }
        }
        return z4;
    }
}
