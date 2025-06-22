package androidx.lifecycle;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComputableLiveData f955a;

    public /* synthetic */ b(ComputableLiveData computableLiveData) {
        this.f955a = computableLiveData;
    }

    public final void run() {
        ComputableLiveData.invalidationRunnable$lambda$1(this.f955a);
    }
}
