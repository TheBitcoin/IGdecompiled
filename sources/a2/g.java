package a2;

import N1.f;
import N1.k;
import S1.l;
import android.view.View;
import android.widget.CheckBox;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.m;

public final class g extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public CheckBox f8915a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(View view, l lVar) {
        super(view);
        m.e(view, "itemView");
        m.e(lVar, "listener");
        View findViewById = view.findViewById(f.cb_split_item);
        m.d(findViewById, "itemView.findViewById(R.id.cb_split_item)");
        this.f8915a = (CheckBox) findViewById;
        view.setOnClickListener(new f(this, lVar));
        this.f8915a.setTypeface(k.f7778g.x());
    }

    /* access modifiers changed from: private */
    public static final void b(g gVar, l lVar, View view) {
        m.e(gVar, "this$0");
        m.e(lVar, "$listener");
        int absoluteAdapterPosition = gVar.getAbsoluteAdapterPosition();
        if (absoluteAdapterPosition != -1) {
            lVar.a(view, absoluteAdapterPosition);
        }
    }
}
