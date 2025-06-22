package com.mbridge.msdk.playercommon.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.PlaybackParameters;
import java.nio.ByteBuffer;

public interface AudioSink {
    public static final long CURRENT_POSITION_NOT_SET = Long.MIN_VALUE;

    public static final class ConfigurationException extends Exception {
        public ConfigurationException(Throwable th) {
            super(th);
        }

        public ConfigurationException(String str) {
            super(str);
        }
    }

    public static final class InitializationException extends Exception {
        public final int audioTrackState;

        public InitializationException(int i4, int i5, int i6, int i7) {
            super("AudioTrack init failed: " + i4 + ", Config(" + i5 + ", " + i6 + ", " + i7 + ")");
            this.audioTrackState = i4;
        }
    }

    public interface Listener {
        void onAudioSessionId(int i4);

        void onPositionDiscontinuity();

        void onUnderrun(int i4, long j4, long j5);
    }

    public static final class WriteException extends Exception {
        public final int errorCode;

        public WriteException(int i4) {
            super("AudioTrack write failed: " + i4);
            this.errorCode = i4;
        }
    }

    void configure(int i4, int i5, int i6, int i7, @Nullable int[] iArr, int i8, int i9) throws ConfigurationException;

    void disableTunneling();

    void enableTunnelingV21(int i4);

    long getCurrentPositionUs(boolean z4);

    PlaybackParameters getPlaybackParameters();

    boolean handleBuffer(ByteBuffer byteBuffer, long j4) throws InitializationException, WriteException;

    void handleDiscontinuity();

    boolean hasPendingData();

    boolean isEncodingSupported(int i4);

    boolean isEnded();

    void pause();

    void play();

    void playToEndOfStream() throws WriteException;

    void release();

    void reset();

    void setAudioAttributes(AudioAttributes audioAttributes);

    void setAudioSessionId(int i4);

    void setListener(Listener listener);

    PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters);

    void setVolume(float f4);
}
