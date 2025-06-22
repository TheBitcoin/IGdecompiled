package androidx.sqlite.db.framework;

import android.os.Build;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import d3.a;
import java.io.File;
import kotlin.jvm.internal.n;

final class FrameworkSQLiteOpenHelper$lazyDelegate$1 extends n implements a {
    final /* synthetic */ FrameworkSQLiteOpenHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FrameworkSQLiteOpenHelper$lazyDelegate$1(FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper) {
        super(0);
        this.this$0 = frameworkSQLiteOpenHelper;
    }

    public final FrameworkSQLiteOpenHelper.OpenHelper invoke() {
        FrameworkSQLiteOpenHelper.OpenHelper openHelper;
        if (Build.VERSION.SDK_INT < 23 || this.this$0.name == null || !this.this$0.useNoBackupDirectory) {
            openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(this.this$0.context, this.this$0.name, new FrameworkSQLiteOpenHelper.DBRefHolder((FrameworkSQLiteDatabase) null), this.this$0.callback, this.this$0.allowDataLossOnRecovery);
        } else {
            openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(this.this$0.context, new File(SupportSQLiteCompat.Api21Impl.getNoBackupFilesDir(this.this$0.context), this.this$0.name).getAbsolutePath(), new FrameworkSQLiteOpenHelper.DBRefHolder((FrameworkSQLiteDatabase) null), this.this$0.callback, this.this$0.allowDataLossOnRecovery);
        }
        SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled(openHelper, this.this$0.writeAheadLoggingEnabled);
        return openHelper;
    }
}
