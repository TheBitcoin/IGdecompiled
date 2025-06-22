package x2;

import N1.k;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.uptodown.R;
import kotlin.jvm.internal.m;

/* renamed from: x2.z0  reason: case insensitive filesystem */
public final class C2407z0 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f22560a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2407z0(View view, String str) {
        super(view);
        m.e(view, "itemView");
        m.e(str, MimeTypes.BASE_TYPE_TEXT);
        View findViewById = view.findViewById(R.id.tv_system_apps_title);
        m.d(findViewById, "findViewById(...)");
        TextView textView = (TextView) findViewById;
        this.f22560a = textView;
        textView.setTypeface(k.f7778g.w());
        textView.setText(str);
    }

    public final void a() {
        this.f22560a.setVisibility(0);
    }
}
