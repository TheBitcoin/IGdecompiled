package J1;

import android.view.View;
import com.uptodown.activities.UsernameEditActivity;
import kotlin.jvm.internal.A;
import kotlin.jvm.internal.C;

public final /* synthetic */ class X5 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UsernameEditActivity f6918a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ A f6919b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C f6920c;

    public /* synthetic */ X5(UsernameEditActivity usernameEditActivity, A a5, C c5) {
        this.f6918a = usernameEditActivity;
        this.f6919b = a5;
        this.f6920c = c5;
    }

    public final void onClick(View view) {
        UsernameEditActivity.x3(this.f6918a, this.f6919b, this.f6920c, view);
    }
}
