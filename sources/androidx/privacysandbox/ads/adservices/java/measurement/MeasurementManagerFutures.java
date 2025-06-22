package androidx.privacysandbox.ads.adservices.java.measurement;

import V2.d;
import V2.g;
import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.privacysandbox.ads.adservices.measurement.DeletionRequest;
import androidx.privacysandbox.ads.adservices.measurement.MeasurementManager;
import androidx.privacysandbox.ads.adservices.measurement.WebSourceRegistrationRequest;
import androidx.privacysandbox.ads.adservices.measurement.WebTriggerRegistrationRequest;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o0.C2172d;
import o3.K;
import o3.L;
import o3.Y;

public abstract class MeasurementManagerFutures {
    public static final Companion Companion = new Companion((C2103g) null);

    private static final class Api33Ext5JavaImpl extends MeasurementManagerFutures {
        /* access modifiers changed from: private */
        public final MeasurementManager mMeasurementManager;

        public Api33Ext5JavaImpl(MeasurementManager measurementManager) {
            m.e(measurementManager, "mMeasurementManager");
            this.mMeasurementManager = measurementManager;
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public C2172d deleteRegistrationsAsync(DeletionRequest deletionRequest) {
            m.e(deletionRequest, "deletionRequest");
            return CoroutineAdapterKt.asListenableFuture$default(C0981i.b(K.a(Y.a()), (g) null, (L) null, new MeasurementManagerFutures$Api33Ext5JavaImpl$deleteRegistrationsAsync$1(this, deletionRequest, (d) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public C2172d getMeasurementApiStatusAsync() {
            return CoroutineAdapterKt.asListenableFuture$default(C0981i.b(K.a(Y.a()), (g) null, (L) null, new MeasurementManagerFutures$Api33Ext5JavaImpl$getMeasurementApiStatusAsync$1(this, (d) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public C2172d registerSourceAsync(Uri uri, InputEvent inputEvent) {
            m.e(uri, "attributionSource");
            return CoroutineAdapterKt.asListenableFuture$default(C0981i.b(K.a(Y.a()), (g) null, (L) null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1(this, uri, inputEvent, (d) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public C2172d registerTriggerAsync(Uri uri) {
            m.e(uri, "trigger");
            return CoroutineAdapterKt.asListenableFuture$default(C0981i.b(K.a(Y.a()), (g) null, (L) null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerTriggerAsync$1(this, uri, (d) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public C2172d registerWebSourceAsync(WebSourceRegistrationRequest webSourceRegistrationRequest) {
            m.e(webSourceRegistrationRequest, "request");
            return CoroutineAdapterKt.asListenableFuture$default(C0981i.b(K.a(Y.a()), (g) null, (L) null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebSourceAsync$1(this, webSourceRegistrationRequest, (d) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public C2172d registerWebTriggerAsync(WebTriggerRegistrationRequest webTriggerRegistrationRequest) {
            m.e(webTriggerRegistrationRequest, "request");
            return CoroutineAdapterKt.asListenableFuture$default(C0981i.b(K.a(Y.a()), (g) null, (L) null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebTriggerAsync$1(this, webTriggerRegistrationRequest, (d) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        public final MeasurementManagerFutures from(Context context) {
            m.e(context, "context");
            MeasurementManager obtain = MeasurementManager.Companion.obtain(context);
            if (obtain != null) {
                return new Api33Ext5JavaImpl(obtain);
            }
            return null;
        }

        private Companion() {
        }
    }

    public static final MeasurementManagerFutures from(Context context) {
        return Companion.from(context);
    }

    public abstract C2172d deleteRegistrationsAsync(DeletionRequest deletionRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract C2172d getMeasurementApiStatusAsync();

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract C2172d registerSourceAsync(Uri uri, InputEvent inputEvent);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract C2172d registerTriggerAsync(Uri uri);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract C2172d registerWebSourceAsync(WebSourceRegistrationRequest webSourceRegistrationRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract C2172d registerWebTriggerAsync(WebTriggerRegistrationRequest webTriggerRegistrationRequest);
}
