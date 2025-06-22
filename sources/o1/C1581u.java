package O1;

import android.widget.CompoundButton;
import com.uptodown.core.activities.FileExplorerActivity;

/* renamed from: O1.u  reason: case insensitive filesystem */
public final /* synthetic */ class C1581u implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f7955a;

    public /* synthetic */ C1581u(FileExplorerActivity fileExplorerActivity) {
        this.f7955a = fileExplorerActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        FileExplorerActivity.h4(this.f7955a, compoundButton, z4);
    }
}
