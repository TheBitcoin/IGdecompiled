package com.uptodown.util.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.uptodown.R;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import w2.w;

public final class UsernameTextView extends AppCompatTextView {

    /* renamed from: k  reason: collision with root package name */
    public static final a f19434k = new a((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ValueAnimator f19435a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public float f19436b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int[] f19437c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Integer f19438d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public long f19439e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f19440f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f19441g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f19442h;

    /* renamed from: i  reason: collision with root package name */
    private String f19443i;

    /* renamed from: j  reason: collision with root package name */
    private Handler f19444j;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final void a(UsernameTextView usernameTextView, boolean z4, String str) {
            m.e(usernameTextView, "<this>");
            b(usernameTextView);
            ValueAnimator e5 = usernameTextView.f19435a;
            if (e5 != null) {
                e5.cancel();
            }
            usernameTextView.setTurbo(z4);
            usernameTextView.setUsernameFormat(str);
            if (str != null) {
                switch (str.hashCode()) {
                    case 110843959:
                        if (str.equals("type1")) {
                            usernameTextView.f19439e = AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS;
                            usernameTextView.f19440f = 200;
                            break;
                        }
                        break;
                    case 110843960:
                        if (str.equals("type2")) {
                            usernameTextView.f19439e = 4000;
                            usernameTextView.f19440f = 300;
                            break;
                        }
                        break;
                    case 110843961:
                        if (str.equals("type3")) {
                            usernameTextView.f19439e = 3000;
                            usernameTextView.f19440f = 400;
                            break;
                        }
                        break;
                }
            }
            usernameTextView.m(usernameTextView.f19440f);
        }

        public final void b(UsernameTextView usernameTextView) {
            m.e(usernameTextView, "<this>");
            ValueAnimator e5 = usernameTextView.f19435a;
            if (e5 != null) {
                e5.cancel();
            }
            usernameTextView.f19435a = null;
            usernameTextView.f19436b = 0.0f;
            usernameTextView.f19437c = null;
            usernameTextView.f19438d = Integer.valueOf(ContextCompat.getColor(usernameTextView.getContext(), R.color.text_terciary));
            usernameTextView.f19439e = 0;
            usernameTextView.f19440f = 0;
            usernameTextView.f19441g = false;
            usernameTextView.setTurbo(false);
            usernameTextView.setUsernameFormat((String) null);
            usernameTextView.getPaint().setShader((Shader) null);
            Handler animationHandler = usernameTextView.getAnimationHandler();
            if (animationHandler != null) {
                animationHandler.removeCallbacksAndMessages((Object) null);
            }
            usernameTextView.setAnimationHandler(new Handler(Looper.getMainLooper()));
            Integer b5 = usernameTextView.f19438d;
            m.b(b5);
            usernameTextView.setTextColor(b5.intValue());
            usernameTextView.invalidate();
        }

        private a() {
        }
    }

    public static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UsernameTextView f19445a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f19446b;

        b(UsernameTextView usernameTextView, long j4) {
            this.f19445a = usernameTextView;
            this.f19446b = j4;
        }

        /* access modifiers changed from: private */
        public static final void b(UsernameTextView usernameTextView, ValueAnimator valueAnimator) {
            m.e(valueAnimator, "it");
            Object animatedValue = valueAnimator.getAnimatedValue();
            m.c(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            usernameTextView.f19436b = ((Float) animatedValue).floatValue();
            usernameTextView.invalidate();
        }

        public void run() {
            ValueAnimator e5 = this.f19445a.f19435a;
            if (e5 != null) {
                e5.cancel();
            }
            UsernameTextView usernameTextView = this.f19445a;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            long j4 = this.f19446b;
            UsernameTextView usernameTextView2 = this.f19445a;
            ofFloat.setDuration(j4);
            ofFloat.setRepeatCount(1);
            ofFloat.setRepeatMode(2);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.addUpdateListener(new w(usernameTextView2));
            usernameTextView.f19435a = ofFloat;
            ValueAnimator e6 = this.f19445a.f19435a;
            if (e6 != null) {
                e6.start();
            }
            this.f19445a.f19441g = true;
            Handler animationHandler = this.f19445a.getAnimationHandler();
            if (animationHandler != null) {
                animationHandler.postDelayed(this, this.f19445a.f19439e);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UsernameTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (C2103g) null);
        m.e(context, "context");
    }

    /* access modifiers changed from: private */
    public final void m(long j4) {
        if (this.f19442h) {
            n();
            this.f19444j = new Handler(Looper.getMainLooper());
            b bVar = new b(this, j4);
            String str = this.f19443i;
            if (str != null) {
                switch (str.hashCode()) {
                    case 110843959:
                        if (str.equals("type1")) {
                            int color = ContextCompat.getColor(getContext(), R.color.turbo_username_type_1_1);
                            this.f19437c = new int[]{color, ContextCompat.getColor(getContext(), R.color.turbo_username_type_1_2), color, color, color};
                            break;
                        }
                        break;
                    case 110843960:
                        if (str.equals("type2")) {
                            int color2 = ContextCompat.getColor(getContext(), R.color.turbo_username_type_2_1);
                            this.f19437c = new int[]{color2, ContextCompat.getColor(getContext(), R.color.turbo_username_type_2_2), color2, color2, color2};
                            break;
                        }
                        break;
                    case 110843961:
                        if (str.equals("type3")) {
                            int color3 = ContextCompat.getColor(getContext(), R.color.turbo_username_type_3_1);
                            this.f19437c = new int[]{color3, ContextCompat.getColor(getContext(), R.color.turbo_username_type_3_2), color3, color3, color3};
                            break;
                        }
                        break;
                }
            }
            Handler handler = this.f19444j;
            if (handler != null) {
                handler.post(bVar);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void n() {
        /*
            r2 = this;
            android.text.TextPaint r0 = r2.getPaint()
            r1 = 0
            r0.setShader(r1)
            java.lang.String r0 = r2.f19443i
            if (r0 == 0) goto L_0x0052
            int r1 = r0.hashCode()
            switch(r1) {
                case 110843959: goto L_0x003e;
                case 110843960: goto L_0x0029;
                case 110843961: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0052
        L_0x0014:
            java.lang.String r1 = "type3"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x001d
            goto L_0x0052
        L_0x001d:
            android.content.Context r0 = r2.getContext()
            r1 = 2131100671(0x7f0603ff, float:1.781373E38)
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r1)
            goto L_0x005d
        L_0x0029:
            java.lang.String r1 = "type2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0032
            goto L_0x0052
        L_0x0032:
            android.content.Context r0 = r2.getContext()
            r1 = 2131100669(0x7f0603fd, float:1.7813726E38)
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r1)
            goto L_0x005d
        L_0x003e:
            java.lang.String r1 = "type1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0052
            android.content.Context r0 = r2.getContext()
            r1 = 2131100667(0x7f0603fb, float:1.7813722E38)
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r1)
            goto L_0x005d
        L_0x0052:
            android.content.Context r0 = r2.getContext()
            r1 = 2131100647(0x7f0603e7, float:1.7813681E38)
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r1)
        L_0x005d:
            r2.setTextColor(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.util.views.UsernameTextView.n():void");
    }

    public final Handler getAnimationHandler() {
        return this.f19444j;
    }

    public final String getUsernameFormat() {
        return this.f19443i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        m.e(canvas, "canvas");
        if (this.f19437c != null) {
            ValueAnimator valueAnimator = this.f19435a;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                n();
            } else {
                float width = (float) getWidth();
                int[] iArr = this.f19437c;
                m.b(iArr);
                float f4 = this.f19436b;
                getPaint().setShader(new LinearGradient(0.0f, 0.0f, width, 0.0f, iArr, new float[]{0.0f, f4, f4, f4, 1.0f}, Shader.TileMode.CLAMP));
            }
        } else {
            Integer num = this.f19438d;
            if (num != null) {
                m.b(num);
                setTextColor(num.intValue());
            }
        }
        super.onDraw(canvas);
    }

    public final void setAnimationHandler(Handler handler) {
        this.f19444j = handler;
    }

    public final void setTurbo(boolean z4) {
        this.f19442h = z4;
    }

    public final void setUsernameFormat(String str) {
        this.f19443i = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UsernameTextView(Context context, AttributeSet attributeSet, int i4, int i5, C2103g gVar) {
        this(context, (i5 & 2) != 0 ? null : attributeSet, (i5 & 4) != 0 ? 0 : i4);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UsernameTextView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        m.e(context, "context");
        this.f19444j = new Handler(Looper.getMainLooper());
        this.f19438d = Integer.valueOf(getCurrentTextColor());
    }
}
