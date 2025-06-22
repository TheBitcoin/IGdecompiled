package com.mbridge.msdk.playercommon.exoplayer2.audio;

import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.nio.ShortBuffer;
import java.util.Arrays;

final class Sonic {
    private static final int AMDF_FREQUENCY = 4000;
    private static final int MAXIMUM_PITCH = 400;
    private static final int MINIMUM_PITCH = 65;
    private final int channelCount;
    private final short[] downSampleBuffer;
    private short[] inputBuffer;
    private int inputFrameCount;
    private final int inputSampleRateHz;
    private int maxDiff;
    private final int maxPeriod;
    private final int maxRequiredFrameCount;
    private int minDiff;
    private final int minPeriod;
    private int newRatePosition;
    private int oldRatePosition;
    private short[] outputBuffer;
    private int outputFrameCount;
    private final float pitch;
    private short[] pitchBuffer;
    private int pitchFrameCount;
    private int prevMinDiff;
    private int prevPeriod;
    private final float rate;
    private int remainingInputToCopyFrameCount;
    private final float speed;

    public Sonic(int i4, int i5, float f4, float f5, int i6) {
        this.inputSampleRateHz = i4;
        this.channelCount = i5;
        this.speed = f4;
        this.pitch = f5;
        this.rate = ((float) i4) / ((float) i6);
        this.minPeriod = i4 / MAXIMUM_PITCH;
        int i7 = i4 / 65;
        this.maxPeriod = i7;
        int i8 = i7 * 2;
        this.maxRequiredFrameCount = i8;
        this.downSampleBuffer = new short[i8];
        this.inputBuffer = new short[(i8 * i5)];
        this.outputBuffer = new short[(i8 * i5)];
        this.pitchBuffer = new short[(i8 * i5)];
    }

    private void adjustRate(float f4, int i4) {
        int i5;
        int i6;
        if (this.outputFrameCount != i4) {
            int i7 = this.inputSampleRateHz;
            int i8 = (int) (((float) i7) / f4);
            while (true) {
                if (i8 <= 16384 && i7 <= 16384) {
                    break;
                }
                i8 /= 2;
                i7 /= 2;
            }
            moveNewSamplesToPitchBuffer(i4);
            int i9 = 0;
            while (true) {
                int i10 = this.pitchFrameCount;
                boolean z4 = true;
                if (i9 < i10 - 1) {
                    while (true) {
                        i5 = this.oldRatePosition;
                        int i11 = (i5 + 1) * i8;
                        i6 = this.newRatePosition;
                        if (i11 <= i6 * i7) {
                            break;
                        }
                        this.outputBuffer = ensureSpaceForAdditionalFrames(this.outputBuffer, this.outputFrameCount, 1);
                        int i12 = 0;
                        while (true) {
                            int i13 = this.channelCount;
                            if (i12 >= i13) {
                                break;
                            }
                            this.outputBuffer[(this.outputFrameCount * i13) + i12] = interpolate(this.pitchBuffer, (i13 * i9) + i12, i7, i8);
                            i12++;
                        }
                        this.newRatePosition++;
                        this.outputFrameCount++;
                    }
                    int i14 = i5 + 1;
                    this.oldRatePosition = i14;
                    if (i14 == i7) {
                        this.oldRatePosition = 0;
                        if (i6 != i8) {
                            z4 = false;
                        }
                        Assertions.checkState(z4);
                        this.newRatePosition = 0;
                    }
                    i9++;
                } else {
                    removePitchFrames(i10 - 1);
                    return;
                }
            }
        }
    }

    private void changeSpeed(float f4) {
        int insertPitchPeriod;
        int i4 = this.inputFrameCount;
        if (i4 >= this.maxRequiredFrameCount) {
            int i5 = 0;
            do {
                if (this.remainingInputToCopyFrameCount > 0) {
                    insertPitchPeriod = copyInputToOutput(i5);
                } else {
                    int findPitchPeriod = findPitchPeriod(this.inputBuffer, i5);
                    if (((double) f4) > 1.0d) {
                        insertPitchPeriod = findPitchPeriod + skipPitchPeriod(this.inputBuffer, i5, f4, findPitchPeriod);
                    } else {
                        insertPitchPeriod = insertPitchPeriod(this.inputBuffer, i5, f4, findPitchPeriod);
                    }
                }
                i5 += insertPitchPeriod;
            } while (this.maxRequiredFrameCount + i5 <= i4);
            removeProcessedInputFrames(i5);
        }
    }

    private int copyInputToOutput(int i4) {
        int min = Math.min(this.maxRequiredFrameCount, this.remainingInputToCopyFrameCount);
        copyToOutput(this.inputBuffer, i4, min);
        this.remainingInputToCopyFrameCount -= min;
        return min;
    }

    private void copyToOutput(short[] sArr, int i4, int i5) {
        short[] ensureSpaceForAdditionalFrames = ensureSpaceForAdditionalFrames(this.outputBuffer, this.outputFrameCount, i5);
        this.outputBuffer = ensureSpaceForAdditionalFrames;
        int i6 = this.channelCount;
        System.arraycopy(sArr, i4 * i6, ensureSpaceForAdditionalFrames, this.outputFrameCount * i6, i6 * i5);
        this.outputFrameCount += i5;
    }

    private void downSampleInput(short[] sArr, int i4, int i5) {
        int i6 = this.maxRequiredFrameCount / i5;
        int i7 = this.channelCount;
        int i8 = i5 * i7;
        int i9 = i4 * i7;
        for (int i10 = 0; i10 < i6; i10++) {
            int i11 = 0;
            for (int i12 = 0; i12 < i8; i12++) {
                i11 += sArr[(i10 * i8) + i9 + i12];
            }
            this.downSampleBuffer[i10] = (short) (i11 / i8);
        }
    }

    private short[] ensureSpaceForAdditionalFrames(short[] sArr, int i4, int i5) {
        int length = sArr.length;
        int i6 = this.channelCount;
        int i7 = length / i6;
        if (i4 + i5 <= i7) {
            return sArr;
        }
        return Arrays.copyOf(sArr, (((i7 * 3) / 2) + i5) * i6);
    }

    private int findPitchPeriod(short[] sArr, int i4) {
        int i5;
        int i6;
        int i7;
        int i8 = this.inputSampleRateHz;
        if (i8 > AMDF_FREQUENCY) {
            i5 = i8 / AMDF_FREQUENCY;
        } else {
            i5 = 1;
        }
        if (this.channelCount == 1 && i5 == 1) {
            i6 = findPitchPeriodInRange(sArr, i4, this.minPeriod, this.maxPeriod);
        } else {
            downSampleInput(sArr, i4, i5);
            int findPitchPeriodInRange = findPitchPeriodInRange(this.downSampleBuffer, 0, this.minPeriod / i5, this.maxPeriod / i5);
            if (i5 != 1) {
                int i9 = findPitchPeriodInRange * i5;
                int i10 = i5 * 4;
                int i11 = i9 - i10;
                int i12 = i9 + i10;
                int i13 = this.minPeriod;
                if (i11 < i13) {
                    i11 = i13;
                }
                int i14 = this.maxPeriod;
                if (i12 > i14) {
                    i12 = i14;
                }
                if (this.channelCount == 1) {
                    i6 = findPitchPeriodInRange(sArr, i4, i11, i12);
                } else {
                    downSampleInput(sArr, i4, 1);
                    i6 = findPitchPeriodInRange(this.downSampleBuffer, 0, i11, i12);
                }
            } else {
                i6 = findPitchPeriodInRange;
            }
        }
        if (previousPeriodBetter(this.minDiff, this.maxDiff)) {
            i7 = this.prevPeriod;
        } else {
            i7 = i6;
        }
        this.prevMinDiff = this.minDiff;
        this.prevPeriod = i6;
        return i7;
    }

    private int findPitchPeriodInRange(short[] sArr, int i4, int i5, int i6) {
        int i7 = i4 * this.channelCount;
        int i8 = 255;
        int i9 = 1;
        int i10 = 0;
        int i11 = 0;
        while (i5 <= i6) {
            int i12 = 0;
            for (int i13 = 0; i13 < i5; i13++) {
                i12 += Math.abs(sArr[i7 + i13] - sArr[(i7 + i5) + i13]);
            }
            if (i12 * i10 < i9 * i5) {
                i10 = i5;
                i9 = i12;
            }
            if (i12 * i8 > i11 * i5) {
                i8 = i5;
                i11 = i12;
            }
            i5++;
        }
        this.minDiff = i9 / i10;
        this.maxDiff = i11 / i8;
        return i10;
    }

    private int insertPitchPeriod(short[] sArr, int i4, float f4, int i5) {
        int i6;
        if (f4 < 0.5f) {
            i6 = (int) ((((float) i5) * f4) / (1.0f - f4));
        } else {
            this.remainingInputToCopyFrameCount = (int) ((((float) i5) * ((2.0f * f4) - 1.0f)) / (1.0f - f4));
            i6 = i5;
        }
        int i7 = i5 + i6;
        short[] ensureSpaceForAdditionalFrames = ensureSpaceForAdditionalFrames(this.outputBuffer, this.outputFrameCount, i7);
        this.outputBuffer = ensureSpaceForAdditionalFrames;
        int i8 = this.channelCount;
        System.arraycopy(sArr, i4 * i8, ensureSpaceForAdditionalFrames, this.outputFrameCount * i8, i8 * i5);
        overlapAdd(i6, this.channelCount, this.outputBuffer, this.outputFrameCount + i5, sArr, i4 + i5, sArr, i4);
        this.outputFrameCount += i7;
        return i6;
    }

    private short interpolate(short[] sArr, int i4, int i5, int i6) {
        short s4 = sArr[i4];
        short s5 = sArr[i4 + this.channelCount];
        int i7 = this.newRatePosition * i5;
        int i8 = this.oldRatePosition;
        int i9 = i8 * i6;
        int i10 = (i8 + 1) * i6;
        int i11 = i10 - i7;
        int i12 = i10 - i9;
        return (short) (((s4 * i11) + ((i12 - i11) * s5)) / i12);
    }

    private void moveNewSamplesToPitchBuffer(int i4) {
        int i5 = this.outputFrameCount - i4;
        short[] ensureSpaceForAdditionalFrames = ensureSpaceForAdditionalFrames(this.pitchBuffer, this.pitchFrameCount, i5);
        this.pitchBuffer = ensureSpaceForAdditionalFrames;
        short[] sArr = this.outputBuffer;
        int i6 = this.channelCount;
        System.arraycopy(sArr, i4 * i6, ensureSpaceForAdditionalFrames, this.pitchFrameCount * i6, i6 * i5);
        this.outputFrameCount = i4;
        this.pitchFrameCount += i5;
    }

    private static void overlapAdd(int i4, int i5, short[] sArr, int i6, short[] sArr2, int i7, short[] sArr3, int i8) {
        for (int i9 = 0; i9 < i5; i9++) {
            int i10 = (i6 * i5) + i9;
            int i11 = (i8 * i5) + i9;
            int i12 = (i7 * i5) + i9;
            for (int i13 = 0; i13 < i4; i13++) {
                sArr[i10] = (short) (((sArr2[i12] * (i4 - i13)) + (sArr3[i11] * i13)) / i4);
                i10 += i5;
                i12 += i5;
                i11 += i5;
            }
        }
    }

    private boolean previousPeriodBetter(int i4, int i5) {
        if (i4 == 0 || this.prevPeriod == 0 || i5 > i4 * 3 || i4 * 2 <= this.prevMinDiff * 3) {
            return false;
        }
        return true;
    }

    private void processStreamInput() {
        int i4 = this.outputFrameCount;
        float f4 = this.speed;
        float f5 = this.pitch;
        float f6 = f4 / f5;
        float f7 = this.rate * f5;
        double d5 = (double) f6;
        if (d5 > 1.00001d || d5 < 0.99999d) {
            changeSpeed(f6);
        } else {
            copyToOutput(this.inputBuffer, 0, this.inputFrameCount);
            this.inputFrameCount = 0;
        }
        if (f7 != 1.0f) {
            adjustRate(f7, i4);
        }
    }

    private void removePitchFrames(int i4) {
        if (i4 != 0) {
            short[] sArr = this.pitchBuffer;
            int i5 = this.channelCount;
            System.arraycopy(sArr, i4 * i5, sArr, 0, (this.pitchFrameCount - i4) * i5);
            this.pitchFrameCount -= i4;
        }
    }

    private void removeProcessedInputFrames(int i4) {
        int i5 = this.inputFrameCount - i4;
        short[] sArr = this.inputBuffer;
        int i6 = this.channelCount;
        System.arraycopy(sArr, i4 * i6, sArr, 0, i6 * i5);
        this.inputFrameCount = i5;
    }

    private int skipPitchPeriod(short[] sArr, int i4, float f4, int i5) {
        int i6;
        if (f4 >= 2.0f) {
            i6 = (int) (((float) i5) / (f4 - 1.0f));
        } else {
            this.remainingInputToCopyFrameCount = (int) ((((float) i5) * (2.0f - f4)) / (f4 - 1.0f));
            i6 = i5;
        }
        short[] ensureSpaceForAdditionalFrames = ensureSpaceForAdditionalFrames(this.outputBuffer, this.outputFrameCount, i6);
        this.outputBuffer = ensureSpaceForAdditionalFrames;
        overlapAdd(i6, this.channelCount, ensureSpaceForAdditionalFrames, this.outputFrameCount, sArr, i4, sArr, i4 + i5);
        this.outputFrameCount += i6;
        return i6;
    }

    public final void flush() {
        this.inputFrameCount = 0;
        this.outputFrameCount = 0;
        this.pitchFrameCount = 0;
        this.oldRatePosition = 0;
        this.newRatePosition = 0;
        this.remainingInputToCopyFrameCount = 0;
        this.prevPeriod = 0;
        this.prevMinDiff = 0;
        this.minDiff = 0;
        this.maxDiff = 0;
    }

    public final int getFramesAvailable() {
        return this.outputFrameCount;
    }

    public final void getOutput(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.channelCount, this.outputFrameCount);
        shortBuffer.put(this.outputBuffer, 0, this.channelCount * min);
        int i4 = this.outputFrameCount - min;
        this.outputFrameCount = i4;
        short[] sArr = this.outputBuffer;
        int i5 = this.channelCount;
        System.arraycopy(sArr, min * i5, sArr, 0, i4 * i5);
    }

    public final void queueEndOfStream() {
        int i4;
        int i5 = this.inputFrameCount;
        float f4 = this.speed;
        float f5 = this.pitch;
        int i6 = this.outputFrameCount + ((int) ((((((float) i5) / (f4 / f5)) + ((float) this.pitchFrameCount)) / (this.rate * f5)) + 0.5f));
        this.inputBuffer = ensureSpaceForAdditionalFrames(this.inputBuffer, i5, (this.maxRequiredFrameCount * 2) + i5);
        int i7 = 0;
        while (true) {
            i4 = this.maxRequiredFrameCount;
            int i8 = this.channelCount;
            if (i7 >= i4 * 2 * i8) {
                break;
            }
            this.inputBuffer[(i8 * i5) + i7] = 0;
            i7++;
        }
        this.inputFrameCount += i4 * 2;
        processStreamInput();
        if (this.outputFrameCount > i6) {
            this.outputFrameCount = i6;
        }
        this.inputFrameCount = 0;
        this.remainingInputToCopyFrameCount = 0;
        this.pitchFrameCount = 0;
    }

    public final void queueInput(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i4 = this.channelCount;
        int i5 = remaining / i4;
        short[] ensureSpaceForAdditionalFrames = ensureSpaceForAdditionalFrames(this.inputBuffer, this.inputFrameCount, i5);
        this.inputBuffer = ensureSpaceForAdditionalFrames;
        shortBuffer.get(ensureSpaceForAdditionalFrames, this.inputFrameCount * this.channelCount, ((i4 * i5) * 2) / 2);
        this.inputFrameCount += i5;
        processStreamInput();
    }
}
