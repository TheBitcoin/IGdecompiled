package y;

import android.database.sqlite.SQLiteDatabase;
import y.M;

/* renamed from: y.l  reason: case insensitive filesystem */
public final /* synthetic */ class C1102l implements M.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteDatabase f4772a;

    public /* synthetic */ C1102l(SQLiteDatabase sQLiteDatabase) {
        this.f4772a = sQLiteDatabase;
    }

    public final Object a() {
        return this.f4772a.beginTransaction();
    }
}
