package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class CanvasUtils {
    private static Method sInorderBarrierMethod;
    private static boolean sOrderMethodsFetched;
    private static Method sReorderBarrierMethod;

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void disableZ(Canvas canvas) {
            canvas.disableZ();
        }

        @DoNotInline
        static void enableZ(Canvas canvas) {
            canvas.enableZ();
        }
    }

    private CanvasUtils() {
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    static void enableZ(@NonNull Canvas canvas, boolean z4) {
        Method method;
        Class<Canvas> cls = Canvas.class;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 29) {
            if (z4) {
                Api29Impl.enableZ(canvas);
            } else {
                Api29Impl.disableZ(canvas);
            }
        } else if (i4 != 28) {
            if (!sOrderMethodsFetched) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("insertReorderBarrier", (Class[]) null);
                    sReorderBarrierMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                    Method declaredMethod2 = cls.getDeclaredMethod("insertInorderBarrier", (Class[]) null);
                    sInorderBarrierMethod = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                sOrderMethodsFetched = true;
            }
            if (z4) {
                try {
                    Method method2 = sReorderBarrierMethod;
                    if (method2 != null) {
                        method2.invoke(canvas, (Object[]) null);
                    }
                } catch (IllegalAccessException unused2) {
                    return;
                } catch (InvocationTargetException e5) {
                    throw new RuntimeException(e5.getCause());
                }
            }
            if (!z4 && (method = sInorderBarrierMethod) != null) {
                method.invoke(canvas, (Object[]) null);
            }
        } else {
            throw new IllegalStateException("This method doesn't work on Pie!");
        }
    }
}
