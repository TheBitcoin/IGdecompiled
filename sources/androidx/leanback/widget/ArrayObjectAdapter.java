package androidx.leanback.widget;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayObjectAdapter extends ObjectAdapter {
    /* access modifiers changed from: private */
    public static final Boolean DEBUG = Boolean.FALSE;
    private static final String TAG = "ArrayObjectAdapter";
    private final List mItems = new ArrayList();
    ListUpdateCallback mListUpdateCallback;
    final List mOldItems = new ArrayList();
    private List mUnmodifiableItems;

    public ArrayObjectAdapter(PresenterSelector presenterSelector) {
        super(presenterSelector);
    }

    public void add(Object obj) {
        add(this.mItems.size(), obj);
    }

    public void addAll(int i4, Collection collection) {
        int size = collection.size();
        if (size != 0) {
            this.mItems.addAll(i4, collection);
            notifyItemRangeInserted(i4, size);
        }
    }

    public void clear() {
        int size = this.mItems.size();
        if (size != 0) {
            this.mItems.clear();
            notifyItemRangeRemoved(0, size);
        }
    }

    public Object get(int i4) {
        return this.mItems.get(i4);
    }

    public int indexOf(Object obj) {
        return this.mItems.indexOf(obj);
    }

    public boolean isImmediateNotifySupported() {
        return true;
    }

    public void move(int i4, int i5) {
        if (i4 != i5) {
            this.mItems.add(i5, this.mItems.remove(i4));
            notifyItemMoved(i4, i5);
        }
    }

    public void notifyArrayItemRangeChanged(int i4, int i5) {
        notifyItemRangeChanged(i4, i5);
    }

    public boolean remove(Object obj) {
        int indexOf = this.mItems.indexOf(obj);
        if (indexOf >= 0) {
            this.mItems.remove(indexOf);
            notifyItemRangeRemoved(indexOf, 1);
        }
        if (indexOf >= 0) {
            return true;
        }
        return false;
    }

    public int removeItems(int i4, int i5) {
        int min = Math.min(i5, this.mItems.size() - i4);
        if (min <= 0) {
            return 0;
        }
        for (int i6 = 0; i6 < min; i6++) {
            this.mItems.remove(i4);
        }
        notifyItemRangeRemoved(i4, min);
        return min;
    }

    public void replace(int i4, Object obj) {
        this.mItems.set(i4, obj);
        notifyItemRangeChanged(i4, 1);
    }

    public void setItems(final List list, final DiffCallback diffCallback) {
        if (diffCallback == null) {
            this.mItems.clear();
            this.mItems.addAll(list);
            notifyChanged();
            return;
        }
        this.mOldItems.clear();
        this.mOldItems.addAll(this.mItems);
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback() {
            public boolean areContentsTheSame(int i4, int i5) {
                return diffCallback.areContentsTheSame(ArrayObjectAdapter.this.mOldItems.get(i4), list.get(i5));
            }

            public boolean areItemsTheSame(int i4, int i5) {
                return diffCallback.areItemsTheSame(ArrayObjectAdapter.this.mOldItems.get(i4), list.get(i5));
            }

            @Nullable
            public Object getChangePayload(int i4, int i5) {
                return diffCallback.getChangePayload(ArrayObjectAdapter.this.mOldItems.get(i4), list.get(i5));
            }

            public int getNewListSize() {
                return list.size();
            }

            public int getOldListSize() {
                return ArrayObjectAdapter.this.mOldItems.size();
            }
        });
        this.mItems.clear();
        this.mItems.addAll(list);
        if (this.mListUpdateCallback == null) {
            this.mListUpdateCallback = new ListUpdateCallback() {
                public void onChanged(int i4, int i5, Object obj) {
                    if (ArrayObjectAdapter.DEBUG.booleanValue()) {
                        Log.d(ArrayObjectAdapter.TAG, "onChanged");
                    }
                    ArrayObjectAdapter.this.notifyItemRangeChanged(i4, i5, obj);
                }

                public void onInserted(int i4, int i5) {
                    if (ArrayObjectAdapter.DEBUG.booleanValue()) {
                        Log.d(ArrayObjectAdapter.TAG, "onInserted");
                    }
                    ArrayObjectAdapter.this.notifyItemRangeInserted(i4, i5);
                }

                public void onMoved(int i4, int i5) {
                    if (ArrayObjectAdapter.DEBUG.booleanValue()) {
                        Log.d(ArrayObjectAdapter.TAG, "onMoved");
                    }
                    ArrayObjectAdapter.this.notifyItemMoved(i4, i5);
                }

                public void onRemoved(int i4, int i5) {
                    if (ArrayObjectAdapter.DEBUG.booleanValue()) {
                        Log.d(ArrayObjectAdapter.TAG, "onRemoved");
                    }
                    ArrayObjectAdapter.this.notifyItemRangeRemoved(i4, i5);
                }
            };
        }
        calculateDiff.dispatchUpdatesTo(this.mListUpdateCallback);
        this.mOldItems.clear();
    }

    public int size() {
        return this.mItems.size();
    }

    public <E> List<E> unmodifiableList() {
        if (this.mUnmodifiableItems == null) {
            this.mUnmodifiableItems = DesugarCollections.unmodifiableList(this.mItems);
        }
        return this.mUnmodifiableItems;
    }

    public void add(int i4, Object obj) {
        this.mItems.add(i4, obj);
        notifyItemRangeInserted(i4, 1);
    }

    public ArrayObjectAdapter(Presenter presenter) {
        super(presenter);
    }

    public ArrayObjectAdapter() {
    }
}
