package G;

import J.C0313l;
import M.C0326g;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public final class i extends C0326g {

    /* renamed from: I  reason: collision with root package name */
    private final GoogleSignInOptions f216I;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public i(android.content.Context r8, android.os.Looper r9, M.C0323d r10, com.google.android.gms.auth.api.signin.GoogleSignInOptions r11, K.f.a r12, K.f.b r13) {
        /*
            r7 = this;
            r3 = 91
            r0 = r7
            r1 = r8
            r2 = r9
            r4 = r10
            r5 = r12
            r6 = r13
            r0.<init>((android.content.Context) r1, (android.os.Looper) r2, (int) r3, (M.C0323d) r4, (K.f.a) r5, (K.f.b) r6)
            if (r11 == 0) goto L_0x0013
            com.google.android.gms.auth.api.signin.GoogleSignInOptions$a r8 = new com.google.android.gms.auth.api.signin.GoogleSignInOptions$a
            r8.<init>(r11)
            goto L_0x0018
        L_0x0013:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions$a r8 = new com.google.android.gms.auth.api.signin.GoogleSignInOptions$a
            r8.<init>()
        L_0x0018:
            java.lang.String r9 = Y.b.a()
            r8.g(r9)
            java.util.Set r9 = r4.d()
            boolean r9 = r9.isEmpty()
            if (r9 != 0) goto L_0x0044
            java.util.Set r9 = r4.d()
            java.util.Iterator r9 = r9.iterator()
        L_0x0031:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0044
            java.lang.Object r10 = r9.next()
            com.google.android.gms.common.api.Scope r10 = (com.google.android.gms.common.api.Scope) r10
            r11 = 0
            com.google.android.gms.common.api.Scope[] r11 = new com.google.android.gms.common.api.Scope[r11]
            r8.f(r10, r11)
            goto L_0x0031
        L_0x0044:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r8 = r8.a()
            r0.f216I = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: G.i.<init>(android.content.Context, android.os.Looper, M.d, com.google.android.gms.auth.api.signin.GoogleSignInOptions, K.f$a, K.f$b):void");
    }

    /* access modifiers changed from: protected */
    public final String E() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    /* access modifiers changed from: protected */
    public final String F() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    public final int l() {
        return C0313l.f342a;
    }

    public final GoogleSignInOptions m0() {
        return this.f216I;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface s(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        if (queryLocalInterface instanceof u) {
            return (u) queryLocalInterface;
        }
        return new u(iBinder);
    }
}
