package d1;

import android.content.Context;
import android.util.Log;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesFactory;
import b1.w;
import b1.x;
import d3.l;
import k3.h;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import n3.a;
import o3.J;
import p0.C2191c;

public final class f {

    /* renamed from: c  reason: collision with root package name */
    public static final b f19560c = new b((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final g3.a f19561d = PreferenceDataStoreDelegateKt.preferencesDataStore$default(x.f9061a.b(), new ReplaceFileCorruptionHandler(a.f19564a), (l) null, (J) null, 12, (Object) null);

    /* renamed from: a  reason: collision with root package name */
    private final h f19562a;

    /* renamed from: b  reason: collision with root package name */
    private final h f19563b;

    static final class a extends n implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final a f19564a = new a();

        a() {
            super(1);
        }

        /* renamed from: a */
        public final Preferences invoke(CorruptionException corruptionException) {
            m.e(corruptionException, "ex");
            Log.w("SessionsSettings", "CorruptionException in settings DataStore in " + w.f9060a.e() + '.', corruptionException);
            return PreferencesFactory.createEmpty();
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ h[] f19565a = {D.g(new kotlin.jvm.internal.x(b.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};

        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final DataStore b(Context context) {
            return (DataStore) f.f19561d.getValue(context, f19565a[0]);
        }

        public final f c() {
            Object j4 = p0.n.a(C2191c.f21433a).j(f.class);
            m.d(j4, "Firebase.app[SessionsSettings::class.java]");
            return (f) j4;
        }

        private b() {
        }
    }

    static final class c extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f19566a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f19567b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f f19568c;

        /* renamed from: d  reason: collision with root package name */
        int f19569d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(f fVar, V2.d dVar) {
            super(dVar);
            this.f19568c = fVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f19567b = obj;
            this.f19569d |= Integer.MIN_VALUE;
            return this.f19568c.g(this);
        }
    }

    public f(h hVar, h hVar2) {
        m.e(hVar, "localOverrideSettings");
        m.e(hVar2, "remoteSettings");
        this.f19562a = hVar;
        this.f19563b = hVar2;
    }

    private final boolean e(double d5) {
        if (0.0d > d5 || d5 > 1.0d) {
            return false;
        }
        return true;
    }

    private final boolean f(long j4) {
        if (!n3.a.z(j4) || !n3.a.u(j4)) {
            return false;
        }
        return true;
    }

    public final double b() {
        Double d5 = this.f19562a.d();
        if (d5 != null) {
            double doubleValue = d5.doubleValue();
            if (e(doubleValue)) {
                return doubleValue;
            }
        }
        Double d6 = this.f19563b.d();
        if (d6 == null) {
            return 1.0d;
        }
        double doubleValue2 = d6.doubleValue();
        if (e(doubleValue2)) {
            return doubleValue2;
        }
        return 1.0d;
    }

    public final long c() {
        n3.a c5 = this.f19562a.c();
        if (c5 != null) {
            long H4 = c5.H();
            if (f(H4)) {
                return H4;
            }
        }
        n3.a c6 = this.f19563b.c();
        if (c6 != null) {
            long H5 = c6.H();
            if (f(H5)) {
                return H5;
            }
        }
        a.C0266a aVar = n3.a.f21358b;
        return n3.c.h(30, n3.d.MINUTES);
    }

    public final boolean d() {
        Boolean a5 = this.f19562a.a();
        if (a5 != null) {
            return a5.booleanValue();
        }
        Boolean a6 = this.f19563b.a();
        if (a6 != null) {
            return a6.booleanValue();
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
        if (r6.b(r0) != r1) goto L_0x005b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object g(V2.d r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof d1.f.c
            if (r0 == 0) goto L_0x0013
            r0 = r6
            d1.f$c r0 = (d1.f.c) r0
            int r1 = r0.f19569d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f19569d = r1
            goto L_0x0018
        L_0x0013:
            d1.f$c r0 = new d1.f$c
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f19567b
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f19569d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            R2.n.b(r6)
            goto L_0x005b
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0034:
            java.lang.Object r2 = r0.f19566a
            d1.f r2 = (d1.f) r2
            R2.n.b(r6)
            goto L_0x004d
        L_0x003c:
            R2.n.b(r6)
            d1.h r6 = r5.f19562a
            r0.f19566a = r5
            r0.f19569d = r4
            java.lang.Object r6 = r6.b(r0)
            if (r6 != r1) goto L_0x004c
            goto L_0x005a
        L_0x004c:
            r2 = r5
        L_0x004d:
            d1.h r6 = r2.f19563b
            r2 = 0
            r0.f19566a = r2
            r0.f19569d = r3
            java.lang.Object r6 = r6.b(r0)
            if (r6 != r1) goto L_0x005b
        L_0x005a:
            return r1
        L_0x005b:
            R2.s r6 = R2.s.f8222a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.f.g(V2.d):java.lang.Object");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private f(android.content.Context r9, V2.g r10, V2.g r11, S0.e r12, b1.C1619b r13) {
        /*
            r8 = this;
            d1.b r0 = new d1.b
            r0.<init>(r9)
            d1.c r1 = new d1.c
            d1.d r2 = new d1.d
            r6 = 4
            r7 = 0
            r5 = 0
            r4 = r10
            r3 = r13
            r2.<init>(r3, r4, r5, r6, r7)
            d1.f$b r10 = f19560c
            androidx.datastore.core.DataStore r6 = r10.b(r9)
            r5 = r2
            r4 = r3
            r2 = r11
            r3 = r12
            r1.<init>(r2, r3, r4, r5, r6)
            r8.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.f.<init>(android.content.Context, V2.g, V2.g, S0.e, b1.b):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f(p0.C2194f r8, V2.g r9, V2.g r10, S0.e r11) {
        /*
            r7 = this;
            java.lang.String r0 = "firebaseApp"
            kotlin.jvm.internal.m.e(r8, r0)
            java.lang.String r0 = "blockingDispatcher"
            kotlin.jvm.internal.m.e(r9, r0)
            java.lang.String r0 = "backgroundDispatcher"
            kotlin.jvm.internal.m.e(r10, r0)
            java.lang.String r0 = "firebaseInstallationsApi"
            kotlin.jvm.internal.m.e(r11, r0)
            android.content.Context r2 = r8.k()
            java.lang.String r0 = "firebaseApp.applicationContext"
            kotlin.jvm.internal.m.d(r2, r0)
            b1.B r0 = b1.C1617B.f8921a
            b1.b r6 = r0.b(r8)
            r1 = r7
            r3 = r9
            r4 = r10
            r5 = r11
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.f.<init>(p0.f, V2.g, V2.g, S0.e):void");
    }
}
