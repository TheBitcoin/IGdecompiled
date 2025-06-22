package e4;

import android.widget.CompoundButton;
import e4.a;

public final /* synthetic */ class c implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f24628a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a.e f24629b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f24630c;

    public /* synthetic */ c(d dVar, a.e eVar, String str) {
        this.f24628a = dVar;
        this.f24629b = eVar;
        this.f24630c = str;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        a.e.b(this.f24628a, this.f24629b, this.f24630c, compoundButton, z4);
    }
}
