package c1;

import android.util.Log;
import c1.C1649b;
import j$.util.DesugarCollections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import x3.a;
import x3.c;

/* renamed from: c1.a  reason: case insensitive filesystem */
public final class C1648a {

    /* renamed from: a  reason: collision with root package name */
    public static final C1648a f9655a = new C1648a();

    /* renamed from: b  reason: collision with root package name */
    private static final Map f9656b = DesugarCollections.synchronizedMap(new LinkedHashMap());

    /* renamed from: c1.a$a  reason: collision with other inner class name */
    private static final class C0161a {

        /* renamed from: a  reason: collision with root package name */
        private final a f9657a;

        /* renamed from: b  reason: collision with root package name */
        private C1649b f9658b;

        public C0161a(a aVar, C1649b bVar) {
            m.e(aVar, "mutex");
            this.f9657a = aVar;
            this.f9658b = bVar;
        }

        public final a a() {
            return this.f9657a;
        }

        public final C1649b b() {
            return this.f9658b;
        }

        public final void c(C1649b bVar) {
            this.f9658b = bVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0161a)) {
                return false;
            }
            C0161a aVar = (C0161a) obj;
            if (m.a(this.f9657a, aVar.f9657a) && m.a(this.f9658b, aVar.f9658b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i4;
            int hashCode = this.f9657a.hashCode() * 31;
            C1649b bVar = this.f9658b;
            if (bVar == null) {
                i4 = 0;
            } else {
                i4 = bVar.hashCode();
            }
            return hashCode + i4;
        }

        public String toString() {
            return "Dependency(mutex=" + this.f9657a + ", subscriber=" + this.f9658b + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C0161a(a aVar, C1649b bVar, int i4, C2103g gVar) {
            this(aVar, (i4 & 2) != 0 ? null : bVar);
        }
    }

    /* renamed from: c1.a$b */
    static final class b extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f9659a;

        /* renamed from: b  reason: collision with root package name */
        Object f9660b;

        /* renamed from: c  reason: collision with root package name */
        Object f9661c;

        /* renamed from: d  reason: collision with root package name */
        Object f9662d;

        /* renamed from: e  reason: collision with root package name */
        Object f9663e;

        /* renamed from: f  reason: collision with root package name */
        Object f9664f;

        /* renamed from: g  reason: collision with root package name */
        /* synthetic */ Object f9665g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ C1648a f9666h;

        /* renamed from: i  reason: collision with root package name */
        int f9667i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C1648a aVar, V2.d dVar) {
            super(dVar);
            this.f9666h = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f9665g = obj;
            this.f9667i |= Integer.MIN_VALUE;
            return this.f9666h.c(this);
        }
    }

    private C1648a() {
    }

    public static final void a(C1649b.a aVar) {
        m.e(aVar, "subscriberName");
        if (aVar != C1649b.a.PERFORMANCE) {
            Map map = f9656b;
            if (map.containsKey(aVar)) {
                Log.d("SessionsDependencies", "Dependency " + aVar + " already added.");
                return;
            }
            m.d(map, "dependencies");
            map.put(aVar, new C0161a(c.a(true), (C1649b) null, 2, (C2103g) null));
            Log.d("SessionsDependencies", "Dependency to " + aVar + " added.");
            return;
        }
        throw new IllegalArgumentException("Incompatible versions of Firebase Perf and Firebase Sessions.\nA safe combination would be:\n  firebase-sessions:1.1.0\n  firebase-crashlytics:18.5.0\n  firebase-perf:20.5.0\nFor more information contact Firebase Support.");
    }

    private final C0161a b(C1649b.a aVar) {
        Map map = f9656b;
        m.d(map, "dependencies");
        Object obj = map.get(aVar);
        if (obj != null) {
            m.d(obj, "dependencies.getOrElse(s…load time.\"\n      )\n    }");
            return (C0161a) obj;
        }
        throw new IllegalStateException("Cannot get dependency " + aVar + ". Dependencies should be added at class load time.");
    }

    public static final void e(C1649b bVar) {
        m.e(bVar, "subscriber");
        C1649b.a b5 = bVar.b();
        C0161a b6 = f9655a.b(b5);
        if (b6.b() != null) {
            Log.d("SessionsDependencies", "Subscriber " + b5 + " already registered.");
            return;
        }
        b6.c(bVar);
        Log.d("SessionsDependencies", "Subscriber " + b5 + " registered.");
        a.C0052a.b(b6.a(), (Object) null, 1, (Object) null);
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: c1.b$a} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(V2.d r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof c1.C1648a.b
            if (r0 == 0) goto L_0x0013
            r0 = r11
            c1.a$b r0 = (c1.C1648a.b) r0
            int r1 = r0.f9667i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f9667i = r1
            goto L_0x0018
        L_0x0013:
            c1.a$b r0 = new c1.a$b
            r0.<init>(r10, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f9665g
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f9667i
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            java.lang.Object r2 = r0.f9664f
            java.lang.Object r5 = r0.f9663e
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r6 = r0.f9662d
            x3.a r6 = (x3.a) r6
            java.lang.Object r7 = r0.f9661c
            c1.b$a r7 = (c1.C1649b.a) r7
            java.lang.Object r8 = r0.f9660b
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.f9659a
            java.util.Map r9 = (java.util.Map) r9
            R2.n.b(r11)
            goto L_0x00a0
        L_0x0040:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0048:
            R2.n.b(r11)
            java.util.Map r11 = f9656b
            java.lang.String r2 = "dependencies"
            kotlin.jvm.internal.m.d(r11, r2)
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            int r5 = r11.size()
            int r5 = S2.H.d(r5)
            r2.<init>(r5)
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
            r8 = r11
            r5 = r2
        L_0x0069:
            boolean r11 = r8.hasNext()
            if (r11 == 0) goto L_0x00b3
            java.lang.Object r11 = r8.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r2 = r11.getKey()
            java.lang.Object r6 = r11.getKey()
            r7 = r6
            c1.b$a r7 = (c1.C1649b.a) r7
            java.lang.Object r11 = r11.getValue()
            c1.a$a r11 = (c1.C1648a.C0161a) r11
            x3.a r6 = r11.a()
            r0.f9659a = r5
            r0.f9660b = r8
            r0.f9661c = r7
            r0.f9662d = r6
            r0.f9663e = r5
            r0.f9664f = r2
            r0.f9667i = r3
            java.lang.Object r11 = r6.c(r4, r0)
            if (r11 != r1) goto L_0x009f
            return r1
        L_0x009f:
            r9 = r5
        L_0x00a0:
            c1.a r11 = f9655a     // Catch:{ all -> 0x00ae }
            c1.b r11 = r11.d(r7)     // Catch:{ all -> 0x00ae }
            r6.d(r4)
            r5.put(r2, r11)
            r5 = r9
            goto L_0x0069
        L_0x00ae:
            r11 = move-exception
            r6.d(r4)
            throw r11
        L_0x00b3:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.C1648a.c(V2.d):java.lang.Object");
    }

    public final C1649b d(C1649b.a aVar) {
        m.e(aVar, "subscriberName");
        C1649b b5 = b(aVar).b();
        if (b5 != null) {
            return b5;
        }
        throw new IllegalStateException("Subscriber " + aVar + " has not been registered.");
    }
}
