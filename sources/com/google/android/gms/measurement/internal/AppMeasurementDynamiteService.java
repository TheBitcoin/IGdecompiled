package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.measurement.C0508a1;
import com.google.android.gms.internal.measurement.C0526c1;
import com.google.android.gms.internal.measurement.S0;
import com.google.android.gms.internal.measurement.U0;
import com.google.android.gms.internal.measurement.V0;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import f0.t;
import f0.u;
import java.util.Map;

@DynamiteApi
public class AppMeasurementDynamiteService extends S0 {

    /* renamed from: a  reason: collision with root package name */
    S2 f2310a = null;

    /* renamed from: b  reason: collision with root package name */
    private final Map f2311b = new ArrayMap();

    class a implements u {

        /* renamed from: a  reason: collision with root package name */
        private V0 f2312a;

        a(V0 v02) {
            this.f2312a = v02;
        }

        public final void a(String str, String str2, Bundle bundle, long j4) {
            try {
                this.f2312a.V(str, str2, bundle, j4);
            } catch (RemoteException e5) {
                RemoteException remoteException = e5;
                S2 s22 = AppMeasurementDynamiteService.this.f2310a;
                if (s22 != null) {
                    s22.a().L().b("Event interceptor threw exception", remoteException);
                }
            }
        }
    }

    class b implements t {

        /* renamed from: a  reason: collision with root package name */
        private V0 f2314a;

        b(V0 v02) {
            this.f2314a = v02;
        }

        public final void a(String str, String str2, Bundle bundle, long j4) {
            try {
                this.f2314a.V(str, str2, bundle, j4);
            } catch (RemoteException e5) {
                RemoteException remoteException = e5;
                S2 s22 = AppMeasurementDynamiteService.this.f2310a;
                if (s22 != null) {
                    s22.a().L().b("Event listener threw exception", remoteException);
                }
            }
        }
    }

    private final void i() {
        if (this.f2310a == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    private final void k(U0 u02, String str) {
        i();
        this.f2310a.L().S(u02, str);
    }

    public void beginAdUnitExposure(@NonNull String str, long j4) throws RemoteException {
        i();
        this.f2310a.v().w(str, j4);
    }

    public void clearConditionalUserProperty(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) throws RemoteException {
        i();
        this.f2310a.H().h0(str, str2, bundle);
    }

    public void clearMeasurementEnabled(long j4) throws RemoteException {
        i();
        this.f2310a.H().b0((Boolean) null);
    }

    public void endAdUnitExposure(@NonNull String str, long j4) throws RemoteException {
        i();
        this.f2310a.v().D(str, j4);
    }

    public void generateEventId(U0 u02) throws RemoteException {
        i();
        long R02 = this.f2310a.L().R0();
        i();
        this.f2310a.L().Q(u02, R02);
    }

    public void getAppInstanceId(U0 u02) throws RemoteException {
        i();
        this.f2310a.f().D(new U2(this, u02));
    }

    public void getCachedAppInstanceId(U0 u02) throws RemoteException {
        i();
        k(u02, this.f2310a.H().v0());
    }

    public void getConditionalUserProperties(String str, String str2, U0 u02) throws RemoteException {
        i();
        this.f2310a.f().D(new C0830o4(this, u02, str, str2));
    }

    public void getCurrentScreenClass(U0 u02) throws RemoteException {
        i();
        k(u02, this.f2310a.H().w0());
    }

    public void getCurrentScreenName(U0 u02) throws RemoteException {
        i();
        k(u02, this.f2310a.H().x0());
    }

    public void getGmpAppId(U0 u02) throws RemoteException {
        i();
        k(u02, this.f2310a.H().y0());
    }

    public void getMaxUserProperties(String str, U0 u02) throws RemoteException {
        i();
        this.f2310a.H();
        F3.E(str);
        i();
        this.f2310a.L().P(u02, 25);
    }

    public void getSessionId(U0 u02) throws RemoteException {
        i();
        this.f2310a.H().P(u02);
    }

    public void getTestFlag(U0 u02, int i4) throws RemoteException {
        i();
        if (i4 == 0) {
            this.f2310a.L().S(u02, this.f2310a.H().z0());
        } else if (i4 == 1) {
            this.f2310a.L().Q(u02, this.f2310a.H().u0().longValue());
        } else if (i4 == 2) {
            d6 L4 = this.f2310a.L();
            double doubleValue = this.f2310a.H().s0().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble(CampaignEx.JSON_KEY_AD_R, doubleValue);
            try {
                u02.f(bundle);
            } catch (RemoteException e5) {
                L4.f3273a.a().L().b("Error returning double value to wrapper", e5);
            }
        } else if (i4 == 3) {
            this.f2310a.L().P(u02, this.f2310a.H().t0().intValue());
        } else if (i4 == 4) {
            this.f2310a.L().U(u02, this.f2310a.H().r0().booleanValue());
        }
    }

    public void getUserProperties(String str, String str2, boolean z4, U0 u02) throws RemoteException {
        i();
        this.f2310a.f().D(new C0877v3(this, u02, str, str2, z4));
    }

    public void initForTests(@NonNull Map map) throws RemoteException {
        i();
    }

    public void initialize(U.a aVar, C0526c1 c1Var, long j4) throws RemoteException {
        S2 s22 = this.f2310a;
        if (s22 == null) {
            this.f2310a = S2.b((Context) C0335p.l((Context) U.b.k(aVar)), c1Var, Long.valueOf(j4));
        } else {
            s22.a().L().a("Attempting to initialize multiple times");
        }
    }

    public void isDataCollectionEnabled(U0 u02) throws RemoteException {
        i();
        this.f2310a.f().D(new C0824n5(this, u02));
    }

    public void logEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, boolean z4, boolean z5, long j4) throws RemoteException {
        i();
        this.f2310a.H().j0(str, str2, bundle, z4, z5, j4);
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, U0 u02, long j4) throws RemoteException {
        Bundle bundle2;
        i();
        C0335p.f(str2);
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        bundle2.putString("_o", MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        this.f2310a.f().D(new O3(this, u02, new E(str2, new D(bundle), MBridgeConstans.DYNAMIC_VIEW_WX_APP, j4), str));
    }

    public void logHealthData(int i4, @NonNull String str, @NonNull U.a aVar, @NonNull U.a aVar2, @NonNull U.a aVar3) throws RemoteException {
        Object obj;
        Object obj2;
        i();
        Object obj3 = null;
        if (aVar == null) {
            obj = null;
        } else {
            obj = U.b.k(aVar);
        }
        if (aVar2 == null) {
            obj2 = null;
        } else {
            obj2 = U.b.k(aVar2);
        }
        if (aVar3 != null) {
            obj3 = U.b.k(aVar3);
        }
        this.f2310a.a().w(i4, true, false, str, obj, obj2, obj3);
    }

    public void onActivityCreated(@NonNull U.a aVar, @NonNull Bundle bundle, long j4) throws RemoteException {
        i();
        Application.ActivityLifecycleCallbacks p02 = this.f2310a.H().p0();
        if (p02 != null) {
            this.f2310a.H().D0();
            p02.onActivityCreated((Activity) U.b.k(aVar), bundle);
        }
    }

    public void onActivityDestroyed(@NonNull U.a aVar, long j4) throws RemoteException {
        i();
        Application.ActivityLifecycleCallbacks p02 = this.f2310a.H().p0();
        if (p02 != null) {
            this.f2310a.H().D0();
            p02.onActivityDestroyed((Activity) U.b.k(aVar));
        }
    }

    public void onActivityPaused(@NonNull U.a aVar, long j4) throws RemoteException {
        i();
        Application.ActivityLifecycleCallbacks p02 = this.f2310a.H().p0();
        if (p02 != null) {
            this.f2310a.H().D0();
            p02.onActivityPaused((Activity) U.b.k(aVar));
        }
    }

    public void onActivityResumed(@NonNull U.a aVar, long j4) throws RemoteException {
        i();
        Application.ActivityLifecycleCallbacks p02 = this.f2310a.H().p0();
        if (p02 != null) {
            this.f2310a.H().D0();
            p02.onActivityResumed((Activity) U.b.k(aVar));
        }
    }

    public void onActivitySaveInstanceState(U.a aVar, U0 u02, long j4) throws RemoteException {
        i();
        Application.ActivityLifecycleCallbacks p02 = this.f2310a.H().p0();
        Bundle bundle = new Bundle();
        if (p02 != null) {
            this.f2310a.H().D0();
            p02.onActivitySaveInstanceState((Activity) U.b.k(aVar), bundle);
        }
        try {
            u02.f(bundle);
        } catch (RemoteException e5) {
            this.f2310a.a().L().b("Error returning bundle value to wrapper", e5);
        }
    }

    public void onActivityStarted(@NonNull U.a aVar, long j4) throws RemoteException {
        i();
        Application.ActivityLifecycleCallbacks p02 = this.f2310a.H().p0();
        if (p02 != null) {
            this.f2310a.H().D0();
            p02.onActivityStarted((Activity) U.b.k(aVar));
        }
    }

    public void onActivityStopped(@NonNull U.a aVar, long j4) throws RemoteException {
        i();
        Application.ActivityLifecycleCallbacks p02 = this.f2310a.H().p0();
        if (p02 != null) {
            this.f2310a.H().D0();
            p02.onActivityStopped((Activity) U.b.k(aVar));
        }
    }

    public void performAction(Bundle bundle, U0 u02, long j4) throws RemoteException {
        i();
        u02.f((Bundle) null);
    }

    public void registerOnMeasurementEventListener(V0 v02) throws RemoteException {
        t tVar;
        i();
        synchronized (this.f2311b) {
            try {
                tVar = (t) this.f2311b.get(Integer.valueOf(v02.A()));
                if (tVar == null) {
                    tVar = new b(v02);
                    this.f2311b.put(Integer.valueOf(v02.A()), tVar);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.f2310a.H().Z(tVar);
    }

    public void resetAnalyticsData(long j4) throws RemoteException {
        i();
        this.f2310a.H().I(j4);
    }

    public void setConditionalUserProperty(@NonNull Bundle bundle, long j4) throws RemoteException {
        i();
        if (bundle == null) {
            this.f2310a.a().G().a("Conditional user property must not be null");
        } else {
            this.f2310a.H().O0(bundle, j4);
        }
    }

    public void setConsent(@NonNull Bundle bundle, long j4) throws RemoteException {
        i();
        this.f2310a.H().Y0(bundle, j4);
    }

    public void setConsentThirdParty(@NonNull Bundle bundle, long j4) throws RemoteException {
        i();
        this.f2310a.H().d1(bundle, j4);
    }

    public void setCurrentScreen(@NonNull U.a aVar, @NonNull String str, @NonNull String str2, long j4) throws RemoteException {
        i();
        this.f2310a.I().H((Activity) U.b.k(aVar), str, str2);
    }

    public void setDataCollectionEnabled(boolean z4) throws RemoteException {
        i();
        this.f2310a.H().c1(z4);
    }

    public void setDefaultEventParameters(@NonNull Bundle bundle) {
        i();
        this.f2310a.H().X0(bundle);
    }

    public void setEventInterceptor(V0 v02) throws RemoteException {
        i();
        a aVar = new a(v02);
        if (this.f2310a.f().J()) {
            this.f2310a.H().a0(aVar);
        } else {
            this.f2310a.f().D(new M4(this, aVar));
        }
    }

    public void setInstanceIdProvider(C0508a1 a1Var) throws RemoteException {
        i();
    }

    public void setMeasurementEnabled(boolean z4, long j4) throws RemoteException {
        i();
        this.f2310a.H().b0(Boolean.valueOf(z4));
    }

    public void setMinimumSessionDuration(long j4) throws RemoteException {
        i();
    }

    public void setSessionTimeoutDuration(long j4) throws RemoteException {
        i();
        this.f2310a.H().W0(j4);
    }

    public void setSgtmDebugInfo(@NonNull Intent intent) throws RemoteException {
        i();
        this.f2310a.H().K(intent);
    }

    public void setUserId(@NonNull String str, long j4) throws RemoteException {
        i();
        this.f2310a.H().d0(str, j4);
    }

    public void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull U.a aVar, boolean z4, long j4) throws RemoteException {
        i();
        this.f2310a.H().m0(str, str2, U.b.k(aVar), z4, j4);
    }

    public void unregisterOnMeasurementEventListener(V0 v02) throws RemoteException {
        t tVar;
        i();
        synchronized (this.f2311b) {
            tVar = (t) this.f2311b.remove(Integer.valueOf(v02.A()));
        }
        if (tVar == null) {
            tVar = new b(v02);
        }
        this.f2310a.H().R0(tVar);
    }
}
