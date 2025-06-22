package androidx.privacysandbox.ads.adservices.java.appsetid;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManager;
import androidx.privacysandbox.ads.adservices.java.appsetid.AppSetIdManagerFutures;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

@f(c = "androidx.privacysandbox.ads.adservices.java.appsetid.AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1", f = "AppSetIdManagerFutures.kt", l = {50}, m = "invokeSuspend")
final class AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1 extends l implements p {
    int label;
    final /* synthetic */ AppSetIdManagerFutures.Api33Ext4JavaImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1(AppSetIdManagerFutures.Api33Ext4JavaImpl api33Ext4JavaImpl, d dVar) {
        super(2, dVar);
        this.this$0 = api33Ext4JavaImpl;
    }

    public final d create(Object obj, d dVar) {
        return new AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1(this.this$0, dVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            AppSetIdManager access$getMAppSetIdManager$p = this.this$0.mAppSetIdManager;
            this.label = 1;
            Object appSetId = access$getMAppSetIdManager$p.getAppSetId(this);
            if (appSetId == c5) {
                return c5;
            }
            return appSetId;
        } else if (i4 == 1) {
            n.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invoke(J j4, d dVar) {
        return ((AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1) create(j4, dVar)).invokeSuspend(s.f8222a);
    }
}
