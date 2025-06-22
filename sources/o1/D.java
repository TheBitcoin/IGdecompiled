package O1;

import android.widget.CompoundButton;
import com.uptodown.core.activities.FileExplorerActivity;

public final /* synthetic */ class D implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f7823a;

    public /* synthetic */ D(FileExplorerActivity fileExplorerActivity) {
        this.f7823a = fileExplorerActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        FileExplorerActivity.l4(this.f7823a, compoundButton, z4);
    }
}
