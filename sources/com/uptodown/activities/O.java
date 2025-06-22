package com.uptodown.activities;

import android.content.DialogInterface;
import com.uptodown.activities.Updates;

public final /* synthetic */ class O implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Updates f18041a;

    public /* synthetic */ O(Updates updates) {
        this.f18041a = updates;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        Updates.h.p(this.f18041a, dialogInterface);
    }
}
