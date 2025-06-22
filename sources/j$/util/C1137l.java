package j$.util;

import java.util.Set;

/* renamed from: j$.util.l  reason: case insensitive filesystem */
public final class C1137l extends C1133h implements Set {
    private static final long serialVersionUID = 487447009682186044L;

    public final boolean equals(Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        synchronized (this.f5217b) {
            equals = this.f5216a.equals(obj);
        }
        return equals;
    }

    public final int hashCode() {
        int hashCode;
        synchronized (this.f5217b) {
            hashCode = this.f5216a.hashCode();
        }
        return hashCode;
    }
}
