package androidx.lifecycle;

import R2.m;
import R2.n;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import d3.a;
import kotlin.jvm.internal.m;
import o3.C0989m;

public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 implements LifecycleEventObserver {
    final /* synthetic */ a $block;
    final /* synthetic */ C0989m $co;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_suspendWithStateAtLeastUnchecked;

    WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1(Lifecycle.State state, Lifecycle lifecycle, C0989m mVar, a aVar) {
        this.$state = state;
        this.$this_suspendWithStateAtLeastUnchecked = lifecycle;
        this.$co = mVar;
        this.$block = aVar;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Object obj;
        m.e(lifecycleOwner, "source");
        m.e(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.Companion.upTo(this.$state)) {
            this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this);
            C0989m mVar = this.$co;
            a aVar = this.$block;
            try {
                m.a aVar2 = R2.m.f8216a;
                obj = R2.m.a(aVar.invoke());
            } catch (Throwable th) {
                m.a aVar3 = R2.m.f8216a;
                obj = R2.m.a(n.a(th));
            }
            mVar.resumeWith(obj);
        } else if (event == Lifecycle.Event.ON_DESTROY) {
            this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this);
            C0989m mVar2 = this.$co;
            m.a aVar4 = R2.m.f8216a;
            mVar2.resumeWith(R2.m.a(n.a(new LifecycleDestroyedException())));
        }
    }
}
