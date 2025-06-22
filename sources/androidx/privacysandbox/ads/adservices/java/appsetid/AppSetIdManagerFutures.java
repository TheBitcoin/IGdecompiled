package androidx.privacysandbox.ads.adservices.java.appsetid;

import V2.d;
import V2.g;
import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManager;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o0.C2172d;
import o3.K;
import o3.L;
import o3.Y;

public abstract class AppSetIdManagerFutures {
    public static final Companion Companion = new Companion((C2103g) null);

    private static final class Api33Ext4JavaImpl extends AppSetIdManagerFutures {
        /* access modifiers changed from: private */
        public final AppSetIdManager mAppSetIdManager;

        public Api33Ext4JavaImpl(AppSetIdManager appSetIdManager) {
            m.e(appSetIdManager, "mAppSetIdManager");
            this.mAppSetIdManager = appSetIdManager;
        }

        @DoNotInline
        public C2172d getAppSetIdAsync() {
            return CoroutineAdapterKt.asListenableFuture$default(C0981i.b(K.a(Y.a()), (g) null, (L) null, new AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1(this, (d) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        public final AppSetIdManagerFutures from(Context context) {
            m.e(context, "context");
            AppSetIdManager obtain = AppSetIdManager.Companion.obtain(context);
            if (obtain != null) {
                return new Api33Ext4JavaImpl(obtain);
            }
            return null;
        }

        private Companion() {
        }
    }

    public static final AppSetIdManagerFutures from(Context context) {
        return Companion.from(context);
    }

    public abstract C2172d getAppSetIdAsync();
}
