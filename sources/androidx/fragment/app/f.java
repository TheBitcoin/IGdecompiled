package androidx.fragment.app;

import androidx.core.util.Consumer;

public final /* synthetic */ class f implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f950a;

    public /* synthetic */ f(FragmentManager fragmentManager) {
        this.f950a = fragmentManager;
    }

    public final void accept(Object obj) {
        FragmentManager.a(this.f950a, (Integer) obj);
    }
}
