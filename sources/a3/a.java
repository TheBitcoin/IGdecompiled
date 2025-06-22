package A3;

import java.util.List;
import kotlin.jvm.internal.m;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f29a;

    /* renamed from: b  reason: collision with root package name */
    public final String f30b;

    /* renamed from: c  reason: collision with root package name */
    public final List f31c;

    /* renamed from: d  reason: collision with root package name */
    public List f32d;

    public a(String str, String str2, List list, List list2) {
        this.f29a = str;
        this.f30b = str2;
        this.f31c = list;
        this.f32d = list2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (m.a(this.f29a, aVar.f29a) && m.a(this.f30b, aVar.f30b) && m.a(this.f31c, aVar.f31c) && m.a(this.f32d, aVar.f32d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        int i5;
        int i6;
        String str = this.f29a;
        int i7 = 0;
        if (str == null) {
            i4 = 0;
        } else {
            i4 = str.hashCode();
        }
        int i8 = i4 * 31;
        String str2 = this.f30b;
        if (str2 == null) {
            i5 = 0;
        } else {
            i5 = str2.hashCode();
        }
        int i9 = (i8 + i5) * 31;
        List list = this.f31c;
        if (list == null) {
            i6 = 0;
        } else {
            i6 = list.hashCode();
        }
        int i10 = (i9 + i6) * 31;
        List list2 = this.f32d;
        if (list2 != null) {
            i7 = list2.hashCode();
        }
        return i10 + i7;
    }

    public String toString() {
        StringBuilder a5 = A2.a.a("MSPAConfig(jurisdiction=");
        a5.append(this.f29a);
        a5.append(", state=");
        a5.append(this.f30b);
        a5.append(", purposes=");
        a5.append(this.f31c);
        a5.append(", applicablePurposes=");
        a5.append(this.f32d);
        a5.append(')');
        return a5.toString();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ a(java.lang.String r2, java.lang.String r3, java.util.List r4, java.util.List r5, int r6) {
        /*
            r1 = this;
            r3 = r6 & 1
            java.lang.String r5 = ""
            if (r3 == 0) goto L_0x0007
            r2 = r5
        L_0x0007:
            r3 = r6 & 2
            r0 = 0
            if (r3 == 0) goto L_0x000d
            goto L_0x000e
        L_0x000d:
            r5 = r0
        L_0x000e:
            r3 = r6 & 4
            if (r3 == 0) goto L_0x0016
            java.util.List r4 = S2.C1601o.h()
        L_0x0016:
            r3 = r6 & 8
            if (r3 == 0) goto L_0x001e
            java.util.List r0 = S2.C1601o.h()
        L_0x001e:
            r1.<init>(r2, r5, r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: A3.a.<init>(java.lang.String, java.lang.String, java.util.List, java.util.List, int):void");
    }
}
