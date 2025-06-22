package com.mbridge.msdk.dycreator.baseview.rewardpopview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.GravityCompat;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.MBGradientAndShadowTextView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MBAcquireRewardPopView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private final String f12493a = "MBAcquireRewardPopView";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public AcquireRewardPopViewParameters f12494b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public AnimationSet f12495c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public float f12496d = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public float f12497e = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public float f12498f = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public float f12499g = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f12500h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f12501i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f12502j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f12503k;

    /* renamed from: l  reason: collision with root package name */
    private final View.OnClickListener f12504l = new View.OnClickListener() {
        public void onClick(View view) {
            View view2;
            MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
            mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.f12505m);
            String str = (String) view.getTag();
            if (!TextUtils.isEmpty(str)) {
                boolean contains = MBAcquireRewardPopView.this.f12494b.rightAnswerList.contains(str);
                MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                if (contains) {
                    view2 = MBAcquireRewardPopView.e(mBAcquireRewardPopView2);
                } else {
                    view2 = MBAcquireRewardPopView.f(mBAcquireRewardPopView2);
                }
                View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                if (childAt != null) {
                    MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, childAt, view2);
                }
                if (MBAcquireRewardPopView.this.f12494b.behaviourListener != null) {
                    if (contains) {
                        MBAcquireRewardPopView.this.f12494b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f12494b.reduceTime);
                    } else {
                        MBAcquireRewardPopView.this.f12494b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_WRONG_ANSWER);
                    }
                }
                MBAcquireRewardPopView mBAcquireRewardPopView3 = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView3.postDelayed(mBAcquireRewardPopView3.f12506n, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public Runnable f12505m = new Runnable() {
        public void run() {
            if (MBAcquireRewardPopView.this.f12500h <= 0) {
                if (MBAcquireRewardPopView.this.f12494b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f12494b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_AUTO_DISMISS);
                }
                boolean unused = MBAcquireRewardPopView.this.f12501i = false;
                MBAcquireRewardPopView.this.setVisibility(8);
                MBAcquireRewardPopView.this.removeAllViews();
                return;
            }
            MBAcquireRewardPopView.i(MBAcquireRewardPopView.this);
            MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
            mBAcquireRewardPopView.postDelayed(mBAcquireRewardPopView.f12505m, 1000);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public Runnable f12506n = new Runnable() {
        public void run() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    boolean unused = MBAcquireRewardPopView.this.f12501i = false;
                    MBAcquireRewardPopView.this.setVisibility(8);
                    MBAcquireRewardPopView.this.removeAllViews();
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            MBAcquireRewardPopView.this.startAnimation(alphaAnimation);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public View.OnTouchListener f12507o = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                float unused = MBAcquireRewardPopView.this.f12496d = motionEvent.getX();
                float unused2 = MBAcquireRewardPopView.this.f12497e = motionEvent.getY();
            } else if (action != 1) {
                if (action == 2) {
                    float unused3 = MBAcquireRewardPopView.this.f12498f = motionEvent.getX();
                    float unused4 = MBAcquireRewardPopView.this.f12499g = motionEvent.getY();
                }
            } else if (MBAcquireRewardPopView.this.f12498f <= MBAcquireRewardPopView.this.f12496d) {
                MBAcquireRewardPopView.this.f12494b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f12496d, MBAcquireRewardPopView.this.f12497e);
            } else if (Math.abs(MBAcquireRewardPopView.this.f12498f - MBAcquireRewardPopView.this.f12496d) <= 50.0f || Math.abs(MBAcquireRewardPopView.this.f12499g - MBAcquireRewardPopView.this.f12497e) >= 100.0f) {
                MBAcquireRewardPopView.this.f12494b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f12496d, MBAcquireRewardPopView.this.f12497e);
            } else if (MBAcquireRewardPopView.this.f12502j) {
                return false;
            } else {
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.f12505m);
                boolean unused5 = MBAcquireRewardPopView.this.f12502j = true;
                View e5 = MBAcquireRewardPopView.e(MBAcquireRewardPopView.this);
                View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                if (childAt != null) {
                    MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, childAt, e5);
                }
                if (MBAcquireRewardPopView.this.f12494b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f12494b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f12494b.reduceTime);
                }
                MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.f12506n, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
            }
            return false;
        }
    };

    /* renamed from: p  reason: collision with root package name */
    private final View.OnClickListener f12508p = new View.OnClickListener() {
        public void onClick(View view) {
            if (MBAcquireRewardPopView.this.f12494b.behaviourListener != null) {
                MBAcquireRewardPopView.this.f12494b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f12496d, MBAcquireRewardPopView.this.f12497e);
            }
        }
    };

    /* renamed from: q  reason: collision with root package name */
    private final View.OnClickListener f12509q = new View.OnClickListener() {
        public void onClick(View view) {
            if (MBAcquireRewardPopView.this.f12494b.behaviourListener != null) {
                MBAcquireRewardPopView.this.f12494b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_CLOSE);
            }
            boolean unused = MBAcquireRewardPopView.this.f12501i = false;
            MBAcquireRewardPopView.this.setVisibility(8);
            MBAcquireRewardPopView.this.removeAllViews();
        }
    };

    public MBAcquireRewardPopView(Context context) {
        super(context);
    }

    static /* synthetic */ View e(MBAcquireRewardPopView mBAcquireRewardPopView) {
        String str;
        LinearLayout linearLayout = new LinearLayout(mBAcquireRewardPopView.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        MBGradientAndShadowTextView.GradientAndShadowParameters gradientAndShadowParameters = new MBGradientAndShadowTextView.GradientAndShadowParameters();
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = mBAcquireRewardPopView.f12494b;
        gradientAndShadowParameters.gradientStartColor = acquireRewardPopViewParameters.successTitleGradientStartColor;
        gradientAndShadowParameters.gradientEndColor = acquireRewardPopViewParameters.successTitleGradientEndColor;
        gradientAndShadowParameters.shadowColor = acquireRewardPopViewParameters.successTitleShadowColor;
        MBGradientAndShadowTextView mBGradientAndShadowTextView = new MBGradientAndShadowTextView(mBAcquireRewardPopView.getContext(), gradientAndShadowParameters);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, 0, ak.a(mBAcquireRewardPopView.getContext(), 12.0f));
        layoutParams2.gravity = 1;
        mBGradientAndShadowTextView.setLayoutParams(layoutParams2);
        AcquireRewardPopViewParameters acquireRewardPopViewParameters2 = mBAcquireRewardPopView.f12494b;
        int i4 = acquireRewardPopViewParameters2.viewType;
        if (i4 == 1) {
            str = acquireRewardPopViewParameters2.successTitle;
        } else if (i4 == 2) {
            str = acquireRewardPopViewParameters2.slideSuccessTitle;
        } else {
            str = "";
        }
        mBGradientAndShadowTextView.setGravity(17);
        mBGradientAndShadowTextView.setText(String.format(" %s ", new Object[]{str}));
        linearLayout.addView(mBGradientAndShadowTextView);
        GradientDrawable a5 = mBAcquireRewardPopView.a(new int[]{AcquireRewardPopViewConst.DEFAULT_COLOR_00FDB258, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_00F3A850}, GradientDrawable.Orientation.LEFT_RIGHT);
        TextView textView = new TextView(mBAcquireRewardPopView.getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        textView.setLayoutParams(layoutParams3);
        textView.setTextSize(12.0f);
        textView.setGravity(17);
        textView.setTextColor(mBAcquireRewardPopView.f12494b.successTipTextColor);
        AcquireRewardPopViewParameters acquireRewardPopViewParameters3 = mBAcquireRewardPopView.f12494b;
        textView.setText(String.format(acquireRewardPopViewParameters3.successTip, new Object[]{Integer.valueOf(acquireRewardPopViewParameters3.reduceTime)}));
        int a6 = ak.a(mBAcquireRewardPopView.getContext(), 6.0f);
        int a7 = ak.a(mBAcquireRewardPopView.getContext(), 32.0f);
        textView.setPadding(a7, a6, a7, a6);
        textView.setBackground(a5);
        linearLayout.addView(textView);
        return linearLayout;
    }

    static /* synthetic */ View f(MBAcquireRewardPopView mBAcquireRewardPopView) {
        LinearLayout linearLayout = new LinearLayout(mBAcquireRewardPopView.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        MBGradientAndShadowTextView.GradientAndShadowParameters gradientAndShadowParameters = new MBGradientAndShadowTextView.GradientAndShadowParameters();
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = mBAcquireRewardPopView.f12494b;
        gradientAndShadowParameters.gradientStartColor = acquireRewardPopViewParameters.failTitleGradientStartColor;
        gradientAndShadowParameters.gradientEndColor = acquireRewardPopViewParameters.failTitleGradientEndColor;
        gradientAndShadowParameters.shadowColor = acquireRewardPopViewParameters.failTitleShadowColor;
        MBGradientAndShadowTextView mBGradientAndShadowTextView = new MBGradientAndShadowTextView(mBAcquireRewardPopView.getContext(), gradientAndShadowParameters);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, 0, ak.a(mBAcquireRewardPopView.getContext(), 12.0f));
        layoutParams2.gravity = 1;
        mBGradientAndShadowTextView.setGravity(17);
        mBGradientAndShadowTextView.setLayoutParams(layoutParams2);
        mBGradientAndShadowTextView.setText(String.format(" %s ", new Object[]{mBAcquireRewardPopView.f12494b.failTitle}));
        linearLayout.addView(mBGradientAndShadowTextView);
        GradientDrawable a5 = mBAcquireRewardPopView.a(new int[]{AcquireRewardPopViewConst.DEFAULT_COLOR_00B09A80, AcquireRewardPopViewConst.DEFAULT_COLOR_FFB09A80, AcquireRewardPopViewConst.DEFAULT_COLOR_FFB09A80, AcquireRewardPopViewConst.DEFAULT_COLOR_00B09A80}, GradientDrawable.Orientation.LEFT_RIGHT);
        TextView textView = new TextView(mBAcquireRewardPopView.getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        textView.setLayoutParams(layoutParams3);
        textView.setTextSize(12.0f);
        textView.setGravity(17);
        textView.setTextColor(mBAcquireRewardPopView.f12494b.failTipTextColor);
        textView.setText(String.format(mBAcquireRewardPopView.f12494b.failTip, new Object[]{""}));
        int a6 = ak.a(mBAcquireRewardPopView.getContext(), 6.0f);
        int a7 = ak.a(mBAcquireRewardPopView.getContext(), 32.0f);
        textView.setPadding(a7, a6, a7, a6);
        textView.setBackground(a5);
        linearLayout.addView(textView);
        return linearLayout;
    }

    static /* synthetic */ int i(MBAcquireRewardPopView mBAcquireRewardPopView) {
        int i4 = mBAcquireRewardPopView.f12500h;
        mBAcquireRewardPopView.f12500h = i4 - 1;
        return i4;
    }

    public void init(AcquireRewardPopViewParameters acquireRewardPopViewParameters) {
        LinearLayout linearLayout;
        if (acquireRewardPopViewParameters == null) {
            af.b("MBAcquireRewardPopView", "Must generate parameters.");
            return;
        }
        this.f12494b = acquireRewardPopViewParameters;
        if (acquireRewardPopViewParameters.viewType == 1) {
            ArrayList arrayList = new ArrayList();
            AcquireRewardPopViewParameters acquireRewardPopViewParameters2 = this.f12494b;
            if (acquireRewardPopViewParameters2 != null) {
                List<String> list = acquireRewardPopViewParameters2.rightAnswerList;
                if (list != null) {
                    arrayList.addAll(list);
                }
                if (this.f12494b.wrongAnswerList != null) {
                    int nextInt = new Random().nextInt(this.f12494b.wrongAnswerList.size());
                    if (nextInt > this.f12494b.wrongAnswerList.size() - 1) {
                        nextInt = 0;
                    }
                    arrayList.add(this.f12494b.wrongAnswerList.get(nextInt));
                }
            }
            linearLayout = a((ArrayList<String>) arrayList);
            if (this.f12494b.canClickMaskArea) {
                setOnClickListener(this.f12508p);
            }
        } else {
            linearLayout = null;
        }
        if (this.f12494b.viewType == 2) {
            int a5 = ak.a(getContext(), 290.0f);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a5, -2);
            layoutParams.addRule(13);
            linearLayout2.setLayoutParams(layoutParams);
            linearLayout2.setOrientation(1);
            MBGradientAndShadowTextView.GradientAndShadowParameters gradientAndShadowParameters = new MBGradientAndShadowTextView.GradientAndShadowParameters();
            AcquireRewardPopViewParameters acquireRewardPopViewParameters3 = this.f12494b;
            gradientAndShadowParameters.gradientStartColor = acquireRewardPopViewParameters3.successTitleGradientStartColor;
            gradientAndShadowParameters.gradientEndColor = acquireRewardPopViewParameters3.successTitleGradientEndColor;
            gradientAndShadowParameters.shadowColor = acquireRewardPopViewParameters3.successTitleShadowColor;
            gradientAndShadowParameters.textSize = 30;
            MBGradientAndShadowTextView mBGradientAndShadowTextView = new MBGradientAndShadowTextView(getContext(), gradientAndShadowParameters);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, 0, ak.a(getContext(), 12.0f));
            layoutParams2.gravity = 1;
            mBGradientAndShadowTextView.setLayoutParams(layoutParams2);
            mBGradientAndShadowTextView.setText(String.format(" %s ", new Object[]{this.f12494b.slideTitle}));
            mBGradientAndShadowTextView.setGravity(17);
            linearLayout2.addView(mBGradientAndShadowTextView);
            GradientDrawable a6 = a(new int[]{AcquireRewardPopViewConst.DEFAULT_COLOR_00FDB258, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_00F3A850}, GradientDrawable.Orientation.LEFT_RIGHT);
            this.f12503k = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 1;
            layoutParams3.setMargins(0, 0, 0, ak.a(getContext(), 25.0f));
            this.f12503k.setLayoutParams(layoutParams3);
            this.f12503k.setTextSize(12.0f);
            this.f12503k.setGravity(17);
            this.f12503k.setTextColor(this.f12494b.successTipTextColor);
            TextView textView = this.f12503k;
            AcquireRewardPopViewParameters acquireRewardPopViewParameters4 = this.f12494b;
            textView.setText(String.format(acquireRewardPopViewParameters4.slideTip, new Object[]{Integer.valueOf(acquireRewardPopViewParameters4.reduceTime)}));
            int a7 = ak.a(getContext(), 6.0f);
            int a8 = ak.a(getContext(), 32.0f);
            this.f12503k.setPadding(a8, a7, a8, a7);
            this.f12503k.setBackground(a6);
            linearLayout2.addView(this.f12503k);
            ImageView imageView = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.gravity = 1;
            imageView.setLayoutParams(layoutParams4);
            imageView.setBackgroundResource(getResources().getIdentifier("mbridge_slide_rightarrow", "drawable", c.m().g()));
            linearLayout2.addView(imageView);
            ImageView imageView2 = new ImageView(getContext());
            imageView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            imageView2.setBackgroundResource(getResources().getIdentifier("mbridge_slide_hand", "drawable", c.m().g()));
            linearLayout2.addView(imageView2);
            imageView2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                public void onViewAttachedToWindow(View view) {
                    MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, view);
                }

                public void onViewDetachedFromWindow(View view) {
                    if (MBAcquireRewardPopView.this.f12495c != null) {
                        MBAcquireRewardPopView.this.f12495c.cancel();
                    }
                }
            });
            linearLayout2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                public void onViewAttachedToWindow(View view) {
                    MBAcquireRewardPopView.this.setLongClickable(true);
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.setOnTouchListener(mBAcquireRewardPopView.f12507o);
                }

                public void onViewDetachedFromWindow(View view) {
                }
            });
            linearLayout = linearLayout2;
        }
        if (linearLayout != null) {
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            setBackgroundColor(this.f12494b.containerBackgroundColor);
            addView(linearLayout);
            int i4 = this.f12494b.autoDismissTime;
            if (i4 > 0) {
                this.f12500h = i4;
                post(this.f12505m);
                this.f12501i = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f12505m);
    }

    public void onPause() {
        if (this.f12501i && this.f12500h > 0) {
            removeCallbacks(this.f12505m);
        }
    }

    public void onResume() {
        if (this.f12501i && this.f12500h > 0) {
            post(this.f12505m);
        }
    }

    public void onStop() {
        if (this.f12501i && this.f12500h > 0) {
            removeCallbacks(this.f12505m);
        }
    }

    public void onTimeLessThanReduce(int i4) {
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = this.f12494b;
        acquireRewardPopViewParameters.reduceTime = i4;
        TextView textView = this.f12503k;
        if (textView != null) {
            textView.setText(String.format(acquireRewardPopViewParameters.tips, new Object[]{Integer.valueOf(i4)}));
        }
    }

    private View a(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = arrayList;
        LinearLayout linearLayout = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ak.a(getContext(), 290.0f), -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setClickable(true);
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = this.f12494b;
        int i4 = acquireRewardPopViewParameters.viewBackLayerTopColor;
        int i5 = acquireRewardPopViewParameters.viewBackLayerBottomColor;
        int i6 = acquireRewardPopViewParameters.viewForegroundTopColor;
        int i7 = acquireRewardPopViewParameters.viewForegroundBottomColor;
        int[] iArr = {i4, i5};
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        GradientDrawable a5 = a(iArr, orientation);
        a5.setCornerRadius((float) ak.a(getContext(), 12.0f));
        GradientDrawable a6 = a(new int[]{i6, i7}, orientation);
        a6.setCornerRadius((float) ak.a(getContext(), 12.0f));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{a5, a6});
        layerDrawable.setLayerInset(1, 5, 5, 5, 5);
        linearLayout.setBackground(layerDrawable);
        ImageView imageView = new ImageView(getContext());
        int a7 = ak.a(getContext(), 20.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a7, a7);
        layoutParams2.gravity = GravityCompat.END;
        layoutParams2.setMargins(0, 13, 13, 0);
        imageView.setLayoutParams(layoutParams2);
        imageView.setImageResource(getResources().getIdentifier("mbridge_reward_popview_close", "drawable", c.m().g()));
        imageView.setOnClickListener(this.f12509q);
        linearLayout.addView(imageView);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        int a8 = ak.a(getContext(), 18.0f);
        layoutParams3.setMargins(a8, 5, a8, ak.a(getContext(), 12.0f));
        textView.setLayoutParams(layoutParams3);
        textView.setText(this.f12494b.title);
        textView.setTextColor(this.f12494b.titleTextColor);
        textView.setTextSize(18.0f);
        textView.setGravity(17);
        linearLayout.addView(textView);
        if (arrayList2 != null && arrayList2.size() > 1) {
            int a9 = ak.a(getContext(), 8.0f);
            int a10 = ak.a(getContext(), 24.0f);
            int a11 = ak.a(getContext(), 30.0f);
            int a12 = ak.a(getContext(), 12.0f);
            int a13 = ak.a(getContext(), 40.0f);
            for (int i8 = 0; i8 < arrayList2.size(); i8++) {
                boolean contains = this.f12494b.rightAnswerList.contains(arrayList2.get(i8));
                TextView textView2 = new TextView(getContext());
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams4.gravity = 1;
                layoutParams4.setMargins(a11, a12, a11, 0);
                textView2.setPadding(a10, a9, a10, a9);
                textView2.setLayoutParams(layoutParams4);
                textView2.setText(arrayList2.get(i8));
                textView2.setSingleLine(true);
                textView2.setEllipsize(TextUtils.TruncateAt.END);
                textView2.setTag(arrayList2.get(i8));
                textView2.setTextSize(17.0f);
                textView2.setGravity(17);
                AcquireRewardPopViewParameters acquireRewardPopViewParameters2 = this.f12494b;
                textView2.setTextColor(contains ? acquireRewardPopViewParameters2.buttonTextLightColor : acquireRewardPopViewParameters2.buttonTextDarkColor);
                AcquireRewardPopViewParameters acquireRewardPopViewParameters3 = this.f12494b;
                int i9 = contains ? acquireRewardPopViewParameters3.buttonBackgroundLightColor : acquireRewardPopViewParameters3.buttonBackgroundDarkColor;
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(i9);
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius((float) a13);
                textView2.setBackground(gradientDrawable);
                textView2.setOnClickListener(this.f12504l);
                linearLayout.addView(textView2);
            }
        }
        this.f12503k = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        int a14 = ak.a(getContext(), 16.0f);
        int a15 = ak.a(getContext(), 18.0f);
        layoutParams5.setMargins(a15, a14, a15, a14);
        layoutParams5.gravity = 1;
        this.f12503k.setLayoutParams(layoutParams5);
        TextView textView3 = this.f12503k;
        AcquireRewardPopViewParameters acquireRewardPopViewParameters4 = this.f12494b;
        textView3.setText(String.format(acquireRewardPopViewParameters4.tips, new Object[]{Integer.valueOf(acquireRewardPopViewParameters4.reduceTime)}));
        this.f12503k.setTextColor(this.f12494b.tipTextColor);
        this.f12503k.setGravity(17);
        this.f12503k.setTextSize(12.0f);
        linearLayout.addView(this.f12503k);
        return linearLayout;
    }

    public MBAcquireRewardPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBAcquireRewardPopView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    @RequiresApi(api = 21)
    public MBAcquireRewardPopView(Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
    }

    private GradientDrawable a(int[] iArr, GradientDrawable.Orientation orientation) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(iArr);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(orientation);
        gradientDrawable.setShape(0);
        return gradientDrawable;
    }

    static /* synthetic */ void a(MBAcquireRewardPopView mBAcquireRewardPopView, final View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.8f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(1000);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000);
        AnimationSet animationSet = new AnimationSet(true);
        mBAcquireRewardPopView.f12495c = animationSet;
        animationSet.addAnimation(translateAnimation);
        mBAcquireRewardPopView.f12495c.addAnimation(alphaAnimation);
        final AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(1000);
        alphaAnimation2.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                view.startAnimation(MBAcquireRewardPopView.this.f12495c);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        mBAcquireRewardPopView.f12495c.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                view.startAnimation(alphaAnimation2);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        view.startAnimation(mBAcquireRewardPopView.f12495c);
    }

    static /* synthetic */ void a(MBAcquireRewardPopView mBAcquireRewardPopView, View view, View view2) {
        mBAcquireRewardPopView.removeView(view);
        mBAcquireRewardPopView.addView(view2);
    }
}
