package x1;

import java.util.HashSet;
import org.json.JSONObject;
import y1.b;
import y1.d;
import y1.e;
import y1.f;

public class c implements b.C0274b {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f22080a;

    /* renamed from: b  reason: collision with root package name */
    private final y1.c f22081b;

    public c(y1.c cVar) {
        this.f22081b = cVar;
    }

    public JSONObject a() {
        return this.f22080a;
    }

    public void b(JSONObject jSONObject, HashSet hashSet, long j4) {
        this.f22081b.c(new e(this, hashSet, jSONObject, j4));
    }

    public void c() {
        this.f22081b.c(new d(this));
    }

    public void d(JSONObject jSONObject, HashSet hashSet, long j4) {
        this.f22081b.c(new f(this, hashSet, jSONObject, j4));
    }

    public void a(JSONObject jSONObject) {
        this.f22080a = jSONObject;
    }
}
