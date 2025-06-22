package kotlin.jvm.internal;

import k3.b;
import k3.e;

public abstract class j extends C2099c implements i, e {
    private final int arity;
    private final int flags;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public j(int r9, java.lang.Object r10, java.lang.Class r11, java.lang.String r12, java.lang.String r13, int r14) {
        /*
            r8 = this;
            r0 = r14 & 1
            r1 = 1
            if (r0 != r1) goto L_0x000c
            r7 = 1
        L_0x0006:
            r2 = r8
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            goto L_0x000f
        L_0x000c:
            r0 = 0
            r7 = 0
            goto L_0x0006
        L_0x000f:
            r2.<init>(r3, r4, r5, r6, r7)
            r2.arity = r9
            int r9 = r14 >> 1
            r2.flags = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.j.<init>(int, java.lang.Object, java.lang.Class, java.lang.String, java.lang.String, int):void");
    }

    /* access modifiers changed from: protected */
    public b computeReflected() {
        return D.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (!getName().equals(jVar.getName()) || !getSignature().equals(jVar.getSignature()) || this.flags != jVar.flags || this.arity != jVar.arity || !m.a(getBoundReceiver(), jVar.getBoundReceiver()) || !m.a(getOwner(), jVar.getOwner())) {
                return false;
            }
            return true;
        } else if (obj instanceof e) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        int i4;
        if (getOwner() == null) {
            i4 = 0;
        } else {
            i4 = getOwner().hashCode() * 31;
        }
        return ((i4 + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public boolean isExternal() {
        return getReflected().isExternal();
    }

    public boolean isInfix() {
        return getReflected().isInfix();
    }

    public boolean isInline() {
        return getReflected().isInline();
    }

    public boolean isOperator() {
        return getReflected().isOperator();
    }

    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    /* access modifiers changed from: protected */
    public e getReflected() {
        return (e) super.getReflected();
    }
}
