package d4;

import A1.c;
import V3.p;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import java.util.List;

public final class m extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    public List f24577a;

    /* renamed from: b  reason: collision with root package name */
    public a f24578b;

    /* renamed from: c  reason: collision with root package name */
    public Integer f24579c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f24580d;

    /* renamed from: e  reason: collision with root package name */
    public Typeface f24581e;

    public interface a {
        void e(p pVar);
    }

    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final a f24582a;

        /* renamed from: b  reason: collision with root package name */
        public Integer f24583b;

        /* renamed from: c  reason: collision with root package name */
        public Integer f24584c;

        /* renamed from: d  reason: collision with root package name */
        public Typeface f24585d;

        /* renamed from: e  reason: collision with root package name */
        public final ConstraintLayout f24586e;

        /* renamed from: f  reason: collision with root package name */
        public final ImageView f24587f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f24588g;

        /* renamed from: h  reason: collision with root package name */
        public final TextView f24589h;

        /* renamed from: i  reason: collision with root package name */
        public final View f24590i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view, a aVar, Integer num, Integer num2, Typeface typeface) {
            super(view);
            kotlin.jvm.internal.m.e(view, "rootView");
            kotlin.jvm.internal.m.e(aVar, "listener");
            this.f24582a = aVar;
            this.f24583b = num;
            this.f24584c = num2;
            this.f24585d = typeface;
            View findViewById = view.findViewById(A1.b.cl_item_container);
            kotlin.jvm.internal.m.d(findViewById, "rootView.findViewById(R.id.cl_item_container)");
            this.f24586e = (ConstraintLayout) findViewById;
            View findViewById2 = view.findViewById(A1.b.iv_stack_more_info);
            kotlin.jvm.internal.m.d(findViewById2, "rootView.findViewById(R.id.iv_stack_more_info)");
            this.f24587f = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(A1.b.tv_stack_selected_state);
            kotlin.jvm.internal.m.d(findViewById3, "rootView.findViewById(R.….tv_stack_selected_state)");
            this.f24588g = (TextView) findViewById3;
            View findViewById4 = view.findViewById(A1.b.tv_stack_name);
            kotlin.jvm.internal.m.d(findViewById4, "rootView.findViewById(R.id.tv_stack_name)");
            this.f24589h = (TextView) findViewById4;
            View findViewById5 = view.findViewById(A1.b.line_item);
            kotlin.jvm.internal.m.d(findViewById5, "rootView.findViewById(R.id.line_item)");
            this.f24590i = findViewById5;
        }

        public static final void b(b bVar, p pVar, View view) {
            kotlin.jvm.internal.m.e(bVar, "this$0");
            kotlin.jvm.internal.m.e(pVar, "$item");
            bVar.f24582a.e(pVar);
        }

        public final void a(p pVar) {
            kotlin.jvm.internal.m.e(pVar, "item");
            this.f24589h.setText(pVar.f24222b);
            this.f24588g.setText(pVar.f24223c);
            Integer num = this.f24583b;
            if (num != null) {
                int intValue = num.intValue();
                this.f24589h.setTextColor(intValue);
                this.f24588g.setTextColor(intValue);
                this.f24587f.setColorFilter(intValue);
            }
            Integer num2 = this.f24584c;
            if (num2 != null) {
                this.f24590i.setBackgroundColor(num2.intValue());
            }
            Typeface typeface = this.f24585d;
            if (typeface != null) {
                this.f24589h.setTypeface(typeface);
                this.f24588g.setTypeface(typeface);
            }
            this.f24586e.setOnClickListener(new n(this, pVar));
        }
    }

    public m(List list, a aVar, Integer num, Integer num2, Typeface typeface) {
        kotlin.jvm.internal.m.e(list, "items");
        kotlin.jvm.internal.m.e(aVar, "listener");
        this.f24577a = list;
        this.f24578b = aVar;
        this.f24579c = num;
        this.f24580d = num2;
        this.f24581e = typeface;
    }

    public int getItemCount() {
        return this.f24577a.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        b bVar = (b) viewHolder;
        kotlin.jvm.internal.m.e(bVar, "holder");
        bVar.a((p) this.f24577a.get(i4));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        kotlin.jvm.internal.m.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(c.list_item_stack, viewGroup, false);
        kotlin.jvm.internal.m.d(inflate, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        return new b(inflate, this.f24578b, this.f24579c, this.f24580d, this.f24581e);
    }
}
