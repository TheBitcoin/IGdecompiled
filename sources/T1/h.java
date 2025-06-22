package T1;

import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.m;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private String f8311a;

    /* renamed from: b  reason: collision with root package name */
    private String f8312b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8313c;

    /* renamed from: d  reason: collision with root package name */
    private long f8314d;

    public h(String str) {
        m.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        this.f8311a = str;
    }

    public final long a() {
        return this.f8314d;
    }

    public final String b() {
        return this.f8311a;
    }

    public final boolean c() {
        return m.a("mounted", this.f8312b);
    }

    public final boolean d() {
        return this.f8313c;
    }

    public final void e(long j4) {
        this.f8314d = j4;
    }

    public final void f(boolean z4) {
        this.f8313c = z4;
    }

    public final void g(String str) {
        this.f8312b = str;
    }
}
