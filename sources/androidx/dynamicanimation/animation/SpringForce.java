package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.dynamicanimation.animation.DynamicAnimation;

public final class SpringForce implements Force {
    public static final float DAMPING_RATIO_HIGH_BOUNCY = 0.2f;
    public static final float DAMPING_RATIO_LOW_BOUNCY = 0.75f;
    public static final float DAMPING_RATIO_MEDIUM_BOUNCY = 0.5f;
    public static final float DAMPING_RATIO_NO_BOUNCY = 1.0f;
    public static final float STIFFNESS_HIGH = 10000.0f;
    public static final float STIFFNESS_LOW = 200.0f;
    public static final float STIFFNESS_MEDIUM = 1500.0f;
    public static final float STIFFNESS_VERY_LOW = 50.0f;
    private static final double UNSET = Double.MAX_VALUE;
    private static final double VELOCITY_THRESHOLD_MULTIPLIER = 62.5d;
    private double mDampedFreq;
    double mDampingRatio = 0.5d;
    private double mFinalPosition = UNSET;
    private double mGammaMinus;
    private double mGammaPlus;
    private boolean mInitialized = false;
    private final DynamicAnimation.MassState mMassState = new DynamicAnimation.MassState();
    double mNaturalFreq = Math.sqrt(1500.0d);
    private double mValueThreshold;
    private double mVelocityThreshold;

    public SpringForce() {
    }

    private void init() {
        if (!this.mInitialized) {
            if (this.mFinalPosition != UNSET) {
                double d5 = this.mDampingRatio;
                if (d5 > 1.0d) {
                    double d6 = this.mNaturalFreq;
                    this.mGammaPlus = ((-d5) * d6) + (d6 * Math.sqrt((d5 * d5) - 1.0d));
                    double d7 = this.mDampingRatio;
                    double d8 = this.mNaturalFreq;
                    this.mGammaMinus = ((-d7) * d8) - (d8 * Math.sqrt((d7 * d7) - 1.0d));
                } else if (d5 >= 0.0d && d5 < 1.0d) {
                    this.mDampedFreq = this.mNaturalFreq * Math.sqrt(1.0d - (d5 * d5));
                }
                this.mInitialized = true;
                return;
            }
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float getAcceleration(float f4, float f5) {
        float finalPosition = f4 - getFinalPosition();
        double d5 = this.mNaturalFreq;
        return (float) (((-(d5 * d5)) * ((double) finalPosition)) - (((d5 * 2.0d) * this.mDampingRatio) * ((double) f5)));
    }

    public float getDampingRatio() {
        return (float) this.mDampingRatio;
    }

    public float getFinalPosition() {
        return (float) this.mFinalPosition;
    }

    public float getStiffness() {
        double d5 = this.mNaturalFreq;
        return (float) (d5 * d5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean isAtEquilibrium(float f4, float f5) {
        if (((double) Math.abs(f5)) >= this.mVelocityThreshold || ((double) Math.abs(f4 - getFinalPosition())) >= this.mValueThreshold) {
            return false;
        }
        return true;
    }

    public SpringForce setDampingRatio(@FloatRange(from = 0.0d) float f4) {
        if (f4 >= 0.0f) {
            this.mDampingRatio = (double) f4;
            this.mInitialized = false;
            return this;
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public SpringForce setFinalPosition(float f4) {
        this.mFinalPosition = (double) f4;
        return this;
    }

    public SpringForce setStiffness(@FloatRange(from = 0.0d, fromInclusive = false) float f4) {
        if (f4 > 0.0f) {
            this.mNaturalFreq = Math.sqrt((double) f4);
            this.mInitialized = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    /* access modifiers changed from: package-private */
    public void setValueThreshold(double d5) {
        double abs = Math.abs(d5);
        this.mValueThreshold = abs;
        this.mVelocityThreshold = abs * VELOCITY_THRESHOLD_MULTIPLIER;
    }

    /* access modifiers changed from: package-private */
    public DynamicAnimation.MassState updateValues(double d5, double d6, long j4) {
        double d7;
        double d8;
        init();
        double d9 = ((double) j4) / 1000.0d;
        double d10 = d5 - this.mFinalPosition;
        double d11 = this.mDampingRatio;
        if (d11 > 1.0d) {
            double d12 = this.mGammaMinus;
            double d13 = this.mGammaPlus;
            double d14 = d10 - (((d12 * d10) - d6) / (d12 - d13));
            double d15 = ((d10 * d12) - d6) / (d12 - d13);
            d8 = (Math.pow(2.718281828459045d, d12 * d9) * d14) + (Math.pow(2.718281828459045d, this.mGammaPlus * d9) * d15);
            double d16 = this.mGammaMinus;
            double pow = d14 * d16 * Math.pow(2.718281828459045d, d16 * d9);
            double d17 = this.mGammaPlus;
            d7 = pow + (d15 * d17 * Math.pow(2.718281828459045d, d17 * d9));
        } else if (d11 == 1.0d) {
            double d18 = this.mNaturalFreq;
            double d19 = d6 + (d18 * d10);
            double d20 = d10 + (d19 * d9);
            d8 = Math.pow(2.718281828459045d, (-d18) * d9) * d20;
            double pow2 = d20 * Math.pow(2.718281828459045d, (-this.mNaturalFreq) * d9);
            double d21 = this.mNaturalFreq;
            d7 = (d19 * Math.pow(2.718281828459045d, (-d21) * d9)) + (pow2 * (-d21));
        } else {
            double d22 = 1.0d / this.mDampedFreq;
            double d23 = this.mNaturalFreq;
            double d24 = d22 * ((d11 * d23 * d10) + d6);
            d8 = Math.pow(2.718281828459045d, (-d11) * d23 * d9) * ((Math.cos(this.mDampedFreq * d9) * d10) + (Math.sin(this.mDampedFreq * d9) * d24));
            double d25 = this.mNaturalFreq;
            double d26 = this.mDampingRatio;
            double d27 = (-d25) * d8 * d26;
            double pow3 = Math.pow(2.718281828459045d, (-d26) * d25 * d9);
            double d28 = this.mDampedFreq;
            double d29 = d9;
            double sin = (-d28) * d10 * Math.sin(d28 * d29);
            double d30 = this.mDampedFreq;
            d7 = d27 + (pow3 * (sin + (d24 * d30 * Math.cos(d30 * d29))));
        }
        DynamicAnimation.MassState massState = this.mMassState;
        massState.mValue = (float) (d8 + this.mFinalPosition);
        massState.mVelocity = (float) d7;
        return massState;
    }

    public SpringForce(float f4) {
        this.mFinalPosition = (double) f4;
    }
}
