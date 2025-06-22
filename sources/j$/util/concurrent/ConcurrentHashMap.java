package j$.util.concurrent;

import j$.sun.misc.a;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable, u {

    /* renamed from: g  reason: collision with root package name */
    public static final int f5118g = Runtime.getRuntime().availableProcessors();

    /* renamed from: h  reason: collision with root package name */
    public static final a f5119h;

    /* renamed from: i  reason: collision with root package name */
    public static final long f5120i;

    /* renamed from: j  reason: collision with root package name */
    public static final long f5121j;

    /* renamed from: k  reason: collision with root package name */
    public static final long f5122k;

    /* renamed from: l  reason: collision with root package name */
    public static final long f5123l;

    /* renamed from: m  reason: collision with root package name */
    public static final long f5124m;

    /* renamed from: n  reason: collision with root package name */
    public static final int f5125n;

    /* renamed from: o  reason: collision with root package name */
    public static final int f5126o;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 7249069246763182397L;

    /* renamed from: a  reason: collision with root package name */
    public volatile transient l[] f5127a;

    /* renamed from: b  reason: collision with root package name */
    public volatile transient l[] f5128b;
    private volatile transient long baseCount;

    /* renamed from: c  reason: collision with root package name */
    public volatile transient c[] f5129c;
    private volatile transient int cellsBusy;

    /* renamed from: d  reason: collision with root package name */
    public transient i f5130d;

    /* renamed from: e  reason: collision with root package name */
    public transient s f5131e;

    /* renamed from: f  reason: collision with root package name */
    public transient e f5132f;
    private volatile transient int sizeCtl;
    private volatile transient int transferIndex;

    public static final int i(int i4) {
        return (i4 ^ (i4 >>> 16)) & Integer.MAX_VALUE;
    }

    static {
        ObjectStreamField objectStreamField = new ObjectStreamField("segments", n[].class);
        Class cls = Integer.TYPE;
        serialPersistentFields = new ObjectStreamField[]{objectStreamField, new ObjectStreamField("segmentMask", cls), new ObjectStreamField("segmentShift", cls)};
        a aVar = a.f4833b;
        f5119h = aVar;
        Class<ConcurrentHashMap> cls2 = ConcurrentHashMap.class;
        f5120i = aVar.h(cls2, "sizeCtl");
        f5121j = aVar.h(cls2, "transferIndex");
        f5122k = aVar.h(cls2, "baseCount");
        f5123l = aVar.h(cls2, "cellsBusy");
        f5124m = aVar.h(c.class, "value");
        f5125n = aVar.a();
        int b5 = aVar.b();
        if (((b5 - 1) & b5) == 0) {
            f5126o = 31 - Integer.numberOfLeadingZeros(b5);
            return;
        }
        throw new ExceptionInInitializerError("array index scale not a power of two");
    }

    public static final int l(int i4) {
        int numberOfLeadingZeros = -1 >>> Integer.numberOfLeadingZeros(i4 - 1);
        if (numberOfLeadingZeros < 0) {
            return 1;
        }
        if (numberOfLeadingZeros >= 1073741824) {
            return 1073741824;
        }
        return numberOfLeadingZeros + 1;
    }

    public static Class c(Object obj) {
        Type[] actualTypeArguments;
        if (!(obj instanceof Comparable)) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (cls != String.class) {
            Type[] genericInterfaces = cls.getGenericInterfaces();
            if (genericInterfaces == null) {
                return null;
            }
            for (Type type : genericInterfaces) {
                if (type instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    if (parameterizedType.getRawType() == Comparable.class && (actualTypeArguments = parameterizedType.getActualTypeArguments()) != null && actualTypeArguments.length == 1 && actualTypeArguments[0] == cls) {
                    }
                }
            }
            return null;
        }
        return cls;
    }

    public static final l k(l[] lVarArr, int i4) {
        return (l) f5119h.f(lVarArr, (((long) i4) << f5126o) + ((long) f5125n));
    }

    public static final boolean b(l[] lVarArr, int i4, l lVar) {
        return j$.com.android.tools.r8.a.z(f5119h.f4834a, lVarArr, (((long) i4) << f5126o) + ((long) f5125n), lVar);
    }

    public static final void h(l[] lVarArr, int i4, l lVar) {
        f5119h.j(lVarArr, (((long) i4) << f5126o) + ((long) f5125n), lVar);
    }

    public ConcurrentHashMap() {
    }

    public ConcurrentHashMap(int i4, float f4, int i5) {
        int i6;
        if (f4 <= 0.0f || i4 < 0 || i5 <= 0) {
            throw new IllegalArgumentException();
        }
        long j4 = (long) (((double) (((float) ((long) (i4 < i5 ? i5 : i4))) / f4)) + 1.0d);
        if (j4 >= 1073741824) {
            i6 = 1073741824;
        } else {
            i6 = l((int) j4);
        }
        this.sizeCtl = i6;
    }

    public int size() {
        long j4 = j();
        if (j4 < 0) {
            return 0;
        }
        if (j4 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j4;
    }

    public boolean isEmpty() {
        return j() <= 0;
    }

    public V get(Object obj) {
        int length;
        l k4;
        Object obj2;
        int i4 = i(obj.hashCode());
        l[] lVarArr = this.f5127a;
        if (lVarArr == null || (length = lVarArr.length) <= 0 || (k4 = k(lVarArr, (length - 1) & i4)) == null) {
            return null;
        }
        int i5 = k4.f5152a;
        if (i5 == i4) {
            Object obj3 = k4.f5153b;
            if (obj3 == obj || (obj3 != null && obj.equals(obj3))) {
                return k4.f5154c;
            }
        } else if (i5 < 0) {
            l a5 = k4.a(i4, obj);
            if (a5 != null) {
                return a5.f5154c;
            }
            return null;
        }
        while (true) {
            k4 = k4.f5155d;
            if (k4 == null) {
                return null;
            }
            if (k4.f5152a != i4 || ((obj2 = k4.f5153b) != obj && (obj2 == null || !obj.equals(obj2)))) {
            }
        }
        return k4.f5154c;
    }

    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(Object obj) {
        obj.getClass();
        l[] lVarArr = this.f5127a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a5 = pVar.a();
                if (a5 == null) {
                    break;
                }
                Object obj2 = a5.f5154c;
                if (obj2 == obj) {
                    return true;
                }
                if (obj2 != null && obj.equals(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public V put(K k4, V v4) {
        return f(k4, v4, false);
    }

    public final Object f(Object obj, Object obj2, boolean z4) {
        Object obj3;
        Object obj4;
        Object obj5;
        if (obj == null || obj2 == null) {
            throw null;
        }
        int i4 = i(obj.hashCode());
        l[] lVarArr = this.f5127a;
        int i5 = 0;
        while (true) {
            if (lVarArr != null) {
                int length = lVarArr.length;
                if (length != 0) {
                    int i6 = (length - 1) & i4;
                    l k4 = k(lVarArr, i6);
                    if (k4 != null) {
                        int i7 = k4.f5152a;
                        if (i7 == -1) {
                            lVarArr = d(lVarArr, k4);
                        } else if (z4 && i7 == i4 && (((obj4 = k4.f5153b) == obj || (obj4 != null && obj.equals(obj4))) && (obj5 = k4.f5154c) != null)) {
                            return obj5;
                        } else {
                            synchronized (k4) {
                                try {
                                    if (k(lVarArr, i6) == k4) {
                                        if (i7 >= 0) {
                                            i5 = 1;
                                            l lVar = k4;
                                            while (true) {
                                                if (lVar.f5152a == i4) {
                                                    Object obj6 = lVar.f5153b;
                                                    if (obj6 != obj) {
                                                        if (obj6 != null && obj.equals(obj6)) {
                                                            break;
                                                        }
                                                    } else {
                                                        break;
                                                    }
                                                }
                                                l lVar2 = lVar.f5155d;
                                                if (lVar2 == null) {
                                                    lVar.f5155d = new l(i4, obj, obj2);
                                                    break;
                                                }
                                                i5++;
                                                lVar = lVar2;
                                            }
                                            obj3 = lVar.f5154c;
                                            if (!z4) {
                                                lVar.f5154c = obj2;
                                            }
                                        } else if (k4 instanceof q) {
                                            r e5 = ((q) k4).e(i4, obj, obj2);
                                            if (e5 != null) {
                                                Object obj7 = e5.f5154c;
                                                if (!z4) {
                                                    e5.f5154c = obj2;
                                                }
                                                obj3 = obj7;
                                            } else {
                                                obj3 = null;
                                            }
                                            i5 = 2;
                                        } else if (k4 instanceof m) {
                                            throw new IllegalStateException("Recursive update");
                                        }
                                    }
                                    obj3 = null;
                                } catch (Throwable th) {
                                    while (true) {
                                        throw th;
                                    }
                                }
                            }
                            if (i5 != 0) {
                                if (i5 >= 8) {
                                    n(lVarArr, i6);
                                }
                                if (obj3 != null) {
                                    return obj3;
                                }
                            }
                        }
                    } else if (b(lVarArr, i6, new l(i4, obj, obj2))) {
                        break;
                    }
                }
            }
            lVarArr = e();
        }
        a(1, i5);
        return null;
    }

    public final void putAll(Map map) {
        o(map.size());
        for (Map.Entry entry : map.entrySet()) {
            f(entry.getKey(), entry.getValue(), false);
        }
    }

    public V remove(Object obj) {
        return g(obj, (Object) null, (Object) null);
    }

    public final Object g(Object obj, Object obj2, Object obj3) {
        int length;
        int i4;
        l k4;
        Object obj4;
        boolean z4;
        r b5;
        int i5 = i(obj.hashCode());
        l[] lVarArr = this.f5127a;
        while (true) {
            if (lVarArr == null || (length = lVarArr.length) == 0 || (k4 = k(lVarArr, i4)) == null) {
                break;
            }
            int i6 = k4.f5152a;
            if (i6 == -1) {
                lVarArr = d(lVarArr, k4);
            } else {
                synchronized (k4) {
                    try {
                        if (k(lVarArr, (i4 = (length - 1) & i5)) == k4) {
                            z4 = true;
                            if (i6 >= 0) {
                                l lVar = null;
                                l lVar2 = k4;
                                while (true) {
                                    if (lVar2.f5152a == i5) {
                                        Object obj5 = lVar2.f5153b;
                                        if (obj5 != obj) {
                                            if (obj5 != null && obj.equals(obj5)) {
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                    l lVar3 = lVar2.f5155d;
                                    if (lVar3 == null) {
                                        break;
                                    }
                                    l lVar4 = lVar3;
                                    lVar = lVar2;
                                    lVar2 = lVar4;
                                }
                                obj4 = lVar2.f5154c;
                                if (obj3 == null || obj3 == obj4 || (obj4 != null && obj3.equals(obj4))) {
                                    if (obj2 != null) {
                                        lVar2.f5154c = obj2;
                                    } else if (lVar != null) {
                                        lVar.f5155d = lVar2.f5155d;
                                    } else {
                                        h(lVarArr, i4, lVar2.f5155d);
                                    }
                                }
                                obj4 = null;
                            } else if (k4 instanceof q) {
                                q qVar = (q) k4;
                                r rVar = qVar.f5170e;
                                if (rVar != null && (b5 = rVar.b(i5, obj, (Class) null)) != null) {
                                    obj4 = b5.f5154c;
                                    if (obj3 == null || obj3 == obj4 || (obj4 != null && obj3.equals(obj4))) {
                                        if (obj2 != null) {
                                            b5.f5154c = obj2;
                                        } else if (qVar.f(b5)) {
                                            h(lVarArr, i4, p(qVar.f5171f));
                                        }
                                    }
                                }
                                obj4 = null;
                            } else if (k4 instanceof m) {
                                throw new IllegalStateException("Recursive update");
                            }
                        }
                        z4 = false;
                        obj4 = null;
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
                if (z4) {
                    if (obj4 != null) {
                        if (obj2 == null) {
                            a(-1, -1);
                        }
                        return obj4;
                    }
                }
            }
        }
        return null;
    }

    public void clear() {
        l lVar;
        l[] lVarArr = this.f5127a;
        long j4 = 0;
        loop0:
        while (true) {
            int i4 = 0;
            while (lVarArr != null && i4 < lVarArr.length) {
                l k4 = k(lVarArr, i4);
                if (k4 == null) {
                    i4++;
                } else {
                    int i5 = k4.f5152a;
                    if (i5 == -1) {
                        lVarArr = d(lVarArr, k4);
                    } else {
                        synchronized (k4) {
                            try {
                                if (k(lVarArr, i4) == k4) {
                                    if (i5 >= 0) {
                                        lVar = k4;
                                    } else {
                                        lVar = k4 instanceof q ? ((q) k4).f5171f : null;
                                    }
                                    while (lVar != null) {
                                        j4--;
                                        lVar = lVar.f5155d;
                                    }
                                    h(lVarArr, i4, (l) null);
                                    i4++;
                                }
                            } finally {
                            }
                        }
                    }
                }
            }
        }
        if (j4 != 0) {
            a(j4, -1);
        }
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [j$.util.concurrent.b, java.util.Set<K>, j$.util.concurrent.i] */
    public Set<K> keySet() {
        i iVar = this.f5130d;
        if (iVar != null) {
            return iVar;
        }
        ? bVar = new b(this);
        this.f5130d = bVar;
        return bVar;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.util.Collection<V>, j$.util.concurrent.b, j$.util.concurrent.s] */
    public Collection<V> values() {
        s sVar = this.f5131e;
        if (sVar != null) {
            return sVar;
        }
        ? bVar = new b(this);
        this.f5131e = bVar;
        return bVar;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [j$.util.concurrent.b, j$.util.concurrent.e, java.util.Set<java.util.Map$Entry<K, V>>] */
    public Set<Map.Entry<K, V>> entrySet() {
        e eVar = this.f5132f;
        if (eVar != null) {
            return eVar;
        }
        ? bVar = new b(this);
        this.f5132f = bVar;
        return bVar;
    }

    public final int hashCode() {
        l[] lVarArr = this.f5127a;
        int i4 = 0;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a5 = pVar.a();
                if (a5 == null) {
                    break;
                }
                i4 += a5.f5154c.hashCode() ^ a5.f5153b.hashCode();
            }
        }
        return i4;
    }

    public final String toString() {
        l[] lVarArr = this.f5127a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        p pVar = new p(lVarArr, length, 0, length);
        StringBuilder sb = new StringBuilder("{");
        l a5 = pVar.a();
        if (a5 != null) {
            while (true) {
                Object obj = a5.f5153b;
                Object obj2 = a5.f5154c;
                if (obj == this) {
                    obj = "(this Map)";
                }
                sb.append(obj);
                sb.append('=');
                if (obj2 == this) {
                    obj2 = "(this Map)";
                }
                sb.append(obj2);
                a5 = pVar.a();
                if (a5 == null) {
                    break;
                }
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        Object value;
        Object obj2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        l[] lVarArr = this.f5127a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        p pVar = new p(lVarArr, length, 0, length);
        while (true) {
            l a5 = pVar.a();
            if (a5 != null) {
                Object obj3 = a5.f5154c;
                Object obj4 = map.get(a5.f5153b);
                if (obj4 == null || (obj4 != obj3 && !obj4.equals(obj3))) {
                    return false;
                }
            } else {
                for (Map.Entry entry : map.entrySet()) {
                    Object key = entry.getKey();
                    if (key == null || (value = entry.getValue()) == null || (obj2 = get(key)) == null || (value != obj2 && !value.equals(obj2))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        int i4 = 1;
        int i5 = 0;
        while (i4 < 16) {
            i5++;
            i4 <<= 1;
        }
        int i6 = 32 - i5;
        int i7 = i4 - 1;
        Object[] objArr = new n[16];
        for (int i8 = 0; i8 < 16; i8++) {
            objArr[i8] = new ReentrantLock();
        }
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("segments", objArr);
        putFields.put("segmentShift", i6);
        putFields.put("segmentMask", i7);
        objectOutputStream.writeFields();
        l[] lVarArr = this.f5127a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a5 = pVar.a();
                if (a5 == null) {
                    break;
                }
                objectOutputStream.writeObject(a5.f5153b);
                objectOutputStream.writeObject(a5.f5154c);
            }
        }
        objectOutputStream.writeObject((Object) null);
        objectOutputStream.writeObject((Object) null);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        long j4;
        int i4;
        long j5;
        Object obj;
        this.sizeCtl = -1;
        objectInputStream.defaultReadObject();
        long j6 = 0;
        long j7 = 0;
        l lVar = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            Object readObject2 = objectInputStream.readObject();
            j4 = 1;
            if (readObject != null && readObject2 != null) {
                j7++;
                lVar = new l(i(readObject.hashCode()), readObject, readObject2, lVar);
            }
        }
        if (j7 == 0) {
            this.sizeCtl = 0;
            return;
        }
        long j8 = (long) (((double) (((float) j7) / 0.75f)) + 1.0d);
        if (j8 >= 1073741824) {
            i4 = 1073741824;
        } else {
            i4 = l((int) j8);
        }
        l[] lVarArr = new l[i4];
        int i5 = i4 - 1;
        while (lVar != null) {
            l lVar2 = lVar.f5155d;
            int i6 = lVar.f5152a;
            int i7 = i6 & i5;
            l k4 = k(lVarArr, i7);
            boolean z4 = true;
            if (k4 == null) {
                j5 = j4;
            } else {
                Object obj2 = lVar.f5153b;
                if (k4.f5152a < 0) {
                    if (((q) k4).e(i6, obj2, lVar.f5154c) == null) {
                        j6 += j4;
                    }
                    j5 = j4;
                } else {
                    j5 = j4;
                    l lVar3 = k4;
                    int i8 = 0;
                    while (true) {
                        if (lVar3 == null) {
                            break;
                        } else if (lVar3.f5152a != i6 || ((obj = lVar3.f5153b) != obj2 && (obj == null || !obj2.equals(obj)))) {
                            i8++;
                            lVar3 = lVar3.f5155d;
                        }
                    }
                    z4 = false;
                    if (z4 && i8 >= 8) {
                        j6 += j5;
                        lVar.f5155d = k4;
                        l lVar4 = lVar;
                        r rVar = null;
                        r rVar2 = null;
                        while (lVar4 != null) {
                            r rVar3 = new r(lVar4.f5152a, lVar4.f5153b, lVar4.f5154c, (l) null, (r) null);
                            rVar3.f5176h = rVar2;
                            if (rVar2 == null) {
                                rVar = rVar3;
                            } else {
                                rVar2.f5155d = rVar3;
                            }
                            lVar4 = lVar4.f5155d;
                            rVar2 = rVar3;
                        }
                        h(lVarArr, i7, new q(rVar));
                    }
                }
                z4 = false;
            }
            if (z4) {
                j6 += j5;
                lVar.f5155d = k4;
                h(lVarArr, i7, lVar);
            }
            lVar = lVar2;
            j4 = j5;
        }
        this.f5127a = lVarArr;
        this.sizeCtl = i4 - (i4 >>> 2);
        this.baseCount = j6;
    }

    public V putIfAbsent(K k4, V v4) {
        return f(k4, v4, true);
    }

    public boolean remove(Object obj, Object obj2) {
        obj.getClass();
        return (obj2 == null || g(obj, (Object) null, obj2) == null) ? false : true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        if (obj != null && obj2 != null && obj3 != null) {
            return g(obj, obj3, obj2) != null;
        }
        throw null;
    }

    public final Object replace(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            return g(obj, obj2, (Object) null);
        }
        throw null;
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? obj2 : obj3;
    }

    public final void forEach(BiConsumer biConsumer) {
        biConsumer.getClass();
        l[] lVarArr = this.f5127a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a5 = pVar.a();
                if (a5 != null) {
                    biConsumer.accept(a5.f5153b, a5.f5154c);
                } else {
                    return;
                }
            }
        }
    }

    public final void replaceAll(BiFunction biFunction) {
        biFunction.getClass();
        l[] lVarArr = this.f5127a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a5 = pVar.a();
                if (a5 != null) {
                    Object obj = a5.f5154c;
                    Object obj2 = a5.f5153b;
                    do {
                        Object apply = biFunction.apply(obj2, obj);
                        apply.getClass();
                        if (g(obj2, apply, obj) != null || (obj = get(obj2)) == null) {
                        }
                        Object apply2 = biFunction.apply(obj2, obj);
                        apply2.getClass();
                        break;
                    } while ((obj = get(obj2)) == null);
                } else {
                    return;
                }
            }
        }
    }

    public final Object computeIfAbsent(Object obj, Function function) {
        r b5;
        Object obj2;
        Object obj3;
        if (obj == null || function == null) {
            throw null;
        }
        int i4 = i(obj.hashCode());
        l[] lVarArr = this.f5127a;
        Object obj4 = null;
        int i5 = 0;
        while (true) {
            if (lVarArr != null) {
                int length = lVarArr.length;
                if (length != 0) {
                    int i6 = (length - 1) & i4;
                    l k4 = k(lVarArr, i6);
                    boolean z4 = true;
                    if (k4 == null) {
                        m mVar = new m();
                        synchronized (mVar) {
                            try {
                                if (b(lVarArr, i6, mVar)) {
                                    obj4 = function.apply(obj);
                                    h(lVarArr, i6, obj4 != null ? new l(i4, obj, obj4) : null);
                                    i5 = 1;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (i5 != 0) {
                            break;
                        }
                    } else {
                        int i7 = k4.f5152a;
                        if (i7 == -1) {
                            lVarArr = d(lVarArr, k4);
                        } else if (i7 == i4 && (((obj2 = k4.f5153b) == obj || (obj2 != null && obj.equals(obj2))) && (obj3 = k4.f5154c) != null)) {
                            return obj3;
                        } else {
                            synchronized (k4) {
                                try {
                                    if (k(lVarArr, i6) == k4) {
                                        if (i7 >= 0) {
                                            l lVar = k4;
                                            i5 = 1;
                                            while (true) {
                                                if (lVar.f5152a == i4) {
                                                    Object obj5 = lVar.f5153b;
                                                    if (obj5 != obj) {
                                                        if (obj5 != null && obj.equals(obj5)) {
                                                            break;
                                                        }
                                                    } else {
                                                        break;
                                                    }
                                                }
                                                l lVar2 = lVar.f5155d;
                                                if (lVar2 == null) {
                                                    Object apply = function.apply(obj);
                                                    if (apply == null) {
                                                        obj4 = apply;
                                                    } else if (lVar.f5155d == null) {
                                                        lVar.f5155d = new l(i4, obj, apply);
                                                        obj4 = apply;
                                                    } else {
                                                        throw new IllegalStateException("Recursive update");
                                                    }
                                                } else {
                                                    i5++;
                                                    lVar = lVar2;
                                                }
                                            }
                                            obj4 = lVar.f5154c;
                                        } else if (k4 instanceof q) {
                                            q qVar = (q) k4;
                                            r rVar = qVar.f5170e;
                                            if (rVar == null || (b5 = rVar.b(i4, obj, (Class) null)) == null) {
                                                obj4 = function.apply(obj);
                                                if (obj4 != null) {
                                                    qVar.e(i4, obj, obj4);
                                                    i5 = 2;
                                                }
                                            } else {
                                                obj4 = b5.f5154c;
                                            }
                                            z4 = false;
                                            i5 = 2;
                                        } else if (k4 instanceof m) {
                                            throw new IllegalStateException("Recursive update");
                                        }
                                    }
                                    z4 = false;
                                } catch (Throwable th2) {
                                    while (true) {
                                        throw th2;
                                    }
                                }
                            }
                            if (i5 != 0) {
                                if (i5 >= 8) {
                                    n(lVarArr, i6);
                                }
                                if (!z4) {
                                    return obj4;
                                }
                            }
                        }
                    }
                }
            }
            lVarArr = e();
        }
        if (obj4 != null) {
            a(1, i5);
        }
        return obj4;
    }

    public final Object computeIfPresent(Object obj, BiFunction biFunction) {
        r b5;
        if (obj == null || biFunction == null) {
            throw null;
        }
        int i4 = i(obj.hashCode());
        l[] lVarArr = this.f5127a;
        int i5 = 0;
        Object obj2 = null;
        int i6 = 0;
        while (true) {
            if (lVarArr != null) {
                int length = lVarArr.length;
                if (length != 0) {
                    int i7 = (length - 1) & i4;
                    l k4 = k(lVarArr, i7);
                    if (k4 == null) {
                        break;
                    }
                    int i8 = k4.f5152a;
                    if (i8 == -1) {
                        lVarArr = d(lVarArr, k4);
                    } else {
                        synchronized (k4) {
                            try {
                                if (k(lVarArr, i7) == k4) {
                                    if (i8 >= 0) {
                                        i6 = 1;
                                        l lVar = null;
                                        l lVar2 = k4;
                                        while (true) {
                                            if (lVar2.f5152a == i4) {
                                                Object obj3 = lVar2.f5153b;
                                                if (obj3 != obj) {
                                                    if (obj3 != null && obj.equals(obj3)) {
                                                        break;
                                                    }
                                                } else {
                                                    break;
                                                }
                                            }
                                            l lVar3 = lVar2.f5155d;
                                            if (lVar3 == null) {
                                                break;
                                            }
                                            i6++;
                                            l lVar4 = lVar3;
                                            lVar = lVar2;
                                            lVar2 = lVar4;
                                        }
                                        obj2 = biFunction.apply(obj, lVar2.f5154c);
                                        if (obj2 != null) {
                                            lVar2.f5154c = obj2;
                                        } else {
                                            l lVar5 = lVar2.f5155d;
                                            if (lVar != null) {
                                                lVar.f5155d = lVar5;
                                            } else {
                                                h(lVarArr, i7, lVar5);
                                            }
                                            i5 = -1;
                                        }
                                    } else if (k4 instanceof q) {
                                        q qVar = (q) k4;
                                        r rVar = qVar.f5170e;
                                        if (!(rVar == null || (b5 = rVar.b(i4, obj, (Class) null)) == null)) {
                                            obj2 = biFunction.apply(obj, b5.f5154c);
                                            if (obj2 != null) {
                                                b5.f5154c = obj2;
                                            } else {
                                                if (qVar.f(b5)) {
                                                    h(lVarArr, i7, p(qVar.f5171f));
                                                }
                                                i5 = -1;
                                            }
                                        }
                                        i6 = 2;
                                    } else if (k4 instanceof m) {
                                        throw new IllegalStateException("Recursive update");
                                    }
                                }
                            } catch (Throwable th) {
                                while (true) {
                                    throw th;
                                }
                            }
                        }
                        if (i6 != 0) {
                            break;
                        }
                    }
                }
            }
            lVarArr = e();
        }
        if (i5 != 0) {
            a((long) i5, i6);
        }
        return obj2;
    }

    public final Object compute(Object obj, BiFunction biFunction) {
        Object obj2;
        l lVar;
        if (obj == null || biFunction == null) {
            throw null;
        }
        int i4 = i(obj.hashCode());
        l[] lVarArr = this.f5127a;
        int i5 = 0;
        Object obj3 = null;
        int i6 = 0;
        while (true) {
            if (lVarArr != null) {
                int length = lVarArr.length;
                if (length != 0) {
                    int i7 = (length - 1) & i4;
                    l k4 = k(lVarArr, i7);
                    if (k4 == null) {
                        m mVar = new m();
                        synchronized (mVar) {
                            try {
                                if (b(lVarArr, i7, mVar)) {
                                    obj3 = biFunction.apply(obj, null);
                                    if (obj3 != null) {
                                        lVar = new l(i4, obj, obj3);
                                        i6 = 1;
                                    } else {
                                        lVar = null;
                                    }
                                    h(lVarArr, i7, lVar);
                                    i5 = 1;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (i5 != 0) {
                            break;
                        }
                    } else {
                        int i8 = k4.f5152a;
                        if (i8 == -1) {
                            lVarArr = d(lVarArr, k4);
                        } else {
                            synchronized (k4) {
                                try {
                                    if (k(lVarArr, i7) == k4) {
                                        if (i8 >= 0) {
                                            l lVar2 = null;
                                            l lVar3 = k4;
                                            i5 = 1;
                                            while (true) {
                                                if (lVar3.f5152a == i4) {
                                                    Object obj4 = lVar3.f5153b;
                                                    if (obj4 != obj) {
                                                        if (obj4 != null && obj.equals(obj4)) {
                                                            break;
                                                        }
                                                    } else {
                                                        break;
                                                    }
                                                }
                                                l lVar4 = lVar3.f5155d;
                                                if (lVar4 == null) {
                                                    Object apply = biFunction.apply(obj, null);
                                                    if (apply == null) {
                                                        obj3 = apply;
                                                    } else if (lVar3.f5155d == null) {
                                                        lVar3.f5155d = new l(i4, obj, apply);
                                                        obj3 = apply;
                                                        i6 = 1;
                                                    } else {
                                                        throw new IllegalStateException("Recursive update");
                                                    }
                                                } else {
                                                    i5++;
                                                    l lVar5 = lVar4;
                                                    lVar2 = lVar3;
                                                    lVar3 = lVar5;
                                                }
                                            }
                                            Object apply2 = biFunction.apply(obj, lVar3.f5154c);
                                            if (apply2 != null) {
                                                lVar3.f5154c = apply2;
                                                obj3 = apply2;
                                            } else {
                                                l lVar6 = lVar3.f5155d;
                                                if (lVar2 != null) {
                                                    lVar2.f5155d = lVar6;
                                                } else {
                                                    h(lVarArr, i7, lVar6);
                                                }
                                                obj3 = apply2;
                                                i6 = -1;
                                            }
                                        } else if (k4 instanceof q) {
                                            q qVar = (q) k4;
                                            r rVar = qVar.f5170e;
                                            r b5 = rVar != null ? rVar.b(i4, obj, (Class) null) : null;
                                            if (b5 == null) {
                                                obj2 = null;
                                            } else {
                                                obj2 = b5.f5154c;
                                            }
                                            Object apply3 = biFunction.apply(obj, obj2);
                                            if (apply3 != null) {
                                                if (b5 != null) {
                                                    b5.f5154c = apply3;
                                                } else {
                                                    qVar.e(i4, obj, apply3);
                                                    i6 = 1;
                                                }
                                            } else if (b5 != null) {
                                                if (qVar.f(b5)) {
                                                    h(lVarArr, i7, p(qVar.f5171f));
                                                }
                                                i6 = -1;
                                            }
                                            obj3 = apply3;
                                            i5 = 1;
                                        } else if (k4 instanceof m) {
                                            throw new IllegalStateException("Recursive update");
                                        }
                                    }
                                } catch (Throwable th2) {
                                    while (true) {
                                        throw th2;
                                    }
                                }
                            }
                            if (i5 != 0) {
                                if (i5 >= 8) {
                                    n(lVarArr, i7);
                                }
                            }
                        }
                    }
                }
            }
            lVarArr = e();
        }
        if (i6 != 0) {
            a((long) i6, i5);
        }
        return obj3;
    }

    public final Object merge(Object obj, Object obj2, BiFunction biFunction) {
        int i4;
        r rVar;
        Object obj3;
        Object obj4 = obj;
        Object obj5 = obj2;
        BiFunction biFunction2 = biFunction;
        if (obj4 == null || obj5 == null || biFunction2 == null) {
            throw null;
        }
        int i5 = i(obj4.hashCode());
        l[] lVarArr = this.f5127a;
        int i6 = 0;
        Object obj6 = null;
        int i7 = 0;
        while (true) {
            if (lVarArr != null) {
                int length = lVarArr.length;
                if (length != 0) {
                    int i8 = (length - 1) & i5;
                    l k4 = k(lVarArr, i8);
                    i4 = 1;
                    if (k4 != null) {
                        int i9 = k4.f5152a;
                        if (i9 == -1) {
                            lVarArr = d(lVarArr, k4);
                        } else {
                            synchronized (k4) {
                                try {
                                    if (k(lVarArr, i8) == k4) {
                                        if (i9 >= 0) {
                                            l lVar = null;
                                            l lVar2 = k4;
                                            i6 = 1;
                                            while (true) {
                                                if (lVar2.f5152a == i5) {
                                                    Object obj7 = lVar2.f5153b;
                                                    if (obj7 != obj4) {
                                                        if (obj7 != null && obj4.equals(obj7)) {
                                                            break;
                                                        }
                                                    } else {
                                                        break;
                                                    }
                                                }
                                                l lVar3 = lVar2.f5155d;
                                                if (lVar3 == null) {
                                                    lVar2.f5155d = new l(i5, obj4, obj5);
                                                    obj6 = obj5;
                                                    i7 = 1;
                                                    break;
                                                }
                                                i6++;
                                                l lVar4 = lVar3;
                                                lVar = lVar2;
                                                lVar2 = lVar4;
                                            }
                                            Object apply = biFunction2.apply(lVar2.f5154c, obj5);
                                            if (apply != null) {
                                                lVar2.f5154c = apply;
                                                obj6 = apply;
                                            } else {
                                                l lVar5 = lVar2.f5155d;
                                                if (lVar != null) {
                                                    lVar.f5155d = lVar5;
                                                } else {
                                                    h(lVarArr, i8, lVar5);
                                                }
                                                obj6 = apply;
                                                i7 = -1;
                                            }
                                        } else if (k4 instanceof q) {
                                            q qVar = (q) k4;
                                            r rVar2 = qVar.f5170e;
                                            if (rVar2 == null) {
                                                rVar = null;
                                            } else {
                                                rVar = rVar2.b(i5, obj4, (Class) null);
                                            }
                                            if (rVar == null) {
                                                obj3 = obj5;
                                            } else {
                                                obj3 = biFunction2.apply(rVar.f5154c, obj5);
                                            }
                                            if (obj3 != null) {
                                                if (rVar != null) {
                                                    rVar.f5154c = obj3;
                                                } else {
                                                    qVar.e(i5, obj4, obj3);
                                                    i7 = 1;
                                                }
                                            } else if (rVar != null) {
                                                if (qVar.f(rVar)) {
                                                    h(lVarArr, i8, p(qVar.f5171f));
                                                }
                                                i7 = -1;
                                            }
                                            i6 = 2;
                                            obj6 = obj3;
                                        } else if (k4 instanceof m) {
                                            throw new IllegalStateException("Recursive update");
                                        }
                                    }
                                } catch (Throwable th) {
                                    while (true) {
                                        throw th;
                                    }
                                }
                            }
                            if (i6 != 0) {
                                if (i6 >= 8) {
                                    n(lVarArr, i8);
                                }
                                i4 = i7;
                                obj5 = obj6;
                            }
                        }
                    } else if (b(lVarArr, i8, new l(i5, obj4, obj5))) {
                        break;
                    }
                }
            }
            lVarArr = e();
        }
        if (i4 != 0) {
            a((long) i4, i6);
        }
        return obj5;
    }

    public boolean contains(Object obj) {
        return containsValue(obj);
    }

    public final l[] e() {
        while (true) {
            l[] lVarArr = this.f5127a;
            if (lVarArr != null && lVarArr.length != 0) {
                return lVarArr;
            }
            int i4 = this.sizeCtl;
            if (i4 < 0) {
                Thread.yield();
            } else {
                if (f5119h.c(this, f5120i, i4, -1)) {
                    try {
                        l[] lVarArr2 = this.f5127a;
                        if (lVarArr2 != null) {
                            if (lVarArr2.length == 0) {
                            }
                            this.sizeCtl = i4;
                            return lVarArr2;
                        }
                        int i5 = i4 > 0 ? i4 : 16;
                        l[] lVarArr3 = new l[i5];
                        this.f5127a = lVarArr3;
                        i4 = i5 - (i5 >>> 2);
                        lVarArr2 = lVarArr3;
                        this.sizeCtl = i4;
                        return lVarArr2;
                    } catch (Throwable th) {
                        this.sizeCtl = i4;
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0017, code lost:
        if (r0.d(r1, r2, r4, r6) == false) goto L_0x0019;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x013f, code lost:
        if (r1.f5129c != r6) goto L_0x014e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0141, code lost:
        r1.f5129c = (j$.util.concurrent.c[]) java.util.Arrays.copyOf(r6, r7 << 1);
     */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01aa A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x00c1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(long r25, int r27) {
        /*
            r24 = this;
            r1 = r24
            r8 = r25
            r10 = r27
            j$.util.concurrent.c[] r11 = r1.f5129c
            r12 = 2
            if (r11 != 0) goto L_0x0019
            j$.sun.misc.a r0 = f5119h
            long r2 = f5122k
            long r4 = r1.baseCount
            long r6 = r4 + r8
            boolean r0 = r0.d(r1, r2, r4, r6)
            if (r0 != 0) goto L_0x0048
        L_0x0019:
            r13 = 1
            if (r11 == 0) goto L_0x00a4
            int r0 = r11.length
            int r0 = r0 - r13
            if (r0 < 0) goto L_0x00a4
            j$.util.concurrent.v r2 = j$.util.concurrent.ThreadLocalRandom.f5135f
            java.lang.Object r2 = r2.get()
            j$.util.concurrent.ThreadLocalRandom r2 = (j$.util.concurrent.ThreadLocalRandom) r2
            int r2 = r2.f5138b
            r0 = r0 & r2
            r15 = r11[r0]
            if (r15 == 0) goto L_0x00a4
            j$.sun.misc.a r14 = f5119h
            long r16 = f5124m
            long r2 = r15.value
            long r20 = r2 + r8
            r18 = r2
            boolean r0 = r14.d(r15, r16, r18, r20)
            if (r0 != 0) goto L_0x0040
            goto L_0x00a5
        L_0x0040:
            if (r10 > r13) goto L_0x0044
            goto L_0x01aa
        L_0x0044:
            long r6 = r1.j()
        L_0x0048:
            if (r10 < 0) goto L_0x01aa
        L_0x004a:
            int r4 = r1.sizeCtl
            long r2 = (long) r4
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x01aa
            j$.util.concurrent.l[] r6 = r1.f5127a
            if (r6 == 0) goto L_0x01aa
            int r0 = r6.length
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 >= r2) goto L_0x01aa
            int r0 = java.lang.Integer.numberOfLeadingZeros(r0)
            r2 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 | r2
            if (r4 >= 0) goto L_0x008c
            int r2 = r4 >>> 16
            if (r2 != r0) goto L_0x01aa
            int r2 = r0 + 1
            if (r4 == r2) goto L_0x01aa
            r2 = 65535(0xffff, float:9.1834E-41)
            int r0 = r0 + r2
            if (r4 == r0) goto L_0x01aa
            j$.util.concurrent.l[] r7 = r1.f5128b
            if (r7 == 0) goto L_0x01aa
            int r0 = r1.transferIndex
            if (r0 > 0) goto L_0x007c
            goto L_0x01aa
        L_0x007c:
            j$.sun.misc.a r0 = f5119h
            long r2 = f5120i
            int r5 = r4 + 1
            boolean r0 = r0.c(r1, r2, r4, r5)
            if (r0 == 0) goto L_0x009f
            r1.m(r6, r7)
            goto L_0x009f
        L_0x008c:
            r2 = r0
            j$.sun.misc.a r0 = f5119h
            r5 = r2
            long r2 = f5120i
            int r5 = r5 << 16
            int r5 = r5 + r12
            boolean r0 = r0.c(r1, r2, r4, r5)
            if (r0 == 0) goto L_0x009f
            r0 = 0
            r1.m(r6, r0)
        L_0x009f:
            long r6 = r1.j()
            goto L_0x004a
        L_0x00a4:
            r0 = 1
        L_0x00a5:
            j$.util.concurrent.v r2 = j$.util.concurrent.ThreadLocalRandom.f5135f
            java.lang.Object r3 = r2.get()
            j$.util.concurrent.ThreadLocalRandom r3 = (j$.util.concurrent.ThreadLocalRandom) r3
            int r3 = r3.f5138b
            if (r3 != 0) goto L_0x00bd
            j$.util.concurrent.ThreadLocalRandom.d()
            java.lang.Object r0 = r2.get()
            j$.util.concurrent.ThreadLocalRandom r0 = (j$.util.concurrent.ThreadLocalRandom) r0
            int r3 = r0.f5138b
            r0 = 1
        L_0x00bd:
            r10 = 0
            r11 = r0
            r14 = r3
        L_0x00c0:
            r15 = 0
        L_0x00c1:
            j$.util.concurrent.c[] r6 = r1.f5129c
            if (r6 == 0) goto L_0x016a
            int r7 = r6.length
            if (r7 <= 0) goto L_0x016a
            int r0 = r7 + -1
            r0 = r0 & r14
            r0 = r6[r0]
            if (r0 != 0) goto L_0x0108
            int r0 = r1.cellsBusy
            if (r0 != 0) goto L_0x0106
            j$.util.concurrent.c r6 = new j$.util.concurrent.c
            r6.<init>(r8)
            int r0 = r1.cellsBusy
            if (r0 != 0) goto L_0x0106
            j$.sun.misc.a r0 = f5119h
            long r2 = f5123l
            r4 = 0
            r5 = 1
            boolean r0 = r0.c(r1, r2, r4, r5)
            if (r0 == 0) goto L_0x0106
            j$.util.concurrent.c[] r0 = r1.f5129c     // Catch:{ all -> 0x00fa }
            if (r0 == 0) goto L_0x00fc
            int r2 = r0.length     // Catch:{ all -> 0x00fa }
            if (r2 <= 0) goto L_0x00fc
            int r2 = r2 + -1
            r2 = r2 & r14
            r3 = r0[r2]     // Catch:{ all -> 0x00fa }
            if (r3 != 0) goto L_0x00fc
            r0[r2] = r6     // Catch:{ all -> 0x00fa }
            r0 = 1
            goto L_0x00fd
        L_0x00fa:
            r0 = move-exception
            goto L_0x0103
        L_0x00fc:
            r0 = 0
        L_0x00fd:
            r1.cellsBusy = r10
            if (r0 == 0) goto L_0x00c1
            goto L_0x01aa
        L_0x0103:
            r1.cellsBusy = r10
            throw r0
        L_0x0106:
            r15 = 0
            goto L_0x0155
        L_0x0108:
            if (r11 != 0) goto L_0x010c
            r11 = 1
            goto L_0x0155
        L_0x010c:
            j$.sun.misc.a r16 = f5119h
            long r18 = f5124m
            long r2 = r0.value
            long r22 = r2 + r8
            r17 = r0
            r20 = r2
            boolean r0 = r16.d(r17, r18, r20, r22)
            if (r0 == 0) goto L_0x0120
            goto L_0x01aa
        L_0x0120:
            j$.util.concurrent.c[] r0 = r1.f5129c
            if (r0 != r6) goto L_0x0106
            int r0 = f5118g
            if (r7 < r0) goto L_0x0129
            goto L_0x0106
        L_0x0129:
            if (r15 != 0) goto L_0x012d
            r15 = 1
            goto L_0x0155
        L_0x012d:
            int r0 = r1.cellsBusy
            if (r0 != 0) goto L_0x0155
            long r2 = f5123l
            r4 = 0
            r5 = 1
            r0 = r16
            boolean r0 = r0.c(r1, r2, r4, r5)
            if (r0 == 0) goto L_0x0155
            j$.util.concurrent.c[] r0 = r1.f5129c     // Catch:{ all -> 0x014c }
            if (r0 != r6) goto L_0x014e
            int r0 = r7 << 1
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r6, r0)     // Catch:{ all -> 0x014c }
            j$.util.concurrent.c[] r0 = (j$.util.concurrent.c[]) r0     // Catch:{ all -> 0x014c }
            r1.f5129c = r0     // Catch:{ all -> 0x014c }
            goto L_0x014e
        L_0x014c:
            r0 = move-exception
            goto L_0x0152
        L_0x014e:
            r1.cellsBusy = r10
            goto L_0x00c0
        L_0x0152:
            r1.cellsBusy = r10
            throw r0
        L_0x0155:
            int r0 = r14 << 13
            r0 = r0 ^ r14
            int r2 = r0 >>> 17
            r0 = r0 ^ r2
            int r2 = r0 << 5
            r0 = r0 ^ r2
            j$.util.concurrent.v r2 = j$.util.concurrent.ThreadLocalRandom.f5135f
            java.lang.Object r2 = r2.get()
            j$.util.concurrent.ThreadLocalRandom r2 = (j$.util.concurrent.ThreadLocalRandom) r2
            r2.f5138b = r0
            r14 = r0
            goto L_0x01ab
        L_0x016a:
            int r0 = r1.cellsBusy
            if (r0 != 0) goto L_0x019c
            j$.util.concurrent.c[] r0 = r1.f5129c
            if (r0 != r6) goto L_0x019c
            j$.sun.misc.a r0 = f5119h
            long r2 = f5123l
            r4 = 0
            r5 = 1
            boolean r0 = r0.c(r1, r2, r4, r5)
            if (r0 == 0) goto L_0x019c
            j$.util.concurrent.c[] r0 = r1.f5129c     // Catch:{ all -> 0x0191 }
            if (r0 != r6) goto L_0x0193
            j$.util.concurrent.c[] r0 = new j$.util.concurrent.c[r12]     // Catch:{ all -> 0x0191 }
            r2 = r14 & 1
            j$.util.concurrent.c r3 = new j$.util.concurrent.c     // Catch:{ all -> 0x0191 }
            r3.<init>(r8)     // Catch:{ all -> 0x0191 }
            r0[r2] = r3     // Catch:{ all -> 0x0191 }
            r1.f5129c = r0     // Catch:{ all -> 0x0191 }
            r0 = 1
            goto L_0x0194
        L_0x0191:
            r0 = move-exception
            goto L_0x0199
        L_0x0193:
            r0 = 0
        L_0x0194:
            r1.cellsBusy = r10
            if (r0 == 0) goto L_0x01ab
            goto L_0x01aa
        L_0x0199:
            r1.cellsBusy = r10
            throw r0
        L_0x019c:
            j$.sun.misc.a r0 = f5119h
            long r2 = f5122k
            long r4 = r1.baseCount
            long r6 = r4 + r8
            boolean r0 = r0.d(r1, r2, r4, r6)
            if (r0 == 0) goto L_0x01ab
        L_0x01aa:
            return
        L_0x01ab:
            r1 = r24
            goto L_0x00c1
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.a(long, int):void");
    }

    public final l[] d(l[] lVarArr, l lVar) {
        int i4;
        if (!(lVar instanceof g)) {
            return this.f5127a;
        }
        l[] lVarArr2 = ((g) lVar).f5145e;
        int numberOfLeadingZeros = Integer.numberOfLeadingZeros(lVarArr.length) | 32768;
        while (true) {
            if (lVarArr2 == this.f5128b && this.f5127a == lVarArr && (i4 = this.sizeCtl) < 0 && (i4 >>> 16) == numberOfLeadingZeros && i4 != numberOfLeadingZeros + 1 && i4 != 65535 + numberOfLeadingZeros && this.transferIndex > 0) {
                if (f5119h.c(this, f5120i, i4, i4 + 1)) {
                    m(lVarArr, lVarArr2);
                    break;
                }
            }
        }
        return lVarArr2;
    }

    public final void o(int i4) {
        int length;
        int l4 = i4 >= 536870912 ? 1073741824 : l(i4 + (i4 >>> 1) + 1);
        while (true) {
            int i5 = this.sizeCtl;
            if (i5 >= 0) {
                l[] lVarArr = this.f5127a;
                if (lVarArr != null && (length = lVarArr.length) != 0) {
                    if (l4 <= i5 || length >= 1073741824) {
                        break;
                    } else if (lVarArr == this.f5127a) {
                        if (f5119h.c(this, f5120i, i5, ((Integer.numberOfLeadingZeros(length) | 32768) << 16) + 2)) {
                            m(lVarArr, (l[]) null);
                        }
                    }
                } else {
                    int i6 = i5 > l4 ? i5 : l4;
                    if (f5119h.c(this, f5120i, i5, -1)) {
                        try {
                            if (this.f5127a == lVarArr) {
                                this.f5127a = new l[i6];
                                i5 = i6 - (i6 >>> 2);
                            }
                            this.sizeCtl = i5;
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            this.sizeCtl = i5;
                            throw th2;
                        }
                    }
                }
            } else {
                break;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: j$.util.concurrent.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: j$.util.concurrent.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: j$.util.concurrent.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: j$.util.concurrent.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: j$.util.concurrent.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v11, resolved type: j$.util.concurrent.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v12, resolved type: j$.util.concurrent.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: j$.util.concurrent.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: j$.util.concurrent.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: j$.util.concurrent.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: j$.util.concurrent.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: j$.util.concurrent.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v13, resolved type: j$.util.concurrent.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v14, resolved type: j$.util.concurrent.l} */
    /* JADX WARNING: type inference failed for: r10v10, types: [j$.util.concurrent.l] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m(j$.util.concurrent.l[] r31, j$.util.concurrent.l[] r32) {
        /*
            r30 = this;
            r1 = r30
            r6 = r31
            int r7 = r6.length
            int r0 = f5118g
            r8 = 1
            if (r0 <= r8) goto L_0x000e
            int r2 = r7 >>> 3
            int r2 = r2 / r0
            goto L_0x000f
        L_0x000e:
            r2 = r7
        L_0x000f:
            r9 = 16
            if (r2 >= r9) goto L_0x0016
            r10 = 16
            goto L_0x0017
        L_0x0016:
            r10 = r2
        L_0x0017:
            if (r32 != 0) goto L_0x0029
            int r0 = r7 << 1
            j$.util.concurrent.l[] r0 = new j$.util.concurrent.l[r0]     // Catch:{ all -> 0x0023 }
            r1.f5128b = r0
            r1.transferIndex = r7
            r11 = r0
            goto L_0x002b
        L_0x0023:
            r0 = 2147483647(0x7fffffff, float:NaN)
            r1.sizeCtl = r0
            return
        L_0x0029:
            r11 = r32
        L_0x002b:
            int r12 = r11.length
            j$.util.concurrent.g r13 = new j$.util.concurrent.g
            r13.<init>(r11)
            r0 = 0
            r2 = 0
            r15 = 1
            r16 = 0
        L_0x0036:
            r3 = -1
            if (r15 == 0) goto L_0x007a
            int r0 = r0 + -1
            if (r0 >= r2) goto L_0x003f
            if (r16 == 0) goto L_0x0044
        L_0x003f:
            r18 = r0
            r17 = r2
            goto L_0x0075
        L_0x0044:
            int r4 = r1.transferIndex
            if (r4 > 0) goto L_0x004b
            r0 = -1
        L_0x0049:
            r15 = 0
            goto L_0x0036
        L_0x004b:
            r3 = r0
            j$.sun.misc.a r0 = f5119h
            r5 = r2
            r17 = r3
            long r2 = f5121j
            if (r4 <= r10) goto L_0x0060
            int r18 = r4 - r10
            r29 = r17
            r17 = r5
            r5 = r18
            r18 = r29
            goto L_0x0065
        L_0x0060:
            r18 = r17
            r17 = r5
            r5 = 0
        L_0x0065:
            boolean r0 = r0.c(r1, r2, r4, r5)
            r2 = r5
            if (r0 == 0) goto L_0x0070
            int r4 = r4 + -1
            r0 = r4
            goto L_0x0049
        L_0x0070:
            r2 = r17
            r0 = r18
            goto L_0x0036
        L_0x0075:
            r2 = r17
            r0 = r18
            goto L_0x0049
        L_0x007a:
            r17 = r2
            r2 = 0
            if (r0 < 0) goto L_0x0085
            if (r0 >= r7) goto L_0x0085
            int r4 = r0 + r7
            if (r4 < r12) goto L_0x008f
        L_0x0085:
            r20 = r7
            r21 = r10
            r18 = 1
            r19 = 16
            goto L_0x019b
        L_0x008f:
            j$.util.concurrent.l r5 = k(r6, r0)
            if (r5 != 0) goto L_0x00a4
            boolean r2 = b(r6, r0, r13)
            r15 = r2
            r20 = r7
            r21 = r10
            r18 = 1
        L_0x00a0:
            r19 = 16
            goto L_0x01ce
        L_0x00a4:
            r18 = 1
            int r8 = r5.f5152a
            if (r8 != r3) goto L_0x00b0
            r20 = r7
            r21 = r10
            r15 = 1
            goto L_0x00a0
        L_0x00b0:
            monitor-enter(r5)
            j$.util.concurrent.l r3 = k(r6, r0)     // Catch:{ all -> 0x00ce }
            if (r3 != r5) goto L_0x0191
            if (r8 < 0) goto L_0x0110
            r3 = r8 & r7
            j$.util.concurrent.l r8 = r5.f5155d     // Catch:{ all -> 0x00ce }
            r15 = r5
        L_0x00be:
            if (r8 == 0) goto L_0x00d1
            r19 = 16
            int r9 = r8.f5152a     // Catch:{ all -> 0x00ce }
            r9 = r9 & r7
            if (r9 == r3) goto L_0x00c9
            r15 = r8
            r3 = r9
        L_0x00c9:
            j$.util.concurrent.l r8 = r8.f5155d     // Catch:{ all -> 0x00ce }
            r9 = 16
            goto L_0x00be
        L_0x00ce:
            r0 = move-exception
            goto L_0x0199
        L_0x00d1:
            r19 = 16
            if (r3 != 0) goto L_0x00d8
            r3 = r2
            r2 = r15
            goto L_0x00d9
        L_0x00d8:
            r3 = r15
        L_0x00d9:
            r8 = r5
        L_0x00da:
            if (r8 == r15) goto L_0x0100
            int r9 = r8.f5152a     // Catch:{ all -> 0x00ce }
            java.lang.Object r14 = r8.f5153b     // Catch:{ all -> 0x00ce }
            r20 = r7
            java.lang.Object r7 = r8.f5154c     // Catch:{ all -> 0x00ce }
            r21 = r9 & r20
            if (r21 != 0) goto L_0x00f1
            r21 = r10
            j$.util.concurrent.l r10 = new j$.util.concurrent.l     // Catch:{ all -> 0x00ce }
            r10.<init>(r9, r14, r7, r2)     // Catch:{ all -> 0x00ce }
            r2 = r10
            goto L_0x00f9
        L_0x00f1:
            r21 = r10
            j$.util.concurrent.l r10 = new j$.util.concurrent.l     // Catch:{ all -> 0x00ce }
            r10.<init>(r9, r14, r7, r3)     // Catch:{ all -> 0x00ce }
            r3 = r10
        L_0x00f9:
            j$.util.concurrent.l r8 = r8.f5155d     // Catch:{ all -> 0x00ce }
            r7 = r20
            r10 = r21
            goto L_0x00da
        L_0x0100:
            r20 = r7
            r21 = r10
            h(r11, r0, r2)     // Catch:{ all -> 0x00ce }
            h(r11, r4, r3)     // Catch:{ all -> 0x00ce }
            h(r6, r0, r13)     // Catch:{ all -> 0x00ce }
        L_0x010d:
            r15 = 1
            goto L_0x0197
        L_0x0110:
            r20 = r7
            r21 = r10
            r19 = 16
            boolean r3 = r5 instanceof j$.util.concurrent.q     // Catch:{ all -> 0x00ce }
            if (r3 == 0) goto L_0x0197
            r3 = r5
            j$.util.concurrent.q r3 = (j$.util.concurrent.q) r3     // Catch:{ all -> 0x00ce }
            j$.util.concurrent.r r7 = r3.f5171f     // Catch:{ all -> 0x00ce }
            r8 = r2
            r9 = r8
            r10 = r7
            r14 = 0
            r15 = 0
            r7 = r9
        L_0x0125:
            if (r10 == 0) goto L_0x0160
            r28 = r3
            int r3 = r10.f5152a     // Catch:{ all -> 0x00ce }
            j$.util.concurrent.r r22 = new j$.util.concurrent.r     // Catch:{ all -> 0x00ce }
            r23 = r3
            java.lang.Object r3 = r10.f5153b     // Catch:{ all -> 0x00ce }
            r24 = r3
            java.lang.Object r3 = r10.f5154c     // Catch:{ all -> 0x00ce }
            r26 = 0
            r27 = 0
            r25 = r3
            r22.<init>(r23, r24, r25, r26, r27)     // Catch:{ all -> 0x00ce }
            r3 = r22
            r22 = r23 & r20
            if (r22 != 0) goto L_0x0150
            r3.f5176h = r9     // Catch:{ all -> 0x00ce }
            if (r9 != 0) goto L_0x014a
            r2 = r3
            goto L_0x014c
        L_0x014a:
            r9.f5155d = r3     // Catch:{ all -> 0x00ce }
        L_0x014c:
            int r14 = r14 + 1
            r9 = r3
            goto L_0x015b
        L_0x0150:
            r3.f5176h = r8     // Catch:{ all -> 0x00ce }
            if (r8 != 0) goto L_0x0156
            r7 = r3
            goto L_0x0158
        L_0x0156:
            r8.f5155d = r3     // Catch:{ all -> 0x00ce }
        L_0x0158:
            int r15 = r15 + 1
            r8 = r3
        L_0x015b:
            j$.util.concurrent.l r10 = r10.f5155d     // Catch:{ all -> 0x00ce }
            r3 = r28
            goto L_0x0125
        L_0x0160:
            r28 = r3
            r3 = 6
            if (r14 > r3) goto L_0x016a
            j$.util.concurrent.l r2 = p(r2)     // Catch:{ all -> 0x00ce }
            goto L_0x0175
        L_0x016a:
            if (r15 == 0) goto L_0x0173
            j$.util.concurrent.q r8 = new j$.util.concurrent.q     // Catch:{ all -> 0x00ce }
            r8.<init>(r2)     // Catch:{ all -> 0x00ce }
            r2 = r8
            goto L_0x0175
        L_0x0173:
            r2 = r28
        L_0x0175:
            if (r15 > r3) goto L_0x017c
            j$.util.concurrent.l r3 = p(r7)     // Catch:{ all -> 0x00ce }
            goto L_0x0186
        L_0x017c:
            if (r14 == 0) goto L_0x0184
            j$.util.concurrent.q r3 = new j$.util.concurrent.q     // Catch:{ all -> 0x00ce }
            r3.<init>(r7)     // Catch:{ all -> 0x00ce }
            goto L_0x0186
        L_0x0184:
            r3 = r28
        L_0x0186:
            h(r11, r0, r2)     // Catch:{ all -> 0x00ce }
            h(r11, r4, r3)     // Catch:{ all -> 0x00ce }
            h(r6, r0, r13)     // Catch:{ all -> 0x00ce }
            goto L_0x010d
        L_0x0191:
            r20 = r7
            r21 = r10
            r19 = 16
        L_0x0197:
            monitor-exit(r5)     // Catch:{ all -> 0x00ce }
            goto L_0x01ce
        L_0x0199:
            monitor-exit(r5)     // Catch:{ all -> 0x00ce }
            throw r0
        L_0x019b:
            if (r16 == 0) goto L_0x01a9
            r1.f5128b = r2
            r1.f5127a = r11
            int r0 = r20 << 1
            int r2 = r20 >>> 1
            int r0 = r0 - r2
            r1.sizeCtl = r0
            return
        L_0x01a9:
            r14 = r0
            j$.sun.misc.a r0 = f5119h
            long r2 = f5120i
            int r4 = r1.sizeCtl
            int r5 = r4 + -1
            boolean r0 = r0.c(r1, r2, r4, r5)
            if (r0 == 0) goto L_0x01cd
            int r4 = r4 + -2
            int r0 = java.lang.Integer.numberOfLeadingZeros(r20)
            r1 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 | r1
            int r0 = r0 << 16
            if (r4 == r0) goto L_0x01c7
            return
        L_0x01c7:
            r0 = r20
            r15 = 1
            r16 = 1
            goto L_0x01ce
        L_0x01cd:
            r0 = r14
        L_0x01ce:
            r1 = r30
            r2 = r17
            r7 = r20
            r10 = r21
            r8 = 1
            r9 = 16
            goto L_0x0036
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.m(j$.util.concurrent.l[], j$.util.concurrent.l[]):void");
    }

    public final long j() {
        c[] cVarArr = this.f5129c;
        long j4 = this.baseCount;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                if (cVar != null) {
                    j4 += cVar.value;
                }
            }
        }
        return j4;
    }

    public final void n(l[] lVarArr, int i4) {
        int length = lVarArr.length;
        if (length < 64) {
            o(length << 1);
            return;
        }
        l k4 = k(lVarArr, i4);
        if (k4 != null && k4.f5152a >= 0) {
            synchronized (k4) {
                try {
                    if (k(lVarArr, i4) == k4) {
                        r rVar = null;
                        r rVar2 = null;
                        l lVar = k4;
                        while (lVar != null) {
                            th = new r(lVar.f5152a, lVar.f5153b, lVar.f5154c, (l) null, (r) null);
                            th.f5176h = rVar2;
                            if (rVar2 != null) {
                                rVar2.f5155d = th;
                            }
                            lVar = lVar.f5155d;
                            rVar2 = th;
                        }
                        h(lVarArr, i4, new q(rVar));
                    }
                } finally {
                    r rVar3 = th;
                }
            }
        }
    }

    public static l p(r rVar) {
        l lVar = null;
        l lVar2 = null;
        for (l lVar3 = rVar; lVar3 != null; lVar3 = lVar3.f5155d) {
            l lVar4 = new l(lVar3.f5152a, lVar3.f5153b, lVar3.f5154c);
            if (lVar2 == null) {
                lVar = lVar4;
            } else {
                lVar2.f5155d = lVar4;
            }
            lVar2 = lVar4;
        }
        return lVar;
    }
}
