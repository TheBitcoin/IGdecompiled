package R3;

import P3.C2546b;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: R3.b  reason: case insensitive filesystem */
public class C2563b {

    /* renamed from: b  reason: collision with root package name */
    private static final String f23911b = C2546b.i(C2563b.class);

    /* renamed from: a  reason: collision with root package name */
    private final Map f23912a = new ConcurrentHashMap();

    public int a() {
        return this.f23912a.size();
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject(this.f23912a);
        if (jSONObject.length() > 0) {
            return jSONObject.toString();
        }
        return null;
    }
}
