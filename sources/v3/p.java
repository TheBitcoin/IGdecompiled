package V3;

import A2.a;
import E2.t;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import kotlin.jvm.internal.m;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final int f24221a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24222b;

    /* renamed from: c  reason: collision with root package name */
    public final String f24223c;

    public p(int i4, String str, String str2) {
        m.e(str, "label");
        m.e(str2, MRAIDCommunicatorUtil.KEY_STATE);
        this.f24221a = i4;
        this.f24222b = str;
        this.f24223c = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f24221a == pVar.f24221a && m.a(this.f24222b, pVar.f24222b) && m.a(this.f24223c, pVar.f24223c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f24223c.hashCode() + t.a(this.f24222b, this.f24221a * 31, 31);
    }

    public String toString() {
        StringBuilder a5 = a.a("StackInfo(id=");
        a5.append(this.f24221a);
        a5.append(", label=");
        a5.append(this.f24222b);
        a5.append(", state=");
        a5.append(this.f24223c);
        a5.append(')');
        return a5.toString();
    }
}
