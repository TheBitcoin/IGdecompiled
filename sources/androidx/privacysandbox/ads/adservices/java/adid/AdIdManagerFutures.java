package androidx.privacysandbox.ads.adservices.java.adid;

import V2.d;
import V2.g;
import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.adid.AdIdManager;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o0.C2172d;
import o3.K;
import o3.L;
import o3.Y;

public abstract class AdIdManagerFutures {
    public static final Companion Companion = new Companion((C2103g) null);

    private static final class Api33Ext4JavaImpl extends AdIdManagerFutures {
        /* access modifiers changed from: private */
        public final AdIdManager mAdIdManager;

        public Api33Ext4JavaImpl(AdIdManager adIdManager) {
            m.e(adIdManager, "mAdIdManager");
            this.mAdIdManager = adIdManager;
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_AD_ID")
        @DoNotInline
        public C2172d getAdIdAsync() {
            return CoroutineAdapterKt.asListenableFuture$default(C0981i.b(K.a(Y.a()), (g) null, (L) null, new AdIdManagerFutures$Api33Ext4JavaImpl$getAdIdAsync$1(this, (d) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        public final AdIdManagerFutures from(Context context) {
            m.e(context, "context");
            AdIdManager obtain = AdIdManager.Companion.obtain(context);
            if (obtain != null) {
                return new Api33Ext4JavaImpl(obtain);
            }
            return null;
        }

        private Companion() {
        }
    }

    public static final AdIdManagerFutures from(Context context) {
        return Companion.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_AD_ID")
    public abstract C2172d getAdIdAsync();
}
