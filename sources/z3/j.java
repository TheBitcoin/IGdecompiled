package z3;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.List;
import kotlin.jvm.internal.m;

public final class j extends f {

    /* renamed from: c  reason: collision with root package name */
    public final List f4816c;

    /* renamed from: d  reason: collision with root package name */
    public final List f4817d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(int i4, String str, String str2, List list, List list2) {
        super(i4, str);
        m.e(str, RewardPlus.NAME);
        m.e(str2, "description");
        m.e(list, "purposes");
        m.e(list2, "specialFeatures");
        this.f4816c = list;
        this.f4817d = list2;
    }
}
