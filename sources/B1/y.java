package b1;

import R2.n;
import R2.s;
import android.content.Context;
import android.util.Log;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesFactory;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.core.PreferencesKt;
import d3.l;
import d3.p;
import d3.q;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
import k3.h;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.x;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.L;
import r3.C1035e;
import r3.C1036f;
import r3.C1037g;

public final class y implements com.google.firebase.sessions.a {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final c f9065f = new c((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final g3.a f9066g = PreferenceDataStoreDelegateKt.preferencesDataStore$default(x.f9061a.a(), new ReplaceFileCorruptionHandler(b.f9074a), (l) null, (J) null, 12, (Object) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Context f9067b;

    /* renamed from: c  reason: collision with root package name */
    private final V2.g f9068c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference f9069d = new AtomicReference();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final C1035e f9070e;

    static final class a extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9071a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ y f9072b;

        /* renamed from: b1.y$a$a  reason: collision with other inner class name */
        static final class C0136a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ y f9073a;

            C0136a(y yVar) {
                this.f9073a = yVar;
            }

            /* renamed from: b */
            public final Object emit(m mVar, V2.d dVar) {
                this.f9073a.f9069d.set(mVar);
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(y yVar, V2.d dVar) {
            super(2, dVar);
            this.f9072b = yVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new a(this.f9072b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9071a;
            if (i4 == 0) {
                n.b(obj);
                C1035e g4 = this.f9072b.f9070e;
                C0136a aVar = new C0136a(this.f9072b);
                this.f9071a = 1;
                if (g4.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class b extends kotlin.jvm.internal.n implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f9074a = new b();

        b() {
            super(1);
        }

        /* renamed from: a */
        public final Preferences invoke(CorruptionException corruptionException) {
            m.e(corruptionException, "ex");
            Log.w("FirebaseSessionsRepo", "CorruptionException in sessions DataStore in " + w.f9060a.e() + '.', corruptionException);
            return PreferencesFactory.createEmpty();
        }
    }

    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ h[] f9075a = {D.g(new x(c.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};

        public /* synthetic */ c(C2103g gVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final DataStore b(Context context) {
            return (DataStore) y.f9066g.getValue(context, f9075a[0]);
        }

        private c() {
        }
    }

    private static final class d {

        /* renamed from: a  reason: collision with root package name */
        public static final d f9076a = new d();

        /* renamed from: b  reason: collision with root package name */
        private static final Preferences.Key f9077b = PreferencesKeys.stringKey("session_id");

        private d() {
        }

        public final Preferences.Key a() {
            return f9077b;
        }
    }

    static final class e extends kotlin.coroutines.jvm.internal.l implements q {

        /* renamed from: a  reason: collision with root package name */
        int f9078a;

        /* renamed from: b  reason: collision with root package name */
        private /* synthetic */ Object f9079b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f9080c;

        e(V2.d dVar) {
            super(3, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9078a;
            if (i4 == 0) {
                n.b(obj);
                Log.e("FirebaseSessionsRepo", "Error reading stored session data.", (Throwable) this.f9080c);
                Preferences createEmpty = PreferencesFactory.createEmpty();
                this.f9079b = null;
                this.f9078a = 1;
                if (((C1036f) this.f9079b).emit(createEmpty, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(C1036f fVar, Throwable th, V2.d dVar) {
            e eVar = new e(dVar);
            eVar.f9079b = fVar;
            eVar.f9080c = th;
            return eVar.invokeSuspend(s.f8222a);
        }
    }

    public static final class f implements C1035e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1035e f9081a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ y f9082b;

        public static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1036f f9083a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ y f9084b;

            /* renamed from: b1.y$f$a$a  reason: collision with other inner class name */
            public static final class C0137a extends kotlin.coroutines.jvm.internal.d {

                /* renamed from: a  reason: collision with root package name */
                /* synthetic */ Object f9085a;

                /* renamed from: b  reason: collision with root package name */
                int f9086b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ a f9087c;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0137a(a aVar, V2.d dVar) {
                    super(dVar);
                    this.f9087c = aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.f9085a = obj;
                    this.f9086b |= Integer.MIN_VALUE;
                    return this.f9087c.emit((Object) null, this);
                }
            }

            public a(C1036f fVar, y yVar) {
                this.f9083a = fVar;
                this.f9084b = yVar;
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r5, V2.d r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof b1.y.f.a.C0137a
                    if (r0 == 0) goto L_0x0013
                    r0 = r6
                    b1.y$f$a$a r0 = (b1.y.f.a.C0137a) r0
                    int r1 = r0.f9086b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f9086b = r1
                    goto L_0x0018
                L_0x0013:
                    b1.y$f$a$a r0 = new b1.y$f$a$a
                    r0.<init>(r4, r6)
                L_0x0018:
                    java.lang.Object r6 = r0.f9085a
                    java.lang.Object r1 = W2.b.c()
                    int r2 = r0.f9086b
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    R2.n.b(r6)
                    goto L_0x0047
                L_0x0029:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x0031:
                    R2.n.b(r6)
                    r3.f r6 = r4.f9083a
                    androidx.datastore.preferences.core.Preferences r5 = (androidx.datastore.preferences.core.Preferences) r5
                    b1.y r2 = r4.f9084b
                    b1.m r5 = r2.i(r5)
                    r0.f9086b = r3
                    java.lang.Object r5 = r6.emit(r5, r0)
                    if (r5 != r1) goto L_0x0047
                    return r1
                L_0x0047:
                    R2.s r5 = R2.s.f8222a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: b1.y.f.a.emit(java.lang.Object, V2.d):java.lang.Object");
            }
        }

        public f(C1035e eVar, y yVar) {
            this.f9081a = eVar;
            this.f9082b = yVar;
        }

        public Object collect(C1036f fVar, V2.d dVar) {
            Object collect = this.f9081a.collect(new a(fVar, this.f9082b), dVar);
            if (collect == W2.b.c()) {
                return collect;
            }
            return s.f8222a;
        }
    }

    static final class g extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9088a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ y f9089b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f9090c;

        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9091a;

            /* renamed from: b  reason: collision with root package name */
            /* synthetic */ Object f9092b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f9093c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(String str, V2.d dVar) {
                super(2, dVar);
                this.f9093c = str;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                a aVar = new a(this.f9093c, dVar);
                aVar.f9092b = obj;
                return aVar;
            }

            /* renamed from: i */
            public final Object invoke(MutablePreferences mutablePreferences, V2.d dVar) {
                return ((a) create(mutablePreferences, dVar)).invokeSuspend(s.f8222a);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9091a == 0) {
                    n.b(obj);
                    ((MutablePreferences) this.f9092b).set(d.f9076a.a(), this.f9093c);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(y yVar, String str, V2.d dVar) {
            super(2, dVar);
            this.f9089b = yVar;
            this.f9090c = str;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new g(this.f9089b, this.f9090c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9088a;
            if (i4 == 0) {
                n.b(obj);
                DataStore a5 = y.f9065f.b(this.f9089b.f9067b);
                a aVar = new a(this.f9090c, (V2.d) null);
                this.f9088a = 1;
                if (PreferencesKt.edit(a5, aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                try {
                    n.b(obj);
                } catch (IOException e5) {
                    Log.w("FirebaseSessionsRepo", "Failed to update session Id: " + e5);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((g) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public y(Context context, V2.g gVar) {
        m.e(context, "context");
        m.e(gVar, "backgroundDispatcher");
        this.f9067b = context;
        this.f9068c = gVar;
        this.f9070e = new f(C1037g.e(f9065f.b(context).getData(), new e((V2.d) null)), this);
        C1001s0 unused = C0981i.d(K.a(gVar), (V2.g) null, (L) null, new a(this, (V2.d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final m i(Preferences preferences) {
        return new m((String) preferences.get(d.f9076a.a()));
    }

    public String a() {
        m mVar = (m) this.f9069d.get();
        if (mVar != null) {
            return mVar.a();
        }
        return null;
    }

    public void b(String str) {
        m.e(str, "sessionId");
        C1001s0 unused = C0981i.d(K.a(this.f9068c), (V2.g) null, (L) null, new g(this, str, (V2.d) null), 3, (Object) null);
    }
}
