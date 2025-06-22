package M;

import android.os.Parcelable;

public final class P implements Parcelable.Creator {
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r10) {
        /*
            r9 = this;
            int r0 = N.b.u(r10)
            r1 = 0
            r2 = 0
            r5 = r2
            r6 = r5
            r4 = 0
            r7 = 0
            r8 = 0
        L_0x000b:
            int r1 = r10.dataPosition()
            if (r1 >= r0) goto L_0x004a
            int r1 = N.b.n(r10)
            int r2 = N.b.i(r1)
            r3 = 1
            if (r2 == r3) goto L_0x0045
            r3 = 2
            if (r2 == r3) goto L_0x0040
            r3 = 3
            if (r2 == r3) goto L_0x0036
            r3 = 4
            if (r2 == r3) goto L_0x0031
            r3 = 5
            if (r2 == r3) goto L_0x002c
            N.b.t(r10, r1)
            goto L_0x000b
        L_0x002c:
            boolean r8 = N.b.j(r10, r1)
            goto L_0x000b
        L_0x0031:
            boolean r7 = N.b.j(r10, r1)
            goto L_0x000b
        L_0x0036:
            android.os.Parcelable$Creator<J.b> r2 = J.C0303b.CREATOR
            android.os.Parcelable r1 = N.b.c(r10, r1, r2)
            r6 = r1
            J.b r6 = (J.C0303b) r6
            goto L_0x000b
        L_0x0040:
            android.os.IBinder r5 = N.b.o(r10, r1)
            goto L_0x000b
        L_0x0045:
            int r4 = N.b.p(r10, r1)
            goto L_0x000b
        L_0x004a:
            N.b.h(r10, r0)
            M.O r3 = new M.O
            r3.<init>(r4, r5, r6, r7, r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: M.P.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new O[i4];
    }
}
