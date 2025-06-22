package j$.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* renamed from: j$.util.t  reason: case insensitive filesystem */
public final class C1258t implements Map, Serializable, Map {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: a  reason: collision with root package name */
    public final Map f5653a;

    /* renamed from: b  reason: collision with root package name */
    public transient Set f5654b;

    /* renamed from: c  reason: collision with root package name */
    public transient C1143s f5655c;

    /* renamed from: d  reason: collision with root package name */
    public transient Collection f5656d;

    public C1258t(Map map) {
        map.getClass();
        this.f5653a = map;
    }

    public final int size() {
        return this.f5653a.size();
    }

    public final boolean isEmpty() {
        return this.f5653a.isEmpty();
    }

    public final boolean containsKey(Object obj) {
        return this.f5653a.containsKey(obj);
    }

    public final boolean containsValue(Object obj) {
        return this.f5653a.containsValue(obj);
    }

    public final Object get(Object obj) {
        return this.f5653a.get(obj);
    }

    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public final Set keySet() {
        if (this.f5654b == null) {
            this.f5654b = DesugarCollections.unmodifiableSet(this.f5653a.keySet());
        }
        return this.f5654b;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [j$.util.s, j$.util.n] */
    public final Set entrySet() {
        if (this.f5655c == null) {
            this.f5655c = new C1139n(this.f5653a.entrySet());
        }
        return this.f5655c;
    }

    public final Collection values() {
        if (this.f5656d == null) {
            this.f5656d = DesugarCollections.unmodifiableCollection(this.f5653a.values());
        }
        return this.f5656d;
    }

    public final boolean equals(Object obj) {
        return obj == this || this.f5653a.equals(obj);
    }

    public final int hashCode() {
        return this.f5653a.hashCode();
    }

    public final String toString() {
        return this.f5653a.toString();
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        return C1127b.u(this.f5653a, obj, obj2);
    }

    public final void forEach(BiConsumer biConsumer) {
        C1127b.s(this.f5653a, biConsumer);
    }

    public final void replaceAll(BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        throw new UnsupportedOperationException();
    }

    public final Object replace(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public final Object computeIfAbsent(Object obj, Function function) {
        throw new UnsupportedOperationException();
    }

    public final Object computeIfPresent(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }

    public final Object compute(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }

    public final Object merge(Object obj, Object obj2, BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }
}
