package b1;

import R2.s;
import V2.d;
import V2.g;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import d1.f;
import d3.p;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.L;
import p0.C2194f;

public final class l {

    /* renamed from: c  reason: collision with root package name */
    public static final b f9035c = new b((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final C2194f f9036a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final f f9037b;

    static final class a extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9038a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l f9039b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g f9040c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ G f9041d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(l lVar, g gVar, G g4, d dVar) {
            super(2, dVar);
            this.f9039b = lVar;
            this.f9040c = gVar;
            this.f9041d = g4;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f9039b, this.f9040c, this.f9041d, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0066, code lost:
            if (r6.g(r5) == r0) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0068, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002b, code lost:
            if (r6 == r0) goto L_0x0068;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r5.f9038a
                java.lang.String r2 = "FirebaseSessions"
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0020
                if (r1 == r4) goto L_0x001c
                if (r1 != r3) goto L_0x0014
                R2.n.b(r6)
                goto L_0x0069
            L_0x0014:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x001c:
                R2.n.b(r6)
                goto L_0x002e
            L_0x0020:
                R2.n.b(r6)
                c1.a r6 = c1.C1648a.f9655a
                r5.f9038a = r4
                java.lang.Object r6 = r6.c(r5)
                if (r6 != r0) goto L_0x002e
                goto L_0x0068
            L_0x002e:
                java.util.Map r6 = (java.util.Map) r6
                java.util.Collection r6 = r6.values()
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                boolean r1 = r6 instanceof java.util.Collection
                if (r1 == 0) goto L_0x0044
                r1 = r6
                java.util.Collection r1 = (java.util.Collection) r1
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L_0x0044
                goto L_0x009b
            L_0x0044:
                java.util.Iterator r6 = r6.iterator()
            L_0x0048:
                boolean r1 = r6.hasNext()
                if (r1 == 0) goto L_0x009b
                java.lang.Object r1 = r6.next()
                c1.b r1 = (c1.C1649b) r1
                boolean r1 = r1.a()
                if (r1 == 0) goto L_0x0048
                b1.l r6 = r5.f9039b
                d1.f r6 = r6.f9037b
                r5.f9038a = r3
                java.lang.Object r6 = r6.g(r5)
                if (r6 != r0) goto L_0x0069
            L_0x0068:
                return r0
            L_0x0069:
                b1.l r6 = r5.f9039b
                d1.f r6 = r6.f9037b
                boolean r6 = r6.d()
                if (r6 != 0) goto L_0x007b
                java.lang.String r6 = "Sessions SDK disabled. Not listening to lifecycle events."
                android.util.Log.d(r2, r6)
                goto L_0x00a0
            L_0x007b:
                b1.E r6 = new b1.E
                V2.g r0 = r5.f9040c
                r6.<init>(r0)
                b1.G r0 = r5.f9041d
                r6.i(r0)
                b1.I r0 = b1.I.f8965a
                r0.a(r6)
                b1.l r6 = r5.f9039b
                p0.f r6 = r6.f9036a
                b1.k r0 = new b1.k
                r0.<init>()
                r6.h(r0)
                goto L_0x00a0
            L_0x009b:
                java.lang.String r6 = "No Sessions subscribers. Not listening to lifecycle events."
                android.util.Log.d(r2, r6)
            L_0x00a0:
                R2.s r6 = R2.s.f8222a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: b1.l.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class b {
        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        private b() {
        }
    }

    public l(C2194f fVar, f fVar2, g gVar, G g4) {
        m.e(fVar, "firebaseApp");
        m.e(fVar2, "settings");
        m.e(gVar, "backgroundDispatcher");
        m.e(g4, "lifecycleServiceBinder");
        this.f9036a = fVar;
        this.f9037b = fVar2;
        Log.d("FirebaseSessions", "Initializing Firebase Sessions SDK.");
        Context applicationContext = fVar.k().getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(I.f8965a);
            C1001s0 unused = C0981i.d(K.a(gVar), (g) null, (L) null, new a(this, gVar, g4, (d) null), 3, (Object) null);
            return;
        }
        Log.e("FirebaseSessions", "Failed to register lifecycle callbacks, unexpected context " + applicationContext.getClass() + '.');
    }
}
