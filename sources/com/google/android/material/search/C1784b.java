package com.google.android.material.search;

/* renamed from: com.google.android.material.search.b  reason: case insensitive filesystem */
public final /* synthetic */ class C1784b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchBar f11028a;

    public /* synthetic */ C1784b(SearchBar searchBar) {
        this.f11028a = searchBar;
    }

    public final void run() {
        this.f11028a.searchBarAnimationHelper.startOnLoadAnimation(this.f11028a);
    }
}
