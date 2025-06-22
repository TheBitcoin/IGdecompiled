package w1;

import android.app.UiModeManager;
import android.content.Context;
import q1.g;

/* renamed from: w1.a  reason: case insensitive filesystem */
public abstract class C2334a {

    /* renamed from: a  reason: collision with root package name */
    private static UiModeManager f22011a;

    public static g a() {
        UiModeManager uiModeManager = f22011a;
        if (uiModeManager == null) {
            return g.OTHER;
        }
        int currentModeType = uiModeManager.getCurrentModeType();
        if (currentModeType == 1) {
            return g.MOBILE;
        }
        if (currentModeType != 4) {
            return g.OTHER;
        }
        return g.CTV;
    }

    public static void b(Context context) {
        if (context != null) {
            f22011a = (UiModeManager) context.getSystemService("uimode");
        }
    }
}
