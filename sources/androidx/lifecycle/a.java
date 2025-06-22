package androidx.lifecycle;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComputableLiveData f954a;

    public /* synthetic */ a(ComputableLiveData computableLiveData) {
        this.f954a = computableLiveData;
    }

    public final void run() {
        ComputableLiveData.refreshRunnable$lambda$0(this.f954a);
    }
}
