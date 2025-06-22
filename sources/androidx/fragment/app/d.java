package androidx.fragment.app;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;

public final /* synthetic */ class d implements OnContextAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f948a;

    public /* synthetic */ d(FragmentActivity fragmentActivity) {
        this.f948a = fragmentActivity;
    }

    public final void onContextAvailable(Context context) {
        this.f948a.mFragments.attachHost((Fragment) null);
    }
}
