package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.video.module.MBridgeContainerView;

public final class m extends e {

    /* renamed from: a  reason: collision with root package name */
    private MBridgeContainerView f16618a;

    public m(MBridgeContainerView mBridgeContainerView) {
        this.f16618a = mBridgeContainerView;
    }

    public final void configurationChanged(int i4, int i5, int i6) {
        super.configurationChanged(i4, i5, i6);
        try {
            MBridgeContainerView mBridgeContainerView = this.f16618a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.configurationChanged(i4, i5, i6);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean endCardShowing() {
        try {
            MBridgeContainerView mBridgeContainerView = this.f16618a;
            if (mBridgeContainerView != null) {
                return mBridgeContainerView.endCardShowing();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.endCardShowing();
    }

    public final void hideAlertWebview() {
        super.hideAlertWebview();
        MBridgeContainerView mBridgeContainerView = this.f16618a;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.hideAlertWebview();
        }
    }

    public final void ivRewardAdsWithoutVideo(String str) {
        super.ivRewardAdsWithoutVideo(str);
        MBridgeContainerView mBridgeContainerView = this.f16618a;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.ivRewardAdsWithoutVideo(str);
        }
    }

    public final boolean miniCardShowing() {
        try {
            MBridgeContainerView mBridgeContainerView = this.f16618a;
            if (mBridgeContainerView != null) {
                return mBridgeContainerView.miniCardShowing();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.miniCardShowing();
    }

    public final void readyStatus(int i4) {
        try {
            MBridgeContainerView mBridgeContainerView = this.f16618a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.readyStatus(i4);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.readyStatus(i4);
    }

    public final void resizeMiniCard(int i4, int i5, int i6) {
        super.resizeMiniCard(i4, i5, i6);
        try {
            MBridgeContainerView mBridgeContainerView = this.f16618a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.resizeMiniCard(i4, i5, i6);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean showAlertWebView() {
        super.showAlertWebView();
        MBridgeContainerView mBridgeContainerView = this.f16618a;
        if (mBridgeContainerView != null) {
            return mBridgeContainerView.showAlertWebView();
        }
        return false;
    }

    public final void showEndcard(int i4) {
        super.showEndcard(i4);
        try {
            MBridgeContainerView mBridgeContainerView = this.f16618a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.showEndcard(i4);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void showMiniCard(int i4, int i5, int i6, int i7, int i8) {
        super.showMiniCard(i4, i5, i6, i7, i8);
        int i9 = i4;
        try {
            MBridgeContainerView mBridgeContainerView = this.f16618a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.showMiniCard(i9, i5, i6, i7, i8);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void showVideoClickView(int i4) {
        super.showVideoClickView(i4);
        MBridgeContainerView mBridgeContainerView = this.f16618a;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.showVideoClickView(i4);
        }
    }

    public final void showVideoEndCover() {
        super.showVideoEndCover();
        try {
            MBridgeContainerView mBridgeContainerView = this.f16618a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.showVideoEndCover();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void toggleCloseBtn(int i4) {
        super.toggleCloseBtn(i4);
        try {
            MBridgeContainerView mBridgeContainerView = this.f16618a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.toggleCloseBtn(i4);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
