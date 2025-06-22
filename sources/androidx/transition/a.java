package androidx.transition;

import androidx.core.os.CancellationSignal;

public final /* synthetic */ class a implements CancellationSignal.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f1026a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Transition f1027b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f1028c;

    public /* synthetic */ a(Runnable runnable, Transition transition, Runnable runnable2) {
        this.f1026a = runnable;
        this.f1027b = transition;
        this.f1028c = runnable2;
    }

    public final void onCancel() {
        FragmentTransitionSupport.a(this.f1026a, this.f1027b, this.f1028c);
    }
}
