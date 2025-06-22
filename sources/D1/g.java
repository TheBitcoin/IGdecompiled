package d1;

import R2.n;
import R2.s;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.J;
import r3.C1035e;
import r3.C1037g;

public final class g {

    /* renamed from: c  reason: collision with root package name */
    private static final b f19570c = new b((C2103g) null);

    /* renamed from: d  reason: collision with root package name */
    private static final Preferences.Key f19571d = PreferencesKeys.booleanKey("firebase_sessions_enabled");

    /* renamed from: e  reason: collision with root package name */
    private static final Preferences.Key f19572e = PreferencesKeys.doubleKey("firebase_sessions_sampling_rate");

    /* renamed from: f  reason: collision with root package name */
    private static final Preferences.Key f19573f = PreferencesKeys.intKey("firebase_sessions_restart_timeout");

    /* renamed from: g  reason: collision with root package name */
    private static final Preferences.Key f19574g = PreferencesKeys.intKey("firebase_sessions_cache_duration");

    /* renamed from: h  reason: collision with root package name */
    private static final Preferences.Key f19575h = PreferencesKeys.longKey("firebase_sessions_cache_updated_time");
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final DataStore f19576a;

    /* renamed from: b  reason: collision with root package name */
    private e f19577b;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f19578a;

        /* renamed from: b  reason: collision with root package name */
        int f19579b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g f19580c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(g gVar, V2.d dVar) {
            super(2, dVar);
            this.f19580c = gVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new a(this.f19580c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            g gVar;
            Object c5 = W2.b.c();
            int i4 = this.f19579b;
            if (i4 == 0) {
                n.b(obj);
                g gVar2 = this.f19580c;
                C1035e data = gVar2.f19576a.getData();
                this.f19578a = gVar2;
                this.f19579b = 1;
                Object p4 = C1037g.p(data, this);
                if (p4 == c5) {
                    return c5;
                }
                gVar = gVar2;
                obj = p4;
            } else if (i4 == 1) {
                gVar = (g) this.f19578a;
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            gVar.l(((Preferences) obj).toPreferences());
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    private static final class b {
        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        private b() {
        }
    }

    static final class c extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f19581a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f19582b;

        /* renamed from: c  reason: collision with root package name */
        int f19583c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(g gVar, V2.d dVar) {
            super(dVar);
            this.f19582b = gVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f19581a = obj;
            this.f19583c |= Integer.MIN_VALUE;
            return this.f19582b.h((Preferences.Key) null, (Object) null, this);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19584a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f19585b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f19586c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Preferences.Key f19587d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ g f19588e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Object obj, Preferences.Key key, g gVar, V2.d dVar) {
            super(2, dVar);
            this.f19586c = obj;
            this.f19587d = key;
            this.f19588e = gVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            d dVar2 = new d(this.f19586c, this.f19587d, this.f19588e, dVar);
            dVar2.f19585b = obj;
            return dVar2;
        }

        /* renamed from: i */
        public final Object invoke(MutablePreferences mutablePreferences, V2.d dVar) {
            return ((d) create(mutablePreferences, dVar)).invokeSuspend(s.f8222a);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19584a == 0) {
                n.b(obj);
                MutablePreferences mutablePreferences = (MutablePreferences) this.f19585b;
                Object obj2 = this.f19586c;
                if (obj2 != null) {
                    mutablePreferences.set(this.f19587d, obj2);
                } else {
                    mutablePreferences.remove(this.f19587d);
                }
                this.f19588e.l(mutablePreferences);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public g(DataStore dataStore) {
        m.e(dataStore, "dataStore");
        this.f19576a = dataStore;
        Object unused = C0979h.b((V2.g) null, new a(this, (V2.d) null), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(androidx.datastore.preferences.core.Preferences.Key r6, java.lang.Object r7, V2.d r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof d1.g.c
            if (r0 == 0) goto L_0x0013
            r0 = r8
            d1.g$c r0 = (d1.g.c) r0
            int r1 = r0.f19583c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f19583c = r1
            goto L_0x0018
        L_0x0013:
            d1.g$c r0 = new d1.g$c
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f19581a
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f19583c
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            R2.n.b(r8)     // Catch:{ IOException -> 0x0029 }
            goto L_0x005d
        L_0x0029:
            r6 = move-exception
            goto L_0x0047
        L_0x002b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0033:
            R2.n.b(r8)
            androidx.datastore.core.DataStore r8 = r5.f19576a     // Catch:{ IOException -> 0x0029 }
            d1.g$d r2 = new d1.g$d     // Catch:{ IOException -> 0x0029 }
            r4 = 0
            r2.<init>(r7, r6, r5, r4)     // Catch:{ IOException -> 0x0029 }
            r0.f19583c = r3     // Catch:{ IOException -> 0x0029 }
            java.lang.Object r6 = androidx.datastore.preferences.core.PreferencesKt.edit(r8, r2, r0)     // Catch:{ IOException -> 0x0029 }
            if (r6 != r1) goto L_0x005d
            return r1
        L_0x0047:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Failed to update cache config value: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "SettingsCache"
            android.util.Log.w(r7, r6)
        L_0x005d:
            R2.s r6 = R2.s.f8222a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.g.h(androidx.datastore.preferences.core.Preferences$Key, java.lang.Object, V2.d):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void l(Preferences preferences) {
        this.f19577b = new e((Boolean) preferences.get(f19571d), (Double) preferences.get(f19572e), (Integer) preferences.get(f19573f), (Integer) preferences.get(f19574g), (Long) preferences.get(f19575h));
    }

    public final boolean d() {
        e eVar = this.f19577b;
        e eVar2 = null;
        if (eVar == null) {
            m.u("sessionConfigs");
            eVar = null;
        }
        Long b5 = eVar.b();
        e eVar3 = this.f19577b;
        if (eVar3 == null) {
            m.u("sessionConfigs");
        } else {
            eVar2 = eVar3;
        }
        Integer a5 = eVar2.a();
        if (b5 == null || a5 == null || (System.currentTimeMillis() - b5.longValue()) / ((long) 1000) >= ((long) a5.intValue())) {
            return true;
        }
        return false;
    }

    public final Integer e() {
        e eVar = this.f19577b;
        if (eVar == null) {
            m.u("sessionConfigs");
            eVar = null;
        }
        return eVar.d();
    }

    public final Double f() {
        e eVar = this.f19577b;
        if (eVar == null) {
            m.u("sessionConfigs");
            eVar = null;
        }
        return eVar.e();
    }

    public final Boolean g() {
        e eVar = this.f19577b;
        if (eVar == null) {
            m.u("sessionConfigs");
            eVar = null;
        }
        return eVar.c();
    }

    public final Object i(Double d5, V2.d dVar) {
        Object h4 = h(f19572e, d5, dVar);
        if (h4 == W2.b.c()) {
            return h4;
        }
        return s.f8222a;
    }

    public final Object j(Integer num, V2.d dVar) {
        Object h4 = h(f19574g, num, dVar);
        if (h4 == W2.b.c()) {
            return h4;
        }
        return s.f8222a;
    }

    public final Object k(Long l4, V2.d dVar) {
        Object h4 = h(f19575h, l4, dVar);
        if (h4 == W2.b.c()) {
            return h4;
        }
        return s.f8222a;
    }

    public final Object m(Integer num, V2.d dVar) {
        Object h4 = h(f19573f, num, dVar);
        if (h4 == W2.b.c()) {
            return h4;
        }
        return s.f8222a;
    }

    public final Object n(Boolean bool, V2.d dVar) {
        Object h4 = h(f19571d, bool, dVar);
        if (h4 == W2.b.c()) {
            return h4;
        }
        return s.f8222a;
    }
}
