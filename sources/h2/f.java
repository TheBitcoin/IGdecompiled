package H2;

import android.view.View;
import android.widget.PopupWindow;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PopupWindow f6652a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f6653b;

    public /* synthetic */ f(PopupWindow popupWindow, h hVar) {
        this.f6652a = popupWindow;
        this.f6653b = hVar;
    }

    public final void onClick(View view) {
        h.p(this.f6652a, this.f6653b, view);
    }
}
