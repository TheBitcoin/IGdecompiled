package com.google.android.material.search;

public final /* synthetic */ class C implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchView f11026a;

    public /* synthetic */ C(SearchView searchView) {
        this.f11026a = searchView;
    }

    public final void run() {
        this.f11026a.requestFocusAndShowKeyboardIfNeeded();
    }
}
