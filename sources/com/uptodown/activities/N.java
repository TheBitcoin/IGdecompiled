package com.uptodown.activities;

import android.view.View;
import com.uptodown.activities.Updates;
import java.util.ArrayList;

public final /* synthetic */ class N implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArrayList f18010a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Updates f18011b;

    public /* synthetic */ N(ArrayList arrayList, Updates updates) {
        this.f18010a = arrayList;
        this.f18011b = updates;
    }

    public final void onClick(View view) {
        Updates.h.o(this.f18010a, this.f18011b, view);
    }
}
