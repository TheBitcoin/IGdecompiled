package d2;

import android.widget.CompoundButton;
import kotlin.jvm.internal.C;

public final /* synthetic */ class s2 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C f20117a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2 f20118b;

    public /* synthetic */ s2(C c5, C2 c22) {
        this.f20117a = c5;
        this.f20118b = c22;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        C2.V(this.f20117a, this.f20118b, compoundButton, z4);
    }
}
