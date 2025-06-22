package androidx.core.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* renamed from: androidx.core.view.w  reason: case insensitive filesystem */
public final /* synthetic */ class C0478w implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MenuHostHelper f925a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MenuProvider f926b;

    public /* synthetic */ C0478w(MenuHostHelper menuHostHelper, MenuProvider menuProvider) {
        this.f925a = menuHostHelper;
        this.f926b = menuProvider;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        MenuHostHelper.b(this.f925a, this.f926b, lifecycleOwner, event);
    }
}
