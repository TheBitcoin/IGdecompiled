package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.google.android.gms.internal.measurement.p0  reason: case insensitive filesystem */
public abstract class C0641p0 extends SQLiteOpenHelper {
    public C0641p0(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i4) {
        this(context, str, (SQLiteDatabase.CursorFactory) null, 1, C0656r0.f2120a);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private C0641p0(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i4, C0656r0 r0Var) {
        super(context, (str == null || C0597k0.a().a(str, r0Var, C0633o0.SQLITE_OPEN_HELPER_TYPE).equals("")) ? null : str, (SQLiteDatabase.CursorFactory) null, 1);
    }
}
