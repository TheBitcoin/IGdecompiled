package androidx.privacysandbox.ads.adservices.java.customaudience;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager;
import androidx.privacysandbox.ads.adservices.customaudience.JoinCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.java.customaudience.CustomAudienceManagerFutures;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.J;

@f(c = "androidx.privacysandbox.ads.adservices.java.customaudience.CustomAudienceManagerFutures$Api33Ext4JavaImpl$joinCustomAudienceAsync$1", f = "CustomAudienceManagerFutures.kt", l = {113}, m = "invokeSuspend")
final class CustomAudienceManagerFutures$Api33Ext4JavaImpl$joinCustomAudienceAsync$1 extends l implements p {
    final /* synthetic */ JoinCustomAudienceRequest $request;
    int label;
    final /* synthetic */ CustomAudienceManagerFutures.Api33Ext4JavaImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomAudienceManagerFutures$Api33Ext4JavaImpl$joinCustomAudienceAsync$1(CustomAudienceManagerFutures.Api33Ext4JavaImpl api33Ext4JavaImpl, JoinCustomAudienceRequest joinCustomAudienceRequest, d dVar) {
        super(2, dVar);
        this.this$0 = api33Ext4JavaImpl;
        this.$request = joinCustomAudienceRequest;
    }

    public final d create(Object obj, d dVar) {
        return new CustomAudienceManagerFutures$Api33Ext4JavaImpl$joinCustomAudienceAsync$1(this.this$0, this.$request, dVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            CustomAudienceManager access$getMCustomAudienceManager$p = this.this$0.mCustomAudienceManager;
            m.b(access$getMCustomAudienceManager$p);
            JoinCustomAudienceRequest joinCustomAudienceRequest = this.$request;
            this.label = 1;
            if (access$getMCustomAudienceManager$p.joinCustomAudience(joinCustomAudienceRequest, this) == c5) {
                return c5;
            }
        } else if (i4 == 1) {
            n.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return s.f8222a;
    }

    public final Object invoke(J j4, d dVar) {
        return ((CustomAudienceManagerFutures$Api33Ext4JavaImpl$joinCustomAudienceAsync$1) create(j4, dVar)).invokeSuspend(s.f8222a);
    }
}
