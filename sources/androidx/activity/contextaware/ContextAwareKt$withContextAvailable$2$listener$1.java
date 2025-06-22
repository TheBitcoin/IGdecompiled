package androidx.activity.contextaware;

import R2.m;
import R2.n;
import android.content.Context;
import d3.l;
import kotlin.jvm.internal.m;
import o3.C0989m;

public final class ContextAwareKt$withContextAvailable$2$listener$1 implements OnContextAvailableListener {
    final /* synthetic */ C0989m $co;
    final /* synthetic */ l $onContextAvailable;

    public ContextAwareKt$withContextAvailable$2$listener$1(C0989m mVar, l lVar) {
        this.$co = mVar;
        this.$onContextAvailable = lVar;
    }

    public void onContextAvailable(Context context) {
        Object obj;
        m.e(context, "context");
        C0989m mVar = this.$co;
        l lVar = this.$onContextAvailable;
        try {
            m.a aVar = R2.m.f8216a;
            obj = R2.m.a(lVar.invoke(context));
        } catch (Throwable th) {
            m.a aVar2 = R2.m.f8216a;
            obj = R2.m.a(n.a(th));
        }
        mVar.resumeWith(obj);
    }
}
