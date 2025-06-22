package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import kotlin.jvm.internal.m;

public final class RoomSQLiteQuery$Companion$copyFrom$1 implements SupportSQLiteProgram, AutoCloseable {
    private final /* synthetic */ RoomSQLiteQuery $$delegate_0;

    RoomSQLiteQuery$Companion$copyFrom$1(RoomSQLiteQuery roomSQLiteQuery) {
        this.$$delegate_0 = roomSQLiteQuery;
    }

    public void bindBlob(int i4, byte[] bArr) {
        m.e(bArr, "value");
        this.$$delegate_0.bindBlob(i4, bArr);
    }

    public void bindDouble(int i4, double d5) {
        this.$$delegate_0.bindDouble(i4, d5);
    }

    public void bindLong(int i4, long j4) {
        this.$$delegate_0.bindLong(i4, j4);
    }

    public void bindNull(int i4) {
        this.$$delegate_0.bindNull(i4);
    }

    public void bindString(int i4, String str) {
        m.e(str, "value");
        this.$$delegate_0.bindString(i4, str);
    }

    public void clearBindings() {
        this.$$delegate_0.clearBindings();
    }

    public void close() {
        this.$$delegate_0.close();
    }
}
