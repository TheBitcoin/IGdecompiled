package j$.util.stream;

import java.util.HashSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/* renamed from: j$.util.stream.m  reason: case insensitive filesystem */
public final class C1203m extends C1167e2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5543b;

    /* renamed from: c  reason: collision with root package name */
    public Object f5544c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1203m(C1144a aVar, C1187i2 i2Var, int i4) {
        super(i2Var);
        this.f5543b = i4;
        this.f5544c = aVar;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1203m(C1187i2 i2Var) {
        super(i2Var);
        this.f5543b = 0;
    }

    public void j() {
        switch (this.f5543b) {
            case 0:
                this.f5544c = null;
                this.f5498a.j();
                return;
            default:
                super.j();
                return;
        }
    }

    public void k(long j4) {
        switch (this.f5543b) {
            case 0:
                this.f5544c = new HashSet();
                this.f5498a.k(-1);
                return;
            case 2:
                this.f5498a.k(-1);
                return;
            default:
                super.k(j4);
                return;
        }
    }

    public final void accept(Object obj) {
        switch (this.f5543b) {
            case 0:
                if (!((HashSet) this.f5544c).contains(obj)) {
                    ((HashSet) this.f5544c).add(obj);
                    this.f5498a.accept(obj);
                    return;
                }
                return;
            case 1:
                ((Consumer) ((r) this.f5544c).f5577n).accept(obj);
                this.f5498a.accept(obj);
                return;
            case 2:
                if (((Predicate) ((r) this.f5544c).f5577n).test(obj)) {
                    this.f5498a.accept(obj);
                    return;
                }
                return;
            case 3:
                this.f5498a.accept(((Function) ((r) this.f5544c).f5577n).apply(obj));
                return;
            case 4:
                this.f5498a.accept(((ToIntFunction) ((U) this.f5544c).f5408n).applyAsInt(obj));
                return;
            case 5:
                this.f5498a.accept(((ToLongFunction) ((C1165e0) this.f5544c).f5497n).applyAsLong(obj));
                return;
            default:
                this.f5498a.accept(((ToDoubleFunction) ((C1242w) this.f5544c).f5623n).applyAsDouble(obj));
                return;
        }
    }
}
