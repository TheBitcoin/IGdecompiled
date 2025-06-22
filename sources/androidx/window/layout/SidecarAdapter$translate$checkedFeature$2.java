package androidx.window.layout;

import androidx.window.sidecar.SidecarDisplayFeature;
import d3.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class SidecarAdapter$translate$checkedFeature$2 extends n implements l {
    public static final SidecarAdapter$translate$checkedFeature$2 INSTANCE = new SidecarAdapter$translate$checkedFeature$2();

    SidecarAdapter$translate$checkedFeature$2() {
        super(1);
    }

    public final Boolean invoke(SidecarDisplayFeature sidecarDisplayFeature) {
        m.e(sidecarDisplayFeature, "$this$require");
        return Boolean.valueOf((sidecarDisplayFeature.getRect().width() == 0 && sidecarDisplayFeature.getRect().height() == 0) ? false : true);
    }
}
