package com.google.android.gms.auth.api.signin;

import android.os.Parcelable;

public final class e implements Parcelable.Creator {
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r15) {
        /*
            r14 = this;
            int r0 = N.b.u(r15)
            r1 = 0
            r2 = 0
            r5 = r1
            r6 = r5
            r10 = r6
            r11 = r10
            r12 = r11
            r13 = r12
            r4 = 0
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x0010:
            int r1 = r15.dataPosition()
            if (r1 >= r0) goto L_0x0060
            int r1 = N.b.n(r15)
            int r2 = N.b.i(r1)
            switch(r2) {
                case 1: goto L_0x005b;
                case 2: goto L_0x0054;
                case 3: goto L_0x004a;
                case 4: goto L_0x0045;
                case 5: goto L_0x0040;
                case 6: goto L_0x003b;
                case 7: goto L_0x0036;
                case 8: goto L_0x0031;
                case 9: goto L_0x002a;
                case 10: goto L_0x0025;
                default: goto L_0x0021;
            }
        L_0x0021:
            N.b.t(r15, r1)
            goto L_0x0010
        L_0x0025:
            java.lang.String r13 = N.b.d(r15, r1)
            goto L_0x0010
        L_0x002a:
            android.os.Parcelable$Creator<G.a> r2 = G.a.CREATOR
            java.util.ArrayList r12 = N.b.g(r15, r1, r2)
            goto L_0x0010
        L_0x0031:
            java.lang.String r11 = N.b.d(r15, r1)
            goto L_0x0010
        L_0x0036:
            java.lang.String r10 = N.b.d(r15, r1)
            goto L_0x0010
        L_0x003b:
            boolean r9 = N.b.j(r15, r1)
            goto L_0x0010
        L_0x0040:
            boolean r8 = N.b.j(r15, r1)
            goto L_0x0010
        L_0x0045:
            boolean r7 = N.b.j(r15, r1)
            goto L_0x0010
        L_0x004a:
            android.os.Parcelable$Creator r2 = android.accounts.Account.CREATOR
            android.os.Parcelable r1 = N.b.c(r15, r1, r2)
            r6 = r1
            android.accounts.Account r6 = (android.accounts.Account) r6
            goto L_0x0010
        L_0x0054:
            android.os.Parcelable$Creator<com.google.android.gms.common.api.Scope> r2 = com.google.android.gms.common.api.Scope.CREATOR
            java.util.ArrayList r5 = N.b.g(r15, r1, r2)
            goto L_0x0010
        L_0x005b:
            int r4 = N.b.p(r15, r1)
            goto L_0x0010
        L_0x0060:
            N.b.h(r15, r0)
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r3 = new com.google.android.gms.auth.api.signin.GoogleSignInOptions
            r3.<init>((int) r4, (java.util.ArrayList) r5, (android.accounts.Account) r6, (boolean) r7, (boolean) r8, (boolean) r9, (java.lang.String) r10, (java.lang.String) r11, (java.util.ArrayList) r12, (java.lang.String) r13)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.e.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new GoogleSignInOptions[i4];
    }
}
