package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.C0597k0;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.measurement.internal.u  reason: case insensitive filesystem */
public abstract class C0866u {
    private static Set a(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", (String[]) null);
        try {
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    static void b(C0821n2 n2Var, SQLiteDatabase sQLiteDatabase) {
        if (n2Var != null) {
            File file = new File(C0597k0.a().c(sQLiteDatabase.getPath()));
            if (!file.setReadable(false, false)) {
                n2Var.L().a("Failed to turn off database read permission");
            }
            if (!file.setWritable(false, false)) {
                n2Var.L().a("Failed to turn off database write permission");
            }
            if (!file.setReadable(true, true)) {
                n2Var.L().a("Failed to turn on database read permission for owner");
            }
            if (!file.setWritable(true, true)) {
                n2Var.L().a("Failed to turn on database write permission for owner");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }

    static void c(C0821n2 n2Var, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) {
        if (n2Var != null) {
            if (!d(n2Var, sQLiteDatabase, str)) {
                sQLiteDatabase.execSQL(str2);
            }
            try {
                Set a5 = a(sQLiteDatabase, str);
                String[] split = str3.split(",");
                int length = split.length;
                int i4 = 0;
                while (i4 < length) {
                    String str4 = split[i4];
                    if (a5.remove(str4)) {
                        i4++;
                    } else {
                        throw new SQLiteException("Table " + str + " is missing required column: " + str4);
                    }
                }
                if (strArr != null) {
                    for (int i5 = 0; i5 < strArr.length; i5 += 2) {
                        if (!a5.remove(strArr[i5])) {
                            sQLiteDatabase.execSQL(strArr[i5 + 1]);
                        }
                    }
                }
                if (!a5.isEmpty()) {
                    n2Var.L().c("Table has extra columns. table, columns", str, TextUtils.join(", ", a5));
                }
            } catch (SQLiteException e5) {
                n2Var.G().b("Failed to verify columns on table that was just created", str);
                throw e5;
            }
        } else {
            throw new IllegalArgumentException("Monitor must not be null");
        }
    }

    private static boolean d(C0821n2 n2Var, SQLiteDatabase sQLiteDatabase, String str) {
        if (n2Var != null) {
            Cursor cursor = null;
            try {
                Cursor query = sQLiteDatabase.query("SQLITE_MASTER", new String[]{RewardPlus.NAME}, "name=?", new String[]{str}, (String) null, (String) null, (String) null);
                boolean moveToFirst = query.moveToFirst();
                query.close();
                return moveToFirst;
            } catch (SQLiteException e5) {
                n2Var.L().c("Error querying for table", str, e5);
                if (cursor == null) {
                    return false;
                }
                cursor.close();
                return false;
            } catch (Throwable th) {
                Throwable th2 = th;
                if (cursor != null) {
                    cursor.close();
                }
                throw th2;
            }
        } else {
            throw new IllegalArgumentException("Monitor must not be null");
        }
    }
}
