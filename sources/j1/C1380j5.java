package J1;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.uptodown.activities.Updates;

/* renamed from: J1.j5  reason: case insensitive filesystem */
public final /* synthetic */ class C1380j5 implements Toolbar.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Updates f7049a;

    public /* synthetic */ C1380j5(Updates updates) {
        this.f7049a = updates;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return Updates.z5(this.f7049a, menuItem);
    }
}
