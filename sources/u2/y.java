package u2;

import android.content.Context;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import com.uptodown.UptodownApp;
import g2.C2033A;
import g2.C2054l;
import kotlin.jvm.internal.m;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public static final y f21955a = new y();

    private y() {
    }

    public final Bundle a(Bundle bundle) {
        String str;
        m.e(bundle, "params");
        z zVar = z.f21956a;
        if (zVar.f()) {
            str = "wifi";
        } else {
            str = "mobile";
        }
        bundle.putString("connectionType", str);
        bundle.putLong("downBandwidthKbps", (long) zVar.a());
        bundle.putLong("upBandwidthKbps", (long) zVar.b());
        return bundle;
    }

    public final Bundle b(Context context, String str, Bundle bundle) {
        m.e(context, "context");
        m.e(str, "packagename");
        m.e(bundle, "bundle");
        UptodownApp.a aVar = UptodownApp.f17422D;
        if (aVar.m() != null) {
            C2054l m4 = aVar.m();
            m.b(m4);
            String i4 = new w().i(m4.c());
            if (i4 != null && m3.m.p(i4, str, true)) {
                bundle.putString("source", "deeplink");
                return bundle;
            }
        } else {
            C2033A b5 = C2033A.f20327f.b(context);
            if (b5 != null && m3.m.p(b5.d(), str, true)) {
                bundle.putString("source", "notification_fcm");
            }
        }
        return bundle;
    }

    public final boolean c(String str) {
        m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
        if (m3.m.p(str, "update", true) || m3.m.p(str, "deeplink", true) || m3.m.p(str, "notification_fcm", true) || m3.m.p(str, "rollback", true)) {
            return true;
        }
        return false;
    }

    public final boolean d(String str) {
        m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
        if (m3.m.p(str, "downBandwidthKbps", true) || m3.m.p(str, "upBandwidthKbps", true) || m3.m.p(str, "speed", true) || m3.m.p(str, TypedValues.TransitionType.S_DURATION, true)) {
            return true;
        }
        return false;
    }

    public final String e(long j4) {
        if (j4 < 10485760) {
            return "<10MB";
        }
        if (j4 < 104857600) {
            return "<100MB";
        }
        if (j4 < 524288000) {
            return "<500MB";
        }
        if (j4 < 1073741824) {
            return "<1GB";
        }
        if (j4 < 10737418240L) {
            return "<10GB";
        }
        return "<10MB";
    }
}
