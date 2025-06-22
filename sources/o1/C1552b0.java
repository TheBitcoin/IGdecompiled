package O1;

import android.widget.CompoundButton;
import com.uptodown.core.activities.FileExplorerActivity;

/* renamed from: O1.b0  reason: case insensitive filesystem */
public final /* synthetic */ class C1552b0 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f7879a;

    public /* synthetic */ C1552b0(FileExplorerActivity fileExplorerActivity) {
        this.f7879a = fileExplorerActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        FileExplorerActivity.Z3(this.f7879a, compoundButton, z4);
    }
}
