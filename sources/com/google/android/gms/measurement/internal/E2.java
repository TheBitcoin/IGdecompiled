package com.google.android.gms.measurement.internal;

import T.d;
import T.e;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.C0534d0;
import com.mbridge.msdk.foundation.entity.CampaignEx;

public final class E2 {

    /* renamed from: a  reason: collision with root package name */
    final S2 f2370a;

    E2(H5 h5) {
        this.f2370a = h5.t0();
    }

    /* access modifiers changed from: package-private */
    public final Bundle a(String str, C0534d0 d0Var) {
        this.f2370a.f().k();
        if (d0Var == null) {
            this.f2370a.a().L().a("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(CampaignEx.JSON_KEY_PACKAGE_NAME, str);
        try {
            Bundle f4 = d0Var.f(bundle);
            if (f4 != null) {
                return f4;
            }
            this.f2370a.a().G().a("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e5) {
            this.f2370a.a().G().b("Exception occurred while retrieving the Install Referrer", e5.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        try {
            d a5 = e.a(this.f2370a.A());
            if (a5 == null) {
                this.f2370a.a().K().a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
                return false;
            } else if (a5.e("com.android.vending", 128).versionCode >= 80837300) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e5) {
            this.f2370a.a().K().b("Failed to retrieve Play Store version for Install Referrer", e5);
            return false;
        }
    }
}
