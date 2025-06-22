package androidx.privacysandbox.ads.adservices.customaudience;

import R2.s;
import V2.d;
import W2.b;
import android.adservices.common.AdData;
import android.adservices.common.AdSelectionSignals;
import android.adservices.common.AdTechIdentifier;
import android.adservices.customaudience.CustomAudience;
import android.adservices.customaudience.JoinCustomAudienceRequest;
import android.adservices.customaudience.LeaveCustomAudienceRequest;
import android.adservices.customaudience.TrustedBiddingData;
import android.annotation.SuppressLint;
import android.content.Context;
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

public abstract class CustomAudienceManager {
    public static final Companion Companion = new Companion((C2103g) null);

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        public final CustomAudienceManager obtain(Context context) {
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
    public static final CustomAudienceManager obtain(Context context) {
        return Companion.obtain(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public abstract Object joinCustomAudience(JoinCustomAudienceRequest joinCustomAudienceRequest, d dVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public abstract Object leaveCustomAudience(LeaveCustomAudienceRequest leaveCustomAudienceRequest, d dVar);

    @RequiresExtension(extension = 1000000, version = 4)
    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    private static final class Api33Ext4Impl extends CustomAudienceManager {
        /* access modifiers changed from: private */
        public final android.adservices.customaudience.CustomAudienceManager customAudienceManager;

        public Api33Ext4Impl(android.adservices.customaudience.CustomAudienceManager customAudienceManager2) {
            m.e(customAudienceManager2, "customAudienceManager");
            this.customAudienceManager = customAudienceManager2;
        }

        private final List<AdData> convertAdData(List<androidx.privacysandbox.ads.adservices.common.AdData> list) {
            ArrayList arrayList = new ArrayList();
            for (androidx.privacysandbox.ads.adservices.common.AdData next : list) {
                AdData a5 = v.a().setMetadata(next.getMetadata()).setRenderUri(next.getRenderUri()).build();
                m.d(a5, "Builder()\n              …                 .build()");
                arrayList.add(a5);
            }
            return arrayList;
        }

        private final AdTechIdentifier convertAdTechIdentifier(androidx.privacysandbox.ads.adservices.common.AdTechIdentifier adTechIdentifier) {
            AdTechIdentifier a5 = AdTechIdentifier.fromString(adTechIdentifier.getIdentifier());
            m.d(a5, "fromString(input.identifier)");
            return a5;
        }

        private final AdSelectionSignals convertBiddingSignals(androidx.privacysandbox.ads.adservices.common.AdSelectionSignals adSelectionSignals) {
            if (adSelectionSignals == null) {
                return null;
            }
            return AdSelectionSignals.fromString(adSelectionSignals.getSignals());
        }

        private final CustomAudience convertCustomAudience(CustomAudience customAudience) {
            CustomAudience a5 = r.a().setActivationTime(TimeConversions.convert(customAudience.getActivationTime())).setAds(convertAdData(customAudience.getAds())).setBiddingLogicUri(customAudience.getBiddingLogicUri()).setBuyer(convertAdTechIdentifier(customAudience.getBuyer())).setDailyUpdateUri(customAudience.getDailyUpdateUri()).setExpirationTime(TimeConversions.convert(customAudience.getExpirationTime())).setName(customAudience.getName()).setTrustedBiddingData(convertTrustedSignals(customAudience.getTrustedBiddingSignals())).setUserBiddingSignals(convertBiddingSignals(customAudience.getUserBiddingSignals())).build();
            m.d(a5, "Builder()\n              …\n                .build()");
            return a5;
        }

        /* access modifiers changed from: private */
        public final JoinCustomAudienceRequest convertJoinRequest(JoinCustomAudienceRequest joinCustomAudienceRequest) {
            JoinCustomAudienceRequest a5 = t.a().setCustomAudience(convertCustomAudience(joinCustomAudienceRequest.getCustomAudience())).build();
            m.d(a5, "Builder()\n              …\n                .build()");
            return a5;
        }

        /* access modifiers changed from: private */
        public final LeaveCustomAudienceRequest convertLeaveRequest(LeaveCustomAudienceRequest leaveCustomAudienceRequest) {
            LeaveCustomAudienceRequest a5 = s.a().setBuyer(convertAdTechIdentifier(leaveCustomAudienceRequest.getBuyer())).setName(leaveCustomAudienceRequest.getName()).build();
            m.d(a5, "Builder()\n              …\n                .build()");
            return a5;
        }

        private final TrustedBiddingData convertTrustedSignals(TrustedBiddingData trustedBiddingData) {
            if (trustedBiddingData == null) {
                return null;
            }
            return u.a().setTrustedBiddingKeys(trustedBiddingData.getTrustedBiddingKeys()).setTrustedBiddingUri(trustedBiddingData.getTrustedBiddingUri()).build();
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public Object joinCustomAudience(JoinCustomAudienceRequest joinCustomAudienceRequest, d dVar) {
            C0991n nVar = new C0991n(b.b(dVar), 1);
            nVar.z();
            this.customAudienceManager.joinCustomAudience(convertJoinRequest(joinCustomAudienceRequest), new h(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
            Object v4 = nVar.v();
            if (v4 == b.c()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            if (v4 == b.c()) {
                return v4;
            }
            return s.f8222a;
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public Object leaveCustomAudience(LeaveCustomAudienceRequest leaveCustomAudienceRequest, d dVar) {
            C0991n nVar = new C0991n(b.b(dVar), 1);
            nVar.z();
            this.customAudienceManager.leaveCustomAudience(convertLeaveRequest(leaveCustomAudienceRequest), new h(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
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
        public Api33Ext4Impl(android.content.Context r2) {
            /*
                r1 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.m.e(r2, r0)
                java.lang.Class r0 = androidx.privacysandbox.ads.adservices.customaudience.x.a()
                java.lang.Object r2 = r2.getSystemService(r0)
                java.lang.String r0 = "context.getSystemService…:class.java\n            )"
                kotlin.jvm.internal.m.d(r2, r0)
                android.adservices.customaudience.CustomAudienceManager r2 = androidx.privacysandbox.ads.adservices.customaudience.y.a(r2)
                r1.<init>((android.adservices.customaudience.CustomAudienceManager) r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager.Api33Ext4Impl.<init>(android.content.Context):void");
        }
    }
}
