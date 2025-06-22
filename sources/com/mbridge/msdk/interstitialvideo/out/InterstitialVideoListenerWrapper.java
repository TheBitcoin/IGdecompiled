package com.mbridge.msdk.interstitialvideo.out;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;

public class InterstitialVideoListenerWrapper implements RewardVideoListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final InterstitialVideoListener f13769a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f13770b = new Handler(Looper.getMainLooper());

    public InterstitialVideoListenerWrapper(InterstitialVideoListener interstitialVideoListener) {
        this.f13769a = interstitialVideoListener;
    }

    public void onAdClose(final MBridgeIds mBridgeIds, final RewardInfo rewardInfo) {
        this.f13770b.post(new Runnable() {
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f13769a != null) {
                    InterstitialVideoListenerWrapper.this.f13769a.onAdClose(mBridgeIds, rewardInfo);
                }
            }
        });
    }

    public void onAdCloseWithIVReward(final MBridgeIds mBridgeIds, final boolean z4, final int i4) {
        this.f13770b.post(new Runnable() {
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f13769a != null) {
                    InterstitialVideoListenerWrapper.this.f13769a.onAdCloseWithIVReward(mBridgeIds, new RewardInfo(z4, i4));
                }
            }
        });
    }

    public void onAdShow(final MBridgeIds mBridgeIds) {
        this.f13770b.post(new Runnable() {
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f13769a != null) {
                    InterstitialVideoListenerWrapper.this.f13769a.onAdShow(mBridgeIds);
                }
            }
        });
    }

    public void onEndcardShow(final MBridgeIds mBridgeIds) {
        this.f13770b.post(new Runnable() {
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f13769a != null) {
                    InterstitialVideoListenerWrapper.this.f13769a.onEndcardShow(mBridgeIds);
                }
            }
        });
    }

    public void onLoadSuccess(final MBridgeIds mBridgeIds) {
        this.f13770b.post(new Runnable() {
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f13769a != null) {
                    InterstitialVideoListenerWrapper.this.f13769a.onLoadSuccess(mBridgeIds);
                }
            }
        });
    }

    public void onShowFail(final MBridgeIds mBridgeIds, final String str) {
        this.f13770b.post(new Runnable() {
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f13769a != null) {
                    InterstitialVideoListenerWrapper.this.f13769a.onShowFail(mBridgeIds, str);
                }
            }
        });
    }

    public void onVideoAdClicked(final MBridgeIds mBridgeIds) {
        this.f13770b.post(new Runnable() {
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f13769a != null) {
                    InterstitialVideoListenerWrapper.this.f13769a.onVideoAdClicked(mBridgeIds);
                }
            }
        });
    }

    public void onVideoComplete(final MBridgeIds mBridgeIds) {
        this.f13770b.post(new Runnable() {
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f13769a != null) {
                    InterstitialVideoListenerWrapper.this.f13769a.onVideoComplete(mBridgeIds);
                }
            }
        });
    }

    public void onVideoLoadFail(final MBridgeIds mBridgeIds, final String str) {
        this.f13770b.post(new Runnable() {
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f13769a != null) {
                    InterstitialVideoListenerWrapper.this.f13769a.onVideoLoadFail(mBridgeIds, str);
                }
            }
        });
    }

    public void onVideoLoadSuccess(final MBridgeIds mBridgeIds) {
        this.f13770b.post(new Runnable() {
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f13769a != null) {
                    InterstitialVideoListenerWrapper.this.f13769a.onVideoLoadSuccess(mBridgeIds);
                }
            }
        });
    }
}
