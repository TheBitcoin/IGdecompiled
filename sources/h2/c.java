package H2;

import android.view.View;
import android.widget.PopupWindow;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PopupWindow f6646a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f6647b;

    public /* synthetic */ c(PopupWindow popupWindow, h hVar) {
        this.f6646a = popupWindow;
        this.f6647b = hVar;
    }

    public final void onClick(View view) {
        h.l(this.f6646a, this.f6647b, view);
    }
}
