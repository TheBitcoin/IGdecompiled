package j$.util.concurrent;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class d extends a implements Iterator {
    public final Object next() {
        l lVar = this.f5161b;
        if (lVar != null) {
            Object obj = lVar.f5153b;
            Object obj2 = lVar.f5154c;
            this.f5141j = lVar;
            a();
            return new k(obj, obj2, this.f5140i);
        }
        throw new NoSuchElementException();
    }
}
