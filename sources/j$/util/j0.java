package j$.util;

import j$.util.function.Consumer$CC;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public final class j0 implements Iterator, Consumer {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5225a = false;

    /* renamed from: b  reason: collision with root package name */
    public Object f5226b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ i0 f5227c;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public j0(i0 i0Var) {
        this.f5227c = i0Var;
    }

    public final void accept(Object obj) {
        this.f5225a = true;
        this.f5226b = obj;
    }

    public final boolean hasNext() {
        if (!this.f5225a) {
            this.f5227c.tryAdvance(this);
        }
        return this.f5225a;
    }

    public final Object next() {
        if (this.f5225a || hasNext()) {
            this.f5225a = false;
            return this.f5226b;
        }
        throw new NoSuchElementException();
    }
}
