package j$.util;

import java.util.Map;

/* renamed from: j$.util.q  reason: case insensitive filesystem */
public final class C1142q implements Map.Entry {

    /* renamed from: a  reason: collision with root package name */
    public final Map.Entry f5250a;

    public C1142q(Map.Entry entry) {
        this.f5250a = (Map.Entry) Objects.requireNonNull(entry);
    }

    public final Object getKey() {
        return this.f5250a.getKey();
    }

    public final Object getValue() {
        return this.f5250a.getValue();
    }

    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final int hashCode() {
        return this.f5250a.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Map.Entry entry2 = this.f5250a;
                Object key = entry2.getKey();
                Object key2 = entry.getKey();
                if (key == null ? key2 == null : key.equals(key2)) {
                    Object value = entry2.getValue();
                    Object value2 = entry.getValue();
                    if (value == null ? value2 == null : value.equals(value2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final String toString() {
        return this.f5250a.toString();
    }
}
