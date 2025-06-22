package J1;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.uptodown.activities.MyDownloads;

public final /* synthetic */ class I2 implements Toolbar.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyDownloads f6793a;

    public /* synthetic */ I2(MyDownloads myDownloads) {
        this.f6793a = myDownloads;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return MyDownloads.o4(this.f6793a, menuItem);
    }
}
