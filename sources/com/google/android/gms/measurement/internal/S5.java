package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

final class S5 implements c6 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ H5 f2748a;

    S5(H5 h5) {
        this.f2748a = h5;
    }

    public final void b(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.f2748a.f().D(new U5(this, str, str2, bundle));
        } else if (this.f2748a.f2548l != null) {
            this.f2748a.f2548l.a().G().b("AppId not known when logging event", str2);
        }
    }
}
