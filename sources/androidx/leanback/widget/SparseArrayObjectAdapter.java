package androidx.leanback.widget;

import android.util.SparseArray;

public class SparseArrayObjectAdapter extends ObjectAdapter {
    private SparseArray<Object> mItems = new SparseArray<>();

    public SparseArrayObjectAdapter(PresenterSelector presenterSelector) {
        super(presenterSelector);
    }

    public void clear(int i4) {
        int indexOfKey = this.mItems.indexOfKey(i4);
        if (indexOfKey >= 0) {
            this.mItems.removeAt(indexOfKey);
            notifyItemRangeRemoved(indexOfKey, 1);
        }
    }

    public Object get(int i4) {
        return this.mItems.valueAt(i4);
    }

    public int indexOf(Object obj) {
        return this.mItems.indexOfValue(obj);
    }

    public boolean isImmediateNotifySupported() {
        return true;
    }

    public Object lookup(int i4) {
        return this.mItems.get(i4);
    }

    public void notifyArrayItemRangeChanged(int i4, int i5) {
        notifyItemRangeChanged(i4, i5);
    }

    public void set(int i4, Object obj) {
        int indexOfKey = this.mItems.indexOfKey(i4);
        if (indexOfKey < 0) {
            this.mItems.append(i4, obj);
            notifyItemRangeInserted(this.mItems.indexOfKey(i4), 1);
        } else if (this.mItems.valueAt(indexOfKey) != obj) {
            this.mItems.setValueAt(indexOfKey, obj);
            notifyItemRangeChanged(indexOfKey, 1);
        }
    }

    public int size() {
        return this.mItems.size();
    }

    public int indexOf(int i4) {
        return this.mItems.indexOfKey(i4);
    }

    public SparseArrayObjectAdapter(Presenter presenter) {
        super(presenter);
    }

    public void clear() {
        int size = this.mItems.size();
        if (size != 0) {
            this.mItems.clear();
            notifyItemRangeRemoved(0, size);
        }
    }

    public SparseArrayObjectAdapter() {
    }
}
