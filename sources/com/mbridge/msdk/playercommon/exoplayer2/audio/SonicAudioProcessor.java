package com.mbridge.msdk.playercommon.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class SonicAudioProcessor implements AudioProcessor {
    private static final float CLOSE_THRESHOLD = 0.01f;
    public static final float MAXIMUM_PITCH = 8.0f;
    public static final float MAXIMUM_SPEED = 8.0f;
    public static final float MINIMUM_PITCH = 0.1f;
    public static final float MINIMUM_SPEED = 0.1f;
    private static final int MIN_BYTES_FOR_SPEEDUP_CALCULATION = 1024;
    public static final int SAMPLE_RATE_NO_CHANGE = -1;
    private ByteBuffer buffer;
    private int channelCount = -1;
    private long inputBytes;
    private boolean inputEnded;
    private ByteBuffer outputBuffer;
    private long outputBytes;
    private int outputSampleRateHz = -1;
    private int pendingOutputSampleRateHz;
    private float pitch = 1.0f;
    private int sampleRateHz = -1;
    private ShortBuffer shortBuffer;
    @Nullable
    private Sonic sonic;
    private float speed = 1.0f;

    public SonicAudioProcessor() {
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.buffer = byteBuffer;
        this.shortBuffer = byteBuffer.asShortBuffer();
        this.outputBuffer = byteBuffer;
        this.pendingOutputSampleRateHz = -1;
    }

    public final boolean configure(int i4, int i5, int i6) throws AudioProcessor.UnhandledFormatException {
        if (i6 == 2) {
            int i7 = this.pendingOutputSampleRateHz;
            if (i7 == -1) {
                i7 = i4;
            }
            if (this.sampleRateHz == i4 && this.channelCount == i5 && this.outputSampleRateHz == i7) {
                return false;
            }
            this.sampleRateHz = i4;
            this.channelCount = i5;
            this.outputSampleRateHz = i7;
            this.sonic = null;
            return true;
        }
        throw new AudioProcessor.UnhandledFormatException(i4, i5, i6);
    }

    public final void flush() {
        if (isActive()) {
            Sonic sonic2 = this.sonic;
            if (sonic2 == null) {
                this.sonic = new Sonic(this.sampleRateHz, this.channelCount, this.speed, this.pitch, this.outputSampleRateHz);
            } else {
                sonic2.flush();
            }
        }
        this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        this.inputBytes = 0;
        this.outputBytes = 0;
        this.inputEnded = false;
    }

    public final ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.outputBuffer;
        this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        return byteBuffer;
    }

    public final int getOutputChannelCount() {
        return this.channelCount;
    }

    public final int getOutputEncoding() {
        return 2;
    }

    public final int getOutputSampleRateHz() {
        return this.outputSampleRateHz;
    }

    public final boolean isActive() {
        if (this.sampleRateHz == -1) {
            return false;
        }
        if (Math.abs(this.speed - 1.0f) >= CLOSE_THRESHOLD || Math.abs(this.pitch - 1.0f) >= CLOSE_THRESHOLD || this.outputSampleRateHz != this.sampleRateHz) {
            return true;
        }
        return false;
    }

    public final boolean isEnded() {
        if (!this.inputEnded) {
            return false;
        }
        Sonic sonic2 = this.sonic;
        if (sonic2 == null || sonic2.getFramesAvailable() == 0) {
            return true;
        }
        return false;
    }

    public final void queueEndOfStream() {
        boolean z4;
        if (this.sonic != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        this.sonic.queueEndOfStream();
        this.inputEnded = true;
    }

    public final void queueInput(ByteBuffer byteBuffer) {
        boolean z4;
        if (this.sonic != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.inputBytes += (long) remaining;
            this.sonic.queueInput(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int framesAvailable = this.sonic.getFramesAvailable() * this.channelCount * 2;
        if (framesAvailable > 0) {
            if (this.buffer.capacity() < framesAvailable) {
                ByteBuffer order = ByteBuffer.allocateDirect(framesAvailable).order(ByteOrder.nativeOrder());
                this.buffer = order;
                this.shortBuffer = order.asShortBuffer();
            } else {
                this.buffer.clear();
                this.shortBuffer.clear();
            }
            this.sonic.getOutput(this.shortBuffer);
            this.outputBytes += (long) framesAvailable;
            this.buffer.limit(framesAvailable);
            this.outputBuffer = this.buffer;
        }
    }

    public final void reset() {
        this.speed = 1.0f;
        this.pitch = 1.0f;
        this.channelCount = -1;
        this.sampleRateHz = -1;
        this.outputSampleRateHz = -1;
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.buffer = byteBuffer;
        this.shortBuffer = byteBuffer.asShortBuffer();
        this.outputBuffer = byteBuffer;
        this.pendingOutputSampleRateHz = -1;
        this.sonic = null;
        this.inputBytes = 0;
        this.outputBytes = 0;
        this.inputEnded = false;
    }

    public final long scaleDurationForSpeedup(long j4) {
        long j5 = this.outputBytes;
        if (j5 >= 1024) {
            int i4 = this.outputSampleRateHz;
            int i5 = this.sampleRateHz;
            if (i4 == i5) {
                return Util.scaleLargeTimestamp(j4, this.inputBytes, j5);
            }
            return Util.scaleLargeTimestamp(j4, this.inputBytes * ((long) i4), j5 * ((long) i5));
        }
        return (long) (((double) this.speed) * ((double) j4));
    }

    public final void setOutputSampleRateHz(int i4) {
        this.pendingOutputSampleRateHz = i4;
    }

    public final float setPitch(float f4) {
        float constrainValue = Util.constrainValue(f4, 0.1f, 8.0f);
        if (this.pitch != constrainValue) {
            this.pitch = constrainValue;
            this.sonic = null;
        }
        flush();
        return constrainValue;
    }

    public final float setSpeed(float f4) {
        float constrainValue = Util.constrainValue(f4, 0.1f, 8.0f);
        if (this.speed != constrainValue) {
            this.speed = constrainValue;
            this.sonic = null;
        }
        flush();
        return constrainValue;
    }
}
