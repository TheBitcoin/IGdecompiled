package androidx.recyclerview.widget;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DiffUtil {
    private static final Comparator<Diagonal> DIAGONAL_COMPARATOR = new Comparator<Diagonal>() {
        public int compare(Diagonal diagonal, Diagonal diagonal2) {
            return diagonal.f981x - diagonal2.f981x;
        }
    };

    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i4, int i5);

        public abstract boolean areItemsTheSame(int i4, int i5);

        @Nullable
        public Object getChangePayload(int i4, int i5) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    static class CenteredArray {
        private final int[] mData;
        private final int mMid;

        CenteredArray(int i4) {
            int[] iArr = new int[i4];
            this.mData = iArr;
            this.mMid = iArr.length / 2;
        }

        /* access modifiers changed from: package-private */
        public int[] backingData() {
            return this.mData;
        }

        public void fill(int i4) {
            Arrays.fill(this.mData, i4);
        }

        /* access modifiers changed from: package-private */
        public int get(int i4) {
            return this.mData[i4 + this.mMid];
        }

        /* access modifiers changed from: package-private */
        public void set(int i4, int i5) {
            this.mData[i4 + this.mMid] = i5;
        }
    }

    static class Diagonal {
        public final int size;

        /* renamed from: x  reason: collision with root package name */
        public final int f981x;

        /* renamed from: y  reason: collision with root package name */
        public final int f982y;

        Diagonal(int i4, int i5, int i6) {
            this.f981x = i4;
            this.f982y = i5;
            this.size = i6;
        }

        /* access modifiers changed from: package-private */
        public int endX() {
            return this.f981x + this.size;
        }

        /* access modifiers changed from: package-private */
        public int endY() {
            return this.f982y + this.size;
        }
    }

    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_MASK = 15;
        private static final int FLAG_MOVED = 12;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 4;
        public static final int NO_POSITION = -1;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final List<Diagonal> mDiagonals;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;

        DiffResult(Callback callback, List<Diagonal> list, int[] iArr, int[] iArr2, boolean z4) {
            this.mDiagonals = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z4;
            addEdgeDiagonals();
            findMatchingItems();
        }

        private void addEdgeDiagonals() {
            Diagonal diagonal;
            if (this.mDiagonals.isEmpty()) {
                diagonal = null;
            } else {
                diagonal = this.mDiagonals.get(0);
            }
            if (!(diagonal != null && diagonal.f981x == 0 && diagonal.f982y == 0)) {
                this.mDiagonals.add(0, new Diagonal(0, 0, 0));
            }
            this.mDiagonals.add(new Diagonal(this.mOldListSize, this.mNewListSize, 0));
        }

        private void findMatchingAddition(int i4) {
            int i5;
            int size = this.mDiagonals.size();
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                Diagonal diagonal = this.mDiagonals.get(i7);
                while (i6 < diagonal.f982y) {
                    if (this.mNewItemStatuses[i6] != 0 || !this.mCallback.areItemsTheSame(i4, i6)) {
                        i6++;
                    } else {
                        if (this.mCallback.areContentsTheSame(i4, i6)) {
                            i5 = 8;
                        } else {
                            i5 = 4;
                        }
                        this.mOldItemStatuses[i4] = (i6 << 4) | i5;
                        this.mNewItemStatuses[i6] = (i4 << 4) | i5;
                        return;
                    }
                }
                i6 = diagonal.endY();
            }
        }

        private void findMatchingItems() {
            int i4;
            for (Diagonal next : this.mDiagonals) {
                for (int i5 = 0; i5 < next.size; i5++) {
                    int i6 = next.f981x + i5;
                    int i7 = next.f982y + i5;
                    if (this.mCallback.areContentsTheSame(i6, i7)) {
                        i4 = 1;
                    } else {
                        i4 = 2;
                    }
                    this.mOldItemStatuses[i6] = (i7 << 4) | i4;
                    this.mNewItemStatuses[i7] = (i6 << 4) | i4;
                }
            }
            if (this.mDetectMoves) {
                findMoveMatches();
            }
        }

        private void findMoveMatches() {
            int i4 = 0;
            for (Diagonal next : this.mDiagonals) {
                while (i4 < next.f981x) {
                    if (this.mOldItemStatuses[i4] == 0) {
                        findMatchingAddition(i4);
                    }
                    i4++;
                }
                i4 = next.endX();
            }
        }

        @Nullable
        private static PostponedUpdate getPostponedUpdate(Collection<PostponedUpdate> collection, int i4, boolean z4) {
            PostponedUpdate postponedUpdate;
            Iterator<PostponedUpdate> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postponedUpdate = null;
                    break;
                }
                postponedUpdate = it.next();
                if (postponedUpdate.posInOwnerList == i4 && postponedUpdate.removal == z4) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                PostponedUpdate next = it.next();
                if (z4) {
                    next.currentPos--;
                } else {
                    next.currentPos++;
                }
            }
            return postponedUpdate;
        }

        public int convertNewPositionToOld(@IntRange(from = 0) int i4) {
            if (i4 < 0 || i4 >= this.mNewListSize) {
                throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i4 + ", new list size = " + this.mNewListSize);
            }
            int i5 = this.mNewItemStatuses[i4];
            if ((i5 & 15) == 0) {
                return -1;
            }
            return i5 >> 4;
        }

        public int convertOldPositionToNew(@IntRange(from = 0) int i4) {
            if (i4 < 0 || i4 >= this.mOldListSize) {
                throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i4 + ", old list size = " + this.mOldListSize);
            }
            int i5 = this.mOldItemStatuses[i4];
            if ((i5 & 15) == 0) {
                return -1;
            }
            return i5 >> 4;
        }

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter adapter) {
            dispatchUpdatesTo((ListUpdateCallback) new AdapterListUpdateCallback(adapter));
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback;
            int i4;
            if (listUpdateCallback instanceof BatchingListUpdateCallback) {
                batchingListUpdateCallback = (BatchingListUpdateCallback) listUpdateCallback;
            } else {
                batchingListUpdateCallback = new BatchingListUpdateCallback(listUpdateCallback);
            }
            int i5 = this.mOldListSize;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i6 = this.mOldListSize;
            int i7 = this.mNewListSize;
            for (int size = this.mDiagonals.size() - 1; size >= 0; size--) {
                Diagonal diagonal = this.mDiagonals.get(size);
                int endX = diagonal.endX();
                int endY = diagonal.endY();
                while (true) {
                    if (i6 <= endX) {
                        break;
                    }
                    i6--;
                    int i8 = this.mOldItemStatuses[i6];
                    if ((i8 & 12) != 0) {
                        int i9 = i8 >> 4;
                        PostponedUpdate postponedUpdate = getPostponedUpdate(arrayDeque, i9, false);
                        if (postponedUpdate != null) {
                            int i10 = (i5 - postponedUpdate.currentPos) - 1;
                            batchingListUpdateCallback.onMoved(i6, i10);
                            if ((i8 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i10, 1, this.mCallback.getChangePayload(i6, i9));
                            }
                        } else {
                            arrayDeque.add(new PostponedUpdate(i6, (i5 - i6) - 1, true));
                        }
                    } else {
                        batchingListUpdateCallback.onRemoved(i6, 1);
                        i5--;
                    }
                }
                while (i7 > endY) {
                    i7--;
                    int i11 = this.mNewItemStatuses[i7];
                    if ((i11 & 12) != 0) {
                        int i12 = i11 >> 4;
                        PostponedUpdate postponedUpdate2 = getPostponedUpdate(arrayDeque, i12, true);
                        if (postponedUpdate2 == null) {
                            arrayDeque.add(new PostponedUpdate(i7, i5 - i6, false));
                        } else {
                            batchingListUpdateCallback.onMoved((i5 - postponedUpdate2.currentPos) - 1, i6);
                            if ((i11 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i6, 1, this.mCallback.getChangePayload(i12, i7));
                            }
                        }
                    } else {
                        batchingListUpdateCallback.onInserted(i6, 1);
                        i5++;
                    }
                }
                int i13 = diagonal.f981x;
                int i14 = diagonal.f982y;
                for (i4 = 0; i4 < diagonal.size; i4++) {
                    if ((this.mOldItemStatuses[i13] & 15) == 2) {
                        batchingListUpdateCallback.onChanged(i13, 1, this.mCallback.getChangePayload(i13, i14));
                    }
                    i13++;
                    i14++;
                }
                i6 = diagonal.f981x;
                i7 = diagonal.f982y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }
    }

    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(@NonNull T t4, @NonNull T t5);

        public abstract boolean areItemsTheSame(@NonNull T t4, @NonNull T t5);

        @Nullable
        public Object getChangePayload(@NonNull T t4, @NonNull T t5) {
            return null;
        }
    }

    private static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        PostponedUpdate(int i4, int i5, boolean z4) {
            this.posInOwnerList = i4;
            this.currentPos = i5;
            this.removal = z4;
        }
    }

    static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range() {
        }

        /* access modifiers changed from: package-private */
        public int newSize() {
            return this.newListEnd - this.newListStart;
        }

        /* access modifiers changed from: package-private */
        public int oldSize() {
            return this.oldListEnd - this.oldListStart;
        }

        public Range(int i4, int i5, int i6, int i7) {
            this.oldListStart = i4;
            this.oldListEnd = i5;
            this.newListStart = i6;
            this.newListEnd = i7;
        }
    }

    static class Snake {
        public int endX;
        public int endY;
        public boolean reverse;
        public int startX;
        public int startY;

        Snake() {
        }

        /* access modifiers changed from: package-private */
        public int diagonalSize() {
            return Math.min(this.endX - this.startX, this.endY - this.startY);
        }

        /* access modifiers changed from: package-private */
        public boolean hasAdditionOrRemoval() {
            if (this.endY - this.startY != this.endX - this.startX) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean isAddition() {
            if (this.endY - this.startY > this.endX - this.startX) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Diagonal toDiagonal() {
            if (!hasAdditionOrRemoval()) {
                int i4 = this.startX;
                return new Diagonal(i4, this.startY, this.endX - i4);
            } else if (this.reverse) {
                return new Diagonal(this.startX, this.startY, diagonalSize());
            } else {
                if (isAddition()) {
                    return new Diagonal(this.startX, this.startY + 1, diagonalSize());
                }
                return new Diagonal(this.startX + 1, this.startY, diagonalSize());
            }
        }
    }

    private DiffUtil() {
    }

    @Nullable
    private static Snake backward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i4) {
        boolean z4;
        int i5;
        int i6;
        int i7;
        int i8;
        if ((range.oldSize() - range.newSize()) % 2 == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        int oldSize = range.oldSize() - range.newSize();
        int i9 = -i4;
        int i10 = i9;
        while (i10 <= i4) {
            if (i10 == i9 || (i10 != i4 && centeredArray2.get(i10 + 1) < centeredArray2.get(i10 - 1))) {
                i6 = centeredArray2.get(i10 + 1);
                i5 = i6;
            } else {
                i6 = centeredArray2.get(i10 - 1);
                i5 = i6 - 1;
            }
            int i11 = range.newListEnd - ((range.oldListEnd - i5) - i10);
            if (i4 == 0 || i5 != i6) {
                i7 = i11;
            } else {
                i7 = i11 + 1;
            }
            while (i5 > range.oldListStart && i11 > range.newListStart && callback.areItemsTheSame(i5 - 1, i11 - 1)) {
                i5--;
                i11--;
            }
            centeredArray2.set(i10, i5);
            if (!z4 || (i8 = oldSize - i10) < i9 || i8 > i4 || centeredArray.get(i8) < i5) {
                i10 += 2;
            } else {
                Snake snake = new Snake();
                snake.startX = i5;
                snake.startY = i11;
                snake.endX = i6;
                snake.endY = i7;
                snake.reverse = true;
                return snake;
            }
        }
        return null;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback) {
        return calculateDiff(callback, true);
    }

    @Nullable
    private static Snake forward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z4 = true;
        if (Math.abs(range.oldSize() - range.newSize()) % 2 != 1) {
            z4 = false;
        }
        int oldSize = range.oldSize() - range.newSize();
        int i9 = -i4;
        int i10 = i9;
        while (i10 <= i4) {
            if (i10 == i9 || (i10 != i4 && centeredArray.get(i10 + 1) > centeredArray.get(i10 - 1))) {
                i6 = centeredArray.get(i10 + 1);
                i5 = i6;
            } else {
                i6 = centeredArray.get(i10 - 1);
                i5 = i6 + 1;
            }
            int i11 = (range.newListStart + (i5 - range.oldListStart)) - i10;
            if (i4 == 0 || i5 != i6) {
                i7 = i11;
            } else {
                i7 = i11 - 1;
            }
            while (i5 < range.oldListEnd && i11 < range.newListEnd && callback.areItemsTheSame(i5, i11)) {
                i5++;
                i11++;
            }
            centeredArray.set(i10, i5);
            if (!z4 || (i8 = oldSize - i10) < i9 + 1 || i8 > i4 - 1 || centeredArray2.get(i8) > i5) {
                i10 += 2;
            } else {
                Snake snake = new Snake();
                snake.startX = i6;
                snake.startY = i7;
                snake.endX = i5;
                snake.endY = i11;
                snake.reverse = false;
                return snake;
            }
        }
        return null;
    }

    @Nullable
    private static Snake midPoint(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2) {
        if (range.oldSize() >= 1 && range.newSize() >= 1) {
            int oldSize = ((range.oldSize() + range.newSize()) + 1) / 2;
            centeredArray.set(1, range.oldListStart);
            centeredArray2.set(1, range.oldListEnd);
            for (int i4 = 0; i4 < oldSize; i4++) {
                Snake forward = forward(range, callback, centeredArray, centeredArray2, i4);
                if (forward != null) {
                    return forward;
                }
                Snake backward = backward(range, callback, centeredArray, centeredArray2, i4);
                if (backward != null) {
                    return backward;
                }
            }
        }
        return null;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback, boolean z4) {
        Range range;
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int i4 = ((((oldListSize + newListSize) + 1) / 2) * 2) + 1;
        CenteredArray centeredArray = new CenteredArray(i4);
        CenteredArray centeredArray2 = new CenteredArray(i4);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range2 = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake midPoint = midPoint(range2, callback, centeredArray, centeredArray2);
            if (midPoint != null) {
                if (midPoint.diagonalSize() > 0) {
                    arrayList.add(midPoint.toDiagonal());
                }
                if (arrayList3.isEmpty()) {
                    range = new Range();
                } else {
                    range = (Range) arrayList3.remove(arrayList3.size() - 1);
                }
                range.oldListStart = range2.oldListStart;
                range.newListStart = range2.newListStart;
                range.oldListEnd = midPoint.startX;
                range.newListEnd = midPoint.startY;
                arrayList2.add(range);
                range2.oldListEnd = range2.oldListEnd;
                range2.newListEnd = range2.newListEnd;
                range2.oldListStart = midPoint.endX;
                range2.newListStart = midPoint.endY;
                arrayList2.add(range2);
            } else {
                arrayList3.add(range2);
            }
        }
        Collections.sort(arrayList, DIAGONAL_COMPARATOR);
        return new DiffResult(callback, arrayList, centeredArray.backingData(), centeredArray2.backingData(), z4);
    }
}
