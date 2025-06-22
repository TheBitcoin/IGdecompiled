package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class EntityDeletionOrUpdateAdapter<T> extends SharedSQLiteStatement {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EntityDeletionOrUpdateAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
        m.e(roomDatabase, "database");
    }

    /* access modifiers changed from: protected */
    public abstract void bind(SupportSQLiteStatement supportSQLiteStatement, T t4);

    /* access modifiers changed from: protected */
    public abstract String createQuery();

    public final int handle(T t4) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t4);
            return acquire.executeUpdateDelete();
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(Iterable<? extends T> iterable) {
        m.e(iterable, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            int i4 = 0;
            for (Object bind : iterable) {
                bind(acquire, bind);
                i4 += acquire.executeUpdateDelete();
            }
            return i4;
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(T[] tArr) {
        m.e(tArr, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            int i4 = 0;
            for (T bind : tArr) {
                bind(acquire, bind);
                i4 += acquire.executeUpdateDelete();
            }
            return i4;
        } finally {
            release(acquire);
        }
    }
}
