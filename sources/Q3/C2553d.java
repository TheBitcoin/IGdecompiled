package Q3;

/* renamed from: Q3.d  reason: case insensitive filesystem */
public enum C2553d {
    ALWAYS("always"),
    WIFI_ONLY("wifi_only"),
    EXCEPTION("exception");
    

    /* renamed from: a  reason: collision with root package name */
    private final String f23890a;

    private C2553d(String str) {
        this.f23890a = str;
    }

    public static C2553d b(String str) {
        for (C2553d dVar : values()) {
            if (dVar.f23890a.equals(str)) {
                return dVar;
            }
        }
        return null;
    }

    public String toString() {
        return this.f23890a;
    }
}
