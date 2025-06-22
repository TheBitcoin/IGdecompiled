package com.mbridge.msdk.video.dynview.j;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.MBFrameLayout;
import com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeFramLayout;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.video.dynview.a.a;
import com.mbridge.msdk.video.dynview.c;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.video.dynview.widget.MBridgeRelativeLayout;
import com.mbridge.msdk.video.module.MBridgeClickCTAView;
import java.util.Map;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private String f16133a = "mbridge_top_play_bg";

    /* renamed from: b  reason: collision with root package name */
    private String f16134b = "mbridge_top_finger_bg";

    /* renamed from: c  reason: collision with root package name */
    private String f16135c = "mbridge_bottom_play_bg";

    /* renamed from: d  reason: collision with root package name */
    private String f16136d = "mbridge_bottom_finger_bg";

    /* renamed from: e  reason: collision with root package name */
    private String f16137e = "mbridge_tv_count";

    /* renamed from: f  reason: collision with root package name */
    private String f16138f = "mbridge_sound_switch";

    /* renamed from: g  reason: collision with root package name */
    private String f16139g = "mbridge_top_control";

    /* renamed from: h  reason: collision with root package name */
    private String f16140h = "mbridge_tv_title";

    /* renamed from: i  reason: collision with root package name */
    private String f16141i = "mbridge_tv_desc";

    /* renamed from: j  reason: collision with root package name */
    private String f16142j = "mbridge_tv_install";

    /* renamed from: k  reason: collision with root package name */
    private String f16143k = "mbridge_sv_starlevel";

    /* renamed from: l  reason: collision with root package name */
    private String f16144l = "mbridge_sv_heat_count_level";

    /* renamed from: m  reason: collision with root package name */
    private String f16145m = "mbridge_tv_cta";

    /* renamed from: n  reason: collision with root package name */
    private String f16146n = "mbridge_native_ec_controller";

    /* renamed from: o  reason: collision with root package name */
    private String f16147o = "mbridge_reward_shape_choice_rl";

    /* renamed from: p  reason: collision with root package name */
    private String f16148p = "#FFFFFF";

    /* renamed from: q  reason: collision with root package name */
    private String f16149q = "#FF000000";

    /* renamed from: r  reason: collision with root package name */
    private String f16150r = "#40000000";

    /* renamed from: s  reason: collision with root package name */
    private String f16151s = "#CAEF79";

    /* renamed from: t  reason: collision with root package name */
    private String f16152t = "#2196F3";

    /* renamed from: u  reason: collision with root package name */
    private String f16153u = "#402196F3";

    /* renamed from: v  reason: collision with root package name */
    private String f16154v = "#8FC31F";

    /* renamed from: w  reason: collision with root package name */
    private String f16155w = "#03A9F4";

    /* renamed from: x  reason: collision with root package name */
    private String f16156x = "#FF89C120";

    /* renamed from: y  reason: collision with root package name */
    private String f16157y = "#FF2BAE5D";

    /* renamed from: z  reason: collision with root package name */
    private boolean f16158z = false;

    public final void a(View view, Map<String, Object> map) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        if (view != null && (view instanceof MBridgeFramLayout)) {
            MBridgeFramLayout mBridgeFramLayout = (MBridgeFramLayout) view;
            AnimatorSet animatorSet = new AnimatorSet();
            if (view.getContext() != null) {
                if (map != null && map.containsKey("is_dy_success")) {
                    this.f16158z = ((Boolean) map.get("is_dy_success")).booleanValue();
                }
                if (this.f16158z) {
                    imageView = (ImageView) view.findViewById(b(this.f16133a));
                    imageView4 = (ImageView) view.findViewById(b(this.f16134b));
                    imageView3 = (ImageView) view.findViewById(b(this.f16135c));
                    imageView2 = (ImageView) view.findViewById(b(this.f16136d));
                } else {
                    imageView = (ImageView) view.findViewById(a(this.f16133a));
                    imageView4 = (ImageView) view.findViewById(a(this.f16134b));
                    imageView3 = (ImageView) view.findViewById(a(this.f16135c));
                    imageView2 = (ImageView) view.findViewById(a(this.f16136d));
                }
                ObjectAnimator objectAnimator = null;
                ObjectAnimator a5 = imageView != null ? new com.mbridge.msdk.video.dynview.h.b().a(imageView) : null;
                ObjectAnimator b5 = imageView4 != null ? new com.mbridge.msdk.video.dynview.h.b().b(imageView4) : null;
                ObjectAnimator a6 = imageView3 != null ? new com.mbridge.msdk.video.dynview.h.b().a(imageView3) : null;
                if (imageView2 != null) {
                    objectAnimator = new com.mbridge.msdk.video.dynview.h.b().b(imageView2);
                }
                if (a5 != null && a6 != null && b5 != null && objectAnimator != null) {
                    animatorSet.playTogether(new Animator[]{a5, a6, b5, objectAnimator});
                    mBridgeFramLayout.setAnimatorSet(animatorSet);
                }
            }
        }
    }

    public final void b(View view, c cVar, Map<String, Object> map) {
        LinearLayout linearLayout;
        View view2;
        if (view != null && cVar != null) {
            if (view.getContext() != null) {
                if (map != null && map.containsKey("is_dy_success")) {
                    this.f16158z = ((Boolean) map.get("is_dy_success")).booleanValue();
                }
                if (this.f16158z) {
                    linearLayout = (LinearLayout) view.findViewById(b(this.f16143k));
                    view2 = view.findViewById(b(this.f16145m));
                } else {
                    linearLayout = (LinearLayout) view.findViewById(a(this.f16143k));
                    view2 = view.findViewById(a(this.f16145m));
                }
                if (linearLayout != null && (linearLayout instanceof MBridgeLevelLayoutView)) {
                    if (cVar.e() == 1) {
                        linearLayout.setOrientation(1);
                    } else {
                        linearLayout.setOrientation(0);
                    }
                }
                if (linearLayout != null && (linearLayout instanceof MBStarLevelLayoutView)) {
                    linearLayout.setOrientation(0);
                }
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(a(this.f16146n));
                if (relativeLayout != null) {
                    if (relativeLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                        layoutParams.setMargins(layoutParams.leftMargin + a.f15977a, layoutParams.topMargin + a.f15979c, layoutParams.rightMargin + a.f15978b, layoutParams.bottomMargin + a.f15980d);
                        relativeLayout.setLayoutParams(layoutParams);
                    }
                    if (relativeLayout.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
                        layoutParams2.setMargins(layoutParams2.leftMargin + a.f15977a, layoutParams2.topMargin + a.f15979c, layoutParams2.rightMargin + a.f15978b, layoutParams2.bottomMargin + a.f15980d);
                        relativeLayout.setLayoutParams(layoutParams2);
                    }
                }
                if (view2 != null) {
                    if (view2 instanceof TextView) {
                        TextView textView = (TextView) view2;
                        textView.setTextColor(Color.parseColor(this.f16148p));
                        textView.setTextSize(22.0f);
                        com.mbridge.msdk.video.dynview.i.b.a.a(view2, 1.0f, (float) (cVar.i() == 1302 ? 25 : 5), this.f16151s, new String[]{this.f16156x, this.f16157y}, GradientDrawable.Orientation.LEFT_RIGHT);
                    }
                    try {
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{new com.mbridge.msdk.video.dynview.h.b().c(view2)});
                        animatorSet.addListener(new Animator.AnimatorListener() {
                            public final void onAnimationCancel(Animator animator) {
                            }

                            public final void onAnimationEnd(Animator animator) {
                            }

                            public final void onAnimationRepeat(Animator animator) {
                            }

                            public final void onAnimationStart(Animator animator) {
                            }
                        });
                        if (view instanceof MBFrameLayout) {
                            ((MBFrameLayout) view).setAnimator(animatorSet);
                        }
                        if (view instanceof MBridgeFramLayout) {
                            ((MBridgeFramLayout) view).setAnimatorSet(animatorSet);
                        }
                        if (view instanceof MBridgeRelativeLayout) {
                            ((MBridgeRelativeLayout) view).setAnimatorSet(animatorSet);
                        }
                    } catch (Exception e5) {
                        Exception exc = e5;
                        if (MBridgeConstans.DEBUG) {
                            exc.printStackTrace();
                        }
                    }
                }
            }
            new com.mbridge.msdk.video.dynview.h.b().c(view, 500);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.view.View r8, com.mbridge.msdk.video.dynview.c r9, java.util.Map<java.lang.String, java.lang.Object> r10) {
        /*
            r7 = this;
            if (r8 == 0) goto L_0x0007
            android.content.Context r0 = r8.getContext()
            goto L_0x0008
        L_0x0007:
            r0 = 0
        L_0x0008:
            if (r0 == 0) goto L_0x0173
            if (r9 != 0) goto L_0x000e
            goto L_0x0173
        L_0x000e:
            java.lang.String r1 = "mbridge_reward_click_tv"
            if (r10 == 0) goto L_0x0056
            java.lang.String r2 = "is_dy_success"
            boolean r3 = r10.containsKey(r2)
            if (r3 == 0) goto L_0x0056
            java.lang.Object r10 = r10.get(r2)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            r7.f16158z = r10
            if (r10 == 0) goto L_0x003f
            java.lang.String r10 = r7.f16137e
            int r10 = r7.b(r10)
            android.view.View r10 = r8.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            int r1 = r7.b(r1)
            android.view.View r1 = r8.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x006c
        L_0x003f:
            java.lang.String r10 = r7.f16137e
            int r10 = r7.a(r10)
            android.view.View r10 = r8.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            int r1 = r7.a(r1)
            android.view.View r1 = r8.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x006c
        L_0x0056:
            java.lang.String r10 = r7.f16137e
            int r10 = r7.a(r10)
            android.view.View r10 = r8.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            int r1 = r7.a(r1)
            android.view.View r1 = r8.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x006c:
            if (r10 == 0) goto L_0x0087
            java.lang.String r2 = "mbridge_reward_shape_progress"
            java.lang.String r3 = "drawable"
            int r0 = com.mbridge.msdk.foundation.tools.x.a(r0, r2, r3)
            r10.setBackgroundResource(r0)
            java.lang.String r0 = r7.f16148p
            int r0 = android.graphics.Color.parseColor(r0)
            r10.setTextColor(r0)
            r0 = 1093664768(0x41300000, float:11.0)
            r10.setTextSize(r0)
        L_0x0087:
            if (r1 == 0) goto L_0x00b4
            r10 = 1101004800(0x41a00000, float:20.0)
            r1.setTextSize(r10)
            boolean r10 = r1 instanceof com.mbridge.msdk.dycreator.baseview.cusview.MBridgeTextView
            if (r10 == 0) goto L_0x00a1
            com.mbridge.msdk.video.dynview.h.b r10 = new com.mbridge.msdk.video.dynview.h.b
            r10.<init>()
            android.animation.ObjectAnimator r10 = r10.c(r1)
            r0 = r1
            com.mbridge.msdk.dycreator.baseview.cusview.MBridgeTextView r0 = (com.mbridge.msdk.dycreator.baseview.cusview.MBridgeTextView) r0
            r0.setObjectAnimator(r10)
        L_0x00a1:
            boolean r10 = r1 instanceof com.mbridge.msdk.dycreator.baseview.MBTextView
            if (r10 == 0) goto L_0x00b4
            com.mbridge.msdk.video.dynview.h.b r10 = new com.mbridge.msdk.video.dynview.h.b
            r10.<init>()
            android.animation.ObjectAnimator r10 = r10.c(r1)
            r0 = r1
            com.mbridge.msdk.dycreator.baseview.MBTextView r0 = (com.mbridge.msdk.dycreator.baseview.MBTextView) r0
            r0.setAnimator(r10)
        L_0x00b4:
            java.lang.String r10 = r7.f16149q
            java.lang.String r0 = r7.f16151s
            int r2 = r9.i()
            r3 = 302(0x12e, float:4.23E-43)
            r4 = 1092616192(0x41200000, float:10.0)
            r5 = 1065353216(0x3f800000, float:1.0)
            if (r2 == r3) goto L_0x00f0
            r3 = 802(0x322, float:1.124E-42)
            if (r2 == r3) goto L_0x00e1
            r3 = 5002010(0x4c531a, float:7.009309E-39)
            if (r2 == r3) goto L_0x00d7
            java.lang.String r2 = r7.f16154v
            java.lang.String r3 = r7.f16151s
            r4 = 1084227584(0x40a00000, float:5.0)
            r4 = r0
            r0 = 1084227584(0x40a00000, float:5.0)
            goto L_0x00fa
        L_0x00d7:
            java.lang.String r0 = r7.f16154v
            java.lang.String r10 = r7.f16148p
            r2 = r0
            r3 = r2
            r4 = r3
        L_0x00de:
            r0 = 1092616192(0x41200000, float:10.0)
            goto L_0x00fa
        L_0x00e1:
            java.lang.String r2 = r7.f16148p
            java.lang.String r10 = r7.f16149q
            java.lang.String r0 = r7.f16150r
            r5 = 1056964608(0x3f000000, float:0.5)
            r4 = 1103626240(0x41c80000, float:25.0)
            r4 = r0
            r3 = r2
            r0 = 1103626240(0x41c80000, float:25.0)
            goto L_0x00fa
        L_0x00f0:
            java.lang.String r2 = r7.f16152t
            java.lang.String r3 = r7.f16155w
            java.lang.String r10 = r7.f16148p
            java.lang.String r0 = r7.f16153u
            r4 = r0
            goto L_0x00de
        L_0x00fa:
            if (r1 == 0) goto L_0x010f
            int r10 = android.graphics.Color.parseColor(r10)
            r1.setTextColor(r10)
            java.lang.String[] r10 = new java.lang.String[]{r2, r3}
            android.graphics.drawable.GradientDrawable$Orientation r6 = android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT
            r3 = r0
            r2 = r5
            r5 = r10
            com.mbridge.msdk.video.dynview.i.b.a.a(r1, r2, r3, r4, r5, r6)
        L_0x010f:
            android.view.View r10 = r9.f()
            r0 = 0
            if (r10 == 0) goto L_0x012c
            android.view.View r10 = r9.f()
            android.view.ViewGroup$LayoutParams r10 = r10.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r10 = (android.widget.RelativeLayout.LayoutParams) r10
            if (r10 == 0) goto L_0x012c
            r10.setMargins(r0, r0, r0, r0)
            android.view.View r9 = r9.f()
            r9.setLayoutParams(r10)
        L_0x012c:
            boolean r9 = r7.f16158z
            if (r9 == 0) goto L_0x013d
            java.lang.String r9 = r7.f16139g
            int r9 = r7.b(r9)
            android.view.View r8 = r8.findViewById(r9)
            android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8
            goto L_0x0149
        L_0x013d:
            java.lang.String r9 = r7.f16139g
            int r9 = r7.a(r9)
            android.view.View r8 = r8.findViewById(r9)
            android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8
        L_0x0149:
            if (r8 == 0) goto L_0x0173
            int r9 = com.mbridge.msdk.video.dynview.a.a.f15977a
            if (r9 != 0) goto L_0x015c
            int r9 = com.mbridge.msdk.video.dynview.a.a.f15978b
            if (r9 != 0) goto L_0x015c
            int r9 = com.mbridge.msdk.video.dynview.a.a.f15979c
            if (r9 != 0) goto L_0x015c
            int r9 = com.mbridge.msdk.video.dynview.a.a.f15980d
            if (r9 != 0) goto L_0x015c
            goto L_0x0173
        L_0x015c:
            r9 = 4
            r8.setVisibility(r9)
            android.view.animation.AlphaAnimation r9 = new android.view.animation.AlphaAnimation
            r10 = 0
            r1 = 1120403456(0x42c80000, float:100.0)
            r9.<init>(r10, r1)
            r1 = 200(0xc8, double:9.9E-322)
            r9.setDuration(r1)
            r8.startAnimation(r9)
            r8.setVisibility(r0)
        L_0x0173:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.j.b.a(android.view.View, com.mbridge.msdk.video.dynview.c, java.util.Map):void");
    }

    private int b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.hashCode();
        }
        return -1;
    }

    public final void a(View view, c cVar) {
        Context context;
        int i4;
        if (view != null && cVar != null && (context = view.getContext()) != null) {
            if (cVar.e() == 1) {
                view.setBackground(context.getResources().getDrawable(x.a(context, this.f16147o, "drawable")));
                TextView textView = (TextView) view.findViewById(a(this.f16140h));
                if (textView != null) {
                    textView.setTextColor(Color.parseColor(this.f16149q));
                }
                TextView textView2 = (TextView) view.findViewById(a(this.f16141i));
                if (textView2 != null) {
                    textView2.setTextColor(Color.parseColor(this.f16149q));
                }
                i4 = ak.a(context, 2.0f);
            } else {
                i4 = ak.a(context, 10.0f);
                view.getBackground().setAlpha(100);
            }
            int a5 = ak.a(context, 8.0f);
            View findViewById = view.findViewById(a(this.f16142j));
            if (findViewById != null) {
                if (cVar.f() != null && (cVar.f() instanceof MBridgeClickCTAView)) {
                    ((MBridgeClickCTAView) cVar.f()).setObjectAnimator(new com.mbridge.msdk.video.dynview.h.b().c(findViewById));
                }
                if (findViewById instanceof TextView) {
                    TextView textView3 = (TextView) findViewById;
                    textView3.setTextColor(Color.parseColor(this.f16148p));
                    textView3.setTextSize(15.0f);
                    String str = this.f16154v;
                    String str2 = this.f16151s;
                    com.mbridge.msdk.video.dynview.i.b.a.a(textView3, 1.0f, 5.0f, str2, new String[]{str, str2}, GradientDrawable.Orientation.LEFT_RIGHT);
                }
            }
            if (view.getLayoutParams() == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(i4, i4, i4, a5);
                layoutParams.height = ak.a(context, 60.0f);
                view.setLayoutParams(layoutParams);
            }
        }
    }

    private int a(String str) {
        return x.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, "id");
    }
}
