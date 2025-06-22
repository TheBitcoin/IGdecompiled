package androidx.privacysandbox.ads.adservices.adid;

import V2.d;
import W2.b;
import android.adservices.adid.AdId;
import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C0991n;

public abstract class AdIdManager {
    public static final Companion Companion = new Companion((C2103g) null);

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        public final AdIdManager obtain(Context context) {
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
    public static final AdIdManager obtain(Context context) {
        return Companion.obtain(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_AD_ID")
    public abstract Object getAdId(d dVar);

    @RequiresExtension(extension = 1000000, version = 4)
    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    private static final class Api33Ext4Impl extends AdIdManager {
        /* access modifiers changed from: private */
        public final android.adservices.adid.AdIdManager mAdIdManager;

        public Api33Ext4Impl(android.adservices.adid.AdIdManager adIdManager) {
            m.e(adIdManager, "mAdIdManager");
            this.mAdIdManager = adIdManager;
        }

        private final AdId convertResponse(AdId adId) {
            String a5 = adId.getAdId();
            m.d(a5, "response.adId");
            return new AdId(a5, adId.isLimitAdTrackingEnabled());
        }

        /* access modifiers changed from: private */
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_AD_ID")
        public final Object getAdIdAsyncInternal(d dVar) {
            C0991n nVar = new C0991n(b.b(dVar), 1);
            nVar.z();
            this.mAdIdManager.getAdId(new h(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
            Object v4 = nVar.v();
            if (v4 == b.c()) {
                h.c(dVar);
            }
            return v4;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        @androidx.annotation.RequiresPermission("android.permission.ACCESS_ADSERVICES_AD_ID")
        @androidx.annotation.DoNotInline
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object getAdId(V2.d r5) {
            /*
                r4 = this;
                boolean r0 = r5 instanceof androidx.privacysandbox.ads.adservices.adid.AdIdManager$Api33Ext4Impl$getAdId$1
                if (r0 == 0) goto L_0x0013
                r0 = r5
                androidx.privacysandbox.ads.adservices.adid.AdIdManager$Api33Ext4Impl$getAdId$1 r0 = (androidx.privacysandbox.ads.adservices.adid.AdIdManager$Api33Ext4Impl$getAdId$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                androidx.privacysandbox.ads.adservices.adid.AdIdManager$Api33Ext4Impl$getAdId$1 r0 = new androidx.privacysandbox.ads.adservices.adid.AdIdManager$Api33Ext4Impl$getAdId$1
                r0.<init>(r4, r5)
            L_0x0018:
                java.lang.Object r5 = r0.result
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L_0x0035
                if (r2 != r3) goto L_0x002d
                java.lang.Object r0 = r0.L$0
                androidx.privacysandbox.ads.adservices.adid.AdIdManager$Api33Ext4Impl r0 = (androidx.privacysandbox.ads.adservices.adid.AdIdManager.Api33Ext4Impl) r0
                R2.n.b(r5)
                goto L_0x0044
            L_0x002d:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L_0x0035:
                R2.n.b(r5)
                r0.L$0 = r4
                r0.label = r3
                java.lang.Object r5 = r4.getAdIdAsyncInternal(r0)
                if (r5 != r1) goto L_0x0043
                return r1
            L_0x0043:
                r0 = r4
            L_0x0044:
                android.adservices.adid.AdId r5 = androidx.privacysandbox.ads.adservices.adid.d.a(r5)
                androidx.privacysandbox.ads.adservices.adid.AdId r5 = r0.convertResponse(r5)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adid.AdIdManager.Api33Ext4Impl.getAdId(V2.d):java.lang.Object");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Api33Ext4Impl(android.content.Context r2) {
            /*
                r1 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.m.e(r2, r0)
                java.lang.Class r0 = androidx.privacysandbox.ads.adservices.adid.e.a()
                java.lang.Object r2 = r2.getSystemService(r0)
                java.lang.String r0 = "context.getSystemService…:class.java\n            )"
                kotlin.jvm.internal.m.d(r2, r0)
                android.adservices.adid.AdIdManager r2 = androidx.privacysandbox.ads.adservices.adid.f.a(r2)
                r1.<init>((android.adservices.adid.AdIdManager) r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adid.AdIdManager.Api33Ext4Impl.<init>(android.content.Context):void");
        }
    }
}
