package j$.time.format;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.l;
import j$.time.g;
import j$.time.j;
import j$.time.temporal.n;
import j$.time.temporal.r;
import j$.time.temporal.s;
import j$.util.A;
import j$.util.C1127b;
import j$.util.C1261w;
import j$.util.C1262x;
import j$.util.Objects;
import j$.util.function.Function$CC;
import j$.util.stream.Collectors;
import j$.util.x0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

public final /* synthetic */ class a implements IntFunction, BinaryOperator, Supplier, BiConsumer, Function, DoubleBinaryOperator, ObjDoubleConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4930a;

    public /* synthetic */ a(int i4) {
        this.f4930a = i4;
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.f4930a) {
            case 12:
                return j$.com.android.tools.r8.a.b(this, biConsumer);
            case 17:
                return j$.com.android.tools.r8.a.b(this, biConsumer);
            case 22:
                return j$.com.android.tools.r8.a.b(this, biConsumer);
            case 23:
                return j$.com.android.tools.r8.a.b(this, biConsumer);
            case 24:
                return j$.com.android.tools.r8.a.b(this, biConsumer);
            default:
                return j$.com.android.tools.r8.a.b(this, biConsumer);
        }
    }

    public Object apply(Object obj) {
        switch (this.f4930a) {
            case 16:
                Set set = Collectors.f5263a;
                return obj;
            default:
                return ((x0) obj).toString();
        }
    }

    public double applyAsDouble(double d5, double d6) {
        return Math.min(d5, d6);
    }

    public /* synthetic */ Function compose(Function function) {
        switch (this.f4930a) {
            case 16:
                return Function$CC.$default$compose(this, function);
            default:
                return Function$CC.$default$compose(this, function);
        }
    }

    public Object apply(Object obj, Object obj2) {
        switch (this.f4930a) {
            case 9:
                Map map = (Map) obj;
                Set set = Collectors.f5263a;
                for (Map.Entry entry : ((Map) obj2).entrySet()) {
                    Object key = entry.getKey();
                    Object requireNonNull = Objects.requireNonNull(entry.getValue());
                    Object v4 = C1127b.v(map, key, requireNonNull);
                    if (v4 != null) {
                        throw new IllegalStateException(String.format("Duplicate key %s (attempted merging values %s and %s)", new Object[]{key, v4, requireNonNull}));
                    }
                }
                return map;
            case 15:
                List list = (List) obj;
                Set set2 = Collectors.f5263a;
                list.addAll((List) obj2);
                return list;
            default:
                x0 x0Var = (x0) obj;
                x0 x0Var2 = (x0) obj2;
                x0Var.getClass();
                Objects.requireNonNull(x0Var2);
                if (x0Var2.f5679d != null) {
                    x0Var2.b();
                    x0Var.a(x0Var2.f5679d[0]);
                }
                return x0Var;
        }
    }

    public Object a(n nVar) {
        switch (this.f4930a) {
            case 0:
                ZoneId zoneId = (ZoneId) nVar.p(r.f5032a);
                if (zoneId == null || (zoneId instanceof ZoneOffset)) {
                    return null;
                }
                return zoneId;
            case 1:
                return (ZoneId) nVar.p(r.f5032a);
            case 2:
                return (l) nVar.p(r.f5033b);
            case 3:
                return (s) nVar.p(r.f5034c);
            case 4:
                j$.time.temporal.a aVar = j$.time.temporal.a.OFFSET_SECONDS;
                if (nVar.f(aVar)) {
                    return ZoneOffset.J(nVar.k(aVar));
                }
                return null;
            case 5:
                ZoneId zoneId2 = (ZoneId) nVar.p(r.f5032a);
                return zoneId2 != null ? zoneId2 : (ZoneId) nVar.p(r.f5035d);
            case 6:
                j$.time.temporal.a aVar2 = j$.time.temporal.a.EPOCH_DAY;
                if (nVar.f(aVar2)) {
                    return g.L(nVar.t(aVar2));
                }
                return null;
            default:
                j$.time.temporal.a aVar3 = j$.time.temporal.a.NANO_OF_DAY;
                if (nVar.f(aVar3)) {
                    return j.G(nVar.t(aVar3));
                }
                return null;
        }
    }

    public String toString() {
        switch (this.f4930a) {
            case 1:
                return "ZoneId";
            case 2:
                return "Chronology";
            case 3:
                return "Precision";
            case 4:
                return "ZoneOffset";
            case 5:
                return "Zone";
            case 6:
                return "LocalDate";
            case 7:
                return "LocalTime";
            default:
                return super.toString();
        }
    }

    public Object get() {
        switch (this.f4930a) {
            case 10:
                return new C1261w();
            case 11:
                return new ArrayList();
            case 13:
                return new C1262x();
            case 14:
                return new A();
            case 20:
                return new HashMap();
            case 21:
                return new LinkedHashSet();
            default:
                return new double[4];
        }
    }

    public void accept(Object obj, double d5) {
        switch (this.f4930a) {
            case 27:
                double[] dArr = (double[]) obj;
                dArr[2] = dArr[2] + 1.0d;
                Collectors.a(dArr, d5);
                dArr[3] = dArr[3] + d5;
                return;
            default:
                ((C1261w) obj).accept(d5);
                return;
        }
    }

    public void accept(Object obj, Object obj2) {
        switch (this.f4930a) {
            case 12:
                ((List) obj).add(obj2);
                return;
            case 17:
                ((x0) obj).a((CharSequence) obj2);
                return;
            case 22:
                ((LinkedHashSet) obj).add(obj2);
                return;
            case 23:
                ((LinkedHashSet) obj).addAll((LinkedHashSet) obj2);
                return;
            case 24:
                double[] dArr = (double[]) obj;
                double[] dArr2 = (double[]) obj2;
                Collectors.a(dArr, dArr2[0]);
                Collectors.a(dArr, dArr2[1]);
                dArr[2] = dArr[2] + dArr2[2];
                return;
            default:
                double[] dArr3 = (double[]) obj;
                double[] dArr4 = (double[]) obj2;
                Collectors.a(dArr3, dArr4[0]);
                Collectors.a(dArr3, dArr4[1]);
                dArr3[2] = dArr3[2] + dArr4[2];
                dArr3[3] = dArr3[3] + dArr4[3];
                return;
        }
    }

    public Object apply(int i4) {
        return new Object[i4];
    }
}
