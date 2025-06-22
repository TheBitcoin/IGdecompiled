package j$.util.concurrent;

import j$.com.android.tools.r8.a;
import java.util.Map;

public class l implements Map.Entry {

    /* renamed from: a  reason: collision with root package name */
    public final int f5152a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f5153b;

    /* renamed from: c  reason: collision with root package name */
    public volatile Object f5154c;

    /* renamed from: d  reason: collision with root package name */
    public volatile l f5155d;

    public l(int i4, Object obj, Object obj2) {
        this.f5152a = i4;
        this.f5153b = obj;
        this.f5154c = obj2;
    }

    public l(int i4, Object obj, Object obj2, l lVar) {
        this(i4, obj, obj2);
        this.f5155d = lVar;
    }

    public final Object getKey() {
        return this.f5153b;
    }

    public final Object getValue() {
        return this.f5154c;
    }

    public final int hashCode() {
        return this.f5153b.hashCode() ^ this.f5154c.hashCode();
    }

    public final String toString() {
        return a.D(this.f5153b, this.f5154c);
    }

    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean equals(Object obj) {
        Map.Entry entry;
        Object key;
        Object value;
        if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (value = entry.getValue()) == null) {
            return false;
        }
        Object obj2 = this.f5153b;
        if (key != obj2 && !key.equals(obj2)) {
            return false;
        }
        Object obj3 = this.f5154c;
        return value == obj3 || value.equals(obj3);
    }

    public l a(int i4, Object obj) {
        Object obj2;
        l lVar = this;
        do {
            if (lVar.f5152a == i4 && ((obj2 = lVar.f5153b) == obj || (obj2 != null && obj.equals(obj2)))) {
                return lVar;
            }
            lVar = lVar.f5155d;
        } while (lVar != null);
        return null;
    }
}
