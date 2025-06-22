package X3;

import W3.C2604a;
import W3.b;
import Z3.C2621j;
import com.inmobi.cmp.data.storage.SharedStorage;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.m;

/* renamed from: X3.d  reason: case insensitive filesystem */
public final class C2608d implements C2607c {

    /* renamed from: a  reason: collision with root package name */
    public final C2604a f24244a;

    /* renamed from: b  reason: collision with root package name */
    public final SharedStorage f24245b;

    /* renamed from: c  reason: collision with root package name */
    public final b f24246c;

    /* renamed from: d  reason: collision with root package name */
    public final C2621j f24247d;

    /* renamed from: e  reason: collision with root package name */
    public final String f24248e = "GVL-v2/cmp-list.json";

    /* renamed from: X3.d$a */
    public static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        public Object f24249a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f24250b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ C2608d f24251c;

        /* renamed from: d  reason: collision with root package name */
        public int f24252d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(C2608d dVar, V2.d dVar2) {
            super(dVar2);
            this.f24251c = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f24250b = obj;
            this.f24252d |= Integer.MIN_VALUE;
            return this.f24251c.a(this);
        }
    }

    public C2608d(C2604a aVar, SharedStorage sharedStorage, b bVar, C2621j jVar) {
        m.e(aVar, "networkUtil");
        m.e(sharedStorage, "sharedStorage");
        m.e(bVar, "requestApi");
        m.e(jVar, "resolver");
        this.f24244a = aVar;
        this.f24245b = sharedStorage;
        this.f24246c = bVar;
        this.f24247d = jVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(V2.d r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof X3.C2608d.a
            if (r0 == 0) goto L_0x0013
            r0 = r9
            X3.d$a r0 = (X3.C2608d.a) r0
            int r1 = r0.f24252d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f24252d = r1
            goto L_0x0018
        L_0x0013:
            X3.d$a r0 = new X3.d$a
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f24250b
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f24252d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f24249a
            X3.d r0 = (X3.C2608d) r0
            R2.n.b(r9)     // Catch:{ a -> 0x0071 }
            goto L_0x0056
        L_0x002d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0035:
            R2.n.b(r9)
            W3.a r9 = r8.f24244a     // Catch:{ a -> 0x0070 }
            boolean r9 = r9.a()     // Catch:{ a -> 0x0070 }
            if (r9 == 0) goto L_0x0059
            W3.b r9 = r8.f24246c     // Catch:{ a -> 0x0070 }
            java.lang.String r2 = "https://cmp.inmobi.com/"
            java.lang.String r4 = r8.f24248e     // Catch:{ a -> 0x0070 }
            java.lang.String r2 = kotlin.jvm.internal.m.m(r2, r4)     // Catch:{ a -> 0x0070 }
            r0.f24249a = r8     // Catch:{ a -> 0x0070 }
            r0.f24252d = r3     // Catch:{ a -> 0x0070 }
            java.lang.Object r9 = r9.a(r2, r0)     // Catch:{ a -> 0x0070 }
            if (r9 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r0 = r8
        L_0x0056:
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ a -> 0x0071 }
            goto L_0x0079
        L_0x0059:
            C2.b r1 = C2.b.f6277a     // Catch:{ a -> 0x0070 }
            com.inmobi.cmp.model.ChoiceError r2 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch:{ a -> 0x0070 }
            r6 = 0
            r7 = 30
            r3 = 0
            r4 = 0
            r5 = 0
            C2.b.a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ a -> 0x0070 }
            com.inmobi.cmp.data.storage.SharedStorage r9 = r8.f24245b     // Catch:{ a -> 0x0070 }
            a4.a r0 = a4.a.CMP_LIST     // Catch:{ a -> 0x0070 }
            java.lang.String r9 = r9.j(r0)     // Catch:{ a -> 0x0070 }
            r0 = r8
            goto L_0x0079
        L_0x0070:
            r0 = r8
        L_0x0071:
            com.inmobi.cmp.data.storage.SharedStorage r9 = r0.f24245b
            a4.a r1 = a4.a.CMP_LIST
            java.lang.String r9 = r9.j(r1)
        L_0x0079:
            com.inmobi.cmp.data.storage.SharedStorage r1 = r0.f24245b
            a4.a r2 = a4.a.CMP_LIST
            r1.e(r2, r9)
            Z3.j r0 = r0.f24247d
            java.lang.Object r9 = r0.a(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: X3.C2608d.a(V2.d):java.lang.Object");
    }
}
