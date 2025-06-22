package r3;

import kotlin.coroutines.jvm.internal.d;

/* renamed from: r3.a  reason: case insensitive filesystem */
public abstract class C1031a implements C1035e {

    /* renamed from: r3.a$a  reason: collision with other inner class name */
    static final class C0040a extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f4182a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f4183b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1031a f4184c;

        /* renamed from: d  reason: collision with root package name */
        int f4185d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0040a(C1031a aVar, V2.d dVar) {
            super(dVar);
            this.f4184c = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f4183b = obj;
            this.f4185d |= Integer.MIN_VALUE;
            return this.f4184c.collect((C1036f) null, this);
        }
    }

    public abstract Object c(C1036f fVar, V2.d dVar);

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object collect(r3.C1036f r6, V2.d r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof r3.C1031a.C0040a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            r3.a$a r0 = (r3.C1031a.C0040a) r0
            int r1 = r0.f4185d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f4185d = r1
            goto L_0x0018
        L_0x0013:
            r3.a$a r0 = new r3.a$a
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f4183b
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f4185d
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r6 = r0.f4182a
            s3.t r6 = (s3.t) r6
            R2.n.b(r7)     // Catch:{ all -> 0x002d }
            goto L_0x004f
        L_0x002d:
            r7 = move-exception
            goto L_0x0059
        L_0x002f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0037:
            R2.n.b(r7)
            s3.t r7 = new s3.t
            V2.g r2 = r0.getContext()
            r7.<init>(r6, r2)
            r0.f4182a = r7     // Catch:{ all -> 0x0055 }
            r0.f4185d = r3     // Catch:{ all -> 0x0055 }
            java.lang.Object r6 = r5.c(r7, r0)     // Catch:{ all -> 0x0055 }
            if (r6 != r1) goto L_0x004e
            return r1
        L_0x004e:
            r6 = r7
        L_0x004f:
            r6.releaseIntercepted()
            R2.s r6 = R2.s.f8222a
            return r6
        L_0x0055:
            r6 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
        L_0x0059:
            r6.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.C1031a.collect(r3.f, V2.d):java.lang.Object");
    }
}
