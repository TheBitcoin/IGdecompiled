package x2;

import N1.k;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import f2.I;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
import y2.n;

/* renamed from: x2.d1  reason: case insensitive filesystem */
public final class C2364d1 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final I f22349a;

    /* renamed from: b  reason: collision with root package name */
    private final LinearLayout f22350b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f22351c;

    /* renamed from: d  reason: collision with root package name */
    private final ImageView f22352d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f22353e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f22354f;

    /* renamed from: g  reason: collision with root package name */
    private final RelativeLayout f22355g;

    /* renamed from: h  reason: collision with root package name */
    private final ImageView f22356h;

    /* renamed from: i  reason: collision with root package name */
    private final int f22357i = 600;

    /* renamed from: j  reason: collision with root package name */
    private long f22358j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2364d1(View view, I i4) {
        super(view);
        m.e(view, "itemView");
        m.e(i4, "listener");
        this.f22349a = i4;
        View findViewById = view.findViewById(R.id.ll_uptodown_protect);
        m.d(findViewById, "findViewById(...)");
        this.f22350b = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_uptodown_protect);
        m.d(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.f22351c = textView;
        View findViewById3 = view.findViewById(R.id.iv_shield);
        m.d(findViewById3, "findViewById(...)");
        this.f22352d = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_title);
        m.d(findViewById4, "findViewById(...)");
        TextView textView2 = (TextView) findViewById4;
        this.f22353e = textView2;
        View findViewById5 = view.findViewById(R.id.tv_msg);
        m.d(findViewById5, "findViewById(...)");
        TextView textView3 = (TextView) findViewById5;
        this.f22354f = textView3;
        View findViewById6 = view.findViewById(R.id.rl_reload);
        m.d(findViewById6, "findViewById(...)");
        this.f22355g = (RelativeLayout) findViewById6;
        View findViewById7 = view.findViewById(R.id.iv_reload);
        m.d(findViewById7, "findViewById(...)");
        this.f22356h = (ImageView) findViewById7;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        textView2.setTypeface(aVar.x());
        textView3.setTypeface(aVar.x());
    }

    /* access modifiers changed from: private */
    public static final void e(C2364d1 d1Var, Context context, View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - d1Var.f22358j > ((long) d1Var.f22357i)) {
            d1Var.f22358j = currentTimeMillis;
            new n(context).f(-1, d1Var.f22356h, R.anim.rotate);
            d1Var.f22349a.b();
        }
    }

    /* access modifiers changed from: private */
    public static final void f(C2364d1 d1Var, View view) {
        d1Var.f22349a.a();
    }

    public final void d(ArrayList arrayList, Context context) {
        m.e(context, "context");
        this.f22350b.setVisibility(0);
        this.f22355g.setOnClickListener(new C2355a1(this, context));
        if (arrayList == null || arrayList.size() <= 0) {
            this.f22352d.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_shield_protect_ok));
            this.f22353e.setText(R.string.no_positives_title_security_badge);
            this.f22354f.setText(R.string.no_positives_msg_security_badge);
            this.f22355g.setBackground(ContextCompat.getDrawable(context, R.drawable.ripple_blue_primary_button));
            this.itemView.setOnClickListener(new C2361c1());
        } else {
            this.f22352d.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_shield_protect_bad));
            this.f22353e.setText(R.string.positives_title_security_badge);
            this.f22354f.setText(R.string.positives_msg_security_badge);
            this.f22355g.setBackground(ContextCompat.getDrawable(context, R.drawable.ripple_cancel_button));
            this.itemView.setOnClickListener(new C2358b1(this));
        }
        if (this.f22356h.getAnimation() != null && this.f22356h.getAnimation().getRepeatCount() != 0) {
            this.f22356h.getAnimation().setRepeatCount(0);
        }
    }

    /* access modifiers changed from: private */
    public static final void g(View view) {
    }
}
