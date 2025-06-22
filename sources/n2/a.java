package N2;

import android.view.View;
import kotlin.jvm.internal.m;

public abstract class a {
    public static final void a(View view, boolean z4) {
        int i4;
        m.e(view, "<this>");
        if (z4) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        view.setVisibility(i4);
    }
}
