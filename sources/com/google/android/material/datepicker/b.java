package com.google.android.material.datepicker;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DateFormatTextWatcher f11010a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f11011b;

    public /* synthetic */ b(DateFormatTextWatcher dateFormatTextWatcher, long j4) {
        this.f11010a = dateFormatTextWatcher;
        this.f11011b = j4;
    }

    public final void run() {
        DateFormatTextWatcher.a(this.f11010a, this.f11011b);
    }
}
