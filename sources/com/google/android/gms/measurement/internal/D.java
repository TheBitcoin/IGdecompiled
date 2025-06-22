package com.google.android.gms.measurement.internal;

import N.a;
import N.c;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;

public final class D extends a implements Iterable {
    public static final Parcelable.Creator<D> CREATOR = new F();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f2344a;

    D(Bundle bundle) {
        this.f2344a = bundle;
    }

    public final int c() {
        return this.f2344a.size();
    }

    /* access modifiers changed from: package-private */
    public final Double h(String str) {
        return Double.valueOf(this.f2344a.getDouble(str));
    }

    public final Iterator iterator() {
        return new C(this);
    }

    public final Bundle j() {
        return new Bundle(this.f2344a);
    }

    /* access modifiers changed from: package-private */
    public final Long k(String str) {
        return Long.valueOf(this.f2344a.getLong(str));
    }

    /* access modifiers changed from: package-private */
    public final Object l(String str) {
        return this.f2344a.get(str);
    }

    /* access modifiers changed from: package-private */
    public final String m(String str) {
        return this.f2344a.getString(str);
    }

    public final String toString() {
        return this.f2344a.toString();
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        int a5 = c.a(parcel);
        c.e(parcel, 2, j(), false);
        c.b(parcel, a5);
    }
}
