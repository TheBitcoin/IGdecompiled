package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public abstract class D3 implements Y4 {
    protected static void g(Iterable iterable, List list) {
        C0684u4.e(iterable);
        if (iterable instanceof G4) {
            List A4 = ((G4) iterable).A();
            G4 g4 = (G4) list;
            int size = list.size();
            for (Object next : A4) {
                if (next == null) {
                    String str = "Element at index " + (g4.size() - size) + " is null.";
                    for (int size2 = g4.size() - 1; size2 >= size; size2--) {
                        g4.remove(size2);
                    }
                    throw new NullPointerException(str);
                } else if (next instanceof K3) {
                    g4.i((K3) next);
                } else if (next instanceof byte[]) {
                    g4.i(K3.m((byte[]) next));
                } else {
                    g4.add((String) next);
                }
            }
        } else if (iterable instanceof C0593j5) {
            list.addAll((Collection) iterable);
        } else {
            if (iterable instanceof Collection) {
                int size3 = ((Collection) iterable).size();
                if (list instanceof ArrayList) {
                    ((ArrayList) list).ensureCapacity(list.size() + size3);
                }
                if (list instanceof C0602k5) {
                    ((C0602k5) list).g(list.size() + size3);
                }
            }
            int size4 = list.size();
            if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
                for (Object next2 : iterable) {
                    if (next2 == null) {
                        h(list, size4);
                    }
                    list.add(next2);
                }
                return;
            }
            List list2 = (List) iterable;
            int size5 = list2.size();
            for (int i4 = 0; i4 < size5; i4++) {
                Object obj = list2.get(i4);
                if (obj == null) {
                    h(list, size4);
                }
                list.add(obj);
            }
        }
    }

    private static void h(List list, int i4) {
        String str = "Element at index " + (list.size() - i4) + " is null.";
        for (int size = list.size() - 1; size >= i4; size--) {
            list.remove(size);
        }
        throw new NullPointerException(str);
    }

    public abstract /* synthetic */ Object clone();

    public abstract D3 e(byte[] bArr, int i4, int i5);

    public abstract D3 f(byte[] bArr, int i4, int i5, C0556f4 f4Var);

    public final /* synthetic */ Y4 v(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    public final /* synthetic */ Y4 w(byte[] bArr, C0556f4 f4Var) {
        return f(bArr, 0, bArr.length, f4Var);
    }
}
