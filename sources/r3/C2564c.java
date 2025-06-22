package R3;

import P3.C2548d;
import R3.C2565d;

/* renamed from: R3.c  reason: case insensitive filesystem */
public final /* synthetic */ class C2564c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2565d f23913a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f23914b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C2548d f23915c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ C2565d.a f23916d;

    public /* synthetic */ C2564c(C2565d dVar, boolean z4, C2548d dVar2, C2565d.a aVar) {
        this.f23913a = dVar;
        this.f23914b = z4;
        this.f23915c = dVar2;
        this.f23916d = aVar;
    }

    public final void run() {
        this.f23913a.d(this.f23914b, this.f23915c, this.f23916d);
    }
}
