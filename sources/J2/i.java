package J2;

import H2.h;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.m;

public final class i extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f7261a;

    public i(f fVar) {
        this.f7261a = fVar;
    }

    public void onClick(View view) {
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        FragmentActivity activity = this.f7261a.getActivity();
        if (activity != null) {
            activity.getSupportFragmentManager().beginTransaction().add((Fragment) new B2.i(), B2.i.f6184F).add((Fragment) new h(), h.f6663r).commit();
        }
    }
}
