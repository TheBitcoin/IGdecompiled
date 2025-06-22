package com.mbridge.msdk.foundation.d.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import com.mbridge.msdk.c.b;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.d.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.FeedbackRadioGroup;
import com.mbridge.msdk.widget.dialog.MBFeedBackDialog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static int f12838a = -1;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static String f12839b;

    /* renamed from: A  reason: collision with root package name */
    private int f12840A = -1;

    /* renamed from: B  reason: collision with root package name */
    private int f12841B = -1;

    /* renamed from: c  reason: collision with root package name */
    private float f12842c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    private String f12843d;

    /* renamed from: e  reason: collision with root package name */
    private CampaignEx f12844e;

    /* renamed from: f  reason: collision with root package name */
    private String f12845f = "";

    /* renamed from: g  reason: collision with root package name */
    private FeedBackButton f12846g;

    /* renamed from: h  reason: collision with root package name */
    private String f12847h;

    /* renamed from: i  reason: collision with root package name */
    private float f12848i = -1.0f;

    /* renamed from: j  reason: collision with root package name */
    private int f12849j = -1;

    /* renamed from: k  reason: collision with root package name */
    private String f12850k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public MBFeedBackDialog f12851l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public Dialog f12852m;

    /* renamed from: n  reason: collision with root package name */
    private JSONArray f12853n;

    /* renamed from: o  reason: collision with root package name */
    private int f12854o = -1;

    /* renamed from: p  reason: collision with root package name */
    private int f12855p = -1;

    /* renamed from: q  reason: collision with root package name */
    private int f12856q = -1;

    /* renamed from: r  reason: collision with root package name */
    private int f12857r = -1;

    /* renamed from: s  reason: collision with root package name */
    private int f12858s;

    /* renamed from: t  reason: collision with root package name */
    private List<C0180a> f12859t = new ArrayList();

    /* renamed from: u  reason: collision with root package name */
    private int f12860u = ak.a(c.m().c(), 20.0f);

    /* renamed from: v  reason: collision with root package name */
    private String f12861v = "";

    /* renamed from: w  reason: collision with root package name */
    private int f12862w;

    /* renamed from: x  reason: collision with root package name */
    private com.mbridge.msdk.widget.dialog.a f12863x = new com.mbridge.msdk.widget.dialog.a() {
        public final void a() {
            a.a(a.this);
        }

        public final void b() {
            a.b(a.this);
        }

        public final void c() {
            a.c(a.this);
        }
    };

    /* renamed from: y  reason: collision with root package name */
    private int f12864y = f12838a;

    /* renamed from: z  reason: collision with root package name */
    private int f12865z = -1;

    public a(String str) {
        this.f12850k = str;
        if (this.f12859t == null) {
            this.f12859t = new ArrayList();
        }
        k();
        i();
        j();
    }

    private void i() {
        Context c5 = c.m().c();
        if (c5 != null) {
            try {
                FeedBackButton feedBackButton = new FeedBackButton(c5);
                this.f12846g = feedBackButton;
                int i4 = 8;
                if (this.f12864y != 8) {
                    i4 = 0;
                }
                feedBackButton.setVisibility(i4);
                this.f12846g.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        a.this.e();
                    }
                });
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    private void j() {
        try {
            if (b.a().a(c.m().c()) != null) {
                g b5 = h.a().b(c.m().k());
                if (b5 == null) {
                    h.a();
                    b5 = i.a();
                }
                b.C0173b G4 = b5.G();
                if (G4 == null) {
                    af.c("", "feedback fbk is null");
                    return;
                }
                k();
                this.f12851l = new MBFeedBackDialog(com.mbridge.msdk.foundation.d.b.a().a(c.m().c()), this.f12863x);
                FeedbackRadioGroup a5 = a(G4);
                this.f12851l.setCancelText(G4.d());
                this.f12851l.setConfirmText(G4.a());
                this.f12851l.setPrivacyText(G4.c());
                this.f12861v = G4.e();
                this.f12851l.setTitle(G4.f());
                this.f12851l.setContent(a5);
                this.f12851l.setCancelButtonClickable(!TextUtils.isEmpty(f12839b));
                a(a5, G4);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private void k() {
        if (this.f12863x == null) {
            this.f12863x = new com.mbridge.msdk.widget.dialog.a() {
                public final void a() {
                    a.a(a.this);
                }

                public final void b() {
                    a.b(a.this);
                }

                public final void c() {
                    a.c(a.this);
                }
            };
        }
    }

    private void l() {
        boolean z4;
        FeedBackButton feedBackButton = this.f12846g;
        if (feedBackButton != null) {
            int i4 = this.f12840A;
            if (i4 > -1) {
                feedBackButton.setX((float) i4);
            }
            int i5 = this.f12841B;
            if (i5 > -1) {
                this.f12846g.setY((float) i5);
            }
            float f4 = this.f12842c;
            if (f4 >= 0.0f) {
                this.f12846g.setAlpha(f4);
                FeedBackButton feedBackButton2 = this.f12846g;
                if (this.f12842c != 0.0f) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                feedBackButton2.setEnabled(z4);
            }
            ViewGroup.LayoutParams layoutParams = this.f12846g.getLayoutParams();
            int i6 = this.f12865z;
            if (i6 > 0) {
                this.f12846g.setWidth(i6);
                if (layoutParams != null) {
                    layoutParams.width = this.f12865z;
                }
            }
            int i7 = this.f12849j;
            if (i7 > 0) {
                this.f12846g.setHeight(i7);
                if (layoutParams != null) {
                    layoutParams.height = this.f12849j;
                }
            }
            if (layoutParams != null) {
                this.f12846g.setLayoutParams(layoutParams);
            }
            try {
                if (!TextUtils.isEmpty(this.f12847h)) {
                    this.f12846g.setTextColor(Color.parseColor(this.f12847h));
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            float f5 = this.f12848i;
            if (f5 > 0.0f) {
                this.f12846g.setTextSize(f5);
            }
            JSONArray jSONArray = this.f12853n;
            if (jSONArray != null && jSONArray.length() == 4) {
                Context c5 = c.m().c();
                this.f12846g.setPadding(ak.a(c5, (float) this.f12853n.optDouble(0)), ak.a(c5, (float) this.f12853n.optDouble(1)), ak.a(c5, (float) this.f12853n.optDouble(2)), ak.a(c5, (float) this.f12853n.optDouble(3)));
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            int i8 = this.f12860u;
            if (i8 > 0) {
                gradientDrawable.setCornerRadius((float) i8);
            }
            if (!TextUtils.isEmpty(this.f12843d)) {
                gradientDrawable.setColor(Color.parseColor(this.f12843d));
            } else {
                gradientDrawable.setColor(Color.parseColor(FeedBackButton.FEEDBACK_BTN_BACKGROUND_COLOR_STR));
            }
            this.f12846g.setBackground(gradientDrawable);
        }
    }

    public final void a(C0180a aVar) {
        if (this.f12859t == null) {
            this.f12859t = new ArrayList();
        }
        this.f12859t.add(aVar);
    }

    public final CampaignEx c() {
        return this.f12844e;
    }

    public final int f() {
        return this.f12858s;
    }

    public final int g() {
        return this.f12862w;
    }

    public final void b() {
        MBFeedBackDialog mBFeedBackDialog = this.f12851l;
        if (mBFeedBackDialog != null && mBFeedBackDialog.isShowing()) {
            this.f12851l.cancel();
        }
    }

    public final void c(int i4) {
        this.f12864y = i4;
        FeedBackButton feedBackButton = this.f12846g;
        if (feedBackButton != null) {
            feedBackButton.setVisibility(i4);
        }
    }

    public final FeedBackButton d() {
        if (this.f12846g == null) {
            i();
        }
        return this.f12846g;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003b A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004e A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0050 A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0053 A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063 A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0076 A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008e A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e() {
        /*
            r10 = this;
            com.mbridge.msdk.foundation.d.b r0 = com.mbridge.msdk.foundation.d.b.a()     // Catch:{ Exception -> 0x002a }
            java.lang.String r1 = r10.f12850k     // Catch:{ Exception -> 0x002a }
            java.lang.String r4 = f12839b     // Catch:{ Exception -> 0x002a }
            java.lang.String r5 = r10.f12845f     // Catch:{ Exception -> 0x002a }
            r2 = 0
            r3 = 1
            r0.a((java.lang.String) r1, (int) r2, (int) r3, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ Exception -> 0x002a }
            com.mbridge.msdk.foundation.d.b r0 = com.mbridge.msdk.foundation.d.b.a()     // Catch:{ Exception -> 0x002a }
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x002a }
            android.content.Context r1 = r1.c()     // Catch:{ Exception -> 0x002a }
            android.app.Activity r0 = r0.a((android.content.Context) r1)     // Catch:{ Exception -> 0x002a }
            com.mbridge.msdk.widget.dialog.MBFeedBackDialog r1 = r10.f12851l     // Catch:{ Exception -> 0x002a }
            if (r1 == 0) goto L_0x002c
            android.content.Context r1 = r1.getContext()     // Catch:{ Exception -> 0x002a }
            if (r1 == r0) goto L_0x002f
            goto L_0x002c
        L_0x002a:
            r0 = move-exception
            goto L_0x0092
        L_0x002c:
            r10.j()     // Catch:{ Exception -> 0x002a }
        L_0x002f:
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x002a }
            android.content.Context r0 = r0.c()     // Catch:{ Exception -> 0x002a }
            com.mbridge.msdk.widget.FeedBackButton r1 = r10.f12846g     // Catch:{ Exception -> 0x002a }
            if (r1 == 0) goto L_0x003f
            android.content.Context r0 = r1.getContext()     // Catch:{ Exception -> 0x002a }
        L_0x003f:
            com.mbridge.msdk.foundation.d.b r1 = com.mbridge.msdk.foundation.d.b.a()     // Catch:{ Exception -> 0x002a }
            java.lang.String r2 = r10.f12850k     // Catch:{ Exception -> 0x002a }
            com.mbridge.msdk.widget.dialog.MBFeedBackDialog r3 = r10.f12851l     // Catch:{ Exception -> 0x002a }
            boolean r1 = r1.a((java.lang.String) r2, (android.content.Context) r0, (com.mbridge.msdk.widget.dialog.MBFeedBackDialog) r3)     // Catch:{ Exception -> 0x002a }
            r2 = 2
            if (r1 == 0) goto L_0x0050
            r3 = 2
            goto L_0x0051
        L_0x0050:
            r3 = 3
        L_0x0051:
            if (r3 != r2) goto L_0x0063
            com.mbridge.msdk.foundation.d.b r4 = com.mbridge.msdk.foundation.d.b.a()     // Catch:{ Exception -> 0x002a }
            java.lang.String r5 = r10.f12850k     // Catch:{ Exception -> 0x002a }
            java.lang.String r8 = f12839b     // Catch:{ Exception -> 0x002a }
            java.lang.String r9 = r10.f12845f     // Catch:{ Exception -> 0x002a }
            r6 = 0
            r7 = 2
            r4.a((java.lang.String) r5, (int) r6, (int) r7, (java.lang.String) r8, (java.lang.String) r9)     // Catch:{ Exception -> 0x002a }
            goto L_0x0072
        L_0x0063:
            com.mbridge.msdk.foundation.d.b r4 = com.mbridge.msdk.foundation.d.b.a()     // Catch:{ Exception -> 0x002a }
            java.lang.String r5 = r10.f12850k     // Catch:{ Exception -> 0x002a }
            java.lang.String r8 = f12839b     // Catch:{ Exception -> 0x002a }
            java.lang.String r9 = r10.f12845f     // Catch:{ Exception -> 0x002a }
            r6 = 0
            r7 = 3
            r4.a((java.lang.String) r5, (int) r6, (int) r7, (java.lang.String) r8, (java.lang.String) r9)     // Catch:{ Exception -> 0x002a }
        L_0x0072:
            java.util.List<com.mbridge.msdk.foundation.d.a.a$a> r2 = r10.f12859t     // Catch:{ Exception -> 0x002a }
            if (r2 == 0) goto L_0x008c
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x002a }
        L_0x007a:
            boolean r4 = r2.hasNext()     // Catch:{ Exception -> 0x002a }
            if (r4 == 0) goto L_0x008c
            java.lang.Object r4 = r2.next()     // Catch:{ Exception -> 0x002a }
            com.mbridge.msdk.foundation.d.a.a$a r4 = (com.mbridge.msdk.foundation.d.a.a.C0180a) r4     // Catch:{ Exception -> 0x002a }
            if (r4 == 0) goto L_0x007a
            r4.a(r3)     // Catch:{ Exception -> 0x002a }
            goto L_0x007a
        L_0x008c:
            if (r1 != 0) goto L_0x0095
            r10.a((android.content.Context) r0)     // Catch:{ Exception -> 0x002a }
            return
        L_0x0092:
            r0.printStackTrace()
        L_0x0095:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.d.a.a.e():void");
    }

    /* renamed from: com.mbridge.msdk.foundation.d.a.a$a  reason: collision with other inner class name */
    public static class C0180a implements com.mbridge.msdk.widget.dialog.a {

        /* renamed from: a  reason: collision with root package name */
        private com.mbridge.msdk.foundation.d.a f12872a;

        /* renamed from: b  reason: collision with root package name */
        private String f12873b;

        public C0180a(String str, com.mbridge.msdk.foundation.d.a aVar) {
            this.f12872a = aVar;
            this.f12873b = str;
        }

        public final void a() {
            com.mbridge.msdk.foundation.d.b.f12876c = false;
            com.mbridge.msdk.foundation.d.a aVar = this.f12872a;
            if (aVar != null) {
                aVar.summit(a.f12839b);
            }
        }

        public final void b() {
            com.mbridge.msdk.foundation.d.b.f12876c = false;
            com.mbridge.msdk.foundation.d.a aVar = this.f12872a;
            if (aVar != null) {
                aVar.close();
            }
        }

        public final void c() {
            com.mbridge.msdk.foundation.d.a aVar = this.f12872a;
            if (aVar != null) {
                aVar.close();
            }
        }

        public final void a(int i4) {
            com.mbridge.msdk.foundation.d.b.f12876c = true;
            com.mbridge.msdk.foundation.d.a aVar = this.f12872a;
            if (aVar != null && i4 == 2) {
                aVar.showed();
            }
        }
    }

    public final void a() {
        FeedBackButton feedBackButton = this.f12846g;
        if (feedBackButton != null) {
            feedBackButton.setOnClickListener((View.OnClickListener) null);
            this.f12846g.setVisibility(8);
            ViewGroup viewGroup = (ViewGroup) this.f12846g.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f12846g);
            }
        }
        MBFeedBackDialog mBFeedBackDialog = this.f12851l;
        if (mBFeedBackDialog != null) {
            mBFeedBackDialog.cancel();
            this.f12851l.setListener((com.mbridge.msdk.widget.dialog.a) null);
        }
        this.f12851l = null;
        this.f12859t = null;
        this.f12846g = null;
        this.f12863x = null;
    }

    public final void b(int i4) {
        this.f12862w = i4;
    }

    static /* synthetic */ void b(a aVar) {
        com.mbridge.msdk.foundation.d.b.a().a(aVar.f12850k, 0, 4, f12839b, aVar.f12845f);
        List<C0180a> list = aVar.f12859t;
        if (list != null) {
            for (C0180a next : list) {
                if (next != null) {
                    next.b();
                }
            }
        }
        f12839b = "";
    }

    static /* synthetic */ void c(a aVar) {
        com.mbridge.msdk.foundation.d.b.a().a(aVar.f12850k, 0, 4, f12839b, aVar.f12845f);
        Context e5 = c.m().e();
        if (e5 == null) {
            e5 = c.m().c();
        }
        List<C0180a> list = aVar.f12859t;
        if (list != null) {
            for (C0180a next : list) {
                if (next != null) {
                    next.b();
                }
            }
        }
        aVar.a(e5);
        f12839b = "";
    }

    public final void a(CampaignEx campaignEx) {
        this.f12844e = campaignEx;
    }

    public final void a(String str) {
        this.f12845f = str;
    }

    private void a(Context context) {
        if (context != null) {
            try {
                com.mbridge.msdk.click.c.f(context, ak.a(this.f12844e));
            } catch (Exception unused) {
                com.mbridge.msdk.click.c.d(context, ak.a(this.f12844e));
            }
        }
    }

    private FeedbackRadioGroup a(b.C0173b bVar) {
        JSONArray b5 = bVar.b();
        Context c5 = c.m().c();
        if (b5 == null || b5.length() <= 0 || c5 == null) {
            return null;
        }
        FeedbackRadioGroup feedbackRadioGroup = new FeedbackRadioGroup(c5);
        feedbackRadioGroup.setOrientation(0);
        return feedbackRadioGroup;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.mbridge.msdk.widget.FeedbackRadioGroup r11, com.mbridge.msdk.c.b.C0173b r12) {
        /*
            r10 = this;
            org.json.JSONArray r12 = r12.b()
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r0 = r0.c()
            if (r12 == 0) goto L_0x007e
            int r1 = r12.length()
            if (r1 <= 0) goto L_0x007e
            if (r0 == 0) goto L_0x007e
            java.lang.String r1 = "mbridge_cm_feedback_choice_btn_bg"
            java.lang.String r2 = "drawable"
            com.mbridge.msdk.foundation.tools.x.a(r0, r1, r2)
            android.content.res.Resources r1 = com.mbridge.msdk.foundation.tools.x.a(r0)
            java.lang.String r2 = "mbridge_cm_feedback_rb_text_color_color_list"
            java.lang.String r3 = "color"
            int r2 = com.mbridge.msdk.foundation.tools.x.a(r0, r2, r3)
            if (r1 == 0) goto L_0x0034
            android.content.res.ColorStateList r1 = r1.getColorStateList(r2)     // Catch:{ Exception -> 0x0030 }
            goto L_0x0035
        L_0x0030:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0034:
            r1 = 0
        L_0x0035:
            r2 = 1065353216(0x3f800000, float:1.0)
            int r3 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r0, (float) r2)
            int r4 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r0, (float) r2)
            int r2 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r0, (float) r2)
            r5 = 0
        L_0x0044:
            int r6 = r12.length()
            if (r5 >= r6) goto L_0x007e
            java.lang.String r6 = r12.optString(r5)
            android.widget.RadioButton r7 = new android.widget.RadioButton
            r7.<init>(r0)
            r7.setButtonTintList(r1)
            r7.setText(r6)
            if (r1 == 0) goto L_0x005e
            r7.setTextColor(r1)
        L_0x005e:
            r7.setCompoundDrawablePadding(r3)
            r7.setPadding(r3, r4, r3, r4)
            android.text.TextUtils$TruncateAt r6 = android.text.TextUtils.TruncateAt.END
            r7.setEllipsize(r6)
            android.widget.RadioGroup$LayoutParams r6 = new android.widget.RadioGroup$LayoutParams
            r8 = -1
            r9 = -2
            r6.<init>(r8, r9)
            int r8 = r2 / 4
            r6.setMargins(r2, r8, r2, r8)
            r10.a((android.widget.RadioButton) r7)
            r11.addView(r7, r6)
            int r5 = r5 + 1
            goto L_0x0044
        L_0x007e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.d.a.a.a(com.mbridge.msdk.widget.FeedbackRadioGroup, com.mbridge.msdk.c.b$b):void");
    }

    private void a(RadioButton radioButton) {
        if (radioButton != null) {
            radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                    if (z4) {
                        String unused = a.f12839b = (String) compoundButton.getText();
                    }
                    if (a.this.f12851l != null) {
                        a.this.f12851l.setCancelButtonClickable(!TextUtils.isEmpty(a.f12839b));
                    }
                }
            });
        }
    }

    public final void a(FeedBackButton feedBackButton) {
        FeedBackButton feedBackButton2 = this.f12846g;
        int i4 = 8;
        if (feedBackButton2 != null) {
            feedBackButton2.setVisibility(8);
        }
        if (feedBackButton != null) {
            feedBackButton.setAlpha(this.f12842c);
            feedBackButton.setEnabled(this.f12842c != 0.0f);
            if (this.f12864y != 8) {
                i4 = 0;
            }
            feedBackButton.setVisibility(i4);
            this.f12846g = feedBackButton;
            CampaignEx campaignEx = this.f12844e;
            if (campaignEx != null && !campaignEx.isDynamicView()) {
                l();
            }
            feedBackButton.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.e();
                }
            });
        }
    }

    public final void a(int i4) {
        this.f12858s = i4;
    }

    public final void a(int i4, int i5, int i6, int i7, int i8, float f4, String str, String str2, float f5, JSONArray jSONArray) {
        if (i4 > -1) {
            this.f12840A = i4;
        }
        if (i5 > -1) {
            this.f12841B = i5;
        }
        if (i6 > -1) {
            this.f12865z = i6;
        }
        if (i7 > -1) {
            this.f12849j = i7;
        }
        if (f5 > -1.0f) {
            this.f12848i = f5;
        }
        if (jSONArray != null) {
            this.f12853n = jSONArray;
        }
        this.f12847h = str;
        this.f12843d = str2;
        this.f12842c = f4;
        this.f12860u = i8;
        l();
    }

    static /* synthetic */ void a(a aVar) {
        com.mbridge.msdk.foundation.d.b.a().a(aVar.f12850k, 1, 4, f12839b, aVar.f12845f);
        List<C0180a> list = aVar.f12859t;
        if (list != null) {
            for (C0180a next : list) {
                if (next != null) {
                    next.a();
                }
            }
        }
        if (!TextUtils.isEmpty(aVar.f12861v)) {
            try {
                Activity a5 = com.mbridge.msdk.foundation.d.b.a().a(c.m().c());
                if (a5 != null) {
                    View inflate = LayoutInflater.from(a5).inflate(x.a(a5, "mbridge_cm_feedback_notice_layout", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
                    Dialog dialog = new Dialog(a5, 3);
                    aVar.f12852m = dialog;
                    dialog.requestWindowFeature(1);
                    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                    Window window = aVar.f12852m.getWindow();
                    layoutParams.copyFrom(window.getAttributes());
                    layoutParams.width = -2;
                    layoutParams.height = -2;
                    aVar.f12852m.setContentView(inflate);
                    aVar.f12852m.show();
                    window.setAttributes(layoutParams);
                    inflate.postDelayed(new Runnable() {
                        public final void run() {
                            try {
                                if (a.this.f12852m != null && a.this.f12852m.isShowing()) {
                                    a.this.f12852m.dismiss();
                                }
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                    }, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        f12839b = "";
    }
}
