package androidx.core.view;

import android.view.MotionEvent;
import androidx.annotation.NonNull;

class VelocityTrackerFallback {
    private static final long ASSUME_POINTER_STOPPED_MS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final long RANGE_MS = 100;
    private int mDataPointsBufferLastUsedIndex = 0;
    private int mDataPointsBufferSize = 0;
    private final long[] mEventTimes = new long[20];
    private float mLastComputedVelocity = 0.0f;
    private final float[] mMovements = new float[20];

    VelocityTrackerFallback() {
    }

    private void clear() {
        this.mDataPointsBufferSize = 0;
        this.mLastComputedVelocity = 0.0f;
    }

    private float getCurrentVelocity() {
        long[] jArr;
        long j4;
        int i4 = this.mDataPointsBufferSize;
        if (i4 < 2) {
            return 0.0f;
        }
        int i5 = this.mDataPointsBufferLastUsedIndex;
        int i6 = ((i5 + 20) - (i4 - 1)) % 20;
        long j5 = this.mEventTimes[i5];
        while (true) {
            jArr = this.mEventTimes;
            j4 = jArr[i6];
            if (j5 - j4 <= RANGE_MS) {
                break;
            }
            this.mDataPointsBufferSize--;
            i6 = (i6 + 1) % 20;
        }
        int i7 = this.mDataPointsBufferSize;
        if (i7 < 2) {
            return 0.0f;
        }
        if (i7 == 2) {
            int i8 = (i6 + 1) % 20;
            long j6 = jArr[i8];
            if (j4 == j6) {
                return 0.0f;
            }
            return this.mMovements[i8] / ((float) (j6 - j4));
        }
        int i9 = 0;
        float f4 = 0.0f;
        for (int i10 = 0; i10 < this.mDataPointsBufferSize - 1; i10++) {
            int i11 = i10 + i6;
            long[] jArr2 = this.mEventTimes;
            long j7 = jArr2[i11 % 20];
            int i12 = (i11 + 1) % 20;
            if (jArr2[i12] != j7) {
                i9++;
                float kineticEnergyToVelocity = kineticEnergyToVelocity(f4);
                float f5 = this.mMovements[i12] / ((float) (this.mEventTimes[i12] - j7));
                f4 += (f5 - kineticEnergyToVelocity) * Math.abs(f5);
                if (i9 == 1) {
                    f4 *= 0.5f;
                }
            }
        }
        return kineticEnergyToVelocity(f4);
    }

    private static float kineticEnergyToVelocity(float f4) {
        float f5;
        if (f4 < 0.0f) {
            f5 = -1.0f;
        } else {
            f5 = 1.0f;
        }
        return f5 * ((float) Math.sqrt((double) (Math.abs(f4) * 2.0f)));
    }

    /* access modifiers changed from: package-private */
    public void addMovement(@NonNull MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.mDataPointsBufferSize != 0 && eventTime - this.mEventTimes[this.mDataPointsBufferLastUsedIndex] > ASSUME_POINTER_STOPPED_MS) {
            clear();
        }
        int i4 = (this.mDataPointsBufferLastUsedIndex + 1) % 20;
        this.mDataPointsBufferLastUsedIndex = i4;
        int i5 = this.mDataPointsBufferSize;
        if (i5 != 20) {
            this.mDataPointsBufferSize = i5 + 1;
        }
        this.mMovements[i4] = motionEvent.getAxisValue(26);
        this.mEventTimes[this.mDataPointsBufferLastUsedIndex] = eventTime;
    }

    /* access modifiers changed from: package-private */
    public void computeCurrentVelocity(int i4) {
        computeCurrentVelocity(i4, Float.MAX_VALUE);
    }

    /* access modifiers changed from: package-private */
    public float getAxisVelocity(int i4) {
        if (i4 != 26) {
            return 0.0f;
        }
        return this.mLastComputedVelocity;
    }

    /* access modifiers changed from: package-private */
    public void computeCurrentVelocity(int i4, float f4) {
        float currentVelocity = getCurrentVelocity() * ((float) i4);
        this.mLastComputedVelocity = currentVelocity;
        if (currentVelocity < (-Math.abs(f4))) {
            this.mLastComputedVelocity = -Math.abs(f4);
        } else if (this.mLastComputedVelocity > Math.abs(f4)) {
            this.mLastComputedVelocity = Math.abs(f4);
        }
    }
}
