package com.google.android.material.search;

import android.view.View;
import com.google.android.material.appbar.AppBarLayout;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchBarAnimationHelper f11032a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchBar f11033b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f11034c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f11035d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f11036e;

    public /* synthetic */ g(SearchBarAnimationHelper searchBarAnimationHelper, SearchBar searchBar, View view, AppBarLayout appBarLayout, boolean z4) {
        this.f11032a = searchBarAnimationHelper;
        this.f11033b = searchBar;
        this.f11034c = view;
        this.f11035d = appBarLayout;
        this.f11036e = z4;
    }

    public final void run() {
        SearchBarAnimationHelper.b(this.f11032a, this.f11033b, this.f11034c, this.f11035d, this.f11036e);
    }
}
