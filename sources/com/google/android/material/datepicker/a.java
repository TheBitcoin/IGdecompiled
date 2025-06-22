package com.google.android.material.datepicker;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DateFormatTextWatcher f11008a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f11009b;

    public /* synthetic */ a(DateFormatTextWatcher dateFormatTextWatcher, String str) {
        this.f11008a = dateFormatTextWatcher;
        this.f11009b = str;
    }

    public final void run() {
        DateFormatTextWatcher.b(this.f11008a, this.f11009b);
    }
}
