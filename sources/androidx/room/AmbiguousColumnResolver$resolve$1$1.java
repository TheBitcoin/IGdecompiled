package androidx.room;

import R2.s;
import androidx.room.AmbiguousColumnResolver;
import d3.q;
import j3.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class AmbiguousColumnResolver$resolve$1$1 extends n implements q {
    final /* synthetic */ String[] $mapping;
    final /* synthetic */ int $mappingIndex;
    final /* synthetic */ List<List<AmbiguousColumnResolver.Match>> $mappingMatches;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AmbiguousColumnResolver$resolve$1$1(String[] strArr, List<? extends List<AmbiguousColumnResolver.Match>> list, int i4) {
        super(3);
        this.$mapping = strArr;
        this.$mappingMatches = list;
        this.$mappingIndex = i4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (List<AmbiguousColumnResolver.ResultColumn>) (List) obj3);
        return s.f8222a;
    }

    public final void invoke(int i4, int i5, List<AmbiguousColumnResolver.ResultColumn> list) {
        Object obj;
        m.e(list, "resultColumnsSublist");
        String[] strArr = this.$mapping;
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        int i6 = 0;
        while (i6 < length) {
            String str = strArr[i6];
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (m.a(str, ((AmbiguousColumnResolver.ResultColumn) obj).component1())) {
                    break;
                }
            }
            AmbiguousColumnResolver.ResultColumn resultColumn = (AmbiguousColumnResolver.ResultColumn) obj;
            if (resultColumn != null) {
                arrayList.add(Integer.valueOf(resultColumn.getIndex()));
                i6++;
            } else {
                return;
            }
        }
        this.$mappingMatches.get(this.$mappingIndex).add(new AmbiguousColumnResolver.Match(new d(i4, i5 - 1), arrayList));
    }
}
