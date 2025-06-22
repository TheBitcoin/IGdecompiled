package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.NonNull;

@Deprecated
public final class ListViewCompat {
    private ListViewCompat() {
    }

    @Deprecated
    public static boolean canScrollList(@NonNull ListView listView, int i4) {
        return listView.canScrollList(i4);
    }

    @Deprecated
    public static void scrollListBy(@NonNull ListView listView, int i4) {
        listView.scrollListBy(i4);
    }
}
