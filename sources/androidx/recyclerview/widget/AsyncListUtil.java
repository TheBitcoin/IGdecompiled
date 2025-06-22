package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;

public class AsyncListUtil<T> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncListUtil";
    boolean mAllowScrollHints;
    private final ThreadUtil.BackgroundCallback<T> mBackgroundCallback;
    final ThreadUtil.BackgroundCallback<T> mBackgroundProxy;
    final DataCallback<T> mDataCallback;
    int mDisplayedGeneration = 0;
    int mItemCount = 0;
    private final ThreadUtil.MainThreadCallback<T> mMainThreadCallback;
    final ThreadUtil.MainThreadCallback<T> mMainThreadProxy;
    final SparseIntArray mMissingPositions = new SparseIntArray();
    final int[] mPrevRange = new int[2];
    int mRequestedGeneration = 0;
    private int mScrollHint = 0;
    final Class<T> mTClass;
    final TileList<T> mTileList;
    final int mTileSize;
    final int[] mTmpRange = new int[2];
    final int[] mTmpRangeExtended = new int[2];
    final ViewCallback mViewCallback;

    public static abstract class DataCallback<T> {
        @WorkerThread
        public abstract void fillData(@NonNull T[] tArr, int i4, int i5);

        @WorkerThread
        public int getMaxCachedTiles() {
            return 10;
        }

        @WorkerThread
        public void recycleData(@NonNull T[] tArr, int i4) {
        }

        @WorkerThread
        public abstract int refreshData();
    }

    public static abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        @UiThread
        public void extendRangeInto(@NonNull int[] iArr, @NonNull int[] iArr2, int i4) {
            int i5;
            int i6 = iArr[1];
            int i7 = iArr[0];
            int i8 = (i6 - i7) + 1;
            int i9 = i8 / 2;
            if (i4 == 1) {
                i5 = i8;
            } else {
                i5 = i9;
            }
            iArr2[0] = i7 - i5;
            if (i4 != 2) {
                i8 = i9;
            }
            iArr2[1] = i6 + i8;
        }

        @UiThread
        public abstract void getItemRangeInto(@NonNull int[] iArr);

        @UiThread
        public abstract void onDataRefresh();

        @UiThread
        public abstract void onItemLoaded(int i4);
    }

    public AsyncListUtil(@NonNull Class<T> cls, int i4, @NonNull DataCallback<T> dataCallback, @NonNull ViewCallback viewCallback) {
        AnonymousClass1 r02 = new ThreadUtil.MainThreadCallback<T>() {
            private boolean isRequestedGeneration(int i4) {
                if (i4 == AsyncListUtil.this.mRequestedGeneration) {
                    return true;
                }
                return false;
            }

            private void recycleAllTiles() {
                for (int i4 = 0; i4 < AsyncListUtil.this.mTileList.size(); i4++) {
                    AsyncListUtil asyncListUtil = AsyncListUtil.this;
                    asyncListUtil.mBackgroundProxy.recycleTile(asyncListUtil.mTileList.getAtIndex(i4));
                }
                AsyncListUtil.this.mTileList.clear();
            }

            public void addTile(int i4, TileList.Tile<T> tile) {
                if (!isRequestedGeneration(i4)) {
                    AsyncListUtil.this.mBackgroundProxy.recycleTile(tile);
                    return;
                }
                TileList.Tile<T> addOrReplace = AsyncListUtil.this.mTileList.addOrReplace(tile);
                if (addOrReplace != null) {
                    Log.e(AsyncListUtil.TAG, "duplicate tile @" + addOrReplace.mStartPosition);
                    AsyncListUtil.this.mBackgroundProxy.recycleTile(addOrReplace);
                }
                int i5 = tile.mStartPosition + tile.mItemCount;
                int i6 = 0;
                while (i6 < AsyncListUtil.this.mMissingPositions.size()) {
                    int keyAt = AsyncListUtil.this.mMissingPositions.keyAt(i6);
                    if (tile.mStartPosition > keyAt || keyAt >= i5) {
                        i6++;
                    } else {
                        AsyncListUtil.this.mMissingPositions.removeAt(i6);
                        AsyncListUtil.this.mViewCallback.onItemLoaded(keyAt);
                    }
                }
            }

            public void removeTile(int i4, int i5) {
                if (isRequestedGeneration(i4)) {
                    TileList.Tile<T> removeAtPos = AsyncListUtil.this.mTileList.removeAtPos(i5);
                    if (removeAtPos == null) {
                        Log.e(AsyncListUtil.TAG, "tile not found @" + i5);
                        return;
                    }
                    AsyncListUtil.this.mBackgroundProxy.recycleTile(removeAtPos);
                }
            }

            public void updateItemCount(int i4, int i5) {
                if (isRequestedGeneration(i4)) {
                    AsyncListUtil asyncListUtil = AsyncListUtil.this;
                    asyncListUtil.mItemCount = i5;
                    asyncListUtil.mViewCallback.onDataRefresh();
                    AsyncListUtil asyncListUtil2 = AsyncListUtil.this;
                    asyncListUtil2.mDisplayedGeneration = asyncListUtil2.mRequestedGeneration;
                    recycleAllTiles();
                    AsyncListUtil asyncListUtil3 = AsyncListUtil.this;
                    asyncListUtil3.mAllowScrollHints = false;
                    asyncListUtil3.updateRange();
                }
            }
        };
        this.mMainThreadCallback = r02;
        AnonymousClass2 r12 = new ThreadUtil.BackgroundCallback<T>() {
            private int mFirstRequiredTileStart;
            private int mGeneration;
            private int mItemCount;
            private int mLastRequiredTileStart;
            final SparseBooleanArray mLoadedTiles = new SparseBooleanArray();
            private TileList.Tile<T> mRecycledRoot;

            private TileList.Tile<T> acquireTile() {
                TileList.Tile<T> tile = this.mRecycledRoot;
                if (tile != null) {
                    this.mRecycledRoot = tile.mNext;
                    return tile;
                }
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                return new TileList.Tile<>(asyncListUtil.mTClass, asyncListUtil.mTileSize);
            }

            private void addTile(TileList.Tile<T> tile) {
                this.mLoadedTiles.put(tile.mStartPosition, true);
                AsyncListUtil.this.mMainThreadProxy.addTile(this.mGeneration, tile);
            }

            private void flushTileCache(int i4) {
                int maxCachedTiles = AsyncListUtil.this.mDataCallback.getMaxCachedTiles();
                while (this.mLoadedTiles.size() >= maxCachedTiles) {
                    int keyAt = this.mLoadedTiles.keyAt(0);
                    SparseBooleanArray sparseBooleanArray = this.mLoadedTiles;
                    int keyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                    int i5 = this.mFirstRequiredTileStart - keyAt;
                    int i6 = keyAt2 - this.mLastRequiredTileStart;
                    if (i5 > 0 && (i5 >= i6 || i4 == 2)) {
                        removeTile(keyAt);
                    } else if (i6 <= 0) {
                        return;
                    } else {
                        if (i5 < i6 || i4 == 1) {
                            removeTile(keyAt2);
                        } else {
                            return;
                        }
                    }
                }
            }

            private int getTileStart(int i4) {
                return i4 - (i4 % AsyncListUtil.this.mTileSize);
            }

            private boolean isTileLoaded(int i4) {
                return this.mLoadedTiles.get(i4);
            }

            private void log(String str, Object... objArr) {
                Log.d(AsyncListUtil.TAG, "[BKGR] " + String.format(str, objArr));
            }

            private void removeTile(int i4) {
                this.mLoadedTiles.delete(i4);
                AsyncListUtil.this.mMainThreadProxy.removeTile(this.mGeneration, i4);
            }

            private void requestTiles(int i4, int i5, int i6, boolean z4) {
                int i7;
                int i8 = i4;
                while (i8 <= i5) {
                    if (z4) {
                        i7 = (i5 + i4) - i8;
                    } else {
                        i7 = i8;
                    }
                    AsyncListUtil.this.mBackgroundProxy.loadTile(i7, i6);
                    i8 += AsyncListUtil.this.mTileSize;
                }
            }

            public void loadTile(int i4, int i5) {
                if (!isTileLoaded(i4)) {
                    TileList.Tile acquireTile = acquireTile();
                    acquireTile.mStartPosition = i4;
                    int min = Math.min(AsyncListUtil.this.mTileSize, this.mItemCount - i4);
                    acquireTile.mItemCount = min;
                    AsyncListUtil.this.mDataCallback.fillData(acquireTile.mItems, acquireTile.mStartPosition, min);
                    flushTileCache(i5);
                    addTile(acquireTile);
                }
            }

            public void recycleTile(TileList.Tile<T> tile) {
                AsyncListUtil.this.mDataCallback.recycleData(tile.mItems, tile.mItemCount);
                tile.mNext = this.mRecycledRoot;
                this.mRecycledRoot = tile;
            }

            public void refresh(int i4) {
                this.mGeneration = i4;
                this.mLoadedTiles.clear();
                int refreshData = AsyncListUtil.this.mDataCallback.refreshData();
                this.mItemCount = refreshData;
                AsyncListUtil.this.mMainThreadProxy.updateItemCount(this.mGeneration, refreshData);
            }

            public void updateRange(int i4, int i5, int i6, int i7, int i8) {
                if (i4 <= i5) {
                    int tileStart = getTileStart(i4);
                    int tileStart2 = getTileStart(i5);
                    this.mFirstRequiredTileStart = getTileStart(i6);
                    int tileStart3 = getTileStart(i7);
                    this.mLastRequiredTileStart = tileStart3;
                    if (i8 == 1) {
                        requestTiles(this.mFirstRequiredTileStart, tileStart2, i8, true);
                        requestTiles(tileStart2 + AsyncListUtil.this.mTileSize, this.mLastRequiredTileStart, i8, false);
                        return;
                    }
                    requestTiles(tileStart, tileStart3, i8, false);
                    requestTiles(this.mFirstRequiredTileStart, tileStart - AsyncListUtil.this.mTileSize, i8, true);
                }
            }
        };
        this.mBackgroundCallback = r12;
        this.mTClass = cls;
        this.mTileSize = i4;
        this.mDataCallback = dataCallback;
        this.mViewCallback = viewCallback;
        this.mTileList = new TileList<>(i4);
        MessageThreadUtil messageThreadUtil = new MessageThreadUtil();
        this.mMainThreadProxy = messageThreadUtil.getMainThreadProxy(r02);
        this.mBackgroundProxy = messageThreadUtil.getBackgroundProxy(r12);
        refresh();
    }

    private boolean isRefreshPending() {
        if (this.mRequestedGeneration != this.mDisplayedGeneration) {
            return true;
        }
        return false;
    }

    @Nullable
    public T getItem(int i4) {
        if (i4 < 0 || i4 >= this.mItemCount) {
            throw new IndexOutOfBoundsException(i4 + " is not within 0 and " + this.mItemCount);
        }
        T itemAt = this.mTileList.getItemAt(i4);
        if (itemAt == null && !isRefreshPending()) {
            this.mMissingPositions.put(i4, 0);
        }
        return itemAt;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    /* access modifiers changed from: package-private */
    public void log(String str, Object... objArr) {
        Log.d(TAG, "[MAIN] " + String.format(str, objArr));
    }

    public void onRangeChanged() {
        if (!isRefreshPending()) {
            updateRange();
            this.mAllowScrollHints = true;
        }
    }

    public void refresh() {
        this.mMissingPositions.clear();
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.mBackgroundProxy;
        int i4 = this.mRequestedGeneration + 1;
        this.mRequestedGeneration = i4;
        backgroundCallback.refresh(i4);
    }

    /* access modifiers changed from: package-private */
    public void updateRange() {
        int i4;
        this.mViewCallback.getItemRangeInto(this.mTmpRange);
        int[] iArr = this.mTmpRange;
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (i5 <= i6 && i5 >= 0 && i6 < this.mItemCount) {
            if (!this.mAllowScrollHints) {
                this.mScrollHint = 0;
            } else {
                int[] iArr2 = this.mPrevRange;
                if (i5 > iArr2[1] || (i4 = iArr2[0]) > i6) {
                    this.mScrollHint = 0;
                } else if (i5 < i4) {
                    this.mScrollHint = 1;
                } else if (i5 > i4) {
                    this.mScrollHint = 2;
                }
            }
            int[] iArr3 = this.mPrevRange;
            iArr3[0] = i5;
            iArr3[1] = i6;
            this.mViewCallback.extendRangeInto(iArr, this.mTmpRangeExtended, this.mScrollHint);
            int[] iArr4 = this.mTmpRangeExtended;
            iArr4[0] = Math.min(this.mTmpRange[0], Math.max(iArr4[0], 0));
            int[] iArr5 = this.mTmpRangeExtended;
            iArr5[1] = Math.max(this.mTmpRange[1], Math.min(iArr5[1], this.mItemCount - 1));
            ThreadUtil.BackgroundCallback<T> backgroundCallback = this.mBackgroundProxy;
            int[] iArr6 = this.mTmpRange;
            int i7 = iArr6[0];
            int i8 = iArr6[1];
            int[] iArr7 = this.mTmpRangeExtended;
            backgroundCallback.updateRange(i7, i8, iArr7[0], iArr7[1], this.mScrollHint);
        }
    }
}
