package r3;

import R2.s;
import W2.b;
import kotlin.coroutines.jvm.internal.d;
import q3.u;

/* renamed from: r3.i  reason: case insensitive filesystem */
abstract /* synthetic */ class C1039i {

    /* renamed from: r3.i$a */
    static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f4202a;

        /* renamed from: b  reason: collision with root package name */
        Object f4203b;

        /* renamed from: c  reason: collision with root package name */
        Object f4204c;

        /* renamed from: d  reason: collision with root package name */
        boolean f4205d;

        /* renamed from: e  reason: collision with root package name */
        /* synthetic */ Object f4206e;

        /* renamed from: f  reason: collision with root package name */
        int f4207f;

        a(V2.d dVar) {
            super(dVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.f4206e = obj;
            this.f4207f |= Integer.MIN_VALUE;
            return C1039i.c((C1036f) null, (u) null, false, this);
        }
    }

    public static final Object b(C1036f fVar, u uVar, V2.d dVar) {
        Object c5 = c(fVar, uVar, true, dVar);
        if (c5 == b.c()) {
            return c5;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0091, code lost:
        if (r2.emit(r9, r0) == r1) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009e, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x009f, code lost:
        if (r8 != false) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a1, code lost:
        q3.k.a(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a4, code lost:
        throw r9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0072 A[Catch:{ all -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0073 A[Catch:{ all -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007f A[Catch:{ all -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(r3.C1036f r6, q3.u r7, boolean r8, V2.d r9) {
        /*
            boolean r0 = r9 instanceof r3.C1039i.a
            if (r0 == 0) goto L_0x0013
            r0 = r9
            r3.i$a r0 = (r3.C1039i.a) r0
            int r1 = r0.f4207f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f4207f = r1
            goto L_0x0018
        L_0x0013:
            r3.i$a r0 = new r3.i$a
            r0.<init>(r9)
        L_0x0018:
            java.lang.Object r9 = r0.f4206e
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f4207f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0058
            if (r2 == r4) goto L_0x0046
            if (r2 != r3) goto L_0x003e
            boolean r8 = r0.f4205d
            java.lang.Object r6 = r0.f4204c
            q3.f r6 = (q3.f) r6
            java.lang.Object r7 = r0.f4203b
            q3.u r7 = (q3.u) r7
            java.lang.Object r2 = r0.f4202a
            r3.f r2 = (r3.C1036f) r2
            R2.n.b(r9)     // Catch:{ all -> 0x003c }
        L_0x0039:
            r9 = r6
            r6 = r2
            goto L_0x0062
        L_0x003c:
            r6 = move-exception
            goto L_0x009d
        L_0x003e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0046:
            boolean r8 = r0.f4205d
            java.lang.Object r6 = r0.f4204c
            q3.f r6 = (q3.f) r6
            java.lang.Object r7 = r0.f4203b
            q3.u r7 = (q3.u) r7
            java.lang.Object r2 = r0.f4202a
            r3.f r2 = (r3.C1036f) r2
            R2.n.b(r9)     // Catch:{ all -> 0x003c }
            goto L_0x0077
        L_0x0058:
            R2.n.b(r9)
            r3.C1037g.o(r6)
            q3.f r9 = r7.iterator()     // Catch:{ all -> 0x003c }
        L_0x0062:
            r0.f4202a = r6     // Catch:{ all -> 0x003c }
            r0.f4203b = r7     // Catch:{ all -> 0x003c }
            r0.f4204c = r9     // Catch:{ all -> 0x003c }
            r0.f4205d = r8     // Catch:{ all -> 0x003c }
            r0.f4207f = r4     // Catch:{ all -> 0x003c }
            java.lang.Object r2 = r9.a(r0)     // Catch:{ all -> 0x003c }
            if (r2 != r1) goto L_0x0073
            goto L_0x0093
        L_0x0073:
            r5 = r2
            r2 = r6
            r6 = r9
            r9 = r5
        L_0x0077:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x003c }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x003c }
            if (r9 == 0) goto L_0x0094
            java.lang.Object r9 = r6.next()     // Catch:{ all -> 0x003c }
            r0.f4202a = r2     // Catch:{ all -> 0x003c }
            r0.f4203b = r7     // Catch:{ all -> 0x003c }
            r0.f4204c = r6     // Catch:{ all -> 0x003c }
            r0.f4205d = r8     // Catch:{ all -> 0x003c }
            r0.f4207f = r3     // Catch:{ all -> 0x003c }
            java.lang.Object r9 = r2.emit(r9, r0)     // Catch:{ all -> 0x003c }
            if (r9 != r1) goto L_0x0039
        L_0x0093:
            return r1
        L_0x0094:
            if (r8 == 0) goto L_0x009a
            r6 = 0
            q3.k.a(r7, r6)
        L_0x009a:
            R2.s r6 = R2.s.f8222a
            return r6
        L_0x009d:
            throw r6     // Catch:{ all -> 0x009e }
        L_0x009e:
            r9 = move-exception
            if (r8 == 0) goto L_0x00a4
            q3.k.a(r7, r6)
        L_0x00a4:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.C1039i.c(r3.f, q3.u, boolean, V2.d):java.lang.Object");
    }
}
