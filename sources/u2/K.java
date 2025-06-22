package u2;

import android.content.Context;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.out.MBridgeSDKFactory;
import com.mbridge.msdk.out.SDKInitStatusListener;
import com.mbridge.msdk.system.MBridgeSDKImpl;
import g2.U;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class K {

    /* renamed from: a  reason: collision with root package name */
    public static final a f21897a = new a((C2103g) null);

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    private final void c(MBridgeSDK mBridgeSDK, Context context) {
        mBridgeSDK.init(mBridgeSDK.getMBConfigurationMap("288115", "7e5347690cfae30d311f1b31465c33f6"), context, (SDKInitStatusListener) new b());
    }

    public final void a(Context context, boolean z4) {
        m.e(context, "context");
        MBridgeSDKImpl mBridgeSDK = MBridgeSDKFactory.getMBridgeSDK();
        m.d(mBridgeSDK, "getMBridgeSDK(...)");
        mBridgeSDK.setConsentStatus(context, z4 ? 1 : 0);
    }

    public final void b(boolean z4) {
        MBridgeSDKImpl mBridgeSDK = MBridgeSDKFactory.getMBridgeSDK();
        m.d(mBridgeSDK, "getMBridgeSDK(...)");
        mBridgeSDK.setDoNotTrackStatus(z4);
    }

    public final void d(Context context) {
        m.e(context, "context");
        U e5 = U.f20468m.e(context);
        if (e5 == null || !e5.n()) {
            MBridgeSDKImpl mBridgeSDK = MBridgeSDKFactory.getMBridgeSDK();
            m.d(mBridgeSDK, "getMBridgeSDK(...)");
            c(mBridgeSDK, context);
        }
    }

    public static final class b implements SDKInitStatusListener {
        b() {
        }

        public void onInitFail(String str) {
            m.e(str, "errorMsg");
        }

        public void onInitSuccess() {
        }
    }
}
