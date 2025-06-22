package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class E3 extends AbstractList implements C4 {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1455a;

    E3(boolean z4) {
        this.f1455a = z4;
    }

    public final void B() {
        if (this.f1455a) {
            this.f1455a = false;
        }
    }

    public boolean addAll(Collection collection) {
        c();
        return super.addAll(collection);
    }

    public final boolean b() {
        return this.f1455a;
    }

    /* access modifiers changed from: protected */
    public final void c() {
        if (!this.f1455a) {
            throw new UnsupportedOperationException();
        }
    }

    public void clear() {
        c();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i4 = 0; i4 < size; i4++) {
            if (!get(i4).equals(list.get(i4))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i4 = 1;
        for (int i5 = 0; i5 < size; i5++) {
            i4 = (i4 * 31) + get(i5).hashCode();
        }
        return i4;
    }

    public abstract Object remove(int i4);

    public boolean remove(Object obj) {
        c();
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    public boolean removeAll(Collection collection) {
        c();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        c();
        return super.retainAll(collection);
    }

    public boolean addAll(int i4, Collection collection) {
        c();
        return super.addAll(i4, collection);
    }
}
