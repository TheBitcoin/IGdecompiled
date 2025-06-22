package E2;

import A2.a;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.m;

public final class u extends Throwable {

    /* renamed from: a  reason: collision with root package name */
    public final String f6417a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6418b;

    /* renamed from: c  reason: collision with root package name */
    public final String f6419c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(String str, String str2, String str3) {
        super("invalid value " + str2 + " passed for " + str + ' ' + str3);
        m.e(str, "fieldName");
        m.e(str2, "fieldValue");
        m.e(str3, NotificationCompat.CATEGORY_MESSAGE);
        this.f6417a = str;
        this.f6418b = str2;
        this.f6419c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        if (m.a(this.f6417a, uVar.f6417a) && m.a(this.f6418b, uVar.f6418b) && m.a(this.f6419c, uVar.f6419c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f6419c.hashCode() + t.a(this.f6418b, this.f6417a.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder a5 = a.a("TCModelError(fieldName=");
        a5.append(this.f6417a);
        a5.append(", fieldValue=");
        a5.append(this.f6418b);
        a5.append(", msg=");
        a5.append(this.f6419c);
        a5.append(')');
        return a5.toString();
    }
}
