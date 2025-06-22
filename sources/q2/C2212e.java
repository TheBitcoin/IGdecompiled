package q2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.tv.ui.activity.TvMainActivity;

/* renamed from: q2.e  reason: case insensitive filesystem */
public final /* synthetic */ class C2212e implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TvMainActivity f21580a;

    public /* synthetic */ C2212e(TvMainActivity tvMainActivity) {
        this.f21580a = tvMainActivity;
    }

    public final void onActivityResult(Object obj) {
        TvMainActivity.w(this.f21580a, (ActivityResult) obj);
    }
}
