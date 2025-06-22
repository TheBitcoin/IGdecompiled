package J1;

import android.view.View;
import com.uptodown.activities.SecurityActivity;
import g2.C2048f;

public final /* synthetic */ class W4 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SecurityActivity f6908a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2048f f6909b;

    public /* synthetic */ W4(SecurityActivity securityActivity, C2048f fVar) {
        this.f6908a = securityActivity;
        this.f6909b = fVar;
    }

    public final void onClick(View view) {
        SecurityActivity.Y4(this.f6908a, this.f6909b, view);
    }
}
