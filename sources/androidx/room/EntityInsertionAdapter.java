package androidx.room;

import S2.C1601o;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.C2098b;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EntityInsertionAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
        m.e(roomDatabase, "database");
    }

    /* access modifiers changed from: protected */
    public abstract void bind(SupportSQLiteStatement supportSQLiteStatement, T t4);

    public final void insert(T t4) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t4);
            acquire.executeInsert();
        } finally {
            release(acquire);
        }
    }

    public final long insertAndReturnId(T t4) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t4);
            return acquire.executeInsert();
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> collection) {
        m.e(collection, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            long[] jArr = new long[collection.size()];
            int i4 = 0;
            for (Object next : collection) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    C1601o.o();
                }
                bind(acquire, next);
                jArr[i4] = acquire.executeInsert();
                i4 = i5;
            }
            release(acquire);
            return jArr;
        } catch (Throwable th) {
            release(acquire);
            throw th;
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> collection) {
        m.e(collection, "entities");
        SupportSQLiteStatement acquire = acquire();
        Iterator<? extends T> it = collection.iterator();
        try {
            int size = collection.size();
            Long[] lArr = new Long[size];
            for (int i4 = 0; i4 < size; i4++) {
                bind(acquire, it.next());
                lArr[i4] = Long.valueOf(acquire.executeInsert());
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(T[] tArr) {
        m.e(tArr, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            List c5 = C1601o.c();
            for (T bind : tArr) {
                bind(acquire, bind);
                c5.add(Long.valueOf(acquire.executeInsert()));
            }
            List<Long> a5 = C1601o.a(c5);
            release(acquire);
            return a5;
        } catch (Throwable th) {
            release(acquire);
            throw th;
        }
    }

    public final void insert(T[] tArr) {
        m.e(tArr, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            for (T bind : tArr) {
                bind(acquire, bind);
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(T[] tArr) {
        m.e(tArr, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            long[] jArr = new long[tArr.length];
            int length = tArr.length;
            int i4 = 0;
            int i5 = 0;
            while (i4 < length) {
                int i6 = i5 + 1;
                bind(acquire, tArr[i4]);
                jArr[i5] = acquire.executeInsert();
                i4++;
                i5 = i6;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(T[] tArr) {
        m.e(tArr, "entities");
        SupportSQLiteStatement acquire = acquire();
        Iterator a5 = C2098b.a(tArr);
        try {
            int length = tArr.length;
            Long[] lArr = new Long[length];
            for (int i4 = 0; i4 < length; i4++) {
                bind(acquire, a5.next());
                lArr[i4] = Long.valueOf(acquire.executeInsert());
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> collection) {
        m.e(collection, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            List c5 = C1601o.c();
            for (Object bind : collection) {
                bind(acquire, bind);
                c5.add(Long.valueOf(acquire.executeInsert()));
            }
            List<Long> a5 = C1601o.a(c5);
            release(acquire);
            return a5;
        } catch (Throwable th) {
            release(acquire);
            throw th;
        }
    }

    public final void insert(Iterable<? extends T> iterable) {
        m.e(iterable, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            for (Object bind : iterable) {
                bind(acquire, bind);
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }
}
