package J1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.PublicProfileActivity;

public final /* synthetic */ class Q3 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PublicProfileActivity f6862a;

    public /* synthetic */ Q3(PublicProfileActivity publicProfileActivity) {
        this.f6862a = publicProfileActivity;
    }

    public final void onActivityResult(Object obj) {
        PublicProfileActivity.v3(this.f6862a, (ActivityResult) obj);
    }
}
