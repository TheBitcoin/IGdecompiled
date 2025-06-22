package q2;

import androidx.fragment.app.Fragment;
import com.uptodown.tv.ui.activity.TvAppDetailActivity;

/* renamed from: q2.a  reason: case insensitive filesystem */
public final /* synthetic */ class C2208a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Fragment f21574a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TvAppDetailActivity.c f21575b;

    public /* synthetic */ C2208a(Fragment fragment, TvAppDetailActivity.c cVar) {
        this.f21574a = fragment;
        this.f21575b = cVar;
    }

    public final void run() {
        TvAppDetailActivity.c.b(this.f21574a, this.f21575b);
    }
}
