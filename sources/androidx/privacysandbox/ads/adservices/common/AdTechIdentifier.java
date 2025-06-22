package androidx.privacysandbox.ads.adservices.common;

import kotlin.jvm.internal.m;

public final class AdTechIdentifier {
    private final String identifier;

    public AdTechIdentifier(String str) {
        m.e(str, "identifier");
        this.identifier = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdTechIdentifier)) {
            return false;
        }
        return m.a(this.identifier, ((AdTechIdentifier) obj).identifier);
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public int hashCode() {
        return this.identifier.hashCode();
    }

    public String toString() {
        return String.valueOf(this.identifier);
    }
}
