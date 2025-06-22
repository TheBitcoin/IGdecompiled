package androidx.privacysandbox.ads.adservices.measurement;

import R2.s;
import V2.d;
import W2.b;
import android.adservices.measurement.DeletionRequest;
import android.adservices.measurement.WebSourceParams;
import android.adservices.measurement.WebSourceRegistrationRequest;
import android.adservices.measurement.WebTriggerParams;
import android.adservices.measurement.WebTriggerRegistrationRequest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.InputEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.adid.h;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import j$.time.TimeConversions;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C0991n;

public abstract class MeasurementManager {
    public static final Companion Companion = new Companion((C2103g) null);
    public static final int MEASUREMENT_API_STATE_DISABLED = 0;
    public static final int MEASUREMENT_API_STATE_ENABLED = 1;

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        public final MeasurementManager obtain(Context context) {
            m.e(context, "context");
            StringBuilder sb = new StringBuilder();
            sb.append("AdServicesInfo.version=");
            AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
            sb.append(adServicesInfo.version());
            Log.d("MeasurementManager", sb.toString());
            if (adServicesInfo.version() >= 5) {
                return new Api33Ext5Impl(context);
            }
            return null;
        }

        private Companion() {
        }
    }

    @SuppressLint({"NewApi", "ClassVerificationFailure"})
    public static final MeasurementManager obtain(Context context) {
        return Companion.obtain(context);
    }

    public abstract Object deleteRegistrations(DeletionRequest deletionRequest, d dVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract Object getMeasurementApiStatus(d dVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract Object registerSource(Uri uri, InputEvent inputEvent, d dVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract Object registerTrigger(Uri uri, d dVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract Object registerWebSource(WebSourceRegistrationRequest webSourceRegistrationRequest, d dVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract Object registerWebTrigger(WebTriggerRegistrationRequest webTriggerRegistrationRequest, d dVar);

    @RequiresExtension(extension = 1000000, version = 5)
    @SuppressLint({"NewApi", "ClassVerificationFailure"})
    private static final class Api33Ext5Impl extends MeasurementManager {
        /* access modifiers changed from: private */
        public final android.adservices.measurement.MeasurementManager mMeasurementManager;

        public Api33Ext5Impl(android.adservices.measurement.MeasurementManager measurementManager) {
            m.e(measurementManager, "mMeasurementManager");
            this.mMeasurementManager = measurementManager;
        }

        /* access modifiers changed from: private */
        public final DeletionRequest convertDeletionRequest(DeletionRequest deletionRequest) {
            DeletionRequest a5 = v.a().setDeletionMode(deletionRequest.getDeletionMode()).setMatchBehavior(deletionRequest.getMatchBehavior()).setStart(TimeConversions.convert(deletionRequest.getStart())).setEnd(TimeConversions.convert(deletionRequest.getEnd())).setDomainUris(deletionRequest.getDomainUris()).setOriginUris(deletionRequest.getOriginUris()).build();
            m.d(a5, "Builder()\n              …\n                .build()");
            return a5;
        }

        private final List<WebSourceParams> convertWebSourceParams(List<WebSourceParams> list) {
            ArrayList arrayList = new ArrayList();
            for (WebSourceParams next : list) {
                u.a();
                WebSourceParams a5 = t.a(next.getRegistrationUri()).setDebugKeyAllowed(next.getDebugKeyAllowed()).build();
                m.d(a5, "Builder(param.registrati…                 .build()");
                arrayList.add(a5);
            }
            return arrayList;
        }

        /* access modifiers changed from: private */
        public final WebSourceRegistrationRequest convertWebSourceRequest(WebSourceRegistrationRequest webSourceRegistrationRequest) {
            y.a();
            WebSourceRegistrationRequest a5 = x.a(convertWebSourceParams(webSourceRegistrationRequest.getWebSourceParams()), webSourceRegistrationRequest.getTopOriginUri()).setWebDestination(webSourceRegistrationRequest.getWebDestination()).setAppDestination(webSourceRegistrationRequest.getAppDestination()).setInputEvent(webSourceRegistrationRequest.getInputEvent()).setVerifiedDestination(webSourceRegistrationRequest.getVerifiedDestination()).build();
            m.d(a5, "Builder(\n               …\n                .build()");
            return a5;
        }

        private final List<WebTriggerParams> convertWebTriggerParams(List<WebTriggerParams> list) {
            ArrayList arrayList = new ArrayList();
            for (WebTriggerParams next : list) {
                s.a();
                WebTriggerParams a5 = r.a(next.getRegistrationUri()).setDebugKeyAllowed(next.getDebugKeyAllowed()).build();
                m.d(a5, "Builder(param.registrati…                 .build()");
                arrayList.add(a5);
            }
            return arrayList;
        }

        /* access modifiers changed from: private */
        public final WebTriggerRegistrationRequest convertWebTriggerRequest(WebTriggerRegistrationRequest webTriggerRegistrationRequest) {
            A.a();
            WebTriggerRegistrationRequest a5 = z.a(convertWebTriggerParams(webTriggerRegistrationRequest.getWebTriggerParams()), webTriggerRegistrationRequest.getDestination()).build();
            m.d(a5, "Builder(\n               …\n                .build()");
            return a5;
        }

        @DoNotInline
        public Object deleteRegistrations(DeletionRequest deletionRequest, d dVar) {
            C0991n nVar = new C0991n(b.b(dVar), 1);
            nVar.z();
            this.mMeasurementManager.deleteRegistrations(convertDeletionRequest(deletionRequest), new h(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
            Object v4 = nVar.v();
            if (v4 == b.c()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            if (v4 == b.c()) {
                return v4;
            }
            return s.f8222a;
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public Object getMeasurementApiStatus(d dVar) {
            C0991n nVar = new C0991n(b.b(dVar), 1);
            nVar.z();
            this.mMeasurementManager.getMeasurementApiStatus(new h(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
            Object v4 = nVar.v();
            if (v4 == b.c()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            return v4;
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public Object registerSource(Uri uri, InputEvent inputEvent, d dVar) {
            C0991n nVar = new C0991n(b.b(dVar), 1);
            nVar.z();
            this.mMeasurementManager.registerSource(uri, inputEvent, new h(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
            Object v4 = nVar.v();
            if (v4 == b.c()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            if (v4 == b.c()) {
                return v4;
            }
            return s.f8222a;
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public Object registerTrigger(Uri uri, d dVar) {
            C0991n nVar = new C0991n(b.b(dVar), 1);
            nVar.z();
            this.mMeasurementManager.registerTrigger(uri, new h(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
            Object v4 = nVar.v();
            if (v4 == b.c()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            if (v4 == b.c()) {
                return v4;
            }
            return s.f8222a;
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public Object registerWebSource(WebSourceRegistrationRequest webSourceRegistrationRequest, d dVar) {
            C0991n nVar = new C0991n(b.b(dVar), 1);
            nVar.z();
            this.mMeasurementManager.registerWebSource(convertWebSourceRequest(webSourceRegistrationRequest), new h(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
            Object v4 = nVar.v();
            if (v4 == b.c()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            if (v4 == b.c()) {
                return v4;
            }
            return s.f8222a;
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public Object registerWebTrigger(WebTriggerRegistrationRequest webTriggerRegistrationRequest, d dVar) {
            C0991n nVar = new C0991n(b.b(dVar), 1);
            nVar.z();
            this.mMeasurementManager.registerWebTrigger(convertWebTriggerRequest(webTriggerRegistrationRequest), new h(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
            Object v4 = nVar.v();
            if (v4 == b.c()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            if (v4 == b.c()) {
                return v4;
            }
            return s.f8222a;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Api33Ext5Impl(android.content.Context r2) {
            /*
                r1 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.m.e(r2, r0)
                java.lang.Class r0 = androidx.privacysandbox.ads.adservices.measurement.C0493g.a()
                java.lang.Object r2 = r2.getSystemService(r0)
                java.lang.String r0 = "context.getSystemService…:class.java\n            )"
                kotlin.jvm.internal.m.d(r2, r0)
                android.adservices.measurement.MeasurementManager r2 = androidx.privacysandbox.ads.adservices.measurement.C0494h.a(r2)
                r1.<init>((android.adservices.measurement.MeasurementManager) r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.measurement.MeasurementManager.Api33Ext5Impl.<init>(android.content.Context):void");
        }
    }
}
