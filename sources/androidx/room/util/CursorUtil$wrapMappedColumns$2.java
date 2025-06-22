package androidx.room.util;

import android.database.Cursor;
import android.database.CursorWrapper;
import kotlin.jvm.internal.m;

public final class CursorUtil$wrapMappedColumns$2 extends CursorWrapper {
    final /* synthetic */ String[] $columnNames;
    final /* synthetic */ int[] $mapping;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CursorUtil$wrapMappedColumns$2(Cursor cursor, String[] strArr, int[] iArr) {
        super(cursor);
        this.$columnNames = strArr;
        this.$mapping = iArr;
    }

    public int getColumnIndex(String str) {
        m.e(str, "columnName");
        String[] strArr = this.$columnNames;
        int[] iArr = this.$mapping;
        int length = strArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int i6 = i5 + 1;
            if (m3.m.p(strArr[i4], str, true)) {
                return iArr[i5];
            }
            i4++;
            i5 = i6;
        }
        return super.getColumnIndex(str);
    }
}
