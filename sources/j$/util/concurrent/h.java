package j$.util.concurrent;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class h extends a implements Iterator, Enumeration {

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f5146k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(l[] lVarArr, int i4, int i5, ConcurrentHashMap concurrentHashMap, int i6) {
        super(lVarArr, i4, i5, concurrentHashMap);
        this.f5146k = i6;
    }

    public final Object next() {
        switch (this.f5146k) {
            case 0:
                l lVar = this.f5161b;
                if (lVar != null) {
                    this.f5141j = lVar;
                    a();
                    return lVar.f5153b;
                }
                throw new NoSuchElementException();
            default:
                l lVar2 = this.f5161b;
                if (lVar2 != null) {
                    Object obj = lVar2.f5154c;
                    this.f5141j = lVar2;
                    a();
                    return obj;
                }
                throw new NoSuchElementException();
        }
    }

    public final Object nextElement() {
        switch (this.f5146k) {
            case 0:
                return next();
            default:
                return next();
        }
    }
}
