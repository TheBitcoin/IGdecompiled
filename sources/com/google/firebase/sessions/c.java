package com.google.firebase.sessions;

import b1.J;
import b1.z;
import java.util.Locale;
import java.util.UUID;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import p0.C2191c;
import p0.n;

public final class c {

    /* renamed from: f  reason: collision with root package name */
    public static final b f11449f = new b((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final J f11450a;

    /* renamed from: b  reason: collision with root package name */
    private final d3.a f11451b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11452c;

    /* renamed from: d  reason: collision with root package name */
    private int f11453d;

    /* renamed from: e  reason: collision with root package name */
    private z f11454e;

    /* synthetic */ class a extends k implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f11455a = new a();

        a() {
            super(0, UUID.class, "randomUUID", "randomUUID()Ljava/util/UUID;", 0);
        }

        /* renamed from: d */
        public final UUID invoke() {
            return UUID.randomUUID();
        }
    }

    public static final class b {
        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        public final c a() {
            Object j4 = n.a(C2191c.f21433a).j(c.class);
            m.d(j4, "Firebase.app[SessionGenerator::class.java]");
            return (c) j4;
        }

        private b() {
        }
    }

    public c(J j4, d3.a aVar) {
        m.e(j4, "timeProvider");
        m.e(aVar, "uuidGenerator");
        this.f11450a = j4;
        this.f11451b = aVar;
        this.f11452c = b();
        this.f11453d = -1;
    }

    private final String b() {
        String uuid = ((UUID) this.f11451b.invoke()).toString();
        m.d(uuid, "uuidGenerator().toString()");
        String lowerCase = m3.m.w(uuid, "-", "", false, 4, (Object) null).toLowerCase(Locale.ROOT);
        m.d(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    public final z a() {
        String b5;
        int i4 = this.f11453d + 1;
        this.f11453d = i4;
        if (i4 == 0) {
            b5 = this.f11452c;
        } else {
            b5 = b();
        }
        this.f11454e = new z(b5, this.f11452c, this.f11453d, this.f11450a.a());
        return c();
    }

    public final z c() {
        z zVar = this.f11454e;
        if (zVar != null) {
            return zVar;
        }
        m.u("currentSession");
        return null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(J j4, d3.a aVar, int i4, C2103g gVar) {
        this(j4, (i4 & 2) != 0 ? a.f11455a : aVar);
    }
}
