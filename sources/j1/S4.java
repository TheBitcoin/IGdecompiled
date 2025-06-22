package J1;

import android.view.View;
import c2.C0;
import com.uptodown.activities.SecurityActivity;

public final /* synthetic */ class S4 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SecurityActivity f6872a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C0 f6873b;

    public /* synthetic */ S4(SecurityActivity securityActivity, C0 c02) {
        this.f6872a = securityActivity;
        this.f6873b = c02;
    }

    public final void onClick(View view) {
        SecurityActivity.f5(this.f6872a, this.f6873b, view);
    }
}
