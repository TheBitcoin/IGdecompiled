package t2;

import N1.k;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.leanback.widget.Presenter;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import kotlin.jvm.internal.m;
import n2.b;

/* renamed from: t2.f  reason: case insensitive filesystem */
public final class C2298f extends Presenter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f21842a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f21843b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2298f(View view) {
        super(view);
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        View findViewById = view.findViewById(R.id.iv_icon);
        m.d(findViewById, "findViewById(...)");
        this.f21842a = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_name);
        m.d(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.f21843b = textView;
        textView.setTypeface(k.f7778g.w());
    }

    public final void a(b bVar) {
        m.e(bVar, "tvManageAppsItem");
        this.f21843b.setText(bVar.c());
        this.f21842a.setImageResource(bVar.a());
    }
}
