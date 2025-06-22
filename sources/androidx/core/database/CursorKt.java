package androidx.core.database;

import android.database.Cursor;

public final class CursorKt {
    public static final byte[] getBlobOrNull(Cursor cursor, int i4) {
        if (cursor.isNull(i4)) {
            return null;
        }
        return cursor.getBlob(i4);
    }

    public static final Double getDoubleOrNull(Cursor cursor, int i4) {
        if (cursor.isNull(i4)) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(i4));
    }

    public static final Float getFloatOrNull(Cursor cursor, int i4) {
        if (cursor.isNull(i4)) {
            return null;
        }
        return Float.valueOf(cursor.getFloat(i4));
    }

    public static final Integer getIntOrNull(Cursor cursor, int i4) {
        if (cursor.isNull(i4)) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(i4));
    }

    public static final Long getLongOrNull(Cursor cursor, int i4) {
        if (cursor.isNull(i4)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i4));
    }

    public static final Short getShortOrNull(Cursor cursor, int i4) {
        if (cursor.isNull(i4)) {
            return null;
        }
        return Short.valueOf(cursor.getShort(i4));
    }

    public static final String getStringOrNull(Cursor cursor, int i4) {
        if (cursor.isNull(i4)) {
            return null;
        }
        return cursor.getString(i4);
    }
}
