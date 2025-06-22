package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.C0507a0;
import com.google.android.gms.internal.measurement.Y;
import f0.C0913b;
import f0.C0917f;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.measurement.internal.e2  reason: case insensitive filesystem */
public final class C0758e2 extends Y implements C0917f {
    C0758e2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final void G(C0755e eVar, M5 m5) {
        Parcel h4 = h();
        C0507a0.d(h4, eVar);
        C0507a0.d(h4, m5);
        k(12, h4);
    }

    public final void H(long j4, String str, String str2, String str3) {
        Parcel h4 = h();
        h4.writeLong(j4);
        h4.writeString(str);
        h4.writeString(str2);
        h4.writeString(str3);
        k(10, h4);
    }

    public final void J(M5 m5) {
        Parcel h4 = h();
        C0507a0.d(h4, m5);
        k(27, h4);
    }

    public final List K(String str, String str2, String str3) {
        Parcel h4 = h();
        h4.writeString(str);
        h4.writeString(str2);
        h4.writeString(str3);
        Parcel i4 = i(17, h4);
        ArrayList<C0755e> createTypedArrayList = i4.createTypedArrayList(C0755e.CREATOR);
        i4.recycle();
        return createTypedArrayList;
    }

    public final void L(C0755e eVar) {
        Parcel h4 = h();
        C0507a0.d(h4, eVar);
        k(13, h4);
    }

    public final void T(E e5, String str, String str2) {
        Parcel h4 = h();
        C0507a0.d(h4, e5);
        h4.writeString(str);
        h4.writeString(str2);
        k(5, h4);
    }

    public final void W(M5 m5) {
        Parcel h4 = h();
        C0507a0.d(h4, m5);
        k(25, h4);
    }

    public final C0913b X(M5 m5) {
        Parcel h4 = h();
        C0507a0.d(h4, m5);
        Parcel i4 = i(21, h4);
        C0913b bVar = (C0913b) C0507a0.a(i4, C0913b.CREATOR);
        i4.recycle();
        return bVar;
    }

    public final List Z(String str, String str2, boolean z4, M5 m5) {
        Parcel h4 = h();
        h4.writeString(str);
        h4.writeString(str2);
        C0507a0.e(h4, z4);
        C0507a0.d(h4, m5);
        Parcel i4 = i(14, h4);
        ArrayList<Y5> createTypedArrayList = i4.createTypedArrayList(Y5.CREATOR);
        i4.recycle();
        return createTypedArrayList;
    }

    public final void b0(M5 m5) {
        Parcel h4 = h();
        C0507a0.d(h4, m5);
        k(26, h4);
    }

    public final List c0(M5 m5, Bundle bundle) {
        Parcel h4 = h();
        C0507a0.d(h4, m5);
        C0507a0.d(h4, bundle);
        Parcel i4 = i(24, h4);
        ArrayList<B5> createTypedArrayList = i4.createTypedArrayList(B5.CREATOR);
        i4.recycle();
        return createTypedArrayList;
    }

    public final byte[] d0(E e5, String str) {
        Parcel h4 = h();
        C0507a0.d(h4, e5);
        h4.writeString(str);
        Parcel i4 = i(9, h4);
        byte[] createByteArray = i4.createByteArray();
        i4.recycle();
        return createByteArray;
    }

    public final void g0(M5 m5) {
        Parcel h4 = h();
        C0507a0.d(h4, m5);
        k(6, h4);
    }

    public final void i0(E e5, M5 m5) {
        Parcel h4 = h();
        C0507a0.d(h4, e5);
        C0507a0.d(h4, m5);
        k(1, h4);
    }

    public final List l(String str, String str2, M5 m5) {
        Parcel h4 = h();
        h4.writeString(str);
        h4.writeString(str2);
        C0507a0.d(h4, m5);
        Parcel i4 = i(16, h4);
        ArrayList<C0755e> createTypedArrayList = i4.createTypedArrayList(C0755e.CREATOR);
        i4.recycle();
        return createTypedArrayList;
    }

    public final void o(M5 m5) {
        Parcel h4 = h();
        C0507a0.d(h4, m5);
        k(4, h4);
    }

    public final List r(String str, String str2, String str3, boolean z4) {
        Parcel h4 = h();
        h4.writeString(str);
        h4.writeString(str2);
        h4.writeString(str3);
        C0507a0.e(h4, z4);
        Parcel i4 = i(15, h4);
        ArrayList<Y5> createTypedArrayList = i4.createTypedArrayList(Y5.CREATOR);
        i4.recycle();
        return createTypedArrayList;
    }

    public final void t(M5 m5) {
        Parcel h4 = h();
        C0507a0.d(h4, m5);
        k(18, h4);
    }

    public final void u(Bundle bundle, M5 m5) {
        Parcel h4 = h();
        C0507a0.d(h4, bundle);
        C0507a0.d(h4, m5);
        k(19, h4);
    }

    public final void v(M5 m5) {
        Parcel h4 = h();
        C0507a0.d(h4, m5);
        k(20, h4);
    }

    public final void w(Y5 y5, M5 m5) {
        Parcel h4 = h();
        C0507a0.d(h4, y5);
        C0507a0.d(h4, m5);
        k(2, h4);
    }

    public final String z(M5 m5) {
        Parcel h4 = h();
        C0507a0.d(h4, m5);
        Parcel i4 = i(11, h4);
        String readString = i4.readString();
        i4.recycle();
        return readString;
    }
}
