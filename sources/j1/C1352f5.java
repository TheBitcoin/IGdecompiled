package J1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.Updates;

/* renamed from: J1.f5  reason: case insensitive filesystem */
public final /* synthetic */ class C1352f5 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Updates f7011a;

    public /* synthetic */ C1352f5(Updates updates) {
        this.f7011a = updates;
    }

    public final void onActivityResult(Object obj) {
        Updates.r5(this.f7011a, (ActivityResult) obj);
    }
}
