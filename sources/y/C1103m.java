package y;

import android.database.sqlite.SQLiteDatabase;
import q.i;
import q.p;
import y.M;

/* renamed from: y.m  reason: case insensitive filesystem */
public final /* synthetic */ class C1103m implements M.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ M f4773a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f4774b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f4775c;

    public /* synthetic */ C1103m(M m4, i iVar, p pVar) {
        this.f4773a = m4;
        this.f4774b = iVar;
        this.f4775c = pVar;
    }

    public final Object apply(Object obj) {
        return M.E(this.f4773a, this.f4774b, this.f4775c, (SQLiteDatabase) obj);
    }
}
