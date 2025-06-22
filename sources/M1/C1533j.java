package M1;

import M1.C1532i;
import android.view.View;
import g2.C2050h;

/* renamed from: M1.j  reason: case insensitive filesystem */
public final /* synthetic */ class C1533j implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1532i.b f7649a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2050h f7650b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7651c;

    public /* synthetic */ C1533j(C1532i.b bVar, C2050h hVar, int i4) {
        this.f7649a = bVar;
        this.f7650b = hVar;
        this.f7651c = i4;
    }

    public final boolean onLongClick(View view) {
        return C1532i.b.n(this.f7649a, this.f7650b, this.f7651c, view);
    }
}
