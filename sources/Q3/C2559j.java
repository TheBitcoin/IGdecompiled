package Q3;

import org.json.JSONObject;

/* renamed from: Q3.j  reason: case insensitive filesystem */
public class C2559j {

    /* renamed from: a  reason: collision with root package name */
    private final String f23904a;

    /* renamed from: b  reason: collision with root package name */
    private final JSONObject f23905b;

    /* renamed from: c  reason: collision with root package name */
    private final long f23906c;

    /* renamed from: d  reason: collision with root package name */
    private final int f23907d;

    public C2559j(String str) {
        this(str, (JSONObject) null, 1);
    }

    public int a() {
        return this.f23907d;
    }

    public JSONObject b() {
        return this.f23905b;
    }

    public String c() {
        return this.f23904a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Packet(");
        if (this.f23905b != null) {
            sb.append("type=POST, data=");
            sb.append(this.f23905b);
        } else {
            sb.append("type=GET, data=");
            sb.append(this.f23904a);
        }
        sb.append(")");
        return sb.toString();
    }

    public C2559j(String str, JSONObject jSONObject, int i4) {
        this.f23904a = str;
        this.f23905b = jSONObject;
        this.f23907d = i4;
        this.f23906c = System.currentTimeMillis();
    }
}
