package a2;

import N1.f;
import N1.k;
import S1.j;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.m;

public final class b extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private TextView f8902a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view, j jVar) {
        super(view);
        m.e(view, "itemView");
        View findViewById = view.findViewById(f.tv_device_name);
        m.d(findViewById, "itemView.findViewById(R.id.tv_device_name)");
        this.f8902a = (TextView) findViewById;
        view.setOnClickListener(new C1614a(jVar, this));
        this.f8902a.setTypeface(k.f7778g.x());
    }

    /* access modifiers changed from: private */
    public static final void b(j jVar, b bVar, View view) {
        int absoluteAdapterPosition;
        m.e(bVar, "this$0");
        if (jVar != null && (absoluteAdapterPosition = bVar.getAbsoluteAdapterPosition()) != -1) {
            jVar.a(view, absoluteAdapterPosition);
        }
    }

    public final TextView c() {
        return this.f8902a;
    }
}
