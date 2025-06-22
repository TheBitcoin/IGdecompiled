package d2;

import android.widget.CompoundButton;
import kotlin.jvm.internal.C;

public final /* synthetic */ class q2 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C f19971a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2 f19972b;

    public /* synthetic */ q2(C c5, C2 c22) {
        this.f19971a = c5;
        this.f19972b = c22;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        C2.U(this.f19971a, this.f19972b, compoundButton, z4);
    }
}
