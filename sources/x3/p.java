package X3;

import W3.C2604a;
import W3.b;
import Z3.C2621j;
import com.inmobi.cmp.data.storage.SharedStorage;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.m;

public final class p implements o {

    /* renamed from: a  reason: collision with root package name */
    public final C2604a f24288a;

    /* renamed from: b  reason: collision with root package name */
    public final SharedStorage f24289b;

    /* renamed from: c  reason: collision with root package name */
    public final b f24290c;

    /* renamed from: d  reason: collision with root package name */
    public final C2621j f24291d;

    /* renamed from: e  reason: collision with root package name */
    public final String f24292e = "tcfv2/google-atp-list.json";

    public static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        public Object f24293a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f24294b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ p f24295c;

        /* renamed from: d  reason: collision with root package name */
        public int f24296d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(p pVar, V2.d dVar) {
            super(dVar);
            this.f24295c = pVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f24294b = obj;
            this.f24296d |= Integer.MIN_VALUE;
            return this.f24295c.a(this);
        }
    }

    public p(C2604a aVar, SharedStorage sharedStorage, b bVar, C2621j jVar) {
        m.e(aVar, "networkUtil");
        m.e(sharedStorage, "sharedStorage");
        m.e(bVar, "requestApi");
        m.e(jVar, "resolver");
        this.f24288a = aVar;
        this.f24289b = sharedStorage;
        this.f24290c = bVar;
        this.f24291d = jVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(V2.d r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof X3.p.a
            if (r0 == 0) goto L_0x0013
            r0 = r9
            X3.p$a r0 = (X3.p.a) r0
            int r1 = r0.f24296d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f24296d = r1
            goto L_0x0018
        L_0x0013:
            X3.p$a r0 = new X3.p$a
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f24294b
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f24296d
            r3 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r0 = r0.f24293a
            X3.p r0 = (X3.p) r0
            R2.n.b(r9)     // Catch:{ a -> 0x002d }
            goto L_0x0082
        L_0x002d:
            goto L_0x009f
        L_0x0030:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0038:
            R2.n.b(r9)
            W3.a r9 = r8.f24288a     // Catch:{ a -> 0x0085 }
            boolean r9 = r9.a()     // Catch:{ a -> 0x0085 }
            if (r9 == 0) goto L_0x0087
            boolean r9 = r8.b()     // Catch:{ a -> 0x0085 }
            if (r9 == 0) goto L_0x0087
            com.inmobi.cmp.data.storage.SharedStorage r9 = r8.f24289b     // Catch:{ a -> 0x0085 }
            a4.a r2 = a4.a.GOOGLE_VENDOR_LAST_UPDATE     // Catch:{ a -> 0x0085 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ a -> 0x0085 }
            r9.getClass()     // Catch:{ a -> 0x0085 }
            java.lang.String r6 = "preferenceKey"
            kotlin.jvm.internal.m.e(r2, r6)     // Catch:{ a -> 0x0085 }
            android.content.SharedPreferences r9 = r9.f11786a     // Catch:{ a -> 0x0085 }
            android.content.SharedPreferences$Editor r9 = r9.edit()     // Catch:{ a -> 0x0085 }
            java.lang.String r2 = "editor"
            kotlin.jvm.internal.m.d(r9, r2)     // Catch:{ a -> 0x0085 }
            java.lang.String r2 = "googleVendorLastUpdate"
            r9.putLong(r2, r4)     // Catch:{ a -> 0x0085 }
            r9.apply()     // Catch:{ a -> 0x0085 }
            W3.b r9 = r8.f24290c     // Catch:{ a -> 0x0085 }
            java.lang.String r2 = "https://cmp.inmobi.com/"
            java.lang.String r4 = r8.f24292e     // Catch:{ a -> 0x0085 }
            java.lang.String r2 = kotlin.jvm.internal.m.m(r2, r4)     // Catch:{ a -> 0x0085 }
            r0.f24293a = r8     // Catch:{ a -> 0x0085 }
            r0.f24296d = r3     // Catch:{ a -> 0x0085 }
            java.lang.Object r9 = r9.a(r2, r0)     // Catch:{ a -> 0x0085 }
            if (r9 != r1) goto L_0x0081
            return r1
        L_0x0081:
            r0 = r8
        L_0x0082:
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ a -> 0x002d }
            goto L_0x00b0
        L_0x0085:
            goto L_0x009e
        L_0x0087:
            C2.b r1 = C2.b.f6277a     // Catch:{ a -> 0x0085 }
            com.inmobi.cmp.model.ChoiceError r2 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch:{ a -> 0x0085 }
            r6 = 0
            r7 = 30
            r3 = 0
            r4 = 0
            r5 = 0
            C2.b.a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ a -> 0x0085 }
            com.inmobi.cmp.data.storage.SharedStorage r9 = r8.f24289b     // Catch:{ a -> 0x0085 }
            a4.a r0 = a4.a.GOOGLE_VENDOR_LIST     // Catch:{ a -> 0x0085 }
            java.lang.String r9 = r9.j(r0)     // Catch:{ a -> 0x0085 }
            r0 = r8
            goto L_0x00b0
        L_0x009e:
            r0 = r8
        L_0x009f:
            boolean r9 = r0.b()
            if (r9 == 0) goto L_0x00a8
            java.lang.String r9 = ""
            goto L_0x00b0
        L_0x00a8:
            com.inmobi.cmp.data.storage.SharedStorage r9 = r0.f24289b
            a4.a r1 = a4.a.GOOGLE_VENDOR_LIST
            java.lang.String r9 = r9.j(r1)
        L_0x00b0:
            com.inmobi.cmp.data.storage.SharedStorage r1 = r0.f24289b
            a4.a r2 = a4.a.GOOGLE_VENDOR_LIST
            r1.e(r2, r9)
            Z3.j r0 = r0.f24291d
            java.lang.Object r9 = r0.a(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: X3.p.a(V2.d):java.lang.Object");
    }

    public final boolean b() {
        SharedStorage sharedStorage = this.f24289b;
        a4.a aVar = a4.a.GOOGLE_VENDOR_LAST_UPDATE;
        sharedStorage.getClass();
        m.e(aVar, "preferenceKey");
        long j4 = sharedStorage.f11786a.getLong("googleVendorLastUpdate", 0);
        if (TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - j4) >= ((long) 0)) {
            return true;
        }
        return false;
    }
}
