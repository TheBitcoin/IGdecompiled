package y;

import android.database.sqlite.SQLiteDatabase;
import y.W;

public final /* synthetic */ class Q implements W.a {
    public final void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
}
