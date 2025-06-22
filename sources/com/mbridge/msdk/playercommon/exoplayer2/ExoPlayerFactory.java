package com.mbridge.msdk.playercommon.exoplayer2;

import android.content.Context;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.analytics.AnalyticsCollector;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager;
import com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelector;
import com.mbridge.msdk.playercommon.exoplayer2.util.Clock;

public final class ExoPlayerFactory {
    private ExoPlayerFactory() {
    }

    public static ExoPlayer newInstance(Renderer[] rendererArr, TrackSelector trackSelector) {
        return newInstance(rendererArr, trackSelector, new DefaultLoadControl());
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context, TrackSelector trackSelector, LoadControl loadControl) {
        return newSimpleInstance((RenderersFactory) new DefaultRenderersFactory(context), trackSelector, loadControl);
    }

    public static ExoPlayer newInstance(Renderer[] rendererArr, TrackSelector trackSelector, LoadControl loadControl) {
        return new ExoPlayerImpl(rendererArr, trackSelector, loadControl, Clock.DEFAULT);
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context, TrackSelector trackSelector, LoadControl loadControl, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager) {
        return newSimpleInstance((RenderersFactory) new DefaultRenderersFactory(context), trackSelector, loadControl, drmSessionManager);
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context, TrackSelector trackSelector, LoadControl loadControl, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, int i4) {
        return newSimpleInstance((RenderersFactory) new DefaultRenderersFactory(context, i4), trackSelector, loadControl, drmSessionManager);
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context, TrackSelector trackSelector, LoadControl loadControl, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, int i4, long j4) {
        return newSimpleInstance((RenderersFactory) new DefaultRenderersFactory(context, i4, j4), trackSelector, loadControl, drmSessionManager);
    }

    public static SimpleExoPlayer newSimpleInstance(Context context, TrackSelector trackSelector) {
        return newSimpleInstance((RenderersFactory) new DefaultRenderersFactory(context), trackSelector);
    }

    public static SimpleExoPlayer newSimpleInstance(RenderersFactory renderersFactory, TrackSelector trackSelector) {
        return newSimpleInstance(renderersFactory, trackSelector, (LoadControl) new DefaultLoadControl());
    }

    public static SimpleExoPlayer newSimpleInstance(RenderersFactory renderersFactory, TrackSelector trackSelector, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager) {
        return newSimpleInstance(renderersFactory, trackSelector, (LoadControl) new DefaultLoadControl(), drmSessionManager);
    }

    public static SimpleExoPlayer newSimpleInstance(RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl) {
        return new SimpleExoPlayer(renderersFactory, trackSelector, loadControl, (DrmSessionManager<FrameworkMediaCrypto>) null);
    }

    public static SimpleExoPlayer newSimpleInstance(RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager) {
        return new SimpleExoPlayer(renderersFactory, trackSelector, loadControl, drmSessionManager);
    }

    public static SimpleExoPlayer newSimpleInstance(RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, AnalyticsCollector.Factory factory) {
        return new SimpleExoPlayer(renderersFactory, trackSelector, loadControl, drmSessionManager, factory);
    }
}
