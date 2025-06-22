package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.internal.measurement.C0641p0;

/* renamed from: com.google.android.gms.measurement.internal.i2  reason: case insensitive filesystem */
final class C0786i2 extends C0641p0 {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C0765f2 f3023a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0786i2(C0765f2 f2Var, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.f3023a = f2Var;
    }

    public final SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException e5) {
            throw e5;
        } catch (SQLiteException unused) {
            this.f3023a.a().G().a("Opening the local database failed, dropping and recreating it");
            if (!this.f3023a.A().getDatabasePath("google_app_measurement_local.db").delete()) {
                this.f3023a.a().G().b("Failed to delete corrupted local db file", "google_app_measurement_local.db");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e6) {
                this.f3023a.a().G().b("Failed to open local database. Events will bypass local storage", e6);
                return null;
            }
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        C0866u.b(this.f3023a.a(), sQLiteDatabase);
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        C0866u.c(this.f3023a.a(), sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", (String[]) null);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
    }
}
