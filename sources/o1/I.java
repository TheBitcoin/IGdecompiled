package O1;

import android.view.View;
import com.uptodown.core.activities.FileExplorerActivity;
import kotlin.jvm.internal.C;

public final /* synthetic */ class I implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C f7841a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f7842b;

    public /* synthetic */ I(C c5, FileExplorerActivity fileExplorerActivity) {
        this.f7841a = c5;
        this.f7842b = fileExplorerActivity;
    }

    public final void onClick(View view) {
        FileExplorerActivity.H3(this.f7841a, this.f7842b, view);
    }
}
