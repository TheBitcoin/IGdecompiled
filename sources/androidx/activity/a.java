package androidx.activity;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f775a;

    public /* synthetic */ a(ComponentActivity componentActivity) {
        this.f775a = componentActivity;
    }

    public final void run() {
        this.f775a.invalidateMenu();
    }
}
