package androidx.privacysandbox.ads.adservices.java.topics;

import V2.d;
import V2.g;
import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import androidx.privacysandbox.ads.adservices.topics.TopicsManager;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o0.C2172d;
import o3.K;
import o3.L;
import o3.Y;

public abstract class TopicsManagerFutures {
    public static final Companion Companion = new Companion((C2103g) null);

    private static final class Api33Ext4JavaImpl extends TopicsManagerFutures {
        /* access modifiers changed from: private */
        public final TopicsManager mTopicsManager;

        public Api33Ext4JavaImpl(TopicsManager topicsManager) {
            m.e(topicsManager, "mTopicsManager");
            this.mTopicsManager = topicsManager;
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
        @DoNotInline
        public C2172d getTopicsAsync(GetTopicsRequest getTopicsRequest) {
            m.e(getTopicsRequest, "request");
            return CoroutineAdapterKt.asListenableFuture$default(C0981i.b(K.a(Y.c()), (g) null, (L) null, new TopicsManagerFutures$Api33Ext4JavaImpl$getTopicsAsync$1(this, getTopicsRequest, (d) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        public final TopicsManagerFutures from(Context context) {
            m.e(context, "context");
            TopicsManager obtain = TopicsManager.Companion.obtain(context);
            if (obtain != null) {
                return new Api33Ext4JavaImpl(obtain);
            }
            return null;
        }

        private Companion() {
        }
    }

    public static final TopicsManagerFutures from(Context context) {
        return Companion.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
    public abstract C2172d getTopicsAsync(GetTopicsRequest getTopicsRequest);
}
