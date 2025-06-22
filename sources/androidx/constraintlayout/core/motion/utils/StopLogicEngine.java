package androidx.constraintlayout.core.motion.utils;

public class StopLogicEngine implements StopEngine {
    private static final float EPSILON = 1.0E-5f;
    private boolean mBackwards = false;
    private boolean mDone = false;
    private float mLastPosition;
    private float mLastTime;
    private int mNumberOfStages;
    private float mStage1Duration;
    private float mStage1EndPosition;
    private float mStage1Velocity;
    private float mStage2Duration;
    private float mStage2EndPosition;
    private float mStage2Velocity;
    private float mStage3Duration;
    private float mStage3EndPosition;
    private float mStage3Velocity;
    private float mStartPosition;
    private String mType;

    private float calcY(float f4) {
        this.mDone = false;
        float f5 = this.mStage1Duration;
        if (f4 <= f5) {
            float f6 = this.mStage1Velocity;
            return (f6 * f4) + ((((this.mStage2Velocity - f6) * f4) * f4) / (f5 * 2.0f));
        }
        int i4 = this.mNumberOfStages;
        if (i4 == 1) {
            return this.mStage1EndPosition;
        }
        float f7 = f4 - f5;
        float f8 = this.mStage2Duration;
        if (f7 < f8) {
            float f9 = this.mStage1EndPosition;
            float f10 = this.mStage2Velocity;
            return f9 + (f10 * f7) + ((((this.mStage3Velocity - f10) * f7) * f7) / (f8 * 2.0f));
        } else if (i4 == 2) {
            return this.mStage2EndPosition;
        } else {
            float f11 = f7 - f8;
            float f12 = this.mStage3Duration;
            if (f11 <= f12) {
                float f13 = this.mStage2EndPosition;
                float f14 = this.mStage3Velocity;
                return (f13 + (f14 * f11)) - (((f14 * f11) * f11) / (f12 * 2.0f));
            }
            this.mDone = true;
            return this.mStage3EndPosition;
        }
    }

    private void setup(float f4, float f5, float f6, float f7, float f8) {
        this.mDone = false;
        this.mStage3EndPosition = f5;
        if (f4 == 0.0f) {
            f4 = 1.0E-4f;
        }
        float f9 = f4 / f6;
        float f10 = (f9 * f4) / 2.0f;
        if (f4 < 0.0f) {
            float sqrt = (float) Math.sqrt((double) ((f5 - ((((-f4) / f6) * f4) / 2.0f)) * f6));
            if (sqrt < f7) {
                this.mType = "backward accelerate, decelerate";
                this.mNumberOfStages = 2;
                this.mStage1Velocity = f4;
                this.mStage2Velocity = sqrt;
                this.mStage3Velocity = 0.0f;
                float f11 = (sqrt - f4) / f6;
                this.mStage1Duration = f11;
                this.mStage2Duration = sqrt / f6;
                this.mStage1EndPosition = ((f4 + sqrt) * f11) / 2.0f;
                this.mStage2EndPosition = f5;
                this.mStage3EndPosition = f5;
                return;
            }
            this.mType = "backward accelerate cruse decelerate";
            this.mNumberOfStages = 3;
            this.mStage1Velocity = f4;
            this.mStage2Velocity = f7;
            this.mStage3Velocity = f7;
            float f12 = (f7 - f4) / f6;
            this.mStage1Duration = f12;
            float f13 = f7 / f6;
            this.mStage3Duration = f13;
            float f14 = ((f4 + f7) * f12) / 2.0f;
            float f15 = (f13 * f7) / 2.0f;
            this.mStage2Duration = ((f5 - f14) - f15) / f7;
            this.mStage1EndPosition = f14;
            this.mStage2EndPosition = f5 - f15;
            this.mStage3EndPosition = f5;
        } else if (f10 >= f5) {
            this.mType = "hard stop";
            this.mNumberOfStages = 1;
            this.mStage1Velocity = f4;
            this.mStage2Velocity = 0.0f;
            this.mStage1EndPosition = f5;
            this.mStage1Duration = (2.0f * f5) / f4;
        } else {
            float f16 = f5 - f10;
            float f17 = f16 / f4;
            if (f17 + f9 < f8) {
                this.mType = "cruse decelerate";
                this.mNumberOfStages = 2;
                this.mStage1Velocity = f4;
                this.mStage2Velocity = f4;
                this.mStage3Velocity = 0.0f;
                this.mStage1EndPosition = f16;
                this.mStage2EndPosition = f5;
                this.mStage1Duration = f17;
                this.mStage2Duration = f9;
                return;
            }
            float sqrt2 = (float) Math.sqrt((double) ((f6 * f5) + ((f4 * f4) / 2.0f)));
            float f18 = (sqrt2 - f4) / f6;
            this.mStage1Duration = f18;
            float f19 = sqrt2 / f6;
            this.mStage2Duration = f19;
            if (sqrt2 < f7) {
                this.mType = "accelerate decelerate";
                this.mNumberOfStages = 2;
                this.mStage1Velocity = f4;
                this.mStage2Velocity = sqrt2;
                this.mStage3Velocity = 0.0f;
                this.mStage1Duration = f18;
                this.mStage2Duration = f19;
                this.mStage1EndPosition = ((f4 + sqrt2) * f18) / 2.0f;
                this.mStage2EndPosition = f5;
                return;
            }
            this.mType = "accelerate cruse decelerate";
            this.mNumberOfStages = 3;
            this.mStage1Velocity = f4;
            this.mStage2Velocity = f7;
            this.mStage3Velocity = f7;
            float f20 = (f7 - f4) / f6;
            this.mStage1Duration = f20;
            float f21 = f7 / f6;
            this.mStage3Duration = f21;
            float f22 = ((f4 + f7) * f20) / 2.0f;
            float f23 = (f21 * f7) / 2.0f;
            this.mStage2Duration = ((f5 - f22) - f23) / f7;
            this.mStage1EndPosition = f22;
            this.mStage2EndPosition = f5 - f23;
            this.mStage3EndPosition = f5;
        }
    }

    public void config(float f4, float f5, float f6, float f7, float f8, float f9) {
        boolean z4 = false;
        this.mDone = false;
        this.mStartPosition = f4;
        if (f4 > f5) {
            z4 = true;
        }
        this.mBackwards = z4;
        if (z4) {
            float f10 = f5;
            float f11 = -f6;
            float f12 = f4 - f10;
            float f13 = f9;
            float f14 = f7;
            setup(f11, f12, f8, f13, f14);
            return;
        }
        float f15 = f9;
        float f16 = f7;
        float f17 = f5 - f4;
        setup(f6, f17, f8, f15, f16);
    }

    public String debug(String str, float f4) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(str + " ===== " + this.mType + "\n");
        sb.append(str);
        if (this.mBackwards) {
            str2 = "backwards";
        } else {
            str2 = "forward ";
        }
        sb.append(str2);
        sb.append(" time = ");
        sb.append(f4);
        sb.append("  stages ");
        sb.append(this.mNumberOfStages);
        sb.append("\n");
        String str3 = sb.toString() + str + " dur " + this.mStage1Duration + " vel " + this.mStage1Velocity + " pos " + this.mStage1EndPosition + "\n";
        if (this.mNumberOfStages > 1) {
            str3 = str3 + str + " dur " + this.mStage2Duration + " vel " + this.mStage2Velocity + " pos " + this.mStage2EndPosition + "\n";
        }
        if (this.mNumberOfStages > 2) {
            str3 = str3 + str + " dur " + this.mStage3Duration + " vel " + this.mStage3Velocity + " pos " + this.mStage3EndPosition + "\n";
        }
        float f5 = this.mStage1Duration;
        if (f4 <= f5) {
            return str3 + str + "stage 0\n";
        }
        int i4 = this.mNumberOfStages;
        if (i4 == 1) {
            return str3 + str + "end stage 0\n";
        }
        float f6 = f4 - f5;
        float f7 = this.mStage2Duration;
        if (f6 < f7) {
            return str3 + str + " stage 1\n";
        } else if (i4 == 2) {
            return str3 + str + "end stage 1\n";
        } else if (f6 - f7 < this.mStage3Duration) {
            return str3 + str + " stage 2\n";
        } else {
            return str3 + str + " end stage 2\n";
        }
    }

    public float getInterpolation(float f4) {
        float calcY = calcY(f4);
        this.mLastPosition = calcY;
        this.mLastTime = f4;
        if (this.mBackwards) {
            return this.mStartPosition - calcY;
        }
        return this.mStartPosition + calcY;
    }

    public float getVelocity(float f4) {
        float f5 = this.mStage1Duration;
        if (f4 <= f5) {
            float f6 = this.mStage1Velocity;
            return f6 + (((this.mStage2Velocity - f6) * f4) / f5);
        }
        int i4 = this.mNumberOfStages;
        if (i4 == 1) {
            return 0.0f;
        }
        float f7 = f4 - f5;
        float f8 = this.mStage2Duration;
        if (f7 < f8) {
            float f9 = this.mStage2Velocity;
            return f9 + (((this.mStage3Velocity - f9) * f7) / f8);
        } else if (i4 == 2) {
            return 0.0f;
        } else {
            float f10 = f7 - f8;
            float f11 = this.mStage3Duration;
            if (f10 >= f11) {
                return 0.0f;
            }
            float f12 = this.mStage3Velocity;
            return f12 - ((f10 * f12) / f11);
        }
    }

    public boolean isStopped() {
        if (getVelocity() >= EPSILON || Math.abs(this.mStage3EndPosition - this.mLastPosition) >= EPSILON) {
            return false;
        }
        return true;
    }

    public static class Decelerate implements StopEngine {
        private float mAcceleration;
        private float mDestination;
        private boolean mDone = false;
        private float mDuration;
        private float mInitialPos;
        private float mInitialVelocity;
        private float mLastVelocity;

        public void config(float f4, float f5, float f6) {
            this.mDone = false;
            this.mDestination = f5;
            this.mInitialVelocity = f6;
            this.mInitialPos = f4;
            float f7 = (f5 - f4) / (f6 / 2.0f);
            this.mDuration = f7;
            this.mAcceleration = (-f6) / f7;
        }

        public String debug(String str, float f4) {
            return this.mDuration + " " + this.mLastVelocity;
        }

        public float getInterpolation(float f4) {
            if (f4 > this.mDuration) {
                this.mDone = true;
                return this.mDestination;
            }
            getVelocity(f4);
            return this.mInitialPos + ((this.mInitialVelocity + ((this.mAcceleration * f4) / 2.0f)) * f4);
        }

        public float getVelocity(float f4) {
            if (f4 > this.mDuration) {
                return 0.0f;
            }
            float f5 = this.mInitialVelocity + (this.mAcceleration * f4);
            this.mLastVelocity = f5;
            return f5;
        }

        public boolean isStopped() {
            return this.mDone;
        }

        public float getVelocity() {
            return this.mLastVelocity;
        }
    }

    public float getVelocity() {
        return this.mBackwards ? -getVelocity(this.mLastTime) : getVelocity(this.mLastTime);
    }
}
