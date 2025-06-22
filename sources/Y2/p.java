package y2;

import android.widget.LinearLayout;
import android.widget.PopupWindow;

public final /* synthetic */ class p implements PopupWindow.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q f22825a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearLayout f22826b;

    public /* synthetic */ p(q qVar, LinearLayout linearLayout) {
        this.f22825a = qVar;
        this.f22826b = linearLayout;
    }

    public final void onDismiss() {
        q.e(this.f22825a, this.f22826b);
    }
}
