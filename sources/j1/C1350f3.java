package J1;

import android.view.ViewTreeObserver;
import c2.X;
import com.uptodown.activities.OrganizationActivity;

/* renamed from: J1.f3  reason: case insensitive filesystem */
public final /* synthetic */ class C1350f3 implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OrganizationActivity f7007a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ X f7008b;

    public /* synthetic */ C1350f3(OrganizationActivity organizationActivity, X x4) {
        this.f7007a = organizationActivity;
        this.f7008b = x4;
    }

    public final void onScrollChanged() {
        OrganizationActivity.z3(this.f7007a, this.f7008b);
    }
}
