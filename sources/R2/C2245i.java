package r2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;

/* renamed from: r2.i  reason: case insensitive filesystem */
public final /* synthetic */ class C2245i implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TvAppDetailFragment f21642a;

    public /* synthetic */ C2245i(TvAppDetailFragment tvAppDetailFragment) {
        this.f21642a = tvAppDetailFragment;
    }

    public final void onActivityResult(Object obj) {
        TvAppDetailFragment.l0(this.f21642a, (ActivityResult) obj);
    }
}
