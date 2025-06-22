package com.google.android.material.carousel;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f10942a;

    public /* synthetic */ a(CarouselLayoutManager carouselLayoutManager) {
        this.f10942a = carouselLayoutManager;
    }

    public final void run() {
        this.f10942a.refreshKeylineState();
    }
}
