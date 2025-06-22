package androidx.activity;

import android.content.res.Resources;
import d3.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class SystemBarStyle$Companion$auto$1 extends n implements l {
    public static final SystemBarStyle$Companion$auto$1 INSTANCE = new SystemBarStyle$Companion$auto$1();

    SystemBarStyle$Companion$auto$1() {
        super(1);
    }

    public final Boolean invoke(Resources resources) {
        m.e(resources, "resources");
        return Boolean.valueOf((resources.getConfiguration().uiMode & 48) == 32);
    }
}
