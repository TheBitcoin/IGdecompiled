package g2;

import android.widget.RelativeLayout;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class a0 {

    /* renamed from: c  reason: collision with root package name */
    public static final a f20531c = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private int f20532a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f20533b;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public final int a() {
        return this.f20532a;
    }

    public final String b() {
        switch (this.f20532a) {
            case 1:
                return "welcome";
            case 2:
                return "deeplink";
            case 3:
                return "continue";
            case 4:
                return "permissions";
            case 5:
                return "login";
            case 6:
                return "kill";
            default:
                return "null";
        }
    }

    public final RelativeLayout c() {
        RelativeLayout relativeLayout = this.f20533b;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        m.u(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        return null;
    }

    public final void d(int i4) {
        this.f20532a = i4;
    }

    public final void e(RelativeLayout relativeLayout) {
        m.e(relativeLayout, "<set-?>");
        this.f20533b = relativeLayout;
    }
}
