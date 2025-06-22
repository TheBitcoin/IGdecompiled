package H2;

import android.view.View;
import android.widget.PopupWindow;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PopupWindow f6650a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f6651b;

    public /* synthetic */ e(PopupWindow popupWindow, h hVar) {
        this.f6650a = popupWindow;
        this.f6651b = hVar;
    }

    public final void onClick(View view) {
        h.n(this.f6650a, this.f6651b, view);
    }
}
