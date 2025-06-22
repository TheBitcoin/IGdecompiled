package androidx.privacysandbox.ads.adservices.topics;

import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon", f = "TopicsManagerImplCommon.kt", l = {22}, m = "getTopics$suspendImpl")
final class TopicsManagerImplCommon$getTopics$1 extends d {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TopicsManagerImplCommon this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopicsManagerImplCommon$getTopics$1(TopicsManagerImplCommon topicsManagerImplCommon, V2.d dVar) {
        super(dVar);
        this.this$0 = topicsManagerImplCommon;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TopicsManagerImplCommon.getTopics$suspendImpl(this.this$0, (GetTopicsRequest) null, this);
    }
}
