package com.google.android.material.search;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

public final /* synthetic */ class o implements OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup.MarginLayoutParams f11042a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f11043b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f11044c;

    public /* synthetic */ o(ViewGroup.MarginLayoutParams marginLayoutParams, int i4, int i5) {
        this.f11042a = marginLayoutParams;
        this.f11043b = i4;
        this.f11044c = i5;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return SearchView.b(this.f11042a, this.f11043b, this.f11044c, view, windowInsetsCompat);
    }
}
