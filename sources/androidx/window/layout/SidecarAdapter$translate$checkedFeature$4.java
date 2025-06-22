package androidx.window.layout;

import androidx.window.sidecar.SidecarDisplayFeature;
import d3.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class SidecarAdapter$translate$checkedFeature$4 extends n implements l {
    public static final SidecarAdapter$translate$checkedFeature$4 INSTANCE = new SidecarAdapter$translate$checkedFeature$4();

    SidecarAdapter$translate$checkedFeature$4() {
        super(1);
    }

    public final Boolean invoke(SidecarDisplayFeature sidecarDisplayFeature) {
        m.e(sidecarDisplayFeature, "$this$require");
        return Boolean.valueOf(sidecarDisplayFeature.getRect().left == 0 || sidecarDisplayFeature.getRect().top == 0);
    }
}
