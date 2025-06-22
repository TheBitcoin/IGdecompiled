package t2;

import android.view.View;
import android.widget.ImageView;
import androidx.leanback.widget.Presenter;
import com.mbridge.msdk.MBridgeConstans;
import com.squareup.picasso.s;
import com.uptodown.R;
import g2.C2050h;
import kotlin.jvm.internal.m;

public final class i extends Presenter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f21855a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(View view) {
        super(view);
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        View findViewById = view.findViewById(R.id.iv_feature_program_day);
        m.d(findViewById, "findViewById(...)");
        this.f21855a = (ImageView) findViewById;
    }

    public final void a(C2050h hVar) {
        m.e(hVar, "appInfo");
        s.h().l(hVar.y()).i(this.f21855a);
    }
}
