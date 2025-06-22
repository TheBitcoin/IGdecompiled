package x2;

import N1.k;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import f2.C2030v;
import g2.C2066y;
import kotlin.jvm.internal.m;

public final class L extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private C2030v f22206a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f22207b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f22208c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public L(View view, C2030v vVar) {
        super(view);
        m.e(view, "itemView");
        m.e(vVar, "listener");
        this.f22206a = vVar;
        View findViewById = view.findViewById(R.id.tv_language_name_original);
        m.d(findViewById, "findViewById(...)");
        this.f22207b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_language_name_localized);
        m.d(findViewById2, "findViewById(...)");
        this.f22208c = (TextView) findViewById2;
        TextView textView = this.f22207b;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.x());
        this.f22208c.setTypeface(aVar.x());
    }

    /* access modifiers changed from: private */
    public static final void c(L l4, C2066y yVar, View view) {
        l4.f22206a.a(yVar);
    }

    public final void b(C2066y yVar, String str) {
        m.e(yVar, "lang");
        m.e(str, "currentLanguageCode");
        this.f22207b.setText(yVar.c());
        this.f22208c.setText(yVar.b());
        this.itemView.setOnClickListener(new K(this, yVar));
        if (m3.m.p(yVar.a(), "ar", false)) {
            if (!m.a(str, "ar")) {
                SpannableString spannableString = new SpannableString(yVar.c());
                spannableString.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE), 0, spannableString.length(), 33);
                this.f22207b.setText(spannableString);
            }
        } else if (m.a(str, "ar")) {
            SpannableString spannableString2 = new SpannableString(yVar.c());
            spannableString2.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE), 0, spannableString2.length(), 33);
            this.f22207b.setText(spannableString2);
        }
    }
}
