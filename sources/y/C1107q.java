package y;

import android.database.sqlite.SQLiteDatabase;
import t.C1048c;
import y.M;

/* renamed from: y.q  reason: case insensitive filesystem */
public final /* synthetic */ class C1107q implements M.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f4781a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C1048c.b f4782b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f4783c;

    public /* synthetic */ C1107q(String str, C1048c.b bVar, long j4) {
        this.f4781a = str;
        this.f4782b = bVar;
        this.f4783c = j4;
    }

    public final Object apply(Object obj) {
        return M.I(this.f4781a, this.f4782b, this.f4783c, (SQLiteDatabase) obj);
    }
}
