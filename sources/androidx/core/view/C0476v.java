package androidx.core.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* renamed from: androidx.core.view.v  reason: case insensitive filesystem */
public final /* synthetic */ class C0476v implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MenuHostHelper f922a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Lifecycle.State f923b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuProvider f924c;

    public /* synthetic */ C0476v(MenuHostHelper menuHostHelper, Lifecycle.State state, MenuProvider menuProvider) {
        this.f922a = menuHostHelper;
        this.f923b = state;
        this.f924c = menuProvider;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        MenuHostHelper.a(this.f922a, this.f923b, this.f924c, lifecycleOwner, event);
    }
}
