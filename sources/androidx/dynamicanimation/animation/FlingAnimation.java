package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;
import androidx.dynamicanimation.animation.DynamicAnimation;

public final class FlingAnimation extends DynamicAnimation<FlingAnimation> {
    private final DragForce mFlingForce;

    static final class DragForce implements Force {
        private static final float DEFAULT_FRICTION = -4.2f;
        private static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5f;
        private float mFriction = DEFAULT_FRICTION;
        private final DynamicAnimation.MassState mMassState = new DynamicAnimation.MassState();
        private float mVelocityThreshold;

        DragForce() {
        }

        public float getAcceleration(float f4, float f5) {
            return f5 * this.mFriction;
        }

        /* access modifiers changed from: package-private */
        public float getFrictionScalar() {
            return this.mFriction / DEFAULT_FRICTION;
        }

        public boolean isAtEquilibrium(float f4, float f5) {
            if (Math.abs(f5) < this.mVelocityThreshold) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void setFrictionScalar(float f4) {
            this.mFriction = f4 * DEFAULT_FRICTION;
        }

        /* access modifiers changed from: package-private */
        public void setValueThreshold(float f4) {
            this.mVelocityThreshold = f4 * VELOCITY_THRESHOLD_MULTIPLIER;
        }

        /* access modifiers changed from: package-private */
        public DynamicAnimation.MassState updateValueAndVelocity(float f4, float f5, long j4) {
            float f6 = (float) j4;
            this.mMassState.mVelocity = (float) (((double) f5) * Math.exp((double) ((f6 / 1000.0f) * this.mFriction)));
            DynamicAnimation.MassState massState = this.mMassState;
            float f7 = this.mFriction;
            massState.mValue = (float) (((double) (f4 - (f5 / f7))) + (((double) (f5 / f7)) * Math.exp((double) ((f7 * f6) / 1000.0f))));
            DynamicAnimation.MassState massState2 = this.mMassState;
            if (isAtEquilibrium(massState2.mValue, massState2.mVelocity)) {
                this.mMassState.mVelocity = 0.0f;
            }
            return this.mMassState;
        }
    }

    public FlingAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
        DragForce dragForce = new DragForce();
        this.mFlingForce = dragForce;
        dragForce.setValueThreshold(getValueThreshold());
    }

    /* access modifiers changed from: package-private */
    public float getAcceleration(float f4, float f5) {
        return this.mFlingForce.getAcceleration(f4, f5);
    }

    public float getFriction() {
        return this.mFlingForce.getFrictionScalar();
    }

    /* access modifiers changed from: package-private */
    public boolean isAtEquilibrium(float f4, float f5) {
        if (f4 >= this.mMaxValue || f4 <= this.mMinValue || this.mFlingForce.isAtEquilibrium(f4, f5)) {
            return true;
        }
        return false;
    }

    public FlingAnimation setFriction(@FloatRange(from = 0.0d, fromInclusive = false) float f4) {
        if (f4 > 0.0f) {
            this.mFlingForce.setFrictionScalar(f4);
            return this;
        }
        throw new IllegalArgumentException("Friction must be positive");
    }

    /* access modifiers changed from: package-private */
    public void setValueThreshold(float f4) {
        this.mFlingForce.setValueThreshold(f4);
    }

    /* access modifiers changed from: package-private */
    public boolean updateValueAndVelocity(long j4) {
        DynamicAnimation.MassState updateValueAndVelocity = this.mFlingForce.updateValueAndVelocity(this.mValue, this.mVelocity, j4);
        float f4 = updateValueAndVelocity.mValue;
        this.mValue = f4;
        float f5 = updateValueAndVelocity.mVelocity;
        this.mVelocity = f5;
        float f6 = this.mMinValue;
        if (f4 < f6) {
            this.mValue = f6;
            return true;
        }
        float f7 = this.mMaxValue;
        if (f4 > f7) {
            this.mValue = f7;
            return true;
        } else if (isAtEquilibrium(f4, f5)) {
            return true;
        } else {
            return false;
        }
    }

    public FlingAnimation setMaxValue(float f4) {
        super.setMaxValue(f4);
        return this;
    }

    public FlingAnimation setMinValue(float f4) {
        super.setMinValue(f4);
        return this;
    }

    public FlingAnimation setStartVelocity(float f4) {
        super.setStartVelocity(f4);
        return this;
    }

    public <K> FlingAnimation(K k4, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k4, floatPropertyCompat);
        DragForce dragForce = new DragForce();
        this.mFlingForce = dragForce;
        dragForce.setValueThreshold(getValueThreshold());
    }
}
