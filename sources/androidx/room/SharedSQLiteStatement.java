package androidx.room;

import R2.g;
import R2.h;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class SharedSQLiteStatement {
    private final RoomDatabase database;
    private final AtomicBoolean lock = new AtomicBoolean(false);
    private final g stmt$delegate = h.a(new SharedSQLiteStatement$stmt$2(this));

    public SharedSQLiteStatement(RoomDatabase roomDatabase) {
        m.e(roomDatabase, "database");
        this.database = roomDatabase;
    }

    /* access modifiers changed from: private */
    public final SupportSQLiteStatement createNewStatement() {
        return this.database.compileStatement(createQuery());
    }

    private final SupportSQLiteStatement getStmt() {
        return (SupportSQLiteStatement) this.stmt$delegate.getValue();
    }

    public SupportSQLiteStatement acquire() {
        assertNotMainThread();
        return getStmt(this.lock.compareAndSet(false, true));
    }

    /* access modifiers changed from: protected */
    public void assertNotMainThread() {
        this.database.assertNotMainThread();
    }

    /* access modifiers changed from: protected */
    public abstract String createQuery();

    public void release(SupportSQLiteStatement supportSQLiteStatement) {
        m.e(supportSQLiteStatement, "statement");
        if (supportSQLiteStatement == getStmt()) {
            this.lock.set(false);
        }
    }

    private final SupportSQLiteStatement getStmt(boolean z4) {
        if (z4) {
            return getStmt();
        }
        return createNewStatement();
    }
}
