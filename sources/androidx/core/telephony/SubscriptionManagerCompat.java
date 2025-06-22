package androidx.core.telephony;

import android.os.Build;
import android.telephony.SubscriptionManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.content.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(22)
public class SubscriptionManagerCompat {
    private static Method sGetSlotIndexMethod;

    @RequiresApi(29)
    private static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static int getSlotIndex(int i4) {
            return SubscriptionManager.getSlotIndex(i4);
        }
    }

    private SubscriptionManagerCompat() {
    }

    public static int getSlotIndex(int i4) {
        if (i4 == -1) {
            return -1;
        }
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 29) {
            return Api29Impl.getSlotIndex(i4);
        }
        try {
            if (sGetSlotIndexMethod == null) {
                Class cls = Integer.TYPE;
                if (i5 >= 26) {
                    sGetSlotIndexMethod = a.a().getDeclaredMethod("getSlotIndex", new Class[]{cls});
                } else {
                    sGetSlotIndexMethod = a.a().getDeclaredMethod("getSlotId", new Class[]{cls});
                }
                sGetSlotIndexMethod.setAccessible(true);
            }
            Integer num = (Integer) sGetSlotIndexMethod.invoke((Object) null, new Object[]{Integer.valueOf(i4)});
            if (num != null) {
                return num.intValue();
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return -1;
    }
}
