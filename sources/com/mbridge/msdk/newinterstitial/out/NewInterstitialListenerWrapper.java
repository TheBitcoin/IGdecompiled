package com.mbridge.msdk.newinterstitial.out;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;

public class NewInterstitialListenerWrapper implements RewardVideoListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final NewInterstitialListener f14250a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f14251b = new Handler(Looper.getMainLooper());

    public NewInterstitialListenerWrapper(NewInterstitialListener newInterstitialListener) {
        this.f14250a = newInterstitialListener;
    }

    public void onAdClose(final MBridgeIds mBridgeIds, final RewardInfo rewardInfo) {
        this.f14251b.post(new Runnable() {
            public void run() {
                if (NewInterstitialListenerWrapper.this.f14250a != null) {
                    NewInterstitialListenerWrapper.this.f14250a.onAdClose(mBridgeIds, rewardInfo);
                }
            }
        });
    }

    public void onAdCloseWithIVReward(final MBridgeIds mBridgeIds, final boolean z4, final int i4) {
        this.f14251b.post(new Runnable() {
            public void run() {
                if (NewInterstitialListenerWrapper.this.f14250a != null) {
                    NewInterstitialListenerWrapper.this.f14250a.onAdCloseWithNIReward(mBridgeIds, new RewardInfo(z4, i4));
                }
            }
        });
    }

    public void onAdShow(final MBridgeIds mBridgeIds) {
        this.f14251b.post(new Runnable() {
            public void run() {
                if (NewInterstitialListenerWrapper.this.f14250a != null) {
                    NewInterstitialListenerWrapper.this.f14250a.onAdShow(mBridgeIds);
                }
            }
        });
    }

    public void onEndcardShow(final MBridgeIds mBridgeIds) {
        this.f14251b.post(new Runnable() {
            public void run() {
                if (NewInterstitialListenerWrapper.this.f14250a != null) {
                    NewInterstitialListenerWrapper.this.f14250a.onEndcardShow(mBridgeIds);
                }
            }
        });
    }

    public void onLoadSuccess(final MBridgeIds mBridgeIds) {
        this.f14251b.post(new Runnable() {
            public void run() {
                if (NewInterstitialListenerWrapper.this.f14250a != null) {
                    NewInterstitialListenerWrapper.this.f14250a.onLoadCampaignSuccess(mBridgeIds);
                }
            }
        });
    }

    public void onShowFail(final MBridgeIds mBridgeIds, final String str) {
        this.f14251b.post(new Runnable() {
            public void run() {
                if (NewInterstitialListenerWrapper.this.f14250a != null) {
                    NewInterstitialListenerWrapper.this.f14250a.onShowFail(mBridgeIds, str);
                }
            }
        });
    }

    public void onVideoAdClicked(final MBridgeIds mBridgeIds) {
        this.f14251b.post(new Runnable() {
            public void run() {
                if (NewInterstitialListenerWrapper.this.f14250a != null) {
                    NewInterstitialListenerWrapper.this.f14250a.onAdClicked(mBridgeIds);
                }
            }
        });
    }

    public void onVideoComplete(final MBridgeIds mBridgeIds) {
        this.f14251b.post(new Runnable() {
            public void run() {
                if (NewInterstitialListenerWrapper.this.f14250a != null) {
                    NewInterstitialListenerWrapper.this.f14250a.onVideoComplete(mBridgeIds);
                }
            }
        });
    }

    public void onVideoLoadFail(final MBridgeIds mBridgeIds, final String str) {
        this.f14251b.post(new Runnable() {
            public void run() {
                if (NewInterstitialListenerWrapper.this.f14250a != null) {
                    NewInterstitialListenerWrapper.this.f14250a.onResourceLoadFail(mBridgeIds, str);
                }
            }
        });
    }

    public void onVideoLoadSuccess(final MBridgeIds mBridgeIds) {
        this.f14251b.post(new Runnable() {
            public void run() {
                if (NewInterstitialListenerWrapper.this.f14250a != null) {
                    NewInterstitialListenerWrapper.this.f14250a.onResourceLoadSuccess(mBridgeIds);
                }
            }
        });
    }
}
