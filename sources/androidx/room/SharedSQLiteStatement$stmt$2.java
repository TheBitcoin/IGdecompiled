package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import d3.a;
import kotlin.jvm.internal.n;

final class SharedSQLiteStatement$stmt$2 extends n implements a {
    final /* synthetic */ SharedSQLiteStatement this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharedSQLiteStatement$stmt$2(SharedSQLiteStatement sharedSQLiteStatement) {
        super(0);
        this.this$0 = sharedSQLiteStatement;
    }

    public final SupportSQLiteStatement invoke() {
        return this.this$0.createNewStatement();
    }
}
