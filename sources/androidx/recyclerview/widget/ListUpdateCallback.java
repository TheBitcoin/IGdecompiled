package androidx.recyclerview.widget;

import androidx.annotation.Nullable;

public interface ListUpdateCallback {
    void onChanged(int i4, int i5, @Nullable Object obj);

    void onInserted(int i4, int i5);

    void onMoved(int i4, int i5);

    void onRemoved(int i4, int i5);
}
