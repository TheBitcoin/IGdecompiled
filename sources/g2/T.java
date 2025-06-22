package g2;

import android.content.Context;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class T {

    /* renamed from: c  reason: collision with root package name */
    public static final a f20465c = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private long f20466a;

    /* renamed from: b  reason: collision with root package name */
    private long f20467b;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final T a(Context context) {
            m.e(context, "context");
            return com.uptodown.activities.preferences.a.f18818a.G(context);
        }

        private a() {
        }
    }

    public T(long j4, long j5) {
        this.f20466a = j4;
        this.f20467b = j5;
    }

    public final long a(Context context) {
        m.e(context, "context");
        if (System.currentTimeMillis() - this.f20467b > 2592000000L) {
            this.f20466a = 0;
            this.f20467b = System.currentTimeMillis();
            com.uptodown.activities.preferences.a.f18818a.q0(context, this);
        }
        return 209715200 - this.f20466a;
    }

    public final long b() {
        return this.f20466a;
    }

    public final long c() {
        return this.f20467b;
    }

    public final void d(Context context) {
        m.e(context, "context");
        com.uptodown.activities.preferences.a.f18818a.q0(context, this);
    }

    public final void e(long j4) {
        this.f20466a = j4;
    }
}
