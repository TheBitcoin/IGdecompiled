package j$.time.format;

import j$.time.chrono.l;
import j$.time.chrono.s;
import j$.time.temporal.a;
import j$.time.temporal.r;
import java.util.Locale;

public final class m implements f {

    /* renamed from: a  reason: collision with root package name */
    public final a f4952a;

    /* renamed from: b  reason: collision with root package name */
    public final v f4953b;

    /* renamed from: c  reason: collision with root package name */
    public final b f4954c;

    /* renamed from: d  reason: collision with root package name */
    public volatile i f4955d;

    public m(a aVar, v vVar, b bVar) {
        this.f4952a = aVar;
        this.f4953b = vVar;
        this.f4954c = bVar;
    }

    public final boolean j(p pVar, StringBuilder sb) {
        String str;
        Long a5 = pVar.a(this.f4952a);
        if (a5 == null) {
            return false;
        }
        l lVar = (l) pVar.f4966a.p(r.f5033b);
        if (lVar == null || lVar == s.f4904c) {
            b bVar = this.f4954c;
            long longValue = a5.longValue();
            v vVar = this.f4953b;
            Locale locale = pVar.f4967b.f4927b;
            str = bVar.f4932a.b(longValue, vVar);
        } else {
            b bVar2 = this.f4954c;
            long longValue2 = a5.longValue();
            v vVar2 = this.f4953b;
            Locale locale2 = pVar.f4967b.f4927b;
            str = bVar2.f4932a.b(longValue2, vVar2);
        }
        if (str == null) {
            if (this.f4955d == null) {
                this.f4955d = new i(this.f4952a, 1, 19, u.NORMAL);
            }
            return this.f4955d.j(pVar, sb);
        }
        sb.append(str);
        return true;
    }

    public final String toString() {
        v vVar = v.FULL;
        a aVar = this.f4952a;
        v vVar2 = this.f4953b;
        if (vVar2 == vVar) {
            return "Text(" + aVar + ")";
        }
        return "Text(" + aVar + "," + vVar2 + ")";
    }
}
