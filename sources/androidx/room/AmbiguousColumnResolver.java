package androidx.room;

import S2.C1601o;
import S2.E;
import S2.N;
import androidx.annotation.RestrictTo;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import d3.l;
import d3.q;
import j3.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class AmbiguousColumnResolver {
    public static final AmbiguousColumnResolver INSTANCE = new AmbiguousColumnResolver();

    private static final class Match {
        private final List<Integer> resultIndices;
        private final d resultRange;

        public Match(d dVar, List<Integer> list) {
            m.e(dVar, "resultRange");
            m.e(list, "resultIndices");
            this.resultRange = dVar;
            this.resultIndices = list;
        }

        public final List<Integer> getResultIndices() {
            return this.resultIndices;
        }

        public final d getResultRange() {
            return this.resultRange;
        }
    }

    private static final class ResultColumn {
        private final int index;
        private final String name;

        public ResultColumn(String str, int i4) {
            m.e(str, RewardPlus.NAME);
            this.name = str;
            this.index = i4;
        }

        public static /* synthetic */ ResultColumn copy$default(ResultColumn resultColumn, String str, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = resultColumn.name;
            }
            if ((i5 & 2) != 0) {
                i4 = resultColumn.index;
            }
            return resultColumn.copy(str, i4);
        }

        public final String component1() {
            return this.name;
        }

        public final int component2() {
            return this.index;
        }

        public final ResultColumn copy(String str, int i4) {
            m.e(str, RewardPlus.NAME);
            return new ResultColumn(str, i4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResultColumn)) {
                return false;
            }
            ResultColumn resultColumn = (ResultColumn) obj;
            return m.a(this.name, resultColumn.name) && this.index == resultColumn.index;
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.index;
        }

        public String toString() {
            return "ResultColumn(name=" + this.name + ", index=" + this.index + ')';
        }
    }

    private static final class Solution implements Comparable<Solution> {
        public static final Companion Companion = new Companion((C2103g) null);
        /* access modifiers changed from: private */
        public static final Solution NO_SOLUTION = new Solution(C1601o.h(), Integer.MAX_VALUE, Integer.MAX_VALUE);
        private final int coverageOffset;
        private final List<Match> matches;
        private final int overlaps;

        public static final class Companion {
            public /* synthetic */ Companion(C2103g gVar) {
                this();
            }

            public final Solution build(List<Match> list) {
                m.e(list, "matches");
                Iterable<Match> iterable = list;
                int i4 = 0;
                int i5 = 0;
                for (Match match : iterable) {
                    i5 += ((match.getResultRange().h() - match.getResultRange().c()) + 1) - match.getResultIndices().size();
                }
                Iterator it = iterable.iterator();
                if (it.hasNext()) {
                    int c5 = ((Match) it.next()).getResultRange().c();
                    while (it.hasNext()) {
                        int c6 = ((Match) it.next()).getResultRange().c();
                        if (c5 > c6) {
                            c5 = c6;
                        }
                    }
                    Iterator it2 = iterable.iterator();
                    if (it2.hasNext()) {
                        int h4 = ((Match) it2.next()).getResultRange().h();
                        while (it2.hasNext()) {
                            int h5 = ((Match) it2.next()).getResultRange().h();
                            if (h4 < h5) {
                                h4 = h5;
                            }
                        }
                        d dVar = new d(c5, h4);
                        if (!(dVar instanceof Collection) || !((Collection) dVar).isEmpty()) {
                            Iterator it3 = dVar.iterator();
                            int i6 = 0;
                            while (it3.hasNext()) {
                                int nextInt = ((E) it3).nextInt();
                                Iterator it4 = iterable.iterator();
                                int i7 = 0;
                                while (true) {
                                    if (!it4.hasNext()) {
                                        break;
                                    }
                                    if (((Match) it4.next()).getResultRange().m(nextInt)) {
                                        i7++;
                                        continue;
                                    }
                                    if (i7 > 1) {
                                        i6++;
                                        if (i6 < 0) {
                                            C1601o.n();
                                        }
                                    }
                                }
                            }
                            i4 = i6;
                        }
                        return new Solution(list, i5, i4);
                    }
                    throw new NoSuchElementException();
                }
                throw new NoSuchElementException();
            }

            public final Solution getNO_SOLUTION() {
                return Solution.NO_SOLUTION;
            }

            private Companion() {
            }
        }

        public Solution(List<Match> list, int i4, int i5) {
            m.e(list, "matches");
            this.matches = list;
            this.coverageOffset = i4;
            this.overlaps = i5;
        }

        public final int getCoverageOffset() {
            return this.coverageOffset;
        }

        public final List<Match> getMatches() {
            return this.matches;
        }

        public final int getOverlaps() {
            return this.overlaps;
        }

        public int compareTo(Solution solution) {
            m.e(solution, "other");
            int g4 = m.g(this.overlaps, solution.overlaps);
            if (g4 != 0) {
                return g4;
            }
            return m.g(this.coverageOffset, solution.coverageOffset);
        }
    }

    private AmbiguousColumnResolver() {
    }

    private final <T> void dfs(List<? extends List<? extends T>> list, List<T> list2, int i4, l lVar) {
        if (i4 == list.size()) {
            lVar.invoke(C1601o.Z(list2));
            return;
        }
        for (Object add : (Iterable) list.get(i4)) {
            list2.add(add);
            INSTANCE.dfs(list, list2, i4 + 1, lVar);
            C1601o.x(list2);
        }
    }

    static /* synthetic */ void dfs$default(AmbiguousColumnResolver ambiguousColumnResolver, List list, List list2, int i4, l lVar, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            list2 = new ArrayList();
        }
        if ((i5 & 4) != 0) {
            i4 = 0;
        }
        ambiguousColumnResolver.dfs(list, list2, i4, lVar);
    }

    private final void rabinKarpSearch(List<ResultColumn> list, String[] strArr, q qVar) {
        int i4 = 0;
        int i5 = 0;
        for (String hashCode : strArr) {
            i5 += hashCode.hashCode();
        }
        int length = strArr.length;
        int i6 = 0;
        for (ResultColumn name : list.subList(0, length)) {
            i6 += name.getName().hashCode();
        }
        while (true) {
            if (i5 == i6) {
                qVar.invoke(Integer.valueOf(i4), Integer.valueOf(length), list.subList(i4, length));
            }
            int i7 = i4 + 1;
            int i8 = length + 1;
            if (i8 <= list.size()) {
                i6 = (i6 - list.get(i4).getName().hashCode()) + list.get(length).getName().hashCode();
                i4 = i7;
                length = i8;
            } else {
                return;
            }
        }
    }

    public static final int[][] resolve(String[] strArr, String[][] strArr2) {
        String[] strArr3 = strArr;
        String[][] strArr4 = strArr2;
        m.e(strArr3, "resultColumns");
        m.e(strArr4, "mappings");
        int length = strArr3.length;
        for (int i4 = 0; i4 < length; i4++) {
            String str = strArr3[i4];
            if (str.charAt(0) == '`' && str.charAt(str.length() - 1) == '`') {
                str = str.substring(1, str.length() - 1);
                m.d(str, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            Locale locale = Locale.US;
            m.d(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            m.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            strArr3[i4] = lowerCase;
        }
        int length2 = strArr4.length;
        for (int i5 = 0; i5 < length2; i5++) {
            int length3 = strArr4[i5].length;
            for (int i6 = 0; i6 < length3; i6++) {
                String[] strArr5 = strArr4[i5];
                String str2 = strArr5[i6];
                Locale locale2 = Locale.US;
                m.d(locale2, "US");
                String lowerCase2 = str2.toLowerCase(locale2);
                m.d(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                strArr5[i6] = lowerCase2;
            }
        }
        Set b5 = N.b();
        for (String[] v4 : strArr4) {
            C1601o.v(b5, v4);
        }
        Set a5 = N.a(b5);
        List c5 = C1601o.c();
        int length4 = strArr3.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length4) {
            String str3 = strArr3[i7];
            int i9 = i8 + 1;
            if (a5.contains(str3)) {
                c5.add(new ResultColumn(str3, i8));
            }
            i7++;
            i8 = i9;
        }
        List<ResultColumn> a6 = C1601o.a(c5);
        int length5 = strArr4.length;
        ArrayList arrayList = new ArrayList(length5);
        for (int i10 = 0; i10 < length5; i10++) {
            arrayList.add(new ArrayList());
        }
        int length6 = strArr4.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length6) {
            String[] strArr6 = strArr4[i11];
            int i13 = i12 + 1;
            INSTANCE.rabinKarpSearch(a6, strArr6, new AmbiguousColumnResolver$resolve$1$1(strArr6, arrayList, i12));
            if (((List) arrayList.get(i12)).isEmpty()) {
                ArrayList arrayList2 = new ArrayList(strArr6.length);
                int length7 = strArr6.length;
                int i14 = 0;
                while (i14 < length7) {
                    String str4 = strArr6[i14];
                    List c6 = C1601o.c();
                    for (ResultColumn resultColumn : a6) {
                        if (m.a(str4, resultColumn.getName())) {
                            c6.add(Integer.valueOf(resultColumn.getIndex()));
                        }
                    }
                    List a7 = C1601o.a(c6);
                    if (!a7.isEmpty()) {
                        arrayList2.add(a7);
                        i14++;
                    } else {
                        throw new IllegalStateException(("Column " + str4 + " not found in result").toString());
                    }
                }
                dfs$default(INSTANCE, arrayList2, (List) null, 0, new AmbiguousColumnResolver$resolve$1$2(arrayList, i12), 6, (Object) null);
            }
            i11++;
            i12 = i13;
        }
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            int i15 = 0;
            while (i15 < size) {
                Object obj = arrayList.get(i15);
                i15++;
                if (((List) obj).isEmpty()) {
                    throw new IllegalStateException("Failed to find matches for all mappings");
                }
            }
        }
        C c7 = new C();
        c7.f20968a = Solution.Companion.getNO_SOLUTION();
        dfs$default(INSTANCE, arrayList, (List) null, 0, new AmbiguousColumnResolver$resolve$4(c7), 6, (Object) null);
        Iterable<Match> matches = ((Solution) c7.f20968a).getMatches();
        ArrayList arrayList3 = new ArrayList(C1601o.p(matches, 10));
        for (Match resultIndices : matches) {
            arrayList3.add(C1601o.Y(resultIndices.getResultIndices()));
        }
        Object[] array = arrayList3.toArray(new int[0][]);
        m.c(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (int[][]) array;
    }
}
