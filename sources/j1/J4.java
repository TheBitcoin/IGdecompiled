package J1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.SearchActivity;

public final /* synthetic */ class J4 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchActivity f6802a;

    public /* synthetic */ J4(SearchActivity searchActivity) {
        this.f6802a = searchActivity;
    }

    public final void onActivityResult(Object obj) {
        SearchActivity.M3(this.f6802a, (ActivityResult) obj);
    }
}
