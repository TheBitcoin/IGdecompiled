package A3;

import A2.a;
import java.util.List;
import kotlin.jvm.internal.m;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f67a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f68b;

    /* renamed from: c  reason: collision with root package name */
    public final String f69c;

    /* renamed from: d  reason: collision with root package name */
    public Boolean f70d;

    /* renamed from: e  reason: collision with root package name */
    public final String f71e;

    /* renamed from: f  reason: collision with root package name */
    public final List f72f;

    public f(Integer num, Integer num2, String str, Boolean bool, String str2, List list) {
        this.f67a = num;
        this.f68b = num2;
        this.f69c = str;
        this.f70d = bool;
        this.f71e = str2;
        this.f72f = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (m.a(this.f67a, fVar.f67a) && m.a(this.f68b, fVar.f68b) && m.a(this.f69c, fVar.f69c) && m.a(this.f70d, fVar.f70d) && m.a(this.f71e, fVar.f71e) && m.a(this.f72f, fVar.f72f)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Integer num = this.f67a;
        int i9 = 0;
        if (num == null) {
            i4 = 0;
        } else {
            i4 = num.hashCode();
        }
        int i10 = i4 * 31;
        Integer num2 = this.f68b;
        if (num2 == null) {
            i5 = 0;
        } else {
            i5 = num2.hashCode();
        }
        int i11 = (i10 + i5) * 31;
        String str = this.f69c;
        if (str == null) {
            i6 = 0;
        } else {
            i6 = str.hashCode();
        }
        int i12 = (i11 + i6) * 31;
        Boolean bool = this.f70d;
        if (bool == null) {
            i7 = 0;
        } else {
            i7 = bool.hashCode();
        }
        int i13 = (i12 + i7) * 31;
        String str2 = this.f71e;
        if (str2 == null) {
            i8 = 0;
        } else {
            i8 = str2.hashCode();
        }
        int i14 = (i13 + i8) * 31;
        List list = this.f72f;
        if (list != null) {
            i9 = list.hashCode();
        }
        return i14 + i9;
    }

    public String toString() {
        StringBuilder a5 = a.a("MSPASensitivePurpose(id=");
        a5.append(this.f67a);
        a5.append(", order=");
        a5.append(this.f68b);
        a5.append(", title=");
        a5.append(this.f69c);
        a5.append(", value=");
        a5.append(this.f70d);
        a5.append(", description=");
        a5.append(this.f71e);
        a5.append(", nationalIds=");
        a5.append(this.f72f);
        a5.append(')');
        return a5.toString();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ f(java.lang.Integer r9, java.lang.Integer r10, java.lang.String r11, java.lang.Boolean r12, java.lang.String r13, java.util.List r14, int r15) {
        /*
            r8 = this;
            r12 = r15 & 1
            r0 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            if (r12 == 0) goto L_0x000b
            r2 = r0
            goto L_0x000c
        L_0x000b:
            r2 = r9
        L_0x000c:
            r9 = r15 & 2
            if (r9 == 0) goto L_0x0012
            r3 = r0
            goto L_0x0013
        L_0x0012:
            r3 = r10
        L_0x0013:
            r9 = r15 & 4
            java.lang.String r10 = ""
            if (r9 == 0) goto L_0x001b
            r4 = r10
            goto L_0x001c
        L_0x001b:
            r4 = r11
        L_0x001c:
            r9 = r15 & 8
            if (r9 == 0) goto L_0x0024
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
        L_0x0022:
            r5 = r9
            goto L_0x0026
        L_0x0024:
            r9 = 0
            goto L_0x0022
        L_0x0026:
            r9 = r15 & 16
            if (r9 == 0) goto L_0x002c
            r6 = r10
            goto L_0x002d
        L_0x002c:
            r6 = r13
        L_0x002d:
            r9 = r15 & 32
            if (r9 == 0) goto L_0x0035
            java.util.List r14 = S2.C1601o.h()
        L_0x0035:
            r1 = r8
            r7 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: A3.f.<init>(java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Boolean, java.lang.String, java.util.List, int):void");
    }
}
