package J1;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.uptodown.activities.Updates;

/* renamed from: J1.n5  reason: case insensitive filesystem */
public final /* synthetic */ class C1408n5 implements SwipeRefreshLayout.OnRefreshListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Updates f7088a;

    public /* synthetic */ C1408n5(Updates updates) {
        this.f7088a = updates;
    }

    public final void onRefresh() {
        Updates.D5(this.f7088a);
    }
}
