package x2;

import N1.k;
import W1.i;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.workers.DownloadWorker;
import f2.x;
import g2.C2035C;
import g2.C2048f;
import g2.C2050h;
import g2.C2060s;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
import u2.t;

/* renamed from: x2.d0  reason: case insensitive filesystem */
public final class C2363d0 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final x f22337a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f22338b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f22339c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f22340d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f22341e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f22342f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f22343g;

    /* renamed from: h  reason: collision with root package name */
    private RelativeLayout f22344h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f22345i;

    /* renamed from: j  reason: collision with root package name */
    private final float f22346j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    private final float f22347k = 0.4f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2363d0(View view, x xVar) {
        super(view);
        m.e(view, "itemView");
        this.f22337a = xVar;
        View findViewById = view.findViewById(R.id.tv_version_old_version_item);
        m.d(findViewById, "findViewById(...)");
        this.f22338b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_date_old_version_item);
        m.d(findViewById2, "findViewById(...)");
        this.f22339c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_type_old_version_item);
        m.d(findViewById3, "findViewById(...)");
        this.f22340d = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_min_sdk_old_version_item);
        m.d(findViewById4, "findViewById(...)");
        this.f22341e = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.iv_download_old_version_item);
        m.d(findViewById5, "findViewById(...)");
        this.f22342f = (ImageView) findViewById5;
        View findViewById6 = view.findViewById(R.id.pb_progress_old_version);
        m.d(findViewById6, "findViewById(...)");
        this.f22343g = (ProgressBar) findViewById6;
        View findViewById7 = view.findViewById(R.id.rl_download_old_version_item);
        m.d(findViewById7, "findViewById(...)");
        this.f22344h = (RelativeLayout) findViewById7;
        View findViewById8 = view.findViewById(R.id.iv_virustotal_report);
        m.d(findViewById8, "findViewById(...)");
        this.f22345i = (ImageView) findViewById8;
        this.f22344h.setOnClickListener(new Z(this));
        this.f22345i.setOnClickListener(new C2354a0(this));
        TextView textView = this.f22338b;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        this.f22339c.setTypeface(aVar.x());
        this.f22340d.setTypeface(aVar.w());
        this.f22341e.setTypeface(aVar.x());
    }

    /* access modifiers changed from: private */
    public static final void e(C2363d0 d0Var, View view) {
        int bindingAdapterPosition;
        if (d0Var.f22337a != null && (bindingAdapterPosition = d0Var.getBindingAdapterPosition()) != -1) {
            d0Var.f22337a.c(bindingAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final void f(C2363d0 d0Var, View view) {
        int bindingAdapterPosition;
        if (d0Var.f22337a != null && (bindingAdapterPosition = d0Var.getBindingAdapterPosition()) != -1) {
            d0Var.f22337a.b(bindingAdapterPosition);
        }
    }

    private final void i() {
        this.f22342f.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.core_vector_cross));
        this.f22344h.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.core_ripple_bg_card));
        this.f22342f.setContentDescription(this.itemView.getContext().getString(R.string.option_button_cancel));
    }

    private final void j() {
        if (this.f22343g.getVisibility() == 0) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f22347k, this.f22346j});
            ofFloat.setStartDelay(200);
            ofFloat.setDuration(300);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.addUpdateListener(new C2360c0(this));
            m.b(ofFloat);
            ofFloat.addListener(new a(this));
            ofFloat.start();
        }
    }

    /* access modifiers changed from: private */
    public static final void k(C2363d0 d0Var, ValueAnimator valueAnimator) {
        m.e(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        m.c(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        d0Var.f22340d.setScaleX(floatValue);
        d0Var.f22340d.setScaleY(floatValue);
        int i4 = (int) (((float) 10) * (((float) 1) - floatValue));
        d0Var.f22340d.setPadding(i4, i4, i4, i4);
    }

    private final void l() {
        if (this.f22343g.getVisibility() == 8) {
            this.f22343g.setVisibility(0);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f22346j, this.f22347k});
            ofFloat.setDuration(300);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.addUpdateListener(new C2357b0(this));
            ofFloat.start();
        }
    }

    /* access modifiers changed from: private */
    public static final void m(C2363d0 d0Var, ValueAnimator valueAnimator) {
        m.e(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        m.c(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        d0Var.f22340d.setScaleX(floatValue);
        d0Var.f22340d.setScaleY(floatValue);
        int i4 = (int) (((float) 10) * (((float) 1) - floatValue));
        d0Var.f22340d.setPadding(i4, i4, i4, i4);
    }

    private final void n() {
        this.f22342f.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_action_install));
        this.f22344h.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.ripple_install_button));
        this.f22342f.setContentDescription(this.itemView.getContext().getString(R.string.action_update));
    }

    public final void h(C2050h hVar, C2048f fVar, int i4) {
        boolean z4;
        boolean z5;
        int i5 = i4;
        C2050h hVar2 = hVar;
        m.e(hVar2, "appInfo");
        t.a aVar = t.f21927u;
        Context context = this.itemView.getContext();
        m.d(context, "getContext(...)");
        t a5 = aVar.a(context);
        a5.a();
        ArrayList O4 = hVar2.O();
        m.b(O4);
        String a6 = ((C2035C) O4.get(i5)).a();
        m.b(a6);
        C2060s f02 = a5.f0(a6);
        if (f02 == null || !DownloadWorker.f19459d.k(f02.h(), f02.E())) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (f02 == null || !f02.K()) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (!z4 && !z5) {
            this.f22343g.setVisibility(8);
            this.f22340d.setScaleX(this.f22346j);
            this.f22340d.setScaleY(this.f22346j);
            this.f22340d.setPadding(10, 10, 10, 10);
        }
        ArrayList O5 = hVar2.O();
        m.b(O5);
        String b5 = ((C2035C) O5.get(i5)).b();
        TextView textView = this.f22340d;
        ArrayList O6 = hVar2.O();
        m.b(O6);
        textView.setText(((C2035C) O6.get(i5)).b());
        String str = null;
        if (m3.m.q(b5, "xapk", false, 2, (Object) null)) {
            this.f22340d.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_old_version_xapk_type));
        } else {
            this.f22340d.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_old_version_apk_type));
        }
        TextView textView2 = this.f22338b;
        ArrayList O7 = hVar2.O();
        m.b(O7);
        textView2.setText(((C2035C) O7.get(i5)).h());
        if (fVar != null) {
            long A4 = fVar.A();
            ArrayList O8 = hVar2.O();
            m.b(O8);
            if (A4 == ((C2035C) O8.get(i5)).g()) {
                this.f22344h.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.ripple_install_button));
                this.f22342f.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_action_install));
                this.f22342f.setContentDescription(this.itemView.getContext().getString(R.string.option_button_install));
                this.f22341e.setVisibility(0);
                TextView textView3 = this.f22341e;
                ArrayList O9 = hVar2.O();
                m.b(O9);
                textView3.setText(((C2035C) O9.get(i5)).d());
                this.f22339c.setVisibility(0);
                TextView textView4 = this.f22339c;
                ArrayList O10 = hVar2.O();
                m.b(O10);
                textView4.setText(((C2035C) O10.get(i5)).c());
                j();
                a5.i();
            }
        }
        if (z4) {
            i();
            l();
            m.b(f02);
            if (f02.x() > 0) {
                this.f22343g.setIndeterminate(false);
                this.f22343g.setProgress(f02.x());
            } else {
                this.f22343g.setIndeterminate(true);
            }
            TextView textView5 = this.f22339c;
            Context context2 = this.itemView.getContext();
            Integer valueOf = Integer.valueOf(f02.x());
            i iVar = new i();
            long z6 = f02.z();
            Context context3 = this.itemView.getContext();
            m.d(context3, "getContext(...)");
            textView5.setText(context2.getString(R.string.percent_of_total_size, new Object[]{valueOf, iVar.d(z6, context3)}));
            this.f22341e.setText(this.itemView.getContext().getString(R.string.verified_by_uptodown));
            this.f22341e.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_myappsupdates_dialog_vt_report), (Drawable) null, (Drawable) null, (Drawable) null);
            this.f22341e.setCompoundDrawablePadding((int) this.itemView.getContext().getResources().getDimension(R.dimen.margin_s));
        } else if (f02 == null || f02.x() != 0) {
            TextView textView6 = this.f22339c;
            ArrayList O11 = hVar2.O();
            m.b(O11);
            textView6.setText(((C2035C) O11.get(i5)).c());
            TextView textView7 = this.f22341e;
            ArrayList O12 = hVar2.O();
            m.b(O12);
            textView7.setText(((C2035C) O12.get(i5)).d());
            this.f22341e.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f22341e.setCompoundDrawablePadding(0);
            j();
            T1.a i6 = k.f7778g.i();
            if (i6 != null) {
                str = i6.b();
            }
            if (m3.m.p(str, hVar2.Q(), true) && i6 != null) {
                long e5 = i6.e();
                ArrayList O13 = hVar2.O();
                m.b(O13);
                if (e5 == ((C2035C) O13.get(i5)).g()) {
                    l();
                    this.f22343g.setIndeterminate(true);
                    this.f22344h.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_download_button_desactivated));
                    this.f22342f.setVisibility(4);
                    this.f22344h.setClickable(false);
                }
            }
            this.f22343g.setIndeterminate(false);
            this.f22343g.setVisibility(8);
            this.f22339c.setVisibility(0);
            this.f22341e.setVisibility(0);
            if (f02 == null || !f02.f()) {
                this.f22342f.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_action_download));
                this.f22344h.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.ripple_open_button));
                this.f22342f.setContentDescription(this.itemView.getContext().getString(R.string.updates_button_download_app));
            } else if (fVar == null) {
                this.f22342f.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_action_install));
                this.f22344h.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.ripple_install_button));
                this.f22342f.setContentDescription(this.itemView.getContext().getString(R.string.option_button_install));
            } else {
                n();
            }
        } else {
            l();
            i();
            this.f22343g.setIndeterminate(true);
            TextView textView8 = this.f22339c;
            ArrayList O14 = hVar2.O();
            m.b(O14);
            textView8.setText(((C2035C) O14.get(i5)).c());
            TextView textView9 = this.f22341e;
            ArrayList O15 = hVar2.O();
            m.b(O15);
            textView9.setText(((C2035C) O15.get(i5)).d());
            this.f22341e.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f22341e.setCompoundDrawablePadding(0);
        }
        a5.i();
    }

    /* renamed from: x2.d0$a */
    public static final class a implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2363d0 f22348a;

        public a(C2363d0 d0Var) {
            this.f22348a = d0Var;
        }

        public void onAnimationEnd(Animator animator) {
            this.f22348a.f22343g.setVisibility(8);
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }
}
