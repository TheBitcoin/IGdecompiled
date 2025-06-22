package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import java.lang.reflect.Array;

class TileList<T> {
    Tile<T> mLastAccessedTile;
    final int mTileSize;
    private final SparseArray<Tile<T>> mTiles = new SparseArray<>(10);

    public static class Tile<T> {
        public int mItemCount;
        public final T[] mItems;
        Tile<T> mNext;
        public int mStartPosition;

        Tile(@NonNull Class<T> cls, int i4) {
            this.mItems = (Object[]) Array.newInstance(cls, i4);
        }

        /* access modifiers changed from: package-private */
        public boolean containsPosition(int i4) {
            int i5 = this.mStartPosition;
            if (i5 > i4 || i4 >= i5 + this.mItemCount) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public T getByPosition(int i4) {
            return this.mItems[i4 - this.mStartPosition];
        }
    }

    public TileList(int i4) {
        this.mTileSize = i4;
    }

    public Tile<T> addOrReplace(Tile<T> tile) {
        int indexOfKey = this.mTiles.indexOfKey(tile.mStartPosition);
        if (indexOfKey < 0) {
            this.mTiles.put(tile.mStartPosition, tile);
            return null;
        }
        Tile<T> valueAt = this.mTiles.valueAt(indexOfKey);
        this.mTiles.setValueAt(indexOfKey, tile);
        if (this.mLastAccessedTile == valueAt) {
            this.mLastAccessedTile = tile;
        }
        return valueAt;
    }

    public void clear() {
        this.mTiles.clear();
    }

    public Tile<T> getAtIndex(int i4) {
        if (i4 < 0 || i4 >= this.mTiles.size()) {
            return null;
        }
        return this.mTiles.valueAt(i4);
    }

    public T getItemAt(int i4) {
        Tile<T> tile = this.mLastAccessedTile;
        if (tile == null || !tile.containsPosition(i4)) {
            int indexOfKey = this.mTiles.indexOfKey(i4 - (i4 % this.mTileSize));
            if (indexOfKey < 0) {
                return null;
            }
            this.mLastAccessedTile = this.mTiles.valueAt(indexOfKey);
        }
        return this.mLastAccessedTile.getByPosition(i4);
    }

    public Tile<T> removeAtPos(int i4) {
        Tile<T> tile = this.mTiles.get(i4);
        if (this.mLastAccessedTile == tile) {
            this.mLastAccessedTile = null;
        }
        this.mTiles.delete(i4);
        return tile;
    }

    public int size() {
        return this.mTiles.size();
    }
}
