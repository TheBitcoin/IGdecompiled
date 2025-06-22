package K0;

import j$.util.DesugarCollections;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: K0.c  reason: case insensitive filesystem */
public final class C1494c {

    /* renamed from: a  reason: collision with root package name */
    private final String f7277a;

    /* renamed from: b  reason: collision with root package name */
    private final Map f7278b;

    /* renamed from: K0.c$b */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f7279a;

        /* renamed from: b  reason: collision with root package name */
        private Map f7280b = null;

        b(String str) {
            this.f7279a = str;
        }

        public C1494c a() {
            Map map;
            String str = this.f7279a;
            if (this.f7280b == null) {
                map = Collections.EMPTY_MAP;
            } else {
                map = DesugarCollections.unmodifiableMap(new HashMap(this.f7280b));
            }
            return new C1494c(str, map);
        }

        public b b(Annotation annotation) {
            if (this.f7280b == null) {
                this.f7280b = new HashMap();
            }
            this.f7280b.put(annotation.annotationType(), annotation);
            return this;
        }
    }

    public static b a(String str) {
        return new b(str);
    }

    public static C1494c d(String str) {
        return new C1494c(str, Collections.EMPTY_MAP);
    }

    public String b() {
        return this.f7277a;
    }

    public Annotation c(Class cls) {
        return (Annotation) this.f7278b.get(cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1494c)) {
            return false;
        }
        C1494c cVar = (C1494c) obj;
        if (!this.f7277a.equals(cVar.f7277a) || !this.f7278b.equals(cVar.f7278b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f7277a.hashCode() * 31) + this.f7278b.hashCode();
    }

    public String toString() {
        return "FieldDescriptor{name=" + this.f7277a + ", properties=" + this.f7278b.values() + "}";
    }

    private C1494c(String str, Map map) {
        this.f7277a = str;
        this.f7278b = map;
    }
}
