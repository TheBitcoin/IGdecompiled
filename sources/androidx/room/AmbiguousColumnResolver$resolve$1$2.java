package androidx.room;

import R2.s;
import androidx.room.AmbiguousColumnResolver;
import d3.l;
import j3.d;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class AmbiguousColumnResolver$resolve$1$2 extends n implements l {
    final /* synthetic */ int $mappingIndex;
    final /* synthetic */ List<List<AmbiguousColumnResolver.Match>> $mappingMatches;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AmbiguousColumnResolver$resolve$1$2(List<? extends List<AmbiguousColumnResolver.Match>> list, int i4) {
        super(1);
        this.$mappingMatches = list;
        this.$mappingIndex = i4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<Integer>) (List) obj);
        return s.f8222a;
    }

    public final void invoke(List<Integer> list) {
        m.e(list, "indices");
        Iterable iterable = list;
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            while (it.hasNext()) {
                int intValue2 = ((Number) it.next()).intValue();
                if (intValue > intValue2) {
                    intValue = intValue2;
                }
            }
            Iterator it2 = iterable.iterator();
            if (it2.hasNext()) {
                int intValue3 = ((Number) it2.next()).intValue();
                while (it2.hasNext()) {
                    int intValue4 = ((Number) it2.next()).intValue();
                    if (intValue3 < intValue4) {
                        intValue3 = intValue4;
                    }
                }
                this.$mappingMatches.get(this.$mappingIndex).add(new AmbiguousColumnResolver.Match(new d(intValue, intValue3), list));
                return;
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
    }
}
