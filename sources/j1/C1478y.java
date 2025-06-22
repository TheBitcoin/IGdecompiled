package J1;

import android.view.View;
import android.view.ViewTreeObserver;
import com.uptodown.activities.C1826a;

/* renamed from: J1.y  reason: case insensitive filesystem */
public final /* synthetic */ class C1478y implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f7215a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C1826a f7216b;

    public /* synthetic */ C1478y(View view, C1826a aVar) {
        this.f7215a = view;
        this.f7216b = aVar;
    }

    public final void onScrollChanged() {
        C1826a.p2(this.f7215a, this.f7216b);
    }
}
