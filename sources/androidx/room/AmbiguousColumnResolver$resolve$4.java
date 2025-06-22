package androidx.room;

import R2.s;
import androidx.room.AmbiguousColumnResolver;
import d3.l;
import java.util.List;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class AmbiguousColumnResolver$resolve$4 extends n implements l {
    final /* synthetic */ C $bestSolution;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AmbiguousColumnResolver$resolve$4(C c5) {
        super(1);
        this.$bestSolution = c5;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<AmbiguousColumnResolver.Match>) (List) obj);
        return s.f8222a;
    }

    public final void invoke(List<AmbiguousColumnResolver.Match> list) {
        m.e(list, "it");
        AmbiguousColumnResolver.Solution build = AmbiguousColumnResolver.Solution.Companion.build(list);
        if (build.compareTo((AmbiguousColumnResolver.Solution) this.$bestSolution.f20968a) < 0) {
            this.$bestSolution.f20968a = build;
        }
    }
}
