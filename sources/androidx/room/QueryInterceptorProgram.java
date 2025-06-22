package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;

public final class QueryInterceptorProgram implements SupportSQLiteProgram, AutoCloseable {
    private final List<Object> bindArgsCache = new ArrayList();

    private final void saveArgsToCache(int i4, Object obj) {
        int size;
        int i5 = i4 - 1;
        if (i5 >= this.bindArgsCache.size() && (size = this.bindArgsCache.size()) <= i5) {
            while (true) {
                this.bindArgsCache.add((Object) null);
                if (size == i5) {
                    break;
                }
                size++;
            }
        }
        this.bindArgsCache.set(i5, obj);
    }

    public void bindBlob(int i4, byte[] bArr) {
        m.e(bArr, "value");
        saveArgsToCache(i4, bArr);
    }

    public void bindDouble(int i4, double d5) {
        saveArgsToCache(i4, Double.valueOf(d5));
    }

    public void bindLong(int i4, long j4) {
        saveArgsToCache(i4, Long.valueOf(j4));
    }

    public void bindNull(int i4) {
        saveArgsToCache(i4, (Object) null);
    }

    public void bindString(int i4, String str) {
        m.e(str, "value");
        saveArgsToCache(i4, str);
    }

    public void clearBindings() {
        this.bindArgsCache.clear();
    }

    public void close() {
    }

    public final List<Object> getBindArgsCache$room_runtime_release() {
        return this.bindArgsCache;
    }
}
