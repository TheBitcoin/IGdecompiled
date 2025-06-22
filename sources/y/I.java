package y;

import android.database.sqlite.SQLiteDatabase;
import y.M;

public final /* synthetic */ class I implements M.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ M f4719a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f4720b;

    public /* synthetic */ I(M m4, long j4) {
        this.f4719a = m4;
        this.f4720b = j4;
    }

    public final Object apply(Object obj) {
        return M.K(this.f4719a, this.f4720b, (SQLiteDatabase) obj);
    }
}
