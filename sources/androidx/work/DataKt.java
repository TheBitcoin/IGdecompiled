package androidx.work;

import R2.l;
import androidx.exifinterface.media.ExifInterface;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import androidx.work.Data;
import kotlin.jvm.internal.m;

public final class DataKt {
    public static final /* synthetic */ <T> boolean hasKeyWithValueOfType(Data data, String str) {
        m.e(data, "<this>");
        m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
        m.j(4, ExifInterface.GPS_DIRECTION_TRUE);
        return data.hasKeyWithValueOfType(str, Object.class);
    }

    public static final Data workDataOf(l... lVarArr) {
        m.e(lVarArr, "pairs");
        Data.Builder builder = new Data.Builder();
        for (l lVar : lVarArr) {
            builder.put((String) lVar.c(), lVar.d());
        }
        Data build = builder.build();
        m.d(build, "dataBuilder.build()");
        return build;
    }
}
