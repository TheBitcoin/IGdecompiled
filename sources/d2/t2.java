package d2;

import android.content.Context;
import android.widget.CompoundButton;
import kotlin.jvm.internal.C;

public final /* synthetic */ class t2 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C f20124a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f20125b;

    public /* synthetic */ t2(C c5, Context context) {
        this.f20124a = c5;
        this.f20125b = context;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        C2.W(this.f20124a, this.f20125b, compoundButton, z4);
    }
}
