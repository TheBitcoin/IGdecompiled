package J1;

import android.view.View;
import g2.C2048f;
import g2.S;

/* renamed from: J1.m2  reason: case insensitive filesystem */
public final /* synthetic */ class C1398m2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1446t2 f7070a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2048f f7071b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ S f7072c;

    public /* synthetic */ C1398m2(C1446t2 t2Var, C2048f fVar, S s4) {
        this.f7070a = t2Var;
        this.f7071b = fVar;
        this.f7072c = s4;
    }

    public final void onClick(View view) {
        C1446t2.f4(this.f7070a, this.f7071b, this.f7072c, view);
    }
}
