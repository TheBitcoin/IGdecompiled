package d1;

import kotlin.jvm.internal.m;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final Boolean f19555a;

    /* renamed from: b  reason: collision with root package name */
    private final Double f19556b;

    /* renamed from: c  reason: collision with root package name */
    private final Integer f19557c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f19558d;

    /* renamed from: e  reason: collision with root package name */
    private final Long f19559e;

    public e(Boolean bool, Double d5, Integer num, Integer num2, Long l4) {
        this.f19555a = bool;
        this.f19556b = d5;
        this.f19557c = num;
        this.f19558d = num2;
        this.f19559e = l4;
    }

    public final Integer a() {
        return this.f19558d;
    }

    public final Long b() {
        return this.f19559e;
    }

    public final Boolean c() {
        return this.f19555a;
    }

    public final Integer d() {
        return this.f19557c;
    }

    public final Double e() {
        return this.f19556b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (m.a(this.f19555a, eVar.f19555a) && m.a(this.f19556b, eVar.f19556b) && m.a(this.f19557c, eVar.f19557c) && m.a(this.f19558d, eVar.f19558d) && m.a(this.f19559e, eVar.f19559e)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        int i5;
        int i6;
        int i7;
        Boolean bool = this.f19555a;
        int i8 = 0;
        if (bool == null) {
            i4 = 0;
        } else {
            i4 = bool.hashCode();
        }
        int i9 = i4 * 31;
        Double d5 = this.f19556b;
        if (d5 == null) {
            i5 = 0;
        } else {
            i5 = d5.hashCode();
        }
        int i10 = (i9 + i5) * 31;
        Integer num = this.f19557c;
        if (num == null) {
            i6 = 0;
        } else {
            i6 = num.hashCode();
        }
        int i11 = (i10 + i6) * 31;
        Integer num2 = this.f19558d;
        if (num2 == null) {
            i7 = 0;
        } else {
            i7 = num2.hashCode();
        }
        int i12 = (i11 + i7) * 31;
        Long l4 = this.f19559e;
        if (l4 != null) {
            i8 = l4.hashCode();
        }
        return i12 + i8;
    }

    public String toString() {
        return "SessionConfigs(sessionEnabled=" + this.f19555a + ", sessionSamplingRate=" + this.f19556b + ", sessionRestartTimeout=" + this.f19557c + ", cacheDuration=" + this.f19558d + ", cacheUpdatedTime=" + this.f19559e + ')';
    }
}
