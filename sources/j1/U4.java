package J1;

import android.view.View;
import com.uptodown.activities.SecurityActivity;
import g2.C2048f;

public final /* synthetic */ class U4 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SecurityActivity f6888a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2048f f6889b;

    public /* synthetic */ U4(SecurityActivity securityActivity, C2048f fVar) {
        this.f6888a = securityActivity;
        this.f6889b = fVar;
    }

    public final void onClick(View view) {
        SecurityActivity.W4(this.f6888a, this.f6889b, view);
    }
}
