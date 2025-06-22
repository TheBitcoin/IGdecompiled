package com.google.android.material.textfield;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClearTextEndIconDelegate f11074a;

    public /* synthetic */ d(ClearTextEndIconDelegate clearTextEndIconDelegate) {
        this.f11074a = clearTextEndIconDelegate;
    }

    public final void run() {
        this.f11074a.animateIcon(true);
    }
}
