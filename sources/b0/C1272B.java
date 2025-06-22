package B0;

import B0.G;

/* renamed from: B0.B  reason: case insensitive filesystem */
final class C1272B extends G {

    /* renamed from: a  reason: collision with root package name */
    private final G.a f5752a;

    /* renamed from: b  reason: collision with root package name */
    private final G.c f5753b;

    /* renamed from: c  reason: collision with root package name */
    private final G.b f5754c;

    C1272B(G.a aVar, G.c cVar, G.b bVar) {
        if (aVar != null) {
            this.f5752a = aVar;
            if (cVar != null) {
                this.f5753b = cVar;
                if (bVar != null) {
                    this.f5754c = bVar;
                    return;
                }
                throw new NullPointerException("Null deviceData");
            }
            throw new NullPointerException("Null osData");
        }
        throw new NullPointerException("Null appData");
    }

    public G.a a() {
        return this.f5752a;
    }

    public G.b c() {
        return this.f5754c;
    }

    public G.c d() {
        return this.f5753b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof G) {
            G g4 = (G) obj;
            if (!this.f5752a.equals(g4.a()) || !this.f5753b.equals(g4.d()) || !this.f5754c.equals(g4.c())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f5752a.hashCode() ^ 1000003) * 1000003) ^ this.f5753b.hashCode()) * 1000003) ^ this.f5754c.hashCode();
    }

    public String toString() {
        return "StaticSessionData{appData=" + this.f5752a + ", osData=" + this.f5753b + ", deviceData=" + this.f5754c + "}";
    }
}
