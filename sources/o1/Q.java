package O1;

import android.widget.CompoundButton;
import com.uptodown.core.activities.FileExplorerActivity;
import kotlin.jvm.internal.C;

public final /* synthetic */ class Q implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f7863a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C f7864b;

    public /* synthetic */ Q(FileExplorerActivity fileExplorerActivity, C c5) {
        this.f7863a = fileExplorerActivity;
        this.f7864b = c5;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        FileExplorerActivity.N3(this.f7863a, this.f7864b, compoundButton, z4);
    }
}
