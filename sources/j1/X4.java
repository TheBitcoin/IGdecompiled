package J1;

import android.view.View;
import com.uptodown.activities.SecurityActivity;
import g2.C2048f;

public final /* synthetic */ class X4 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2048f f6916a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SecurityActivity f6917b;

    public /* synthetic */ X4(C2048f fVar, SecurityActivity securityActivity) {
        this.f6916a = fVar;
        this.f6917b = securityActivity;
    }

    public final void onClick(View view) {
        SecurityActivity.Z4(this.f6916a, this.f6917b, view);
    }
}
