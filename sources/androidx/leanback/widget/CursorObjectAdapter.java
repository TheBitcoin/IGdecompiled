package androidx.leanback.widget;

import android.database.Cursor;
import android.util.LruCache;
import androidx.leanback.database.CursorMapper;

public class CursorObjectAdapter extends ObjectAdapter {
    private static final int CACHE_SIZE = 100;
    private Cursor mCursor;
    private final LruCache<Integer, Object> mItemCache = new LruCache<>(100);
    private CursorMapper mMapper;

    public CursorObjectAdapter(PresenterSelector presenterSelector) {
        super(presenterSelector);
    }

    public void changeCursor(Cursor cursor) {
        Cursor cursor2 = this.mCursor;
        if (cursor != cursor2) {
            if (cursor2 != null) {
                cursor2.close();
            }
            this.mCursor = cursor;
            this.mItemCache.trimToSize(0);
            onCursorChanged();
        }
    }

    public void close() {
        Cursor cursor = this.mCursor;
        if (cursor != null) {
            cursor.close();
            this.mCursor = null;
        }
    }

    public Object get(int i4) {
        Cursor cursor = this.mCursor;
        if (cursor == null) {
            return null;
        }
        if (cursor.moveToPosition(i4)) {
            Object obj = this.mItemCache.get(Integer.valueOf(i4));
            if (obj != null) {
                return obj;
            }
            Object convert = this.mMapper.convert(this.mCursor);
            this.mItemCache.put(Integer.valueOf(i4), convert);
            return convert;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final Cursor getCursor() {
        return this.mCursor;
    }

    public final CursorMapper getMapper() {
        return this.mMapper;
    }

    /* access modifiers changed from: protected */
    public final void invalidateCache(int i4) {
        this.mItemCache.remove(Integer.valueOf(i4));
    }

    public boolean isClosed() {
        Cursor cursor = this.mCursor;
        if (cursor == null || cursor.isClosed()) {
            return true;
        }
        return false;
    }

    public boolean isImmediateNotifySupported() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCursorChanged() {
        notifyChanged();
    }

    /* access modifiers changed from: protected */
    public void onMapperChanged() {
    }

    public final void setMapper(CursorMapper cursorMapper) {
        boolean z4;
        if (this.mMapper != cursorMapper) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.mMapper = cursorMapper;
        if (z4) {
            onMapperChanged();
        }
    }

    public int size() {
        Cursor cursor = this.mCursor;
        if (cursor == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public Cursor swapCursor(Cursor cursor) {
        Cursor cursor2 = this.mCursor;
        if (cursor == cursor2) {
            return cursor2;
        }
        this.mCursor = cursor;
        this.mItemCache.trimToSize(0);
        onCursorChanged();
        return cursor2;
    }

    /* access modifiers changed from: protected */
    public final void invalidateCache(int i4, int i5) {
        int i6 = i5 + i4;
        while (i4 < i6) {
            invalidateCache(i4);
            i4++;
        }
    }

    public CursorObjectAdapter(Presenter presenter) {
        super(presenter);
    }

    public CursorObjectAdapter() {
    }
}
