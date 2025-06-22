package J1;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.uptodown.activities.MainActivity;

/* renamed from: J1.e1  reason: case insensitive filesystem */
public final /* synthetic */ class C1341e1 implements TabLayoutMediator.TabConfigurationStrategy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MainActivity f6998a;

    public /* synthetic */ C1341e1(MainActivity mainActivity) {
        this.f6998a = mainActivity;
    }

    public final void onConfigureTab(TabLayout.Tab tab, int i4) {
        MainActivity.j7(this.f6998a, tab, i4);
    }
}
