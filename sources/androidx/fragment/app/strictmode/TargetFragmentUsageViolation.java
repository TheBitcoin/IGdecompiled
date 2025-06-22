package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public abstract class TargetFragmentUsageViolation extends Violation {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TargetFragmentUsageViolation(Fragment fragment, String str, int i4, C2103g gVar) {
        this(fragment, (i4 & 2) != 0 ? null : str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TargetFragmentUsageViolation(Fragment fragment, String str) {
        super(fragment, str);
        m.e(fragment, "fragment");
    }
}
