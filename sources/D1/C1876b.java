package d1;

import V2.d;
import android.content.Context;
import android.os.Bundle;
import d1.h;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import n3.c;

/* renamed from: d1.b  reason: case insensitive filesystem */
public final class C1876b implements h {

    /* renamed from: b  reason: collision with root package name */
    private static final a f19524b = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f19525a;

    /* renamed from: d1.b$a */
    private static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public C1876b(Context context) {
        m.e(context, "context");
        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        this.f19525a = bundle == null ? Bundle.EMPTY : bundle;
    }

    public Boolean a() {
        if (this.f19525a.containsKey("firebase_sessions_enabled")) {
            return Boolean.valueOf(this.f19525a.getBoolean("firebase_sessions_enabled"));
        }
        return null;
    }

    public Object b(d dVar) {
        return h.a.a(this, dVar);
    }

    public n3.a c() {
        if (this.f19525a.containsKey("firebase_sessions_sessions_restart_timeout")) {
            return n3.a.c(c.h(this.f19525a.getInt("firebase_sessions_sessions_restart_timeout"), n3.d.SECONDS));
        }
        return null;
    }

    public Double d() {
        if (this.f19525a.containsKey("firebase_sessions_sampling_rate")) {
            return Double.valueOf(this.f19525a.getDouble("firebase_sessions_sampling_rate"));
        }
        return null;
    }
}
