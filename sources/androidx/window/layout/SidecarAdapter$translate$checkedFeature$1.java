package androidx.window.layout;

import androidx.window.sidecar.SidecarDisplayFeature;
import d3.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class SidecarAdapter$translate$checkedFeature$1 extends n implements l {
    public static final SidecarAdapter$translate$checkedFeature$1 INSTANCE = new SidecarAdapter$translate$checkedFeature$1();

    SidecarAdapter$translate$checkedFeature$1() {
        super(1);
    }

    public final Boolean invoke(SidecarDisplayFeature sidecarDisplayFeature) {
        m.e(sidecarDisplayFeature, "$this$require");
        boolean z4 = true;
        if (!(sidecarDisplayFeature.getType() == 1 || sidecarDisplayFeature.getType() == 2)) {
            z4 = false;
        }
        return Boolean.valueOf(z4);
    }
}
