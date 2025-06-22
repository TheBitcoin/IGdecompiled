package com.mbridge.msdk.playercommon;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.d.b;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import org.json.JSONException;
import org.json.JSONObject;
import r1.C2216b;

public class PlayerView extends LinearLayout {
    public static final String TAG = "PlayerView";
    private boolean hadOMPause = false;
    /* access modifiers changed from: private */
    public boolean isBTVideo = false;
    /* access modifiers changed from: private */
    public boolean isBTVideoPlaying = false;
    private boolean mHasReportedData = false;
    private boolean mInitState = false;
    /* access modifiers changed from: private */
    public boolean mIsCovered = false;
    private boolean mIsFirstCreateHolder = true;
    /* access modifiers changed from: private */
    public boolean mIsNeedToRepeatPrepare = false;
    /* access modifiers changed from: private */
    public boolean mIsSurfaceHolderDestoryed = false;
    private LinearLayout mLlSurContainer;
    private LinearLayout mLoadingView;
    private String mPlayUrl;
    /* access modifiers changed from: private */
    public SurfaceHolder mSurfaceHolder;
    /* access modifiers changed from: private */
    public VideoFeedsPlayer mVideoFeedsPlayer;
    private OnPlayerViewVisibleListener onPlayerViewVisibleListener;
    protected int orientation = 1;
    private C2216b videoEvents;
    protected float xInScreen;
    protected float yInScreen;

    private class MySurfaceHoldeCallback implements SurfaceHolder.Callback {
        private MySurfaceHoldeCallback() {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
            try {
                af.c(PlayerView.TAG, "surfaceChanged");
                if (PlayerView.this.mIsSurfaceHolderDestoryed && !PlayerView.this.mIsCovered && !PlayerView.this.isComplete() && !PlayerView.this.isBTVideo && !b.f12876c) {
                    if (PlayerView.this.mVideoFeedsPlayer.hasPrepare()) {
                        af.c(PlayerView.TAG, "surfaceChanged  start====");
                        PlayerView.this.resumeStart();
                    } else {
                        af.c(PlayerView.TAG, "surfaceChanged  PLAY====");
                        PlayerView.this.playVideo(0);
                        PlayerView.this.resumeOMSDK();
                    }
                    if (PlayerView.this.isBTVideo) {
                        if (PlayerView.this.isBTVideoPlaying) {
                            if (!PlayerView.this.mVideoFeedsPlayer.hasPrepare()) {
                                PlayerView.this.mVideoFeedsPlayer.prepare();
                            }
                            PlayerView.this.mVideoFeedsPlayer.start(false);
                            PlayerView.this.resumeOMSDK();
                        } else {
                            PlayerView.this.pause();
                        }
                    }
                }
                boolean unused = PlayerView.this.mIsSurfaceHolderDestoryed = false;
            } catch (Exception e5) {
                af.b(PlayerView.TAG, e5.getMessage());
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            try {
                af.c(PlayerView.TAG, "surfaceCreated");
                if (PlayerView.this.mVideoFeedsPlayer != null && surfaceHolder != null) {
                    SurfaceHolder unused = PlayerView.this.mSurfaceHolder = surfaceHolder;
                    PlayerView.this.mVideoFeedsPlayer.setDisplay(surfaceHolder);
                }
            } catch (Exception e5) {
                af.b(PlayerView.TAG, e5.getMessage());
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            try {
                af.c(PlayerView.TAG, "surfaceDestroyed ");
                boolean unused = PlayerView.this.mIsSurfaceHolderDestoryed = true;
                boolean unused2 = PlayerView.this.mIsNeedToRepeatPrepare = true;
                PlayerView.this.mVideoFeedsPlayer.pause();
                PlayerView.this.pauseOmsdk();
            } catch (Exception e5) {
                af.b(PlayerView.TAG, e5.getMessage());
            }
        }
    }

    public interface OnPlayerViewVisibleListener {
        void playerViewVisibleCallback();
    }

    public PlayerView(Context context) {
        super(context);
        init();
    }

    private void init() {
        try {
            initView();
            initPlayer();
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    private void initPlayer() {
        this.mVideoFeedsPlayer = new VideoFeedsPlayer();
    }

    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(x.a(getContext(), "mbridge_playercommon_player_view", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
        if (inflate != null) {
            this.mLlSurContainer = (LinearLayout) inflate.findViewById(x.a(getContext(), "mbridge_playercommon_ll_sur_container", "id"));
            this.mLoadingView = (LinearLayout) inflate.findViewById(x.a(getContext(), "mbridge_playercommon_ll_loading", "id"));
            addSurfaceView();
            addView(inflate, -1, -1);
        }
    }

    public void addSurfaceView() {
        try {
            af.c(TAG, "addSurfaceView");
            SurfaceView surfaceView = new SurfaceView(getContext().getApplicationContext());
            SurfaceHolder holder = surfaceView.getHolder();
            this.mSurfaceHolder = holder;
            holder.setType(3);
            this.mSurfaceHolder.setKeepScreenOn(true);
            this.mSurfaceHolder.addCallback(new MySurfaceHoldeCallback());
            this.mLlSurContainer.addView(surfaceView, -1, -1);
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public JSONObject buildH5JsonObject(int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(a.f13134h, ak.b(c.m().c(), this.xInScreen));
                jSONObject2.put(a.f13135i, ak.b(c.m().c(), this.yInScreen));
                jSONObject2.put(a.f13139m, i4);
                try {
                    this.orientation = getContext().getResources().getConfiguration().orientation;
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                jSONObject2.put(a.f13137k, this.orientation);
                jSONObject2.put(a.f13138l, (double) ak.d(getContext()));
                return jSONObject2;
            } catch (JSONException e6) {
                e = e6;
                jSONObject = jSONObject2;
                e.printStackTrace();
                return jSONObject;
            }
        } catch (JSONException e7) {
            e = e7;
            e.printStackTrace();
            return jSONObject;
        }
    }

    public void closeSound() {
        VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            videoFeedsPlayer.closeSound();
        }
    }

    public void coverUnlockResume() {
        try {
            this.mVideoFeedsPlayer.setIsFrontDesk(true);
            if (this.mVideoFeedsPlayer != null) {
                af.c(TAG, "coverUnlockResume========");
                if (this.mVideoFeedsPlayer.hasPrepare()) {
                    if (!this.mIsNeedToRepeatPrepare) {
                        start(true);
                        return;
                    }
                }
                playVideo(0);
            }
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }

    public int getCurPosition() {
        try {
            VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer != null) {
                return videoFeedsPlayer.getCurPosition();
            }
            return 0;
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
            return 0;
        }
    }

    public int getDuration() {
        VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            return videoFeedsPlayer.getDuration();
        }
        return 0;
    }

    public C2216b getVideoEvents() {
        return this.videoEvents;
    }

    public float getVolume() {
        VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            return videoFeedsPlayer.getVolume();
        }
        return 0.0f;
    }

    public void initBufferIngParam(int i4) {
        VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            videoFeedsPlayer.initBufferIngParam(i4);
        }
    }

    public boolean initVFPData(String str, String str2, VideoPlayerStatusListener videoPlayerStatusListener) {
        if (TextUtils.isEmpty(str)) {
            af.c(TAG, "playUrl==null");
            return false;
        }
        this.mPlayUrl = str;
        this.mVideoFeedsPlayer.initPlayer(getContext(), this.mLoadingView, str, videoPlayerStatusListener);
        this.mInitState = true;
        return true;
    }

    public boolean isComplete() {
        try {
            VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer == null || !videoFeedsPlayer.isComplete()) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            af.b(TAG, th.getMessage(), th);
            return false;
        }
    }

    public boolean isPlayIng() {
        try {
            VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer != null) {
                return videoFeedsPlayer.isPlayIng();
            }
            return false;
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
            return false;
        }
    }

    public boolean isSilent() {
        return this.mVideoFeedsPlayer.isSilent();
    }

    public void justSeekTo(int i4) {
        try {
            VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer != null) {
                videoFeedsPlayer.justSeekTo(i4);
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.xInScreen = motionEvent.getRawX();
        this.yInScreen = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onPause() {
        try {
            pause();
            VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer != null) {
                videoFeedsPlayer.setIsFrontDesk(false);
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void onResume() {
        try {
            this.mVideoFeedsPlayer.setIsFrontDesk(true);
            if (this.mVideoFeedsPlayer != null && !this.mIsSurfaceHolderDestoryed && !isComplete() && !this.mIsCovered) {
                af.c(TAG, "onresume========");
                if (this.mVideoFeedsPlayer.hasPrepare()) {
                    resumeStart();
                } else {
                    playVideo(0);
                }
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i4) {
        super.onVisibilityChanged(view, i4);
        try {
            if (ah.a().a("i_l_s_t_r_i", false) && i4 == 0 && !this.mHasReportedData) {
                this.mHasReportedData = true;
                OnPlayerViewVisibleListener onPlayerViewVisibleListener2 = this.onPlayerViewVisibleListener;
                if (onPlayerViewVisibleListener2 != null) {
                    onPlayerViewVisibleListener2.playerViewVisibleCallback();
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public void openSound() {
        VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            videoFeedsPlayer.openSound();
        }
    }

    public void pause() {
        try {
            VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer != null) {
                videoFeedsPlayer.pause();
            }
            pauseOmsdk();
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void pauseOmsdk() {
        try {
            if (this.videoEvents != null && !this.hadOMPause) {
                af.a("omsdk", "play view:  pause");
                this.hadOMPause = true;
                this.videoEvents.j();
            }
        } catch (Exception e5) {
            throw new RuntimeException(e5);
        }
    }

    public boolean playVideo(int i4) {
        try {
            VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer == null) {
                af.c(TAG, "player init error 播放失败");
                return false;
            } else if (!this.mInitState) {
                af.c(TAG, "vfp init failed 播放失败");
                return false;
            } else {
                videoFeedsPlayer.play(this.mPlayUrl, i4);
                this.mIsNeedToRepeatPrepare = false;
                return true;
            }
        } catch (Throwable th) {
            af.b(TAG, th.getMessage(), th);
            return false;
        }
    }

    public void prepare() {
        try {
            VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer != null) {
                videoFeedsPlayer.prepare();
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void release() {
        try {
            VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer != null) {
                videoFeedsPlayer.releasePlayer();
            }
            if (this.mSurfaceHolder != null) {
                af.b(TAG, "mSurfaceHolder release");
                this.mSurfaceHolder.getSurface().release();
            }
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }

    public void removeSurface() {
        try {
            af.c(TAG, "removeSurface");
            this.mLlSurContainer.removeAllViews();
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void resumeOMSDK() {
        try {
            C2216b bVar = this.videoEvents;
            if (bVar != null) {
                this.hadOMPause = false;
                bVar.k();
                af.a("omsdk", "play view:  resume");
            }
        } catch (Exception e5) {
            throw new RuntimeException(e5);
        }
    }

    public void resumeStart() {
        try {
            start(true);
            resumeOMSDK();
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void seekTo(int i4) {
        try {
            VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer != null) {
                videoFeedsPlayer.seekTo(i4);
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void seekToEndFrame() {
        VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            videoFeedsPlayer.seekToEndFrame();
        }
    }

    public void setDataSource() {
        try {
            VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer != null) {
                videoFeedsPlayer.showLoading();
                this.mVideoFeedsPlayer.setDataSource();
                this.mIsNeedToRepeatPrepare = false;
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void setDesk(boolean z4) {
        this.mVideoFeedsPlayer.setIsFrontDesk(z4);
    }

    public void setIsBTVideo(boolean z4) {
        this.isBTVideo = z4;
    }

    public void setIsBTVideoPlaying(boolean z4) {
        this.isBTVideoPlaying = z4;
    }

    public void setIsCovered(boolean z4) {
        try {
            this.mIsCovered = z4;
            af.b(TAG, "mIsCovered:" + z4);
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void setNotifyListener(OnPlayerViewVisibleListener onPlayerViewVisibleListener2) {
        this.onPlayerViewVisibleListener = onPlayerViewVisibleListener2;
    }

    public void setPlaybackParams(float f4) {
        VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            videoFeedsPlayer.setPlaybackParams(f4);
        }
    }

    public void setVideoEvents(C2216b bVar) {
        this.videoEvents = bVar;
    }

    public void setVolume(float f4, float f5) {
        VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            videoFeedsPlayer.setVolume(f4, f5);
        }
    }

    public void start(boolean z4) {
        try {
            VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer != null && !this.mIsCovered) {
                videoFeedsPlayer.start(z4);
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void stop() {
        try {
            VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer != null) {
                videoFeedsPlayer.stop();
            }
            if (this.videoEvents != null) {
                this.videoEvents = null;
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public void start(int i4) {
        try {
            VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer != null) {
                videoFeedsPlayer.start(i4);
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public boolean playVideo() {
        return playVideo(0);
    }

    public PlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
