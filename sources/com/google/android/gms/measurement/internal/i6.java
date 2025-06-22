package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.mbridge.msdk.MBridgeConstans;

public final class i6 {

    /* renamed from: a  reason: collision with root package name */
    private final S2 f3032a;

    public i6(S2 s22) {
        this.f3032a = s22;
    }

    private final boolean d() {
        if (this.f3032a.F().f3341z.a() > 0) {
            return true;
        }
        return false;
    }

    private final boolean e() {
        if (d() && this.f3032a.B().currentTimeMillis() - this.f3032a.F().f3341z.a() > this.f3032a.w().x((String) null, G.f2448W)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        String str;
        this.f3032a.f().k();
        if (d()) {
            if (e()) {
                this.f3032a.F().f3340y.b((String) null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1);
                this.f3032a.H().b1("auto", "_cmpx", bundle);
            } else {
                String a5 = this.f3032a.F().f3340y.a();
                if (TextUtils.isEmpty(a5)) {
                    this.f3032a.a().I().a("Cache still valid but referrer not found");
                } else {
                    long a6 = ((this.f3032a.F().f3341z.a() / 3600000) - 1) * 3600000;
                    Uri parse = Uri.parse(a5);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(parse.getPath(), bundle2);
                    for (String next : parse.getQueryParameterNames()) {
                        bundle2.putString(next, parse.getQueryParameter(next));
                    }
                    ((Bundle) pair.second).putLong("_cc", a6);
                    Object obj = pair.first;
                    if (obj == null) {
                        str = MBridgeConstans.DYNAMIC_VIEW_WX_APP;
                    } else {
                        str = (String) obj;
                    }
                    this.f3032a.H().b1(str, "_cmp", (Bundle) pair.second);
                }
                this.f3032a.F().f3340y.b((String) null);
            }
            this.f3032a.F().f3341z.b(0);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(String str, Bundle bundle) {
        String str2;
        this.f3032a.f().k();
        if (!this.f3032a.m()) {
            if (bundle == null || bundle.isEmpty()) {
                str2 = null;
            } else {
                if (str == null || str.isEmpty()) {
                    str = "auto";
                }
                Uri.Builder builder = new Uri.Builder();
                builder.path(str);
                for (String next : bundle.keySet()) {
                    builder.appendQueryParameter(next, bundle.getString(next));
                }
                str2 = builder.build().toString();
            }
            if (!TextUtils.isEmpty(str2)) {
                this.f3032a.F().f3340y.b(str2);
                this.f3032a.F().f3341z.b(this.f3032a.B().currentTimeMillis());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        if (d() && e()) {
            this.f3032a.F().f3340y.b((String) null);
        }
    }
}
