package x2;

import N1.k;
import W1.i;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import f2.C2012c;
import g2.C2063v;
import kotlin.jvm.internal.m;

/* renamed from: x2.d  reason: case insensitive filesystem */
public final class C2362d extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private C2012c f22332a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f22333b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f22334c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f22335d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f22336e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2362d(View view, C2012c cVar) {
        super(view);
        m.e(view, "itemView");
        m.e(cVar, "listener");
        this.f22332a = cVar;
        View findViewById = view.findViewById(R.id.rl_app_file_item);
        m.d(findViewById, "findViewById(...)");
        this.f22333b = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_type_app_file_item);
        m.d(findViewById2, "findViewById(...)");
        this.f22334c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_name_app_file_item);
        m.d(findViewById3, "findViewById(...)");
        this.f22335d = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_size_app_file_item);
        m.d(findViewById4, "findViewById(...)");
        this.f22336e = (TextView) findViewById4;
        TextView textView = this.f22334c;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.x());
        this.f22335d.setTypeface(aVar.w());
        this.f22336e.setTypeface(aVar.x());
    }

    /* access modifiers changed from: private */
    public static final void c(C2362d dVar, C2063v vVar, View view) {
        dVar.f22332a.a(vVar);
    }

    public final void b(C2063v vVar) {
        m.e(vVar, "fileInfo");
        this.f22333b.setOnClickListener(new C2359c(this, vVar));
        String b5 = vVar.b();
        if (b5 != null) {
            TextView textView = this.f22334c;
            String substring = b5.substring(m3.m.R(b5, ".", 0, false, 6, (Object) null) + 1);
            m.d(substring, "substring(...)");
            textView.setText(substring);
        }
        this.f22335d.setText(vVar.b());
        TextView textView2 = this.f22336e;
        i iVar = new i();
        long d5 = vVar.d();
        Context context = this.itemView.getContext();
        m.d(context, "getContext(...)");
        textView2.setText(iVar.d(d5, context));
    }
}
