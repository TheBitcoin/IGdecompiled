package e4;

import A2.a;
import E2.t;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import kotlin.jvm.internal.m;
import z3.f;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final f f24631a;

    /* renamed from: b  reason: collision with root package name */
    public Boolean f24632b;

    /* renamed from: c  reason: collision with root package name */
    public final f f24633c;

    /* renamed from: d  reason: collision with root package name */
    public e f24634d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f24635e;

    /* renamed from: f  reason: collision with root package name */
    public String f24636f;

    /* renamed from: g  reason: collision with root package name */
    public Integer f24637g;

    public d(f fVar, Boolean bool, f fVar2, e eVar, boolean z4, String str, Integer num) {
        m.e(fVar, "value");
        m.e(fVar2, "viewType");
        m.e(eVar, "itemType");
        m.e(str, MimeTypes.BASE_TYPE_TEXT);
        this.f24631a = fVar;
        this.f24632b = bool;
        this.f24633c = fVar2;
        this.f24634d = eVar;
        this.f24635e = z4;
        this.f24636f = str;
        this.f24637g = num;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (m.a(this.f24631a, dVar.f24631a) && m.a(this.f24632b, dVar.f24632b) && this.f24633c == dVar.f24633c && this.f24634d == dVar.f24634d && this.f24635e == dVar.f24635e && m.a(this.f24636f, dVar.f24636f) && m.a(this.f24637g, dVar.f24637g)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        int hashCode = this.f24631a.hashCode() * 31;
        Boolean bool = this.f24632b;
        int i5 = 0;
        if (bool == null) {
            i4 = 0;
        } else {
            i4 = bool.hashCode();
        }
        int hashCode2 = this.f24633c.hashCode();
        int hashCode3 = (this.f24634d.hashCode() + ((hashCode2 + ((hashCode + i4) * 31)) * 31)) * 31;
        boolean z4 = this.f24635e;
        if (z4) {
            z4 = true;
        }
        int a5 = t.a(this.f24636f, (hashCode3 + (z4 ? 1 : 0)) * 31, 31);
        Integer num = this.f24637g;
        if (num != null) {
            i5 = num.hashCode();
        }
        return a5 + i5;
    }

    public String toString() {
        StringBuilder a5 = a.a("SwitchItemData(value=");
        a5.append(this.f24631a);
        a5.append(", selectedState=");
        a5.append(this.f24632b);
        a5.append(", viewType=");
        a5.append(this.f24633c);
        a5.append(", itemType=");
        a5.append(this.f24634d);
        a5.append(", isTagEnabled=");
        a5.append(this.f24635e);
        a5.append(", text=");
        a5.append(this.f24636f);
        a5.append(", counter=");
        a5.append(this.f24637g);
        a5.append(')');
        return a5.toString();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ d(z3.f r9, java.lang.Boolean r10, e4.f r11, e4.e r12, boolean r13, java.lang.String r14, java.lang.Integer r15, int r16) {
        /*
            r8 = this;
            r0 = r16 & 1
            r1 = 0
            if (r0 == 0) goto L_0x000d
            z3.f r0 = new z3.f
            r2 = 0
            r3 = 3
            r0.<init>(r2, r1, r3)
            goto L_0x000e
        L_0x000d:
            r0 = r9
        L_0x000e:
            r2 = r16 & 2
            if (r2 == 0) goto L_0x0014
            r2 = r1
            goto L_0x0015
        L_0x0014:
            r2 = r10
        L_0x0015:
            r3 = r16 & 4
            if (r3 == 0) goto L_0x001c
            e4.f r3 = e4.f.NORMAL
            goto L_0x001d
        L_0x001c:
            r3 = r11
        L_0x001d:
            r4 = r16 & 8
            if (r4 == 0) goto L_0x0024
            e4.e r4 = e4.e.IAB_VENDOR
            goto L_0x0025
        L_0x0024:
            r4 = r12
        L_0x0025:
            r5 = r16 & 16
            if (r5 == 0) goto L_0x002b
            r5 = 1
            goto L_0x002c
        L_0x002b:
            r5 = r13
        L_0x002c:
            r6 = r16 & 32
            if (r6 == 0) goto L_0x0033
            java.lang.String r6 = ""
            goto L_0x0034
        L_0x0033:
            r6 = r14
        L_0x0034:
            r7 = r16 & 64
            if (r7 == 0) goto L_0x0042
            r16 = r1
        L_0x003a:
            r9 = r8
            r10 = r0
            r11 = r2
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            goto L_0x0045
        L_0x0042:
            r16 = r15
            goto L_0x003a
        L_0x0045:
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e4.d.<init>(z3.f, java.lang.Boolean, e4.f, e4.e, boolean, java.lang.String, java.lang.Integer, int):void");
    }
}
