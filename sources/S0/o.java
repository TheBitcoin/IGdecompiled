package s0;

import J0.C1310a;
import O0.c;
import O0.d;
import android.util.Log;
import androidx.lifecycle.i;
import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public class o implements C2270e, C1310a {

    /* renamed from: i  reason: collision with root package name */
    private static final R0.b f21727i = new k();

    /* renamed from: a  reason: collision with root package name */
    private final Map f21728a;

    /* renamed from: b  reason: collision with root package name */
    private final Map f21729b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f21730c;

    /* renamed from: d  reason: collision with root package name */
    private final List f21731d;

    /* renamed from: e  reason: collision with root package name */
    private Set f21732e;

    /* renamed from: f  reason: collision with root package name */
    private final v f21733f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicReference f21734g;

    /* renamed from: h  reason: collision with root package name */
    private final j f21735h;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Executor f21736a;

        /* renamed from: b  reason: collision with root package name */
        private final List f21737b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private final List f21738c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private j f21739d = j.f21720a;

        b(Executor executor) {
            this.f21736a = executor;
        }

        public static /* synthetic */ ComponentRegistrar a(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }

        public b b(C2268c cVar) {
            this.f21738c.add(cVar);
            return this;
        }

        public b c(ComponentRegistrar componentRegistrar) {
            this.f21737b.add(new p(componentRegistrar));
            return this;
        }

        public b d(Collection collection) {
            this.f21737b.addAll(collection);
            return this;
        }

        public o e() {
            return new o(this.f21736a, this.f21737b, this.f21738c, this.f21739d);
        }

        public b f(j jVar) {
            this.f21739d = jVar;
            return this;
        }
    }

    public static b m(Executor executor) {
        return new b(executor);
    }

    private void n(List list) {
        int i4;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator it = this.f21731d.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((R0.b) it.next()).get();
                    if (componentRegistrar != null) {
                        list.addAll(this.f21735h.a(componentRegistrar));
                        it.remove();
                    }
                } catch (w e5) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e5);
                }
            }
            Iterator it2 = list.iterator();
            while (true) {
                i4 = 0;
                if (!it2.hasNext()) {
                    break;
                }
                Object[] array = ((C2268c) it2.next()).j().toArray();
                int length = array.length;
                while (true) {
                    if (i4 >= length) {
                        break;
                    }
                    Object obj = array[i4];
                    if (obj.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                        if (this.f21732e.contains(obj.toString())) {
                            it2.remove();
                            break;
                        }
                        this.f21732e.add(obj.toString());
                    }
                    i4++;
                }
            }
            if (this.f21728a.isEmpty()) {
                q.a(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.f21728a.keySet());
                arrayList2.addAll(list);
                q.a(arrayList2);
            }
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                C2268c cVar = (C2268c) it3.next();
                this.f21728a.put(cVar, new x(new l(this, cVar)));
            }
            arrayList.addAll(t(list));
            arrayList.addAll(u());
            s();
        }
        int size = arrayList.size();
        while (i4 < size) {
            Object obj2 = arrayList.get(i4);
            i4++;
            ((Runnable) obj2).run();
        }
        r();
    }

    private void o(Map map, boolean z4) {
        for (Map.Entry entry : map.entrySet()) {
            C2268c cVar = (C2268c) entry.getKey();
            R0.b bVar = (R0.b) entry.getValue();
            if (cVar.n() || (cVar.o() && z4)) {
                bVar.get();
            }
        }
        this.f21733f.d();
    }

    private static List q(Iterable iterable) {
        ArrayList arrayList = new ArrayList();
        for (Object add : iterable) {
            arrayList.add(add);
        }
        return arrayList;
    }

    private void r() {
        Boolean bool = (Boolean) this.f21734g.get();
        if (bool != null) {
            o(this.f21728a, bool.booleanValue());
        }
    }

    private void s() {
        for (C2268c cVar : this.f21728a.keySet()) {
            Iterator it = cVar.g().iterator();
            while (true) {
                if (it.hasNext()) {
                    r rVar = (r) it.next();
                    if (rVar.g() && !this.f21730c.containsKey(rVar.c())) {
                        this.f21730c.put(rVar.c(), y.b(Collections.EMPTY_SET));
                    } else if (this.f21729b.containsKey(rVar.c())) {
                        continue;
                    } else if (rVar.f()) {
                        throw new z(String.format("Unsatisfied dependency for component %s: %s", new Object[]{cVar, rVar.c()}));
                    } else if (!rVar.g()) {
                        this.f21729b.put(rVar.c(), C2262D.e());
                    }
                }
            }
        }
    }

    private List t(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C2268c cVar = (C2268c) it.next();
            if (cVar.p()) {
                R0.b bVar = (R0.b) this.f21728a.get(cVar);
                for (C2264F f4 : cVar.j()) {
                    if (!this.f21729b.containsKey(f4)) {
                        this.f21729b.put(f4, bVar);
                    } else {
                        arrayList.add(new m((C2262D) ((R0.b) this.f21729b.get(f4)), bVar));
                    }
                }
            }
        }
        return arrayList;
    }

    private List u() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.f21728a.entrySet()) {
            C2268c cVar = (C2268c) entry.getKey();
            if (!cVar.p()) {
                R0.b bVar = (R0.b) entry.getValue();
                for (C2264F f4 : cVar.j()) {
                    if (!hashMap.containsKey(f4)) {
                        hashMap.put(f4, new HashSet());
                    }
                    ((Set) hashMap.get(f4)).add(bVar);
                }
            }
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            if (!this.f21730c.containsKey(entry2.getKey())) {
                this.f21730c.put((C2264F) entry2.getKey(), y.b((Collection) entry2.getValue()));
            } else {
                y yVar = (y) this.f21730c.get(entry2.getKey());
                for (R0.b nVar : (Set) entry2.getValue()) {
                    arrayList.add(new n(yVar, nVar));
                }
            }
        }
        return arrayList;
    }

    public /* synthetic */ Object a(Class cls) {
        return C2269d.a(this, cls);
    }

    public /* synthetic */ Set b(C2264F f4) {
        return C2269d.f(this, f4);
    }

    public R0.a c(C2264F f4) {
        R0.b g4 = g(f4);
        if (g4 == null) {
            return C2262D.e();
        }
        if (g4 instanceof C2262D) {
            return (C2262D) g4;
        }
        return C2262D.f(g4);
    }

    public /* synthetic */ R0.b d(Class cls) {
        return C2269d.d(this, cls);
    }

    public /* synthetic */ Set e(Class cls) {
        return C2269d.e(this, cls);
    }

    public synchronized R0.b f(C2264F f4) {
        y yVar = (y) this.f21730c.get(f4);
        if (yVar != null) {
            return yVar;
        }
        return f21727i;
    }

    public synchronized R0.b g(C2264F f4) {
        C2263E.c(f4, "Null interface requested.");
        return (R0.b) this.f21729b.get(f4);
    }

    public /* synthetic */ Object h(C2264F f4) {
        return C2269d.b(this, f4);
    }

    public /* synthetic */ R0.a i(Class cls) {
        return C2269d.c(this, cls);
    }

    public void p(boolean z4) {
        HashMap hashMap;
        if (i.a(this.f21734g, (Object) null, Boolean.valueOf(z4))) {
            synchronized (this) {
                hashMap = new HashMap(this.f21728a);
            }
            o(hashMap, z4);
        }
    }

    private o(Executor executor, Iterable iterable, Collection collection, j jVar) {
        this.f21728a = new HashMap();
        this.f21729b = new HashMap();
        this.f21730c = new HashMap();
        this.f21732e = new HashSet();
        this.f21734g = new AtomicReference();
        v vVar = new v(executor);
        this.f21733f = vVar;
        this.f21735h = jVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(C2268c.q(vVar, v.class, d.class, c.class));
        arrayList.add(C2268c.q(this, C1310a.class, new Class[0]));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            C2268c cVar = (C2268c) it.next();
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        this.f21731d = q(iterable);
        n(arrayList);
    }
}
