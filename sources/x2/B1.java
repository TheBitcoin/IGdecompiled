package x2;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import kotlin.jvm.internal.m;

public final class B1 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22110a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public B1(View view) {
        super(view);
        m.e(view, "itemView");
        View findViewById = view.findViewById(R.id.rl_container_warning_not_storage_available);
        m.d(findViewById, "findViewById(...)");
        this.f22110a = (RelativeLayout) findViewById;
    }

    public final void a(boolean z4) {
        if (z4) {
            this.f22110a.setVisibility(0);
        } else {
            this.f22110a.setVisibility(8);
        }
    }
}
