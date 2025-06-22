package androidx.leanback.app;

import android.app.Fragment;
import android.os.Build;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class PermissionHelper {
    private PermissionHelper() {
    }

    public static void requestPermissions(Fragment fragment, String[] strArr, int i4) {
        if (Build.VERSION.SDK_INT >= 23) {
            fragment.requestPermissions(strArr, i4);
        }
    }
}
