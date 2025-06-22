package X3;

import R2.s;
import V2.d;
import V2.g;
import W3.C2604a;
import W3.b;
import Z3.C2621j;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataScope;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;

public final class h implements g {

    /* renamed from: a  reason: collision with root package name */
    public final C2604a f24258a;

    /* renamed from: b  reason: collision with root package name */
    public final b f24259b;

    /* renamed from: c  reason: collision with root package name */
    public final C2621j f24260c;

    public static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        public Object f24261a;

        /* renamed from: b  reason: collision with root package name */
        public int f24262b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f24263c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ h f24264d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f24265e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(h hVar, String str, d dVar) {
            super(2, dVar);
            this.f24264d = hVar;
            this.f24265e = str;
        }

        public final d create(Object obj, d dVar) {
            a aVar = new a(this.f24264d, this.f24265e, dVar);
            aVar.f24263c = obj;
            return aVar;
        }

        public Object invoke(Object obj, Object obj2) {
            a aVar = new a(this.f24264d, this.f24265e, (d) obj2);
            aVar.f24263c = (LiveDataScope) obj;
            return aVar.invokeSuspend(s.f8222a);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v9, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: androidx.lifecycle.LiveDataScope} */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0082, code lost:
            if (r5.emit(r14, r13) != r0) goto L_0x0085;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r13.f24262b
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L_0x0028
                if (r1 == r4) goto L_0x001c
                if (r1 != r2) goto L_0x0014
                R2.n.b(r14)
                goto L_0x0085
            L_0x0014:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L_0x001c:
                java.lang.Object r1 = r13.f24261a
                Z3.j r1 = (Z3.C2621j) r1
                java.lang.Object r5 = r13.f24263c
                androidx.lifecycle.LiveDataScope r5 = (androidx.lifecycle.LiveDataScope) r5
                R2.n.b(r14)     // Catch:{ a -> 0x0073 }
                goto L_0x0057
            L_0x0028:
                R2.n.b(r14)
                java.lang.Object r14 = r13.f24263c
                r5 = r14
                androidx.lifecycle.LiveDataScope r5 = (androidx.lifecycle.LiveDataScope) r5
                X3.h r14 = r13.f24264d     // Catch:{ a -> 0x0073 }
                W3.a r14 = r14.f24258a     // Catch:{ a -> 0x0073 }
                boolean r14 = r14.a()     // Catch:{ a -> 0x0073 }
                if (r14 == 0) goto L_0x0060
                java.lang.String r14 = r13.f24265e     // Catch:{ a -> 0x0073 }
                int r14 = r14.length()     // Catch:{ a -> 0x0073 }
                if (r14 <= 0) goto L_0x0060
                X3.h r14 = r13.f24264d     // Catch:{ a -> 0x0073 }
                Z3.j r1 = r14.f24260c     // Catch:{ a -> 0x0073 }
                W3.b r14 = r14.f24259b     // Catch:{ a -> 0x0073 }
                java.lang.String r6 = r13.f24265e     // Catch:{ a -> 0x0073 }
                r13.f24263c = r5     // Catch:{ a -> 0x0073 }
                r13.f24261a = r1     // Catch:{ a -> 0x0073 }
                r13.f24262b = r4     // Catch:{ a -> 0x0073 }
                java.lang.Object r14 = r14.a(r6, r13)     // Catch:{ a -> 0x0073 }
                if (r14 != r0) goto L_0x0057
                goto L_0x0084
            L_0x0057:
                java.lang.String r14 = (java.lang.String) r14     // Catch:{ a -> 0x0073 }
                java.lang.Object r14 = r1.a(r14)     // Catch:{ a -> 0x0073 }
                V3.d r14 = (V3.C2593d) r14     // Catch:{ a -> 0x0073 }
                goto L_0x0078
            L_0x0060:
                C2.b r6 = C2.b.f6277a     // Catch:{ a -> 0x0073 }
                com.inmobi.cmp.model.ChoiceError r7 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch:{ a -> 0x0073 }
                r11 = 0
                r12 = 30
                r8 = 0
                r9 = 0
                r10 = 0
                C2.b.a(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ a -> 0x0073 }
                V3.d r14 = new V3.d     // Catch:{ a -> 0x0073 }
                r14.<init>(r3, r4)     // Catch:{ a -> 0x0073 }
                goto L_0x0078
            L_0x0073:
                V3.d r14 = new V3.d
                r14.<init>(r3, r4)
            L_0x0078:
                r13.f24263c = r3
                r13.f24261a = r3
                r13.f24262b = r2
                java.lang.Object r14 = r5.emit(r14, r13)
                if (r14 != r0) goto L_0x0085
            L_0x0084:
                return r0
            L_0x0085:
                R2.s r14 = R2.s.f8222a
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: X3.h.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public h(C2604a aVar, b bVar, C2621j jVar) {
        m.e(aVar, "networkUtil");
        m.e(bVar, "requestApi");
        m.e(jVar, "resolver");
        this.f24258a = aVar;
        this.f24259b = bVar;
        this.f24260c = jVar;
    }

    public LiveData a(String str) {
        m.e(str, "url");
        return CoroutineLiveDataKt.liveData$default((g) null, 0, (p) new a(this, str, (d) null), 3, (Object) null);
    }
}
