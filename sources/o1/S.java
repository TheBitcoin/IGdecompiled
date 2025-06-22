package O1;

import android.widget.CompoundButton;
import com.uptodown.core.activities.FileExplorerActivity;

public final /* synthetic */ class S implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f7865a;

    public /* synthetic */ S(FileExplorerActivity fileExplorerActivity) {
        this.f7865a = fileExplorerActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        FileExplorerActivity.O3(this.f7865a, compoundButton, z4);
    }
}
