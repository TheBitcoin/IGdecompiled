package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.TileList;

interface ThreadUtil<T> {

    public interface BackgroundCallback<T> {
        void loadTile(int i4, int i5);

        @SuppressLint({"UnknownNullness"})
        void recycleTile(TileList.Tile<T> tile);

        void refresh(int i4);

        void updateRange(int i4, int i5, int i6, int i7, int i8);
    }

    public interface MainThreadCallback<T> {
        @SuppressLint({"UnknownNullness"})
        void addTile(int i4, TileList.Tile<T> tile);

        void removeTile(int i4, int i5);

        void updateItemCount(int i4, int i5);
    }

    BackgroundCallback<T> getBackgroundProxy(BackgroundCallback<T> backgroundCallback);

    MainThreadCallback<T> getMainThreadProxy(MainThreadCallback<T> mainThreadCallback);
}
