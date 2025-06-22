package androidx.room;

import S2.C1601o;
import android.database.sqlite.SQLiteConstraintException;
import androidx.annotation.RestrictTo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class EntityUpsertionAdapter<T> {
    private final EntityInsertionAdapter<T> insertionAdapter;
    private final EntityDeletionOrUpdateAdapter<T> updateAdapter;

    public EntityUpsertionAdapter(EntityInsertionAdapter<T> entityInsertionAdapter, EntityDeletionOrUpdateAdapter<T> entityDeletionOrUpdateAdapter) {
        m.e(entityInsertionAdapter, "insertionAdapter");
        m.e(entityDeletionOrUpdateAdapter, "updateAdapter");
        this.insertionAdapter = entityInsertionAdapter;
        this.updateAdapter = entityDeletionOrUpdateAdapter;
    }

    private final void checkUniquenessException(SQLiteConstraintException sQLiteConstraintException) {
        String message = sQLiteConstraintException.getMessage();
        if (message == null) {
            throw sQLiteConstraintException;
        } else if (!m3.m.B(message, "1555", true)) {
            throw sQLiteConstraintException;
        }
    }

    public final void upsert(T t4) {
        try {
            this.insertionAdapter.insert(t4);
        } catch (SQLiteConstraintException e5) {
            checkUniquenessException(e5);
            this.updateAdapter.handle(t4);
        }
    }

    public final long upsertAndReturnId(T t4) {
        try {
            return this.insertionAdapter.insertAndReturnId(t4);
        } catch (SQLiteConstraintException e5) {
            checkUniquenessException(e5);
            this.updateAdapter.handle(t4);
            return -1;
        }
    }

    public final long[] upsertAndReturnIdsArray(T[] tArr) {
        long j4;
        m.e(tArr, "entities");
        int length = tArr.length;
        long[] jArr = new long[length];
        for (int i4 = 0; i4 < length; i4++) {
            try {
                j4 = this.insertionAdapter.insertAndReturnId(tArr[i4]);
            } catch (SQLiteConstraintException e5) {
                checkUniquenessException(e5);
                this.updateAdapter.handle(tArr[i4]);
                j4 = -1;
            }
            jArr[i4] = j4;
        }
        return jArr;
    }

    public final Long[] upsertAndReturnIdsArrayBox(T[] tArr) {
        long j4;
        m.e(tArr, "entities");
        int length = tArr.length;
        Long[] lArr = new Long[length];
        for (int i4 = 0; i4 < length; i4++) {
            try {
                j4 = this.insertionAdapter.insertAndReturnId(tArr[i4]);
            } catch (SQLiteConstraintException e5) {
                checkUniquenessException(e5);
                this.updateAdapter.handle(tArr[i4]);
                j4 = -1;
            }
            lArr[i4] = Long.valueOf(j4);
        }
        return lArr;
    }

    public final List<Long> upsertAndReturnIdsList(T[] tArr) {
        m.e(tArr, "entities");
        List c5 = C1601o.c();
        for (T t4 : tArr) {
            try {
                c5.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(t4)));
            } catch (SQLiteConstraintException e5) {
                checkUniquenessException(e5);
                this.updateAdapter.handle(t4);
                c5.add(-1L);
            }
        }
        return C1601o.a(c5);
    }

    public final void upsert(T[] tArr) {
        m.e(tArr, "entities");
        for (T t4 : tArr) {
            try {
                this.insertionAdapter.insert(t4);
            } catch (SQLiteConstraintException e5) {
                checkUniquenessException(e5);
                this.updateAdapter.handle(t4);
            }
        }
    }

    public final long[] upsertAndReturnIdsArray(Collection<? extends T> collection) {
        long j4;
        m.e(collection, "entities");
        Iterator<? extends T> it = collection.iterator();
        int size = collection.size();
        long[] jArr = new long[size];
        for (int i4 = 0; i4 < size; i4++) {
            Object next = it.next();
            try {
                j4 = this.insertionAdapter.insertAndReturnId(next);
            } catch (SQLiteConstraintException e5) {
                checkUniquenessException(e5);
                this.updateAdapter.handle(next);
                j4 = -1;
            }
            jArr[i4] = j4;
        }
        return jArr;
    }

    public final Long[] upsertAndReturnIdsArrayBox(Collection<? extends T> collection) {
        long j4;
        m.e(collection, "entities");
        Iterator<? extends T> it = collection.iterator();
        int size = collection.size();
        Long[] lArr = new Long[size];
        for (int i4 = 0; i4 < size; i4++) {
            Object next = it.next();
            try {
                j4 = this.insertionAdapter.insertAndReturnId(next);
            } catch (SQLiteConstraintException e5) {
                checkUniquenessException(e5);
                this.updateAdapter.handle(next);
                j4 = -1;
            }
            lArr[i4] = Long.valueOf(j4);
        }
        return lArr;
    }

    public final void upsert(Iterable<? extends T> iterable) {
        m.e(iterable, "entities");
        for (Object next : iterable) {
            try {
                this.insertionAdapter.insert(next);
            } catch (SQLiteConstraintException e5) {
                checkUniquenessException(e5);
                this.updateAdapter.handle(next);
            }
        }
    }

    public final List<Long> upsertAndReturnIdsList(Collection<? extends T> collection) {
        m.e(collection, "entities");
        List c5 = C1601o.c();
        for (Object next : collection) {
            try {
                c5.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(next)));
            } catch (SQLiteConstraintException e5) {
                checkUniquenessException(e5);
                this.updateAdapter.handle(next);
                c5.add(-1L);
            }
        }
        return C1601o.a(c5);
    }
}
