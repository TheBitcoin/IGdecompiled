package J1;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.uptodown.activities.MyApps;

public final /* synthetic */ class O1 implements Toolbar.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyApps f6845a;

    public /* synthetic */ O1(MyApps myApps) {
        this.f6845a = myApps;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return MyApps.g5(this.f6845a, menuItem);
    }
}
