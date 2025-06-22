package H2;

import android.view.View;
import android.widget.PopupWindow;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PopupWindow f6648a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f6649b;

    public /* synthetic */ d(PopupWindow popupWindow, h hVar) {
        this.f6648a = popupWindow;
        this.f6649b = hVar;
    }

    public final void onClick(View view) {
        h.m(this.f6648a, this.f6649b, view);
    }
}
