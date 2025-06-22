package androidx.fragment.app;

import android.content.res.Configuration;
import androidx.core.util.Consumer;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f949a;

    public /* synthetic */ e(FragmentManager fragmentManager) {
        this.f949a = fragmentManager;
    }

    public final void accept(Object obj) {
        FragmentManager.e(this.f949a, (Configuration) obj);
    }
}
