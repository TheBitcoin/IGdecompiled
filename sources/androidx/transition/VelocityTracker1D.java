package androidx.transition;

import java.util.Arrays;

class VelocityTracker1D {
    private static final int ASSUME_POINTER_MOVE_STOPPED_MILLIS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final int HORIZON_MILLIS = 100;
    private float[] mDataSamples = new float[20];
    private int mIndex = 0;
    private long[] mTimeSamples;

    VelocityTracker1D() {
        long[] jArr = new long[20];
        this.mTimeSamples = jArr;
        Arrays.fill(jArr, Long.MIN_VALUE);
    }

    private float kineticEnergyToVelocity(float f4) {
        return (float) (((double) Math.signum(f4)) * Math.sqrt((double) (Math.abs(f4) * 2.0f)));
    }

    public void addDataPoint(long j4, float f4) {
        int i4 = (this.mIndex + 1) % 20;
        this.mIndex = i4;
        this.mTimeSamples[i4] = j4;
        this.mDataSamples[i4] = f4;
    }

    /* access modifiers changed from: package-private */
    public float calculateVelocity() {
        float kineticEnergyToVelocity;
        int i4;
        int i5 = this.mIndex;
        if (i5 == 0 && this.mTimeSamples[i5] == Long.MIN_VALUE) {
            return 0.0f;
        }
        long j4 = this.mTimeSamples[i5];
        int i6 = 0;
        long j5 = j4;
        while (true) {
            long j6 = this.mTimeSamples[i5];
            if (j6 != Long.MIN_VALUE) {
                float abs = (float) Math.abs(j6 - j5);
                if (((float) (j4 - j6)) > 100.0f || abs > 40.0f) {
                    break;
                }
                if (i5 == 0) {
                    i5 = 20;
                }
                i5--;
                i6++;
                if (i6 >= 20) {
                    break;
                }
                j5 = j6;
            } else {
                break;
            }
        }
        if (i6 < 2) {
            return 0.0f;
        }
        if (i6 == 2) {
            int i7 = this.mIndex;
            if (i7 == 0) {
                i4 = 19;
            } else {
                i4 = i7 - 1;
            }
            long[] jArr = this.mTimeSamples;
            float f4 = (float) (jArr[i7] - jArr[i4]);
            if (f4 == 0.0f) {
                return 0.0f;
            }
            float[] fArr = this.mDataSamples;
            kineticEnergyToVelocity = (fArr[i7] - fArr[i4]) / f4;
        } else {
            int i8 = this.mIndex;
            int i9 = ((i8 - i6) + 21) % 20;
            int i10 = (i8 + 21) % 20;
            long j7 = this.mTimeSamples[i9];
            float f5 = this.mDataSamples[i9];
            int i11 = i9 + 1;
            float f6 = 0.0f;
            for (int i12 = i11 % 20; i12 != i10; i12 = (i12 + 1) % 20) {
                long j8 = this.mTimeSamples[i12];
                float f7 = (float) (j8 - j7);
                if (f7 != 0.0f) {
                    float f8 = this.mDataSamples[i12];
                    float f9 = (f8 - f5) / f7;
                    f6 += (f9 - kineticEnergyToVelocity(f6)) * Math.abs(f9);
                    if (i12 == i11) {
                        f6 *= 0.5f;
                    }
                    f5 = f8;
                    j7 = j8;
                }
            }
            kineticEnergyToVelocity = kineticEnergyToVelocity(f6);
        }
        return kineticEnergyToVelocity * 1000.0f;
    }

    public void resetTracking() {
        this.mIndex = 0;
        Arrays.fill(this.mTimeSamples, Long.MIN_VALUE);
        Arrays.fill(this.mDataSamples, 0.0f);
    }
}
