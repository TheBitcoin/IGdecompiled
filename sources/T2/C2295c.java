package t2;

import N1.k;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.mbridge.msdk.MBridgeConstans;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.Gallery;
import f2.C2019j;
import g2.C2050h;
import g2.C2053k;
import g2.C2059q;
import g2.O;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.m;
import s2.C2279b;

/* renamed from: t2.c  reason: case insensitive filesystem */
public final class C2295c extends Presenter.ViewHolder {

    /* renamed from: j  reason: collision with root package name */
    public static final a f21821j = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final TextView f21822a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f21823b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f21824c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f21825d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f21826e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f21827f;

    /* renamed from: g  reason: collision with root package name */
    private final ProgressBar f21828g;

    /* renamed from: h  reason: collision with root package name */
    private final LinearLayout f21829h;

    /* renamed from: i  reason: collision with root package name */
    private final RelativeLayout f21830i;

    /* renamed from: t2.c$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    /* renamed from: t2.c$b */
    public static final class b implements C2019j {
        b() {
        }

        public void a(long j4) {
            UptodownApp.f17422D.a0();
        }

        public void b(C2053k kVar) {
            m.e(kVar, "category");
            UptodownApp.f17422D.a0();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2295c(View view) {
        super(view);
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        View findViewById = view.findViewById(R.id.tv_name);
        m.d(findViewById, "findViewById(...)");
        this.f21822a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_short_desc);
        m.d(findViewById2, "findViewById(...)");
        this.f21823b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_description);
        m.d(findViewById3, "findViewById(...)");
        this.f21824c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_percent);
        m.d(findViewById4, "findViewById(...)");
        this.f21825d = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.tv_version);
        m.d(findViewById5, "findViewById(...)");
        this.f21826e = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.tv_autor);
        m.d(findViewById6, "findViewById(...)");
        this.f21827f = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.pb_download);
        m.d(findViewById7, "findViewById(...)");
        this.f21828g = (ProgressBar) findViewById7;
        this.f21829h = (LinearLayout) view.findViewById(R.id.ll_screenshots);
        View findViewById8 = view.findViewById(R.id.rl_contaier_valoration_tv_app_detail);
        m.d(findViewById8, "findViewById(...)");
        this.f21830i = (RelativeLayout) findViewById8;
    }

    /* access modifiers changed from: private */
    public static final void e(C2050h hVar, View view) {
        Object tag = view.getTag();
        m.c(tag, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) tag).intValue();
        Intent intent = new Intent(view.getContext(), Gallery.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("images", hVar.h0());
        bundle.putInt("index", intValue);
        intent.putExtra("bundle", bundle);
        view.getContext().startActivity(intent);
    }

    /* access modifiers changed from: private */
    public static final void f(int i4, View view, boolean z4) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, i4);
        if (z4) {
            view.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.main_light_grey));
            layoutParams.setMargins(12, 0, 12, 12);
        } else {
            view.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.transparent));
            layoutParams.setMargins(12, 12, 12, 12);
        }
        view.setLayoutParams(layoutParams);
    }

    private final void g(Context context, C2050h hVar) {
        if (hVar.V() == 0) {
            this.f21830i.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f21830i.findViewById(R.id.tv_valoration_value_tv_app_detail);
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.x());
        textView.setText(String.valueOf(((double) hVar.V()) / 10.0d));
        TextView textView2 = (TextView) this.f21830i.findViewById(R.id.tv_num_ratings);
        textView2.setTypeface(aVar.x());
        textView2.setText(String.valueOf(hVar.W()));
        View findViewById = this.f21830i.findViewById(R.id.iv_star1);
        m.d(findViewById, "findViewById(...)");
        ImageView imageView = (ImageView) findViewById;
        View findViewById2 = this.f21830i.findViewById(R.id.iv_star2);
        m.d(findViewById2, "findViewById(...)");
        ImageView imageView2 = (ImageView) findViewById2;
        View findViewById3 = this.f21830i.findViewById(R.id.iv_star3);
        m.d(findViewById3, "findViewById(...)");
        ImageView imageView3 = (ImageView) findViewById3;
        View findViewById4 = this.f21830i.findViewById(R.id.iv_star4);
        m.d(findViewById4, "findViewById(...)");
        ImageView imageView4 = (ImageView) findViewById4;
        View findViewById5 = this.f21830i.findViewById(R.id.iv_star5);
        m.d(findViewById5, "findViewById(...)");
        ImageView imageView5 = (ImageView) findViewById5;
        imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
        imageView2.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
        imageView3.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
        imageView4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
        imageView5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
        if (hVar.V() > 5) {
            imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
        }
        if (hVar.V() > 15) {
            imageView2.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
        }
        if (hVar.V() > 25) {
            imageView3.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
        }
        if (hVar.V() > 35) {
            imageView4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
        }
        if (hVar.V() > 45) {
            imageView5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
        }
    }

    public final void c(Context context, C2050h hVar, int i4) {
        m.e(context, "context");
        m.e(hVar, "appInfo");
        this.f21822a.setText(hVar.L());
        this.f21823b.setText(hVar.j0());
        if (hVar.j() != null) {
            TextView textView = this.f21824c;
            C2059q.a aVar = C2059q.f20700f;
            String j4 = hVar.j();
            m.b(j4);
            textView.setText(aVar.m(j4, context, new b()));
        }
        h(i4);
        this.f21826e.setText(hVar.w0());
        this.f21827f.setText(hVar.g());
        g(context, hVar);
    }

    public final void d(Context context, C2050h hVar) {
        ArrayList arrayList;
        LinearLayout linearLayout;
        m.e(context, "context");
        if (hVar != null) {
            arrayList = hVar.h0();
        } else {
            arrayList = null;
        }
        if (arrayList != null && (linearLayout = this.f21829h) != null) {
            if (linearLayout.getChildCount() > 0) {
                this.f21829h.removeAllViews();
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
            layoutParams.setMargins(12, 12, 12, 12);
            ArrayList h02 = hVar.h0();
            m.b(h02);
            int size = h02.size();
            for (int i4 = 0; i4 < size; i4++) {
                C2279b bVar = new C2279b(context);
                s h4 = s.h();
                ArrayList h03 = hVar.h0();
                m.b(h03);
                h4.l(((O) h03.get(i4)).d()).i(bVar);
                bVar.setPadding(4, 4, 4, 4);
                bVar.setLayoutParams(layoutParams);
                bVar.setFocusable(true);
                bVar.setTag(Integer.valueOf(i4));
                bVar.setOnClickListener(new C2293a(hVar));
                bVar.setOnFocusChangeListener(new C2294b(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
                this.f21829h.addView(bVar);
            }
        }
    }

    public final void h(int i4) {
        if (i4 > 0) {
            this.f21828g.setVisibility(0);
            this.f21828g.setProgress(i4);
            this.f21825d.setVisibility(0);
            TextView textView = this.f21825d;
            F f4 = F.f20971a;
            String format = String.format("%s%%", Arrays.copyOf(new Object[]{String.valueOf(i4)}, 1));
            m.d(format, "format(...)");
            textView.setText(format);
            return;
        }
        this.f21828g.setVisibility(8);
        this.f21825d.setVisibility(8);
    }

    public final void i(boolean z4) {
        this.f21828g.setIndeterminate(z4);
    }
}
