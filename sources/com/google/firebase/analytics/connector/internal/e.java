package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import e0.a;

final class e implements a.C0029a {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ f f11116a;

    public e(f fVar) {
        this.f11116a = fVar;
    }

    public final void a(String str, String str2, Bundle bundle, long j4) {
        if (str != null && a.f(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(RewardPlus.NAME, str2);
            bundle2.putLong("timestampInMillis", j4);
            bundle2.putBundle("params", bundle);
            this.f11116a.f11117a.a(3, bundle2);
        }
    }
}
