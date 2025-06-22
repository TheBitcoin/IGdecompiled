package androidx.privacysandbox.ads.adservices.java.adselection;

import V2.d;
import V2.g;
import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionConfig;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager;
import androidx.privacysandbox.ads.adservices.adselection.ReportImpressionRequest;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o0.C2172d;
import o3.K;
import o3.L;
import o3.Y;

public abstract class AdSelectionManagerFutures {
    public static final Companion Companion = new Companion((C2103g) null);

    private static final class Api33Ext4JavaImpl extends AdSelectionManagerFutures {
        /* access modifiers changed from: private */
        public final AdSelectionManager mAdSelectionManager;

        public Api33Ext4JavaImpl(AdSelectionManager adSelectionManager) {
            this.mAdSelectionManager = adSelectionManager;
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public C2172d reportImpressionAsync(ReportImpressionRequest reportImpressionRequest) {
            m.e(reportImpressionRequest, "reportImpressionRequest");
            return CoroutineAdapterKt.asListenableFuture$default(C0981i.b(K.a(Y.a()), (g) null, (L) null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$reportImpressionAsync$1(this, reportImpressionRequest, (d) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public C2172d selectAdsAsync(AdSelectionConfig adSelectionConfig) {
            m.e(adSelectionConfig, "adSelectionConfig");
            return CoroutineAdapterKt.asListenableFuture$default(C0981i.b(K.a(Y.a()), (g) null, (L) null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$selectAdsAsync$1(this, adSelectionConfig, (d) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        public final AdSelectionManagerFutures from(Context context) {
            m.e(context, "context");
            AdSelectionManager obtain = AdSelectionManager.Companion.obtain(context);
            if (obtain != null) {
                return new Api33Ext4JavaImpl(obtain);
            }
            return null;
        }

        private Companion() {
        }
    }

    public static final AdSelectionManagerFutures from(Context context) {
        return Companion.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public abstract C2172d reportImpressionAsync(ReportImpressionRequest reportImpressionRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public abstract C2172d selectAdsAsync(AdSelectionConfig adSelectionConfig);
}
