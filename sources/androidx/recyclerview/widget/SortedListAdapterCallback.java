package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

public abstract class SortedListAdapterCallback<T2> extends SortedList.Callback<T2> {
    final RecyclerView.Adapter<?> mAdapter;

    public SortedListAdapterCallback(@SuppressLint({"UnknownNullness", "MissingNullability"}) RecyclerView.Adapter<?> adapter) {
        this.mAdapter = adapter;
    }

    public void onChanged(int i4, int i5) {
        this.mAdapter.notifyItemRangeChanged(i4, i5);
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

    @SuppressLint({"UnknownNullness"})
    public void onChanged(int i4, int i5, Object obj) {
        this.mAdapter.notifyItemRangeChanged(i4, i5, obj);
    }
}
