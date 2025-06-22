package com.google.android.gms.auth.api.signin;

import F.b;
import G.o;
import M.C0321b;
import M.C0335p;
import android.content.Context;
import android.content.Intent;
import k0.C0937l;
import k0.C0940o;

public abstract class a {
    public static b a(Context context, GoogleSignInOptions googleSignInOptions) {
        return new b(context, (GoogleSignInOptions) C0335p.l(googleSignInOptions));
    }

    public static C0937l b(Intent intent) {
        b d5 = o.d(intent);
        GoogleSignInAccount a5 = d5.a();
        if (!d5.getStatus().k() || a5 == null) {
            return C0940o.d(C0321b.a(d5.getStatus()));
        }
        return C0940o.e(a5);
    }
}
