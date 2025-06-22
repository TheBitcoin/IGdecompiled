package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public final class AdapterListUpdateCallback implements ListUpdateCallback {
    @NonNull
    private final RecyclerView.Adapter mAdapter;

    public AdapterListUpdateCallback(@NonNull RecyclerView.Adapter adapter) {
        this.mAdapter = adapter;
    }

    @SuppressLint({"UnknownNullness"})
    public void onChanged(int i4, int i5, Object obj) {
        this.mAdapter.notifyItemRangeChanged(i4, i5, obj);
    }

    public void onInserted(int i4, int i5) {
        this.mAdapter.notifyItemRangeInserted(i4, i5);
    }

    public void onMoved(int i4, int i5) {
        this.mAdapter.notifyItemMoved(i4, i5);
    }

    public void onRemoved(int i4, int i5) {
        this.mAdapter.notifyItemRangeRemoved(i4, i5);
    }
}
