package O1;

import android.widget.CompoundButton;
import com.uptodown.core.activities.FileExplorerActivity;

/* renamed from: O1.t  reason: case insensitive filesystem */
public final /* synthetic */ class C1580t implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f7949a;

    public /* synthetic */ C1580t(FileExplorerActivity fileExplorerActivity) {
        this.f7949a = fileExplorerActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        FileExplorerActivity.d4(this.f7949a, compoundButton, z4);
    }
}
