package androidx.fragment.app;

import androidx.core.util.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f946a;

    public /* synthetic */ b(FragmentActivity fragmentActivity) {
        this.f946a = fragmentActivity;
    }

    public final void accept(Object obj) {
        this.f946a.mFragments.noteStateNotSaved();
    }
}
