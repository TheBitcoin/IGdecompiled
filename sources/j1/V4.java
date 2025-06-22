package J1;

import android.view.View;
import com.uptodown.activities.SecurityActivity;
import g2.C2048f;

public final /* synthetic */ class V4 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SecurityActivity f6898a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2048f f6899b;

    public /* synthetic */ V4(SecurityActivity securityActivity, C2048f fVar) {
        this.f6898a = securityActivity;
        this.f6899b = fVar;
    }

    public final void onClick(View view) {
        SecurityActivity.X4(this.f6898a, this.f6899b, view);
    }
}
