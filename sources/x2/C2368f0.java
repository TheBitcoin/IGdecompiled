package x2;

import N1.k;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import f2.C2011b;
import g2.C2038F;
import g2.C2048f;
import java.util.Arrays;
import kotlin.jvm.internal.m;
import u2.F;

/* renamed from: x2.f0  reason: case insensitive filesystem */
public final class C2368f0 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final C2011b f22376a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f22377b;

    /* renamed from: c  reason: collision with root package name */
    private final ImageView f22378c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f22379d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f22380e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f22381f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2368f0(View view, C2011b bVar, Context context) {
        super(view);
        m.e(view, "itemView");
        m.e(context, "context");
        this.f22376a = bVar;
        this.f22377b = context;
        View findViewById = view.findViewById(R.id.iv_icon_positive);
        m.d(findViewById, "findViewById(...)");
        this.f22378c = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_name_app_positive);
        m.d(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.f22379d = textView;
        View findViewById3 = view.findViewById(R.id.tv_version_app_positive);
        m.d(findViewById3, "findViewById(...)");
        TextView textView2 = (TextView) findViewById3;
        this.f22380e = textView2;
        View findViewById4 = view.findViewById(R.id.tv_count_positives);
        m.d(findViewById4, "findViewById(...)");
        TextView textView3 = (TextView) findViewById4;
        this.f22381f = textView3;
        view.setOnClickListener(new C2366e0(this));
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        textView2.setTypeface(aVar.x());
        textView3.setTypeface(aVar.x());
    }

    /* access modifiers changed from: private */
    public static final void b(C2368f0 f0Var, View view) {
        int bindingAdapterPosition;
        if (f0Var.f22376a != null && (bindingAdapterPosition = f0Var.getBindingAdapterPosition()) != -1) {
            f0Var.f22376a.a(bindingAdapterPosition);
        }
    }

    public final void c(C2048f fVar) {
        if (fVar != null) {
            this.f22378c.setImageDrawable(F.f21886a.k(this.f22377b, fVar.o()));
            this.f22379d.setText(fVar.m());
            this.f22380e.setText(fVar.B());
            if (fVar.p() != null) {
                kotlin.jvm.internal.F f4 = kotlin.jvm.internal.F.f20971a;
                String string = this.f22377b.getString(R.string.x_positives);
                m.d(string, "getString(...)");
                C2038F p4 = fVar.p();
                m.b(p4);
                String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(p4.b())}, 1));
                m.d(format, "format(...)");
                this.f22381f.setText(format);
            }
        }
    }
}
