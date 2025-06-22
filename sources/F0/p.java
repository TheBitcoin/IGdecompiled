package f0;

public enum p {
    UNINITIALIZED("uninitialized"),
    POLICY("eu_consent_policy"),
    DENIED("denied"),
    GRANTED("granted");
    

    /* renamed from: a  reason: collision with root package name */
    private final String f3378a;

    private p(String str) {
        this.f3378a = str;
    }

    public final String toString() {
        return this.f3378a;
    }
}
