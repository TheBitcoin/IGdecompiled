package d4;

import A1.b;
import A1.c;
import V3.o;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import java.util.List;
import kotlin.jvm.internal.m;

public final class l extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    public final List f24571a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f24572b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f24573c;

    /* renamed from: d  reason: collision with root package name */
    public final Typeface f24574d;

    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final Typeface f24575a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f24576b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view, Typeface typeface) {
            super(view);
            m.e(view, "rootView");
            this.f24575a = typeface;
            View findViewById = view.findViewById(b.tv_publisher_link_name);
            m.d(findViewById, "rootView.findViewById(R.id.tv_publisher_link_name)");
            this.f24576b = (TextView) findViewById;
        }

        public static final void a(Context context, o oVar, View view) {
            m.e(context, "$context");
            m.e(oVar, "$item");
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(oVar.f24220b));
            context.startActivity(intent);
        }

        public final void b(Context context, o oVar, Integer num) {
            m.e(context, "context");
            m.e(oVar, "item");
            SpannableString spannableString = new SpannableString(oVar.f24219a);
            spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
            TextView textView = this.f24576b;
            textView.setText(spannableString);
            if (num != null) {
                textView.setTextColor(num.intValue());
            }
            Typeface typeface = this.f24575a;
            if (typeface != null) {
                textView.setTypeface(typeface);
            }
            if (oVar.f24220b.length() > 0) {
                this.itemView.setOnClickListener(new k(context, oVar));
            }
        }
    }

    public l(List list, Context context, Integer num, Typeface typeface) {
        m.e(list, "items");
        m.e(context, "context");
        this.f24571a = list;
        this.f24572b = context;
        this.f24573c = num;
        this.f24574d = typeface;
    }

    public int getItemCount() {
        return this.f24571a.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        a aVar = (a) viewHolder;
        m.e(aVar, "holder");
        aVar.b(this.f24572b, (o) this.f24571a.get(i4), this.f24573c);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(c.list_publisher_link, viewGroup, false);
        m.d(inflate, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        return new a(inflate, this.f24574d);
    }
}
