package androidx.leanback.app;

import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.Row;

class ListRowDataAdapter extends ObjectAdapter {
    public static final int ON_CHANGED = 16;
    public static final int ON_ITEM_RANGE_CHANGED = 2;
    public static final int ON_ITEM_RANGE_INSERTED = 4;
    public static final int ON_ITEM_RANGE_REMOVED = 8;
    private final ObjectAdapter mAdapter;
    final ObjectAdapter.DataObserver mDataObserver;
    int mLastVisibleRowIndex;

    private class QueueBasedDataObserver extends ObjectAdapter.DataObserver {
        QueueBasedDataObserver() {
        }

        public void onChanged() {
            ListRowDataAdapter.this.initialize();
            ListRowDataAdapter.this.notifyChanged();
        }
    }

    private class SimpleDataObserver extends ObjectAdapter.DataObserver {
        SimpleDataObserver() {
        }

        public void onChanged() {
            ListRowDataAdapter.this.initialize();
            onEventFired(16, -1, -1);
        }

        /* access modifiers changed from: protected */
        public void onEventFired(int i4, int i5, int i6) {
            ListRowDataAdapter.this.doNotify(i4, i5, i6);
        }

        public void onItemRangeChanged(int i4, int i5) {
            int i6 = ListRowDataAdapter.this.mLastVisibleRowIndex;
            if (i4 <= i6) {
                onEventFired(2, i4, Math.min(i5, (i6 - i4) + 1));
            }
        }

        public void onItemRangeInserted(int i4, int i5) {
            ListRowDataAdapter listRowDataAdapter = ListRowDataAdapter.this;
            int i6 = listRowDataAdapter.mLastVisibleRowIndex;
            if (i4 <= i6) {
                listRowDataAdapter.mLastVisibleRowIndex = i6 + i5;
                onEventFired(4, i4, i5);
                return;
            }
            listRowDataAdapter.initialize();
            int i7 = ListRowDataAdapter.this.mLastVisibleRowIndex;
            if (i7 > i6) {
                onEventFired(4, i6 + 1, i7 - i6);
            }
        }

        public void onItemRangeRemoved(int i4, int i5) {
            int i6 = (i4 + i5) - 1;
            ListRowDataAdapter listRowDataAdapter = ListRowDataAdapter.this;
            int i7 = listRowDataAdapter.mLastVisibleRowIndex;
            if (i6 < i7) {
                listRowDataAdapter.mLastVisibleRowIndex = i7 - i5;
                onEventFired(8, i4, i5);
                return;
            }
            listRowDataAdapter.initialize();
            int i8 = ListRowDataAdapter.this.mLastVisibleRowIndex;
            int i9 = i7 - i8;
            if (i9 > 0) {
                onEventFired(8, Math.min(i8 + 1, i4), i9);
            }
        }
    }

    public ListRowDataAdapter(ObjectAdapter objectAdapter) {
        super(objectAdapter.getPresenterSelector());
        this.mAdapter = objectAdapter;
        initialize();
        if (objectAdapter.isImmediateNotifySupported()) {
            this.mDataObserver = new SimpleDataObserver();
        } else {
            this.mDataObserver = new QueueBasedDataObserver();
        }
        attach();
    }

    /* access modifiers changed from: package-private */
    public void attach() {
        initialize();
        this.mAdapter.registerObserver(this.mDataObserver);
    }

    /* access modifiers changed from: package-private */
    public void detach() {
        this.mAdapter.unregisterObserver(this.mDataObserver);
    }

    /* access modifiers changed from: package-private */
    public void doNotify(int i4, int i5, int i6) {
        if (i4 == 2) {
            notifyItemRangeChanged(i5, i6);
        } else if (i4 == 4) {
            notifyItemRangeInserted(i5, i6);
        } else if (i4 == 8) {
            notifyItemRangeRemoved(i5, i6);
        } else if (i4 == 16) {
            notifyChanged();
        } else {
            throw new IllegalArgumentException("Invalid event type " + i4);
        }
    }

    public Object get(int i4) {
        return this.mAdapter.get(i4);
    }

    /* access modifiers changed from: package-private */
    public void initialize() {
        this.mLastVisibleRowIndex = -1;
        for (int size = this.mAdapter.size() - 1; size >= 0; size--) {
            if (((Row) this.mAdapter.get(size)).isRenderedAsRowView()) {
                this.mLastVisibleRowIndex = size;
                return;
            }
        }
    }

    public int size() {
        return this.mLastVisibleRowIndex + 1;
    }
}
