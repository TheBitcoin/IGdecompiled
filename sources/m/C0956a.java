package m;

import E2.s;
import com.inmobi.cmp.core.cmpapi.status.CmpStatus;
import com.inmobi.cmp.core.cmpapi.status.DisplayStatus;
import java.util.LinkedHashMap;

/* renamed from: m.a  reason: case insensitive filesystem */
public final class C0956a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0956a f3560a = new C0956a();

    /* renamed from: b  reason: collision with root package name */
    public static CmpStatus f3561b = CmpStatus.LOADING;

    /* renamed from: c  reason: collision with root package name */
    public static s f3562c;

    /* renamed from: d  reason: collision with root package name */
    public static String f3563d;

    /* renamed from: e  reason: collision with root package name */
    public static String f3564e;

    static {
        new LinkedHashMap();
        DisplayStatus displayStatus = DisplayStatus.VISIBLE;
    }

    public final CmpStatus a() {
        return f3561b;
    }

    public final void b(s sVar) {
        f3562c = sVar;
    }

    public final void c(String str) {
        f3564e = str;
    }

    public final String d() {
        return f3564e;
    }

    public final void e(String str) {
        f3563d = str;
    }

    public final s f() {
        return f3562c;
    }

    public final String g() {
        return f3563d;
    }
}
