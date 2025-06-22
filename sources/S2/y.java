package S2;

import R2.p;
import d3.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import l3.e;

abstract class y extends x {

    public static final class a implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Iterable f8251a;

        public a(Iterable iterable) {
            this.f8251a = iterable;
        }

        public Iterator iterator() {
            return this.f8251a.iterator();
        }
    }

    static final class b extends n implements l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f8252a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(int i4) {
            super(1);
            this.f8252a = i4;
        }

        public final Object a(int i4) {
            throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + this.f8252a + '.');
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public static e A(Iterable iterable) {
        m.e(iterable, "<this>");
        return new a(iterable);
    }

    public static boolean B(Iterable iterable, Object obj) {
        m.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        if (J(iterable, obj) >= 0) {
            return true;
        }
        return false;
    }

    public static Object C(Iterable iterable, int i4) {
        m.e(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).get(i4);
        }
        return D(iterable, i4, new b(i4));
    }

    public static final Object D(Iterable iterable, int i4, l lVar) {
        m.e(iterable, "<this>");
        m.e(lVar, "defaultValue");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (i4 < 0 || i4 >= list.size()) {
                return lVar.invoke(Integer.valueOf(i4));
            }
            return list.get(i4);
        } else if (i4 < 0) {
            return lVar.invoke(Integer.valueOf(i4));
        } else {
            int i5 = 0;
            for (Object next : iterable) {
                int i6 = i5 + 1;
                if (i4 == i5) {
                    return next;
                }
                i5 = i6;
            }
            return lVar.invoke(Integer.valueOf(i4));
        }
    }

    public static List E(Iterable iterable) {
        m.e(iterable, "<this>");
        return (List) F(iterable, new ArrayList());
    }

    public static final Collection F(Iterable iterable, Collection collection) {
        m.e(iterable, "<this>");
        m.e(collection, "destination");
        for (Object next : iterable) {
            if (next != null) {
                collection.add(next);
            }
        }
        return collection;
    }

    public static Object G(Iterable iterable) {
        m.e(iterable, "<this>");
        if (iterable instanceof List) {
            return H((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static Object H(List list) {
        m.e(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static Object I(List list) {
        m.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final int J(Iterable iterable, Object obj) {
        m.e(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(obj);
        }
        int i4 = 0;
        for (Object next : iterable) {
            if (i4 < 0) {
                C1603q.o();
            }
            if (m.a(obj, next)) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    public static int K(List list, Object obj) {
        m.e(list, "<this>");
        return list.indexOf(obj);
    }

    public static final Appendable L(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, l lVar) {
        m.e(iterable, "<this>");
        m.e(appendable, "buffer");
        m.e(charSequence, "separator");
        m.e(charSequence2, "prefix");
        m.e(charSequence3, "postfix");
        m.e(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i5 = 0;
        for (Object next : iterable) {
            i5++;
            if (i5 > 1) {
                appendable.append(charSequence);
            }
            if (i4 >= 0 && i5 > i4) {
                break;
            }
            m3.m.a(appendable, next, lVar);
        }
        if (i4 >= 0 && i5 > i4) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static /* synthetic */ Appendable M(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, l lVar, int i5, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i6;
        CharSequence charSequence7;
        l lVar2;
        if ((i5 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i5 & 4) != 0) {
            charSequence6 = charSequence8;
        } else {
            charSequence6 = charSequence2;
        }
        if ((i5 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i5 & 16) != 0) {
            i6 = -1;
        } else {
            i6 = i4;
        }
        if ((i5 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i5 & 64) != 0) {
            lVar2 = null;
        } else {
            lVar2 = lVar;
        }
        return L(iterable, appendable, charSequence5, charSequence6, charSequence8, i6, charSequence7, lVar2);
    }

    public static final String N(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, l lVar) {
        m.e(iterable, "<this>");
        m.e(charSequence, "separator");
        m.e(charSequence2, "prefix");
        m.e(charSequence3, "postfix");
        m.e(charSequence4, "truncated");
        String sb = ((StringBuilder) L(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i4, charSequence4, lVar)).toString();
        m.d(sb, "toString(...)");
        return sb;
    }

    public static /* synthetic */ String O(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, l lVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i5 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i5 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i5 & 8) != 0) {
            i4 = -1;
        }
        if ((i5 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i5 & 32) != 0) {
            lVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        l lVar2 = lVar;
        int i6 = i4;
        CharSequence charSequence6 = charSequence2;
        return N(iterable, charSequence, charSequence6, charSequence3, i6, charSequence5, lVar2);
    }

    public static Object P(List list) {
        m.e(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(C1603q.j(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static Comparable Q(Iterable iterable) {
        m.e(iterable, "<this>");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) < 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static Comparable R(Iterable iterable) {
        m.e(iterable, "<this>");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) > 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static List S(Collection collection, Iterable iterable) {
        m.e(collection, "<this>");
        m.e(iterable, "elements");
        if (iterable instanceof Collection) {
            Collection collection2 = (Collection) iterable;
            ArrayList arrayList = new ArrayList(collection.size() + collection2.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        v.u(arrayList2, iterable);
        return arrayList2;
    }

    public static Object T(Iterable iterable) {
        m.e(iterable, "<this>");
        if (iterable instanceof List) {
            return U((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (!it.hasNext()) {
                return next;
            }
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final Object U(List list) {
        m.e(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        } else if (size == 1) {
            return list.get(0);
        } else {
            throw new IllegalArgumentException("List has more than one element.");
        }
    }

    public static List V(Iterable iterable) {
        m.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return Z(iterable);
            }
            Object[] array = collection.toArray(new Comparable[0]);
            C1597k.l((Comparable[]) array);
            return C1597k.c(array);
        }
        List a02 = a0(iterable);
        u.s(a02);
        return a02;
    }

    public static List W(Iterable iterable, Comparator comparator) {
        m.e(iterable, "<this>");
        m.e(comparator, "comparator");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return Z(iterable);
            }
            Object[] array = collection.toArray(new Object[0]);
            C1597k.m(array, comparator);
            return C1597k.c(array);
        }
        List a02 = a0(iterable);
        u.t(a02, comparator);
        return a02;
    }

    public static final Collection X(Iterable iterable, Collection collection) {
        m.e(iterable, "<this>");
        m.e(collection, "destination");
        for (Object add : iterable) {
            collection.add(add);
        }
        return collection;
    }

    public static int[] Y(Collection collection) {
        m.e(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator it = collection.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            iArr[i4] = ((Number) it.next()).intValue();
            i4++;
        }
        return iArr;
    }

    public static List Z(Iterable iterable) {
        Object obj;
        m.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return C1603q.m(a0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return C1603q.h();
        }
        if (size != 1) {
            return b0(collection);
        }
        if (iterable instanceof List) {
            obj = ((List) iterable).get(0);
        } else {
            obj = iterable.iterator().next();
        }
        return C1602p.e(obj);
    }

    public static final List a0(Iterable iterable) {
        m.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return b0((Collection) iterable);
        }
        return (List) X(iterable, new ArrayList());
    }

    public static List b0(Collection collection) {
        m.e(collection, "<this>");
        return new ArrayList(collection);
    }

    public static Set c0(Iterable iterable) {
        m.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        return (Set) X(iterable, new LinkedHashSet());
    }

    public static Set d0(Iterable iterable) {
        Object obj;
        m.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return P.f((Set) X(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return P.d();
        }
        if (size != 1) {
            return (Set) X(iterable, new LinkedHashSet(J.d(collection.size())));
        }
        if (iterable instanceof List) {
            obj = ((List) iterable).get(0);
        } else {
            obj = iterable.iterator().next();
        }
        return O.c(obj);
    }

    public static List e0(Iterable iterable, Iterable iterable2) {
        m.e(iterable, "<this>");
        m.e(iterable2, "other");
        Iterator it = iterable.iterator();
        Iterator it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(r.p(iterable, 10), r.p(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(p.a(it.next(), it2.next()));
        }
        return arrayList;
    }
}
