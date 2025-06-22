package androidx.activity.result;

import d3.l;

public final /* synthetic */ class a implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f786a;

    public /* synthetic */ a(l lVar) {
        this.f786a = lVar;
    }

    public final void onActivityResult(Object obj) {
        ActivityResultCallerKt.registerForActivityResult$lambda$0(this.f786a, obj);
    }
}
