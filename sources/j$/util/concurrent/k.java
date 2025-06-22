package j$.util.concurrent;

import j$.com.android.tools.r8.a;
import java.util.Map;

public final class k implements Map.Entry {

    /* renamed from: a  reason: collision with root package name */
    public final Object f5149a;

    /* renamed from: b  reason: collision with root package name */
    public Object f5150b;

    /* renamed from: c  reason: collision with root package name */
    public final ConcurrentHashMap f5151c;

    public k(Object obj, Object obj2, ConcurrentHashMap concurrentHashMap) {
        this.f5149a = obj;
        this.f5150b = obj2;
        this.f5151c = concurrentHashMap;
    }

    public final Object getKey() {
        return this.f5149a;
    }

    public final Object getValue() {
        return this.f5150b;
    }

    public final int hashCode() {
        return this.f5149a.hashCode() ^ this.f5150b.hashCode();
    }

    public final String toString() {
        return a.D(this.f5149a, this.f5150b);
    }

    public final boolean equals(Object obj) {
        Map.Entry entry;
        Object key;
        Object value;
        if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (value = entry.getValue()) == null) {
            return false;
        }
        Object obj2 = this.f5149a;
        if (key != obj2 && !key.equals(obj2)) {
            return false;
        }
        Object obj3 = this.f5150b;
        return value == obj3 || value.equals(obj3);
    }

    public final Object setValue(Object obj) {
        obj.getClass();
        Object obj2 = this.f5150b;
        this.f5150b = obj;
        this.f5151c.put(this.f5149a, obj);
        return obj2;
    }
}
