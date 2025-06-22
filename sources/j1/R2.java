package J1;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.uptodown.activities.NotificationsRegistryActivity;

public final /* synthetic */ class R2 implements Toolbar.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NotificationsRegistryActivity f6866a;

    public /* synthetic */ R2(NotificationsRegistryActivity notificationsRegistryActivity) {
        this.f6866a = notificationsRegistryActivity;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return NotificationsRegistryActivity.y3(this.f6866a, menuItem);
    }
}
