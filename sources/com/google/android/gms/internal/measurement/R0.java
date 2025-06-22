package com.google.android.gms.internal.measurement;

import U.a;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class R0 extends Y implements P0 {
    R0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public final void beginAdUnitExposure(String str, long j4) {
        Parcel h4 = h();
        h4.writeString(str);
        h4.writeLong(j4);
        k(23, h4);
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        Parcel h4 = h();
        h4.writeString(str);
        h4.writeString(str2);
        C0507a0.d(h4, bundle);
        k(9, h4);
    }

    public final void clearMeasurementEnabled(long j4) {
        Parcel h4 = h();
        h4.writeLong(j4);
        k(43, h4);
    }

    public final void endAdUnitExposure(String str, long j4) {
        Parcel h4 = h();
        h4.writeString(str);
        h4.writeLong(j4);
        k(24, h4);
    }

    public final void generateEventId(U0 u02) {
        Parcel h4 = h();
        C0507a0.c(h4, u02);
        k(22, h4);
    }

    public final void getCachedAppInstanceId(U0 u02) {
        Parcel h4 = h();
        C0507a0.c(h4, u02);
        k(19, h4);
    }

    public final void getConditionalUserProperties(String str, String str2, U0 u02) {
        Parcel h4 = h();
        h4.writeString(str);
        h4.writeString(str2);
        C0507a0.c(h4, u02);
        k(10, h4);
    }

    public final void getCurrentScreenClass(U0 u02) {
        Parcel h4 = h();
        C0507a0.c(h4, u02);
        k(17, h4);
    }

    public final void getCurrentScreenName(U0 u02) {
        Parcel h4 = h();
        C0507a0.c(h4, u02);
        k(16, h4);
    }

    public final void getGmpAppId(U0 u02) {
        Parcel h4 = h();
        C0507a0.c(h4, u02);
        k(21, h4);
    }

    public final void getMaxUserProperties(String str, U0 u02) {
        Parcel h4 = h();
        h4.writeString(str);
        C0507a0.c(h4, u02);
        k(6, h4);
    }

    public final void getUserProperties(String str, String str2, boolean z4, U0 u02) {
        Parcel h4 = h();
        h4.writeString(str);
        h4.writeString(str2);
        C0507a0.e(h4, z4);
        C0507a0.c(h4, u02);
        k(5, h4);
    }

    public final void initialize(a aVar, C0526c1 c1Var, long j4) {
        Parcel h4 = h();
        C0507a0.c(h4, aVar);
        C0507a0.d(h4, c1Var);
        h4.writeLong(j4);
        k(1, h4);
    }

    public final void logEvent(String str, String str2, Bundle bundle, boolean z4, boolean z5, long j4) {
        Parcel h4 = h();
        h4.writeString(str);
        h4.writeString(str2);
        C0507a0.d(h4, bundle);
        C0507a0.e(h4, z4);
        C0507a0.e(h4, z5);
        h4.writeLong(j4);
        k(2, h4);
    }

    public final void logHealthData(int i4, String str, a aVar, a aVar2, a aVar3) {
        Parcel h4 = h();
        h4.writeInt(i4);
        h4.writeString(str);
        C0507a0.c(h4, aVar);
        C0507a0.c(h4, aVar2);
        C0507a0.c(h4, aVar3);
        k(33, h4);
    }

    public final void onActivityCreated(a aVar, Bundle bundle, long j4) {
        Parcel h4 = h();
        C0507a0.c(h4, aVar);
        C0507a0.d(h4, bundle);
        h4.writeLong(j4);
        k(27, h4);
    }

    public final void onActivityDestroyed(a aVar, long j4) {
        Parcel h4 = h();
        C0507a0.c(h4, aVar);
        h4.writeLong(j4);
        k(28, h4);
    }

    public final void onActivityPaused(a aVar, long j4) {
        Parcel h4 = h();
        C0507a0.c(h4, aVar);
        h4.writeLong(j4);
        k(29, h4);
    }

    public final void onActivityResumed(a aVar, long j4) {
        Parcel h4 = h();
        C0507a0.c(h4, aVar);
        h4.writeLong(j4);
        k(30, h4);
    }

    public final void onActivitySaveInstanceState(a aVar, U0 u02, long j4) {
        Parcel h4 = h();
        C0507a0.c(h4, aVar);
        C0507a0.c(h4, u02);
        h4.writeLong(j4);
        k(31, h4);
    }

    public final void onActivityStarted(a aVar, long j4) {
        Parcel h4 = h();
        C0507a0.c(h4, aVar);
        h4.writeLong(j4);
        k(25, h4);
    }

    public final void onActivityStopped(a aVar, long j4) {
        Parcel h4 = h();
        C0507a0.c(h4, aVar);
        h4.writeLong(j4);
        k(26, h4);
    }

    public final void registerOnMeasurementEventListener(V0 v02) {
        Parcel h4 = h();
        C0507a0.c(h4, v02);
        k(35, h4);
    }

    public final void setConditionalUserProperty(Bundle bundle, long j4) {
        Parcel h4 = h();
        C0507a0.d(h4, bundle);
        h4.writeLong(j4);
        k(8, h4);
    }

    public final void setCurrentScreen(a aVar, String str, String str2, long j4) {
        Parcel h4 = h();
        C0507a0.c(h4, aVar);
        h4.writeString(str);
        h4.writeString(str2);
        h4.writeLong(j4);
        k(15, h4);
    }

    public final void setDataCollectionEnabled(boolean z4) {
        Parcel h4 = h();
        C0507a0.e(h4, z4);
        k(39, h4);
    }

    public final void setMeasurementEnabled(boolean z4, long j4) {
        Parcel h4 = h();
        C0507a0.e(h4, z4);
        h4.writeLong(j4);
        k(11, h4);
    }

    public final void setUserProperty(String str, String str2, a aVar, boolean z4, long j4) {
        Parcel h4 = h();
        h4.writeString(str);
        h4.writeString(str2);
        C0507a0.c(h4, aVar);
        C0507a0.e(h4, z4);
        h4.writeLong(j4);
        k(4, h4);
    }
}
