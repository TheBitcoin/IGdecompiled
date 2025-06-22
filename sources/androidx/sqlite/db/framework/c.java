package androidx.sqlite.db.framework;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;

public final /* synthetic */ class c implements DatabaseErrorHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SupportSQLiteOpenHelper.Callback f1024a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FrameworkSQLiteOpenHelper.DBRefHolder f1025b;

    public /* synthetic */ c(SupportSQLiteOpenHelper.Callback callback, FrameworkSQLiteOpenHelper.DBRefHolder dBRefHolder) {
        this.f1024a = callback;
        this.f1025b = dBRefHolder;
    }

    public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
        FrameworkSQLiteOpenHelper.OpenHelper._init_$lambda$0(this.f1024a, this.f1025b, sQLiteDatabase);
    }
}
