package j$.util.stream;

import j$.util.h0;
import j$.util.stream.IntStream;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.BaseStream;

/* renamed from: j$.util.stream.f  reason: case insensitive filesystem */
public final /* synthetic */ class C1169f implements BaseStream {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1174g f5500a;

    public /* synthetic */ C1169f(C1174g gVar) {
        this.f5500a = gVar;
    }

    public static /* synthetic */ BaseStream w(C1174g gVar) {
        if (gVar == null) {
            return null;
        }
        return gVar instanceof C1164e ? ((C1164e) gVar).f5495a : gVar instanceof C ? B.w((C) gVar) : gVar instanceof IntStream ? IntStream.Wrapper.convert((IntStream) gVar) : gVar instanceof C1195k0 ? C1190j0.w((C1195k0) gVar) : gVar instanceof Stream ? U2.w((Stream) gVar) : new C1169f(gVar);
    }

    public final /* synthetic */ void close() {
        this.f5500a.close();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        C1174g gVar = this.f5500a;
        if (obj instanceof C1169f) {
            obj = ((C1169f) obj).f5500a;
        }
        return gVar.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f5500a.hashCode();
    }

    public final /* synthetic */ boolean isParallel() {
        return this.f5500a.isParallel();
    }

    public final /* synthetic */ Iterator iterator() {
        return this.f5500a.iterator();
    }

    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return w(this.f5500a.onClose(runnable));
    }

    public final /* synthetic */ BaseStream parallel() {
        return w(this.f5500a.parallel());
    }

    public final /* synthetic */ BaseStream sequential() {
        return w(this.f5500a.sequential());
    }

    public final /* synthetic */ Spliterator spliterator() {
        return h0.a(this.f5500a.spliterator());
    }

    public final /* synthetic */ BaseStream unordered() {
        return w(this.f5500a.unordered());
    }
}
