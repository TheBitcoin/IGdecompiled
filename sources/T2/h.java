package T2;

import S2.C1591e;
import e3.b;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class h extends C1591e implements Set, Serializable, b {

    /* renamed from: b  reason: collision with root package name */
    private static final a f8359b = new a((C2103g) null);

    /* renamed from: c  reason: collision with root package name */
    private static final h f8360c = new h(d.f8335n.e());

    /* renamed from: a  reason: collision with root package name */
    private final d f8361a;

    private static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public h(d dVar) {
        m.e(dVar, "backing");
        this.f8361a = dVar;
    }

    public boolean add(Object obj) {
        if (this.f8361a.j(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean addAll(Collection collection) {
        m.e(collection, "elements");
        this.f8361a.m();
        return super.addAll(collection);
    }

    public int c() {
        return this.f8361a.size();
    }

    public void clear() {
        this.f8361a.clear();
    }

    public boolean contains(Object obj) {
        return this.f8361a.containsKey(obj);
    }

    public final Set h() {
        this.f8361a.l();
        if (size() > 0) {
            return this;
        }
        return f8360c;
    }

    public boolean isEmpty() {
        return this.f8361a.isEmpty();
    }

    public Iterator iterator() {
        return this.f8361a.D();
    }

    public boolean remove(Object obj) {
        return this.f8361a.M(obj);
    }

    public boolean removeAll(Collection collection) {
        m.e(collection, "elements");
        this.f8361a.m();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        m.e(collection, "elements");
        this.f8361a.m();
        return super.retainAll(collection);
    }

    public h() {
        this(new d());
    }
}
