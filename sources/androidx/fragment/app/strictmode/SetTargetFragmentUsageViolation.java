package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.m;

public final class SetTargetFragmentUsageViolation extends TargetFragmentUsageViolation {
    private final int requestCode;
    private final Fragment targetFragment;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SetTargetFragmentUsageViolation(Fragment fragment, Fragment fragment2, int i4) {
        super(fragment, "Attempting to set target fragment " + fragment2 + " with request code " + i4 + " for fragment " + fragment);
        m.e(fragment, "fragment");
        m.e(fragment2, "targetFragment");
        this.targetFragment = fragment2;
        this.requestCode = i4;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public final Fragment getTargetFragment() {
        return this.targetFragment;
    }
}
