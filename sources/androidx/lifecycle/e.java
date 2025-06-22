package androidx.lifecycle;

import q3.s;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s f958a;

    public /* synthetic */ e(s sVar) {
        this.f958a = sVar;
    }

    public final void onChanged(Object obj) {
        FlowLiveDataConversions$asFlow$1.invokeSuspend$lambda$0(this.f958a, obj);
    }
}
