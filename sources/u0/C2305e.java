package u0;

import android.os.Bundle;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.Locale;
import q0.C2204a;
import v0.g;
import w0.b;

/* renamed from: u0.e  reason: case insensitive filesystem */
class C2305e implements C2204a.b {

    /* renamed from: a  reason: collision with root package name */
    private b f21863a;

    /* renamed from: b  reason: collision with root package name */
    private b f21864b;

    C2305e() {
    }

    private static void b(b bVar, String str, Bundle bundle) {
        if (bVar != null) {
            bVar.j(str, bundle);
        }
    }

    private void c(String str, Bundle bundle) {
        b bVar;
        if ("clx".equals(bundle.getString("_o"))) {
            bVar = this.f21863a;
        } else {
            bVar = this.f21864b;
        }
        b(bVar, str, bundle);
    }

    public void a(int i4, Bundle bundle) {
        String string;
        g.f().i(String.format(Locale.US, "Analytics listener received message. ID: %d, Extras: %s", new Object[]{Integer.valueOf(i4), bundle}));
        if (bundle != null && (string = bundle.getString(RewardPlus.NAME)) != null) {
            Bundle bundle2 = bundle.getBundle("params");
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            c(string, bundle2);
        }
    }

    public void d(b bVar) {
        this.f21864b = bVar;
    }

    public void e(b bVar) {
        this.f21863a = bVar;
    }
}
