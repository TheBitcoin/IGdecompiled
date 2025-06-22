package O1;

import android.view.View;
import com.uptodown.core.activities.FileExplorerActivity;
import kotlin.jvm.internal.C;

public final /* synthetic */ class U implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C f7870a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f7871b;

    public /* synthetic */ U(C c5, FileExplorerActivity fileExplorerActivity) {
        this.f7870a = c5;
        this.f7871b = fileExplorerActivity;
    }

    public final void onClick(View view) {
        FileExplorerActivity.Q3(this.f7870a, this.f7871b, view);
    }
}
