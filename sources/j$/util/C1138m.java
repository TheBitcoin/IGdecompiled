package j$.util;

import j$.time.format.r;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

/* renamed from: j$.util.m  reason: case insensitive filesystem */
public final class C1138m implements Iterator, C1263y {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5234a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final Iterator f5235b;

    public C1138m(C1139n nVar) {
        this.f5235b = nVar.f5239a.iterator();
    }

    public final void forEachRemaining(Consumer consumer) {
        switch (this.f5234a) {
            case 0:
                C1127b.t(this.f5235b, consumer);
                return;
            default:
                C1127b.t(this.f5235b, new r(1, consumer));
                return;
        }
    }

    public C1138m(C1143s sVar) {
        this.f5235b = sVar.f5239a.iterator();
    }

    public final boolean hasNext() {
        switch (this.f5234a) {
            case 0:
                return this.f5235b.hasNext();
            default:
                return this.f5235b.hasNext();
        }
    }

    public final Object next() {
        switch (this.f5234a) {
            case 0:
                return this.f5235b.next();
            default:
                return new C1142q((Map.Entry) this.f5235b.next());
        }
    }

    public final void remove() {
        switch (this.f5234a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
