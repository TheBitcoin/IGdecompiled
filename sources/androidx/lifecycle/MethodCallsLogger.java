package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MethodCallsLogger {
    private final Map<String, Integer> calledMethods = new HashMap();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean approveCall(String str, int i4) {
        int i5;
        m.e(str, RewardPlus.NAME);
        Integer num = this.calledMethods.get(str);
        boolean z4 = false;
        if (num != null) {
            i5 = num.intValue();
        } else {
            i5 = 0;
        }
        if ((i5 & i4) != 0) {
            z4 = true;
        }
        this.calledMethods.put(str, Integer.valueOf(i4 | i5));
        return !z4;
    }
}
