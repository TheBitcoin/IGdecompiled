package androidx.room.util;

import S2.C1601o;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.room.Room;
import d3.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class StringUtil {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    public static final void appendPlaceholders(StringBuilder sb, int i4) {
        m.e(sb, "builder");
        for (int i5 = 0; i5 < i4; i5++) {
            sb.append("?");
            if (i5 < i4 - 1) {
                sb.append(",");
            }
        }
    }

    public static /* synthetic */ void getEMPTY_STRING_ARRAY$annotations() {
    }

    public static final String joinIntoString(List<Integer> list) {
        if (list != null) {
            return C1601o.O(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 62, (Object) null);
        }
        return null;
    }

    public static final StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    public static final List<Integer> splitToIntList(String str) {
        List<String> i02;
        Integer num;
        if (str == null || (i02 = m3.m.i0(str, new char[]{','}, false, 0, 6, (Object) null)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String parseInt : i02) {
            try {
                num = Integer.valueOf(Integer.parseInt(parseInt));
            } catch (NumberFormatException e5) {
                Log.e(Room.LOG_TAG, "Malformed integer list", e5);
                num = null;
            }
            if (num != null) {
                arrayList.add(num);
            }
        }
        return arrayList;
    }
}
