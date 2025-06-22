package androidx.work.impl.constraints;

import kotlin.jvm.internal.C2103g;

public abstract class ConstraintsState {

    public static final class ConstraintsMet extends ConstraintsState {
        public static final ConstraintsMet INSTANCE = new ConstraintsMet();

        private ConstraintsMet() {
            super((C2103g) null);
        }
    }

    public static final class ConstraintsNotMet extends ConstraintsState {
        private final int reason;

        public ConstraintsNotMet(int i4) {
            super((C2103g) null);
            this.reason = i4;
        }

        public static /* synthetic */ ConstraintsNotMet copy$default(ConstraintsNotMet constraintsNotMet, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i4 = constraintsNotMet.reason;
            }
            return constraintsNotMet.copy(i4);
        }

        public final int component1() {
            return this.reason;
        }

        public final ConstraintsNotMet copy(int i4) {
            return new ConstraintsNotMet(i4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ConstraintsNotMet) && this.reason == ((ConstraintsNotMet) obj).reason;
        }

        public final int getReason() {
            return this.reason;
        }

        public int hashCode() {
            return this.reason;
        }

        public String toString() {
            return "ConstraintsNotMet(reason=" + this.reason + ')';
        }
    }

    public /* synthetic */ ConstraintsState(C2103g gVar) {
        this();
    }

    private ConstraintsState() {
    }
}
