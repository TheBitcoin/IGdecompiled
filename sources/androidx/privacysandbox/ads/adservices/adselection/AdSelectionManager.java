package androidx.privacysandbox.ads.adservices.adselection;

import R2.s;
import V2.d;
import W2.b;
import android.adservices.adselection.AdSelectionConfig;
import android.adservices.adselection.AdSelectionOutcome;
import android.adservices.adselection.ReportImpressionRequest;
import android.adservices.common.AdSelectionSignals;
import android.adservices.common.AdTechIdentifier;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.adid.h;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C0991n;

public abstract class AdSelectionManager {
    public static final Companion Companion = new Companion((C2103g) null);

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        public final AdSelectionManager obtain(Context context) {
            m.e(context, "context");
            if (AdServicesInfo.INSTANCE.version() >= 4) {
                return new Api33Ext4Impl(context);
            }
            return null;
        }

        private Companion() {
        }
    }

    @SuppressLint({"NewApi", "ClassVerificationFailure"})
    public static final AdSelectionManager obtain(Context context) {
        return Companion.obtain(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public abstract Object reportImpression(ReportImpressionRequest reportImpressionRequest, d dVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public abstract Object selectAds(AdSelectionConfig adSelectionConfig, d dVar);

    @RequiresExtension(extension = 1000000, version = 4)
    @SuppressLint({"NewApi", "ClassVerificationFailure"})
    private static final class Api33Ext4Impl extends AdSelectionManager {
        /* access modifiers changed from: private */
        public final android.adservices.adselection.AdSelectionManager mAdSelectionManager;

        public Api33Ext4Impl(android.adservices.adselection.AdSelectionManager adSelectionManager) {
            m.e(adSelectionManager, "mAdSelectionManager");
            this.mAdSelectionManager = adSelectionManager;
        }

        private final AdSelectionConfig convertAdSelectionConfig(AdSelectionConfig adSelectionConfig) {
            AdSelectionConfig a5 = k.a().setAdSelectionSignals(convertAdSelectionSignals(adSelectionConfig.getAdSelectionSignals())).setCustomAudienceBuyers(convertBuyers(adSelectionConfig.getCustomAudienceBuyers())).setDecisionLogicUri(adSelectionConfig.getDecisionLogicUri()).setSeller(AdTechIdentifier.fromString(adSelectionConfig.getSeller().getIdentifier())).setPerBuyerSignals(convertPerBuyerSignals(adSelectionConfig.getPerBuyerSignals())).setSellerSignals(convertAdSelectionSignals(adSelectionConfig.getSellerSignals())).setTrustedScoringSignalsUri(adSelectionConfig.getTrustedScoringSignalsUri()).build();
            m.d(a5, "Builder()\n              …\n                .build()");
            return a5;
        }

        private final AdSelectionSignals convertAdSelectionSignals(androidx.privacysandbox.ads.adservices.common.AdSelectionSignals adSelectionSignals) {
            AdSelectionSignals a5 = AdSelectionSignals.fromString(adSelectionSignals.getSignals());
            m.d(a5, "fromString(request.signals)");
            return a5;
        }

        private final List<AdTechIdentifier> convertBuyers(List<androidx.privacysandbox.ads.adservices.common.AdTechIdentifier> list) {
            ArrayList arrayList = new ArrayList();
            for (androidx.privacysandbox.ads.adservices.common.AdTechIdentifier identifier : list) {
                AdTechIdentifier a5 = AdTechIdentifier.fromString(identifier.getIdentifier());
                m.d(a5, "fromString(buyer.identifier)");
                arrayList.add(a5);
            }
            return arrayList;
        }

        private final Map<AdTechIdentifier, AdSelectionSignals> convertPerBuyerSignals(Map<androidx.privacysandbox.ads.adservices.common.AdTechIdentifier, androidx.privacysandbox.ads.adservices.common.AdSelectionSignals> map) {
            AdSelectionSignals adSelectionSignals;
            HashMap hashMap = new HashMap();
            for (androidx.privacysandbox.ads.adservices.common.AdTechIdentifier next : map.keySet()) {
                AdTechIdentifier a5 = AdTechIdentifier.fromString(next.getIdentifier());
                m.d(a5, "fromString(key.identifier)");
                if (map.get(next) != null) {
                    androidx.privacysandbox.ads.adservices.common.AdSelectionSignals adSelectionSignals2 = map.get(next);
                    m.b(adSelectionSignals2);
                    adSelectionSignals = convertAdSelectionSignals(adSelectionSignals2);
                } else {
                    adSelectionSignals = null;
                }
                hashMap.put(a5, adSelectionSignals);
            }
            return hashMap;
        }

        /* access modifiers changed from: private */
        public final ReportImpressionRequest convertReportImpressionRequest(ReportImpressionRequest reportImpressionRequest) {
            j.a();
            return i.a(reportImpressionRequest.getAdSelectionId(), convertAdSelectionConfig(reportImpressionRequest.getAdSelectionConfig()));
        }

        private final AdSelectionOutcome convertResponse(AdSelectionOutcome adSelectionOutcome) {
            long a5 = adSelectionOutcome.getAdSelectionId();
            Uri a6 = adSelectionOutcome.getRenderUri();
            m.d(a6, "response.renderUri");
            return new AdSelectionOutcome(a5, a6);
        }

        /* access modifiers changed from: private */
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        public final Object selectAdsInternal(AdSelectionConfig adSelectionConfig, d dVar) {
            C0991n nVar = new C0991n(b.b(dVar), 1);
            nVar.z();
            this.mAdSelectionManager.selectAds(adSelectionConfig, new h(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
            Object v4 = nVar.v();
            if (v4 == b.c()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            return v4;
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public Object reportImpression(ReportImpressionRequest reportImpressionRequest, d dVar) {
            C0991n nVar = new C0991n(b.b(dVar), 1);
            nVar.z();
            this.mAdSelectionManager.reportImpression(convertReportImpressionRequest(reportImpressionRequest), new h(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
            Object v4 = nVar.v();
            if (v4 == b.c()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            if (v4 == b.c()) {
                return v4;
            }
            return s.f8222a;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        @androidx.annotation.RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @androidx.annotation.DoNotInline
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object selectAds(androidx.privacysandbox.ads.adservices.adselection.AdSelectionConfig r5, V2.d r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager$Api33Ext4Impl$selectAds$1
                if (r0 == 0) goto L_0x0013
                r0 = r6
                androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager$Api33Ext4Impl$selectAds$1 r0 = (androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager$Api33Ext4Impl$selectAds$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager$Api33Ext4Impl$selectAds$1 r0 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager$Api33Ext4Impl$selectAds$1
                r0.<init>(r4, r6)
            L_0x0018:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L_0x0035
                if (r2 != r3) goto L_0x002d
                java.lang.Object r5 = r0.L$0
                androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager$Api33Ext4Impl r5 = (androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager.Api33Ext4Impl) r5
                R2.n.b(r6)
                goto L_0x0048
            L_0x002d:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L_0x0035:
                R2.n.b(r6)
                android.adservices.adselection.AdSelectionConfig r5 = r4.convertAdSelectionConfig(r5)
                r0.L$0 = r4
                r0.label = r3
                java.lang.Object r6 = r4.selectAdsInternal(r5, r0)
                if (r6 != r1) goto L_0x0047
                return r1
            L_0x0047:
                r5 = r4
            L_0x0048:
                android.adservices.adselection.AdSelectionOutcome r6 = androidx.privacysandbox.ads.adservices.adselection.n.a(r6)
                androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome r5 = r5.convertResponse(r6)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager.Api33Ext4Impl.selectAds(androidx.privacysandbox.ads.adservices.adselection.AdSelectionConfig, V2.d):java.lang.Object");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Api33Ext4Impl(android.content.Context r2) {
            /*
                r1 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.m.e(r2, r0)
                java.lang.Class r0 = androidx.privacysandbox.ads.adservices.adselection.a.a()
                java.lang.Object r2 = r2.getSystemService(r0)
                java.lang.String r0 = "context.getSystemService…:class.java\n            )"
                kotlin.jvm.internal.m.d(r2, r0)
                android.adservices.adselection.AdSelectionManager r2 = androidx.privacysandbox.ads.adservices.adselection.l.a(r2)
                r1.<init>((android.adservices.adselection.AdSelectionManager) r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager.Api33Ext4Impl.<init>(android.content.Context):void");
        }
    }
}
