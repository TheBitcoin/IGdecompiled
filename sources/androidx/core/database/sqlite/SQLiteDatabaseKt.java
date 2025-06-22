package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import d3.l;

public final class SQLiteDatabaseKt {
    public static final <T> T transaction(SQLiteDatabase sQLiteDatabase, boolean z4, l lVar) {
        if (z4) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            T invoke = lVar.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return invoke;
        } finally {
            kotlin.jvm.internal.l.b(1);
            sQLiteDatabase.endTransaction();
            kotlin.jvm.internal.l.a(1);
        }
    }

    public static /* synthetic */ Object transaction$default(SQLiteDatabase sQLiteDatabase, boolean z4, l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z4 = true;
        }
        if (z4) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            Object invoke = lVar.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return invoke;
        } finally {
            kotlin.jvm.internal.l.b(1);
            sQLiteDatabase.endTransaction();
            kotlin.jvm.internal.l.a(1);
        }
    }
}
