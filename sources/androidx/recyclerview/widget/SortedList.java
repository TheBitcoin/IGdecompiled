package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class SortedList<T> {
    private static final int CAPACITY_GROWTH = 10;
    private static final int DELETION = 2;
    private static final int INSERTION = 1;
    public static final int INVALID_POSITION = -1;
    private static final int LOOKUP = 4;
    private static final int MIN_CAPACITY = 10;
    private BatchedCallback mBatchedCallback;
    private Callback mCallback;
    T[] mData;
    private int mNewDataStart;
    private T[] mOldData;
    private int mOldDataSize;
    private int mOldDataStart;
    private int mSize;
    private final Class<T> mTClass;

    public static class BatchedCallback<T2> extends Callback<T2> {
        private final BatchingListUpdateCallback mBatchingListUpdateCallback;
        final Callback<T2> mWrappedCallback;

        @SuppressLint({"UnknownNullness"})
        public BatchedCallback(Callback<T2> callback) {
            this.mWrappedCallback = callback;
            this.mBatchingListUpdateCallback = new BatchingListUpdateCallback(callback);
        }

        public boolean areContentsTheSame(T2 t22, T2 t23) {
            return this.mWrappedCallback.areContentsTheSame(t22, t23);
        }

        public boolean areItemsTheSame(T2 t22, T2 t23) {
            return this.mWrappedCallback.areItemsTheSame(t22, t23);
        }

        public int compare(T2 t22, T2 t23) {
            return this.mWrappedCallback.compare(t22, t23);
        }

        public void dispatchLastEvent() {
            this.mBatchingListUpdateCallback.dispatchLastEvent();
        }

        @Nullable
        public Object getChangePayload(T2 t22, T2 t23) {
            return this.mWrappedCallback.getChangePayload(t22, t23);
        }

        public void onChanged(int i4, int i5) {
            this.mBatchingListUpdateCallback.onChanged(i4, i5, (Object) null);
        }

        public void onInserted(int i4, int i5) {
            this.mBatchingListUpdateCallback.onInserted(i4, i5);
        }

        public void onMoved(int i4, int i5) {
            this.mBatchingListUpdateCallback.onMoved(i4, i5);
        }

        public void onRemoved(int i4, int i5) {
            this.mBatchingListUpdateCallback.onRemoved(i4, i5);
        }

        @SuppressLint({"UnknownNullness"})
        public void onChanged(int i4, int i5, Object obj) {
            this.mBatchingListUpdateCallback.onChanged(i4, i5, obj);
        }
    }

    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public abstract boolean areContentsTheSame(T2 t22, T2 t23);

        public abstract boolean areItemsTheSame(T2 t22, T2 t23);

        public abstract int compare(T2 t22, T2 t23);

        @Nullable
        public Object getChangePayload(T2 t22, T2 t23) {
            return null;
        }

        public abstract void onChanged(int i4, int i5);

        @SuppressLint({"UnknownNullness"})
        public void onChanged(int i4, int i5, Object obj) {
            onChanged(i4, i5);
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback) {
        this(cls, callback, 10);
    }

    private void addAllInternal(T[] tArr) {
        if (tArr.length >= 1) {
            int sortAndDedup = sortAndDedup(tArr);
            if (this.mSize == 0) {
                this.mData = tArr;
                this.mSize = sortAndDedup;
                this.mCallback.onInserted(0, sortAndDedup);
                return;
            }
            merge(tArr, sortAndDedup);
        }
    }

    private void addToData(int i4, T t4) {
        int i5 = this.mSize;
        if (i4 <= i5) {
            T[] tArr = this.mData;
            if (i5 == tArr.length) {
                T[] tArr2 = (Object[]) Array.newInstance(this.mTClass, tArr.length + 10);
                System.arraycopy(this.mData, 0, tArr2, 0, i4);
                tArr2[i4] = t4;
                System.arraycopy(this.mData, i4, tArr2, i4 + 1, this.mSize - i4);
                this.mData = tArr2;
            } else {
                System.arraycopy(tArr, i4, tArr, i4 + 1, i5 - i4);
                this.mData[i4] = t4;
            }
            this.mSize++;
            return;
        }
        throw new IndexOutOfBoundsException("cannot add item to " + i4 + " because size is " + this.mSize);
    }

    private T[] copyArray(T[] tArr) {
        T[] tArr2 = (Object[]) Array.newInstance(this.mTClass, tArr.length);
        System.arraycopy(tArr, 0, tArr2, 0, tArr.length);
        return tArr2;
    }

    private int findIndexOf(T t4, T[] tArr, int i4, int i5, int i6) {
        while (i4 < i5) {
            int i7 = (i4 + i5) / 2;
            T t5 = tArr[i7];
            int compare = this.mCallback.compare(t5, t4);
            if (compare < 0) {
                i4 = i7 + 1;
            } else if (compare == 0) {
                if (!this.mCallback.areItemsTheSame(t5, t4)) {
                    int linearEqualitySearch = linearEqualitySearch(t4, i7, i4, i5);
                    if (!(i6 == 1 && linearEqualitySearch == -1)) {
                        return linearEqualitySearch;
                    }
                }
                return i7;
            } else {
                i5 = i7;
            }
        }
        if (i6 == 1) {
            return i4;
        }
        return -1;
    }

    private int findSameItem(T t4, T[] tArr, int i4, int i5) {
        while (i4 < i5) {
            if (this.mCallback.areItemsTheSame(tArr[i4], t4)) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    private int linearEqualitySearch(T t4, int i4, int i5, int i6) {
        T t5;
        int i7 = i4 - 1;
        while (i7 >= i5) {
            T t6 = this.mData[i7];
            if (this.mCallback.compare(t6, t4) != 0) {
                break;
            } else if (this.mCallback.areItemsTheSame(t6, t4)) {
                return i7;
            } else {
                i7--;
            }
        }
        do {
            i4++;
            if (i4 >= i6) {
                return -1;
            }
            t5 = this.mData[i4];
            if (this.mCallback.compare(t5, t4) != 0) {
                return -1;
            }
        } while (!this.mCallback.areItemsTheSame(t5, t4));
        return i4;
    }

    private void merge(T[] tArr, int i4) {
        boolean z4 = this.mCallback instanceof BatchedCallback;
        if (!z4) {
            beginBatchedUpdates();
        }
        this.mOldData = this.mData;
        int i5 = 0;
        this.mOldDataStart = 0;
        int i6 = this.mSize;
        this.mOldDataSize = i6;
        this.mData = (Object[]) Array.newInstance(this.mTClass, i6 + i4 + 10);
        this.mNewDataStart = 0;
        while (true) {
            int i7 = this.mOldDataStart;
            int i8 = this.mOldDataSize;
            if (i7 >= i8 && i5 >= i4) {
                break;
            } else if (i7 == i8) {
                int i9 = i4 - i5;
                System.arraycopy(tArr, i5, this.mData, this.mNewDataStart, i9);
                int i10 = this.mNewDataStart + i9;
                this.mNewDataStart = i10;
                this.mSize += i9;
                this.mCallback.onInserted(i10 - i9, i9);
                break;
            } else if (i5 == i4) {
                int i11 = i8 - i7;
                System.arraycopy(this.mOldData, i7, this.mData, this.mNewDataStart, i11);
                this.mNewDataStart += i11;
                break;
            } else {
                T t4 = this.mOldData[i7];
                T t5 = tArr[i5];
                int compare = this.mCallback.compare(t4, t5);
                if (compare > 0) {
                    T[] tArr2 = this.mData;
                    int i12 = this.mNewDataStart;
                    this.mNewDataStart = i12 + 1;
                    tArr2[i12] = t5;
                    this.mSize++;
                    i5++;
                    this.mCallback.onInserted(i12, 1);
                } else if (compare != 0 || !this.mCallback.areItemsTheSame(t4, t5)) {
                    T[] tArr3 = this.mData;
                    int i13 = this.mNewDataStart;
                    this.mNewDataStart = i13 + 1;
                    tArr3[i13] = t4;
                    this.mOldDataStart++;
                } else {
                    T[] tArr4 = this.mData;
                    int i14 = this.mNewDataStart;
                    this.mNewDataStart = i14 + 1;
                    tArr4[i14] = t5;
                    i5++;
                    this.mOldDataStart++;
                    if (!this.mCallback.areContentsTheSame(t4, t5)) {
                        Callback callback = this.mCallback;
                        callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t4, t5));
                    }
                }
            }
        }
        this.mOldData = null;
        if (!z4) {
            endBatchedUpdates();
        }
    }

    private void removeItemAtIndex(int i4, boolean z4) {
        T[] tArr = this.mData;
        System.arraycopy(tArr, i4 + 1, tArr, i4, (this.mSize - i4) - 1);
        int i5 = this.mSize - 1;
        this.mSize = i5;
        this.mData[i5] = null;
        if (z4) {
            this.mCallback.onRemoved(i4, 1);
        }
    }

    private void replaceAllInsert(T t4) {
        T[] tArr = this.mData;
        int i4 = this.mNewDataStart;
        tArr[i4] = t4;
        this.mNewDataStart = i4 + 1;
        this.mSize++;
        this.mCallback.onInserted(i4, 1);
    }

    private void replaceAllInternal(@NonNull T[] tArr) {
        boolean z4 = this.mCallback instanceof BatchedCallback;
        if (!z4) {
            beginBatchedUpdates();
        }
        this.mOldDataStart = 0;
        this.mOldDataSize = this.mSize;
        this.mOldData = this.mData;
        this.mNewDataStart = 0;
        int sortAndDedup = sortAndDedup(tArr);
        this.mData = (Object[]) Array.newInstance(this.mTClass, sortAndDedup);
        while (true) {
            int i4 = this.mNewDataStart;
            if (i4 >= sortAndDedup && this.mOldDataStart >= this.mOldDataSize) {
                break;
            }
            int i5 = this.mOldDataStart;
            int i6 = this.mOldDataSize;
            if (i5 >= i6) {
                int i7 = sortAndDedup - i4;
                System.arraycopy(tArr, i4, this.mData, i4, i7);
                this.mNewDataStart += i7;
                this.mSize += i7;
                this.mCallback.onInserted(i4, i7);
                break;
            } else if (i4 >= sortAndDedup) {
                int i8 = i6 - i5;
                this.mSize -= i8;
                this.mCallback.onRemoved(i4, i8);
                break;
            } else {
                T t4 = this.mOldData[i5];
                T t5 = tArr[i4];
                int compare = this.mCallback.compare(t4, t5);
                if (compare < 0) {
                    replaceAllRemove();
                } else if (compare > 0) {
                    replaceAllInsert(t5);
                } else if (!this.mCallback.areItemsTheSame(t4, t5)) {
                    replaceAllRemove();
                    replaceAllInsert(t5);
                } else {
                    T[] tArr2 = this.mData;
                    int i9 = this.mNewDataStart;
                    tArr2[i9] = t5;
                    this.mOldDataStart++;
                    this.mNewDataStart = i9 + 1;
                    if (!this.mCallback.areContentsTheSame(t4, t5)) {
                        Callback callback = this.mCallback;
                        callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t4, t5));
                    }
                }
            }
        }
        this.mOldData = null;
        if (!z4) {
            endBatchedUpdates();
        }
    }

    private void replaceAllRemove() {
        this.mSize--;
        this.mOldDataStart++;
        this.mCallback.onRemoved(this.mNewDataStart, 1);
    }

    private int sortAndDedup(@NonNull T[] tArr) {
        if (tArr.length == 0) {
            return 0;
        }
        Arrays.sort(tArr, this.mCallback);
        int i4 = 1;
        int i5 = 0;
        for (int i6 = 1; i6 < tArr.length; i6++) {
            T t4 = tArr[i6];
            if (this.mCallback.compare(tArr[i5], t4) == 0) {
                int findSameItem = findSameItem(t4, tArr, i5, i4);
                if (findSameItem != -1) {
                    tArr[findSameItem] = t4;
                } else {
                    if (i4 != i6) {
                        tArr[i4] = t4;
                    }
                    i4++;
                }
            } else {
                if (i4 != i6) {
                    tArr[i4] = t4;
                }
                i5 = i4;
                i4++;
            }
        }
        return i4;
    }

    private void throwIfInMutationOperation() {
        if (this.mOldData != null) {
            throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
        }
    }

    public int add(T t4) {
        throwIfInMutationOperation();
        return add(t4, true);
    }

    public void addAll(@NonNull T[] tArr, boolean z4) {
        throwIfInMutationOperation();
        if (tArr.length != 0) {
            if (z4) {
                addAllInternal(tArr);
            } else {
                addAllInternal(copyArray(tArr));
            }
        }
    }

    public void beginBatchedUpdates() {
        throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (!(callback instanceof BatchedCallback)) {
            if (this.mBatchedCallback == null) {
                this.mBatchedCallback = new BatchedCallback(callback);
            }
            this.mCallback = this.mBatchedCallback;
        }
    }

    public void clear() {
        throwIfInMutationOperation();
        int i4 = this.mSize;
        if (i4 != 0) {
            Arrays.fill(this.mData, 0, i4, (Object) null);
            this.mSize = 0;
            this.mCallback.onRemoved(0, i4);
        }
    }

    public void endBatchedUpdates() {
        throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (callback instanceof BatchedCallback) {
            ((BatchedCallback) callback).dispatchLastEvent();
        }
        Callback callback2 = this.mCallback;
        BatchedCallback batchedCallback = this.mBatchedCallback;
        if (callback2 == batchedCallback) {
            this.mCallback = batchedCallback.mWrappedCallback;
        }
    }

    public T get(int i4) throws IndexOutOfBoundsException {
        int i5;
        if (i4 >= this.mSize || i4 < 0) {
            throw new IndexOutOfBoundsException("Asked to get item at " + i4 + " but size is " + this.mSize);
        }
        T[] tArr = this.mOldData;
        if (tArr == null || i4 < (i5 = this.mNewDataStart)) {
            return this.mData[i4];
        }
        return tArr[(i4 - i5) + this.mOldDataStart];
    }

    public int indexOf(T t4) {
        if (this.mOldData != null) {
            T t5 = t4;
            int findIndexOf = findIndexOf(t5, this.mData, 0, this.mNewDataStart, 4);
            T t6 = t5;
            if (findIndexOf != -1) {
                return findIndexOf;
            }
            int findIndexOf2 = findIndexOf(t6, this.mOldData, this.mOldDataStart, this.mOldDataSize, 4);
            if (findIndexOf2 != -1) {
                return (findIndexOf2 - this.mOldDataStart) + this.mNewDataStart;
            }
            return -1;
        }
        return findIndexOf(t4, this.mData, 0, this.mSize, 4);
    }

    public void recalculatePositionOfItemAt(int i4) {
        throwIfInMutationOperation();
        Object obj = get(i4);
        removeItemAtIndex(i4, false);
        int add = add(obj, false);
        if (i4 != add) {
            this.mCallback.onMoved(i4, add);
        }
    }

    public boolean remove(T t4) {
        throwIfInMutationOperation();
        return remove(t4, true);
    }

    public T removeItemAt(int i4) {
        throwIfInMutationOperation();
        T t4 = get(i4);
        removeItemAtIndex(i4, true);
        return t4;
    }

    public void replaceAll(@NonNull T[] tArr, boolean z4) {
        throwIfInMutationOperation();
        if (z4) {
            replaceAllInternal(tArr);
        } else {
            replaceAllInternal(copyArray(tArr));
        }
    }

    public int size() {
        return this.mSize;
    }

    public void updateItemAt(int i4, T t4) {
        boolean z4;
        throwIfInMutationOperation();
        T t5 = get(i4);
        if (t5 == t4 || !this.mCallback.areContentsTheSame(t5, t4)) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (t5 == t4 || this.mCallback.compare(t5, t4) != 0) {
            if (z4) {
                Callback callback = this.mCallback;
                callback.onChanged(i4, 1, callback.getChangePayload(t5, t4));
            }
            removeItemAtIndex(i4, false);
            int add = add(t4, false);
            if (i4 != add) {
                this.mCallback.onMoved(i4, add);
                return;
            }
            return;
        }
        this.mData[i4] = t4;
        if (z4) {
            Callback callback2 = this.mCallback;
            callback2.onChanged(i4, 1, callback2.getChangePayload(t5, t4));
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback, int i4) {
        this.mTClass = cls;
        this.mData = (Object[]) Array.newInstance(cls, i4);
        this.mCallback = callback;
        this.mSize = 0;
    }

    private int add(T t4, boolean z4) {
        T t5 = t4;
        int findIndexOf = findIndexOf(t5, this.mData, 0, this.mSize, 1);
        if (findIndexOf == -1) {
            findIndexOf = 0;
        } else if (findIndexOf < this.mSize) {
            T t6 = this.mData[findIndexOf];
            if (this.mCallback.areItemsTheSame(t6, t5)) {
                if (this.mCallback.areContentsTheSame(t6, t5)) {
                    this.mData[findIndexOf] = t5;
                    return findIndexOf;
                }
                this.mData[findIndexOf] = t5;
                Callback callback = this.mCallback;
                callback.onChanged(findIndexOf, 1, callback.getChangePayload(t6, t5));
                return findIndexOf;
            }
        }
        addToData(findIndexOf, t5);
        if (z4) {
            this.mCallback.onInserted(findIndexOf, 1);
        }
        return findIndexOf;
    }

    private boolean remove(T t4, boolean z4) {
        int findIndexOf = findIndexOf(t4, this.mData, 0, this.mSize, 2);
        if (findIndexOf == -1) {
            return false;
        }
        removeItemAtIndex(findIndexOf, z4);
        return true;
    }

    public void replaceAll(@NonNull T... tArr) {
        replaceAll(tArr, false);
    }

    public void addAll(@NonNull T... tArr) {
        addAll(tArr, false);
    }

    public void replaceAll(@NonNull Collection<T> collection) {
        replaceAll(collection.toArray((Object[]) Array.newInstance(this.mTClass, collection.size())), true);
    }

    public void addAll(@NonNull Collection<T> collection) {
        addAll(collection.toArray((Object[]) Array.newInstance(this.mTClass, collection.size())), true);
    }
}
