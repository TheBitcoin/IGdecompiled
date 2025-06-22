package t2;

import N1.k;
import T1.a;
import W1.i;
import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import g2.C2060s;
import java.io.File;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.m;
import u2.t;

/* renamed from: t2.g  reason: case insensitive filesystem */
public final class C2299g extends Presenter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private TextView f21844a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f21845b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f21846c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressBar f21847d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2299g(View view) {
        super(view);
        m.e(view, "itemView");
        View findViewById = view.findViewById(R.id.tv_nombre_app);
        m.d(findViewById, "findViewById(...)");
        this.f21844a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_size_download);
        m.d(findViewById2, "findViewById(...)");
        this.f21845b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_date_download);
        m.d(findViewById3, "findViewById(...)");
        this.f21846c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.progressbar_downloading);
        m.d(findViewById4, "findViewById(...)");
        this.f21847d = (ProgressBar) findViewById4;
        TextView textView = this.f21844a;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.x());
        this.f21845b.setTypeface(aVar.x());
        this.f21846c.setTypeface(aVar.x());
    }

    public final void a(File file, Context context) {
        m.e(file, "item");
        if (context != null) {
            t a5 = t.f21927u.a(context);
            a5.a();
            String name = file.getName();
            m.d(name, "getName(...)");
            C2060s d02 = a5.d0(name);
            a5.i();
            this.f21844a.setText(file.getName());
            this.f21845b.setText(new i().d(file.length(), context));
            if (d02 == null || d02.k() != 0) {
                this.f21844a.setTypeface(k.f7778g.x());
            } else {
                this.f21844a.setTypeface(k.f7778g.x());
            }
            TextView textView = this.f21845b;
            k.a aVar = k.f7778g;
            textView.setTypeface(aVar.x());
            this.f21846c.setTypeface(aVar.x());
            if (d02 == null || d02.x() <= 0 || d02.x() >= 100) {
                a i4 = aVar.i();
                if (i4 == null || d02 == null || !m3.m.p(i4.b(), d02.w(), true) || d02.E() <= 0 || i4.e() != d02.E()) {
                    long lastModified = file.lastModified();
                    DateFormat dateTimeInstance = DateFormat.getDateTimeInstance();
                    this.f21846c.setVisibility(0);
                    this.f21846c.setText(dateTimeInstance.format(new Date(lastModified)));
                    this.f21845b.setText(new i().d(file.length(), context));
                    this.f21847d.setVisibility(4);
                    return;
                }
                this.f21847d.setIndeterminate(true);
                this.f21847d.setVisibility(0);
                this.f21846c.setText(R.string.installing);
                this.f21845b.setText("");
                return;
            }
            TextView textView2 = this.f21845b;
            F f4 = F.f20971a;
            Locale locale = Locale.getDefault();
            m.b(d02);
            String format = String.format(locale, "%d%%", Arrays.copyOf(new Object[]{Integer.valueOf(d02.x())}, 1));
            m.d(format, "format(...)");
            textView2.setText(format);
            this.f21846c.setVisibility(8);
            this.f21847d.setProgress(d02.x());
            this.f21847d.setVisibility(0);
        }
    }
}
