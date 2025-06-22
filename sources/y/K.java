package y;

import android.database.sqlite.SQLiteDatabase;
import y.M;

public final /* synthetic */ class K implements M.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ M f4721a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f4722b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f4723c;

    public /* synthetic */ K(M m4, String str, String str2) {
        this.f4721a = m4;
        this.f4722b = str;
        this.f4723c = str2;
    }

    public final Object apply(Object obj) {
        return M.u(this.f4721a, this.f4722b, this.f4723c, (SQLiteDatabase) obj);
    }
}
