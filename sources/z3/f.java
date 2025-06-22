package z3;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import kotlin.jvm.internal.m;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public final int f4812a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4813b;

    public f(int i4, String str) {
        m.e(str, RewardPlus.NAME);
        this.f4812a = i4;
        this.f4813b = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(int i4, String str, int i5) {
        this((i5 & 1) != 0 ? 0 : i4, (i5 & 2) != 0 ? "" : null);
    }
}
