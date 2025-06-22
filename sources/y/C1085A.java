package y;

import android.database.Cursor;
import java.util.Map;
import t.C1046a;
import y.M;

/* renamed from: y.A  reason: case insensitive filesystem */
public final /* synthetic */ class C1085A implements M.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ M f4713a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f4714b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C1046a.C0050a f4715c;

    public /* synthetic */ C1085A(M m4, Map map, C1046a.C0050a aVar) {
        this.f4713a = m4;
        this.f4714b = map;
        this.f4715c = aVar;
    }

    public final Object apply(Object obj) {
        return M.A(this.f4713a, this.f4714b, this.f4715c, (Cursor) obj);
    }
}
