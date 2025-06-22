package S2;

import d3.l;
import j3.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.m;

/* renamed from: S2.l  reason: case insensitive filesystem */
abstract class C1598l extends C1597k {
    public static final String A(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, l lVar) {
        m.e(objArr, "<this>");
        m.e(charSequence, "separator");
        m.e(charSequence2, "prefix");
        m.e(charSequence3, "postfix");
        m.e(charSequence4, "truncated");
        String sb = ((StringBuilder) y(objArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i4, charSequence4, lVar)).toString();
        m.d(sb, "toString(...)");
        return sb;
    }

    public static /* synthetic */ String B(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, l lVar, int i5, Object obj) {
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
        return z(bArr, charSequence, charSequence6, charSequence3, i6, charSequence5, lVar2);
    }

    public static /* synthetic */ String C(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, l lVar, int i5, Object obj) {
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
        return A(objArr, charSequence, charSequence6, charSequence3, i6, charSequence5, lVar2);
    }

    public static char D(char[] cArr) {
        m.e(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return cArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static Object E(Object[] objArr) {
        m.e(objArr, "<this>");
        if (objArr.length == 1) {
            return objArr[0];
        }
        return null;
    }

    public static final List F(Object[] objArr, int i4) {
        m.e(objArr, "<this>");
        if (i4 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i4 + " is less than zero.").toString());
        } else if (i4 == 0) {
            return C1603q.h();
        } else {
            int length = objArr.length;
            if (i4 >= length) {
                return I(objArr);
            }
            if (i4 == 1) {
                return C1602p.e(objArr[length - 1]);
            }
            ArrayList arrayList = new ArrayList(i4);
            for (int i5 = length - i4; i5 < length; i5++) {
                arrayList.add(objArr[i5]);
            }
            return arrayList;
        }
    }

    public static final Collection G(Object[] objArr, Collection collection) {
        m.e(objArr, "<this>");
        m.e(collection, "destination");
        for (Object add : objArr) {
            collection.add(add);
        }
        return collection;
    }

    public static List H(int[] iArr) {
        m.e(iArr, "<this>");
        int length = iArr.length;
        if (length == 0) {
            return C1603q.h();
        }
        if (length != 1) {
            return K(iArr);
        }
        return C1602p.e(Integer.valueOf(iArr[0]));
    }

    public static List I(Object[] objArr) {
        m.e(objArr, "<this>");
        int length = objArr.length;
        if (length == 0) {
            return C1603q.h();
        }
        if (length != 1) {
            return L(objArr);
        }
        return C1602p.e(objArr[0]);
    }

    public static List J(boolean[] zArr) {
        m.e(zArr, "<this>");
        int length = zArr.length;
        if (length == 0) {
            return C1603q.h();
        }
        if (length != 1) {
            return M(zArr);
        }
        return C1602p.e(Boolean.valueOf(zArr[0]));
    }

    public static final List K(int[] iArr) {
        m.e(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int valueOf : iArr) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        return arrayList;
    }

    public static final List L(Object[] objArr) {
        m.e(objArr, "<this>");
        return new ArrayList(C1603q.g(objArr));
    }

    public static final List M(boolean[] zArr) {
        m.e(zArr, "<this>");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean valueOf : zArr) {
            arrayList.add(Boolean.valueOf(valueOf));
        }
        return arrayList;
    }

    public static final Set N(Object[] objArr) {
        m.e(objArr, "<this>");
        int length = objArr.length;
        if (length == 0) {
            return P.d();
        }
        if (length != 1) {
            return (Set) G(objArr, new LinkedHashSet(J.d(objArr.length)));
        }
        return O.c(objArr[0]);
    }

    public static boolean n(int[] iArr, int i4) {
        m.e(iArr, "<this>");
        if (v(iArr, i4) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean o(Object[] objArr, Object obj) {
        m.e(objArr, "<this>");
        if (w(objArr, obj) >= 0) {
            return true;
        }
        return false;
    }

    public static List p(Object[] objArr, int i4) {
        m.e(objArr, "<this>");
        if (i4 >= 0) {
            return F(objArr, e.a(objArr.length - i4, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i4 + " is less than zero.").toString());
    }

    public static List q(Object[] objArr) {
        m.e(objArr, "<this>");
        return (List) r(objArr, new ArrayList());
    }

    public static final Collection r(Object[] objArr, Collection collection) {
        m.e(objArr, "<this>");
        m.e(collection, "destination");
        for (Object obj : objArr) {
            if (obj != null) {
                collection.add(obj);
            }
        }
        return collection;
    }

    public static int s(int[] iArr) {
        m.e(iArr, "<this>");
        if (iArr.length != 0) {
            return iArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int t(Object[] objArr) {
        m.e(objArr, "<this>");
        return objArr.length - 1;
    }

    public static Object u(Object[] objArr, int i4) {
        m.e(objArr, "<this>");
        if (i4 < 0 || i4 >= objArr.length) {
            return null;
        }
        return objArr[i4];
    }

    public static final int v(int[] iArr, int i4) {
        m.e(iArr, "<this>");
        int length = iArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (i4 == iArr[i5]) {
                return i5;
            }
        }
        return -1;
    }

    public static final int w(Object[] objArr, Object obj) {
        m.e(objArr, "<this>");
        int i4 = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i4 < length) {
                if (objArr[i4] == null) {
                    return i4;
                }
                i4++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i4 < length2) {
            if (m.a(obj, objArr[i4])) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    public static final Appendable x(byte[] bArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, l lVar) {
        m.e(bArr, "<this>");
        m.e(appendable, "buffer");
        m.e(charSequence, "separator");
        m.e(charSequence2, "prefix");
        m.e(charSequence3, "postfix");
        m.e(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i5 = 0;
        for (byte b5 : bArr) {
            i5++;
            if (i5 > 1) {
                appendable.append(charSequence);
            }
            if (i4 >= 0 && i5 > i4) {
                break;
            }
            if (lVar != null) {
                appendable.append((CharSequence) lVar.invoke(Byte.valueOf(b5)));
            } else {
                appendable.append(String.valueOf(b5));
            }
        }
        if (i4 >= 0 && i5 > i4) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final Appendable y(Object[] objArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, l lVar) {
        m.e(objArr, "<this>");
        m.e(appendable, "buffer");
        m.e(charSequence, "separator");
        m.e(charSequence2, "prefix");
        m.e(charSequence3, "postfix");
        m.e(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i5 = 0;
        for (Object obj : objArr) {
            i5++;
            if (i5 > 1) {
                appendable.append(charSequence);
            }
            if (i4 >= 0 && i5 > i4) {
                break;
            }
            m3.m.a(appendable, obj, lVar);
        }
        if (i4 >= 0 && i5 > i4) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final String z(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, l lVar) {
        m.e(bArr, "<this>");
        m.e(charSequence, "separator");
        m.e(charSequence2, "prefix");
        m.e(charSequence3, "postfix");
        m.e(charSequence4, "truncated");
        String sb = ((StringBuilder) x(bArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i4, charSequence4, lVar)).toString();
        m.d(sb, "toString(...)");
        return sb;
    }
}
