package z3;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import kotlin.jvm.internal.m;

public final class d extends f implements g {

    /* renamed from: c  reason: collision with root package name */
    public String f4798c;

    /* renamed from: d  reason: collision with root package name */
    public String f4799d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(int i4, String str, String str2, String str3) {
        super(i4, str);
        m.e(str, RewardPlus.NAME);
        m.e(str2, "description");
        m.e(str3, "illustrations");
        this.f4798c = str2;
        this.f4799d = str3;
    }

    public String a() {
        return this.f4798c;
    }

    public String b() {
        return this.f4799d;
    }
}
