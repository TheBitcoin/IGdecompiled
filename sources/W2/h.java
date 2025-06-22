package w2;

import C1.d;
import C1.e;
import D1.a;
import F1.g;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import kotlin.jvm.internal.m;

public final class h extends a {

    /* renamed from: a  reason: collision with root package name */
    private g f22026a;

    /* renamed from: b  reason: collision with root package name */
    private View f22027b;

    /* renamed from: c  reason: collision with root package name */
    private View f22028c;

    /* renamed from: d  reason: collision with root package name */
    private final View f22029d;

    /* renamed from: e  reason: collision with root package name */
    private final ImageView f22030e;

    /* renamed from: f  reason: collision with root package name */
    private final ImageView f22031f;

    public h(View view, e eVar) {
        m.e(view, "customPlayerUi");
        m.e(eVar, "youTubePlayer");
        this.f22028c = view;
        View findViewById = view.findViewById(R.id.v_player_panel_home);
        m.d(findViewById, "findViewById(...)");
        this.f22029d = findViewById;
        View findViewById2 = this.f22028c.findViewById(R.id.iv_player_panel_feature);
        m.d(findViewById2, "findViewById(...)");
        ImageView imageView = (ImageView) findViewById2;
        this.f22030e = imageView;
        View findViewById3 = this.f22028c.findViewById(R.id.iv_player_control);
        m.d(findViewById3, "findViewById(...)");
        this.f22031f = (ImageView) findViewById3;
        g gVar = new g();
        this.f22026a = gVar;
        this.f22027b = view;
        m.b(gVar);
        eVar.d(gVar);
        m(imageView, eVar);
        m(findViewById, eVar);
    }

    private final void m(View view, e eVar) {
        view.setOnClickListener(new g(eVar));
    }

    /* access modifiers changed from: private */
    public static final void n(e eVar, View view) {
        eVar.play();
    }

    public void b(e eVar, d dVar) {
        m.e(eVar, "youTubePlayer");
        m.e(dVar, MRAIDCommunicatorUtil.KEY_STATE);
        super.b(eVar, dVar);
        if (dVar == d.PLAYING) {
            this.f22030e.setVisibility(8);
            this.f22031f.setVisibility(8);
            return;
        }
        this.f22030e.setVisibility(0);
        UptodownApp.a aVar = UptodownApp.f17422D;
        Context context = this.f22028c.getContext();
        m.d(context, "getContext(...)");
        if (!aVar.f(context)) {
            this.f22031f.setVisibility(0);
        }
    }

    public final ImageView l() {
        return this.f22030e;
    }
}
