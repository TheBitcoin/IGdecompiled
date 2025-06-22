package q2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.tv.ui.activity.TvMainActivity;

/* renamed from: q2.d  reason: case insensitive filesystem */
public final /* synthetic */ class C2211d implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TvMainActivity f21579a;

    public /* synthetic */ C2211d(TvMainActivity tvMainActivity) {
        this.f21579a = tvMainActivity;
    }

    public final void onActivityResult(Object obj) {
        TvMainActivity.y(this.f21579a, (ActivityResult) obj);
    }
}
