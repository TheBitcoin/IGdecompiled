package kotlin.jvm.internal;

import k3.b;
import k3.h;

public abstract class y extends C2099c implements h {
    private final boolean syntheticJavaProperty;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public y(java.lang.Object r10, java.lang.Class r11, java.lang.String r12, java.lang.String r13, int r14) {
        /*
            r9 = this;
            r0 = r14 & 1
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L_0x000d
            r8 = 1
        L_0x0007:
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            goto L_0x000f
        L_0x000d:
            r8 = 0
            goto L_0x0007
        L_0x000f:
            r3.<init>(r4, r5, r6, r7, r8)
            r10 = 2
            r11 = r14 & 2
            if (r11 != r10) goto L_0x0018
            r1 = 1
        L_0x0018:
            r3.syntheticJavaProperty = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.y.<init>(java.lang.Object, java.lang.Class, java.lang.String, java.lang.String, int):void");
    }

    public b compute() {
        if (this.syntheticJavaProperty) {
            return this;
        }
        return super.compute();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof y) {
            y yVar = (y) obj;
            if (!getOwner().equals(yVar.getOwner()) || !getName().equals(yVar.getName()) || !getSignature().equals(yVar.getSignature()) || !m.a(getBoundReceiver(), yVar.getBoundReceiver())) {
                return false;
            }
            return true;
        } else if (obj instanceof h) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public boolean isConst() {
        return getReflected().isConst();
    }

    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    /* access modifiers changed from: protected */
    public h getReflected() {
        if (!this.syntheticJavaProperty) {
            return (h) super.getReflected();
        }
        throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
    }
}
