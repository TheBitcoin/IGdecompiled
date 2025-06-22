package m0;

import java.util.Map;
import l0.f;

/* renamed from: m0.c  reason: case insensitive filesystem */
abstract class C2135c implements Map.Entry {
    C2135c() {
    }

    public boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (!f.a(getKey(), entry.getKey()) || !f.a(getValue(), entry.getValue())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public abstract Object getKey();

    public abstract Object getValue();

    public int hashCode() {
        int i4;
        Object key = getKey();
        Object value = getValue();
        int i5 = 0;
        if (key == null) {
            i4 = 0;
        } else {
            i4 = key.hashCode();
        }
        if (value != null) {
            i5 = value.hashCode();
        }
        return i4 ^ i5;
    }

    public String toString() {
        String valueOf = String.valueOf(getKey());
        String valueOf2 = String.valueOf(getValue());
        StringBuilder sb = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }
}
