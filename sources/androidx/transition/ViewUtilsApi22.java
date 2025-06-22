package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(22)
class ViewUtilsApi22 extends ViewUtilsApi21 {
    private static boolean sTryHiddenSetLeftTopRightBottom = true;

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void setLeftTopRightBottom(View view, int i4, int i5, int i6, int i7) {
            view.setLeftTopRightBottom(i4, i5, i6, i7);
        }
    }

    ViewUtilsApi22() {
    }

    @SuppressLint({"NewApi"})
    public void setLeftTopRightBottom(@NonNull View view, int i4, int i5, int i6, int i7) {
        if (sTryHiddenSetLeftTopRightBottom) {
            try {
                Api29Impl.setLeftTopRightBottom(view, i4, i5, i6, i7);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSetLeftTopRightBottom = false;
            }
        }
    }
}
