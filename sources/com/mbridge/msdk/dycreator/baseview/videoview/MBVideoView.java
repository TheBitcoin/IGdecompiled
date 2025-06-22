package com.mbridge.msdk.dycreator.baseview.videoview;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.dycreator.baseview.videoview.listener.VideoViewEventListener;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerFactory;
import com.mbridge.msdk.playercommon.exoplayer2.LoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.PlaybackParameters;
import com.mbridge.msdk.playercommon.exoplayer2.Player;
import com.mbridge.msdk.playercommon.exoplayer2.RenderersFactory;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.ConcatenatingMediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.ExtractorMediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.DefaultTrackSelector;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectionArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelector;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DefaultDataSourceFactory;

public class MBVideoView extends FrameLayout implements Player.EventListener {

    /* renamed from: a  reason: collision with root package name */
    private final String f12529a = "MBVideoView";

    /* renamed from: b  reason: collision with root package name */
    private final int f12530b = 1000;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ExoPlayer f12531c;

    /* renamed from: d  reason: collision with root package name */
    private long f12532d = 5000;

    /* renamed from: e  reason: collision with root package name */
    private String[] f12533e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public VideoViewEventListener f12534f;

    /* renamed from: g  reason: collision with root package name */
    private final SurfaceHolder.Callback f12535g = new SurfaceHolder.Callback() {
        public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
        }

        public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
            try {
                Player.VideoComponent videoComponent = MBVideoView.this.f12531c.getVideoComponent();
                if (videoComponent != null) {
                    videoComponent.setVideoSurfaceHolder(surfaceHolder);
                }
            } catch (Throwable th) {
                af.b("MBVideoView", th.getMessage());
            }
        }

        public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private final Runnable f12536h = new Runnable() {
        public void run() {
            if (MBVideoView.this.f12534f != null) {
                MBVideoView.this.f12534f.onBufferingFail("Buffering fail.");
            }
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private final Runnable f12537i = new Runnable() {
        public void run() {
            try {
                if (MBVideoView.this.f12531c != null && MBVideoView.this.isPlaying()) {
                    long currentPosition = MBVideoView.this.f12531c.getCurrentPosition();
                    long duration = MBVideoView.this.f12531c.getDuration();
                    int round = Math.round(((float) currentPosition) / 1000.0f);
                    int round2 = Math.round(((float) duration) / 1000.0f);
                    af.c("MBVideoView", "currentPosition:" + round + " duration:" + duration);
                    if (MBVideoView.this.f12534f != null) {
                        MBVideoView.this.f12534f.onPlayProgress(round, round2);
                    }
                    MBVideoView.this.getHandler().postDelayed(this, 1000);
                }
            } catch (Exception e5) {
                af.b("MBVideoView", e5.getMessage());
            }
        }
    };

    /* renamed from: com.mbridge.msdk.dycreator.baseview.videoview.MBVideoView$1  reason: invalid class name */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MBVideoView f12538a;

        public void run() {
            if (this.f12538a.f12534f != null) {
                this.f12538a.f12534f.onBufferingFail("Buffering timeout");
            }
        }
    }

    public MBVideoView(@NonNull Context context) {
        super(context);
    }

    public boolean isPlaying() {
        ExoPlayer exoPlayer = this.f12531c;
        if (exoPlayer != null && exoPlayer.getPlaybackState() == 3 && this.f12531c.getPlayWhenReady()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onLoadingChanged(boolean z4) {
    }

    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        af.b("MBVideoView", "onPlaybackParametersChanged : " + playbackParameters.speed);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPlayerError(com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException r4) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x0016
            int r0 = r4.type
            if (r0 == 0) goto L_0x0013
            r1 = 1
            if (r0 == r1) goto L_0x0010
            r1 = 2
            if (r0 == r1) goto L_0x000d
            goto L_0x0016
        L_0x000d:
            java.lang.String r0 = "Play error, because have a UnexpectedException."
            goto L_0x0018
        L_0x0010:
            java.lang.String r0 = "Play error, because have a RendererException."
            goto L_0x0018
        L_0x0013:
            java.lang.String r0 = "Play error, because have a SourceException."
            goto L_0x0018
        L_0x0016:
            java.lang.String r0 = "Play error and ExoPlayer have not message."
        L_0x0018:
            java.lang.Throwable r1 = r4.getCause()
            if (r1 == 0) goto L_0x0034
            java.lang.Throwable r1 = r4.getCause()
            java.lang.String r1 = r1.getMessage()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0034
            java.lang.Throwable r0 = r4.getCause()
            java.lang.String r0 = r0.getMessage()
        L_0x0034:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onPlayerError : "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "MBVideoView"
            com.mbridge.msdk.foundation.tools.af.b(r2, r1)
            com.mbridge.msdk.dycreator.baseview.videoview.listener.VideoViewEventListener r1 = r3.f12534f
            if (r1 == 0) goto L_0x0053
            int r4 = r4.type
            r1.onPlayerError(r4, r0)
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.baseview.videoview.MBVideoView.onPlayerError(com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException):void");
    }

    public void onPlayerStateChanged(boolean z4, int i4) {
        af.b("MBVideoView", "onPlaybackStateChanged : " + i4);
        if (i4 == 1) {
            af.b("MBVideoView", "onPlaybackStateChanged : IDLE");
        } else if (i4 == 2) {
            af.b("MBVideoView", "onPlaybackStateChanged : Buffering");
        } else if (i4 == 3) {
            af.b("MBVideoView", "onPlaybackStateChanged : READY");
        } else if (i4 == 4) {
            af.b("MBVideoView", "onPlaybackStateChanged : Ended : PLAY ENDED");
        }
    }

    public void onPositionDiscontinuity(int i4) {
        this.f12531c.getCurrentWindowIndex();
    }

    public void onRepeatModeChanged(int i4) {
    }

    public void onSeekProcessed() {
    }

    public void onShuffleModeEnabledChanged(boolean z4) {
    }

    public void onTimelineChanged(Timeline timeline, @Nullable Object obj, int i4) {
    }

    public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
    }

    public void pause() {
    }

    public void play() {
    }

    public void setVideoUrl(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            this.f12533e = strArr;
            try {
                this.f12531c = ExoPlayerFactory.newSimpleInstance((RenderersFactory) new DefaultRenderersFactory(getContext()), (TrackSelector) new DefaultTrackSelector(), (LoadControl) new DefaultLoadControl());
                ConcatenatingMediaSource concatenatingMediaSource = new ConcatenatingMediaSource();
                for (String parse : this.f12533e) {
                    concatenatingMediaSource.addMediaSource(new ExtractorMediaSource.Factory(new DefaultDataSourceFactory(getContext(), "MBridge_ExoPlayer")).createMediaSource(Uri.parse(parse)));
                }
                this.f12531c.setRepeatMode(0);
                this.f12531c.prepare(concatenatingMediaSource);
                this.f12531c.addListener(this);
            } catch (Throwable th) {
                af.b("MBVideoView", th.getMessage());
                th.toString();
            }
        }
    }

    public void setVideoViewEventLister(VideoViewEventListener videoViewEventListener) {
        this.f12534f = videoViewEventListener;
    }

    public void stop() {
    }

    public MBVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    @RequiresApi(api = 21)
    public MBVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
    }
}
