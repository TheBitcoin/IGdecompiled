package com.mbridge.msdk.playercommon.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor;
import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioRendererEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager;
import com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto;
import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecSelector;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.MetadataOutput;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.MetadataRenderer;
import com.mbridge.msdk.playercommon.exoplayer2.text.TextOutput;
import com.mbridge.msdk.playercommon.exoplayer2.text.TextRenderer;
import com.mbridge.msdk.playercommon.exoplayer2.video.MediaCodecVideoRenderer;
import com.mbridge.msdk.playercommon.exoplayer2.video.VideoRendererEventListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

public class DefaultRenderersFactory implements RenderersFactory {
    public static final long DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS = 5000;
    public static final int EXTENSION_RENDERER_MODE_OFF = 0;
    public static final int EXTENSION_RENDERER_MODE_ON = 1;
    public static final int EXTENSION_RENDERER_MODE_PREFER = 2;
    protected static final int MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY = 50;
    private static final String TAG = "DefaultRenderersFactory";
    private final long allowedVideoJoiningTimeMs;
    private final Context context;
    @Nullable
    private final DrmSessionManager<FrameworkMediaCrypto> drmSessionManager;
    private final int extensionRendererMode;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ExtensionRendererMode {
    }

    public DefaultRenderersFactory(Context context2) {
        this(context2, 0);
    }

    /* access modifiers changed from: protected */
    public AudioProcessor[] buildAudioProcessors() {
        return new AudioProcessor[0];
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0060, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0062, code lost:
        r10 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006b, code lost:
        throw new java.lang.RuntimeException("Error instantiating Opus extension", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0098, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009a, code lost:
        r11 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a3, code lost:
        throw new java.lang.RuntimeException("Error instantiating FLAC extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0060 A[ExcHandler: Exception (r0v16 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:6:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0098 A[ExcHandler: Exception (r0v10 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:19:0x006f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void buildAudioRenderers(android.content.Context r20, @androidx.annotation.Nullable com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager<com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto> r21, com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor[] r22, android.os.Handler r23, com.mbridge.msdk.playercommon.exoplayer2.audio.AudioRendererEventListener r24, int r25, java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.Renderer> r26) {
        /*
            r19 = this;
            r0 = r25
            r1 = r26
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            java.lang.String r6 = "DefaultRenderersFactory"
            java.lang.Class<com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor[]> r7 = com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor[].class
            java.lang.Class<com.mbridge.msdk.playercommon.exoplayer2.audio.AudioRendererEventListener> r8 = com.mbridge.msdk.playercommon.exoplayer2.audio.AudioRendererEventListener.class
            java.lang.Class<android.os.Handler> r9 = android.os.Handler.class
            com.mbridge.msdk.playercommon.exoplayer2.audio.MediaCodecAudioRenderer r10 = new com.mbridge.msdk.playercommon.exoplayer2.audio.MediaCodecAudioRenderer
            com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecSelector r12 = com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecSelector.DEFAULT
            r14 = 0
            com.mbridge.msdk.playercommon.exoplayer2.audio.AudioCapabilities r17 = com.mbridge.msdk.playercommon.exoplayer2.audio.AudioCapabilities.getCapabilities((android.content.Context) r20)
            r11 = r20
            r13 = r21
            r18 = r22
            r15 = r23
            r16 = r24
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            r1.add(r10)
            if (r0 != 0) goto L_0x002d
            goto L_0x00d7
        L_0x002d:
            int r10 = r1.size()
            if (r0 != r4) goto L_0x0035
            int r10 = r10 + -1
        L_0x0035:
            java.lang.String r0 = "com.mbridge.msdk.playercommon.exoplayer2.ext.opus.LibopusAudioRenderer"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0060 }
            java.lang.Class[] r11 = new java.lang.Class[r3]     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0060 }
            r11[r2] = r9     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0060 }
            r11[r5] = r8     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0060 }
            r11[r4] = r7     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0060 }
            java.lang.reflect.Constructor r0 = r0.getConstructor(r11)     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0060 }
            java.lang.Object[] r11 = new java.lang.Object[r3]     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0060 }
            r11[r2] = r23     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0060 }
            r11[r5] = r24     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0060 }
            r11[r4] = r22     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0060 }
            java.lang.Object r0 = r0.newInstance(r11)     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0060 }
            com.mbridge.msdk.playercommon.exoplayer2.Renderer r0 = (com.mbridge.msdk.playercommon.exoplayer2.Renderer) r0     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0060 }
            int r11 = r10 + 1
            r1.add(r10, r0)     // Catch:{ ClassNotFoundException -> 0x0062, Exception -> 0x0060 }
            java.lang.String r0 = "Loaded LibopusAudioRenderer."
            android.util.Log.i(r6, r0)     // Catch:{ ClassNotFoundException -> 0x0062, Exception -> 0x0060 }
            goto L_0x006d
        L_0x0060:
            r0 = move-exception
            goto L_0x0064
        L_0x0062:
            r10 = r11
            goto L_0x006c
        L_0x0064:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating Opus extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x006c:
            r11 = r10
        L_0x006d:
            java.lang.String r0 = "com.mbridge.msdk.playercommon.exoplayer2.ext.flac.LibflacAudioRenderer"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x0098 }
            java.lang.Class[] r10 = new java.lang.Class[r3]     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x0098 }
            r10[r2] = r9     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x0098 }
            r10[r5] = r8     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x0098 }
            r10[r4] = r7     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x0098 }
            java.lang.reflect.Constructor r0 = r0.getConstructor(r10)     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x0098 }
            java.lang.Object[] r10 = new java.lang.Object[r3]     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x0098 }
            r10[r2] = r23     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x0098 }
            r10[r5] = r24     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x0098 }
            r10[r4] = r22     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x0098 }
            java.lang.Object r0 = r0.newInstance(r10)     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x0098 }
            com.mbridge.msdk.playercommon.exoplayer2.Renderer r0 = (com.mbridge.msdk.playercommon.exoplayer2.Renderer) r0     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x0098 }
            int r10 = r11 + 1
            r1.add(r11, r0)     // Catch:{ ClassNotFoundException -> 0x009a, Exception -> 0x0098 }
            java.lang.String r0 = "Loaded LibflacAudioRenderer."
            android.util.Log.i(r6, r0)     // Catch:{ ClassNotFoundException -> 0x009a, Exception -> 0x0098 }
            goto L_0x00a5
        L_0x0098:
            r0 = move-exception
            goto L_0x009c
        L_0x009a:
            r11 = r10
            goto L_0x00a4
        L_0x009c:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating FLAC extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x00a4:
            r10 = r11
        L_0x00a5:
            java.lang.String r0 = "com.mbridge.msdk.playercommon.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            java.lang.Class[] r11 = new java.lang.Class[r3]     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            r11[r2] = r9     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            r11[r5] = r8     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            r11[r4] = r7     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            java.lang.reflect.Constructor r0 = r0.getConstructor(r11)     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            r3[r2] = r23     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            r3[r5] = r24     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            r3[r4] = r22     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            java.lang.Object r0 = r0.newInstance(r3)     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            com.mbridge.msdk.playercommon.exoplayer2.Renderer r0 = (com.mbridge.msdk.playercommon.exoplayer2.Renderer) r0     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            r1.add(r10, r0)     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            java.lang.String r0 = "Loaded FfmpegAudioRenderer."
            android.util.Log.i(r6, r0)     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            goto L_0x00d7
        L_0x00ce:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating FFmpeg extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x00d7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory.buildAudioRenderers(android.content.Context, com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager, com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor[], android.os.Handler, com.mbridge.msdk.playercommon.exoplayer2.audio.AudioRendererEventListener, int, java.util.ArrayList):void");
    }

    /* access modifiers changed from: protected */
    public void buildMetadataRenderers(Context context2, MetadataOutput metadataOutput, Looper looper, int i4, ArrayList<Renderer> arrayList) {
        arrayList.add(new MetadataRenderer(metadataOutput, looper));
    }

    /* access modifiers changed from: protected */
    public void buildMiscellaneousRenderers(Context context2, Handler handler, int i4, ArrayList<Renderer> arrayList) {
    }

    /* access modifiers changed from: protected */
    public void buildTextRenderers(Context context2, TextOutput textOutput, Looper looper, int i4, ArrayList<Renderer> arrayList) {
        arrayList.add(new TextRenderer(textOutput, looper));
    }

    /* access modifiers changed from: protected */
    public void buildVideoRenderers(Context context2, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2, long j4, Handler handler, VideoRendererEventListener videoRendererEventListener, int i4, ArrayList<Renderer> arrayList) {
        int i5 = i4;
        ArrayList<Renderer> arrayList2 = arrayList;
        arrayList2.add(new MediaCodecVideoRenderer(context2, MediaCodecSelector.DEFAULT, j4, drmSessionManager2, false, handler, videoRendererEventListener, 50));
        if (i5 != 0) {
            int size = arrayList2.size();
            if (i5 == 2) {
                size--;
            }
            try {
                arrayList2.add(size, (Renderer) Class.forName("com.mbridge.msdk.playercommon.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(new Class[]{Boolean.TYPE, Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE}).newInstance(new Object[]{Boolean.TRUE, Long.valueOf(j4), handler, videoRendererEventListener, 50}));
                Log.i(TAG, "Loaded LibvpxVideoRenderer.");
            } catch (ClassNotFoundException unused) {
            } catch (Exception e5) {
                throw new RuntimeException("Error instantiating VP9 extension", e5);
            }
        }
    }

    public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2) {
        if (drmSessionManager2 == null) {
            drmSessionManager2 = this.drmSessionManager;
        }
        DrmSessionManager<FrameworkMediaCrypto> drmSessionManager3 = drmSessionManager2;
        ArrayList arrayList = new ArrayList();
        Handler handler2 = handler;
        buildVideoRenderers(this.context, drmSessionManager3, this.allowedVideoJoiningTimeMs, handler2, videoRendererEventListener, this.extensionRendererMode, arrayList);
        Handler handler3 = handler2;
        buildAudioRenderers(this.context, drmSessionManager3, buildAudioProcessors(), handler3, audioRendererEventListener, this.extensionRendererMode, arrayList);
        Handler handler4 = handler3;
        buildTextRenderers(this.context, textOutput, handler4.getLooper(), this.extensionRendererMode, arrayList);
        buildMetadataRenderers(this.context, metadataOutput, handler4.getLooper(), this.extensionRendererMode, arrayList);
        buildMiscellaneousRenderers(this.context, handler4, this.extensionRendererMode, arrayList);
        return (Renderer[]) arrayList.toArray(new Renderer[arrayList.size()]);
    }

    @Deprecated
    public DefaultRenderersFactory(Context context2, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2) {
        this(context2, drmSessionManager2, 0);
    }

    public DefaultRenderersFactory(Context context2, int i4) {
        this(context2, (DrmSessionManager<FrameworkMediaCrypto>) null, i4, 5000);
    }

    @Deprecated
    public DefaultRenderersFactory(Context context2, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2, int i4) {
        this(context2, drmSessionManager2, i4, 5000);
    }

    public DefaultRenderersFactory(Context context2, int i4, long j4) {
        this(context2, (DrmSessionManager<FrameworkMediaCrypto>) null, i4, j4);
    }

    @Deprecated
    public DefaultRenderersFactory(Context context2, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2, int i4, long j4) {
        this.context = context2;
        this.extensionRendererMode = i4;
        this.allowedVideoJoiningTimeMs = j4;
        this.drmSessionManager = drmSessionManager2;
    }
}
