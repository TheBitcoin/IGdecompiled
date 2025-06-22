package com.google.android.gms.measurement;

import M.C0335p;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.measurement.C0526c1;
import com.google.android.gms.measurement.internal.S2;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import f0.o;
import f0.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Deprecated
public class AppMeasurement {

    /* renamed from: b  reason: collision with root package name */
    private static volatile AppMeasurement f2275b;

    /* renamed from: a  reason: collision with root package name */
    private final a f2276a;

    public static class ConditionalUserProperty {
        @Keep
        public boolean mActive;
        @NonNull
        @Keep
        public String mAppId;
        @Keep
        public long mCreationTimestamp;
        @NonNull
        @Keep
        public String mExpiredEventName;
        @NonNull
        @Keep
        public Bundle mExpiredEventParams;
        @NonNull
        @Keep
        public String mName;
        @NonNull
        @Keep
        public String mOrigin;
        @Keep
        public long mTimeToLive;
        @NonNull
        @Keep
        public String mTimedOutEventName;
        @NonNull
        @Keep
        public Bundle mTimedOutEventParams;
        @NonNull
        @Keep
        public String mTriggerEventName;
        @Keep
        public long mTriggerTimeout;
        @NonNull
        @Keep
        public String mTriggeredEventName;
        @NonNull
        @Keep
        public Bundle mTriggeredEventParams;
        @Keep
        public long mTriggeredTimestamp;
        @NonNull
        @Keep
        public Object mValue;

        ConditionalUserProperty(Bundle bundle) {
            C0335p.l(bundle);
            Class<String> cls = String.class;
            this.mAppId = (String) o.a(bundle, MBridgeConstans.APP_ID, cls, (Object) null);
            this.mOrigin = (String) o.a(bundle, TtmlNode.ATTR_TTS_ORIGIN, cls, (Object) null);
            this.mName = (String) o.a(bundle, RewardPlus.NAME, cls, (Object) null);
            this.mValue = o.a(bundle, "value", Object.class, (Object) null);
            this.mTriggerEventName = (String) o.a(bundle, "trigger_event_name", cls, (Object) null);
            Class<Long> cls2 = Long.class;
            this.mTriggerTimeout = ((Long) o.a(bundle, "trigger_timeout", cls2, 0L)).longValue();
            this.mTimedOutEventName = (String) o.a(bundle, "timed_out_event_name", cls, (Object) null);
            Class<Bundle> cls3 = Bundle.class;
            this.mTimedOutEventParams = (Bundle) o.a(bundle, "timed_out_event_params", cls3, (Object) null);
            this.mTriggeredEventName = (String) o.a(bundle, "triggered_event_name", cls, (Object) null);
            this.mTriggeredEventParams = (Bundle) o.a(bundle, "triggered_event_params", cls3, (Object) null);
            this.mTimeToLive = ((Long) o.a(bundle, "time_to_live", cls2, 0L)).longValue();
            this.mExpiredEventName = (String) o.a(bundle, "expired_event_name", cls, (Object) null);
            this.mExpiredEventParams = (Bundle) o.a(bundle, "expired_event_params", cls3, (Object) null);
            this.mActive = ((Boolean) o.a(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            this.mCreationTimestamp = ((Long) o.a(bundle, "creation_timestamp", cls2, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) o.a(bundle, "triggered_timestamp", cls2, 0L)).longValue();
        }
    }

    private static abstract class a implements z {
        private a() {
        }
    }

    private AppMeasurement(S2 s22) {
        this.f2276a = new b(s22);
    }

    private static AppMeasurement a(Context context, String str, String str2) {
        if (f2275b == null) {
            synchronized (AppMeasurement.class) {
                try {
                    if (f2275b == null) {
                        z b5 = b(context, (Bundle) null);
                        if (b5 != null) {
                            f2275b = new AppMeasurement(b5);
                        } else {
                            f2275b = new AppMeasurement(S2.b(context, new C0526c1(0, 0, true, (String) null, (String) null, (String) null, (Bundle) null, (String) null), (Long) null));
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f2275b;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static f0.z b(android.content.Context r7, android.os.Bundle r8) {
        /*
            r8 = 1
            r0 = 0
            r1 = 2
            r2 = 0
            java.lang.Class<com.google.firebase.analytics.FirebaseAnalytics> r3 = com.google.firebase.analytics.FirebaseAnalytics.class
            java.lang.String r4 = "getScionFrontendApiImplementation"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{  }
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r5[r0] = r6     // Catch:{  }
            java.lang.Class<android.os.Bundle> r6 = android.os.Bundle.class
            r5[r8] = r6     // Catch:{  }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{  }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{  }
            r1[r0] = r7     // Catch:{  }
            r1[r8] = r2     // Catch:{  }
            java.lang.Object r7 = r3.invoke(r2, r1)     // Catch:{  }
            f0.z r7 = (f0.z) r7     // Catch:{  }
            return r7
        L_0x0023:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.AppMeasurement.b(android.content.Context, android.os.Bundle):f0.z");
    }

    @Keep
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @NonNull
    @Deprecated
    public static AppMeasurement getInstance(@NonNull Context context) {
        return a(context, (String) null, (String) null);
    }

    @Keep
    public void beginAdUnitExposure(@Size(min = 1) @NonNull String str) {
        this.f2276a.i(str);
    }

    @Keep
    public void clearConditionalUserProperty(@Size(max = 24, min = 1) @NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        this.f2276a.b(str, str2, bundle);
    }

    @Keep
    public void endAdUnitExposure(@Size(min = 1) @NonNull String str) {
        this.f2276a.g(str);
    }

    @Keep
    public long generateEventId() {
        return this.f2276a.E();
    }

    @NonNull
    @Keep
    public String getAppInstanceId() {
        return this.f2276a.e();
    }

    @WorkerThread
    @Keep
    @NonNull
    public List<ConditionalUserProperty> getConditionalUserProperties(@NonNull String str, @Size(max = 23, min = 1) @NonNull String str2) {
        int i4;
        List<Bundle> h4 = this.f2276a.h(str, str2);
        if (h4 == null) {
            i4 = 0;
        } else {
            i4 = h4.size();
        }
        ArrayList arrayList = new ArrayList(i4);
        for (Bundle conditionalUserProperty : h4) {
            arrayList.add(new ConditionalUserProperty(conditionalUserProperty));
        }
        return arrayList;
    }

    @NonNull
    @Keep
    public String getCurrentScreenClass() {
        return this.f2276a.F();
    }

    @NonNull
    @Keep
    public String getCurrentScreenName() {
        return this.f2276a.d();
    }

    @NonNull
    @Keep
    public String getGmpAppId() {
        return this.f2276a.a();
    }

    @WorkerThread
    @Keep
    public int getMaxUserProperties(@Size(min = 1) @NonNull String str) {
        return this.f2276a.c(str);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @Keep
    @VisibleForTesting
    @NonNull
    public Map<String, Object> getUserProperties(@NonNull String str, @Size(max = 24, min = 1) @NonNull String str2, boolean z4) {
        return this.f2276a.j(str, str2, z4);
    }

    @Keep
    public void logEventInternal(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        this.f2276a.k(str, str2, bundle);
    }

    @Keep
    public void setConditionalUserProperty(@NonNull ConditionalUserProperty conditionalUserProperty) {
        C0335p.l(conditionalUserProperty);
        a aVar = this.f2276a;
        Bundle bundle = new Bundle();
        String str = conditionalUserProperty.mAppId;
        if (str != null) {
            bundle.putString(MBridgeConstans.APP_ID, str);
        }
        String str2 = conditionalUserProperty.mOrigin;
        if (str2 != null) {
            bundle.putString(TtmlNode.ATTR_TTS_ORIGIN, str2);
        }
        String str3 = conditionalUserProperty.mName;
        if (str3 != null) {
            bundle.putString(RewardPlus.NAME, str3);
        }
        Object obj = conditionalUserProperty.mValue;
        if (obj != null) {
            o.b(bundle, obj);
        }
        String str4 = conditionalUserProperty.mTriggerEventName;
        if (str4 != null) {
            bundle.putString("trigger_event_name", str4);
        }
        bundle.putLong("trigger_timeout", conditionalUserProperty.mTriggerTimeout);
        String str5 = conditionalUserProperty.mTimedOutEventName;
        if (str5 != null) {
            bundle.putString("timed_out_event_name", str5);
        }
        Bundle bundle2 = conditionalUserProperty.mTimedOutEventParams;
        if (bundle2 != null) {
            bundle.putBundle("timed_out_event_params", bundle2);
        }
        String str6 = conditionalUserProperty.mTriggeredEventName;
        if (str6 != null) {
            bundle.putString("triggered_event_name", str6);
        }
        Bundle bundle3 = conditionalUserProperty.mTriggeredEventParams;
        if (bundle3 != null) {
            bundle.putBundle("triggered_event_params", bundle3);
        }
        bundle.putLong("time_to_live", conditionalUserProperty.mTimeToLive);
        String str7 = conditionalUserProperty.mExpiredEventName;
        if (str7 != null) {
            bundle.putString("expired_event_name", str7);
        }
        Bundle bundle4 = conditionalUserProperty.mExpiredEventParams;
        if (bundle4 != null) {
            bundle.putBundle("expired_event_params", bundle4);
        }
        bundle.putLong("creation_timestamp", conditionalUserProperty.mCreationTimestamp);
        bundle.putBoolean("active", conditionalUserProperty.mActive);
        bundle.putLong("triggered_timestamp", conditionalUserProperty.mTriggeredTimestamp);
        aVar.f(bundle);
    }

    private AppMeasurement(z zVar) {
        this.f2276a = new a(zVar);
    }
}
