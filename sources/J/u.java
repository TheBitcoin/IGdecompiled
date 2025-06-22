package J;

import java.util.concurrent.Callable;

public final /* synthetic */ class u implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f356a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f357b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ z f358c;

    public /* synthetic */ u(boolean z4, String str, z zVar) {
        this.f356a = z4;
        this.f357b = str;
        this.f358c = zVar;
    }

    public final Object call() {
        return D.c(this.f356a, this.f357b, this.f358c);
    }
}
