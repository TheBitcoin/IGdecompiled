package com.google.android.gms.internal.measurement;

import U.a;
import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import java.util.Map;

public interface P0 extends IInterface {
    void beginAdUnitExposure(String str, long j4);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    void clearMeasurementEnabled(long j4);

    void endAdUnitExposure(String str, long j4);

    void generateEventId(U0 u02);

    void getAppInstanceId(U0 u02);

    void getCachedAppInstanceId(U0 u02);

    void getConditionalUserProperties(String str, String str2, U0 u02);

    void getCurrentScreenClass(U0 u02);

    void getCurrentScreenName(U0 u02);

    void getGmpAppId(U0 u02);

    void getMaxUserProperties(String str, U0 u02);

    void getSessionId(U0 u02);

    void getTestFlag(U0 u02, int i4);

    void getUserProperties(String str, String str2, boolean z4, U0 u02);

    void initForTests(Map map);

    void initialize(a aVar, C0526c1 c1Var, long j4);

    void isDataCollectionEnabled(U0 u02);

    void logEvent(String str, String str2, Bundle bundle, boolean z4, boolean z5, long j4);

    void logEventAndBundle(String str, String str2, Bundle bundle, U0 u02, long j4);

    void logHealthData(int i4, String str, a aVar, a aVar2, a aVar3);

    void onActivityCreated(a aVar, Bundle bundle, long j4);

    void onActivityDestroyed(a aVar, long j4);

    void onActivityPaused(a aVar, long j4);

    void onActivityResumed(a aVar, long j4);

    void onActivitySaveInstanceState(a aVar, U0 u02, long j4);

    void onActivityStarted(a aVar, long j4);

    void onActivityStopped(a aVar, long j4);

    void performAction(Bundle bundle, U0 u02, long j4);

    void registerOnMeasurementEventListener(V0 v02);

    void resetAnalyticsData(long j4);

    void setConditionalUserProperty(Bundle bundle, long j4);

    void setConsent(Bundle bundle, long j4);

    void setConsentThirdParty(Bundle bundle, long j4);

    void setCurrentScreen(a aVar, String str, String str2, long j4);

    void setDataCollectionEnabled(boolean z4);

    void setDefaultEventParameters(Bundle bundle);

    void setEventInterceptor(V0 v02);

    void setInstanceIdProvider(C0508a1 a1Var);

    void setMeasurementEnabled(boolean z4, long j4);

    void setMinimumSessionDuration(long j4);

    void setSessionTimeoutDuration(long j4);

    void setSgtmDebugInfo(Intent intent);

    void setUserId(String str, long j4);

    void setUserProperty(String str, String str2, a aVar, boolean z4, long j4);

    void unregisterOnMeasurementEventListener(V0 v02);
}
