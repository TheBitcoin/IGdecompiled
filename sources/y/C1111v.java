package y;

import android.database.Cursor;
import java.util.List;
import q.p;
import y.M;

/* renamed from: y.v  reason: case insensitive filesystem */
public final /* synthetic */ class C1111v implements M.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ M f4790a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f4791b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f4792c;

    public /* synthetic */ C1111v(M m4, List list, p pVar) {
        this.f4790a = m4;
        this.f4791b = list;
        this.f4792c = pVar;
    }

    public final Object apply(Object obj) {
        return M.L(this.f4790a, this.f4791b, this.f4792c, (Cursor) obj);
    }
}
