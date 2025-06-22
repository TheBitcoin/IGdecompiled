package androidx.constraintlayout.core.motion.utils;

import java.io.PrintStream;

public class SpringStopEngine implements StopEngine {
    private static final double UNSET = Double.MAX_VALUE;
    private int mBoundaryMode = 0;
    double mDamping = 0.5d;
    private boolean mInitialized = false;
    private float mLastTime;
    private double mLastVelocity;
    private float mMass;
    private float mPos;
    private double mStiffness;
    private float mStopThreshold;
    private double mTargetPos;
    private float mV;

    private void compute(double d5) {
        if (d5 > 0.0d) {
            double d6 = this.mStiffness;
            double d7 = this.mDamping;
            int sqrt = (int) ((9.0d / ((Math.sqrt(d6 / ((double) this.mMass)) * d5) * 4.0d)) + 1.0d);
            double d8 = d5 / ((double) sqrt);
            int i4 = 0;
            while (i4 < sqrt) {
                float f4 = this.mPos;
                double d9 = this.mTargetPos;
                float f5 = this.mV;
                double d10 = d6;
                float f6 = this.mMass;
                double d11 = d7;
                double d12 = ((double) f5) + ((((((-d6) * (((double) f4) - d9)) - (((double) f5) * d7)) / ((double) f6)) * d8) / 2.0d);
                double d13 = ((((-((((double) f4) + ((d8 * d12) / 2.0d)) - d9)) * d10) - (d12 * d11)) / ((double) f6)) * d8;
                double d14 = ((double) f5) + (d13 / 2.0d);
                float f7 = f5 + ((float) d13);
                this.mV = f7;
                float f8 = f4 + ((float) (d14 * d8));
                this.mPos = f8;
                int i5 = this.mBoundaryMode;
                if (i5 > 0) {
                    if (f8 < 0.0f && (i5 & 1) == 1) {
                        this.mPos = -f8;
                        this.mV = -f7;
                    }
                    float f9 = this.mPos;
                    if (f9 > 1.0f && (i5 & 2) == 2) {
                        this.mPos = 2.0f - f9;
                        this.mV = -this.mV;
                    }
                }
                i4++;
                d6 = d10;
                d7 = d11;
            }
        }
    }

    public String debug(String str, float f4) {
        return null;
    }

    public float getAcceleration() {
        double d5 = this.mStiffness;
        return ((float) (((-d5) * (((double) this.mPos) - this.mTargetPos)) - (this.mDamping * ((double) this.mV)))) / this.mMass;
    }

    public float getInterpolation(float f4) {
        compute((double) (f4 - this.mLastTime));
        this.mLastTime = f4;
        if (isStopped()) {
            this.mPos = (float) this.mTargetPos;
        }
        return this.mPos;
    }

    public float getVelocity() {
        return 0.0f;
    }

    public boolean isStopped() {
        double d5 = ((double) this.mPos) - this.mTargetPos;
        double d6 = this.mStiffness;
        double d7 = (double) this.mV;
        if (Math.sqrt((((d7 * d7) * ((double) this.mMass)) + ((d6 * d5) * d5)) / d6) <= ((double) this.mStopThreshold)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void log(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        PrintStream printStream = System.out;
        printStream.println((".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "() ") + str);
    }

    public void springConfig(float f4, float f5, float f6, float f7, float f8, float f9, float f10, int i4) {
        this.mTargetPos = (double) f5;
        this.mDamping = (double) f9;
        this.mInitialized = false;
        this.mPos = f4;
        this.mLastVelocity = (double) f6;
        this.mStiffness = (double) f8;
        this.mMass = f7;
        this.mStopThreshold = f10;
        this.mBoundaryMode = i4;
        this.mLastTime = 0.0f;
    }

    public float getVelocity(float f4) {
        return this.mV;
    }
}
