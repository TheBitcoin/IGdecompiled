package com.mbridge.msdk.tracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

final class b extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private final String f15436a;

    public b(Context context, String str, String str2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.f15436a = str2;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (!y.a((Object) sQLiteDatabase)) {
            try {
                sQLiteDatabase.execSQL(String.format(i.f15459a, new Object[]{this.f15436a}));
            } catch (Exception e5) {
                if (a.f15435a) {
                    Log.e("TrackManager", "create table error", e5);
                }
            }
        }
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        if (!y.a((Object) sQLiteDatabase)) {
            try {
                sQLiteDatabase.execSQL(String.format(i.f15460b, new Object[]{this.f15436a}));
                sQLiteDatabase.execSQL(String.format(i.f15459a, new Object[]{this.f15436a}));
            } catch (Exception e5) {
                if (a.f15435a) {
                    Log.e("TrackManager", "downgrade table error", e5);
                }
            }
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        if (!y.a((Object) sQLiteDatabase)) {
            try {
                sQLiteDatabase.execSQL(String.format(i.f15460b, new Object[]{this.f15436a}));
                sQLiteDatabase.execSQL(String.format(i.f15459a, new Object[]{this.f15436a}));
            } catch (Exception e5) {
                if (a.f15435a) {
                    Log.e("TrackManager", "upgrade table error", e5);
                }
            }
        }
    }
}
