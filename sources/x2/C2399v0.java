package x2;

import N1.k;
import W1.s;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import f2.C2005D;
import g2.C2048f;
import kotlin.jvm.internal.m;

/* renamed from: x2.v0  reason: case insensitive filesystem */
public final class C2399v0 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final C2005D f22521a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f22522b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f22523c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f22524d;

    /* renamed from: e  reason: collision with root package name */
    private final ImageView f22525e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2399v0(View view, C2005D d5) {
        super(view);
        m.e(view, "itemView");
        this.f22521a = d5;
        View findViewById = view.findViewById(R.id.tv_name_rollback_item);
        m.d(findViewById, "findViewById(...)");
        TextView textView = (TextView) findViewById;
        this.f22522b = textView;
        View findViewById2 = view.findViewById(R.id.tv_version_rollback_item);
        m.d(findViewById2, "findViewById(...)");
        TextView textView2 = (TextView) findViewById2;
        this.f22523c = textView2;
        View findViewById3 = view.findViewById(R.id.tv_size_rollback_item);
        m.d(findViewById3, "findViewById(...)");
        TextView textView3 = (TextView) findViewById3;
        this.f22524d = textView3;
        View findViewById4 = view.findViewById(R.id.iv_icon_rollback_item);
        m.d(findViewById4, "findViewById(...)");
        this.f22525e = (ImageView) findViewById4;
        view.setOnClickListener(new C2397u0(this));
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        textView2.setTypeface(aVar.x());
        textView3.setTypeface(aVar.w());
    }

    /* access modifiers changed from: private */
    public static final void b(C2399v0 v0Var, View view) {
        int bindingAdapterPosition;
        if (v0Var.f22521a != null && (bindingAdapterPosition = v0Var.getBindingAdapterPosition()) != -1) {
            v0Var.f22521a.a(bindingAdapterPosition);
        }
    }

    public final void c(C2048f fVar, Context context) {
        m.e(fVar, "item");
        m.e(context, "context");
        try {
            PackageManager packageManager = context.getPackageManager();
            m.d(packageManager, "getPackageManager(...)");
            String o4 = fVar.o();
            m.b(o4);
            this.f22525e.setImageDrawable(s.d(packageManager, o4, 0).applicationInfo.loadIcon(context.getPackageManager()));
        } catch (Exception e5) {
            this.f22525e.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_uptodown_logo_disabled));
            e5.printStackTrace();
        }
        this.f22522b.setText(fVar.m());
        this.f22523c.setText(fVar.B());
        this.f22524d.setText(fVar.u(context));
    }
}
