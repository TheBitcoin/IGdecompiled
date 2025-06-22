package J1;

import android.view.ViewTreeObserver;
import com.uptodown.activities.PublicProfileActivity;

public final /* synthetic */ class M3 implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PublicProfileActivity f6833a;

    public /* synthetic */ M3(PublicProfileActivity publicProfileActivity) {
        this.f6833a = publicProfileActivity;
    }

    public final void onScrollChanged() {
        PublicProfileActivity.r3(this.f6833a);
    }
}
