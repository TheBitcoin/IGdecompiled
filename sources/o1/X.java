package O1;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.uptodown.core.activities.FileExplorerActivity;

public final /* synthetic */ class X implements Toolbar.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f7874a;

    public /* synthetic */ X(FileExplorerActivity fileExplorerActivity) {
        this.f7874a = fileExplorerActivity;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return FileExplorerActivity.o4(this.f7874a, menuItem);
    }
}
