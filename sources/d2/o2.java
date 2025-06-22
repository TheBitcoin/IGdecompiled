package d2;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.C;

public final /* synthetic */ class o2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2 f19957a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f19958b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C f19959c;

    public /* synthetic */ o2(C2 c22, Context context, C c5) {
        this.f19957a = c22;
        this.f19958b = context;
        this.f19959c = c5;
    }

    public final void onClick(View view) {
        C2.Z(this.f19957a, this.f19958b, this.f19959c, view);
    }
}
