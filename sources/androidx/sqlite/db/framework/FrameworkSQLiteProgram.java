package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;
import kotlin.jvm.internal.m;

public class FrameworkSQLiteProgram implements SupportSQLiteProgram, AutoCloseable {
    private final SQLiteProgram delegate;

    public FrameworkSQLiteProgram(SQLiteProgram sQLiteProgram) {
        m.e(sQLiteProgram, "delegate");
        this.delegate = sQLiteProgram;
    }

    public void bindBlob(int i4, byte[] bArr) {
        m.e(bArr, "value");
        this.delegate.bindBlob(i4, bArr);
    }

    public void bindDouble(int i4, double d5) {
        this.delegate.bindDouble(i4, d5);
    }

    public void bindLong(int i4, long j4) {
        this.delegate.bindLong(i4, j4);
    }

    public void bindNull(int i4) {
        this.delegate.bindNull(i4);
    }

    public void bindString(int i4, String str) {
        m.e(str, "value");
        this.delegate.bindString(i4, str);
    }

    public void clearBindings() {
        this.delegate.clearBindings();
    }

    public void close() {
        this.delegate.close();
    }
}
