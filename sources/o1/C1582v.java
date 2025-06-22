package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.core.activities.FileExplorerActivity;

/* renamed from: O1.v  reason: case insensitive filesystem */
public final /* synthetic */ class C1582v implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f7957a;

    public /* synthetic */ C1582v(FileExplorerActivity fileExplorerActivity) {
        this.f7957a = fileExplorerActivity;
    }

    public final void onActivityResult(Object obj) {
        FileExplorerActivity.x4(this.f7957a, (ActivityResult) obj);
    }
}
