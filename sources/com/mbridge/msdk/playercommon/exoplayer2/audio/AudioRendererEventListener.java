package com.mbridge.msdk.playercommon.exoplayer2.audio;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderCounters;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

public interface AudioRendererEventListener {

    public static final class EventDispatcher {
        @Nullable
        private final Handler handler;
        /* access modifiers changed from: private */
        @Nullable
        public final AudioRendererEventListener listener;

        public EventDispatcher(@Nullable Handler handler2, @Nullable AudioRendererEventListener audioRendererEventListener) {
            Handler handler3;
            if (audioRendererEventListener != null) {
                handler3 = (Handler) Assertions.checkNotNull(handler2);
            } else {
                handler3 = null;
            }
            this.handler = handler3;
            this.listener = audioRendererEventListener;
        }

        public final void audioSessionId(final int i4) {
            if (this.listener != null) {
                this.handler.post(new Runnable() {
                    public void run() {
                        EventDispatcher.this.listener.onAudioSessionId(i4);
                    }
                });
            }
        }

        public final void audioTrackUnderrun(int i4, long j4, long j5) {
            if (this.listener != null) {
                final int i5 = i4;
                final long j6 = j4;
                final long j7 = j5;
                this.handler.post(new Runnable() {
                    public void run() {
                        EventDispatcher.this.listener.onAudioSinkUnderrun(i5, j6, j7);
                    }
                });
            }
        }

        public final void decoderInitialized(String str, long j4, long j5) {
            if (this.listener != null) {
                final String str2 = str;
                final long j6 = j4;
                final long j7 = j5;
                this.handler.post(new Runnable() {
                    public void run() {
                        EventDispatcher.this.listener.onAudioDecoderInitialized(str2, j6, j7);
                    }
                });
            }
        }

        public final void disabled(final DecoderCounters decoderCounters) {
            if (this.listener != null) {
                this.handler.post(new Runnable() {
                    public void run() {
                        decoderCounters.ensureUpdated();
                        EventDispatcher.this.listener.onAudioDisabled(decoderCounters);
                    }
                });
            }
        }

        public final void enabled(final DecoderCounters decoderCounters) {
            if (this.listener != null) {
                this.handler.post(new Runnable() {
                    public void run() {
                        EventDispatcher.this.listener.onAudioEnabled(decoderCounters);
                    }
                });
            }
        }

        public final void inputFormatChanged(final Format format) {
            if (this.listener != null) {
                this.handler.post(new Runnable() {
                    public void run() {
                        EventDispatcher.this.listener.onAudioInputFormatChanged(format);
                    }
                });
            }
        }
    }

    void onAudioDecoderInitialized(String str, long j4, long j5);

    void onAudioDisabled(DecoderCounters decoderCounters);

    void onAudioEnabled(DecoderCounters decoderCounters);

    void onAudioInputFormatChanged(Format format);

    void onAudioSessionId(int i4);

    void onAudioSinkUnderrun(int i4, long j4, long j5);
}
