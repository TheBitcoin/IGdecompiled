package M;

import N.c;
import android.os.Parcel;
import android.os.Parcelable;

public final class k0 implements Parcelable.Creator {
    static void a(C0325f fVar, Parcel parcel, int i4) {
        int a5 = c.a(parcel);
        c.i(parcel, 1, fVar.f515a);
        c.i(parcel, 2, fVar.f516b);
        c.i(parcel, 3, fVar.f517c);
        c.n(parcel, 4, fVar.f518d, false);
        c.h(parcel, 5, fVar.f519e, false);
        c.p(parcel, 6, fVar.f520f, i4, false);
        c.e(parcel, 7, fVar.f521g, false);
        c.m(parcel, 8, fVar.f522h, i4, false);
        c.p(parcel, 10, fVar.f523i, i4, false);
        c.p(parcel, 11, fVar.f524j, i4, false);
        c.c(parcel, 12, fVar.f525k);
        c.i(parcel, 13, fVar.f526l);
        c.c(parcel, 14, fVar.f527m);
        c.n(parcel, 15, fVar.c(), false);
        c.b(parcel, a5);
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v5, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r2v6, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r23) {
        /*
            r22 = this;
            r0 = r23
            int r1 = N.b.u(r0)
            com.google.android.gms.common.api.Scope[] r2 = M.C0325f.f513o
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            J.d[] r4 = M.C0325f.f514p
            r5 = 0
            r6 = 0
            r13 = r2
            r14 = r3
            r16 = r4
            r17 = r16
            r11 = r5
            r12 = r11
            r15 = r12
            r21 = r15
            r8 = 0
            r9 = 0
            r10 = 0
            r18 = 0
            r19 = 0
            r20 = 0
        L_0x0025:
            int r2 = r0.dataPosition()
            if (r2 >= r1) goto L_0x0096
            int r2 = N.b.n(r0)
            int r3 = N.b.i(r2)
            switch(r3) {
                case 1: goto L_0x0091;
                case 2: goto L_0x008c;
                case 3: goto L_0x0087;
                case 4: goto L_0x0082;
                case 5: goto L_0x007d;
                case 6: goto L_0x0073;
                case 7: goto L_0x006e;
                case 8: goto L_0x0064;
                case 9: goto L_0x0036;
                case 10: goto L_0x0059;
                case 11: goto L_0x004e;
                case 12: goto L_0x0049;
                case 13: goto L_0x0044;
                case 14: goto L_0x003f;
                case 15: goto L_0x003a;
                default: goto L_0x0036;
            }
        L_0x0036:
            N.b.t(r0, r2)
            goto L_0x0025
        L_0x003a:
            java.lang.String r21 = N.b.d(r0, r2)
            goto L_0x0025
        L_0x003f:
            boolean r20 = N.b.j(r0, r2)
            goto L_0x0025
        L_0x0044:
            int r19 = N.b.p(r0, r2)
            goto L_0x0025
        L_0x0049:
            boolean r18 = N.b.j(r0, r2)
            goto L_0x0025
        L_0x004e:
            android.os.Parcelable$Creator<J.d> r3 = J.C0305d.CREATOR
            java.lang.Object[] r2 = N.b.f(r0, r2, r3)
            r17 = r2
            J.d[] r17 = (J.C0305d[]) r17
            goto L_0x0025
        L_0x0059:
            android.os.Parcelable$Creator<J.d> r3 = J.C0305d.CREATOR
            java.lang.Object[] r2 = N.b.f(r0, r2, r3)
            r16 = r2
            J.d[] r16 = (J.C0305d[]) r16
            goto L_0x0025
        L_0x0064:
            android.os.Parcelable$Creator r3 = android.accounts.Account.CREATOR
            android.os.Parcelable r2 = N.b.c(r0, r2, r3)
            r15 = r2
            android.accounts.Account r15 = (android.accounts.Account) r15
            goto L_0x0025
        L_0x006e:
            android.os.Bundle r14 = N.b.a(r0, r2)
            goto L_0x0025
        L_0x0073:
            android.os.Parcelable$Creator<com.google.android.gms.common.api.Scope> r3 = com.google.android.gms.common.api.Scope.CREATOR
            java.lang.Object[] r2 = N.b.f(r0, r2, r3)
            r13 = r2
            com.google.android.gms.common.api.Scope[] r13 = (com.google.android.gms.common.api.Scope[]) r13
            goto L_0x0025
        L_0x007d:
            android.os.IBinder r12 = N.b.o(r0, r2)
            goto L_0x0025
        L_0x0082:
            java.lang.String r11 = N.b.d(r0, r2)
            goto L_0x0025
        L_0x0087:
            int r10 = N.b.p(r0, r2)
            goto L_0x0025
        L_0x008c:
            int r9 = N.b.p(r0, r2)
            goto L_0x0025
        L_0x0091:
            int r8 = N.b.p(r0, r2)
            goto L_0x0025
        L_0x0096:
            N.b.h(r0, r1)
            M.f r7 = new M.f
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: M.k0.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new C0325f[i4];
    }
}
