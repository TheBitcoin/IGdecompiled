package g2;

import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.uptodown.UptodownApp;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class M {

    /* renamed from: e  reason: collision with root package name */
    public static final a f20408e = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f20409a;

    /* renamed from: b  reason: collision with root package name */
    private final String f20410b;

    /* renamed from: c  reason: collision with root package name */
    private int f20411c = -1;

    /* renamed from: d  reason: collision with root package name */
    private long f20412d = System.currentTimeMillis();

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public M(String str, String str2) {
        m.e(str, "type");
        m.e(str2, "json");
        this.f20409a = str;
        this.f20410b = str2;
    }

    private final int f() {
        if (UptodownApp.f17422D.K()) {
            return MBridgeCommon.DEFAULT_LOAD_TIMEOUT;
        }
        if (m3.m.p(this.f20409a, "new_releases", true) || m3.m.p(this.f20409a, "last_updates", true)) {
            return 600000;
        }
        return 1800000;
    }

    public final boolean a() {
        if (System.currentTimeMillis() - this.f20412d < ((long) f())) {
            return true;
        }
        return false;
    }

    public final String b() {
        return this.f20410b;
    }

    public final L c() {
        L l4 = new L();
        l4.i(this.f20410b);
        l4.k(200);
        l4.j(new JSONObject(this.f20410b));
        return l4;
    }

    public final long d() {
        return this.f20412d;
    }

    public final String e() {
        return this.f20409a;
    }

    public final void g(int i4) {
        this.f20411c = i4;
    }

    public final void h(long j4) {
        this.f20412d = j4;
    }
}
