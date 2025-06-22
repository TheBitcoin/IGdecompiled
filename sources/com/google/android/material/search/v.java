package com.google.android.material.search;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class v implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchView f11050a;

    public /* synthetic */ v(SearchView searchView) {
        this.f11050a = searchView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return SearchView.c(this.f11050a, view, motionEvent);
    }
}
