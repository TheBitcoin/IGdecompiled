package M;

import android.content.ComponentName;
import android.net.Uri;

public final class l0 {

    /* renamed from: f  reason: collision with root package name */
    private static final Uri f546f = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* renamed from: a  reason: collision with root package name */
    private final String f547a;

    /* renamed from: b  reason: collision with root package name */
    private final String f548b;

    /* renamed from: c  reason: collision with root package name */
    private final ComponentName f549c = null;

    /* renamed from: d  reason: collision with root package name */
    private final int f550d = 4225;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f551e;

    public l0(String str, String str2, int i4, boolean z4) {
        C0335p.f(str);
        this.f547a = str;
        C0335p.f(str2);
        this.f548b = str2;
        this.f551e = z4;
    }

    public final ComponentName a() {
        return this.f549c;
    }

    /* JADX WARNING: type inference failed for: r6v10, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.content.Intent b(android.content.Context r6) {
        /*
            r5 = this;
            java.lang.String r0 = "ConnectionStatusConfig"
            java.lang.String r1 = r5.f547a
            if (r1 == 0) goto L_0x0061
            boolean r1 = r5.f551e
            r2 = 0
            if (r1 == 0) goto L_0x0050
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r3 = r5.f547a
            java.lang.String r4 = "serviceActionBundleKey"
            r1.putString(r4, r3)
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ IllegalArgumentException -> 0x0024 }
            android.net.Uri r3 = f546f     // Catch:{ IllegalArgumentException -> 0x0024 }
            java.lang.String r4 = "serviceIntentCall"
            android.os.Bundle r6 = r6.call(r3, r4, r2, r1)     // Catch:{ IllegalArgumentException -> 0x0024 }
            goto L_0x0033
        L_0x0024:
            r6 = move-exception
            java.lang.String r1 = "Dynamic intent resolution failed: "
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r1.concat(r6)
            android.util.Log.w(r0, r6)
            r6 = r2
        L_0x0033:
            if (r6 != 0) goto L_0x0036
            goto L_0x003f
        L_0x0036:
            java.lang.String r1 = "serviceResponseIntentKey"
            android.os.Parcelable r6 = r6.getParcelable(r1)
            r2 = r6
            android.content.Intent r2 = (android.content.Intent) r2
        L_0x003f:
            if (r2 != 0) goto L_0x0050
            java.lang.String r6 = r5.f547a
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r1 = "Dynamic lookup for intent failed for action: "
            java.lang.String r6 = r1.concat(r6)
            android.util.Log.w(r0, r6)
        L_0x0050:
            if (r2 != 0) goto L_0x0060
            java.lang.String r6 = r5.f547a
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r6)
            java.lang.String r6 = r5.f548b
            android.content.Intent r6 = r0.setPackage(r6)
            return r6
        L_0x0060:
            return r2
        L_0x0061:
            android.content.Intent r6 = new android.content.Intent
            r6.<init>()
            android.content.ComponentName r0 = r5.f549c
            android.content.Intent r6 = r6.setComponent(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: M.l0.b(android.content.Context):android.content.Intent");
    }

    public final String c() {
        return this.f548b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        if (!C0333n.a(this.f547a, l0Var.f547a) || !C0333n.a(this.f548b, l0Var.f548b) || !C0333n.a(this.f549c, l0Var.f549c) || this.f551e != l0Var.f551e) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return C0333n.b(this.f547a, this.f548b, this.f549c, 4225, Boolean.valueOf(this.f551e));
    }

    public final String toString() {
        String str = this.f547a;
        if (str != null) {
            return str;
        }
        C0335p.l(this.f549c);
        return this.f549c.flattenToString();
    }
}
