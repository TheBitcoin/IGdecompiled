package androidx.fragment.app;

import androidx.core.util.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f947a;

    public /* synthetic */ c(FragmentActivity fragmentActivity) {
        this.f947a = fragmentActivity;
    }

    public final void accept(Object obj) {
        this.f947a.mFragments.noteStateNotSaved();
    }
}
