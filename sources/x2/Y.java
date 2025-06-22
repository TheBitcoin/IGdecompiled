package x2;

import N1.k;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import f2.C2031w;
import g2.C2034B;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.m;

public final class Y extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final C2031w f22287a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f22288b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f22289c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f22290d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f22291e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f22292f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f22293g;

    /* renamed from: h  reason: collision with root package name */
    private Context f22294h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Y(View view, C2031w wVar) {
        super(view);
        m.e(view, "itemView");
        this.f22287a = wVar;
        View findViewById = view.findViewById(R.id.tv_title);
        m.d(findViewById, "findViewById(...)");
        this.f22288b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_msg);
        m.d(findViewById2, "findViewById(...)");
        this.f22289c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_action_01);
        m.d(findViewById3, "findViewById(...)");
        this.f22290d = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_action_02);
        m.d(findViewById4, "findViewById(...)");
        this.f22291e = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.tv_date);
        m.d(findViewById5, "findViewById(...)");
        this.f22292f = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.iv_delete_notification);
        m.d(findViewById6, "findViewById(...)");
        this.f22293g = (ImageView) findViewById6;
        Context context = view.getContext();
        m.d(context, "getContext(...)");
        this.f22294h = context;
        this.f22290d.setOnClickListener(new V(this));
        this.f22291e.setOnClickListener(new W(this));
        this.f22293g.setOnClickListener(new X(this));
        TextView textView = this.f22288b;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.x());
        this.f22289c.setTypeface(aVar.x());
        this.f22292f.setTypeface(aVar.x());
        this.f22290d.setTypeface(aVar.w());
        this.f22291e.setTypeface(aVar.w());
    }

    /* access modifiers changed from: private */
    public static final void d(Y y4, View view) {
        int bindingAdapterPosition;
        if (y4.f22287a != null && (bindingAdapterPosition = y4.getBindingAdapterPosition()) != -1) {
            y4.f22287a.c(bindingAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final void e(Y y4, View view) {
        int bindingAdapterPosition;
        if (y4.f22287a != null && (bindingAdapterPosition = y4.getBindingAdapterPosition()) != -1) {
            y4.f22287a.a(bindingAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final void f(Y y4, View view) {
        int bindingAdapterPosition;
        if (y4.f22287a != null && (bindingAdapterPosition = y4.getBindingAdapterPosition()) != -1) {
            y4.f22287a.b(bindingAdapterPosition);
        }
    }

    private final String g(String str) {
        switch (str.hashCode()) {
            case -1569440520:
                if (!str.equals("positive_apps")) {
                    return "";
                }
                String string = this.f22294h.getString(R.string.title_positive_apps);
                m.d(string, "getString(...)");
                return string;
            case -1335458389:
                if (!str.equals("delete")) {
                    return "";
                }
                String string2 = this.f22294h.getString(R.string.option_button_delete);
                m.d(string2, "getString(...)");
                return string2;
            case -504325460:
                if (!str.equals("open_app")) {
                    return "";
                }
                String string3 = this.f22294h.getString(R.string.open);
                m.d(string3, "getString(...)");
                return string3;
            case -234430262:
                if (!str.equals("updates")) {
                    return "";
                }
                String string4 = this.f22294h.getString(R.string.updates);
                m.d(string4, "getString(...)");
                return string4;
            case 212443764:
                str.equals("no_action");
                return "";
            case 1085191854:
                if (!str.equals("update_uptodown")) {
                    return "";
                }
                String string5 = this.f22294h.getString(R.string.action_update);
                m.d(string5, "getString(...)");
                return string5;
            case 1117687366:
                if (!str.equals("preregister")) {
                    return "";
                }
                String string6 = this.f22294h.getString(R.string.action_app_details_settings);
                m.d(string6, "getString(...)");
                return string6;
            case 1312704747:
                if (!str.equals("downloads")) {
                    return "";
                }
                String string7 = this.f22294h.getString(R.string.downloads_title);
                m.d(string7, "getString(...)");
                return string7;
            case 1957569947:
                if (!str.equals("install")) {
                    return "";
                }
                String string8 = this.f22294h.getString(R.string.option_button_install);
                m.d(string8, "getString(...)");
                return string8;
            default:
                return "";
        }
    }

    public final void h(C2034B b5) {
        m.e(b5, "notificationRegistry");
        this.f22288b.setText(b5.f());
        this.f22289c.setText(b5.d());
        String e5 = b5.e();
        m.b(e5);
        Date date = new Date(Long.parseLong(e5));
        this.f22292f.setText(DateFormat.getDateTimeInstance().format(Long.valueOf(date.getTime())));
        String a5 = b5.a();
        this.f22290d.setVisibility(8);
        this.f22291e.setVisibility(8);
        if (a5 != null && !m3.m.D(a5, "no_action", false, 2, (Object) null)) {
            List j02 = m3.m.j0(a5, new String[]{";"}, false, 0, 6, (Object) null);
            int size = j02.size();
            if (size == 1) {
                this.f22290d.setText(g((String) j02.get(0)));
                this.f22290d.setVisibility(0);
            } else if (size == 2) {
                this.f22290d.setText(g((String) j02.get(0)));
                this.f22291e.setText(g((String) j02.get(1)));
                this.f22290d.setVisibility(0);
                this.f22291e.setVisibility(0);
            }
        }
    }
}
