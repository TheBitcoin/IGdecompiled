package com.mbridge.msdk.newreward.player.view.floatview;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Build;
import android.util.AttributeSet;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.player.iview.IBaseWebView;
import com.mbridge.msdk.newreward.player.presenter.FloatWebViewPresenter;
import com.mbridge.msdk.newreward.player.view.hybrid.MBWebView;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MBCommunicatorUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class FloatWebTemplateView extends FrameLayout implements View.OnClickListener, IBaseWebView {
    public static final int FLOAT_EXPAND_VIEW = 546;
    public static final int FLOAT_MINI_CARD = 273;
    private static final String TAG = "FloatTemplateView";
    boolean hasWebViewShow;
    boolean isWebViewAttached = false;
    boolean isWebViewShowed = false;
    ImageView mCloseImageView;
    FloatWebViewPresenter mFloatPresenter;
    String mUrl;
    int mViewType;
    MBWebView mWebView;
    b reqCallBack;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FloatViewType {
    }

    public FloatWebTemplateView(@NonNull Context context) {
        super(context);
    }

    private void initPresenter() {
        FloatWebViewPresenter floatWebViewPresenter = new FloatWebViewPresenter(this, this.mViewType);
        this.mFloatPresenter = floatWebViewPresenter;
        floatWebViewPresenter.getView();
    }

    public void addShowReqListener(b bVar) {
        this.reqCallBack = bVar;
    }

    public void addViewToCurrentViewGroup(View view) {
    }

    public ImageView getPrivacyButton() {
        return null;
    }

    public MBWebView getWebView() {
        return this.mWebView;
    }

    public void hideCTAView() {
    }

    public boolean initViews(boolean z4) {
        int i4;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setBackgroundColor(2130706432);
        int f4 = ak.f(getContext());
        int e5 = ak.e(getContext());
        this.mWebView = new MBWebView(new MutableContextWrapper(c.m().c()));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (this.mViewType == 273) {
            layoutParams.width = (int) ((((double) f4) * 0.7d) + 0.5d);
            layoutParams.height = (int) ((((double) e5) * 0.7d) + 0.5d);
            layoutParams.gravity = 17;
        }
        this.mWebView.setLayoutParams(layoutParams);
        this.mCloseImageView = new ImageView(getContext());
        if (this.mViewType == 273) {
            i4 = ak.a(getContext(), 48.0f);
        } else {
            i4 = 96;
        }
        int a5 = ak.a(getContext(), 5.0f);
        int i5 = (int) ((((double) f4) * 0.15d) + 0.5d);
        int i6 = (int) ((((double) e5) * 0.15d) + 0.5d);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i4, i4);
        int i7 = this.mViewType;
        if (i7 != 273) {
            i6 = 30;
        }
        layoutParams2.topMargin = i6;
        if (i7 != 273) {
            i5 = 30;
        }
        layoutParams2.rightMargin = i5;
        layoutParams2.gravity = 8388661;
        this.mCloseImageView.setLayoutParams(layoutParams2);
        this.mCloseImageView.setPadding(a5, a5, a5, a5);
        this.mCloseImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.mCloseImageView.setImageResource(x.a(getContext(), "mbridge_reward_close_ec", "drawable"));
        this.mCloseImageView.setOnClickListener(this);
        this.mCloseImageView.setVisibility(4);
        this.mWebView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            public void onViewAttachedToWindow(View view) {
                FloatWebTemplateView.this.isWebViewAttached = true;
            }

            public void onViewDetachedFromWindow(View view) {
                FloatWebTemplateView.this.isWebViewAttached = false;
            }
        });
        addView(this.mWebView);
        addView(this.mCloseImageView);
        FloatWebViewPresenter floatWebViewPresenter = this.mFloatPresenter;
        if (floatWebViewPresenter == null) {
            return true;
        }
        if (this.mViewType == 273) {
            floatWebViewPresenter.renderPauseUrl();
        }
        if (this.mViewType != 546) {
            return true;
        }
        this.mFloatPresenter.renderMRAID(this.mUrl);
        return true;
    }

    public void onActivityLifeCycleCallback(String str) {
        FloatWebViewPresenter floatWebViewPresenter = this.mFloatPresenter;
        if (floatWebViewPresenter != null) {
            floatWebViewPresenter.onActivityLifeCycleCallback(str);
        }
    }

    public void onClick(View view) {
        this.mFloatPresenter.click(view);
    }

    public void onCloseViewClick(int i4) {
        FloatWebViewPresenter floatWebViewPresenter = this.mFloatPresenter;
        if (floatWebViewPresenter != null) {
            floatWebViewPresenter.click((View) null);
        }
    }

    public void onDestroyWebContent(int i4) {
        MBWebView mBWebView = this.mWebView;
        if (mBWebView != null) {
            mBWebView.destroy();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FloatWebViewPresenter floatWebViewPresenter = this.mFloatPresenter;
        if (floatWebViewPresenter != null) {
            floatWebViewPresenter.onDetachedFromWindow();
        }
    }

    public boolean onWebViewShow(int i4) {
        this.mWebView.post(new Runnable() {
            public void run() {
                FloatWebTemplateView.this.mFloatPresenter.changeNativeCloseButton();
                FloatWebTemplateView.this.webViewShow();
                FloatWebTemplateView.this.setNotch();
            }
        });
        if (this.hasWebViewShow) {
            return true;
        }
        this.hasWebViewShow = true;
        return false;
    }

    public void removeTempleFromSuperView(ViewGroup viewGroup) {
        if (getParent() != null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).removeView(this);
        }
        b bVar = this.reqCallBack;
        if (bVar != null) {
            bVar.reqSuccessful("remove");
        }
    }

    public void setFloatViewType(int i4) {
        this.mViewType = i4;
        initPresenter();
    }

    public void setNativeCloseButtonVisibility(int i4) {
        ImageView imageView = this.mCloseImageView;
        if (imageView != null) {
            imageView.setVisibility(i4);
        }
    }

    public void setNotch() {
        DisplayCutout a5;
        int i4;
        try {
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 23) {
                WindowInsets a6 = getRootWindowInsets();
                if (i5 >= 28 && (a5 = a6.getDisplayCutout()) != null) {
                    int a7 = a5.getSafeInsetLeft();
                    int a8 = a5.getSafeInsetTop();
                    int a9 = a5.getSafeInsetRight();
                    int a10 = a5.getSafeInsetBottom();
                    int rotation = getDisplay().getRotation();
                    if (rotation != 0) {
                        if (rotation == 1) {
                            i4 = 90;
                        } else if (rotation == 2) {
                            i4 = SubsamplingScaleImageView.ORIENTATION_180;
                        } else if (rotation == 3) {
                            i4 = SubsamplingScaleImageView.ORIENTATION_270;
                        }
                        this.mFloatPresenter.setNotchData(s.a(i4, a7, a9, a8, a10));
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mCloseImageView.getLayoutParams();
                        layoutParams.topMargin = a8;
                        layoutParams.leftMargin = a7;
                        layoutParams.rightMargin = a9;
                        layoutParams.bottomMargin = a10;
                    }
                    i4 = 0;
                    this.mFloatPresenter.setNotchData(s.a(i4, a7, a9, a8, a10));
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mCloseImageView.getLayoutParams();
                    layoutParams2.topMargin = a8;
                    layoutParams2.leftMargin = a7;
                    layoutParams2.rightMargin = a9;
                    layoutParams2.bottomMargin = a10;
                }
            }
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }

    public void setRenderUrl(String str) {
        this.mUrl = str;
    }

    public void show(ViewGroup viewGroup) {
        if (getParent() != null) {
            viewGroup.bringToFront();
        } else if (viewGroup != null) {
            viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
        }
        this.mFloatPresenter.onShown();
        b bVar = this.reqCallBack;
        if (bVar != null) {
            bVar.reqSuccessful("show");
        }
    }

    public void showCTAView(String str, CampaignEx campaignEx) {
    }

    public void showMRAIDExpandView(String str, int i4) {
    }

    public void showMiniCard() {
    }

    public void webViewShow() {
        if (!this.isWebViewShowed) {
            int i4 = getResources().getConfiguration().orientation;
            String str = "undefined";
            if (i4 != 0) {
                if (i4 == 1) {
                    str = "portrait";
                } else if (i4 == 2) {
                    str = "landscape";
                }
            }
            MBCommunicatorUtil.notifyShowDataInfo(this.mWebView, i4, this.mFloatPresenter.getCampaignOrientation());
            MBCommunicatorUtil.notifyWebViewShowed(this.mWebView, str, this.mFloatPresenter.getWebViewShowExtraData());
            this.isWebViewShowed = true;
        }
    }

    public FloatWebTemplateView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FloatWebTemplateView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    @RequiresApi(api = 21)
    public FloatWebTemplateView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
    }
}
