package com.uptodown.activities;

import android.view.View;
import com.uptodown.activities.MyApps;
import java.util.ArrayList;

/* renamed from: com.uptodown.activities.q  reason: case insensitive filesystem */
public final /* synthetic */ class C1842q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArrayList f18819a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MyApps f18820b;

    public /* synthetic */ C1842q(ArrayList arrayList, MyApps myApps) {
        this.f18819a = arrayList;
        this.f18820b = myApps;
    }

    public final void onClick(View view) {
        MyApps.f.n(this.f18819a, this.f18820b, view);
    }
}
