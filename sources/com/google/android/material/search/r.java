package com.google.android.material.search;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

public final /* synthetic */ class r implements OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchView f11047a;

    public /* synthetic */ r(SearchView searchView) {
        this.f11047a = searchView;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return SearchView.h(this.f11047a, view, windowInsetsCompat);
    }
}
