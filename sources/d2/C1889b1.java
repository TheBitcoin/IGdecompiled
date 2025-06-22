package d2;

import android.content.Context;
import android.content.DialogInterface;

/* renamed from: d2.b1  reason: case insensitive filesystem */
public final /* synthetic */ class C1889b1 implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1941r1 f19874a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f19875b;

    public /* synthetic */ C1889b1(C1941r1 r1Var, Context context) {
        this.f19874a = r1Var;
        this.f19875b = context;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        C1941r1.J3(this.f19874a, this.f19875b, dialogInterface);
    }
}
